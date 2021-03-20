package com.nikanorov.task_3_1_1.spring_boot.controllers;


import com.nikanorov.task_3_1_1.spring_boot.models.User;
import com.nikanorov.task_3_1_1.spring_boot.service.RoleService;
import com.nikanorov.task_3_1_1.spring_boot.service.UserServicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
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

    @PostMapping("/save")
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        userServicee.save(user);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


//    @GetMapping
//    public String index(Model model, Principal principal
//            ) {
//        model.addAttribute("users", userServicee.getAllUsers());
//        model.addAttribute("currentuser", userServicee.getUserByName(principal.getName()));
//        model.addAttribute("roles", roleService.getAllRoles());
//        User newUser = new User();
//        model.addAttribute("new_user",newUser);
//        return "admin/index";
//    }
//
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", userServicee.getById(id));
//        model.addAttribute("roles", userServicee.getById(id).getRolesList());
//
//        return "admin/show";
//    }
//
//    @GetMapping("/new")
//    public String newUser(@ModelAttribute("user") User user
//            , Model model) {
//        model.addAttribute("roles", roleService.getAllRoles());
//        return "admin/new";
//    }
//
//    @PostMapping
//    public String createUser(@ModelAttribute("user")
//                             @Valid User user
//
//            , BindingResult result
//            , @RequestParam("select_role") Long[] roles) {
//        if (result.hasErrors())
//            return "admin/new";
//        for (Long roleId : roles) {
//            user.addRole(roleService.getById(roleId));
//        }
//        userServicee.save(user);
//        return "redirect:/admin";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(Model model
//            , @PathVariable("id") int id) {
//        model.addAttribute("userById", userServicee.getById(id));
//        model.addAttribute("rolesList", roleService.getAllRoles());
//
//        return "admin/edit";
//    }
//
//
//
//    @PostMapping("/update")
//    public String update(@ModelAttribute User user
//          ,@RequestParam("select_role") Long[] roles  ) {
//        System.out.println("it works");
////        if (result.hasErrors())
////            return "admin/edit";
//        for (Long role : roles) {
//            user.addRole(roleService.getById(role));
//        }
//        int id =user.getId();
//        userServicee.update(user, id);
//        return "redirect:/admin";
//    }
//
//    @PostMapping("/delete")
//    public String delete(@ModelAttribute
//                                     User user) {
//       int id = user.getId();
//        userServicee.delete(id);
//        return "redirect:/admin";
//    }
//
//
//    @RequestMapping(value = "login", method = RequestMethod.GET)
//    public String loginPage() {
//        return "admin/login";
//    }


}
