package dev.smirnov.crudspringproject.controller;

import dev.smirnov.crudspringproject.model.Role;
import dev.smirnov.crudspringproject.model.User;
import dev.smirnov.crudspringproject.service.RoleService;
import dev.smirnov.crudspringproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author pavelsmirnov
 */
@Controller
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String getUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("role", new Role());
        model.addAttribute("userRole", new LinkedHashSet<Long>());
        model.addAttribute("roleList", this.roleService.getRoles());
        model.addAttribute("userList", this.userService.getUsers());
        return "/admin";
    }

    @PostMapping("/admin/adduser")
    public String addUser(@ModelAttribute("user") User user, @RequestParam("rL") String[] roles) {
        Set<Role> roleList = new LinkedHashSet<>();
        for(int i=0; i < roles.length ; i++){
            roleList.add(this.roleService.getRoleById(Long.parseLong(roles[i])));
        }

        user.setRoles(roleList);
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
    @GetMapping("/admin/edit/{id}")
    public String editUsers(@PathVariable("id") long id, Model model) {
        User user = this.userService.getUserById(id);
        Set<Long> integerList = new LinkedHashSet<>();
        user.getRoles().forEach(x -> integerList.add(x.getId()));
        model.addAttribute("user", user);
        model.addAttribute("userRole", integerList);
        model.addAttribute("userList", this.userService.getUsers());
        model.addAttribute("role", new Role());
        model.addAttribute("roleList", this.roleService.getRoles());
        return "/admin";
    }

    @PostMapping("/admin/addrole")
    public String addRole(@ModelAttribute("role") Role role) {
            this.roleService.createRole(role);
        return "redirect:/admin";
    }

    @GetMapping("/admin/deleterole/{id}")
    public String deleteRole(@PathVariable("id") long id) {
        this.roleService.deleteRole(id);
        return "redirect:/admin";
    }
}
