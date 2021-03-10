package com.nikanorov.task_3_1_1.spring_boot.controllers;

import com.nikanorov.task_3_1_1.spring_boot.models.User;
import com.nikanorov.task_3_1_1.spring_boot.service.RoleService;
import com.nikanorov.task_3_1_1.spring_boot.service.UserServicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;

@Controller
//@RestController
@RequestMapping("/admin")
public class AdminController {

    private RoleService roleService;
    private UserServicee userServicee;


    @Autowired
    public AdminController(RoleService roleService, UserServicee userServicee) {
        this.roleService = roleService;
        this.userServicee = userServicee;
    }

    @GetMapping
    public String index(Model model, Principal principal) {
        model.addAttribute("users", userServicee.getAllUsers());
        model.addAttribute("currentuser",userServicee.getUserByName(principal.getName())) ;
        return "/admin/index";
    }

// @GetMapping
//    public ModelAndView index() {
//        ModelAndView model = new ModelAndView("/admin/index");
//        model.addObject("users", userServicee.getAllUsers());
//        return model;
//    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServicee.getById(id));
        model.addAttribute("roles", userServicee.getById(id).getRolesList());

        return "admin/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user
            , Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        return "admin/new";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user")
                             @Valid User user

            , BindingResult result
            , @RequestParam("select_role") Long[] roles) {
        if (result.hasErrors())
            return "admin/new";
        for (Long role : roles) {
            user.addRole(roleService.getById(role));
        }
        userServicee.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model
            , @PathVariable("id") int id) {
        model.addAttribute("userById", userServicee.getById(id));
        model.addAttribute("rolesList", roleService.getAllRoles());

        return "admin/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user")
                         @Valid User user, BindingResult result
            , @PathVariable("id") int id, @RequestParam("select_role") Long[] roles) {
        if (result.hasErrors())
            return "admin/edit";
        for (Long role : roles) {
            user.addRole(roleService.getById(role));
        }
        userServicee.update(user, id);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userServicee.delete(id);
        return "redirect:/admin";
    }


    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "admin/login";
    }


}
