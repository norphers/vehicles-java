package com.vehicles.project;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}

	public String toString() {
		return "Wheel [brand=" + brand + ", diameter=" + diameter + "]";
	}
	
}


