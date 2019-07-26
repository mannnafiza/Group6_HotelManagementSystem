package com.csis.Entities;

public class Service {
	
	private String customerName  = "";
	private String resType;
	private String mealNeeded ; 
	private String houseKeepingNeeded ; 
	private String mealType;
	private float time = 0;
	
	
	/**
	 * constructor		
	 */
	public Service()
	{
		
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
	/**
	 * @return the mealType
	 */
	public String getMealType() {
		return mealType;
	}
	/**
	 * @param mealType the mealType to set
	 */
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	/**
	 * @return the resType
	 */
	public String getResType() {
		return resType;
	}
	/**
	 * @param resType the resType to set
	 */
	public void setResType(String resType) {
		this.resType = resType;
	}
	/**
	 * @return the mealNeeded
	 */
	public String getMealNeeded() {
		return mealNeeded;
	}
	/**
	 * @param mealNeeded the mealNeeded to set
	 */
	public void setMealNeeded(String mealNeeded) {
		this.mealNeeded = mealNeeded;
	}
	/**
	 * @return the houseKeepingNeeded
	 */
	public String getHouseKeepingNeeded() {
		return houseKeepingNeeded;
	}
	/**
	 * @param houseKeepingNeeded the houseKeepingNeeded to set
	 */
	public void setHouseKeepingNeeded(String houseKeepingNeeded) {
		this.houseKeepingNeeded = houseKeepingNeeded;
	}
	

}
