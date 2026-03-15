package com.capgemini.Spring.classbased;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bike {

	private int bikeId;
	private String bikeName;
	private String colour;
	@Override
	public String toString() {
		return "Bike [bikeId=" + bikeId + ", bikeName=" + bikeName + ", colour=" + colour + "]";
	}
	public int getBikeId() {
		return bikeId;
	}
	@Value("99")
	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}
	public String getBikeName() {
		return bikeName;
	}
	@Value("BMW")
	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}
	public String getColour() {
		return colour;
	}
	@Value("White")
	public void setColour(String colour) {
		this.colour = colour;
	}
	
}
