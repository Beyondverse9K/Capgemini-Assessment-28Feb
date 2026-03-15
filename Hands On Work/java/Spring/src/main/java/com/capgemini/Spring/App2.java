package com.capgemini.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("annotation_config.xml");
		User user=(User)ac.getBean("user");
		System.out.println(user);
	}

}
