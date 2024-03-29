package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/hello")
public class RequestMappingController {

    // 此时请求映射的请求路径为：/hello/testRequestMapping
    @RequestMapping(value = {"/testRequestMapping", "/test"}
            , method = {RequestMethod.GET, RequestMethod.POST})
    public String success() {
        return "success";
    }

    @GetMapping("/testGetMapping")
    public String testGetMapping() {
        return "success";
    }

    @RequestMapping(value = "testPut", method = RequestMethod.PUT)
    public String testPut() {
        return "success";
    }

    @RequestMapping(
            value = "/testParamsAndHeaders",
            params = {"username"},
            headers = {"Host=localHost:8081"})
    public String testParamsAndHeaders() {
        return "success";
    }

    //    @RequestMapping("/a?a/testAnt")
//    @RequestMapping("/a*a/testAnt")
    @RequestMapping("/**/testAnt")
    public String restAnt() {
        return "success";
    }

    @RequestMapping("/testPath/{id}")
    public String testPath(@PathVariable("id") Integer id){
        System.out.println("id = "+id);
        return "success";
    }
}
