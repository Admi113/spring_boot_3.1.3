package com.nikanorov.task_3_1_1.spring_boot.controllers;

import com.nikanorov.task_3_1_1.spring_boot.service.RoleService;
import com.nikanorov.task_3_1_1.spring_boot.service.UserServicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {


    @GetMapping
    public String index() {
        return "admin/index_old";
    }


    @GetMapping(value = "login")
    public String loginPage() {
        return "admin/login";
    }


}
