package com.csis.Entities;

import java.util.Vector;

public class Staff {
	
	private int id;
	private String username;
	private String password;
	private String gender;
	private String city;
	
	public Staff() {
		
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	};
	
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
