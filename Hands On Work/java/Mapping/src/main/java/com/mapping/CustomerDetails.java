package com.mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMERDETAILS")
public class CustomerDetails {
	
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "MOBILE")
	private long mobile;
	
	@Column(name = "SALARY")
	private double salary;
	
	public CustomerDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerDetails(int id, String name, String email, long mobile, double salary) {
		this.id=id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.salary = salary;
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getMobile() {
		return mobile;
	}
	
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + 
	email + ", mobile=" + mobile + ", salary=" + salary + "]";
	}
}
