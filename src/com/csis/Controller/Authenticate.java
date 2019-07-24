 package com.csis.Controller;

import java.util.ArrayList;
import com.csis.Boundary.DBHelper;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Authenticate {

	private String username = "";
	private String password = "";
	private DBHelper db = new DBHelper();
	private HomeDAO homeDAO = new HomeDAO();
	
	//for deccryption
	private static final String key = "aesEncryptionKey";
	private static final String initVector = "encryptionIntVec";
	/**
	 * @param username
	 * @param password
	 */
	public Authenticate() {
		super();
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
		list = homeDAO.listUserNames();
		
		for(String str: list)
		{
			System.out.println("User: " + str);
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
		System.out.println("P: " + password + "         D:" +pswrd );
			if(password.equals(pswrd))
			{
				return true;
			}
	
		return false;		
	}

	
	
}
