package com.csis.SystemTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

import com.csis.Boundary.Home;
import com.csis.Boundary.Registration;
import com.csis.Boundary.Reservation;
import com.csis.Controller.Authenticate;
import com.csis.Controller.RegistrationDAO;
import com.csis.Controller.Validate;

class Registration_Login_Test {

	Registration register = new Registration();
	RegistrationDAO registrationDAO = new RegistrationDAO();
	String msg;
	
	@Test
	void test_NewUserRegistration_WithExistingUsername() {
		
		register.txtFieldName.setText("Sarah");
		register.pswrdField.setText("Sarah123");
		register.txtFieldCity.setText("Burnaby");
		register.gender = "Female";
		
		Validate validate = new Validate(register.txtFieldName.getText(), register.pswrdField.getPassword().toString() , register.gender, register.txtFieldCity.getText());
		if(validate.isSignUpDataValid())
		{
			Authenticate auth = new Authenticate("Registration Task");
			auth.setUsername(register.txtFieldName.getText());
			if(auth.matchUserName())
			{
				msg = "The username already exists, choose a different one.";
				System.out.println("The username already exists, choose a different one.");
				JOptionPane.showMessageDialog(null,"The username already exists, choose a different one.");
			}else
			{
				//store the user inputs in the user_Info table
				registrationDAO.insertNewUser(register.txtFieldName.getText(), register.encrypt(register.pswrdField.getPassword().toString()), register.gender, register.txtFieldCity.getText());
				ArrayList<String> newList = new ArrayList<>();
				newList = registrationDAO.getUserProfile(register.txtFieldName.getText());
				
				//to see the profile of newly added user
				for(String str: newList)
				{
					System.out.println(str);
				}	

			}
		}
		
		//assert Test for Registration.java
		assertEquals("The username already exists, choose a different one.", msg);
			
	}
	@Test
	void test_UniqueNewUserRegistration_Login () {
		
		register.txtFieldName.setText("Kulbir");
		register.pswrdField.setText("Kulbir123");
		register.txtFieldCity.setText("Burnaby");
		register.gender = "Female";
		
		Validate validate = new Validate(register.txtFieldName.getText(), register.pswrdField.getPassword().toString() , register.gender, register.txtFieldCity.getText());
		if(validate.isSignUpDataValid())
		{
			Authenticate auth = new Authenticate("Registration Task");
			auth.setUsername(register.txtFieldName.getText());
			if(auth.matchUserName())
			{
				msg = "The username already exists, choose a different one.";
				System.out.println("The username already exists, choose a different one.");
				JOptionPane.showMessageDialog(null,"The username already exists, choose a different one.");
			}else
			{
				//store the user inputs in the user_Info table
				registrationDAO.insertNewUser(register.txtFieldName.getText(), register.encrypt(register.pswrdField.getPassword().toString()), register.gender, register.txtFieldCity.getText());
				ArrayList<String> newList = new ArrayList<>();
				newList = registrationDAO.getUserProfile(register.txtFieldName.getText());
				
				//to see the profile of newly added user
				for(String str: newList)
				{
					System.out.println(str);
				}	

				msg = "";
			}
		}
		//assert Test for Registration.java
		assertNotEquals("The username already exists, choose a different one.", msg);
		
		Home home = new Home();
		
		 home.txtFieldName.setText("Sarah");
		  home.pswrdField.setText("Sarah123");
		  home.btnLogin.setSelected(true);
		  
		  if(home.btnLogin.isSelected())
		  {
			  validate = new  Validate(home.txtFieldName.getText(),home.pswrdField.getPassword().toString());
			  if(validate.isLoginDataValid()) 
				  
			  {
				  Authenticate auth = new Authenticate("Login Task");
					auth.setUsername(home.txtFieldName.getText());
					String password = new String(home.pswrdField.getPassword());
					String encryptedPassword = Home.encrypt(password);
					auth.setPassword(encryptedPassword);
					
					if(auth.matchUserName() && auth.matchpassword())
					{					
						JOptionPane.showMessageDialog(null,"Login Successful");
						msg = "Login Successful";
					}
			  
			  }	  
		  }
		//assert Test for Home.java
		  assertEquals("Login Successful", msg); 
	}

}
