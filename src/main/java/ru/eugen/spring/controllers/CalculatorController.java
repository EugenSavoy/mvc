package ru.eugen.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.eugen.spring.config.Operation;

@Controller
public class CalculatorController {

    @GetMapping("/calc")
    public String sayExit(@RequestParam(value = "a", required = false) int a,
                          @RequestParam(value = "b", required = false) int b,
                          @RequestParam(value = "action", required = false) String nameofoperation,
                          Model model) {

        Operation operation = Operation.valueOf(nameofoperation);

        int result = 0;
        String message = "All right!";
       if (operation.equals(Operation.mult)) {
           result = a*b;
        }
        else if (operation.equals(Operation.add)) {
            result = a+b;
        }
       else if (operation.equals(Operation.sub)) {
           result = a-b;
       }
       else if (operation.equals(Operation.devision)) {
           try {
               result = a/b;

           } catch (ArithmeticException e) {
              message = "Cannot be divided by zero!";
           }

       }

       model.addAttribute("result", result);
        model.addAttribute("message", message);

        return "/calc"; }
    }


