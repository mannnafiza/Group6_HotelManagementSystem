package com.csis.Boundary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import com.csis.Entities.AddProperty;
import com.csis.Entities.BillingData;
import com.csis.Entities.OrderNewInventory;
import com.csis.Entities.Review;
import com.csis.Entities.Service;
import com.csis.Entities.Staff;
import com.csis.Entities.Transaction;
import com.csis.Entities.UserInfo;

import java.sql.Date;

public class DBHelper {

	// dsn = data source name
	private String dsn = "jdbc:mysql://localhost:3306/Group6_HotelManagementSystem";
	private String username = "root";
	private String password = "";

	private Connection conn = null;
	private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;

	// connect to the database
	public void connectDB() {
		
		try {
			// connect to the database with the proper info
			this.conn = DriverManager.getConnection(dsn, username, password);
			
			if (this.conn.isClosed()) {
				System.out.println("database connection was not established.");
			} else
				System.out.println("database connection established.");
		} catch (SQLException sx) {
			System.out.println("Error connecting to the database");
			System.out.println(sx.getMessage());
			System.out.println(sx.getErrorCode());
			System.out.println(sx.getSQLState());
		}
	}

	// disconnect from the database
	public void disconnectDB() {
		try {
			this.conn.close();
			if (conn.isClosed()) {
				System.out.println("Database connection closed.");
			} else
				System.out.println("Error disconnecting from the database");
		} catch (SQLException sx) {
			System.out.println("Error disconnecting from the database");
			System.out.println(sx.getMessage());
			System.out.println(sx.getErrorCode());
			System.out.println(sx.getSQLState());
		}
	}

	/**
	 * 
	 * @return connection to database
	 */
	public Connection getConnection() {
		return this.conn;
	}
	
	
	//method to get id of user
	  public int getUserId(String username) 
		{
		  int userId = 0;
		  
		  String sql = "SELECT * FROM user_Info where userName = ?";
		  
		  try {
			  connectDB();
		  
			  //create statement 
			  pstmt = conn.prepareStatement(sql);
		  	  
			  pstmt.setString(1, username);
			  rs = pstmt.executeQuery(); 
			  while(rs.next())
			  {
				  userId =  rs.getInt("id");
			  }
		  
		  disconnectDB();
		  }catch(SQLException sx)
		  {
			  System.out.println("Error fetching data from the database");
			  System.out.println(sx.getMessage());
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState()); 
		  }
		  
		  return userId;
		}
		
}
