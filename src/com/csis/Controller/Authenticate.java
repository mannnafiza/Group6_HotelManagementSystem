 package com.csis.Controller;

import java.util.ArrayList;

public class Authenticate {

	private String username = "";
	private String password = "";
	private String purpose = "";
	private HomeDAO homeDAO = new HomeDAO();
	private AdminDAO adminDAO = new AdminDAO();
	private RegistrationDAO registrationDAO =  new RegistrationDAO();
	
	//default constructor
	public Authenticate() {	
		
	}
	/**
	 * @param purpose 
	 */
	public Authenticate(String purpose) {
		super();
		this.purpose = purpose;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	//method to verify username input
	/**
	 * @return the boolean value whether username verified or not
	 */
	public boolean matchUserName()
	{
		ArrayList<String> list = new ArrayList<>();
		if(purpose.equals("Login Task"))
			list = homeDAO.listUserNames();
		if(purpose.equals("Registration Task"))
			list = registrationDAO.listUserNames();
		if(purpose.equals(""))
			list = homeDAO.listUserNames();
			
		for(String str: list)
		{
			if(username.equals(str))
				return true;
		}		
		return false;		
	}
	
	//method to verify password input
	/**
	 * @return the boolean value whether password verified or not
	 */
	public boolean matchpassword()
	{
		String pswrd = homeDAO.getPassword(username);
		
			if(password.equals(pswrd))
			{
				return true;
			}	
		return false;		
	}

	
	
	//method to verify username input
		/**
		 * @return the boolean value whether username verified or not
		 */
		public boolean matchAdminUserName()
		{
			ArrayList<String> list = new ArrayList<>();
			if(purpose.equals("Login Task"))
				list = adminDAO.listAdminUserNames();
			
			if(purpose.equals(""))
				list = homeDAO.listUserNames();
				
			for(String str: list)
			{
				if(username.equals(str))
					return true;
			}		
			return false;		
		}
		
		//method to verify password input
		/**
		 * @return the boolean value whether password verified or not
		 */
		public boolean matchAdminpassword()
		{
			String pswrd = adminDAO.getAdminPassword(username);
			
				if(password.equals(pswrd))
				{
					return true;
				}	
			return false;		
		}
	
	
}
