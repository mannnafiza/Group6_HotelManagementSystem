package com.csis.Entities;

import java.util.Date;

public class Restaurant {
	private Date date;
	private int noOfGuest;
	private String mealType;
	private String reservationFor;
	
	public Restaurant(){
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNoOfGuest() {
		return noOfGuest;
	}

	public void setNoOfGuest(int noOfGuest) {
		this.noOfGuest = noOfGuest;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getReservationFor() {
		return reservationFor;
	}

	public void setReservationFor(String reservationFor) {
		this.reservationFor = reservationFor;
	}

	
	
	
}
