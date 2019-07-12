package com.csis.Boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.csis.Entities.Transaction;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PaymentReceipt {

	private JFrame frame;
	private Transaction t;

	/**
	 * Launch the application.
	 * @param t 
	 */
	public static void main(String[] args, Transaction t) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentReceipt window = new PaymentReceipt(t);
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
	public PaymentReceipt(Transaction t) {
		this.t = t;
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
		
		JLabel lblPayer = new JLabel("Payer");
		lblPayer.setBounds(165, 64, 67, 22);
		frame.getContentPane().add(lblPayer);
		
		JLabel lblName = new JLabel("");
		lblName.setBounds(281, 64, 67, 22);
		frame.getContentPane().add(lblName);
		
		JLabel lblCustomerReceipt = new JLabel("Customer Receipt");
		lblCustomerReceipt.setBounds(214, 11, 114, 37);
		frame.getContentPane().add(lblCustomerReceipt);
		
		JLabel lblAmount = new JLabel("Amount Paid");
		lblAmount.setBounds(165, 100, 67, 22);
		frame.getContentPane().add(lblAmount);
		
		JLabel lblAmountValue = new JLabel("0.0");
		lblAmountValue.setBounds(281, 97, 67, 22);
		frame.getContentPane().add(lblAmountValue);
		
		JLabel lblPaymentMode = new JLabel("Payment Mode");
		lblPaymentMode.setBounds(165, 133, 82, 22);
		frame.getContentPane().add(lblPaymentMode);
		
		JLabel lblModeOfPayment = new JLabel("Card");
		lblModeOfPayment.setBounds(281, 130, 67, 22);
		frame.getContentPane().add(lblModeOfPayment);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(165, 163, 198, 58);
		frame.getContentPane().add(panel);
		panel.setVisible(false);
		panel.setLayout(null);
		
		JLabel lblCard = new JLabel("Card Number");
		lblCard.setBounds(0, 3, 82, 22);
		panel.add(lblCard);
		
		JLabel lblCardNum = new JLabel("1213");
		lblCardNum.setBounds(116, 0, 67, 22);
		panel.add(lblCardNum);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date");
		lblExpiryDate.setBounds(0, 36, 82, 22);
		panel.add(lblExpiryDate);
		
		JLabel lblExpDateValue = new JLabel("");
		lblExpDateValue.setBounds(116, 33, 82, 22);
		panel.add(lblExpDateValue);
		
		JLabel lbldate = new JLabel("Date");
		lbldate.setBounds(407, 22, 45, 22);
		frame.getContentPane().add(lbldate);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(407, 52, 45, 22);
		frame.getContentPane().add(lblTime);
		
		JLabel lblDateValue = new JLabel("");
		lblDateValue.setBounds(462, 22, 67, 22);
		frame.getContentPane().add(lblDateValue);
		
		JLabel lblTimeValue = new JLabel("");
		lblTimeValue.setBounds(462, 52, 67, 22);
		frame.getContentPane().add(lblTimeValue);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(158, 260, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JButton btnContinue = new JButton("Continue Reservation");
		btnContinue.setBounds(294, 260, 133, 23);
		frame.getContentPane().add(btnContinue);
		
		lblDateValue.setText(t.getDate());
		lblTimeValue.setText(t.getTime());
		lblName.setText(t.getUserName());
		lblAmountValue.setText(Float.toString(t.getAmountPaid()));
		lblModeOfPayment.setText(t.getPaymentMode());
		if(lblModeOfPayment.equals("Cash"))
			panel.setVisible(false);
		else
			panel.setVisible(true);
		lblCardNum.setText(Integer.toString(t.getCardNumber()));
		lblExpiryDate.setText(t.getExpiryDate());
		
		
		btnContinue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//Reservation.main(null, user);
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Home.main(null);
				frame.dispose();
			}
		});
	}

}
