# =========================
# Stage 1: Build
# =========================
FROM eclipse-temurin:17-jdk-alpine AS build

WORKDIR /app

# Copiamos solo lo necesario para cachear dependencias
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./

RUN chmod +x gradlew && ./gradlew dependencies --no-daemon

# Copiamos el código fuente
COPY src src

# Construimos el jar
RUN ./gradlew clean bootJar --no-daemon -x test

# =========================
# Stage 2: Runtime
# =========================
FROM eclipse-temurin:17-jre-alpine

# Crear usuario no-root
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

WORKDIR /app

# Copiamos el jar generado
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

# JVM optimizada para contenedores
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-jar", "app.jar"]
