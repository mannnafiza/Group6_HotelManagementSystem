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

	//method to get all the user names from user_Info table
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

	//method to get the password for a specific user from user_Info table
	public String getPassword(String usernm) {

		String s1 = "";
		String sql = "SELECT password FROM user_Info where userName = '" + usernm + "'";
		try {
			// connect to the database
			connectDB();
			this.stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next())
			{			
				s1 = rs.getString(1);
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
	  
	  return s1;
	  
	}
		
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
	  
	  public void insertReservationInformation(int userId, String usrname, String resType, String roomType,
			  int stayDuration, String mealStatus, String mealType, Date resDate, Time resTime, int meetingDuration,
			  boolean addService, int noOfGuest, String resFor){
		  
		  String insertSql = "INSERT INTO reservation_info (userId, userName, resType, roomType, stayDuration, mealStatus, mealType, resDate, resTime,  meetingDuration, addService, noGuest, resFor) " +
	  				"values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		  
		  try {
			  connectDB();
			  
			  //create statement
			  pstmt = conn.prepareStatement(insertSql);
			  
			  //set the parameters of query
			  pstmt.setInt(1, userId);
			  pstmt.setString(2, usrname);
			  pstmt.setString(3, resType);
			  pstmt.setString(4, roomType);
			  pstmt.setInt(5, stayDuration);
			  pstmt.setString(6, mealStatus);
			  pstmt.setString(7, mealType);
			  pstmt.setDate(8, resDate);
			  pstmt.setTime(9, resTime);
			  pstmt.setInt(10, meetingDuration);
			  pstmt.setBoolean(11, addService);
			  pstmt.setInt(12, noOfGuest);
			  pstmt.setString(13, resFor);
			  
			  //execute			  
			  pstmt.executeUpdate();
			  
			  disconnectDB();
		  } catch(SQLException sx) {
			  System.out.println("Error inserting data into the reservation table");
			  System.out.println(sx.getMessage()); 
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState());
		  }
	  }
	    
		//method to add inventory 
		public ArrayList<AddProperty> listAddPropertyInventory() 
		{
			ArrayList<AddProperty> s1 = new ArrayList<AddProperty>();

			String sql = "SELECT * FROM propertyInventory_Info";
			try {
				// connect to the database
				connectDB();
				this.stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);

				while (rs.next())
				{      //itemId, Item , Type , Quantity , Price , Category , Unitprice
					 
	                AddProperty s = new AddProperty();
					
					//Get the right type (string) from the right column ("itemId");
					s.setItemId((rs.getInt("itemId")));
					s.setItem((rs.getString("Item")));
					s.setType((rs.getString("Type")));
					s.setQuantity((rs.getInt("Quantity")));
					s.setPrice((rs.getFloat("Price")));
					s.setCategory((rs.getString("Category")));
					s.setUnitprice((rs.getFloat("Unitprice")));
		
					s1.add(s);
					 // System.out.println(s1);
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

	//method to get inventory 

	public AddProperty getProperty(int itemId) {
			
		AddProperty ap = new AddProperty();
			
			String sql = "SELECT * FROM propertyInventory_Info  WHERE itemId  = ?";
			
			try {
				
				//Connect to the database
				connectDB();
				
				//Create the statement
				pstmt = conn.prepareStatement(sql);
				
				//Declare the parameter (starting at 1)
				pstmt.setInt(1,itemId);
				
				rs = pstmt.executeQuery();
				
				while (rs.next())	{
					
					//Get the right type (string) from the right column ("");									
					ap.setItemId((rs.getInt("itemId")));
					ap.setItem((rs.getString("Item")));
					ap.setType((rs.getString("Type")));
					ap.setQuantity((rs.getInt("Quantity")));
					ap.setPrice((rs.getFloat("Price")));
					ap.setCategory((rs.getString("Category")));
					ap.setUnitprice((rs.getFloat("Unitprice")));				
				} 
				
				disconnectDB();
					
				} catch (SQLException sx) {
					System.out.println("Error Connecting to Database");
					System.out.println(sx.getMessage());
					System.out.println(sx.getErrorCode());
					System.out.println(sx.getSQLState());
					
				}
				return ap;			
			}
	
	//method to add property inventory
	public int AddPropertyInv(AddProperty ap)	{
		 int propertyInv = 0;		
		
		String sql = "Insert into propertyInventory_Info(Item  , Type  ,Quantity  ,Price , Category , Unitprice  )" 
				+ " VALUES ('" + ap.getItem() + "','" + ap.getType() + "','" + ap.getQuantity() 
				+ "','" + ap.getPrice() + "','" + ap.getCategory() + "','" + ap.getUnitprice() + "');";
		
		try { // itemId , Item , Type , Quantity , Price , Category , Unitprice
			//Connect to the database
			connectDB();
			
			//Create the statement
			this.stmt = this.conn.createStatement();
			
			//Execute the statement
			propertyInv = stmt.executeUpdate(sql , Statement.RETURN_GENERATED_KEYS);

			disconnectDB();			
			
		} catch (SQLException sx) {
			System.out.println("Error Connecting to Database");
			System.out.println(sx.getMessage());
			System.out.println(sx.getErrorCode());
			System.out.println(sx.getSQLState());
			
		}
		System.out.println("Inserted new Property Inventory: " + propertyInv);
		return propertyInv;
		
	}
	  
	//method to delete inventory
	public void deleteInventory(int id) {
		
		String sql = "DELETE FROM propertyInventory_Info  WHERE itemId = ?";
		
		try {
			
			//Connect to the database
			connectDB();
			
			//Create the statement
			pstmt = conn.prepareStatement(sql);
			
			//Declare the parameter (starting at 1)
			pstmt.setInt(1,id);
			
			//Delete Data
			pstmt.executeUpdate();
			
			disconnectDB();
				
			} catch (SQLException sx) {
				System.out.println("Error Connecting to Database");
				System.out.println(sx.getMessage());
				System.out.println(sx.getErrorCode());
				System.out.println(sx.getSQLState());
				
			}		
		}
	
	//method to Edit inventory



	public void updateInventory(AddProperty su)	{		

	String updateSql = "UPDATE propertyInventory_Info SET " + 
			"Item  = ?, " +
			"Type = ?, " + 
			"Quantity = ?, " +
			"Price = ?, " +
			"Category = ?, " +
			"Unitprice = ? " +
			
			"WHERE itemId = ?";
	
	//itemId , Item , Type , Quantity , Price , Category , Unitprice
	
	try {
			connectDB();
			
			pstmt = conn.prepareStatement(updateSql);
	
			
			//pstmt.setInt(1, su.getVGID());  				
			pstmt.setString(1, su.getItem());
			pstmt.setString(2, su.getType());
			pstmt.setInt(3, su.getQuantity());
			pstmt.setFloat(4, su.getPrice());
			pstmt.setString(5, su.getCategory());
			pstmt.setFloat(6, su.getUnitprice());
			pstmt.setInt(7, su.getItemId());  				
			
			pstmt.executeUpdate();
			
			disconnectDB();
			
	} catch (SQLException sx) {
		System.out.println("Error Connecting to Database");
		System.out.println(sx.getMessage());
		System.out.println(sx.getErrorCode());
		System.out.println(sx.getSQLState());
		
	}	
}


//method to add user room service info into the roomService_Info  table at the time of reservation
public int roomService(Service serviceData)	{ //, serviceType  .   "','" + serviceData.isServiceType() +  
	 int roomService = 0;		
	//Get all the shoes! Shoes for days!
	String sql = "Insert into roomService_Info (customerName , resType , roomNumber, mealNeeded , houseKeepingNeeded , mealType, time  )" 
			+ " VALUES ('" + serviceData.getCustomerName()  + "','" + serviceData.getResType()  + "','" + serviceData.getRoomNumber() + "','" + serviceData.getMealNeeded() 
			+ "','" + serviceData.getHouseKeepingNeeded() + "','" + serviceData.getMealType() +"','" + serviceData.getTime() +"');";
	
	try {
		//Connect to the database
		connectDB();
		
		//Create the statement
		this.stmt = this.conn.createStatement();
		
		//Execute the statement
		roomService = stmt.executeUpdate(sql , Statement.RETURN_GENERATED_KEYS);

		disconnectDB();			
		
	} catch (SQLException sx) {
		System.out.println("Error Connecting to Database");
		System.out.println(sx.getMessage());
		System.out.println(sx.getErrorCode());
		System.out.println(sx.getSQLState());
		
	}
	System.out.println("Inserted new Room Service: " + roomService);
	return roomService;
	
}

	
	  
	  
	//method to add user room service info into the roomService_Info  table at the time of reservation
	  public void insertRoomServiceInformation( String customerName , int roomNumber , String serviceType ,

			  float time){
		  
		  String insertSql = "INSERT INTO roomService_Info (customerName  , roomNumber  ,serviceType ,time  ) values (?,?,?,?)";
		  
		    try {
			  connectDB();
			  
			  //create statement
			  pstmt = conn.prepareStatement(insertSql);
			  
			  //set the parameters of query
			  pstmt.setString(1, customerName);
			  pstmt.setInt(2, roomNumber);
			  pstmt.setString(3, serviceType);
			  pstmt.setFloat(4, time);
			  
			  //execute			  
			  pstmt.executeUpdate();
			  
			  disconnectDB();
		  } catch(SQLException sx) {
			  System.out.println("Error inserting data into the reservation table");
			  System.out.println(sx.getMessage()); 
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState());
		  }
	  }
	
	  /**
	   * 
	   * @param date
	   * @return list of rooms for specific date
	   */
	  public ArrayList<String> getRoomList(Date date){
		  String sql = "SELECT roomType from reservation_info where resDate = ?";
		  ArrayList<String> roomType = new ArrayList<>();
		  try {
			  connectDB();
			  
			  
			//create statement 
			  pstmt = conn.prepareStatement(sql);
		  	  
			  pstmt.setDate(1,  date);
			  rs = pstmt.executeQuery(); 
			  while(rs.next())
			  {
				  roomType.add(rs.getString("roomType"));
			  }
			  
			  disconnectDB();
			  
		  } catch(SQLException sx) {
			  System.out.println("Error inserting data into the reservation table");
			  System.out.println(sx.getMessage()); 
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState());
		  }
		  return roomType;
	  }
	  
	 /**
	  * 
	  * @param date
	  * @return type of reservation for specific date
	  */
	  public ArrayList<String> getReservationType(Date date) {
		 String sql = "SELECT resType FROM reservation_info where resDate = ?";
		 ArrayList<String> type = new ArrayList<>();
		 
		 try {
			  connectDB();
			  
			  	  
			//create statement 
			  pstmt = conn.prepareStatement(sql);
		  	  
			  pstmt.setDate(1,  date);
			  rs = pstmt.executeQuery(); 
			  while(rs.next())
			  {
				 type.add(rs.getString("resType"));
			  }
			  
			  disconnectDB();
			  
		  } catch(SQLException sx) {
			  System.out.println("Error inserting data into the reservation table");
			  System.out.println(sx.getMessage()); 
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState());
		  }
		 return type;
	  }
	  
	  /**
	   * 
	   * @param date
	   * @param roomType
	   * @return stay duration for specific room starting given date
	   */
	  public int  getStayDuration(Date date, String roomType) {
		  String sql = "SELECT stayDuration FROM reservation_info WHERE date = ? AND roomType = ?";
		  
		  int duration = 0;
		  try {
			  connectDB();
			  
			  	  
			//create statement 
			  pstmt = conn.prepareStatement(sql);
		  	  
			  pstmt.setDate(1,  date);
			  rs = pstmt.executeQuery(); 
			  while(rs.next())
			  {
				 duration = rs.getInt("stayDuration");
			  }
			
			  
			  disconnectDB();
			  
		  } catch(SQLException sx) {
			  System.out.println("Error inserting data into the reservation table");
			  System.out.println(sx.getMessage()); 
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState());
		  }

		  return duration;
	  }
	  
	  /**
	   * 
	   * @param date
	   * @param duration
	   * @return end date for reservation
	   */
	  public Date getDate(Date date, int duration) {
		  String sql = "SELECT DATE_ADD(?, ?)";
		  
		  Date endDate = null;

		  
		  try {
			  connectDB();

			  	  
			//create statement 
			  pstmt = conn.prepareStatement(sql);
		  	  
			  pstmt.setDate(1,  date);
			  pstmt.setInt(2,  duration);
			  rs = pstmt.executeQuery(); 
			  while(rs.next())
			  {
				 endDate = rs.getDate("resDate");
			  }
			
			  
			  disconnectDB();
			  
		  } catch(SQLException sx) {
			  System.out.println("Error inserting data into the reservation table");
			  System.out.println(sx.getMessage()); 
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState());
		  }
		  return endDate;
	  }
	  
	  /**
	   * create a new staff member
	   * @param username
	   * @param password
	   * @param gender
	   * @param city
	   */
	  public void createStaff(String username, String password, String gender, String city){
			
			String sql = "insert into staff_info (username, password, gender, city) values (?,?,?,?)";
			
			try {
				connectDB();
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				pstmt.setString(3, gender);
				pstmt.setString(4, city);
				
				pstmt.executeUpdate();
				disconnectDB();
				
			} catch(SQLException sx) {
				System.out.println("Error in connecting database");
				System.out.println(sx.getMessage());
				System.out.println(sx.getErrorCode());
				System.out.println(sx.getSQLState());
			}
		}	  
	  /**
	   * 
	   * @return list of all staff members
	   */
	  public ArrayList<Staff> listStaff(){
			ArrayList<Staff> staffArr = new ArrayList<>();
			
			String sql = "Select * from staff_info";
			try {
				connectDB();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					Staff s = new Staff();
					s.setId(rs.getInt("id"));
					s.setUsername(rs.getString("username"));
					s.setPassword(rs.getString("password"));
					s.setGender(rs.getString("gender"));
					s.setCity(rs.getString("city"));
					staffArr.add(s);
				}
				disconnectDB();
			} catch(SQLException sx) {
				System.out.println("Error in connecting database");
				System.out.println(sx.getMessage());
				System.out.println(sx.getErrorCode());
				System.out.println(sx.getSQLState());
			}
			
			return staffArr;
		}	  
	  /**
	   * 
	   * @param id
	   * @return a staff member
	   */
	  public Staff getStaffMember(int id) {
			Staff s = new Staff();
			
			String sql = "Select * from staff_info where id = ?";
			
			try {
				connectDB();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,  id);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					s.setId(rs.getInt("id"));
					s.setUsername(rs.getString("username"));
					s.setPassword(rs.getString("password"));
					s.setGender(rs.getString("gender"));
					s.setCity(rs.getString("city"));
				}
				disconnectDB();
			} catch(SQLException sx) {
				System.out.println("Error in connecting database");
				System.out.println(sx.getMessage());
				System.out.println(sx.getErrorCode());
				System.out.println(sx.getSQLState());
			}
			
			return s;
		}	  
	  /**
	   * delete a staff member
	   * @param id
	   */
	  public void deleteStaffMember(int id) {
			String sql = "delete from staff_Info where id = ?";
			try {
				connectDB();
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
				
				disconnectDB();
			} catch(SQLException sx) {
				System.out.println("Error in connecting database");
				System.out.println(sx.getMessage());
				System.out.println(sx.getErrorCode());
				System.out.println(sx.getSQLState());
			}
		}	  
	  /**
	   * update a staff member information
	   * @param s
	   */
	  public void updateStaff(Staff s) {
			String sql = "update staff_Info set username = ?, password = ?, gender = ?, city = ? where id = ?";
					
			try {
				connectDB();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, s.getUsername());
				pstmt.setString(2, s.getPassword());
				pstmt.setString(3, s.getGender());
				pstmt.setString(4, s.getCity());
				pstmt.setInt(5, s.getId());
				
				pstmt.executeUpdate();
				disconnectDB();
			} catch(SQLException sx) {
				System.out.println("Error in connecting database");
				System.out.println(sx.getMessage());
				System.out.println(sx.getErrorCode());
				System.out.println(sx.getSQLState());
			}
		}


	
	  
	  //add new order inventory
	//method to list order 
			public ArrayList<OrderNewInventory> listAddOrderInventory() 
			{
				ArrayList<OrderNewInventory> s1 = new ArrayList<OrderNewInventory>();

				String sql = "SELECT * FROM neworderinventory_info";
				try {
					// connect to the database
					connectDB();
					this.stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);

					while (rs.next())
					{      //itemId, Item , Type , Quantity , Price , Category , Unitprice
						 
						OrderNewInventory s = new OrderNewInventory();
						
						//Get the right type (string) from the right column ("itemId");
						s.setItem((rs.getString("Item")));
						s.setQuantity((rs.getInt("Quantity")));
						s.setUnitPrice((rs.getFloat("Unitprice")));
						s.setAmount((rs.getFloat("Amount")));

			
						s1.add(s);
						 // System.out.println(s1);

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


			//method to get order 
		public OrderNewInventory getlistAddOrderInventory(String Item) {
				
			OrderNewInventory ap = new OrderNewInventory();
				
				String sql = "SELECT * FROM neworderinventory_info  WHERE Item = ?";
				
				try {
					
					//Connect to the database
					connectDB();
					
					//Create the statement
					pstmt = conn.prepareStatement(sql);
					
					//Declare the parameter (starting at 1)
					pstmt.setString(1,Item);
					
					rs = pstmt.executeQuery();
					
					while (rs.next())	{
						
						//Get the right type (string) from the right column ("");				
			
						
						//ap.setItemId((rs.getInt("itemId")));
						ap.setItem((rs.getString("Item")));
						ap.setQuantity((rs.getInt("Quantity")));
						ap.setAmount((rs.getFloat("Amount")));
						ap.setUnitPrice((rs.getFloat("Unitprice")));
						
						
					} 
					
					disconnectDB();
						
					} catch (SQLException sx) {
						System.out.println("Error Connecting to Database");
						System.out.println(sx.getMessage());
						System.out.println(sx.getErrorCode());
						System.out.println(sx.getSQLState());
						
					}
					
					return ap;
					
				}
		
		//method to add order inventory
		public int AddOrderInventory(OrderNewInventory ap)	{
			 int propertyInv = 0;		
			
			String sql = "Insert into neworderinventory_info(Item   ,Quantity  , UnitPrice , Amount )" 
					+ " VALUES ('" + ap.getItem() + "','" + ap.getQuantity() + "','" + ap.getUnitPrice() + "','" + ap.getAmount()+  "');";
			
			try { // itemId , Item , Type , Quantity , Price , Category , Unitprice
				//Connect to the database
				connectDB();
				
				//Create the statement
				this.stmt = this.conn.createStatement();
				
				//Execute the statement
				propertyInv = stmt.executeUpdate(sql , Statement.RETURN_GENERATED_KEYS);

				disconnectDB();			
				
			} catch (SQLException sx) {
				System.out.println("Error Connecting to Database");
				System.out.println(sx.getMessage());
				System.out.println(sx.getErrorCode());
				System.out.println(sx.getSQLState());
				
			}
			System.out.println("Inserted new Property Inventory: " + propertyInv);
			return propertyInv;
			
		}
	  
	  
		  //method to obtain data from reservation_info table
		public ArrayList<String> getReservationData(UserInfo user, String type) {

		// TODO Auto-generated method stub
			  
		  String sql = "SELECT * FROM reservation_info where userName = ? and resType = ?";
		  ArrayList<String> list = new ArrayList<>();
		  
		  try {
			  connectDB();
		  
			  //create statement 
			  pstmt = conn.prepareStatement(sql);
		  	  
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
		  
		  disconnectDB();
		  }catch(SQLException sx)
		  {
			  System.out.println("Error fetching data from the database");
			  System.out.println(sx.getMessage());
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState()); 
		  }
		  
		  return list;
		  
	}

		 //method to obtain data from roomservice_info table
	public ArrayList<String> getRoomServiceData(UserInfo user, String type) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM roomservice_info where customerName = ? and resType = ?";
		  ArrayList<String> list = new ArrayList<>();
		  
		  try {
			  connectDB();
		  
			  //create statement 
			  pstmt = conn.prepareStatement(sql);
		  	  
			  pstmt.setString(1, user.getUsername());
			  pstmt.setString(2, type);
			  rs = pstmt.executeQuery(); 
			  while(rs.next())
			  {
				  //list.add(rs.getString("userName"));
				 // list.add(rs.getString("resType"));
				  list.add(Integer.toString(rs.getInt("roomNumber")));
				  list.add(rs.getString("mealNeeded"));
				  list.add(rs.getString("houseKeepingNeeded"));
				  list.add(rs.getString("mealType"));
			  }
		  
		  disconnectDB();
		  }catch(SQLException sx)
		  {
			  System.out.println("Error fetching data from the database");
			  System.out.println(sx.getMessage());
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState()); 
		  }
		  
		  return list;
	}

	public int addBillEntry(UserInfo user, BillingData bill) {
		// TODO Auto-generated method stub
		
		 String insertSql = "INSERT INTO expenses_info (Date, Time, userId, userName, isRoomReserved, isRestaurantReserved, isBanquetReserved, isHallReserved, roomTotal, restaurantTotal, banquetTotal,  hallTotal, totalAmount, discount, finalAmount) " +
	  				"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		  
		  try {
			  connectDB();
			  
			  //create statement
			  pstmt = conn.prepareStatement(insertSql);
			  
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
			  
			  disconnectDB();
		  } catch(SQLException sx) {
			  System.out.println("Error inserting data into the expenses table");
			  System.out.println(sx.getMessage()); 
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState());
		  }
		return 0;
	}

	public int addtransactionEntry(Transaction t) {
		// TODO Auto-generated method stub
		
		 String insertSql = "INSERT INTO transactions_info (Date, Time, userId, userName, amountPaid, paymentMode, cardNumber, cardExpiryDate, cardSecurityCode) " +
	  				"values (?,?,?,?,?,?,?,?,?)";
		  
		  try {
			  connectDB();
			  
			  //create statement
			  pstmt = conn.prepareStatement(insertSql);
			  
			  //set the parameters of query
			  pstmt.setString(1, t.getDate());
			  pstmt.setString(2, t.getTime());
			  pstmt.setInt(3, t.getUserId());
			  pstmt.setString(4, t.getUserName());
			  pstmt.setFloat(5, t.getAmountPaid());
			  pstmt.setString(6, t.getPaymentMode());
			  pstmt.setLong(7, t.getCardNumber());
			  pstmt.setString(8, t.getExpiryDate());
			  pstmt.setInt(9, t.getCode());
			  
			  //execute			  
			  pstmt.executeUpdate();
			  
			  disconnectDB();
		  } catch(SQLException sx) {
			  System.out.println("Error inserting data into the transaction table");
			  System.out.println(sx.getMessage()); 
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState());
		  }
		return 0;
	}
}
