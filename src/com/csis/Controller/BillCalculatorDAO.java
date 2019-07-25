package com.csis.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.csis.Boundary.CustomerBill;
import com.csis.Boundary.DBHelper;
import com.csis.Entities.BillingData;
import com.csis.Entities.UserInfo;

public class BillCalculatorDAO {

	DBHelper helper = new DBHelper();
	BillingData bill = new BillingData();
	private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	ArrayList<String> roomlist = new ArrayList<>();
	ArrayList<String> banquetlist = new ArrayList<>();
	ArrayList<String> restaurantlist = new ArrayList<>();
	ArrayList<String> meetinghalllist = new ArrayList<>();
	ArrayList<String> adServiceList = new ArrayList<>();
	String resType = "";
	
	//method to make use of DBHelper instance to fetch data from reservation_info table 
	//and set the class fields of BillingData entity class
	public void calculate(UserInfo user) {
		// TODO Auto-generated method stub
		
		//set name of user for receipt
		bill.setName(user.getUsername());
		bill.setUserId(user.getId());
		
		//processing room reservation entries
		roomlist = getReservationData(user,"room");
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
			{
				bill.setRoomAdditionalServiceNeeded(true);
				adServiceList = getRoomServiceData(user, "Room");
				for(String str: adServiceList)
				{
					System.out.println("Item: "+ str);
					//break;
				}
				if(adServiceList.size() > 0)
				{
				if(adServiceList.get(1).equals("Yes"))
					bill.setRoomadServiceMealNeeded(true);
				if(adServiceList.get(2).equals("Yes"))
					bill.setRoomadServiceHKNeeded(true);
				bill.setRoomAdServcMealType(adServiceList.get(3));
				}else
				{
					System.out.println("Nothing fetched");
				}
			}
		}else
			bill.setRoomReserved(false);
			
