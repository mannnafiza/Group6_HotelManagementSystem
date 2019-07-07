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

public class CustomerReceipt {

	private JFrame frame;
	private JTextField textField_1;
	private JLabel lblBillFor;
	BillingData bill = new BillingData();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerReceipt window = new CustomerReceipt();
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
	public CustomerReceipt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 581, 462);
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.getContentPane().setLayout(null);
		
		lblBillFor = new JLabel("Bill for");
		lblBillFor.setForeground(new Color(255, 255, 255));
		lblBillFor.setBounds(229, 43, 161, 29);
		lblBillFor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		frame.getContentPane().add(lblBillFor);
				
		show(bill);
		
	}

	private void show(BillingData bill) {
		// TODO Auto-generated method stub
		lblBillFor.setText("Bill for " + bill.getName());
	}
}
