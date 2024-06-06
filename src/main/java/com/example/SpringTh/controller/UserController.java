package com.example.SpringTh.controller;

import com.example.SpringTh.Entity.User;
import com.example.SpringTh.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listesUsers",userService.getAllUsers());
        return "index";
    }

    @GetMapping("/showNewUserForm")
    public String showForm(Model model){
    User user=new User();
    model.addAttribute("user",user);
    return "new_form";
    }
    @PostMapping("/saveUser")
    public String addUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";

    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value="id") long id,Model model){
     User user=userService.getUserById(id);
     model.addAttribute("user",user);
     return "update_form";
    }
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable (value="id") long id){
        this.userService.deleteUserById(id);
        return "redirect:/";
    }
}
