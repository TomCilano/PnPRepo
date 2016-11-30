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
    public Docket aUserApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("aUser-api")
                .apiInfo(apiInfoAUser())
                .select()
                .paths(regex("/rest/aUser.*"))
                .build().globalOperationParameters(
                        newArrayList(new ParameterBuilder()
                                .name("x-authorization-key")
                                .description("API Authorization Token")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(true)
                                .build()));
    }

    @Bean
    public ApiInfo apiInfoAUser() {
        return new ApiInfoBuilder()
                .title("AUserObj API")
                .description("<div> This is the UserObj API. Here you may perform CRUD operation on User Objects" +
                        "<div> The User Object is a complex data model that has numerous attributes.<div> To see the UserObj Model in a table click" +
                        " <a href=\"user.jsp\">HERE</a>\n<div> On that page there is also a link to the raw Json model. Though it can be " +
                        "found below in controllers as well." +
                        "<div> Some points about this controller" +
                        "<div> If you are going to update  ")
                .termsOfServiceUrl("n/a")
                .contact("Tom Cilano")
                .license("Apache License Version 2.0")
                .licenseUrl("")
                .version(".1")
                .build();
    }

    @Bean
    public Docket messageApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("message api")
                .apiInfo(apiInfoMessage())
                .select()
                .paths(regex("/rest/message.*"))
                .build().globalOperationParameters(
                        newArrayList(new ParameterBuilder()
                                .name("x-authorization-key")
                                .description("API Authorization Token")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(true)
                                .build()));

    }

    @Bean
    public ApiInfo apiInfoMessage() {
        return new ApiInfoBuilder()
                .title("Message API")
                .description("")
                .termsOfServiceUrl("n/a")
                .contact("Tom Cilano")
                .license("Apache License Version 2.0")
                .version(".01" +
                    "}")
                .termsOfServiceUrl("http://localhost:8080/user.jsp")
                .build();


    }
    @Bean
    public Docket storyApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("story api")
                .apiInfo(apiInfoStory())
                .select()
                .paths(regex("/rest/story.*"))
                .build().globalOperationParameters(
                        newArrayList(new ParameterBuilder()
                                .name("x-authorization-key")
                                .description("API Authorization Token")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(true)
                                .build()));

    }
    @Bean
    public ApiInfo apiInfoStory(){
        return new ApiInfoBuilder()
                .title("StoryObj API")
                .description("This is where you can perform CRUD operations on 'StoryObj' by id ------->Here is a testing token:  hGsZ9J4kvxbBNRqGSEM7JtfDlSU/qh8Z")
                .contact("TomCilano")
                .license("")
                .build();

    }
}

