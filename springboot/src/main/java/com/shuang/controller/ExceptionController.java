package com.shuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 111
 */
@Controller
public class ExceptionController {

    @RequestMapping("/defaultException")
    public String defaultException(){
        String aaa = null;
        aaa.length();
        return "index";
    }

    /**
     * 该方法需要返回一个ModelAndView，目的是可以封装异常信息以及师徒的指定
     * @param exception e 会将产生异常对象注入到方法中
     * @return
     */
    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView handlException(Exception exception){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error",exception.toString());
        modelAndView.setViewName("error1");
        return modelAndView;
    }
}
