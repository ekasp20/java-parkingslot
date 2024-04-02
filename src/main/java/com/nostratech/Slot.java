package com.nostratech;

public class Slot {
	private String slotNumber;
	private Vehicle vehicle;
	
	public Slot(String slotNumber) {
		this.slotNumber = slotNumber;
	}
	public String getSlotNumber() {
		return slotNumber;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
