package ru.eugen.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {

    @GetMapping("/exit")
    public String sayExit() {
        return "exit/exit"; }
    }


