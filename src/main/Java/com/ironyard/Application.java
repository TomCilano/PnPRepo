package com.ironyard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;


/**
 * Created by Tom on 11/8/16.
 */
@EnableSwagger2
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);

    }


    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("user-api")
                .apiInfo(apiInfoUser())
                .select()
                .paths(regex("/rest.*"))
                .build().globalOperationParameters(
                        newArrayList(new ParameterBuilder()
                                .name("x-authorization-key")
                                .description("API Authorization Key")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(true)
                                .build()));
    }

    @Bean
    public ApiInfo apiInfoUser() {
        return new ApiInfoBuilder()
                .title("UserObj API")
                .description("This is where you can access the user data model and perform CRUD operations on them."+"\n"+
                        "test token = hGsZ9J4kvxbBNRqGSEM7JtfDlSU/qh8Z")
                .termsOfServiceUrl("n/a")
                .contact("Tom Cilano")
                .license("Apache License Version 2.0")
                .licenseUrl("")
                .version(".1")
                .build();
    }
}