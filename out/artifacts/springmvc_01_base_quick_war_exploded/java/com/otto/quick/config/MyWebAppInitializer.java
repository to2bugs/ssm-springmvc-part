package com.otto.quick.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// 会加载项目的配置类，会创建并初始化IOC容器，会设置DispatcherServlet的请求路径
// 替代 web.xml
//TODO: SpringMVC提供的接口,是替代web.xml的方案,更方便实现完全注解方式ssm处理!
//TODO: Springmvc框架会自动检查当前类的实现类,会自动加载 getRootConfigClasses / getServletConfigClasses 提供的配置类
//TODO: getServletMappings 返回的地址 设置DispatherServlet对应处理的地址
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 指定service / mapper层的配置类
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    /**
     * 设置项目的配置类
     * 指定springmvc的配置类，这里是config.MVCConfiguration
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { MVCConfiguration.class };
    }

    /**
     * 设置dispatcherServlet的访问地址!
     * 一般情况下为 / 代表处理所有请求!
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
