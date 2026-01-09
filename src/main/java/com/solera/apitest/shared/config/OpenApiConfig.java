package com.solera.apitest.shared.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Test API",
                version = "1.0.0",
                contact = @Contact(
                        name = "Solera Holdings",
                        email = "pablo.avila@solera.com",
                        url = "https://pabloavila.dev"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        servers = @Server(
                url = "http://localhost:8080",
                description = "Development"
        )
)

@Configuration
public class OpenApiConfig {
}
