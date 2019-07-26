package com.csis.Entities;

public class UserInfo {
	private int id;
	private String username;
	
	/**
	 * constructor
	 */
	public UserInfo() {
		
	}

	/**
	 * 
	 * @return the id of user
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id is the id of user
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return the name of user
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * 
	 * @param username, is the name of user
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
