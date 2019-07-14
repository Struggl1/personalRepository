package com.shuang.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView handleException(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error",e);
        modelAndView.setViewName("error1");
        return modelAndView;
    }
}
