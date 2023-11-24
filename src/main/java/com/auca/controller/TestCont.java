package com.auca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestCont {

    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("message", "This message");
        return "test";
    }

    @GetMapping("/")
    public String dashboard(){
        return "dashboard";
    }
}
