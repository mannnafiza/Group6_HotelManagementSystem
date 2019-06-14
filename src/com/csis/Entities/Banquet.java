package com.csis.Entities;

import java.util.Date;

public class Banquet {
	private Date date;
	private boolean meal;
	private boolean addService;
	
	public Banquet(){
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
	
	
}
