package com.nostratech;

import java.util.*;

public class ParkingLot {
	private String parkingLotId;
	private int numberOfFloors;
	private List<Floor> floors;
	
	public ParkingLot(String parkingLotId, int numberOfFloors) {
		this.parkingLotId = parkingLotId;
		this.numberOfFloors = numberOfFloors;
		this.floors = new ArrayList<>();
	}
	
	private boolean isSlotTypeCompatible(String slotNumber, String vehicleType) {
		if (vehicleType.equals("CAR")) {
			return !slotNumber.equals("1");
		}else if (vehicleType.equals("BIKE")) {
			return !slotNumber.equals("1");
		}else if (vehicleType.equals("TRUCK")) {
			return !slotNumber.equals("1");
		}
		return false;
	}
	
	public void addFloor(Floor floor) {
		floors.add(floor);
	}
	
	public String parkVehicle(String vehicleType, String regNo, String color) {
		for (Floor floor : floors) {
			for (Slot slot : floor.getSlots()) {
				if (slot.getVehicle() == null && isSlotTypeCompatible(slot.getSlotNumber(), vehicleType)) {
					Vehicle vehicle = new Vehicle(vehicleType, regNo, color);
					slot.setVehicle(vehicle);
					return parkingLotId + "_" + floor.getFloorNumber() + "_" + slot.getSlotNumber();
				}
			}
		}
		return "Parking Lot is Full";
	}
	public void unparkVehicle(String ticketId) {
		String[] tokens = ticketId.split("_");
		String floorNumber = tokens[1];
		String slotNumber = tokens[2];
		
		for (Floor floor : floors) {
			if(floor.getFloorNumber().equals(floorNumber)) {
				for(Slot slot : floor.getSlots()) {
					if(slot.getSlotNumber().equals(slotNumber)) {
						slot.setVehicle(null);
						return;
					}
				}
			}
		}
		System.out.println("Invalid Ticket");
	}
}
