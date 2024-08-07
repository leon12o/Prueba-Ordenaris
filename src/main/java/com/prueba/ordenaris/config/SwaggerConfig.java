package com.prueba.ordenaris.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(title = "API Gestion de empleados", description = "La app provee los endpoints para el sistema de gestion para empleados", termsOfService = "www.unprogramadornace.com/terminos_y_condiciones", version = "1.0.0", contact = @Contact(name = "Omar", url = "contact", email = "leon@leon.com")), servers = {
        @Server(description = "DEV SERVER", url = "http://localhost:8080/") })

public class SwaggerConfig {

}
