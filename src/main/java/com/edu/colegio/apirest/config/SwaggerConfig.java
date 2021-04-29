/**
 * 
 */
package com.edu.colegio.apirest.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author JUAN DAVID GARCIA
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private ApiInfo getApiInfo() {
        return new ApiInfo(
                "API para colegio",
                "Colegio API Description",
                "1.0.0",
                "",
                new Contact("", "", ""),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.edu.colegio.apirest.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
