package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index() {
        // "/" -->/WEB-INF/templates/index.html
        //视图前属性 /WEB-INF/templates/
        //视图后属性 .html
        //视图前属性和视图后属性中间的就是视图名称
        //视图前缀+视图+视图后缀就可以被视图解析器解析
        //返回视图名称
        return "index";
    }
}
