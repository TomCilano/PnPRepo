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
                .paths(regex("/rest/user.*"))
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
                .description("")


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
                                .description("API Authorization Key")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(true)
                                .build()));

    }

    @Bean
    public ApiInfo apiInfoMessage() {
        return new ApiInfoBuilder()
                .title("Message API")
                .description("This is where you can perform CRUD operations on  'messages' by Id. In generating a message it use the" +
                        " local server Date and time. When you update a message " +
                        "it's date will include the date modified be label as Edited." +
                        "<br> The Json model is simple \n {\n" +
                        "  \"date\": \"string\",\n" +
                        "  \"id\": 0,\n" +
                        "  \"story\": \"string\"\n" +
                        "}"+"     It is Important for the user to follow certain standards when using this API." +
                        "1: When ")
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
                                .description("API Authorization Key")
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

