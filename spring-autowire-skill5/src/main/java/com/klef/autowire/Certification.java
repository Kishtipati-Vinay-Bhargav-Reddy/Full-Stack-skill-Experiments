package com.klef.autowire;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id = 501;
    private String name = "Spring Framework";
    private String dateOfCompletion = "15-02-2026";

    public void display() {
        System.out.println("Certification ID   : " + id);
        System.out.println("Certification Name : " + name);
        System.out.println("Completed On       : " + dateOfCompletion);
    }
}
