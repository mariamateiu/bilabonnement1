package com.example.bilabonnement1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {


    @GetMapping("/hej")
    public String test() {
        return "DamageRegistration";
    }
}
