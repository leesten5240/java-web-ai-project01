package com.itheima;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @RequestMapping("/request")
    public String request(HttpServletRequest  request) {
        //1. 获取请求方式
        String method = request.getMethod();
        System.out.println(method);

        //2.获取请求地址
        String requestURL = request.getRequestURL().toString();// http://localhost:8080/request
        System.out.println(requestURL);

        String requestURI = request.getRequestURI();// /request
        System.out.println(requestURI);

        //3. 获取请求协议
        String protocol = request.getProtocol();
        System.out.println(protocol);

        //4. 获取请求参数 - name
        String name = request.getParameter("name");
        System.out.println(name);

        //5. 获取请求头 - Accept
        String accept = request.getHeader("Accept");
        System.out.println(accept);

        return "OK";
    }
}
