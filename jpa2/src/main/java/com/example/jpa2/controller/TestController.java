package com.example.jpa2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("hi")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

}
