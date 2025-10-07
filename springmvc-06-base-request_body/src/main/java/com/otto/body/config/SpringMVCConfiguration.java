package com.otto.body.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/*
    @EnableWebMvc
        1. 首先将 HandlerMapping 添加到IOC容器中
            不必在手动的将 HandlerMapping 注入容器
        2. 再将 HandlerAdapter 添加到IOC容器中
            不必在手动的将 HandlerAdapter 注入容器
        3. 给 HandlerAdapter 配置了 json 解析器
            addRequestBodyAdvice(handlerAdapterDef);
		    addResponseBodyAdvice(handlerAdapterDef);
 */
@Configuration
@ComponentScan(basePackages = "com.otto.body.controller")
@EnableWebMvc // 给HandlerAdapter配置了json转换器
public class SpringMVCConfiguration {

    // @Bean
    // public HandlerMapping handlerMapping() {
    //     HandlerMapping handlerMapping = new RequestMappingHandlerMapping();
    //     return handlerMapping;
    // }
    //
    // @Bean
    // public HandlerAdapter handlerAdapter() {
    //     HandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
    //     return handlerAdapter;
    // }
}
