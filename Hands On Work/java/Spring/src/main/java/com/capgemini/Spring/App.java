package com.capgemini.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean-config.xml");
        Student beanS=(Student)ac.getBean("student");
        System.out.println(beanS);
        Student beanS1=(Student)ac.getBean("student1");
        System.out.println(beanS1);
        Employee beanE=(Employee)ac.getBean("employee");
        System.out.println(beanE);
        Employee beanE1=(Employee)ac.getBean("employee1");
        System.out.println(beanE1);
    }
}
