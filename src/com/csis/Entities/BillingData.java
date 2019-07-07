package com.csis.Entities;

public class BillingData {

	private String name = "";
	
	private boolean isRoomReserved = false;
	private boolean isBanquetReserved = false;
	private boolean isRestaurantReserved = false;
	private boolean isHallReserved = false;
	
	/**
	 * @return the isRoomReserved
	 */
	public boolean isRoomReserved() {
		return isRoomReserved;
	}
	/**
	 * @param isRoomReserved the isRoomReserved to set
	 */
	public void setRoomReserved(boolean isRoomReserved) {
		this.isRoomReserved = isRoomReserved;
	}
	/**
	 * @return the isBanquetReserved
	 */
	public boolean isBanquetReserved() {
		return isBanquetReserved;
	}
	/**
	 * @param isBanquetReserved the isBanquetReserved to set
	 */
	public void setBanquetReserved(boolean isBanquetReserved) {
		this.isBanquetReserved = isBanquetReserved;
	}
	/**
	 * @return the isRestaurantReserved
	 */
	public boolean isRestaurantReserved() {
		return isRestaurantReserved;
	}
	/**
	 * @param isRestaurantReserved the isRestaurantReserved to set
	 */
	public void setRestaurantReserved(boolean isRestaurantReserved) {
		this.isRestaurantReserved = isRestaurantReserved;
	}
	/**
	 * @return the isHallReserved
	 */
	public boolean isHallReserved() {
		return isHallReserved;
	}
	/**
	 * @param isHallReserved the isHallReserved to set
	 */
	public void setHallReserved(boolean isHallReserved) {
		this.isHallReserved = isHallReserved;
	}

	private String resType;
	private String roomType = "";
	private int numOfDays = 0;
	private String mealIncludedForRoom = "";
	private String mealTypeForRoom = "";
	private String mealIncludedForBanquet = "";
	private String mealTypeForBanquet = "";
	private String mealIncludedForRestaurant = "";
	private String mealTypeForRestaurant = "";
	private String mealIncludedForHall = "";
	private String mealTypeForHall = "";
	
	private String dateOfreservation = "";
	private String timeReservedFor = "";
	private int hoursHallReservedFor = 0;
	private int additionalServiceNeeded = 0;
	private int numOfGuests = 0;
	private String reservationFor = "";
	private float banquetFee = 0.0f;
	private float roomFee = 0.0f;
	private float restaurantFee = 0.0f;
	private float meetingHallFee = 0.0f;
	
	private float roomUnitCost;
	private static float vegMealUnitCost = 5.99f;
	private static float nonVegMealUnitCost = 7.99f;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}
	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	/**
	 * @return the numOfDays
	 */
	public int getNumOfDays() {
		return numOfDays;
	}
	/**
	 * @param numOfDays the numOfDays to set
	 */
	public void setNumOfDays(int numOfDays) {
		this.numOfDays = numOfDays;
	}
	
	/**
	 * @return the dateOfreservation
	 */
	public String getDateOfreservation() {
		return dateOfreservation;
	}
	/**
	 * @param dateOfreservation the dateOfreservation to set
	 */
	public void setDateOfreservation(String dateOfreservation) {
		this.dateOfreservation = dateOfreservation;
	}
	/**
	 * @return the timeReservedFor
	 */
	public String getTimeReservedFor() {
		return timeReservedFor;
	}
	/**
	 * @param timeReservedFor the timeReservedFor to set
	 */
	public void setTimeReservedFor(String timeReservedFor) {
		this.timeReservedFor = timeReservedFor;
	}
	/**
	 * @return the hoursHallReservedFor
	 */
	public int getHoursHallReservedFor() {
		return hoursHallReservedFor;
	}
	/**
	 * @param hoursHallReservedFor the hoursHallReservedFor to set
	 */
	public void setHoursHallReservedFor(int hoursHallReservedFor) {
		this.hoursHallReservedFor = hoursHallReservedFor;
	}
	/**
	 * @return the additionalServiceNeeded
	 */
	public int getAdditionalServiceNeeded() {
		return additionalServiceNeeded;
	}
	/**
	 * @param additionalServiceNeeded the additionalServiceNeeded to set
	 */
	public void setAdditionalServiceNeeded(int additionalServiceNeeded) {
		this.additionalServiceNeeded = additionalServiceNeeded;
	}
	/**
	 * @return the numOfGuests
	 */
	public int getNumOfGuests() {
		return numOfGuests;
	}
	/**
	 * @param numOfGuests the numOfGuests to set
	 */
	public void setNumOfGuests(int numOfGuests) {
		this.numOfGuests = numOfGuests;
	}
	/**
	 * @return the reservationFor
	 */
	public String getReservationFor() {
		return reservationFor;
	}
	/**
	 * @param reservationFor the reservationFor to set
	 */
	public void setReservationFor(String reservationFor) {
		this.reservationFor = reservationFor;
	}
	
	
	public void processReservationCost()
	{
		setResType();
		setRoomUnitCost(getRoomType());
		addAmount(getResType());
		
	}
	private void setResType() {
		// TODO Auto-generated method stub
		
		if(isRoomReserved)
			resType += "room ";
		if(isRestaurantReserved)
			resType += "restaurant ";
		if(isBanquetReserved)
			resType += "banquet ";
		if(isHallReserved)
			resType += "hall ";
		
	}
	private void setRoomUnitCost(String rmType) {
		// TODO Auto-generated method stub
		
		switch(rmType)
		{
		case "Executive King Double":
			roomUnitCost = 70;
			break;
		case "Executive Queen Double":
			roomUnitCost = 75;
			break;
		case "Executive Queen Single":
			roomUnitCost = 80;
			break;
		case "Deluxe King Double":
			roomUnitCost = 85;
			break;
		case "Deluxe Queen Double":
			roomUnitCost = 90;
			break;
		case "Deluxe Queen Single":
			roomUnitCost = 95;
			break;
		case "Regular Double":
			roomUnitCost = 60;
			break;
		case "Regular Single":
			roomUnitCost = 50;
			break;		
		}
	}
	
	private void addAmount(String resType2) {
		// TODO Auto-generated method stub
		switch(resType)
		{
			case "room":
				if(mealTypeForRoom.equals("Veg"))
					restaurantFee += vegMealUnitCost;
				else if(mealTypeForRoom.equals("Non-Veg"))
					restaurantFee += nonVegMealUnitCost;
				break;
			
		case "banquet":
			banquetFee += 8;
			break;
			
		case "meeting":
			meetingHallFee += 4;
			break;
			
		case "restaurant":
			if(mealIncludedForBanquet.equals("Veg"))
				restaurantFee += vegMealUnitCost;
			else if(mealIncludedForBanquet.equals("Non-Veg"))
				restaurantFee += nonVegMealUnitCost;
			break;
		}
	}
}
