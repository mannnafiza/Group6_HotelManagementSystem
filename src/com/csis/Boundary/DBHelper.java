package com.csis.Boundary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBHelper {

	// dsn = data source name
	private String dsn = "jdbc:mysql://localhost/Group6_HotelManagementSystem";
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

	//method to get all the usernames from user_Info table
	public ArrayList<String> listUserNames() 
	{
		ArrayList<String> s1 = new ArrayList<String>();

		String sql = "SELECT userName FROM user_Info";
		try {
			// connect to the database
			connectDB();
			this.stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next())
			{
				s1.add(rs.getString("username"));				
			}

			disconnectDB();
		} catch (SQLException sx) {
			System.out.println("Error fetching data from the database");
			System.out.println(sx.getMessage());
			System.out.println(sx.getErrorCode());
			System.out.println(sx.getSQLState());
		}

		return s1;
	}

	//method to get all the passwords from user_Info table
	public ArrayList<String> listPasswords() {
		ArrayList<String> s1 = new ArrayList<String>();

		String sql = "SELECT password FROM user_Info";
		try {
			// connect to the database
			connectDB();
			this.stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next())
			{			
				s1.add(rs.getString("password"));				
			}

			disconnectDB();
		} catch (SQLException sx) {
			System.out.println("Error fetching data from the database");
			System.out.println(sx.getMessage());
			System.out.println(sx.getErrorCode());
			System.out.println(sx.getSQLState());
		}

		return s1;
	}
	
	//method to obtain profile of a specific user
	public ArrayList<String> getUserProfile(String name)
	{
	  ArrayList<String> s1 = new ArrayList<String>();
	  
	  String sql = "SELECT * FROM user_Info where userName = ?";
	  
	  try {
		  connectDB();
	  
		  //create statement 
		  pstmt = conn.prepareStatement(sql);
	  	  
		  pstmt.setString(1, name);
		  rs = pstmt.executeQuery(); 
		  while(rs.next())
		  {
			  s1.add("Id: " + rs.getInt("id") + " ,Name: " + rs.getString("userName") + " ,Password: " + rs.getString("password") + " ,Gender: " + rs.getString("gender") + " ,City: " + rs.getString("city"));
			  System.out.println(s1);
		  }
	  
	  disconnectDB();
	  }catch(SQLException sx)
	  {
		  System.out.println("Error fetching data from the database");
		  System.out.println(sx.getMessage());
		  System.out.println(sx.getErrorCode());
		  System.out.println(sx.getSQLState()); 
	  }
	  
	  return s1; }
	 
	//method to add new user's info into the user_Info table at the time of registration
	  public void insertNewUser(String usrnm, String pswd, String gendr, String city)
	  { // TODO Auto-generated method stub

		  String insertSql = "INSERT INTO user_Info (userName,password,gender,city) " +
			  				"values (?,?,?,?)";
	  
		  try { 
			  connectDB();
	  
			  // create statement
			  pstmt = conn.prepareStatement(insertSql);
	  
			  // declare the parameter starting at 1 
			  pstmt.setString(1,usrnm);			
			  pstmt.setString(2, pswd);
			  pstmt.setString(3, gendr);
			  pstmt.setString(4, city);
	  
			  pstmt.executeUpdate();
	  
			  disconnectDB(); 
		  } catch (SQLException sx)
		  {
			  System.out.println("Error inserting data into the database");
			  System.out.println(sx.getMessage()); 
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState());
		  }
	  }
	 
}