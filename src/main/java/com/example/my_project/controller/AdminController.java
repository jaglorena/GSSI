package com.example.my_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminController {

    @GetMapping("/protegida")
    public Map<String, String> protegida() {
        Map<String, String> protegida = new HashMap<>();
        protegida.put("titulo","Esta es una ruta protegida");
        return protegida;
    }
}
