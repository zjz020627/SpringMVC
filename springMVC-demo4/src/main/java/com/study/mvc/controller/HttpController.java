package com.study.mvc.controller;

import com.study.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author RenAshbell
 * @create 2022-05-09-20:56
 */
@Controller
public class HttpController {

    @RequestMapping("/testRequestBody")
    public String testRequestBody(
            @RequestBody String requestBody,
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password){
        // 获取整个请求体
        System.out.println("requestBody:"+requestBody);
        // 获取单个请求参数
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        return "success";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(
            RequestEntity<String> requestEntity,
            @RequestHeader(value = "Host") String host){
        // 当前requestEntity表示所有请求报文的信息
        System.out.println("请求头:"+requestEntity.getHeaders());
        // 当前host表示请求头中的host信息
        System.out.println("请求头中的host:" + host);
        System.out.println("请求体:"+requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().println("hello,response");
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }

    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        return new User(1001,"admin","123456",16,"男");
    }

    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username,String password){
        System.out.println(username+","+password);
        return "hello,axios";
    }
}
