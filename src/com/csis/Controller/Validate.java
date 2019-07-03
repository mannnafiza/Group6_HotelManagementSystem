package com.csis.Controller;

public class Validate {

	private String userName = "";
	private String password = "";
	private String gender = "";
	private String city = "";
	
	//room service class
	private String roomNumber = "";
	private String time= "";
	
	
	/**
	 * @param userName
	 * @param password
	 * @param gender
	 * @param city
	 */	
	//constructor used by Registration class
	public Validate(String userName, String password, String gender, String city) {
		super();
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.city = city;
	}
		
	/**
	 * @param userName
	 * @param password
	 */
	//constructor used by Home class
	public Validate(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	//constructor for room service class
	public Validate(String userName) {
		super();
		this.userName = userName;
		
	}
	
	
	 // default constructor
	 
	public Validate() {
		super();
		// TODO Auto-generated constructor stub
	}

	//method to validate the registration page's user credentials
	public boolean isSignUpDataValid()
	{
		if(userName.equals("") || password.equals("") || gender.equals("") || city.equals(""))
		{
			System.out.println("No field should be empty....");
			return false;
		}
		
		if(!checkPassword(password))
			return false;
				
		return true;
	}
	
	//method to validate the Home(or Login) page's user credentials
	public boolean isLoginDataValid()
	{
		if(userName.equals("") || password.equals(""))
		{
			System.out.println("No field should be empty....");
			return false;
		}
		
		if(!checkPassword(password))
			return false;
		
		return true;
	}
	
	public boolean isCustmerDataValid()
	{
		if(userName.equals("") || roomNumber.equals("") || time.equals(""))
		{
			System.out.println("No field should be empty....");
			return false;
		}
		
		if(!checkPassword(password))
			return false;
		
		return true;
	}
	
	
	//method to validate if the password meets all the minimum requirements
	private boolean checkPassword(String password) {
		// TODO Auto-generated method stub
		
		boolean containsDigit = false;
		boolean isValid = true;
		if((password.length() < 5))
		{
			System.out.println("Password should contain atleast 5 characters!!");
			isValid = false;
		}
		
		String p = password.toUpperCase();
		if(!(password.charAt(0) == (p.charAt(0))))
		{
			System.out.println("Password should begin with an uppercase!!");
			isValid = false;
		}
		
		for(int i = 0; i<password.length(); i++)
		{
			if(Character.isDigit(password.charAt(i)))
			{
				containsDigit = true;
			}
		}

		if(!containsDigit)
		{
			System.out.println("Password must contain atleast one digit!!");
			isValid = false;
		}
	
		if(!isValid)
			return false;
		
		return true;
	}	
}
