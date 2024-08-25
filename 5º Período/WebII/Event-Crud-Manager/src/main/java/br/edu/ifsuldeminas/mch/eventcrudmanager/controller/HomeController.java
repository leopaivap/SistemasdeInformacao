package br.edu.ifsuldeminas.mch.eventcrudmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String loadMenu() {
        return "index";
    }
}
