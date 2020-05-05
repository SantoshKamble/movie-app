/**
 * 
 */
package com.santosh.moviesapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author santkamb
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.santosh.moviesapp.resources"))
                .paths(regex("/api/movies-app/v1/movie.*"))
                .build()
                .apiInfo(metaData());
    }
	
	private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Movie Recommendation App")
                .description("\"Spring Boot REST API for Movie Recommendation - KPN \"")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("Santosh Kamble ", "https://santoshKamble.com/about/", "santosh.kamble@Capgemini.com"))
                .build();
    }

}
