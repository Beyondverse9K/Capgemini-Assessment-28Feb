package com.capgemini.Spring.classbased;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //Make the class as configuration class
@ComponentScan(basePackages = "com.capgemini.Spring")
public class BeanConfig {

	public BeanConfig() {
		// TODO Auto-generated constructor stub
	}
	@Bean
	public List<Integer> list(){
		return List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	}
	@Bean(name = "Yamaha")
	public Bike Yamaha() {
		Bike bike=new Bike();
		bike.setBikeId(1);
		bike.setBikeName("YAMAHA");
		bike.setColour("Grey");
		return bike;
	}
}
