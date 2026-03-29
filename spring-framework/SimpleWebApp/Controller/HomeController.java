package com.telusko.SimpleWebApp.Controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
  
    public String greet(){
        System.out.println("I am here");
        return "Welcome to myApp";
    }

    
    @RequestMapping("/about")
    public String about(){
        return "we dont teach,we educate";
    }

}
