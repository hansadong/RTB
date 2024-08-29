package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/main")
    public String index() {
        return "양경운 하이 박찬민 하이 ";
    }
}
