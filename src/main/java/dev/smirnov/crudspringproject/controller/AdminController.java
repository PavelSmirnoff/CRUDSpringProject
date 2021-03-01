package dev.smirnov.crudspringproject.controller;

import dev.smirnov.crudspringproject.model.User;
import dev.smirnov.crudspringproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;

/**
 * @author pavelsmirnov
 */
@Controller
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String getUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userList", this.userService.getUsers());
        return "/admin";
    }

    @PostMapping("/admin/add")
    public String addUser(@ModelAttribute("user") User user) {
        if (user.getId() == null) {
            this.userService.createUser(user);
        } else {
            this.userService.updateUser(user);
        }
        return "redirect:/admin";
    }

    //@RequestMapping("/delete/{id}")
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        this.userService.deleteUser(id);
        return "redirect:/admin";
    }

    //@RequestMapping("/edit/{id}")
    @GetMapping("/edit/{id}")
    public String editUsers(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("userList", this.userService.getUsers());
        return "/admin";
    }
}
