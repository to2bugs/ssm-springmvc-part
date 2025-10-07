package com.otto.quick.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * 1. 将自定义的 controller 配置到ioc容器
 *      @ComponentScan(basePackages = "com.otto.quick.controller")
 * 2. 将 HandrleMapping 和 HandlerAdapter 配置到IOC容器
 *      @Bean
 */
@Configuration
@ComponentScan(basePackages = "com.otto.quick.controller")
public class MVCConfiguration {

    @Bean
    HandlerMapping handlerMapping() {
        HandlerMapping handlerMapping = new RequestMappingHandlerMapping();
        return handlerMapping;
    }

    @Bean
    HandlerAdapter handlerAdapter() {
        HandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
        return handlerAdapter;
    }
}
