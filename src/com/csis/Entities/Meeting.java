package com.csis.Entities;

import java.util.Date;

public class Meeting {
	private Date reservedate;
	private int duration;
	private String meal;
	
	/**
	 * constructor
	 */
	public Meeting(){
		
	}

	/**
	 * 
	 * @return the date of reservation
	 */
	public Date getReservedate() {
		return reservedate;
	}

	/**
	 * 
	 * @param reservedate is the date on which reservation is made
	 */
	public void setReservedate(Date reservedate) {
		this.reservedate = reservedate;
	}

	/**
	 * 
	 * @return the meeting duration in hours
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * 
	 * @param duration is the meeting duration in hours
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * 
	 * @return the status of the meal (if required)
	 */
	public String isMeal() {
		return meal;
	}

	/**
	 * 
	 * @param meal is the status of the meal (if required)
	 */
	public void setMeal(String meal) {
		this.meal = meal;
	}
	
	
}
