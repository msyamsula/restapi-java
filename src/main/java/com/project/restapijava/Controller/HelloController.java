package com.project.restapijava.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    
    @GetMapping("/")
    public String hello(){
        return "hello test 2";
    }

    @GetMapping("/workout")
    public String workout(){
        return "working out";
    }
    
}
