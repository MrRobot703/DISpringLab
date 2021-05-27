package com.demoshop.demoshop.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.expression.Lists;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apiApplication() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(buildApiInfo("Demo Shop"));
    }

    private ApiInfo buildApiInfo(String title) {
        return new ApiInfoBuilder()
                .title(title)
                .description("Учебное приложение, разработанное в рамках практикума")
                .version("1.0.0")
                .contact(new Contact("SimbirSoft", "http://simbirsoft.com", "info@simbirsoft.com"))
                .license("All rights reserved Copyright © 2021")
                .build();
    }
}
