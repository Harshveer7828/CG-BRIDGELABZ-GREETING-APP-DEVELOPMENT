package com.greetingapp.greeting.service;

import com.greetingapp.greeting.entity.GreetingEntity;
import com.greetingapp.greeting.repositories.GreetingRepository;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public String getGreetingMessage(){
        return "Hello World";
    }

    public String customGreetingMessage(String firstName, String lastName){
        if(firstName != null && lastName != null){
            return "Hello " + firstName + " " + lastName + "!!";
        } else if (firstName != null) {
            return "Hello" + firstName + "!!";
        } else if (lastName != null) {
            return "Hello" + lastName + "!!";
        }else {
            return "Hello World";
        }
    }

    // Method to save the message
    public GreetingEntity saveMessage(String message){
        GreetingEntity greeting = new GreetingEntity(message);
        return greetingRepository.save(greeting);
    }



}
