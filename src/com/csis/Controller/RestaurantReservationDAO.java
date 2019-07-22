package com.csis.Controller;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Calendar;
import java.util.Date;

import com.csis.Boundary.AdminLogin;
import com.csis.Boundary.CustomerBill;
import com.csis.Boundary.DBHelper;
import com.csis.Boundary.Home;
import com.csis.Boundary.Reservation;
import com.csis.Entities.Restaurant;
import com.csis.Entities.UserInfo;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DateFormatter;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class RestaurantReservationDAO {

	private JFrame frame;
	UserInfo user;
	Restaurant restaurantData = new Restaurant();
	String errorMsg;
	boolean inputValid = false;
	String resForOption = "";
	
	DBHelper helper = new DBHelper();
	private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;

	/**
	 * Launch the application.
	 * accept current user's user name
	 * @param args
	 * @param user
	 */
	public static void main(String[] args, UserInfo user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantReservationDAO window = new RestaurantReservationDAO(user);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param user
	 */
	public RestaurantReservationDAO(UserInfo user) {
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
		
		JLabel lblTitle = new JLabel("Restaurant Reservation");
		lblTitle.setForeground(color);
		lblTitle.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lblTitle.setBounds(212, 41, 232, 25);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblUsername = new JLabel((String) null);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setForeground(color);
		lblUsername.setBounds(540, 24, 76, 25);
		lblUsername.setText(user.getUsername());
		frame.getContentPane().add(lblUsername);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(color);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBackground(new Color(95, 158, 160));
		lblDate.setBounds(63, 174, 46, 25);
		frame.getContentPane().add(lblDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(175, 179, 91, 20);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		frame.getContentPane().add(dateChooser);
		
		JRadioButton rdbtnBreakfast = new JRadioButton("Breakfast");
		rdbtnBreakfast.setForeground(color);
		rdbtnBreakfast.setActionCommand("Breakfast");
		rdbtnBreakfast.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnBreakfast.setBounds(202, 125, 91, 23);
		rdbtnBreakfast.setBackground(new Color(201, 210, 218));
		frame.getContentPane().add(rdbtnBreakfast);
		
		JRadioButton rdbtnBrunch = new JRadioButton("Brunch");
		rdbtnBrunch.setForeground(color);
		rdbtnBrunch.setActionCommand("Brunch");
		rdbtnBrunch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnBrunch.setBackground(new Color(201, 210, 218));
		rdbtnBrunch.setBounds(295, 125, 78, 23);
		frame.getContentPane().add(rdbtnBrunch);
		
		JRadioButton rdbtnLunch = new JRadioButton("Lunch");
		rdbtnLunch.setForeground(color);
		rdbtnLunch.setActionCommand("Lunch");
		rdbtnLunch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnLunch.setBackground(new Color(201, 210, 218));
		rdbtnLunch.setBounds(392, 125, 78, 23);
		frame.getContentPane().add(rdbtnLunch);
		
		JRadioButton rdbtnDinner = new JRadioButton("Dinner");
		rdbtnDinner.setForeground(color);
		rdbtnDinner.setActionCommand("Dinner");
		rdbtnDinner.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnDinner.setBackground(new Color(201, 210, 218));
		rdbtnDinner.setBounds(472, 125, 109, 23);
		frame.getContentPane().add(rdbtnDinner);
		
		
		ButtonGroup resForGroup = new ButtonGroup();
		resForGroup.add(rdbtnBreakfast);
		resForGroup.add(rdbtnBrunch);
		resForGroup.add(rdbtnLunch);
		resForGroup.add(rdbtnDinner);
		
		//set Listener
		RadioListener listener = new RadioListener();
		rdbtnBreakfast.addActionListener(listener);
		rdbtnBreakfast.addChangeListener(listener);
		rdbtnBreakfast.addItemListener(listener);
		
		rdbtnBrunch.addActionListener(listener);
		rdbtnBrunch.addChangeListener(listener);
		rdbtnBrunch.addItemListener(listener);
		
		rdbtnLunch.addActionListener(listener);
		rdbtnLunch.addChangeListener(listener);
		rdbtnLunch.addItemListener(listener);
		
		rdbtnDinner.addActionListener(listener);
		rdbtnDinner.addChangeListener(listener);
		rdbtnDinner.addItemListener(listener);
		
		
		JLabel lblReservationFor = new JLabel("Reservation for:");
		lblReservationFor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReservationFor.setForeground(color);
		lblReservationFor.setBounds(63, 123, 118, 25);
		frame.getContentPane().add(lblReservationFor);
		
		JLabel lblGuest = new JLabel("# Guest");
		lblGuest.setForeground(color);
		lblGuest.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGuest.setBounds(63, 229, 72, 26);
		frame.getContentPane().add(lblGuest);
		
		JSpinner spinGuests = new JSpinner();
		spinGuests.setBounds(175, 229, 29, 31);
		frame.getContentPane().add(spinGuests);
		
		JLabel lblMealType = new JLabel("Meal Type");
		lblMealType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMealType.setForeground(color);
		lblMealType.setBounds(63, 280, 72, 25);
		frame.getContentPane().add(lblMealType);
		
		JRadioButton rdbtnVeg = new JRadioButton("Veg");
		rdbtnVeg.setForeground(color);
		rdbtnVeg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnVeg.setBounds(175, 282, 72, 23);
		rdbtnVeg.setBackground(new Color(201, 210, 218));
		frame.getContentPane().add(rdbtnVeg);
		
		JRadioButton rdbtnNonVeg = new JRadioButton("Non Veg");
		rdbtnNonVeg.setForeground(color);
		rdbtnNonVeg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNonVeg.setBackground(new Color(201, 210, 218));
		rdbtnNonVeg.setBounds(274, 282, 109, 23);
		frame.getContentPane().add(rdbtnNonVeg);
		
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setForeground(color);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTime.setBackground(new Color(201, 210, 218));
		lblTime.setBounds(372, 174, 46, 25);
		frame.getContentPane().add(lblTime);
		
		Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 24); // 24 == 12 PM == 00:00:00
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        SpinnerDateModel model = new SpinnerDateModel();
        model.setValue(calendar.getTime());

        JSpinner spinner = new JSpinner(model);

        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "HH:mm"); //add "HH:mm a" for am/pm
        DateFormatter formatter = (DateFormatter)editor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false); 
        formatter.setOverwriteMode(true);

        spinner.setEditor(editor);
        spinner.setForeground(Color.WHITE);
		spinner.setBounds(441, 176, 89, 25);
		frame.getContentPane().add(spinner);
		
		JButton btnCalculateMyBill = new JButton("Calculate my Bill");		
		btnCalculateMyBill.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCalculateMyBill.setBounds(453, 354, 128, 23);
		btnCalculateMyBill.setForeground(color);
		frame.getContentPane().add(btnCalculateMyBill);
		
		
		/**
		 * set listeners
		 */
		setDateListener(dateChooser);
		setMealListener(rdbtnVeg, rdbtnNonVeg);
		
		
		/**
		 * set action listener for button
		 */
		JButton button = new JButton("Confirm");
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumberOfGuest(spinGuests);
				restaurantData.setReservationFor(resForOption);
				validateInfo(restaurantData.getDate(), restaurantData.getNoOfGuest(), restaurantData.getMealType());
				if(inputValid) {
					System.out.println(restaurantData.getMealType() + " " + restaurantData.getNoOfGuest() + " " 
							+ restaurantData.getDate() + " " + displayDate());
					
					try {
						
						java.sql.Date sqlDate = new java.sql.Date(restaurantData.getDate().getTime());
						
						String time  = editor.getFormat().format(spinner.getValue());
						SimpleDateFormat smp = new SimpleDateFormat("HH:mm");
						Date sTime = smp.parse(time);
						java.sql.Time sqlTime = new java.sql.Time(sTime.getTime());
						
						insertReservationInformation(user.getId(), user.getUsername(), "restaurant","-", 0, "-",
								restaurantData.getMealType(), sqlDate, sqlTime, 0, false, restaurantData.getNoOfGuest(), restaurantData.getReservationFor() );
						JOptionPane.showMessageDialog(null, "Restaurant Reservation confirmed");
						
						btnCalculateMyBill.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								BillCalculator billCalculate = new BillCalculator();
								billCalculate.calculate(user);
								
								frame.dispose();
							}
						});
					} catch(Exception ex) {
						System.out.println("Error in inserting " + ex.getMessage());
					}
					
				} else {
					JOptionPane.showMessageDialog(null, errorMsg);
				}	
			}
		});
		button.setForeground(color);
		button.setBounds(336, 354, 89, 23);
		frame.getContentPane().add(button);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservation.main(null, user);
				frame.dispose();
			}
		});
		btnBack.setForeground(color);
		btnBack.setBounds(204, 354, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user.getUsername().equals("admin")) {
					AdminLogin.main(null);
				} else {
					Home.main(null);
				}
				
				frame.dispose();
			}
		});
		btnLogOut.setForeground(new Color(85, 96, 128));
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogOut.setBounds(84, 354, 89, 23);
		frame.getContentPane().add(btnLogOut);
		
		
		
		
	}

	/**
	 * 
	 * @return date from DATE
	 */
	protected String displayDate() {
		String actualDate = DateFormat.getDateInstance().format(restaurantData.getDate());
		return actualDate;
	}
	


	/**
	 * set the number of guests
	 * @param spinGuests
	 */
	protected void setNumberOfGuest(JSpinner spinGuests) {
		// TODO Auto-generated method stub
		restaurantData.setNoOfGuest(Integer.parseInt(spinGuests.getValue().toString()));
	}
	
	

	/**
	 * set the meal type veg/non-veg
	 * @param rdbtnVeg
	 * @param rdbtnNonVeg
	 */
	private void setMealListener(JRadioButton rdbtnVeg, JRadioButton rdbtnNonVeg) {
		// TODO Auto-generated method stub
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnVeg);
		radioGroup.add(rdbtnNonVeg);
		
		class RestaurantActionListener implements ActionListener {
		      public void actionPerformed(ActionEvent ex) {
		      String choice = radioGroup.getSelection().getActionCommand();
		      }
		    }

		  class RestaurantItemListener implements ItemListener {
		   			@Override
			public void itemStateChanged(ItemEvent ex) {
				// TODO Auto-generated method stub
				String item = ((AbstractButton) ex.getItemSelectable()).getActionCommand();
		        //boolean selected = (ex.getStateChange() == ItemEvent.SELECTED);
		        if(item.equals("Veg")) {
			    	  restaurantData.setMealType("Veg");
			      }else {
			    	  restaurantData.setMealType("Non-Veg");
			      }
			}
		    }

		    ActionListener al = new RestaurantActionListener();
		    rdbtnVeg.addActionListener(al);
		    rdbtnNonVeg.addActionListener(al);

		    ItemListener il = new RestaurantItemListener();
		    rdbtnVeg.addItemListener(il);
		    rdbtnNonVeg.addItemListener(il);
	}

	/**
	 * set the reservation date
	 * @param dateChooser
	 */
	private void setDateListener(JDateChooser dateChooser) {
		// TODO Auto-generated method stub
		dateChooser.getDateEditor().addPropertyChangeListener("date", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {
				// TODO Auto-generated method stub
				Date date = (Date) event.getNewValue();
				restaurantData.setDate(date);
				}
			
		});
	}
	
	/**
	 * validate the user inputs
	 * @param date
	 * @param noOfGuest
	 * @param mealType
	 * @return
	 */
	protected boolean validateInfo(Date date, int noOfGuest, String mealType) {
		// TODO Auto-generated method stub
		errorMsg = "Please enter the following field: ";
		inputValid = true;
		if(noOfGuest <= 0) {
			errorMsg += "\nNo.of Guests";
			inputValid = false;
		}
		if(date == null) {
			errorMsg += "\nDate";
	    	inputValid = false;
		}
		if(mealType == null) {
			errorMsg += "\nMeal Type";
			inputValid = false;
		}
		return inputValid;
	}
	
	
	/**
	 * listen to the change in radio button value for reservation meal category
	 * @author Mann
	 *
	 */
	
	class RadioListener implements ActionListener, ItemListener, ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			System.out.println("ChangeEvent received from: "
 		           + e.getSource());
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			System.out.println("ItemEvent received: " 
 		           + e.getItem()
 		           + " is now "
 		           + ((e.getStateChange() == ItemEvent.SELECTED)?
 			      "selected.":"unselected"));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String factoryName = null;

	        System.out.print("ActionEvent received: ");
	        if (e.getActionCommand() == "Breakfast") {
	        	resForOption = "Breakfast";
	    	    System.out.println(resForOption + " pressed.");
	        } else if(e.getActionCommand() == "Brunch") {
	        	resForOption = "Brunch";
	    	    System.out.println(resForOption + " pressed.");
	        } else if(e.getActionCommand() == "Lunch") {
	        	resForOption = "Lunch";
	        	System.out.println(resForOption + " pressed");
	        } else {
	        	resForOption = "Dinner";
	        	System.out.println(resForOption + " pressed");
	        }
		}
		
	}
	
	/**
	 * 
	 * @param userId is the id of user
	 * @param usrname, name of the user
	 * @param resType, reservation type (room, meeting, banquet, restaurant)
	 * @param roomType, type of the room
	 * @param stayDuration, duration to book
	 * @param mealStatus, if meal is included
	 * @param mealType, type of the meal included
	 * @param resDate, date on reservation is made
	 * @param resTime, time at which reservation is made
	 * @param meetingDuration, duration for meeting
	 * @param addService, additional service if required
	 * @param noOfGuest, number of guest
	 * @param resFor, if reservation for breakfast, brunch, lunch, dinner
	 */
	 public void insertReservationInformation(int userId, String usrname, String resType, String roomType,
			  int stayDuration, String mealStatus, String mealType, java.sql.Date resDate, Time resTime, int meetingDuration,
			  boolean addService, int noOfGuest, String resFor){
		  
		  String insertSql = "INSERT INTO reservation_info (userId, userName, resType, roomType, stayDuration, mealStatus, mealType, resDate, resTime,  meetingDuration, addService, noGuest, resFor) " +
	  				"values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		  
		  try {
			  helper.connectDB();
			  
			  //create statement
			  pstmt = helper.getConnection().prepareStatement(insertSql);
			  
			  //set the parameters of query
			  pstmt.setInt(1, userId);
			  pstmt.setString(2, usrname);
			  pstmt.setString(3, resType);
			  pstmt.setString(4, roomType);
			  pstmt.setInt(5, stayDuration);
			  pstmt.setString(6, mealStatus);
			  pstmt.setString(7, mealType);
			  pstmt.setDate(8, resDate);
			  pstmt.setTime(9, resTime);
			  pstmt.setInt(10, meetingDuration);
			  pstmt.setBoolean(11, addService);
			  pstmt.setInt(12, noOfGuest);
			  pstmt.setString(13, resFor);
			  
			  //execute			  
			  pstmt.executeUpdate();
			  
			  helper.disconnectDB();
		  } catch(SQLException sx) {
			  System.out.println("Error inserting data into the reservation table");
			  System.out.println(sx.getMessage()); 
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState());
		  }
	  }
}
