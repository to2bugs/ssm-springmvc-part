package com.otto.req.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.otto.req.controller")
@EnableWebMvc
public class SpringMVCConfiguration {
}
