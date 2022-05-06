package com.study.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author RenAshbell
 * @create 2022-05-06-16:02
 */
@Controller
public class ScopeController {

    // 使用servlet向request域对象共享数据
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request){
        request.setAttribute("testRequestScope","hello,servletAPI");
        return "success";
    }

}
