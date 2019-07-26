package com.csis.ControllerTests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

import com.csis.Boundary.Home;
import com.csis.Controller.Authenticate;
import com.csis.Controller.Validate;


class IntegrationTestHome {
	 Home home = new Home();
	String msg = "";
	
	  @Test void testA_UserNameBlank() {
		 
	  home.txtFieldName.setText("");
	  home.pswrdField.setText("Sarah123");
	  home.btnLogin.setSelected(true);
	  
	  if(home.btnLogin.isSelected())
	  {
		  Validate validate = new  Validate(home.txtFieldName.getText(),home.pswrdField.getPassword().toString());
		  if(!validate.isLoginDataValid()) 
			  msg = validate.errorMsg;
		  
	  }	  
	  assertEquals("No field should be empty", msg);
	  
	  }
	 
	  @Test void testB_PasswordBlank() {
			 
		  home.txtFieldName.setText("Sarah");
		  home.pswrdField.setText("");		  
		  home.btnLogin.setSelected(true);
		  
		  if(home.btnLogin.isSelected())
		  {
			  Validate validate = new  Validate(home.txtFieldName.getText(),home.pswrdField.getPassword().toString());
			  if(!validate.isLoginDataValid()) 
				  msg = validate.errorMsg;
		  }	
		  	assertEquals("No field should be empty", msg);
		  
		  }
	  
	  @Test void testC_ValidLoginData() {
		  
		  home.txtFieldName.setText("Sarah");
		  home.pswrdField.setText("Sarah123");
		  home.btnLogin.setSelected(true);
		  
		  if(home.btnLogin.isSelected())
		  {
			  Validate validate = new  Validate(home.txtFieldName.getText(),home.pswrdField.getPassword().toString());
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
		  assertEquals("Login Successful", msg); 
	  }
	  
	  @Test void testD_InValidLoginData() {
		  
		  home.txtFieldName.setText("Sar");
		  home.pswrdField.setText("Sarah456");
		  home.btnLogin.setSelected(true);
		  
		  if(home.btnLogin.isSelected())
		  {
			  Validate validate = new  Validate(home.txtFieldName.getText(),home.pswrdField.getPassword().toString());
			  if(validate.isLoginDataValid()) 	  
			  {
				  Authenticate auth = new Authenticate("Login Task");
					auth.setUsername(home.txtFieldName.getText());
					String password = new String(home.pswrdField.getPassword());
					String encryptedPassword = Home.encrypt(password);
					auth.setPassword(encryptedPassword);
					
					System.out.println("P:  "+ auth.getPassword() + "U: "+ home.txtFieldName.getText());
					if(!(auth.matchUserName() && auth.matchpassword()))
					{
						JOptionPane.showMessageDialog(null,"Wrong username or password.");
						msg = "Wrong username or password.";
					}
			  }	
		  }
		  assertEquals("Wrong username or password.", msg); 
	  }
}
