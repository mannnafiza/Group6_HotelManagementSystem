package com.csis.Entities;

import java.util.Date;

public class Banquet {
	private Date date;
	private String meal;
	private boolean addService;
	
	/**
	 * constructor
	 */
	public Banquet(){
		
	}

	
	/**
	 * 
	 * @return the date
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
	 * @return if meal is selected
	 */
	public String isMeal() {
		return meal;
	}

	
	/**
	 * 
	 * @param meal is the status of the meal selection
	 */
	public void setMeal(String meal) {
		this.meal = meal;
	}

	/**
	 * 
	 * @return if additional services were asked
	 */
	public boolean isAddService() {
		return addService;
	}

	
	/**
	 * 
	 * @param addService is the status of additional services required
	 */
	public void setAddService(boolean addService) {
		this.addService = addService;
	}
	
	
}
