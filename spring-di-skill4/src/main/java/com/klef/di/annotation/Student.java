package com.klef.di.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @Value("102")
    private int studentId;

    @Value("Reddy")
    private String name;

    private String course;
    private int year;

    // Constructor Injection
    public Student(@Value("AI & DS") String course,
                   @Value("3") int year) {
        this.course = course;
        this.year = year;
    }

    // Setter Injection
    @Value("Artificial Intelligence")
    public void setCourse(String course) {
        this.course = course;
    }

    @Value("3")
    public void setYear(int year) {
        this.year = year;
    }

    public void display() {
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Course     : " + course);
        System.out.println("Year       : " + year);
    }
}
