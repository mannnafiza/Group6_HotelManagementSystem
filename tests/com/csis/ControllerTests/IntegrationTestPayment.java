package com.csis.ControllerTests;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;
import com.csis.Boundary.Payment;
import com.csis.Controller.Validate;
import com.csis.Entities.BillingData;
import com.csis.Entities.UserInfo;

class IntegrationTestPayment {

	String msg = "";
	Payment payment;
	BillingData bill = new BillingData();
	UserInfo user = new UserInfo();

	@Test void testA_CardNumberBlankField() {
		
		payment = new Payment(bill, user);
		payment.textFieldcardNum.setText("");
		payment.textFieldExpiryDate.setText("12/22");
		payment.textFieldSecurityCode.setText("500");
		payment.btnPay.setSelected(true);
		if(payment.btnPay.isSelected())
		  { 
			 Validate validate = new Validate(payment.textFieldcardNum.getText(),payment.textFieldExpiryDate.getText(),payment.textFieldSecurityCode.getText());
			 if(!validate.istransactionDataValid()) 
				  msg = validate.errorMsg;			  
		  }	  
		  	assertEquals("CardNumber must have length 8\n", msg);		  
	}
	
	@Test void testB_ExpiryDateFieldNotInFormat() {
		
		payment = new Payment(bill, user);
		payment.textFieldcardNum.setText("12345678");
		payment.textFieldExpiryDate.setText("12+22");
		payment.textFieldSecurityCode.setText("500");
		payment.btnPay.setSelected(true);
		if(payment.btnPay.isSelected())
		  { 
			 Validate validate = new Validate(payment.textFieldcardNum.getText(),payment.textFieldExpiryDate.getText(),payment.textFieldSecurityCode.getText());
			 if(!validate.istransactionDataValid()) 
				  msg = validate.errorMsg;			  
		  }	  
		  	assertEquals("Expiry Date must be in format MM/YY.\n", msg);		  
		 }

	@Test void testC_SecurityCodeContainsAlphabet() {
		
		payment = new Payment(bill, user);
		payment.textFieldcardNum.setText("12345678");
		payment.textFieldExpiryDate.setText("12/22");
		payment.textFieldSecurityCode.setText("5ff");
		payment.btnPay.setSelected(true);
		if(payment.btnPay.isSelected())
		  { 
			 Validate validate = new Validate(payment.textFieldcardNum.getText(),payment.textFieldExpiryDate.getText(),payment.textFieldSecurityCode.getText());
			 if(!validate.istransactionDataValid()) 
				  msg = validate.errorMsg;			  
		  }	  
		  	assertEquals("Security Code should contain only digits.\n", msg);		  
		 }
	
	@Test void testD_ValidCardDetails() {
		
		payment = new Payment(bill, user);
		payment.textFieldcardNum.setText("12345678");
		payment.textFieldExpiryDate.setText("12/22");
		payment.textFieldSecurityCode.setText("505");
		payment.btnPay.setSelected(true);
		if(payment.btnPay.isSelected())
		  { 
			 Validate validate = new Validate(payment.textFieldcardNum.getText(),payment.textFieldExpiryDate.getText(),payment.textFieldSecurityCode.getText());
			 if(validate.istransactionDataValid()) 
			 {
				 msg = "Payment Successful.\n";		
				 JOptionPane.showMessageDialog(null, msg);
			 }
		  }	  
		  	assertEquals("Payment Successful.\n", msg);		  
		 }
}
