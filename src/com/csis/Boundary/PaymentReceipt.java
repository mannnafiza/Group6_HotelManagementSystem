package com.csis.Boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.csis.Controller.PaymentReceiptDAO;
import com.csis.Entities.Transaction;
import com.csis.Entities.UserInfo;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class PaymentReceipt {

	private JFrame frame;
	private Transaction t;
	public JLabel lblModeOfPayment;
	public JButton btnSaveReceipt;
	DBHelper helper = new DBHelper();
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	UserInfo user;
	PaymentReceiptDAO paymentReceiptDAO = new PaymentReceiptDAO();
	

	/**
	 * Launch the application.
	 * 
	 * @param t
	 */
	public static void main(String[] args, Transaction t, UserInfo user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentReceipt window = new PaymentReceipt(t, user);
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
	public PaymentReceipt(Transaction t, UserInfo user) {
		this.t = t;
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

		JLabel lblPayer = new JLabel("Payer");
		lblPayer.setForeground(color);
		lblPayer.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPayer.setBounds(129, 74, 67, 22);
		frame.getContentPane().add(lblPayer);

		JLabel lblName = new JLabel("");
		lblName.setForeground(color);
		lblName.setBounds(281, 74, 67, 22);
		frame.getContentPane().add(lblName);

		JLabel lblCustomerReceipt = new JLabel("Customer Receipt");
		lblCustomerReceipt.setForeground(color);
		lblCustomerReceipt.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lblCustomerReceipt.setBounds(165, 11, 183, 37);
		frame.getContentPane().add(lblCustomerReceipt);

		JLabel lblAmount = new JLabel("Amount Paid");
		lblAmount.setForeground(color);
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAmount.setBounds(129, 118, 89, 22);
		frame.getContentPane().add(lblAmount);

		JLabel lblAmountValue = new JLabel("0.0");
		lblAmountValue.setBounds(281, 118, 67, 22);
		lblAmountValue.setForeground(color);
		frame.getContentPane().add(lblAmountValue);

		JLabel lblPaymentMode = new JLabel("Payment Mode");
		lblPaymentMode.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPaymentMode.setBounds(129, 163, 130, 22);
		lblPaymentMode.setForeground(color);
		frame.getContentPane().add(lblPaymentMode);

		lblModeOfPayment = new JLabel("Card");
		lblModeOfPayment.setBounds(281, 163, 67, 22);
		lblModeOfPayment.setForeground(color);
		frame.getContentPane().add(lblModeOfPayment);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(201, 210, 218));
		panel.setBounds(104, 209, 323, 115);
		frame.getContentPane().add(panel);
		panel.setVisible(false);
		panel.setLayout(null);

		JLabel lblCard = new JLabel("Card Number");
		lblCard.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCard.setBounds(28, 0, 95, 22);
		lblCard.setForeground(color);
		panel.add(lblCard);

		JLabel lblCardNum = new JLabel("");
		lblCardNum.setBounds(182, 0, 67, 22);
		lblCardNum.setForeground(color);
		panel.add(lblCardNum);

		JLabel lblExpiryDate = new JLabel("Expiry Date");
		lblExpiryDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblExpiryDate.setForeground(color);
		lblExpiryDate.setBounds(30, 33, 82, 22);
		panel.add(lblExpiryDate);

		JLabel lblExpDateValue = new JLabel("00");
		lblExpDateValue.setForeground(color);
		lblExpDateValue.setBounds(181, 33, 82, 22);
		panel.add(lblExpDateValue);

		JLabel lbldate = new JLabel("Date");
		lbldate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbldate.setForeground(color);
		lbldate.setBounds(407, 22, 45, 22);
		frame.getContentPane().add(lbldate);

		JLabel lblTime = new JLabel("Time");
		lblTime.setForeground(color);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTime.setBounds(407, 52, 45, 22);
		frame.getContentPane().add(lblTime);

		JLabel lblDateValue = new JLabel("");
		lblDateValue.setBounds(462, 22, 107, 22);
		lblDateValue.setForeground(color);
		frame.getContentPane().add(lblDateValue);

		JLabel lblTimeValue = new JLabel("");
		lblTimeValue.setBounds(462, 52, 67, 22);
		lblTimeValue.setForeground(color);
		frame.getContentPane().add(lblTimeValue);

		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(color);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setBounds(46, 351, 89, 23);
		frame.getContentPane().add(btnExit);

		JButton btnContinue = new JButton("Continue Reservation");
		btnContinue.setForeground(color);
		btnContinue.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnContinue.setBounds(187, 351, 203, 23);
		frame.getContentPane().add(btnContinue);

		lblDateValue.setText(t.getDate());
		lblTimeValue.setText(t.getTime());
		lblName.setText(user.getUsername());
		lblAmountValue.setText(Float.toString(t.getAmountPaid()));
		lblModeOfPayment.setText(t.getPaymentMode());
		
		/**
		 * Option card or cash for customer
		 */
		if (lblModeOfPayment.getText().equals("Cash"))
			panel.setVisible(false);
		else if(lblModeOfPayment.getText().equals("Card"))
		{
			
			lblCardNum.setText(Integer.toString(t.getCardNumber()));
			lblExpDateValue.setText(t.getExpiryDate());
			panel.setVisible(true);
		}
		
		/**
		 * button event listener
		 */
		btnSaveReceipt = new JButton("Save Receipt");
		btnSaveReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> billsData = null;
				billsData = paymentReceiptDAO.getBillData(user);
				System.out.println("<<<<<<<<<<<<<Bill Data>>>>>>>>>>>>>>>>.");
				paymentReceiptDAO.writeToFile("Bills_Report", billsData);
			}
		});
		btnSaveReceipt.setForeground(new Color(85, 96, 128));
		btnSaveReceipt.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSaveReceipt.setBounds(413, 351, 203, 23);
		frame.getContentPane().add(btnSaveReceipt);
		
		
		/**
		 * button event listener
		 */
		btnContinue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Reservation.main(null, user);
			}
		});
		
		
		/**
		 * button event listener
		 */
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
