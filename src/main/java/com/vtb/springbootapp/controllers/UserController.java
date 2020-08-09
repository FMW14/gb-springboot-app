package com.vtb.springbootapp.controllers;

import com.vtb.springbootapp.domain.User;
import com.vtb.springbootapp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("frontUsers", userService.getAll());
        return "users";
    }

    @GetMapping("/remove/{id}")
    public String removeUser(@PathVariable Long id) {
        userService.removeById(id);
        return "redirect:/users/all";
    }

    @GetMapping("/edit/{id}")
    public String editUserById(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "user-edit-page";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users/all";
    }

    @PostMapping("/add")
    public String addNewUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users/all";
    }
}
