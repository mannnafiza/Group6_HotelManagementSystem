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

		JLabel lblModeOfPayment = new JLabel("Card");
		lblModeOfPayment.setBounds(281, 163, 67, 22);
		lblModeOfPayment.setForeground(color);
		frame.getContentPane().add(lblModeOfPayment);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(201, 210, 218));
		panel.setBounds(104, 209, 263, 58);
		frame.getContentPane().add(panel);
		panel.setVisible(false);
		panel.setLayout(null);

		JLabel lblCard = new JLabel("Card Number");
		lblCard.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCard.setBounds(30, 0, 95, 22);
		lblCard.setForeground(color);
		panel.add(lblCard);

		JLabel lblCardNum = new JLabel("1213");
		lblCardNum.setBounds(186, 0, 67, 22);
		lblCardNum.setForeground(color);
		panel.add(lblCardNum);

		JLabel lblExpiryDate = new JLabel("Expiry Date");
		lblExpiryDate.setForeground(color);
		lblExpiryDate.setBounds(30, 33, 82, 22);

		panel.add(lblExpiryDate);

		JLabel lblExpDateValue = new JLabel("");
		lblExpDateValue.setBounds(116, 33, 82, 22);
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
		lblDateValue.setBounds(462, 22, 67, 22);
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
		if (lblModeOfPayment.equals("Cash"))
			panel.setVisible(false);
		else
			panel.setVisible(true);
		lblCardNum.setText(Integer.toString(t.getCardNumber()));
		lblExpiryDate.setText(t.getExpiryDate());

		JButton btnSaveReceipt = new JButton("Save Purchase");
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

		btnContinue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Reservation.main(null, user);
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

	/*	
		*//**
			 * @param user current instance of UserInfo Entity class
			 * @return contents of expenses_info table for specific user
			 */
	/*
	 * public ArrayList<String> getBillData(UserInfo user) { ArrayList<String> s1 =
	 * new ArrayList<String>();
	 * 
	 * String sql = "SELECT * FROM expenses_info where userName = ?";
	 * 
	 * try { helper.connectDB();
	 * 
	 * //create statement pstmt = helper.getConnection().prepareStatement(sql);
	 * 
	 * pstmt.setString(1, user.getUsername()); rs = pstmt.executeQuery();
	 * while(rs.next()) { s1.add("Bill Id: " + rs.getInt("billId") + "\n" + "Date: "
	 * + rs.getString("Date") + ", Time: " + rs.getString("Time") + ", User Name: "
	 * + rs.getString("userName") + "Room Status: " + rs.getString("isRoomReserved")
	 * + ", Meeting Hall Status:" + rs.getString("isHallReserved") +
	 * ", Restaurant Status: " + rs.getString("isRestaurantReserved") +
	 * "Banquet Status: " + rs.getString("isBanquetReserved") + ", Room Total: " +
	 * rs.getFloat("roomTotal") + "Meeting Hall Total: " + rs.getFloat("hallTotal")
	 * + ", Restaurant Total: " + rs.getFloat("restaurantTotal") + "Bnaquet Total: "
	 * + rs.getFloat("banquetTotal") + ", Total Amount: " +
	 * rs.getFloat("totalAmount") + ", Discount: " + rs.getFloat("discount") +
	 * ", Final Amount: " + rs.getFloat("finalAmount")); System.out.println(s1); }
	 * helper.disconnectDB(); }catch(SQLException sx) {
	 * System.out.println("Error fetching data from the database");
	 * System.out.println(sx.getMessage()); System.out.println(sx.getErrorCode());
	 * System.out.println(sx.getSQLState()); }
	 * 
	 * return s1;
	 * 
	 * }
	 * 
	 *//**
		 * 
		 * @param fileName is the name of the file to be created
		 * @return the message for confirmation of file generation
		 *//*
			 * public String writeToFile(String fileName, ArrayList<String> data) {
			 * PrintWriter writer = null; try { writer = new PrintWriter(fileName + ".txt",
			 * "UTF-8"); } catch (FileNotFoundException e1) { // TODO Auto-generated catch
			 * block e1.printStackTrace(); return "Report Not Generated"; } catch
			 * (UnsupportedEncodingException e1) { // TODO Auto-generated catch block
			 * e1.printStackTrace(); return "Report Not Generated"; }
			 * 
			 * for(int i = 0; i < data.size(); i++) { writer.println(data.get(i) + "\n");
			 * writer.println(
			 * "---------------------------------------------------------------------------------------------------------------------------"+
			 * "---------------------------------------------------------------------------------------------------------------------------"
			 * ); }
			 * 
			 * writer.close(); return "Report Generated"; }
			 */
}
