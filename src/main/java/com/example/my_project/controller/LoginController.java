package com.example.my_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;

@Controller("/")
public class LoginController {

    Logger logger = Logger.getLogger(LoginController.class.getName());
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/authorized")
    public String authorized(@RequestParam String code) {
        logger.info("Codigo recibido=" + code);
        return "authorized";
    }


}
