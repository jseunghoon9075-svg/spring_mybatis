package com.app.mybatis.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@Slf4j
@RequestMapping("/test/*")
public class TestController {

    @GetMapping("ex")
    public String ex() {
        log.info("요청임~");
        return "first";
    }

    @GetMapping("/ex01")
    public void ex01(HttpServletResponse response) throws IOException {
        response.getWriter().write("Hello World");
    }
}
