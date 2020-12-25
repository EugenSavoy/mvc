package ru.eugen.spring.controllers;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String sayHallo(@RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        //String name = request.getParameter( "name");
        //String surname = request.getParameter( "surname");

        //System.out.println(name +", "+ surname);

        model.addAttribute("message", name +", "+ surname);

        return "hello/HelloWord";
    }

    @GetMapping("/goodbuy")
    public String sayGoodbuy() {
        return "hello/goodbuy";
    }

}
