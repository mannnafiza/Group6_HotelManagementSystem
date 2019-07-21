package com.csis.Boundary;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.jws.soap.SOAPBinding.Use;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import com.csis.Entities.UserInfo;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.ListCellRenderer;
import javax.swing.JComboBox;

public class AdminHome {

	private JFrame frame;
	UserInfo user;
	private String choice = "";
	DBHelper helper = new DBHelper();
	private ResultSet rs = null;
	private Statement stmt = null;

	/**
	 * Launch the application
	 * @param args 
	 * @param user object of UserInfo
	 */
	public static void main(String[] args, UserInfo user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome window = new AdminHome(user);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application
	 * @param user object of UserInfo
	 */
	public AdminHome(UserInfo user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 642, 464);
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(201, 210, 218));
		frame.getContentPane().setLayout(null);
		
		Color color = new Color(85, 96, 128);
		
		JLabel lblReserve = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/reserve.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblReserve.setIcon(new ImageIcon(img));
		lblReserve.setBounds(50, 221, 108, 135);
		frame.getContentPane().add(lblReserve);
		
		JLabel lblReservation = new JLabel("Reservation");
		lblReservation.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblReservation.setForeground(color);
		lblReservation.setBounds(61, 367, 87, 31);
		frame.getContentPane().add(lblReservation);
		
