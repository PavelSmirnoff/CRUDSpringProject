package dev.smirnov.crudspringproject.controller;

import dev.smirnov.crudspringproject.model.User;
import dev.smirnov.crudspringproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author pavelsmirnov
 */
@Controller
public class UserController {
    private UserService userService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUsers(ModelAndView model) {
        List<User> userList = this.userService.getUsers();
        userList.forEach(x -> System.out.println(x.getId()));

        model.setViewName("users");
        model.addObject("user", new User());
        model.addObject("userList", userList );
        model.addObject("text", "simple text");
        return model;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        if (user.getId() == null){
            this.userService.createUser(user);
        }else{
            this.userService.updateUser(user);
        }

        return "redirect:/users";
    }
}
