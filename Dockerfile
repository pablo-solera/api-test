# Etapa de build
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Copiar Gradle wrapper y dependencias
COPY gradlew settings.gradle build.gradle ./
COPY gradle ./gradle
RUN ./gradlew build -x test --no-daemon || true

# Copiar código fuente
COPY src ./src

# Generar jar
RUN ./gradlew bootJar -x test --no-daemon

# Etapa runtime ligera
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
