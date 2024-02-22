package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestContronller {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/hello")
    public String testHellor(){
        return "hello";
    }

    @RequestMapping("/error")
    public String testError(){
        System.out.println(1/0);
        return "error";
    }
}
