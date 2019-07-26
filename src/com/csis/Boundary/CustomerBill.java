package com.csis.Boundary;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.csis.Controller.BillCalculatorDAO;
import com.csis.Entities.BillingData;
import com.csis.Entities.UserInfo;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class CustomerBill {

	private JFrame frame;
	public JLabel lblBillFor;
	JLabel lblYourReservations;
	public JTextArea textAreaEntries;
	JLabel lblDateValue;
	BillingData bill = new BillingData();
	BillingData bill2 = new BillingData();
	DBHelper helper = new DBHelper();
	public JButton btnPayBill;
	private JScrollPane scrollPane;
	private UserInfo user = new UserInfo();
	private BillCalculatorDAO billCalculatorDAO = new BillCalculatorDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, BillingData bill,UserInfo user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerBill window = new CustomerBill(bill,user);
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
	public CustomerBill(BillingData bill, UserInfo user) {
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
		frame.getContentPane().setBackground(new Color(201, 210, 218));
		frame.getContentPane().setLayout(null);
		
		Color color = new Color(85, 96, 128);
		
		lblBillFor = new JLabel("Bill for");
		lblBillFor.setForeground(color);
		lblBillFor.setBounds(324, 11, 244, 29);
		lblBillFor.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		frame.getContentPane().add(lblBillFor);
		
		lblYourReservations = new JLabel("Your Reservations:");
		lblYourReservations.setBounds(32, 49, 142, 21);
		lblYourReservations.setForeground(color);
		lblYourReservations.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		frame.getContentPane().add(lblYourReservations);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 81, 770, 323);
		frame.getContentPane().add(scrollPane);
		
		textAreaEntries = new JTextArea();
		scrollPane.setViewportView(textAreaEntries);
		textAreaEntries.setForeground(color);
		
		btnPayBill = new JButton("Pay Bill");
		btnPayBill.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPayBill.setForeground(color);
		btnPayBill.setBounds(361, 415, 89, 23);
		frame.getContentPane().add(btnPayBill);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(color);
		lblDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDate.setBackground(new Color(95, 158, 160));
		lblDate.setBounds(604, 18, 46, 14);
		frame.getContentPane().add(lblDate);
		
		lblDateValue = new JLabel("");
		lblDateValue.setForeground(color);
		lblDateValue.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDateValue.setBackground(new Color(95, 158, 160));
		lblDateValue.setBounds(660, 15, 161, 20);
		frame.getContentPane().add(lblDateValue);
				
		
		show(bill);
		
		//method to store billing details in expenses table
		billCalculatorDAO.addBillEntry(user,bill);
		btnPayBill.addActionListener(new ActionListener()
		{		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Payment.main(null,bill, user);
				frame.dispose();
			}
		});
		
	}

	public void show(BillingData bill) {
		// TODO Auto-generated method stub
		lblBillFor.setText("Bill for " + bill.getName());
		lblDateValue.setText(bill.getDate());
		textAreaEntries.setText(bill.prepareBill());
		
	}
}
