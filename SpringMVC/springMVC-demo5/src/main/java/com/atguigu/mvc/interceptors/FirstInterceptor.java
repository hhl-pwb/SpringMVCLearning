package com.atguigu.mvc.interceptors;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 在springMVC.xml中使用<ref bean></ref>的方式引入拦截器的时候，序言将拦截器设置为IOC容器的普通组件
 * 使用@Component标注,
 * 使用@Component标注后的组件名默认为类名首字母小写，即firstInterceptor
 */
@Component
public class FirstInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("FirstInterceptor-->preHandle");
//        return HandlerInterceptor.super.preHandle(request, response, handler);
        // 返回false表示拦截，返回true表示放行
//        return false;
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler
            , ModelAndView modelAndView) throws Exception {
        System.out.println("FirstInterceptor-->postHandle");
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler
            , Exception ex) throws Exception {
        System.out.println("FirstInterceptor-->afterCompletion");
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
