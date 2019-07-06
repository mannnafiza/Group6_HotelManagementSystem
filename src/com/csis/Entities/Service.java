package com.csis.Entities;

public class Service {
	
	private String customerName  = "";
	private int roomNumber  = 0 ;
	private float time = 0;
	private String serviceTypeMeal ; 
	private String serviceTypeHouseKeeping ; 
	private String serviceType;
	
	/**
	 * @return the serviceTypeMeal
	 */
	public String getServiceTypeMeal() {
		return serviceTypeMeal;
	}
	/**
	 * @param serviceTypeMeal the serviceTypeMeal to set
	 */
	public void setServiceTypeMeal(String serviceTypeMeal) {
		this.serviceTypeMeal = serviceTypeMeal;
	}
	/**
	 * @return the serviceTypeHouseKeeping
	 */
	public String getServiceTypeHouseKeeping() {
		return serviceTypeHouseKeeping;
	}
	/**
	 * @param serviceTypeHouseKeeping the serviceTypeHouseKeeping to set
	 */
	public void setServiceTypeHouseKeeping(String serviceTypeHouseKeeping) {
		this.serviceTypeHouseKeeping = serviceTypeHouseKeeping;
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
	/**
	 * @return the serviceType
	 */
	/**
	 * @return the serviceType
	 */
	public String getServiceType() {
		return serviceType;
	}
	/**
	 * @param serviceType the serviceType to set
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	

}
