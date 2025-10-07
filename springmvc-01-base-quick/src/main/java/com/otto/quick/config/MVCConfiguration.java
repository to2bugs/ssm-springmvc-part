package com.otto.quick.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * DispatcherServlet 是 Spring MVC 携带的，用来处理全部的请求
 *
 * Spring MVC 的配置类
 * 1. 将自定义的 controller 配置到ioc容器
 *      使用 @ComponentScan(basePackages = "com.otto.quick.controller")
 * 2. 将 HandlerMapping 和 HandlerAdapter 配置到IOC容器
 *      使用 @Bean RequestMappingHandlerMapping RequestMappingHandlerAdapter
 */
@Configuration
@ComponentScan(basePackages = "com.otto.quick.controller")
public class MVCConfiguration {

    /*
        DispatcherServlet 处理外部的所有请求，请求来后会先调用HandlerMapping，会获得 controller 中的 handler
        HandlerMapping保存 请求路径 和 controller 中 handler方法
     */
    @Bean
    HandlerMapping handlerMapping() {
        HandlerMapping handlerMapping = new RequestMappingHandlerMapping();
        return handlerMapping;
    }

    /*
        DispatcherServlet 再调用 HandlerAdapter，DispatcherServlet 只会将参数封装到 request 中
        HandlerAdapter 简化参数的处理：将 request 中原始的参数转化成 controller 中 handler 方法需要的参数
        HandlerAdapter 简化数据响应：将 controller 中 handler 方法返回的数据封装到 response 中
     */
    @Bean
    HandlerAdapter handlerAdapter() {
        HandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
        return handlerAdapter;
    }
}
