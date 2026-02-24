package com.klef.di.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlMain {

    private static ApplicationContext context;

	public static void main(String[] args) {

        context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student = context.getBean("student", Student.class);
        student.display();
    }
}

