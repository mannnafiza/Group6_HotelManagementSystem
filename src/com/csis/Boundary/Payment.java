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

import com.csis.Controller.Validate;
import com.csis.Entities.BillingData;
import com.csis.Entities.Transaction;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Payment {

	private JFrame frame;
	BillingData bill = new BillingData();
	private ButtonGroup btngrp = new ButtonGroup();
	private JTextField textFieldSecurityCode;
	private JTextField textFieldcardNum;
	private JTextField textFieldExpiryDate;
	String modeOfPayment;
	int cardNumber;
	String expirydate;
	int code;
	DBHelper helper = new DBHelper();
	Transaction t = new Transaction();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args,BillingData bill) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment window = new Payment(bill);
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
	public Payment(BillingData bill) {
		this.bill = bill;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.setBounds(100, 100, 581, 462);
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.getContentPane().setLayout(null);
		
		JLabel lblAmount = new JLabel("Amount To Be Paid : ");
		lblAmount.setBounds(58, 32, 136, 22);
		lblAmount.setForeground(new Color(255, 255, 255));
		lblAmount.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frame.getContentPane().add(lblAmount);
		
		JLabel lblAmountValue = new JLabel("");
		lblAmountValue.setForeground(Color.WHITE);
		lblAmountValue.setText(Float.toString(bill.getFinalAmount()));
		lblAmountValue.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblAmountValue.setBounds(204, 32, 136, 22);
		frame.getContentPane().add(lblAmountValue);
		
		JLabel lblPaymentMethod = new JLabel("Payment Method:");
		lblPaymentMethod.setForeground(Color.WHITE);
		lblPaymentMethod.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblPaymentMethod.setBounds(58, 65, 136, 22);
		frame.getContentPane().add(lblPaymentMethod);
		
		JRadioButton rdbtnCard = new JRadioButton("Card");
		rdbtnCard.setBounds(275, 64, 68, 23);
		frame.getContentPane().add(rdbtnCard);
		rdbtnCard.setBackground(new Color(95, 158, 160));
		rdbtnCard.setForeground(Color.WHITE);
		rdbtnCard.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JRadioButton rdbtnCash = new JRadioButton("Cash");
		rdbtnCash.setSelected(true);
		rdbtnCash.setBackground(new Color(95, 158, 160));
		rdbtnCash.setForeground(Color.WHITE);
		rdbtnCash.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnCash.setBounds(186, 64, 105, 23);
		frame.getContentPane().add(rdbtnCash);
		
		btngrp.add(rdbtnCard);
		btngrp.add(rdbtnCash);
		
		JPanel panel = new JPanel();
		panel.setBounds(196, 98, 284, 149);
		panel.setBackground(new Color(95, 158, 160));
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
		textFieldcardNum.setBounds(47, 25, 199, 25);
		panel.add(textFieldcardNum);
		textFieldcardNum.setForeground(new Color(51, 153, 102));
		textFieldcardNum.setFont(new Font("Serif", Font.PLAIN, 16));
		textFieldcardNum.setColumns(10);
		
		JLabel lblCardIcon = new JLabel("");
		lblCardIcon.setBounds(10, 27, 29, 25);
		panel.add(lblCardIcon);
		
		textFieldSecurityCode = new JTextField("Security Code");
		textFieldSecurityCode.setBounds(47, 102, 201, 25);
		panel.add(textFieldSecurityCode);
		textFieldSecurityCode.setForeground(new Color(51, 153, 102));
		textFieldSecurityCode.setFont(new Font("Serif", Font.PLAIN, 16));
		textFieldSecurityCode.setColumns(10);
		
		JLabel lblEnterPaymentInformation = new JLabel("Enter Payment Information");
		lblEnterPaymentInformation.setForeground(Color.WHITE);
		lblEnterPaymentInformation.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnterPaymentInformation.setBounds(57, -10, 173, 32);
		panel.add(lblEnterPaymentInformation);
		
		textFieldExpiryDate = new JTextField("MM/YY");
		textFieldExpiryDate.setForeground(new Color(51, 153, 102));
		textFieldExpiryDate.setFont(new Font("Serif", Font.PLAIN, 16));
		textFieldExpiryDate.setColumns(10);
		textFieldExpiryDate.setBounds(47, 65, 199, 25);
		panel.add(textFieldExpiryDate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(202, 258, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JButton btnPay = new JButton("Pay Now");
		btnPay.setBounds(338, 258, 89, 23);
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
		
		
	    
	    class RoomItemListener implements ItemListener {
   			@Override
	public void itemStateChanged(ItemEvent ex) {
		// TODO Auto-generated method stub
		String item = ((AbstractButton) ex.getItemSelectable()).getActionCommand();
        boolean selected = (ex.getStateChange() == ItemEvent.SELECTED);
        if(item.equals("Cash")) {
        	modeOfPayment = "Cash";
	      }else {
	    	  modeOfPayment = "Card";
	      }
	}
    }
	    
	    ItemListener il = new RoomItemListener();
		rdbtnCard.addItemListener(il);
		rdbtnCash.addItemListener(il);
		 
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardNumber = 0;
				expirydate = "";
				code = 0;
				textFieldcardNum.setText("");
				textFieldExpiryDate.setText("");
				textFieldSecurityCode.setText("");
			}
		});
		
		btnPay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				t.setUserId(bill.getUserId());
				t.setUserName(bill.getName());
				t.setAmountPaid(bill.getFinalAmount());
				t.setPaymentMode(modeOfPayment);
				
				if(modeOfPayment.equals("Card"))
				{
					 cardNumber = Integer.parseInt(textFieldcardNum.getText());
					 expirydate =  textFieldExpiryDate.getText();
					 code = Integer.parseInt(textFieldSecurityCode.getText());
					 System.out.println("Mode: "+ modeOfPayment);
						System.out.println("CardNum: "+ cardNumber);
						System.out.println("Expiry Date: "+ expirydate);
						System.out.println("code: "+ code);
						
					Validate validate = new Validate(cardNumber,expirydate,code);
					if(validate.istransactionDataValid())
					{

						t.setCardNumber(cardNumber);
						t.setExpiryDate(expirydate);
						t.setCode(code);
					}				
				}else
				{
					t.setCardNumber(0);
					t.setExpiryDate(null);
					t.setCode(0);
				}
				
				//set current date and time as class field values for Transaction class
				Date currentDate = new Date();
				String date = DateFormat.getDateInstance().format(currentDate); 
				t.setDate(date);
				String time = DateFormat.getTimeInstance().format(currentDate);
				t.setTime(time);
				
				JOptionPane jop = new JOptionPane();
				jop.showMessageDialog(null," Payment Successful.");
				
				//method call to add transaction to the database
				helper.addtransactionEntry(t);
				PaymentReceipt.main(null,t);
				
				frame.dispose();
			}
		});
	}
}
