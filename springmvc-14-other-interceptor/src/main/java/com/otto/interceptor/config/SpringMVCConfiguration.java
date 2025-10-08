package com.otto.interceptor.config;

import com.otto.interceptor.interceptor.MyInterceptor;
import com.otto.interceptor.interceptor.OneInterceptor;
import com.otto.interceptor.interceptor.ThreeInterceptor;
import com.otto.interceptor.interceptor.TwoInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@ComponentScan(basePackages = { "com.otto.interceptor.controller", "com.otto.interceptor.exception" })
@EnableWebMvc
public class SpringMVCConfiguration implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /*
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // todo: 注册拦截器
        // todo: 配置方案一 拦截所有的请求
        // registry.addInterceptor(new MyInterceptor());
        // todo: 配置方案二 拦截指定地址
        //       * 任意一层字符串
        //      ** 任意多层字符串
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/inter/**"); // 只拦截 /inter 开头的所有请求
        // todo: 配置方案三 排除拦截指定的地址
        //       排除地址应该在拦截地址的内部哦
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/inter/**") // 只拦截 /inter 开头的所有请求
                .excludePathPatterns("/inter/data1"); // 但排除 /inter/data1 的请求
    }
     */


    /*
        测试多个拦截器的执行顺序
        1. 没有出现异常时的执行顺序
            OneInterceptor preHandle
            TwoInterceptor preHandle
            OrderController order1
            TwoInterceptor postHandle
            OneInterceptor postHandle
            TwoInterceptor afterCompletion
            OneInterceptor afterCompletion

        2. 出现异常时的执行顺序
            OneInterceptor preHandle
            TwoInterceptor preHandle
            ThreeInterceptor preHandle
            OrderController order1 出现异常
            ThreeInterceptor afterCompletion
            TwoInterceptor afterCompletion
            OneInterceptor afterCompletion
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // one 先于 two 加入拦截器池
        registry.addInterceptor(new OneInterceptor());

        // two 先于 three 加入拦截器池
        registry.addInterceptor(new TwoInterceptor());

        // three
        registry.addInterceptor(new ThreeInterceptor());
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/jsp/", ".jsp");
    }
}
