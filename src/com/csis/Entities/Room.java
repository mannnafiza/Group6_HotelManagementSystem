package com.csis.Entities;

import java.util.Date;

public class Room {
	private String roomType;
	private int duration;
	private String meal;
	private boolean addService;
	private Date reserveDate;
	
	/**
	 * constructor
	 */
	public Room(){
		
	}

	/**
	 * 
	 * @return the type of room reserved
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * 
	 * @param roomType is the type of room reserved
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 * 
	 * @return the meal veg or non-veg
	 */
	public String isMeal() {
		return meal;
	}

	/**
	 * 
	 * @param meal is the meal veg or non-veg
	 */
	public void setMeal(String meal) {
		this.meal = meal;
	}

	/**
	 * 
	 * @return if addiotional services required
	 */
	public boolean isAddService() {
		return addService;
	}

	/**
	 * 
	 * @param addService is the status if addiotional services required
	 */
	public void setAddService(boolean addService) {
		this.addService = addService;
	}

	/**
	 * 
	 * @return date on which reservation is made
	 */
	public Date getReserveDate() {
		return reserveDate;
	}

	/**
	 * 
	 * @param reserveDate is the date on which reservation is made
	 */
	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}

	/**
	 * 
	 * @return the duration of stay
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * 
	 * @param duration, is the stay duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
}
