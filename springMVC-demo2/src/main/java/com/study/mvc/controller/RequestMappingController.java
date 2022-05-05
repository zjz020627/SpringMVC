package com.study.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/testGetMapping")
    public String testGetMapping(){
        return "success";
    }

    @RequestMapping(value = "/testPut",method = RequestMethod.PUT)
    public String testPut(){
        return "success";
    }

    @RequestMapping(
            value = "/testParamsAndHeaders",
            params = {"username","password!=123456"},
            headers = {"Host=localhost:8080"}
    )
    public String testParamsAndHeaders(){
        return "success";
    }


//    @RequestMapping("/a?a/testAnt")// ?表示任意的单个字符, 这个字符必须存在且只能有一个
//    @RequestMapping("/a*a/testAnt")// *表示任意的0个或多个字符
    @RequestMapping("/**/testAnt")// **表示任意的一层或多层目录, 写法只能/**/
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/testPath/{id}/{username}")// {id}为占位符id
    public String testPath(@PathVariable("id")Integer id,@PathVariable("username")String username){
        System.out.println("id:" + id + ",username:" + username);
        return "success";
    }
}
