package com.ironyard.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Tom on 11/14/16.
 */
@Configuration
public class FilterRegistrations {

    @Bean
    public FilterRegistrationBean restApiFilter() {
        /**
         * Apply RestSecurityFilter filter to any request that matches /rest/*
         */
        FilterRegistrationBean registration = new FilterRegistrationBean(new RestSecurity());
        registration.addUrlPatterns("/rest/*");
        return registration;
    }
}
