package com.csis.Entities;

import java.util.Date;

public class Restaurant {
	private Date date;
	//private String time;
	private int noOfGuest;
	private String mealType;
	
	Restaurant(){
		
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
	
	
}