		/**
		 * Event listener for reservation module
		 */
		lblReserve.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Reservation.main(null, user);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		JLabel lblStaff = new JLabel("");
		Image imgStaff = new ImageIcon(this.getClass().getResource("/staff.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblStaff.setIcon(new ImageIcon(imgStaff));
		lblStaff.setBounds(276, 237, 96, 119);
		frame.getContentPane().add(lblStaff);
		
		/**
		 * Event listener for staff module
		 */
		lblStaff.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				StaffCustomization.main(null);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel lblStaffText = new JLabel("Staff");
		lblStaffText.setForeground(color);
		lblStaffText.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStaffText.setBounds(298, 367, 61, 31);
		frame.getContentPane().add(lblStaffText);
		
		JLabel lblInventory = new JLabel("");
		Image imgInventory = new ImageIcon(this.getClass().getResource("/inventory.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblInventory.setIcon(new ImageIcon(imgInventory));
		lblInventory.setBounds(469, 232, 96, 119);
		frame.getContentPane().add(lblInventory);
		
		/**
		 * Event Listener for inventory module
		 */
		lblInventory.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				ManageInventory.main(null);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel lblInvenText = new JLabel("Inventory");
		lblInvenText.setForeground(color);
		lblInvenText.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInvenText.setBounds(479, 367, 77, 31);
		frame.getContentPane().add(lblInvenText);
		
		JLabel lblAdminIcon = new JLabel("");
		Image imgAdmin = new ImageIcon(this.getClass().getResource("/adminlogin.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblAdminIcon.setIcon(new ImageIcon(imgAdmin));
		lblAdminIcon.setBounds(261, 11, 123, 127);
		frame.getContentPane().add(lblAdminIcon);
		
		JLabel label_1 = new JLabel("ADMIN");
		label_1.setForeground(new Color(85, 96, 128));
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		label_1.setBounds(271, 147, 101, 23);
		frame.getContentPane().add(label_1);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin.main(null);
				frame.dispose();
			}
		});
		btnLogOut.setForeground(new Color(85, 96, 128));
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogOut.setBounds(527, 11, 89, 23);
		frame.getContentPane().add(btnLogOut);
		
		String[] reportArray = { "Reservation", "Inventory", "Transactions"};
		
		JComboBox comboBox = new JComboBox(reportArray);
		comboBox.setRenderer(new MyComboBoxRenderer("REPORT"));
		comboBox.setBounds(499, 60, 117, 20);
		comboBox.setSelectedIndex(-1);
		frame.getContentPane().add(comboBox);
		
		JButton btnGenerateReport = new JButton("Generate");
		btnGenerateReport.setVisible(false);
		
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if((String) comboBox.getSelectedItem() != "") {
					btnGenerateReport.setVisible(true);
					choice = (String) comboBox.getSelectedItem();
					System.out.println("<<<<<<<<<<<<<<<<<<<<<"+ choice+ ">>>>>>>>>>>>>>>>>>>>>>>>>>");
				}
				
				
				
			}
			
		});
		
		
		btnGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(choice.equals("Reservation")) {
					//helper.connectDB();
					ArrayList<String> reservationData = null;
					reservationData = getReservationData();
					
					writeToFile("Reservation_Report", reservationData);
					
				} else if(choice.equals("Inventory")) {
					ArrayList<String> inventoryData = null;
					inventoryData = getInventoryData();
					writeToFile("Inventory_Report", inventoryData);
				} else if(choice.equals("Transactions")) {
					ArrayList<String> transactionData = null;
					transactionData = getTransactionData();
					writeToFile("Transaction_Report", transactionData);
				}
				else {
					btnGenerateReport.setVisible(false);
				}
			}

			
		});
		btnGenerateReport.setForeground(new Color(85, 96, 128));
		btnGenerateReport.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGenerateReport.setBounds(499, 104, 117, 23);
		frame.getContentPane().add(btnGenerateReport);
		
		
		
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	
	/**
	 * 
	 * @return contents of reservation_info table
	 */
	public  ArrayList<String> getReservationData() {
		// TODO Auto-generated method stub
		ArrayList<String> s1 = new ArrayList<String>();
		  
		  String sql = "SELECT * FROM reservation_Info";
		  
		  try {
			  helper.connectDB();
			  this.stmt = helper.getConnection().createStatement();
				rs = stmt.executeQuery(sql);

				while (rs.next())
				{
				
				  s1.add("Id: " + rs.getInt("resId") + "\n" + "UserId: " + rs.getInt("userId") + ", Name: " + rs.getString("userName") +
						  ", Reservation Type: " + rs.getString("resType") + ", Room Type: " + rs.getString("roomType") + 
						  ", Stay Duration: " + rs.getString("stayDuration") + ", Meal Status: " + rs.getString("mealStatus") +
						   ", MealType: " + rs.getString("mealType") + ", Date: " + rs.getDate("resDate") + ", Time: " + rs.getTime("resTime") +
						    ", Meeting Duration: " + rs.getInt("meetingDuration") + ", Additional Service: " + rs.getInt("addService") +
						    ", No. of Guests: " + rs.getInt("noGuest") + ", Reservation For: " + rs.getString("resFor"));
				  System.out.println(s1);
			  }	  
		  helper.disconnectDB();
		  }catch(SQLException sx)
		  {
			  System.out.println("Error fetching data from the database");
			  System.out.println(sx.getMessage());
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState()); 
		  }
		  
		  return s1;
	}
	
	
	/**
	 * 
	 * @return contents of inventory table
	 */
	public  ArrayList<String> getInventoryData() {
		ArrayList<String> s1 = new ArrayList<String>();
		  
		  String sql = "SELECT * FROM propertyinventory_info";
		  
		  try {
			  helper.connectDB();
			  this.stmt = helper.getConnection().createStatement();
				rs = stmt.executeQuery(sql);

				while (rs.next())
				{
				
				  s1.add("Item Id: " + rs.getInt("itemId") + "\n" + "Item: " + rs.getString("Item") + ", Type: " + rs.getString("Type") +
						  ", Quantity: " + rs.getInt("Quantity") + ", Price: " + rs.getFloat("Price") + 
						  ", Category: " + rs.getString("Category") + ", Unit Price: " + rs.getFloat("Unitprice"));
				  System.out.println(s1);
			  }	  
		  helper.disconnectDB();
		  }catch(SQLException sx)
		  {
			  System.out.println("Error fetching data from the database");
			  System.out.println(sx.getMessage());
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState()); 
		  }
		  
		  return s1;
		
	}
	
	
	/**
	 * 
	 * @return contents of transaction_info table
	 */
	public  ArrayList<String> getTransactionData() {
		ArrayList<String> s1 = new ArrayList<String>();
		  
		  String sql = "SELECT * FROM transactions_info";
		  
		  try {
			  helper.connectDB();
			  this.stmt = helper.getConnection().createStatement();
				rs = stmt.executeQuery(sql);

				while (rs.next())
				{
				
				  s1.add("Transaction Id: " + rs.getInt("tran_Id") + "\n" + "Date: " + rs.getString("Date") + ", Time: " + rs.getString("Time") +
						  ", User Id: " + rs.getInt("userId") + ", User Name: " + rs.getString("userName") + 
						  ", Amount Paid: " + rs.getFloat("amountPaid") + ", Payment Mode: " + rs.getString("paymentMode") + 
						  ", Card Number: " + rs.getString("cardNumber") + ", Card Expiry Date: " + rs.getString("cardExpiryDate") + 
						  ", Card Security Code: " + rs.getString("cardSecurityCode"));
				  System.out.println(s1);
			  }	  
		  helper.disconnectDB();
		  }catch(SQLException sx)
		  {
			  System.out.println("Error fetching data from the database");
			  System.out.println(sx.getMessage());
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState()); 
		  }
		  
		  return s1;
		
	}
	
	/**
	 * 
	 * @param fileName is the name of the file to be created
	 * @return the message for confirmation of file generation
	 */
	public String writeToFile(String fileName, ArrayList<String> data) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileName + ".txt", "UTF-8");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "Report Not Generated";
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "Report Not Generated";
		}
		
		for(int i = 0; i < data.size(); i++) {
			writer.println(data.get(i) + "\n");
			writer.println("---------------------------------------------------------------------------------------------------------------------------"+
			"---------------------------------------------------------------------------------------------------------------------------");
		}
		
		writer.close();
		return "Report Generated";
	}
	
	
	
	/**
	 * class for comboBoxRenderring
	 * @author Mann
	 *
	 */
	class MyComboBoxRenderer extends JLabel implements ListCellRenderer {
		  private String _title;

		  public MyComboBoxRenderer(String title) {
		    _title = title;
		  }

		  @Override
		  public Component getListCellRendererComponent(JList list, Object value,
		      int index, boolean isSelected, boolean hasFocus) {
		    if (index == -1 && value == null)
		      setText(_title);
		    else
		      setText(value.toString());
		    return this;
		  }
	}
	

}
