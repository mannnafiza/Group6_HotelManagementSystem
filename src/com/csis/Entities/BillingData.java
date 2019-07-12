package com.csis.Entities;

import java.text.DecimalFormat;

public class BillingData {

	private String name = "";
	private int userId;
	private String date;
	private String time;
	private StringBuilder sb = new StringBuilder();
	private boolean isRoomReserved = false;
	private boolean isBanquetReserved = false;
	private boolean isRestaurantReserved = false;
	private boolean isHallReserved = false;
	
	private String resType;
	private String roomType = "";
	private int numOfDays = 0;
	
	private boolean mealIncludedForRoom;
	private String mealTypeForRoom = "";
	private boolean mealIncludedForBanquet;
	private String mealTypeForBanquet = "";
	private boolean mealIncludedForRestaurant;
	private String mealTypeForRestaurant = "";
	private boolean mealIncludedForHall;
	private String mealTypeForHall = "";

	private String dateRoomReservedFor = "";
	private String dateRestaurantReservedFor = "";
	private String dateBanquetReservedFor = "";
	private String dateHallReservedFor = "";

	private String timeRoomReservedFor = "";
	private String timeRestaurantReservedFor = "";
	private String timeBanquetReservedFor = "";
	private String timeHallReservedFor = "";

	private boolean roomAdditionalServiceNeeded;
	private boolean banquetAdditionalServiceNeeded;
	private String roomAdServcType = "";
	private String banquetAdServcType = "";
	private boolean roomadServiceMealNeeded;
	private boolean banquetadServiceMealNeeded;
	private boolean roomadServiceHKNeeded;
	private boolean banquetadServiceHKlNeeded;
	private String roomAdServcMealType;
	private String banquetAdServcMealType;

	private int durationOfMeeting = 0;
	private int numOfGuests = 0;
	private String reservationFor = "";

	private float banquetFee = 0.0f;
	private float roomFee = 0.0f;
	private float restaurantFee = 0.0f;
	private float meetingHallFee = 0.0f;

	private float roomUnitCost;
	private float roomAdditionalCharges = 0.0f;
	private float banquetAdditionalCharges = 0.0f;
	private float totalFee = 0.0f;
	private float discount = 0.0f;
	private float finalAmount;
	
	private float banquetUnitFee = 150.49f;
	private float seatBookingFee = 14.99f;
	private static float VEG_MEAL_UNIT_COST = 5.99f;
	private static float NON_VEG_MEAL_UNIT_COST = 7.99f;
	private static float HOUSE_KEEPING_UNIT_COST = 15.0f;
	private static float PER_HOUR_HALL_FEE = 50;
	private static float HALL_MEAL_COST = 250;
	private static float BANQUET_MEAL__COST = 500;
	DecimalFormat df = new DecimalFormat("#.00");

	
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

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
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

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

