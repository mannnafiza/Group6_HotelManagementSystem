package com.csis.Controller;

import java.util.ArrayList;

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
	
	public void calculate(UserInfo user) {
		// TODO Auto-generated method stub
		
		roomlist = helper.getRoomReservationData(user);
		if(roomlist.size() > 0)
		{
			System.out.println("Name: " + roomlist.get(0));
			bill.setName(roomlist.get(0));
			bill.setRoomReserved(true);
			bill.setRoomType(roomlist.get(2));
			bill.setNumOfDays(Integer.parseInt(roomlist.get(3)));
			String status = roomlist.get(4);
			//if(status.equals("yes"))
				//bill.setMealTypeForRoom(roomlist.get(5));
			
		}
		 
		banquetlist = helper.getBanquetReservationData(user);
		for(String str: banquetlist)
		{
			System.out.println("Item: "+ str);
			//break;
		}
		

		banquetlist = helper.getRestaurantReservationData(user);
		for(String str: banquetlist)
		{
			System.out.println("Item: "+ str);
			//break;
		}

		banquetlist = helper.getMeetingHallsReservationData(user);
		for(String str: banquetlist)
		{
			System.out.println("Item: "+ str);
			//break;
		}
		
		bill.processReservationCost();
	}
	
	
	
}
