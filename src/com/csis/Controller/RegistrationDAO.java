package com.csis.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.csis.Boundary.DBHelper;

public class RegistrationDAO {

	DBHelper helper = new DBHelper();
	private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	
	//default constructor
	public RegistrationDAO() {	}


	/**
	  * @return list of usernames
	  */
		public ArrayList<String> listUserNames() 
		{
			ArrayList<String> s1 = new ArrayList<String>();

			String sql = "SELECT userName FROM user_Info";
			try {
				// connect to the database
				helper.connectDB();
				this.stmt = helper.getConnection().createStatement();
				rs = stmt.executeQuery(sql);

				while (rs.next())
				{
					s1.add(rs.getString("username"));				
				}

				helper.disconnectDB();
			} catch (SQLException sx) {
				System.out.println("Error fetching data from the database");
				System.out.println(sx.getMessage());
				System.out.println(sx.getErrorCode());
				System.out.println(sx.getSQLState());
			}

			return s1;
		}
		
		/**
		 * 
		 * @param usrname, name of the user
		 * @param pswd, password of user
		 * @param gendr, gender of user
		 * @param city, city of user
		 */
		  public void insertNewUser(String usrnm, String pswd, String gendr, String city)
		  { // TODO Auto-generated method stub

			  String insertSql = "INSERT INTO user_Info (userName,password,gender,city) " +
				  				"values (?,?,?,?)";
		  
			  try { 
				  helper.connectDB();
		  
				  // create statement
				  pstmt = helper.getConnection().prepareStatement(insertSql);
		  
				  // declare the parameter starting at 1 
				  pstmt.setString(1,usrnm);			
				  pstmt.setString(2, pswd);
				  pstmt.setString(3, gendr);
				  pstmt.setString(4, city);
					  
				  pstmt.executeUpdate();
		  
				  helper.disconnectDB(); 
			  } catch (SQLException sx)
			  {
				  System.out.println("Error inserting data into the database");
				  System.out.println(sx.getMessage()); 
				  System.out.println(sx.getErrorCode());
				  System.out.println(sx.getSQLState());
			  }
		  }
		  
		/**
		  * @return list of specific user's details
		  */
		public ArrayList<String> getUserProfile(String name)
		{
		  ArrayList<String> s1 = new ArrayList<String>();
		  
		  String sql = "SELECT * FROM user_Info where userName = ?";
		  
		  try {
			  helper.connectDB();
		  
			  //create statement 
			  pstmt = helper.getConnection().prepareStatement(sql);
		  	  
			  pstmt.setString(1, name);
			  rs = pstmt.executeQuery(); 
			  while(rs.next())
			  {
				  s1.add("Id: " + rs.getInt("id") + " ,Name: " + rs.getString("userName") + " ,Password: " + rs.getString("password") + " ,Gender: " + rs.getString("gender") + " ,City: " + rs.getString("city"));
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
}
