package com.csis.Boundary;

import java.awt.EventQueue;
import java.awt.Font;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.csis.Entities.BillingData;
import com.csis.Entities.UserInfo;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class CustomerReceipt {

	private JFrame frame;
	private JLabel lblBillFor;
	JLabel lblYourReservations;
	JTextArea textAreaEntries;
	JLabel lblDateValue;
	BillingData bill = new BillingData();
	DBHelper helper = new DBHelper();
	private JScrollPane scrollPane;
	private UserInfo user = new UserInfo();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, BillingData bill,UserInfo user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerReceipt window = new CustomerReceipt(bill,user);
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
	public CustomerReceipt(BillingData bill, UserInfo user) {
		this.bill = bill;
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 818, 488);
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.getContentPane().setLayout(null);
		
		lblBillFor = new JLabel("Bill for");
		lblBillFor.setForeground(new Color(255, 255, 255));
		lblBillFor.setBounds(407, 11, 161, 29);
		lblBillFor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		frame.getContentPane().add(lblBillFor);
		
		lblYourReservations = new JLabel("Your Reservations:");
		lblYourReservations.setBounds(32, 49, 142, 21);
		lblYourReservations.setForeground(new Color(255, 255, 255));
		lblYourReservations.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		frame.getContentPane().add(lblYourReservations);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 81, 770, 323);
		frame.getContentPane().add(scrollPane);
		
		textAreaEntries = new JTextArea();
		scrollPane.setViewportView(textAreaEntries);
		textAreaEntries.setForeground(new Color(0, 128, 128));
		
		JButton btnPayBill = new JButton("Pay Bill");
		btnPayBill.setForeground(new Color(0, 128, 0));
		btnPayBill.setBounds(290, 415, 89, 23);
		frame.getContentPane().add(btnPayBill);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(new Color(255, 255, 255));
		lblDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDate.setBackground(new Color(95, 158, 160));
		lblDate.setBounds(604, 18, 46, 14);
		frame.getContentPane().add(lblDate);
		
		lblDateValue = new JLabel("");
		lblDateValue.setForeground(new Color(255, 255, 255));
		lblDateValue.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDateValue.setBackground(new Color(95, 158, 160));
		lblDateValue.setBounds(660, 15, 161, 20);
		frame.getContentPane().add(lblDateValue);
				
		
		show(bill);
		
		//method to store billing details in expenses table
		int id = helper.addBillEntry(user,bill);
		
		
	}

	private void show(BillingData bill) {
		// TODO Auto-generated method stub
		lblBillFor.setText("Bill for " + bill.getName());
		lblDateValue.setText(bill.getDate());
		textAreaEntries.setText(bill.prepareBill());
		
	}
}
