package com.example.Security.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("v1")
public class UsuarioController {

    @GetMapping("index")
    public String inicio() {
        return "Conectado";
    }

    @GetMapping("index2")
    public String inicio2() {
        return "Conectado SIN SEGURIDAD!";
    }

}
