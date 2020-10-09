package com.vehicles.project;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class exerciciVehicles {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner (System.in);
		
		boolean vehicleOk = false;
		boolean choiceCar = false;
		boolean choiceBike = false;
		Car newCar;
		Bike newBike;
		String plate=null;
		String color=null;
		String brand=null;
		boolean correctPlate = false;
		
		
		do{
			System.out.println("Hello, this is the Self-Custom Vehicle Software.\nWhat do you want to custom?");
			String userChoice=sc.next().toLowerCase();
			if (userChoice.equals("car")) {
				choiceCar = true; 
				vehicleOk = true;
			}
			else if (userChoice.equals("bike")) {
				choiceBike = true;
				vehicleOk = true;
			}
		} while(vehicleOk==false);
		
		
		newCar = new Car(plate, brand, color);
		newBike = new Bike(plate, brand, color);


		do {
			System.out.println("Insert your plate number, please.");
			plate=sc.next().toUpperCase();	
			
			Matcher m = Pattern.compile("^[0-9]{4}[A-Z]{2,3}$").matcher(plate); 
			
			if (m.find()) {
				System.out.println(plate + " is a valid number plate");
				newCar.plate = plate;
				newBike.plate= plate;
				correctPlate=true;
			} 
			else {
				System.out.println(plate + " is not a valid number plate");
				correctPlate=false;
			}
		} while(correctPlate==false);
		
		System.out.println("Ok, now, what vehicle's brand do you want? ");
		brand=sc.next();
		newCar.brand=brand;
		newBike.brand=brand;
		
		System.out.println("Finally, insert the colour what you want: ");
		color=sc.next();
		newCar.color=color;
		newBike.color=color;
		
		if(choiceCar==true) {
			System.out.println("Add the front Wheels");
			newCar.wheels.add(CreateWheel(sc));
			newCar.wheels.add(CreateWheel(sc));
			
			System.out.println("Add the back Wheels");
			newCar.wheels.add(CreateWheel(sc));
			newCar.wheels.add(CreateWheel(sc));	
		}
		else if (choiceBike==true) {
			System.out.println("Add the Wheels");
			newBike.wheels.add(CreateWheel(sc));
			newBike.wheels.add(CreateWheel(sc));
		}
		 
		if (choiceCar==true) {
			System.out.println(newCar);
		}
		else if (choiceBike==true) {
			System.out.println(newBike);
		}
				
	}
	
	public static Wheel CreateWheel(Scanner sc) {
		
		boolean diameterEntry=false;
		double diameter = 0.0;
		System.out.println("Which brand wheel do you want?");
		String brandW = sc.next();
			
		do {
			System.out.println("Which size?");
			double setDiameter=sc.nextDouble();
			if (setDiameter<0.4) {
				System.out.println("The diamter is too small.");	
			} else if (setDiameter>4) {
				System.out.println("The diamter is too big.");
			} else {
				diameter = setDiameter; 
				diameterEntry=true;
			}
		} while(diameterEntry==false);
		
		Wheel wheel = new Wheel (brandW, diameter);
		
		return wheel;
	}

}
