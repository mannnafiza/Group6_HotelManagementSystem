package com.csis.Controller;

import javax.swing.JOptionPane;

public class Validate {

	private String userName = "";
	private String password = "";
	private String gender = "";
	private String city = "";
	
	//room service class
	private String roomNumber = "";
	private String serviceTypeMeal  = "";
	private String serviceTypeHouseKeeping = "";
	private String mealType  = "";
	private String time= "";
	private String cardNumber;
	private String expiryDate;
	private String code;
	
	
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
	
	/**
	 * @param userName
	 */
	//constructor for room service class
	public Validate(String userName) {
		super();
		this.userName = userName;
		
	}
	
	public Validate(String userName, String roomNumber,  String serviceTypeMeal , String serviceTypeHouseKeeping ,String  mealType , String time) {
		super();
		this.userName = userName;
		this.roomNumber = roomNumber;
		this.serviceTypeMeal  = serviceTypeMeal ;
		this.serviceTypeHouseKeeping  = serviceTypeHouseKeeping ;
		this.mealType  = mealType ;
		this.time = time;
	}
	
	
	 // default constructor
	/**
	 * @param cardNumber
	 * @param expirydate
	 * @param code
	 */
	public Validate(String cardNumber, String expirydate, String code) {
		super();
		// TODO Auto-generated constructor stub
		this.cardNumber = cardNumber;
		this.expiryDate = expirydate;
		this.code = code;
		
	}

	//method to validate the registration page's user credentials
	/**
	 * @return boolean value as per Registration data validation results
	 */
	public boolean isSignUpDataValid()
	{
		if(userName.equals("") || password.equals("") || gender.equals("") || city.equals(""))
		{
			JOptionPane.showMessageDialog(null,"No field should be empty");
			System.out.println("No field should be empty....");
			return false;
		}
		
		if(!checkPassword(password))
			return false;
				
		return true;
	}
	
	//method to validate the Home(or Login) page's user credentials
	/**
	 * @return boolean value as per Login data validation results
	 */
	public boolean isLoginDataValid()
	{
		if(userName.equals("") || password.equals(""))
		{
			JOptionPane.showMessageDialog(null,"No field should be empty");
			System.out.println("No field should be empty....");
			return false;
		}
		
		if(!checkPassword(password))
			return false;
		
		return true;
	}
	
	public boolean isCustmerDataValid()
	{
		if(userName.equals("") || roomNumber.equals("")||time.equals(""))
		{
			System.out.println("No field should be empty....room");
			return false;
		}

		return true;
	}
	
	/**
	 * @return boolean value as per transaction data validation results
	 */
	public boolean istransactionDataValid() {
		// TODO Auto-generated method stub
		
		boolean valid = true;
		String errorMsg = "";
		/*
		 * if(cardNumber==0 || expiryDate.equals("") || code==0) {
		 * System.out.println("No field should be empty...."); return false; }
		 */
		if(cardNumber.length() == 8)
		{
			for(int i = 0; i<cardNumber.length(); i++)
			{
				if(!Character.isDigit(cardNumber.charAt(i)))
				{
					errorMsg += "CardNumber should contain only digits.\n";
					valid = false;
					break;
				}
			}
		}
		else
		{
			errorMsg += "CardNumber must be equal to 8 in length.\n";
			valid = false;
		}
		
		if(expiryDate.length() == 5)
		{
			String c = "/";
			if(!(Character.isDigit(expiryDate.charAt(0)) && Character.isDigit(expiryDate.charAt(1))
					&& String.valueOf(expiryDate.charAt(2)).contains(c) && Character.isDigit(expiryDate.charAt(3)) && Character.isDigit(expiryDate.charAt(4))))
			{
				errorMsg += "Expiry Date must be in format MM/YY.\n";
				valid = false;
			}
					
		}
		else
		{
			errorMsg += "Expiry Date must be equal to 5 in length.\n";
			valid = false;
		}
		
		if(code.length() == 3)
		{
			for(int i = 0; i<code.length(); i++)
			{
				if(!Character.isDigit(code.charAt(i)))
				{
					errorMsg += "Security Code should contain only digits.\n";
					valid = false;
					break;
				}
			}
		}else
		{
			errorMsg += "Security Code must be equal to 3 in length.\n";
			valid = false;
		}
		
		if(errorMsg != "")
			JOptionPane.showMessageDialog(null,errorMsg);
		return valid;
		
	}	
	
	//method to validate if the password meets all the minimum requirements
	/**
	 * @param password the password to be validated
	 * @return boolean value as per password validation results
	 */
	private boolean checkPassword(String password) {
		// TODO Auto-generated method stub
		
		String errorMsg = "";
		boolean containsDigit = false;
		boolean isValid = true;
		if((password.length() < 5))
		{
			errorMsg += "Password should contain atleast 5 characters!!\n";
			System.out.println("Password should contain atleast 5 characters!!");
			isValid = false;
		}
		
		String p = password.toUpperCase();
		if(!(password.charAt(0) == (p.charAt(0))))
		{
			errorMsg += "Password should begin with an uppercase!!\n";
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
			errorMsg += "Password must contain atleast one digit!!\n";
			System.out.println("Password must contain atleast one digit!!");
			isValid = false;
		}
	
		if(errorMsg != "")
			JOptionPane.showMessageDialog(null,errorMsg);
		
		if(!isValid)
			return false;
		
		return true;
	}


}