		//processing banquet reservation entries
		banquetlist = getReservationData(user,"banquet");
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
			{
				bill.setBanquetAdditionalServiceNeeded(true);
				adServiceList = getRoomServiceData(user, "Banquet");
				if(adServiceList.size() > 0)
				{
				if(adServiceList.get(1).equals("Yes"))
					bill.setBanquetadServiceMealNeeded(true);
				if(adServiceList.get(2).equals("Yes"))
					bill.setBanquetadServiceHKlNeeded(true);
					bill.setBanquetAdServcMealType(adServiceList.get(3));
				}
			}
		}else
			bill.setBanquetReserved(false);
		
		//processing restaurant reservation entries
		restaurantlist = getReservationData(user,"restaurant");
		for(String str: restaurantlist)
		{
			System.out.println("Item: "+ str);
			//break;
		}
		if(restaurantlist.size() > 0)
		{
			bill.setRestaurantReserved(true);		
			bill.setMealTypeForRestaurant(restaurantlist.get(5));
			bill.setDateRestaurantReservedFor(restaurantlist.get(6));
			bill.setTimeRestaurantReservedFor(restaurantlist.get(7));
			bill.setNumOfGuests(Integer.parseInt(restaurantlist.get(10)));
			bill.setReservationFor(restaurantlist.get(11));
		}else
			bill.setRestaurantReserved(false);	

		
		//processing meeting hall reservation entries
		meetinghalllist = getReservationData(user,"meeting");
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
			}
			bill.setDateHallReservedFor((meetinghalllist.get(6)));
			bill.setTimeHallReservedFor(meetinghalllist.get(7));
			bill.setDurationOfMeeting(Integer.parseInt(meetinghalllist.get(8)));	
		}else
			bill.setHallReserved(false);	
		
		//set time and date of bill generation and set BillingData class fields accordingly
		Date currentDate = new Date();
		String date = DateFormat.getDateInstance().format(currentDate); 
		bill.setDate(date);
		String time = DateFormat.getTimeInstance().format(currentDate);
		bill.setTime(time);

		//method call to display receipt to the user in next frame
		CustomerBill.main(null,bill,user);
	}
	
	/**
	 * 
	 * @param user, instance of UserInfo Entity class
	 * @param type, reservationType for this user
	 * @return list of rooms/banquet/restaurant/meeting hall reserved by this user
	 */
	 //method to obtain data from reservation_info table
	public ArrayList<String> getReservationData(UserInfo user, String type) {
	  
	  String sql = "SELECT * FROM reservation_info where userName = ? and resType = ?";
	  ArrayList<String> list = new ArrayList<>();
	  
	  try {
		  helper.connectDB();
	  
		  //create statement 
		  pstmt = helper.getConnection().prepareStatement(sql);
	  	  
		  pstmt.setString(1, user.getUsername());
		  pstmt.setString(2, type);
		  rs = pstmt.executeQuery(); 
		  while(rs.next())
		  {
			  list.add(rs.getString("userName"));
			  list.add(rs.getString("resType"));
			  list.add(rs.getString("roomType"));
			  list.add(Integer.toString(rs.getInt("stayDuration")));
			  list.add(rs.getString("mealStatus"));
			  list.add(rs.getString("mealType"));
			  list.add(rs.getDate("resDate").toString());
			  list.add(rs.getString("resTime"));
			  list.add(Integer.toString(rs.getInt("meetingDuration")));
			  list.add(Integer.toString(rs.getInt("addService")));
			  list.add(Integer.toString(rs.getInt("noGuest")));
			  list.add(rs.getString("resFor"));
		  }
	  
	  helper.disconnectDB();
	  }catch(SQLException sx)
	  {
		  System.out.println("Error fetching data from the database");
		  System.out.println(sx.getMessage());
		  System.out.println(sx.getErrorCode());
		  System.out.println(sx.getSQLState()); 
	  }
	  
	  return list;  
	}
	
	/**
	 * 
	* @param user, instance of UserInfo Entity class
	 * @param type, reservationType for this user
	 * @return list of rooms/banquet additional services ordered by this user
	 */
	//method to obtain data from roomservice_info table
		public ArrayList<String> getRoomServiceData(UserInfo user, String type) {
			// TODO Auto-generated method stub
			
			String sql = "SELECT * FROM roomservice_info where customerName = ? and resType = ?";
			  ArrayList<String> list = new ArrayList<>();
			  
			  try {
				  helper.connectDB();
			  
				  //create statement 
				  pstmt = helper.getConnection().prepareStatement(sql);
			  	  
				  pstmt.setString(1, user.getUsername());
				  pstmt.setString(2, type);
				  rs = pstmt.executeQuery(); 
				  while(rs.next())
				  {
					  list.add(Integer.toString(rs.getInt("roomNumber")));
					  list.add(rs.getString("mealNeeded"));
					  list.add(rs.getString("houseKeepingNeeded"));
					  list.add(rs.getString("mealType"));
				  }
			  
			  helper.disconnectDB();
			  }catch(SQLException sx)
			  {
				  System.out.println("Error fetching data from the database");
				  System.out.println(sx.getMessage());
				  System.out.println(sx.getErrorCode());
				  System.out.println(sx.getSQLState()); 
			  }
			  
			  return list;
		}

		public void addBillEntry(UserInfo user, BillingData bill) {
			// TODO Auto-generated method stub
			
			 String insertSql = "INSERT INTO expenses_info (Date, Time, userId, userName, isRoomReserved, isRestaurantReserved, isBanquetReserved, isHallReserved, roomTotal, restaurantTotal, banquetTotal,  hallTotal, totalAmount, discount, finalAmount) " +
		  				"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			  
			  try {
				  helper.connectDB();
				  
				  //create statement
				  pstmt = helper.getConnection().prepareStatement(insertSql);
				  
				  //set the parameters of query
				  pstmt.setString(1, bill.getDate());
				  pstmt.setString(2, bill.getTime());
				  pstmt.setInt(3, user.getId());
				  pstmt.setString(4, user.getUsername());
				  if(bill.isRoomReserved())
					  pstmt.setString(5, "yes");
				  else
					  pstmt.setString(5, "no");
				  
				  if(bill.isRestaurantReserved())
					  pstmt.setString(6, "yes");
				  else
					  pstmt.setString(6, "no");
				  
				  if(bill.isBanquetReserved())
					  pstmt.setString(7, "yes");
				  else
					  pstmt.setString(7, "no");
				  
				  if(bill.isHallReserved())
					  pstmt.setString(8, "yes");
				  else
					  pstmt.setString(8, "no");
				  
				  pstmt.setFloat(9, bill.getRoomFee());
				  pstmt.setFloat(10, bill.getRestaurantFee());
				  pstmt.setFloat(11, bill.getBanquetFee());
				  pstmt.setFloat(12, bill.getMeetingHallFee());
				  pstmt.setFloat(13, bill.getTotalFee());
				  pstmt.setFloat(14, bill.getDiscount());
				  pstmt.setFloat(15, bill.getFinalAmount());
				  
				  //execute			  
				  pstmt.executeUpdate();
				  
				  helper.disconnectDB();
			  } catch(SQLException sx) {
				  System.out.println("Error inserting data into the expenses table");
				  System.out.println(sx.getMessage()); 
				  System.out.println(sx.getErrorCode());
				  System.out.println(sx.getSQLState());
			  }
		}
}
