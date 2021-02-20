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
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userList", this.userService.getUsers());
        return "/users";
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute("user") User user) {
        File file = new File("text.txt");
        user.setFile(file);
        if (user.getId() == null) {
            this.userService.createUser(user);
        } else {
            this.userService.updateUser(user);
        }
        return "redirect:/users";
    }

    //@RequestMapping("/delete/{id}")
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        this.userService.deleteUser(id);
        return "redirect:/users";
    }

    //@RequestMapping("/edit/{id}")
    @GetMapping("/edit/{id}")
    public String editUsers(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("userList", this.userService.getUsers());
        return "/users";
    }
}
