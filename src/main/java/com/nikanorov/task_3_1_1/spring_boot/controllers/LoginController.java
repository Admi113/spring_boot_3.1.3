package com.nikanorov.task_3_1_1.spring_boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(value = "login")
    public String loginPage() {
        return "admin/login";
    }
}
