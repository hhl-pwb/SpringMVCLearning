package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/")
    public String index(){
        //返回的字符串，为视图名称
        return "index";
    }

    /**
     * springMVC参数接收案例
     * @return
     */
    @RequestMapping("/param")
    public String param(){
        return "test_param";
    }
}
