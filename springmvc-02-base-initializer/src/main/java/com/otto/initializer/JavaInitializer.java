package com.otto.initializer;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;

/*
    每当web项目启动，就会自动的调用 WebApplicationInitializer 接口的 onStartup 方法
 */
public class JavaInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("每当web项目启动，就会自动的调用 WebApplicationInitializer 接口的 onStartup 方法");
    }
}
