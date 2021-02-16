package dev.smirnov.crudspringproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pavelsmirnov
 */
@Controller
public class UserController {

    @RequestMapping("/")
    String getIndex(){

        return "index";
    }
}
