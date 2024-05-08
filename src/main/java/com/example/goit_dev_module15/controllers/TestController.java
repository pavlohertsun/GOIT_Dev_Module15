package com.example.goit_dev_module15.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {
    @GetMapping("")
    public ModelAndView getHelloWorld(){
        return new ModelAndView("/test/test");
    }
}
