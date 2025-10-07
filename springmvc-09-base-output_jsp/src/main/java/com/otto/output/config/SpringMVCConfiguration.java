package com.otto.output.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/*
    为了避免SpringMVC的每一个组件都使用@Bean，Spring MVC特意提供了一个接口 WebMvcConfigurer
    这个接口中提供了许多方法来配置SpringMVC的组件，想要配置哪个组件就重写对应的方法即可
    比如：需要配置视图解析器，只要重写 void configureViewResolvers(ViewResolverRegistry registry) 即可
 */
@Configuration
@ComponentScan(basePackages = "com.otto.output")
@EnableWebMvc
public class SpringMVCConfiguration implements WebMvcConfigurer {

    /*
        视图解析器
            配置前缀和后缀
     */

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // 通过在registry中添加前缀和后缀，来快速的配置视图解析器
        // 视图解析器的生成创建和放入IOC容器，都由类ViewResolverRegistry的内部完成了
        // 以下是配置解析jsp页面的前缀和后缀
        registry.jsp("/WEB-INF/views/", ".jsp");
    }
}
