package com.csis.Entities;

import java.util.Date;

public class Banquet {
	private Date date;
	private String meal;
	private boolean addService;
	
	public Banquet(){
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String isMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public boolean isAddService() {
		return addService;
	}

	public void setAddService(boolean addService) {
		this.addService = addService;
	}
	
	
}
