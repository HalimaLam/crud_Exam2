package com.example.SpringTh.controller;

import com.example.SpringTh.Entity.Project;
import com.example.SpringTh.Entity.User;
import com.example.SpringTh.Service.ProjectService;
import com.example.SpringTh.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listesUsers",userService.getAllUsers());
        return "employee_list";
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
    @GetMapping("/userInfo/{id}")
    public String showFormForDetails(@PathVariable(value="id") long id,Model model){
        User user=userService.getUserById(id);
        model.addAttribute("user",user);
        return "details_form";
    }

    @GetMapping("/assignProject")
    public String showAssignProjectForm(Model model) {
        List<User> employees = userService.getAllUsers();
        List<Project> projects = projectService.getAllProject();

        model.addAttribute("employees", employees);
        model.addAttribute("projects", projects);

        return "emp_affect";
    }

    @PostMapping("/assignProject")
    public String assignProjectToEmployee(@RequestParam("employeeName") String employeeName,
                                          @RequestParam("projectName") String projectName,
                                          Model model) {
        // Logique pour affecter le projet à l'employé
        boolean success = userService.assignProjectToEmployee(employeeName, projectName);

        if (success) {
            model.addAttribute("message", "Project assigned successfully!");
        } else {
            model.addAttribute("message", "Error in assigning project. Please try again.");
        }

        return "success";
    }
}
