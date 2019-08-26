package com.marcusdacoregio.authservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/signup")
public class TestController {
    @GetMapping("/")
    public String test() {
       return  "test";
    }

}
