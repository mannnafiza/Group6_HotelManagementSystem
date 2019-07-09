package com.csis.Boundary;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.csis.Entities.BillingData;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CustomerReceipt {

	private JFrame frame;
	private JLabel lblBillFor;
	JLabel lblYourReservations;
	JTextArea textAreaEntries;
	BillingData bill = new BillingData();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, BillingData bill) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerReceipt window = new CustomerReceipt(bill);
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
	public CustomerReceipt(BillingData bill) {
		this.bill = bill;
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
		
		textAreaEntries = new JTextArea();
		textAreaEntries.setForeground(new Color(0, 128, 128));
		textAreaEntries.setBounds(32, 81, 770, 323);
		frame.getContentPane().add(textAreaEntries);
		
		JButton btnPayBill = new JButton("Pay Bill");
		btnPayBill.setForeground(new Color(0, 128, 0));
		btnPayBill.setBounds(290, 415, 89, 23);
		frame.getContentPane().add(btnPayBill);
				
		show(bill);
		
	}

	private void show(BillingData bill) {
		// TODO Auto-generated method stub
		lblBillFor.setText("Bill for " + bill.getName());
		textAreaEntries.setText(bill.prepareBill());
		
	}
}
