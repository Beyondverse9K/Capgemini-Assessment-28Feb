package com.capgemini.Spring.classbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
		People people = ac.getBean(People.class);
		System.out.println(people);
		Bike bike =(Bike) ac.getBean("Yamaha");
		System.out.println(bike);
		Pojo pojo = ac.getBean(Pojo.class); //Field Injection
		System.out.println(pojo);
	}

}
