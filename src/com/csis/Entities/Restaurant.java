package com.csis.Entities;

import java.util.Date;

public class Restaurant {
	private Date date;
	private int noOfGuest;
	private String mealType;
	private String reservationFor;
	
	/**
	 * constructor
	 */
	public Restaurant(){
		
	}

	/**
	 * 
	 * @return the date of reservation
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * 
	 * @param date is the date on which reservation is made
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * 
	 * @return number of guests for reservation
	 */
	public int getNoOfGuest() {
		return noOfGuest;
	}

	/**
	 * 
	 * @param noOfGuest, is the number of guest for reservation
	 */
	public void setNoOfGuest(int noOfGuest) {
		this.noOfGuest = noOfGuest;
	}

	/**
	 * 
	 * @return the type of meal (veg or non veg)
	 */
	public String getMealType() {
		return mealType;
	}

	/**
	 * 
	 * @param mealType is the type of meal (veg or non veg)
	 */
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	/**
	 * 
	 * @return the reservation for type (breakfast, brunch, lunch, and dinner)
	 */
	public String getReservationFor() {
		return reservationFor;
	}

	/**
	 * 
	 * @param reservationFor is the reservation for type (breakfast, brunch, lunch, and dinner)
	 */
	public void setReservationFor(String reservationFor) {
		this.reservationFor = reservationFor;
	}

	
	
	
}
