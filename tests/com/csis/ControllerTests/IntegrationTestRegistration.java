package com.csis.ControllerTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.csis.Boundary.Home;
import com.csis.Boundary.Registration;
import com.csis.Controller.Validate;

class IntegrationTestRegistration {

	String msg = "";
	Registration reg = new Registration();

	@Test void testA_AnyBlankField() {
		
		reg.txtFieldName.setText("");
		reg.pswrdField.setText("Sarah123");
		reg.gender = "Female";
		reg.txtFieldCity.setText("");
		reg.btnSignUp.setSelected(true);
		if(reg.btnSignUp.isSelected())
		  { 
			 Validate validate = new Validate(reg.txtFieldName.getText(),reg.pswrdField.getPassword().toString(),reg.gender,reg.txtFieldCity.getText());
			  if(!validate.isSignUpDataValid()) 
				  msg = validate.errorMsg;			  
		  }	  
		  	assertEquals("No field should be empty", msg);		  
		  }
	
	@Test void testB_PasswordFieldLength() {
		reg = new Registration();
		reg.txtFieldName.setText("Sarah");
		reg.pswrdField.setText("Sh12");
		reg.gender = "Female";
		reg.txtFieldCity.setText("Burnaby");
		reg.btnSignUp.setSelected(true);
		if(reg.btnSignUp.isSelected())
		  { 
			 Validate validate = new Validate(reg.txtFieldName.getText(),reg.pswrdField.getText(),reg.gender,reg.txtFieldCity.getText());
			  if(!validate.isSignUpDataValid()) 
			  {
				  msg = validate.errorMsg;
			  }
		  }	 
		 System.out.println(msg);
		  	assertEquals("Password should contain atleast 5 characters!!\n", msg);		  
		  }
	
	@Test void testB_PasswordFieldStrength() {
		reg = new Registration();
		reg.txtFieldName.setText("Sarah");
		reg.pswrdField.setText("Shhdbch");
		reg.gender = "Female";
		reg.txtFieldCity.setText("Burnaby");
		reg.btnSignUp.setSelected(true);
		if(reg.btnSignUp.isSelected())
		  { 
			 Validate validate = new Validate(reg.txtFieldName.getText(),reg.pswrdField.getText(),reg.gender,reg.txtFieldCity.getText());
			  if(!validate.isSignUpDataValid()) 
			  {
				  msg = validate.errorMsg;
			  }
		  }	 
		 System.out.println(msg);
		  	assertEquals("Password must contain atleast one digit!!\n", msg);		  
		  }
}
