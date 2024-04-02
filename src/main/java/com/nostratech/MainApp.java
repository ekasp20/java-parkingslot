package com.nostratech;

import java.util.*;

public class MainApp {
    public static void main( String[] args ){
    Scanner scanner = new Scanner(System.in);
    ParkingLot parkingLot = null;
    
    while(true) {
    	System.out.println("Enter command: ");
    	String command = scanner.nextLine();
    	String[] tokens = command.split(" ");
    	
    	if(tokens[0].equals("create_parking_lot")) {
    	String parkingLotId = tokens[1];
    	int numberOfFloors = Integer.parseInt(tokens[2]);
    	int numberOfSlotsPerFloors = Integer.parseInt(tokens[3]);
    	parkingLot = new ParkingLot(parkingLotId, numberOfFloors, numberOfSlotsPerFloors);
    	System.out.println("Created parking lot with " + numberOfFloors + " floors and " + numberOfSlotsPerFloors + " slots per floor");
    }	else if(tokens[0].equals("park_vehicle")) {
    	String vehicleType = tokens[1];
    	String regNo = tokens[2];
    	String color = tokens[3];
    	if(parkingLot != null) {
    		String ticketId = parkingLot.parkVehicle(vehicleType, regNo, color);
    		if(!ticketId.equals("Parking Lot Full")) {
    			System.out.println("Parked vehicle. Ticket ID: " + ticketId);
    		}
    			else {
    				System.out.println("Parking Lot Full");
    			}
    	}
    			else {
    				System.out.println("Parking Lot Not Created Yet");
    			}
    		}
    	else if(tokens[0].equals("unpark_vehicle")) {
    		String ticketId = tokens[1];
    		if(parkingLot != null) {
    			parkingLot.unparkVehicle(ticketId);
    		}
    		else {
    			System.out.println("Parking lot not created yet");
    		}
    	}
    	else if (tokens[0].equals("display")) {
    		String displayType = tokens[1];
    		String vehicleType = tokens[2];
    		if (parkingLot != null) {
    			if(displayType.equals("free_count")) {
    				parkingLot.displayFreeCount(vehicleType);
    			}
    			else if(displayType.equals("free_slots")) {
    				parkingLot.displayFreeSlots(vehicleType);
    			}
    			else if(displayType.equals("occupied_slots")) {
    				parkingLot.displayOccupiedSlots(vehicleType);
    			}
    			else {
        			System.out.println("Invalid display type");
    			}
    		}
    		else {
    			System.out.println("Parking lot not yet created");
    		}
    	}
    	else if(tokens[0].equals("Exit")) {
    		break;
    	}
    	else {
    		System.out.println("Invalid Command");
    	}
    }
    }
}
    		
    		
    	
    
    	
    
    

    

   
  

    		
    

    

