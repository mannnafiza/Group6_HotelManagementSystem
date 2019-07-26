package com.csis.Boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import com.csis.Controller.PaymentDAO;
import com.csis.Controller.Validate;
import com.csis.Entities.BillingData;
import com.csis.Entities.Transaction;
import com.csis.Entities.UserInfo;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Payment {

	public JFrame frame;
	UserInfo user;
	BillingData bill = new BillingData();
	public ButtonGroup btngrp = new ButtonGroup();
	public JTextField textFieldSecurityCode;
	public JTextField textFieldcardNum;
	public JTextField textFieldExpiryDate;
	public JRadioButton rdbtnCard;
	public JRadioButton rdbtnCash;
	public JButton btnPay;
	String modeOfPayment = "";
	String cardNumber;
	String expirydate;
	String code;
	DBHelper helper = new DBHelper();
	Transaction t = new Transaction();
	PaymentDAO paymentDAO = new PaymentDAO();
	JOptionPane jop = new JOptionPane();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args,BillingData bill, UserInfo user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment window = new Payment(bill, user);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Payment(BillingData bill, UserInfo user) {
		this.bill = bill;
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(201, 210, 218));
		frame.setBackground(UIManager.getColor("ComboBox.buttonDarkShadow"));
		frame.setBounds(100, 100, 642, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Color color = new Color(85, 96, 128);
		
		JLabel lblAmount = new JLabel("Amount To Be Paid : ");
		lblAmount.setForeground(color);
		lblAmount.setBounds(58, 32, 136, 22);
		lblAmount.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frame.getContentPane().add(lblAmount);
		
		JLabel lblAmountValue = new JLabel("");
		lblAmountValue.setForeground(color);
		lblAmountValue.setText(Float.toString(bill.getFinalAmount()));
		lblAmountValue.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblAmountValue.setBounds(204, 32, 136, 22);
		frame.getContentPane().add(lblAmountValue);
		
		JLabel lblPaymentMethod = new JLabel("Payment Method:");
		lblPaymentMethod.setForeground(color);
		lblPaymentMethod.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblPaymentMethod.setBounds(58, 65, 136, 22);
		frame.getContentPane().add(lblPaymentMethod);
		
		rdbtnCard = new JRadioButton("Card");
		rdbtnCard.setBounds(275, 64, 68, 23);
		frame.getContentPane().add(rdbtnCard);
		rdbtnCard.setBackground(new Color(201, 210, 218));
		rdbtnCard.setForeground(color);
		rdbtnCard.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		rdbtnCash = new JRadioButton("Cash");
		rdbtnCash.setSelected(true);
		rdbtnCash.setBackground(new Color(201, 210, 218));
		rdbtnCash.setForeground(color);
		rdbtnCash.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnCash.setBounds(186, 64, 105, 23);
		frame.getContentPane().add(rdbtnCash);
		
		btngrp.add(rdbtnCard);
		btngrp.add(rdbtnCash);
		
		JPanel panel = new JPanel();
		panel.setBounds(196, 98, 284, 205);
		panel.setBackground(new Color(201, 210, 218));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JLabel lblCodeIcon = new JLabel("");
		lblCodeIcon.setBounds(10, 102, 29, 32);
		panel.add(lblCodeIcon);
		
		JLabel lblExpiryIcon = new JLabel("");
		lblExpiryIcon.setBounds(10, 65, 29, 25);
		panel.add(lblExpiryIcon);
		
		textFieldcardNum = new JTextField("Card Number");
		textFieldcardNum.setBounds(49, 65, 199, 25);
		panel.add(textFieldcardNum);
		textFieldcardNum.setForeground(color);
		textFieldcardNum.setFont(new Font("Serif", Font.PLAIN, 16));
		textFieldcardNum.setColumns(10);
		
		JLabel lblCardIcon = new JLabel("");
		lblCardIcon.setBounds(10, 27, 29, 25);
		panel.add(lblCardIcon);
		
		textFieldSecurityCode = new JTextField("Security Code");
		textFieldSecurityCode.setBounds(47, 154, 201, 25);
		panel.add(textFieldSecurityCode);
		textFieldSecurityCode.setForeground(color);
		textFieldSecurityCode.setFont(new Font("Serif", Font.PLAIN, 16));
		textFieldSecurityCode.setColumns(10);
		
		JLabel lblEnterPaymentInformation = new JLabel("Enter Payment Information");
		lblEnterPaymentInformation.setForeground(color);
		lblEnterPaymentInformation.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 16));
		lblEnterPaymentInformation.setBounds(49, 11, 225, 32);
		panel.add(lblEnterPaymentInformation);
		
		textFieldExpiryDate = new JTextField("MM/YY");
		textFieldExpiryDate.setForeground(color);
		textFieldExpiryDate.setFont(new Font("Serif", Font.PLAIN, 16));
		textFieldExpiryDate.setColumns(10);
		textFieldExpiryDate.setBounds(49, 109, 199, 25);
		panel.add(textFieldExpiryDate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.setBounds(204, 354, 89, 23);
		btnCancel.setForeground(color);
		frame.getContentPane().add(btnCancel);
		
		btnPay = new JButton("Pay Now");
		btnPay.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPay.setForeground(color);
		btnPay.setBounds(358, 354, 89, 23);
		frame.getContentPane().add(btnPay);
		
		rdbtnCard.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

					panel.setVisible(true);		
			}
		});
		
		rdbtnCash.addActionListener(new ActionListener()
		{		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					panel.setVisible(false);	
			}
		});	 
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardNumber = "";
				expirydate = "";
				code = "";
				textFieldcardNum.setText("Card Number");
				textFieldExpiryDate.setText("MM/YY");
				textFieldSecurityCode.setText("Security Code");
			}
		});
		
		btnPay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				t.setUserId(bill.getUserId());
				t.setUserName(bill.getName());
				t.setAmountPaid(bill.getFinalAmount());
				
				if(rdbtnCash.isSelected()) {
		        	modeOfPayment = "Cash";
			      }else if(rdbtnCard.isSelected()) {
			    	  modeOfPayment = "Card";
			      }
				t.setPaymentMode(modeOfPayment);
				
				if(modeOfPayment.equals("Card"))
				{
					if(textFieldcardNum.getText().equals("Card Number") || textFieldExpiryDate.getText().equals("MM/YY") || textFieldSecurityCode.getText().equals("Security Code"))
					{
						jop.showMessageDialog(null," Blank input found.");
					}
					else
					{
					 cardNumber = textFieldcardNum.getText();
					 expirydate =  textFieldExpiryDate.getText();
					 code = textFieldSecurityCode.getText();
					 System.out.println("Mode: "+ modeOfPayment);
						System.out.println("CardNum: "+ cardNumber);
						System.out.println("Expiry Date: "+ expirydate);
						System.out.println("code: "+ code);
						
					//method to check for blank user inputs
					Validate validate = new Validate(cardNumber,expirydate,code);
					if(validate.istransactionDataValid())
					{

						t.setCardNumber(Integer.parseInt(cardNumber));
						t.setExpiryDate(expirydate);
						t.setCode(Integer.parseInt(code));
					
					//set current date and time as class field values for Transaction class
					Date currentDate = new Date();
					String date = DateFormat.getDateInstance().format(currentDate); 
					t.setDate(date);
					String time = DateFormat.getTimeInstance().format(currentDate);
					t.setTime(time);
					
					
					jop.showMessageDialog(null," Payment Successful.");
					
					//method call to add transaction to the database
					paymentDAO.addtransactionEntry(t);
					PaymentReceipt.main(null,t, user);
					
					frame.dispose();
					}
					}
					
				}else
				{
					System.out.println("Mode: "+ modeOfPayment);
					t.setCardNumber(0);
					t.setExpiryDate(null);
					t.setCode(0);
					
					//set current date and time as class field values for Transaction class
					Date currentDate = new Date();
					String date = DateFormat.getDateInstance().format(currentDate); 
					t.setDate(date);
					String time = DateFormat.getTimeInstance().format(currentDate);
					t.setTime(time);
					
					
					jop.showMessageDialog(null," Payment Successful.");
					
					//method call to add transaction to the database
					paymentDAO.addtransactionEntry(t);
					PaymentReceipt.main(null,t, user);
					
					frame.dispose();
				}
				
				
			}
		});
	}
}
