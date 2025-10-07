package com.otto.statics.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.otto.statics.controller")
@EnableWebMvc
public class SpringMVCConfiguration implements WebMvcConfigurer {

    // todo: 配置视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }



    // todo: 配置允许DispatcherServlet查找静态资源文件
    // todo: DispatcherServlet先让HandlerMapping去找有没有对应的controller handler
    //       如果没有controller handler，则去找静态资源
    //       通过 http://localhost:8080/imgs/01.png 查看到静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
