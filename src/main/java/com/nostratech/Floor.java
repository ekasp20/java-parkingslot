package com.nostratech;

import java.util.*;

public class Floor {
	private String floorNumber;
	private List<Slot> slots;
	
	public Floor(String floorNumber, int numberOfSlots) {
		this.floorNumber = floorNumber;
		this.slots = new ArrayList<>();
		for (int i = 1; i <= numberOfSlots; i++) {
			slots.add(new Slot(Integer.toString(i)));
		}
	}
	
	public void addSlot(Slot slot) {
		slots.add(slot);
	}
	
	public String getFloorNumber() {
		return floorNumber;
	}
	
	public List<Slot> getSlots(){
		return slots;
	}
}
