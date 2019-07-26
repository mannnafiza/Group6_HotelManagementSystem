package com.csis.Controller;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.csis.Boundary.DBHelper;
import com.csis.Entities.UserInfo;

public class PaymentReceiptDAO {

	DBHelper helper = new DBHelper();
	private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	
	/**
	 * @param user current instance of UserInfo Entity class
	 * @return contents of expenses_info table for specific user
	 */
	public  ArrayList<String> getBillData(UserInfo user) {
		ArrayList<String> s1 = new ArrayList<String>();
		  
		 String sql = "SELECT * FROM expenses_info where userName = ?";
		  
		  try {
			  helper.connectDB();
		  
			  //create statement 
			  pstmt = helper.getConnection().prepareStatement(sql);
		  	  
			  pstmt.setString(1, user.getUsername());
			  rs = pstmt.executeQuery(); 
			  while(rs.next())
			  {
				  s1.add("Bill Id: " + rs.getInt("billId") + "\n" + "Date: " + rs.getString("Date") + ", Time: " + rs.getString("Time") + 
						  ", User Name: " + rs.getString("userName") + " Room Status: " + rs.getString("isRoomReserved") + ", Meeting Hall Status:" + 
						  rs.getString("isHallReserved") + ", Restaurant Status: " + rs.getString("isRestaurantReserved") + " Banquet Status: " +
						  rs.getString("isBanquetReserved") + ", Room Total: " + rs.getFloat("roomTotal") + " Meeting Hall Total: " + rs.getFloat("hallTotal") +
						  ", Restaurant Total: " + rs.getFloat("restaurantTotal") + " Banquet Total: " + rs.getFloat("banquetTotal") +
						  ", Total Amount: " + rs.getFloat("totalAmount") + ", Discount: " + rs.getFloat("discount") + ", Final Amount: " +
						  rs.getFloat("finalAmount"));
				  System.out.println(s1);
			  }	  
		  helper.disconnectDB();
		  }catch(SQLException sx)
		  {
			  System.out.println("Error fetching data from the database");
			  System.out.println(sx.getMessage());
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState()); 
		  }
		  
		  return s1;
		
	}
	
	
	/**
	 * 
	 * @param fileName is the name of the file to be created
	 * @return the message for confirmation of file generation
	 */
	public String writeToFile(String fileName, ArrayList<String> data) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileName + ".txt", "UTF-8");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "Report Not Generated";
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "Report Not Generated";
		}
		
		for(int i = 0; i < data.size(); i++) {
			writer.println(data.get(i) + "\n");
			writer.println("---------------------------------------------------------------------------------------------------------------------------"+
			"---------------------------------------------------------------------------------------------------------------------------");
		}
		
		writer.close();
		return "Report Generated";
	}

}
