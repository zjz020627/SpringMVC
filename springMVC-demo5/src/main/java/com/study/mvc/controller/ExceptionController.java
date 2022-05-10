package com.study.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author RenAshbell
 * @create 2022-05-10-17:03
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})
    public String testException(Exception ex, Model model){
        model.addAttribute("ex",ex);
        return "error";
    }
}
