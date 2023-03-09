package com.example.controllers;

import com.example.services.GreetingServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    //property dependnecy injection 
    //@Autowired
    GreetingServiceImpl greetingService;
    
    // constructor dependency injection
    public MyController(GreetingServiceImpl greetingService){
        this.greetingService=greetingService;
    }

    // public String hello(){
    //     return "ciao!";
    // }

    public String hello(){
        return greetingService.sayGretting();
    }
}
