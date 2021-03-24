package com.nikanorov.task_3_1_1.spring_boot.controllers;


import com.nikanorov.task_3_1_1.spring_boot.models.Role;
import com.nikanorov.task_3_1_1.spring_boot.models.User;
import com.nikanorov.task_3_1_1.spring_boot.service.RoleService;
import com.nikanorov.task_3_1_1.spring_boot.service.UserServicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/")
public class RController {

    private RoleService roleService;
    private UserServicee userServicee;


    @Autowired
    public RController(RoleService roleService, UserServicee userServicee) {
        this.roleService = roleService;
        this.userServicee = userServicee;
    }

    @GetMapping("/users")
    public List<User> showAllUsers() {
        List<User> users = userServicee.getAllUsers();
        return users;
    }

    @GetMapping("/roles")
    public List<Role> showAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return roles;
    }

    @GetMapping("/auth")
    public User showCurrentUser(Principal principal) {
        String userName = principal.getName();
        User user = userServicee.getUserByName(userName);
        return user;
    }
    @PostMapping("/getOne/{id}")
    public User getUser(@PathVariable int id) {
             User user =userServicee.getById(id);
               return  user;
    }

    @PostMapping("/save")
    public List<User> createUser(@RequestBody User user) {
        userServicee.save(user);
        List<User> users = userServicee.getAllUsers();
        return users;
    }

    @PutMapping("/edit")
    public List<User> updateUser(@RequestBody User user) {
        int id = user.getId();
        userServicee.update(user,id);
        List<User> users = userServicee.getAllUsers();
        return users;
    }

 @DeleteMapping("/delete/{id}")
    public void updateteUser(@PathVariable int id) {
        userServicee.delete(id);
    }

}
