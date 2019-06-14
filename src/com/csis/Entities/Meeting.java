package com.csis.Entities;

import java.util.Date;

public class Meeting {
	private Date reservedate;
	private int duration;
	private boolean meal;
	
	Meeting(){
		
	}

	public Date getReservedate() {
		return reservedate;
	}

	public void setReservedate(Date reservedate) {
		this.reservedate = reservedate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isMeal() {
		return meal;
	}

	public void setMeal(boolean meal) {
		this.meal = meal;
	}
	
	
}
