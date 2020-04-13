package com.example.adminclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tr
 * @date 2020/4/13 10:52
 */
@RestController()
@RequestMapping("/ini")
public class HelloController {
    @GetMapping("/hello")
    public String Hello() {
        return "hello";
    }
}
