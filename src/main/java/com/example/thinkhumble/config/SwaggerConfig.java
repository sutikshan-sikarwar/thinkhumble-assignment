package com.example.thinkhumble.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI stockOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Stock Quote API")
                .description("API for real-time stock quotes")
                .version("v1.0"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("stock-quotes")
                .pathsToMatch("/api/**")
                .build();
    }
}