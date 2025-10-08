package com.otto.interceptor.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/*
    自定义拦截器，需要实现 HandlerInterceptor
    还要注册到配置类中，即SpringMVCConfiguration

    多个拦截器
        1. 按照配置类 SpringMVCConfiguration 中 addInterceptors()方法，加入的顺序依次执行
        2. 按照洋葱模型依次执行各自的拦截器方法

           测试多个拦截器的执行顺序
        1. 没有出现异常时的执行顺序
            OneInterceptor preHandle
            TwoInterceptor preHandle
            ThreeInterceptor preHandle
            OrderController order1
            ThreeInterceptor postHandle
            TwoInterceptor postHandle
            OneInterceptor postHandle
            ThreeInterceptor afterCompletion
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
public class MyInterceptor implements HandlerInterceptor {

    /*
        在执行controller handler 之前执行的拦截方法
        作用：
            1. 编码格式设置
            2. 登陆保护
            3. 权限处理
        参数：
            1. request 请求对象
            2. response 响应对象
            3. handler controller的handler
        返回值
            true 放行
            false 拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor preHandle");
        return true;
    }


    /*
        在执行controller handler 之后执行的拦截方法
        作用：
            1. 对结果进行处理，检查敏感词汇
        参数：
            1. request 请求对象
            2. response 响应对象
            3. handler controller的handler
            4. modelAndView 返回的视图和共享域数据

     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor postHandle");
    }


    /*
        整体处理完毕 之后执行的拦截方法
        作用：
            1. 对结果进行处理，检查敏感词汇
        参数：
            1. request 请求对象
            2. response 响应对象
            3. handler controller的handler
            4. ex controller handler 报错后的异常对象

     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor afterCompletion");
    }
}