	/**
	 * @return the resType
	 */
	public String getResType() {
		return resType;
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

	/**
	 * @return the mealIncludedForRoom
	 */
	public boolean isMealIncludedForRoom() {
		return mealIncludedForRoom;
	}

	/**
	 * @param mealIncludedForRoom the mealIncludedForRoom to set
	 */
	public void setMealIncludedForRoom(boolean mealIncludedForRoom) {
		this.mealIncludedForRoom = mealIncludedForRoom;
	}

	/**
	 * @return the mealTypeForRoom
	 */
	public String getMealTypeForRoom() {
		return mealTypeForRoom;
	}

	/**
	 * @param mealTypeForRoom the mealTypeForRoom to set
	 */
	public void setMealTypeForRoom(String mealTypeForRoom) {
		this.mealTypeForRoom = mealTypeForRoom;
	}

	/**
	 * @return the mealIncludedForBanquet
	 */
	public boolean isMealIncludedForBanquet() {
		return mealIncludedForBanquet;
	}

	/**
	 * @param mealIncludedForBanquet the mealIncludedForBanquet to set
	 */
	public void setMealIncludedForBanquet(boolean mealIncludedForBanquet) {
		this.mealIncludedForBanquet = mealIncludedForBanquet;
	}

	/**
	 * @return the mealTypeForBanquet
	 */
	public String getMealTypeForBanquet() {
		return mealTypeForBanquet;
	}

	/**
	 * @param mealTypeForBanquet the mealTypeForBanquet to set
	 */
	public void setMealTypeForBanquet(String mealTypeForBanquet) {
		this.mealTypeForBanquet = mealTypeForBanquet;
	}

	/**
	 * @return the mealIncludedForRestaurant
	 */
	public boolean isMealIncludedForRestaurant() {
		return mealIncludedForRestaurant;
	}

	/**
	 * @param mealIncludedForRestaurant the mealIncludedForRestaurant to set
	 */
	public void setMealIncludedForRestaurant(boolean mealIncludedForRestaurant) {
		this.mealIncludedForRestaurant = mealIncludedForRestaurant;
	}

	/**
	 * @return the mealTypeForRestaurant
	 */
	public String getMealTypeForRestaurant() {
		return mealTypeForRestaurant;
	}

	/**
	 * @param mealTypeForRestaurant the mealTypeForRestaurant to set
	 */
	public void setMealTypeForRestaurant(String mealTypeForRestaurant) {
		this.mealTypeForRestaurant = mealTypeForRestaurant;
	}

	/**
	 * @return the mealIncludedForHall
	 */
	public boolean isMealIncludedForHall() {
		return mealIncludedForHall;
	}

	/**
	 * @param mealIncludedForHall the mealIncludedForHall to set
	 */
	public void setMealIncludedForHall(boolean mealIncludedForHall) {
		this.mealIncludedForHall = mealIncludedForHall;
	}

	/**
	 * @return the mealTypeForHall
	 */
	public String getMealTypeForHall() {
		return mealTypeForHall;
	}

	/**
	 * @param mealTypeForHall the mealTypeForHall to set
	 */
	public void setMealTypeForHall(String mealTypeForHall) {
		this.mealTypeForHall = mealTypeForHall;
	}

	/**
	 * @return the dateRoomReservedFor
	 */
	public String getDateRoomReservedFor() {
		return dateRoomReservedFor;
	}

	/**
	 * @param dateRoomReservedFor the dateRoomReservedFor to set
	 */
	public void setDateRoomReservedFor(String dateRoomReservedFor) {
		this.dateRoomReservedFor = dateRoomReservedFor;
	}

	/**
	 * @return the dateRestaurantReservedFor
	 */
	public String getDateRestaurantReservedFor() {
		return dateRestaurantReservedFor;
	}

	/**
	 * @param dateRestaurantReservedFor the dateRestaurantReservedFor to set
	 */
	public void setDateRestaurantReservedFor(String dateRestaurantReservedFor) {
		this.dateRestaurantReservedFor = dateRestaurantReservedFor;
	}

	/**
	 * @return the dateBanquetReservedFor
	 */
	public String getDateBanquetReservedFor() {
		return dateBanquetReservedFor;
	}

	/**
	 * @param dateBanquetReservedFor the dateBanquetReservedFor to set
	 */
	public void setDateBanquetReservedFor(String dateBanquetReservedFor) {
		this.dateBanquetReservedFor = dateBanquetReservedFor;
	}

	/**
	 * @return the dateHallReservedFor
	 */
	public String getDateHallReservedFor() {
		return dateHallReservedFor;
	}

	/**
	 * @param dateHallReservedFor the dateHallReservedFor to set
	 */
	public void setDateHallReservedFor(String dateHallReservedFor) {
		this.dateHallReservedFor = dateHallReservedFor;
	}

	/**
	 * @return the timeRoomReservedFor
	 */
	public String getTimeRoomReservedFor() {
		return timeRoomReservedFor;
	}

	/**
	 * @param timeRoomReservedFor the timeRoomReservedFor to set
	 */
	public void setTimeRoomReservedFor(String timeRoomReservedFor) {
		this.timeRoomReservedFor = timeRoomReservedFor;
	}

	/**
	 * @return the timeRestaurantReservedFor
	 */
	public String getTimeRestaurantReservedFor() {
		return timeRestaurantReservedFor;
	}

	/**
	 * @param timeRestaurantReservedFor the timeRestaurantReservedFor to set
	 */
	public void setTimeRestaurantReservedFor(String timeRestaurantReservedFor) {
		this.timeRestaurantReservedFor = timeRestaurantReservedFor;
	}

	/**
	 * @return the timeBanquetReservedFor
	 */
	public String getTimeBanquetReservedFor() {
		return timeBanquetReservedFor;
	}

	/**
	 * @param timeBanquetReservedFor the timeBanquetReservedFor to set
	 */
	public void setTimeBanquetReservedFor(String timeBanquetReservedFor) {
		this.timeBanquetReservedFor = timeBanquetReservedFor;
	}

	/**
	 * @return the timeHallReservedFor
	 */
	public String getTimeHallReservedFor() {
		return timeHallReservedFor;
	}

	/**
	 * @param timeHallReservedFor the timeHallReservedFor to set
	 */
	public void setTimeHallReservedFor(String timeHallReservedFor) {
		this.timeHallReservedFor = timeHallReservedFor;
	}

	/**
	 * @return the roomAdditionalServiceNeeded
	 */
	public boolean isRoomAdditionalServiceNeeded() {
		return roomAdditionalServiceNeeded;
	}

	/**
	 * @param roomAdditionalServiceNeeded the roomAdditionalServiceNeeded to set
	 */
	public void setRoomAdditionalServiceNeeded(boolean roomAdditionalServiceNeeded) {
		this.roomAdditionalServiceNeeded = roomAdditionalServiceNeeded;
	}

	/**
	 * @return the banquetAdditionalServiceNeeded
	 */
	public boolean isBanquetAdditionalServiceNeeded() {
		return banquetAdditionalServiceNeeded;
	}

	/**
	 * @param banquetAdditionalServiceNeeded the banquetAdditionalServiceNeeded to
	 *                                       set
	 */
	public void setBanquetAdditionalServiceNeeded(boolean banquetAdditionalServiceNeeded) {
		this.banquetAdditionalServiceNeeded = banquetAdditionalServiceNeeded;
	}

	/**
	 * @return the roomAdServcType
	 */
	public String getRoomAdServcType() {
		return roomAdServcType;
	}

	/**
	 * @param roomAdServcType the roomAdServcType to set
	 */
	public void setRoomAdServcType(String roomAdServcType) {
		this.roomAdServcType = roomAdServcType;
	}

	/**
	 * @return the banquetAdServcType
	 */
	public String getBanquetAdServcType() {
		return banquetAdServcType;
	}

	/**
	 * @param banquetAdServcType the banquetAdServcType to set
	 */
	public void setBanquetAdServcType(String banquetAdServcType) {
		this.banquetAdServcType = banquetAdServcType;
	}

	/**
	 * @return the roomAdServcMealType
	 */
	public String getRoomAdServcMealType() {
		return roomAdServcMealType;
	}

	/**
	 * @param roomAdServcMealType the roomAdServcMealType to set
	 */
	public void setRoomAdServcMealType(String roomAdServcMealType) {
		this.roomAdServcMealType = roomAdServcMealType;
	}

	/**
	 * @return the banquetAdServcMealType
	 */
	public String getBanquetAdServcMealType() {
		return banquetAdServcMealType;
	}

	/**
	 * @param banquetAdServcMealType the banquetAdServcMealType to set
	 */
	public void setBanquetAdServcMealType(String banquetAdServcMealType) {
		this.banquetAdServcMealType = banquetAdServcMealType;
	}

	/**
	 * @return the durationOfMeeting
	 */
	public int getDurationOfMeeting() {
		return durationOfMeeting;
	}

	/**
	 * @param durationOfMeeting the durationOfMeeting to set
	 */
	public void setDurationOfMeeting(int durationOfMeeting) {
		this.durationOfMeeting = durationOfMeeting;
	}

	
	/**
	 * @return the totalFee
	 */
	public float getTotalFee() {
		return totalFee;
	}

	/**
	 * @return the discount
	 */
	public float getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(float discount) {
		this.discount = discount;
	}

	/**
	 * @return the finalAmount
	 */
	public float getFinalAmount() {
		return finalAmount;
	}

	/**
	 * @return the roomadServiceMealNeeded
	 */
	public boolean isRoomadServiceMealNeeded() {
		return roomadServiceMealNeeded;
	}

	/**
	 * @param roomadServiceMealNeeded the roomadServiceMealNeeded to set
	 */
	public void setRoomadServiceMealNeeded(boolean roomadServiceMealNeeded) {
		this.roomadServiceMealNeeded = roomadServiceMealNeeded;
	}

	/**
	 * @return the banquetadServiceMealNeeded
	 */
	public boolean isBanquetadServiceMealNeeded() {
		return banquetadServiceMealNeeded;
	}

	/**
	 * @param banquetadServiceMealNeeded the banquetadServiceMealNeeded to set
	 */
	public void setBanquetadServiceMealNeeded(boolean banquetadServiceMealNeeded) {
		this.banquetadServiceMealNeeded = banquetadServiceMealNeeded;
	}

	/**
	 * @return the roomadServiceHKNeeded
	 */
	public boolean isRoomadServiceHKNeeded() {
		return roomadServiceHKNeeded;
	}

	/**
	 * @param roomadServiceHKNeeded the roomadServiceHKNeeded to set
	 */
	public void setRoomadServiceHKNeeded(boolean roomadServiceHKNeeded) {
		this.roomadServiceHKNeeded = roomadServiceHKNeeded;
	}

	/**
	 * @return the banquetadServiceHKlNeeded
	 */
	public boolean isBanquetadServiceHKlNeeded() {
		return banquetadServiceHKlNeeded;
	}

	/**
	 * @param banquetadServiceHKlNeeded the banquetadServiceHKlNeeded to set
	 */
	public void setBanquetadServiceHKlNeeded(boolean banquetadServiceHKlNeeded) {
		this.banquetadServiceHKlNeeded = banquetadServiceHKlNeeded;
	}

	
	/**
	 * @return the banquetFee
	 */
	public float getBanquetFee() {
		return banquetFee;
	}

	/**
	 * @param banquetFee the banquetFee to set
	 */
	public void setBanquetFee(float banquetFee) {
		this.banquetFee = banquetFee;
	}

	/**
	 * @return the roomFee
	 */
	public float getRoomFee() {
		return roomFee;
	}

	/**
	 * @param roomFee the roomFee to set
	 */
	public void setRoomFee(float roomFee) {
		this.roomFee = roomFee;
	}

	/**
	 * @return the restaurantFee
	 */
	public float getRestaurantFee() {
		return restaurantFee;
	}

	/**
	 * @param restaurantFee the restaurantFee to set
	 */
	public void setRestaurantFee(float restaurantFee) {
		this.restaurantFee = restaurantFee;
	}

	/**
	 * @return the meetingHallFee
	 */
	public float getMeetingHallFee() {
		return meetingHallFee;
	}

	/**
	 * @param meetingHallFee the meetingHallFee to set
	 */
	public void setMeetingHallFee(float meetingHallFee) {
		this.meetingHallFee = meetingHallFee;
	}

	/**
	 * @param totalFee the totalFee to set
	 */
	public void setTotalFee(float totalFee) {
		this.totalFee = totalFee;
	}

	/**
	 * @param finalAmount the finalAmount to set
	 */
	public void setFinalAmount(float finalAmount) {
		this.finalAmount = finalAmount;
	}

	//method to prepare format of final bill
	public String prepareBill() {
		// TODO Auto-generated method stub

		if (isRoomAdditionalServiceNeeded()) {
			if(isRoomadServiceMealNeeded())
				roomAdServcType += " Meal ";
			if(isRoomadServiceHKNeeded())
				roomAdServcType += " HouseKeeping ";
		}
		if (isBanquetAdditionalServiceNeeded()) {
			if(isBanquetadServiceMealNeeded())
				banquetAdServcType += " Meal ";
			if(isBanquetadServiceHKlNeeded())
				banquetAdServcType += " HouseKeeping ";
		}
		totalFee = totalAmount();
		addRoomEntryToReceipt();
		addRestaurantEntryToReceipt();
		addbanquetEntryToReceipt();
		addHallEntryToReceipt();
		sb.append("\n\n\t\t\t\t\tTotal Amount:\t$" + totalFee + "\n");
		
		
		//code to give discount to staff members
		//discount = 10.00f;
		sb.append("\t\t\t\t\tDiscount:\t$" + df.format(discount) + "\n");
		totalFee -= discount;
		sb.append("\t\t\t\t\tGST / PST(5%):\t$" + df.format(totalFee * 0.05) + "\n");
		finalAmount = (float) (totalFee + (totalFee * 0.05));
		sb.append("\t\t\t\t\t Balance due:\t$" + df.format(finalAmount));
		return sb.toString();
	}

	// method to create receipt format for meeting hall reservation fields
	private void addHallEntryToReceipt() {
		// TODO Auto-generated method stub

		System.out.println("Hall Reserved: "+ isHallReserved());
		if (isHallReserved())
		{
			sb.append("\n* Meeting Hall *\n");
			sb.append("Reserved for:\t\tDate: " + getDateHallReservedFor() + "\tTime: " + getTimeHallReservedFor() + "\n");
			sb.append("Single Hall type: \t\t\t\t\tPer Hour Cost:\t\t$" + PER_HOUR_HALL_FEE + "\n");
			if (isMealIncludedForHall()) {
				sb.append("Meal Included:\t\tYES");
				//sb.append("\tType: " + getMealTypeForRoom());
				sb.append("\t\t\t\tMeal Cost:\t\t$" + HALL_MEAL_COST + "\n");
			}
			sb.append("Duration of Meeting:\t" + getDurationOfMeeting() + "hour(s)\n");
			sb.append("\t\t\t\t\t\tTotal Hall Cost:\t$" + df.format(meetingHallFee) + "\n");
		}
	}

	// method to create receipt format for banquet reservation fields
	private void addbanquetEntryToReceipt() {
		// TODO Auto-generated method stub
		System.out.println("banquet Reserved: "+ isBanquetReserved());
		if (isBanquetReserved()) {
			sb.append("\n* Banquet *\n");
			sb.append("Reserved for:\t\tDate: " + getDateBanquetReservedFor() + "\tTime: " + getTimeBanquetReservedFor()
					+ "\n");
			sb.append("Single Banquet hall type: \t\t\t\t\tUnit Cost:\t\t$" + banquetUnitFee + "\n");
			if (isMealIncludedForBanquet()) {
				sb.append("Meal Included:\t\tYES");
				// sb.append("\tType: " + getMealTypeForRoom());
				sb.append("\t\t\t\tMeal Cost:\t\t$" + BANQUET_MEAL__COST + "\n");
			}
			if (isBanquetAdditionalServiceNeeded())
			{
				sb.append("Additional Services:\t" + banquetAdServcType + "\t\t\tAdditional Services Cost:\t$"
						+ banquetAdditionalCharges + "\n");
			}
			sb.append("\t\t\t\t\t\tTotal Banquet Cost:\t$" + df.format(banquetFee) + "\n");
		}
	}

	// method to create receipt format for restaurant reservation fields
	private void addRestaurantEntryToReceipt() {
		// TODO Auto-generated method stub
		System.out.println("restaurant Reserved: "+ isRestaurantReserved());
		if (isRestaurantReserved())
		{
			sb.append("\n* Restaurant *\n");
			sb.append("Reserved for:\t\tDate: " + getDateRestaurantReservedFor() + "\tTime: " + getTimeRestaurantReservedFor()
			+ "\t\tMeal of Day Type:\t" + getReservationFor() + "\n");
			sb.append("Single Restaurant type: \t\t\t\t\tUnit Cost:\t\t$" + seatBookingFee + "\n");
			sb.append("Meal Type:\t\t" + getMealTypeForRestaurant() + "\t\t\t\tMeal Cost:\t\t$" + VEG_MEAL_UNIT_COST + "\n");
			sb.append("Number of people:\t" + getNumOfGuests() + "person(s)\n");
			sb.append("\t\t\t\t\t\tTotal Restaurant Cost:\t$" + df.format(restaurantFee) + "\n");
		}
	}

	// method to create receipt format for room reservation fields
	private void addRoomEntryToReceipt() {
		// TODO Auto-generated method stub
		System.out.println("room Reserved: "+ isRoomReserved());
		if (isRoomReserved()) {
			sb.append("\n* Room *\n");
			sb.append("Reserved for:\t\tDate: " + getDateRoomReservedFor() + "\tTime: " + getTimeRoomReservedFor()
					+ "\n");
			sb.append("Room Type:\t\t" + getRoomType() + "\t\t\tUnit Cost:\t\t$" + roomUnitCost + "\n");
			if (isMealIncludedForRoom()) {
				sb.append("Meal Included:\t\tYES");
				// sb.append("\tType: " + getMealTypeForRoom());
				sb.append("\t\t\t\tMeal Cost:\t\t$" + VEG_MEAL_UNIT_COST + "\n");
			}
			sb.append("Stay Duration:\t\t" + getNumOfDays() + "day(s)\n");
			if (isRoomAdditionalServiceNeeded())
			{
				System.out.println("Room Ad service: "+ roomAdServcType);
				sb.append("Additional Services:\t" + roomAdServcType + "\t\t\tAdditional Services Cost:\t$"
						+ roomAdditionalCharges + "\n");
			}
			sb.append("\t\t\t\t\t\tTotal Room Cost:\t$" + df.format(roomFee) + "\n");
		}
	}

	//method to set price according to room type chosen by the customer
	public void setRoomUnitCost(String rmType) {
		// TODO Auto-generated method stub

		switch (rmType) {
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
		default:
			break;
		}
	}

	//method to compute total amount for reservation without discount
	private float totalAmount() {
		// TODO Auto-generated method stub

		if (isRoomReserved) {
			roomFee += roomUnitCost * numOfDays;
			System.out.println("days: " + numOfDays + "total : " + roomFee);
			
			if (isMealIncludedForRoom())
				roomFee += VEG_MEAL_UNIT_COST;
			
			if (isRoomAdditionalServiceNeeded()) {
				if (roomAdServcType.contains("Meal")) {
					
					roomAdditionalCharges += VEG_MEAL_UNIT_COST;
				}
				if (roomAdServcType.contains("HouseKeeping")) {
					roomAdditionalCharges += HOUSE_KEEPING_UNIT_COST;
				}
				roomFee += roomAdditionalCharges;
			}		
			System.out.println("Total room fee: " + roomFee + "days: "+ getNumOfDays());
		}

		if (isBanquetReserved) {
			banquetFee += banquetUnitFee;
			if (isMealIncludedForRoom())
				banquetFee += BANQUET_MEAL__COST;
			if (banquetAdditionalServiceNeeded) {
				if (banquetAdServcType.contains("meal")) {
					banquetAdditionalCharges += VEG_MEAL_UNIT_COST;
				}
				if (banquetAdServcType.contains("house-keeping")) {
					banquetAdditionalCharges += HOUSE_KEEPING_UNIT_COST;
				}
				banquetFee += banquetAdditionalCharges;
			}
		}
	
		  if (isHallReserved) {
			  
			 meetingHallFee += PER_HOUR_HALL_FEE * getDurationOfMeeting();
			  
			  if (isMealIncludedForRoom())
				  meetingHallFee += HALL_MEAL_COST;			  
			  }
		 
		if (isRestaurantReserved) {

			if (mealTypeForRestaurant.equals("Veg"))
				restaurantFee += VEG_MEAL_UNIT_COST;
			else if (mealTypeForRestaurant.equals("Non-Veg"))
				restaurantFee += NON_VEG_MEAL_UNIT_COST;

				restaurantFee += restaurantFee * getNumOfGuests();
			
			restaurantFee += seatBookingFee;
			System.out.println("Total rest fee: " + restaurantFee + "guests: "+ getNumOfGuests());
		}

		totalFee = roomFee + banquetFee + restaurantFee + meetingHallFee;
		return totalFee;
	}
	
	
}
