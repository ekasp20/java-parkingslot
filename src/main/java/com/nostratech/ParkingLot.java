package com.nostratech;

import java.util.*;

public class ParkingLot {
	private String parkingLotId;
	private int numberOfFloors;
	private List<Floor> floors;
	private int numberOfSlotsPerFloors;
	
	public ParkingLot(String parkingLotId, int numberOfFloors, int numberOfSlotsPerFloors) {
		this.parkingLotId = parkingLotId;
		this.numberOfFloors = numberOfFloors;
		this.numberOfSlotsPerFloors = numberOfSlotsPerFloors;
		this.floors = new ArrayList<>();
		for(int i = 1; i <= numberOfFloors; i++){
			floors.add(new Floor(Integer.toString(i), numberOfSlotsPerFloors));
		}
	}
	
	private boolean isSlotTypeCompatible(String slotNumber, String vehicleType) {
		if (vehicleType.equals("CAR")) {
			return !slotNumber.equals("1");
		}else if (vehicleType.equals("BIKE")) {
			return !slotNumber.equals("1") && !slotNumber.equals("2");
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
	public void displayFreeCount(String vehicleType) {
		for (Floor floor : floors) {
			int count = 0 ;
			for(Slot slot : floor.getSlots()) {
				if(slot.getVehicle() == null && isSlotTypeCompatible(slot.getSlotNumber(), vehicleType)) {
					count++;
				}
			}
			System.out.println("No. of free slots for " + vehicleType + " on floor " + floor.getFloorNumber() + ": " + count);
		}
	}
	public void displayFreeSlots(String vehicleType) {
		for(Floor floor : floors) {
			List<String> freeSlots = new ArrayList<>();
			for(Slot slot : floor.getSlots()) {
				if(slot.getVehicle() == null && isSlotTypeCompatible(slot.getSlotNumber(), vehicleType)) {
					freeSlots.add(slot.getSlotNumber());
				}
			}
			System.out.println("Free slots for " + vehicleType + " on Floor " + floor.getFloorNumber() + ": " + String.join(",", freeSlots));
		}
	}
	public void displayOccupiedSlots(String vehicleType) {
		for(Floor floor : floors) {
			List<String> occupiedSlots = new ArrayList<>();
			for (Slot slot : floor.getSlots()) {
				if(slot.getVehicle() != null && slot.getVehicle().getType().equals(vehicleType)) {
					occupiedSlots.add(slot.getSlotNumber());
				}
			}
			System.out.println("Occupied slots for " + vehicleType + "on Floor " + floor.getFloorNumber() + ": " + String.join(",", occupiedSlots));
		}
	}
}
