package com.itheima;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {
    @RequestMapping("/response")
    public void response(HttpServletResponse  response) throws IOException {
        //1. 设置状态码（一般不用手动设置）
        response.setStatus(HttpServletResponse.SC_OK);
        //2. 设置响应头
        response.setHeader("Name","LeeSten");
        //3. 设置响应体
        response.getWriter().write("<h1>hello response</h1>");
    }

    @RequestMapping("/response2")
    public ResponseEntity<String> response2() {//泛型里表示响应体的数据类型//泛型里表示响应体的数据类型
        return ResponseEntity
                .status(401) //响应状态码
                .header("Name","LeeSten2")//响应头
                .body("<h1>hello response2</h1>");//响应体
    }
}
