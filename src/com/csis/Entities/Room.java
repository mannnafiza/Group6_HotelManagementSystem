package com.csis.Entities;

import java.util.Date;

public class Room {
	private String roomType;
	private int duration;
	private boolean meal;
	private boolean addService;
	private Date reserveDate;
	
	Room(){
		
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public boolean isMeal() {
		return meal;
	}

	public void setMeal(boolean meal) {
		this.meal = meal;
	}

	public boolean isAddService() {
		return addService;
	}

	public void setAddService(boolean addService) {
		this.addService = addService;
	}

	public Date getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
}
