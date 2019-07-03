package com.csis.Entities;

public class Service {
	
	private String customerName  = "";
	private int roomNumber  = 0 ;
	private float time = 0;
	private boolean serviceType ; 
	
	/**
	 * @return the serviceType
	 */
	public boolean getServiceType() {
		return serviceType;
	}
	/**
	 * @param serviceStatus the serviceType to set
	 */
	public void setServiceType(boolean serviceStatus) {
		this.serviceType = serviceStatus;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the roomNumber
	 */
	public int getRoomNumber() {
		return roomNumber;
	}
	/**
	 * @param roomNumber the roomNumber to set
	 */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	/**
	 * @return the time
	 */
	public float getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(float time) {
		this.time = time;
	}

}
