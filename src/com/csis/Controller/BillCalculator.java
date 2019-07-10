package com.csis.Controller;

import java.util.ArrayList;

import com.csis.Boundary.CustomerReceipt;
import com.csis.Boundary.DBHelper;
import com.csis.Entities.BillingData;
import com.csis.Entities.UserInfo;

public class BillCalculator {

	DBHelper helper = new DBHelper();
	BillingData bill = new BillingData();
	ArrayList<String> roomlist = new ArrayList<>();
	ArrayList<String> banquetlist = new ArrayList<>();
	ArrayList<String> restaurantlist = new ArrayList<>();
	ArrayList<String> meetinghalllist = new ArrayList<>();
	String resType = "";
	
	//method to make use of DBHelper instance to fetch data from reservation_info table 
	//and set the class fields of BillingData entity class
	public void calculate(UserInfo user) {
		// TODO Auto-generated method stub
		
		//set name of user for receipt
		bill.setName(user.getUsername());
		
		//processing room reservation entries
		roomlist = helper.getReservationData(user,"room");
		for(String str: roomlist)
		{
			System.out.println("Item: "+ str);
			//break;
		}
		if(roomlist.size() > 0)
		{
			bill.setRoomReserved(true);
			bill.setRoomType(roomlist.get(2));
			bill.setRoomUnitCost(bill.getRoomType());
			bill.setNumOfDays(Integer.parseInt(roomlist.get(3)));
			String status = roomlist.get(4);
			if(status.equals("yes"))
			{
				bill.setMealIncludedForRoom(true);
				bill.setMealTypeForRoom(roomlist.get(5));
			}
			bill.setDateRoomReservedFor(roomlist.get(6));
			bill.setTimeRoomReservedFor(roomlist.get(7));
			
			System.out.println("add Service=======: " + roomlist.get(9));
			String adServiceStatus = roomlist.get(9);
			if(adServiceStatus.equals("1"))
				bill.setRoomAdditionalServiceNeeded(true);
		}else
			bill.setRoomReserved(false);
			
		//processing banquet reservation entries
		banquetlist = helper.getReservationData(user,"banquet");
		for(String str: banquetlist)
		{
			System.out.println("Item: "+ str);
			//break;
		}
		if(banquetlist.size() > 0)
		{
			bill.setBanquetReserved(true);			
			String status = banquetlist.get(4);
			if(status.equals("yes"))
			{
				bill.setMealIncludedForBanquet(true);
				bill.setMealTypeForBanquet(banquetlist.get(5));
			}
			bill.setDateBanquetReservedFor(banquetlist.get(6));
			bill.setTimeBanquetReservedFor(banquetlist.get(7));	
			String adServiceStatus = banquetlist.get(9);
			if(adServiceStatus.equals("1"))
				bill.setBanquetAdditionalServiceNeeded(true);
		}else
			bill.setBanquetReserved(true);
		
		//processing restaurant reservation entries
		restaurantlist = helper.getReservationData(user,"restaurant");
		for(String str: restaurantlist)
		{
			System.out.println("Item: "+ str);
			//break;
		}
		if(restaurantlist.size() > 0)
		{
			bill.setRestaurantReserved(true);		
			//String status = restaurantlist.get(4);
			//if(status.equals("yes"))
			//{
				//bill.setMealIncludedForRestaurant(true);
				bill.setMealTypeForRestaurant(restaurantlist.get(5));
			//}
			bill.setDateRestaurantReservedFor(restaurantlist.get(6));
			bill.setTimeRestaurantReservedFor(restaurantlist.get(7));
			bill.setNumOfGuests(Integer.parseInt(restaurantlist.get(10)));
			bill.setReservationFor(restaurantlist.get(11));
		}else
			bill.setRestaurantReserved(false);	

		
		//processing meeting hall reservation entries
		meetinghalllist = helper.getReservationData(user,"meeting");
		for(String str: meetinghalllist)
		{
			System.out.println("Item: "+ str);
			//break;
		}
		if(meetinghalllist.size() > 0)
		{
			bill.setHallReserved(true);			
			String status = meetinghalllist.get(4);
			if(status.equals("yes"))
			{
				bill.setMealIncludedForHall(true);
				//bill.setMealTypeForHall("Veg");
			}
			bill.setDateHallReservedFor((meetinghalllist.get(6)));
			bill.setTimeHallReservedFor(meetinghalllist.get(7));
			bill.setDurationOfMeeting(Integer.parseInt(meetinghalllist.get(8)));	
		}else
			bill.setHallReserved(false);	
		
		//method call to display receipt to the user in next frame
		CustomerReceipt.main(null,bill);
	}
	
	
	
}
