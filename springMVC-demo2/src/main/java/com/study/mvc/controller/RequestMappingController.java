package com.study.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author RenAshbell
 * @create 2022-05-04-16:26
 */
@Controller
//@RequestMapping("/hello")
public class RequestMappingController {
    @RequestMapping(
            value = {"/testRequestMapping","test"},
            method = {RequestMethod.POST,RequestMethod.GET}
    )
    public String success(){
        return "success";
    }
}
