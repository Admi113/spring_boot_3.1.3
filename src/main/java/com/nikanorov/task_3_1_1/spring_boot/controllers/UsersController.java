package com.nikanorov.task_3_1_1.spring_boot.controllers;


import com.nikanorov.task_3_1_1.spring_boot.models.User;
import com.nikanorov.task_3_1_1.spring_boot.service.RoleService;
import com.nikanorov.task_3_1_1.spring_boot.service.UserServicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {


    private UserServicee userServicee;

    @Autowired
    public UsersController(RoleService roleService, UserServicee userServicee) {
        this.userServicee = userServicee;
    }


    @GetMapping
    public String showUserInfo(Model model, Authentication authentication) {
        String userName = authentication.getName();
        User user = userServicee.getUserByName(userName);
        model.addAttribute("roles", user.getRolesList());
        model.addAttribute("currentuser", user);
        return "user/show";
    }


}
