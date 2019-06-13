package com.csis.Controller;

import java.util.ArrayList;

import com.csis.Boundary.DBHelper;

public class Authenticate {

	private String username = "";
	private String password = "";
	private DBHelper db = new DBHelper();
	/**
	 * @param username
	 * @param password
	 */
	public Authenticate() {
		super();
		/*
		 * this.username = username; this.password = password;
		 */
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
	public boolean matchUserName()
	{
		ArrayList<String> list = new ArrayList<>();
		list = db.listUserNames();
		
		for(String str: list)
		{
			//System.out.println("User: " + str);
			if(username.equals(str))
				return true;
		}		
		return false;		
	}
	
	//method to verify password input
	public boolean matchpassword()
	{
		ArrayList<String> list = new ArrayList<>();
		list = db.listPasswords();
		
		for(String str: list)
		{
			//System.out.println("User: " + str);
			if(password.equals(str))
				return true;
		}		
		return false;		
	}

	
	
}
