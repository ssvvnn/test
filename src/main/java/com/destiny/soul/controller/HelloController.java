package com.destiny.soul.controller;


import com.github.destiny.entity.Student;
import io.kubernetes.client.openapi.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author zhuhaifeng
 */
@RestController
@RequestMapping("/destiny")
public class HelloController {
    @Autowired
    private Student student;

    @GetMapping("/hello")
    public String message() throws IOException, ApiException {

        return "hello";
    }
    @GetMapping("/namespace")
    public  void client() throws IOException, ApiException {

    }

    public static void main(String[] args) {

    }
}
