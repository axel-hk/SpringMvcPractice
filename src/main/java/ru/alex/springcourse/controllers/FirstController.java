package ru.alex.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){

        //System.out.println("Hello "+ name + " " + surname);
        model.addAttribute("messege", "Hello "+ name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public  String goodByepage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String Calculator(@RequestParam(value = "a", required = false) int a,
                           @RequestParam(value = "b", required = false) int b,
                           @RequestParam(value = "action", required = false)String action,
                           Model model){
        double answer;
        switch (action){
            case "addition":
                answer = a+b;
                break;
            case "subtraction":
                answer = a-b;
                break;
            case "multiplication":
                answer = a*b;
                break;
            case "division":
               answer = a /(double)b;
               break;
            default:
                answer = 0;
                break;
        }

        model.addAttribute("answer", answer);
        return "first/calculator";

    }
}


