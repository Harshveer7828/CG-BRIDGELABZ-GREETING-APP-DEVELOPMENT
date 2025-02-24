package com.greetingapp.greeting.controller;

import com.greetingapp.greeting.entity.GreetingEntity;
import com.greetingapp.greeting.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("greet/hello")
public class GreetingServiceController {
    private final GreetingService greetingService;

    public GreetingServiceController(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    @GetMapping
    public String sayHello(){
        return greetingService.getGreetingMessage();
    }


    // GET request to greet with firstname and lastname
    @GetMapping("/data")
    public String greetWithFullName(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName){
        return greetingService.customGreetingMessage(firstName,lastName);
    }

    // POST request to save the message
    @PostMapping("/save")
    public GreetingEntity saveMessage(@RequestBody String message){
        return greetingService.saveMessage(message);
    }



}
