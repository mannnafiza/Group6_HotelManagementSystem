package com.csis.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.csis.Boundary.DBHelper;
import com.csis.Entities.Transaction;

public class PaymentDAO {

	DBHelper helper = new DBHelper();
	private PreparedStatement pstmt = null;
	
	
	/**
	  * @param t instance of Transaction Entity class
	  */
	public void addtransactionEntry(Transaction t) {
		// TODO Auto-generated method stub
		
		 String insertSql = "INSERT INTO transactions_info (Date, Time, userId, userName, amountPaid, paymentMode, cardNumber, cardExpiryDate, cardSecurityCode) " +
	  				"values (?,?,?,?,?,?,?,?,?)";
		  
		  try {
			  helper.connectDB();
			  
			  //create statement
			  pstmt = helper.getConnection().prepareStatement(insertSql);
			  
			  //set the parameters of query
			  pstmt.setString(1, t.getDate());
			  pstmt.setString(2, t.getTime());
			  pstmt.setInt(3, t.getUserId());
			  pstmt.setString(4, t.getUserName());
			  pstmt.setFloat(5, t.getAmountPaid());
			  pstmt.setString(6, t.getPaymentMode());
			  pstmt.setLong(7, t.getCardNumber());
			  pstmt.setString(8, t.getExpiryDate());
			  pstmt.setInt(9, t.getCode());
			  
			  //execute			  
			  pstmt.executeUpdate();
			  
			  helper.disconnectDB();
		  } catch(SQLException sx) {
			  System.out.println("Error inserting data into the transaction table");
			  System.out.println(sx.getMessage()); 
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState());
		  }
	}
}
