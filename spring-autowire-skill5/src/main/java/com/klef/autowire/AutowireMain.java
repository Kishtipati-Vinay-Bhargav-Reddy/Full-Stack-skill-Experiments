package com.klef.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowireMain {

    private static ApplicationContext context;

	public static void main(String[] args) {

        context = new AnnotationConfigApplicationContext(AppConfig.class);

        Student student = context.getBean(Student.class);
        student.display();
    }
}
