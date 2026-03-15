package com.capgemini.Spring.classbased;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Pojo {
	@Autowired
	@Qualifier("Yamaha")
	private Bike bike;
	@Autowired
	private People people;
	@Autowired
	private List<Integer> peoples;
	@Override
	public String toString() {
		return "Pojo [bike=" + bike + ", people=" + people + ", peoples=" + peoples + "]";
	}
	
}
