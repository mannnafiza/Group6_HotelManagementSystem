package com.csis.Entities;

import java.util.Vector;

public class Staff {
	
	private int id;
	private String username;
	private String password;
	private String gender;
	private String city;
	
	/**
	 * constructor
	 */
	public Staff() {
		
	}
	
	/**
	 * 
	 * @return the id of staff member
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id is the id of staff member
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return the user name of staff member
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param username, is the user name of staff member
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 * @return the password of staff member
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password, is the password of staff member
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return the gender of staff member
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * 
	 * @param gender, is the gender of staff member
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * 
	 * @return the city of staff member
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @param city is the city of staff member
	 */
	public void setCity(String city) {
		this.city = city;
	};
	
	/**
	 * 
	 * @return the vector of staff
	 */
	public Vector getVector() {
		Vector v = new Vector();
		v.add(id);
		v.add(username);
		v.add(password);
		v.add(gender);
		v.add(city);
		
		return v;
	}
	
}
