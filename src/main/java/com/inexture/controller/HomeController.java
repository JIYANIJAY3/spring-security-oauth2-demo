package com.inexture.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/local")
    public String local()
    {
        return "local page";
    }

    @GetMapping("/home")
    public String home()
    {
        return "Welcome Home Page";
    }
}
