package ru.gpbi.requestprocessing.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(info = @Info(title = "Request Processing System API", version = "v3",
				contact = @Contact(name = "(send offer)", email = "79066966780@yandex.ru")))
public class SpringDocConfig {
}