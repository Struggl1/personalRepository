package com.shuang.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 使用HandlerExceptionResolver进行异常处理
 */
@Configuration
public class HandlerException implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if(e instanceof NullPointerException){
            modelAndView.setViewName("error1");
        }
        if(e instanceof ArithmeticException){
            modelAndView.setViewName("error1");
        }
        modelAndView.addObject("error",e.toString());
        return modelAndView;
    }
}
