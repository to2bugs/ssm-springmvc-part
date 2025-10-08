package com.otto.exp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
    全局异常处理器
        异常发生时，会走GlobalExceptionHandler类下定义的方法处理异常
        @ControllerAdvice 可以返回视图、转发和重定向
        @RestControllerAdvice = @ControllerAdvice + @RequestBody 直接返回Json字符串

    异常发生时的处理流程：
        1. 发生异常时，就会进到 @ControllerAdvice 注解注释的类中
        2. 具体在 @ControllerAdvice 注解注释的类中执行哪个方法
            根据handler方法上 @ExceptionHandler 指定的异常，去执行具体的handler方法

    🆘 要确保当前类能够被扫描到
        即在配置类SpringMVCConfiguration中能扫描到包 com.otto.exp.exception
 */
// @ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    /*
        定义具体处理 ArithmeticException 的异常
        使用注解 @ExceptionHandler(value = ArithmeticException.class)
            表示专门处理 ArithmeticException 异常
        ArithmeticExceptionHandler() 的参数 Exception 可以接收到 ArithmeticException 异常的信息
     */
    @ExceptionHandler(value = ArithmeticException.class)
    public Object ArithmeticExceptionHandler(Exception ex) {
        // 自定义处理异常即可
        return ex.getMessage();
    }



    /*
        处理所有的异常
            如果没有找到处理具体的异常，则会调用这个方法
     */
    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(Exception ex) {
        // 自定义处理异常即可
        return ex.getMessage();
    }
}
