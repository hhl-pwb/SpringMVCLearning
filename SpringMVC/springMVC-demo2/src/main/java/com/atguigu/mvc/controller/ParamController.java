package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class ParamController {

    // 形参位置的request表示当前请求
    @RequestMapping("/testServeletAPI")
    public String testServeletAPI(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "success";
    }

    @RequestMapping("/testParam")
    public String testParam(@RequestParam(value = "username", required = false
            , defaultValue = "hehe") String username,
                            String password,
                            String[] hobby,
                            @RequestHeader(value = "Host") String host,
                            @CookieValue("JSESSIONID") String JSESSIONID) {
        //若请求参数中出现多个同名的请求参数，可以在控制器方法的形参位置设置字符串或字符串数组接收此参数。
        //若使用字符串类型的形参，最终结果为请求参数的每一个值，之间使用逗号进行拼接。
        System.out.println("username = " + username + ", password = " + password
                + ", hobby = " + Arrays.toString(hobby));
        System.out.println("Host = "+host);
        System.out.println("JSESSIONID = "+JSESSIONID);
        return "success";
    }
    @RequestMapping("/testBean")
    public String testBean(User user){
        System.out.println(user);
        return "success";
    }
}
