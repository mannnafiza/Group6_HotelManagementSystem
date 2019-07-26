package com.csis.Controller;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import com.csis.Boundary.AdminLogin;
import com.csis.Boundary.DBHelper;
import com.csis.Boundary.Home;
import com.csis.Boundary.Reservation;
import com.csis.Entities.Meeting;
import com.csis.Entities.Staff;
import com.csis.Entities.UserInfo;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class MeetingReservationDAO {

	private JFrame frame;
	UserInfo user;
	Meeting meetingData = new Meeting();
	String errorMsg;
	boolean inputValid = false;	
	
	DBHelper helper = new DBHelper();
	private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	
	public String msg = "";

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
					MeetingReservationDAO window = new MeetingReservationDAO(user);
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
	public MeetingReservationDAO(UserInfo user) {
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
		
		JLabel lblMeetingReservation = new JLabel("Meeting Reservation");
		lblMeetingReservation.setForeground(color);
		lblMeetingReservation.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lblMeetingReservation.setBounds(224, 79, 232, 25);
		frame.getContentPane().add(lblMeetingReservation);
		
		JLabel lblUsername = new JLabel((String) null);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setForeground(color);
		lblUsername.setBounds(540, 25, 76, 25);
		lblUsername.setText(user.getUsername());
		frame.getContentPane().add(lblUsername);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(color);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBackground(new Color(95, 158, 160));
		lblDate.setBounds(85, 160, 46, 25);
		frame.getContentPane().add(lblDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(164, 165, 91, 20);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		frame.getContentPane().add(dateChooser);
		
		JLabel labelMeetingDuration = new JLabel("Duration");
		labelMeetingDuration.setForeground(color);
		labelMeetingDuration.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelMeetingDuration.setBounds(85, 213, 89, 23);
		frame.getContentPane().add(labelMeetingDuration);
		
		JLabel lblhours = new JLabel("(hours)");
		lblhours.setForeground(color);
		lblhours.setBounds(95, 235, 46, 14);
		frame.getContentPane().add(lblhours);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(184, 209, 29, 35);
		frame.getContentPane().add(spinner);
		
		JLabel lblMeetingMeal = new JLabel("Meal ");
		lblMeetingMeal.setForeground(color);
		lblMeetingMeal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMeetingMeal.setBounds(85, 283, 76, 20);
		frame.getContentPane().add(lblMeetingMeal);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setForeground(color);
		rdbtnYes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnYes.setBackground(new Color(201, 210, 218));
		rdbtnYes.setBounds(164, 280, 109, 23);
		frame.getContentPane().add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setForeground(color);
		rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNo.setBackground(new Color(201, 210, 218));
		rdbtnNo.setBounds(275, 280, 109, 23);
		frame.getContentPane().add(rdbtnNo);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setForeground(color);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTime.setBackground(new Color(95, 158, 160));
		lblTime.setBounds(338, 165, 46, 20);
		frame.getContentPane().add(lblTime);
		
		Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 24); // 24 == 12 PM == 00:00:00
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        SpinnerDateModel model = new SpinnerDateModel();
        model.setValue(calendar.getTime());

        JSpinner spinnerTime = new JSpinner(model);

        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerTime, "HH:mm"); //add "HH:mm a" for am/pm
        DateFormatter formatter = (DateFormatter)editor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false); 
        formatter.setOverwriteMode(true);

        spinnerTime.setEditor(editor);
        spinnerTime.setForeground(Color.WHITE);
        spinnerTime.setBounds(414, 162, 89, 25);
		frame.getContentPane().add(spinnerTime);
		
		JButton btnCalculateMyBill = new JButton("Calculate my Bill");		
		btnCalculateMyBill.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCalculateMyBill.setBounds(471, 360, 128, 23);
		btnCalculateMyBill.setForeground(color);
		frame.getContentPane().add(btnCalculateMyBill);
		
		/**
		 * set listeners
		 */
		setReservationDateListener(dateChooser);
		setMealListener(rdbtnYes, rdbtnNo);
		
		/**
		 * set action listener for button
		 */
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setMeetingDuration(spinner);
				validateInfo(meetingData.getReservedate(), meetingData.getDuration(), meetingData.isMeal());
				if(inputValid) {
					System.out.println(displayDate() + " " + meetingData.getDuration() + " " + meetingData.isMeal());
				
					
					try {
						
						java.sql.Date sqlDate = new java.sql.Date(meetingData.getReservedate().getTime());
						
						String time  = editor.getFormat().format(spinnerTime.getValue());
						SimpleDateFormat smp = new SimpleDateFormat("HH:mm");
						Date sTime = smp.parse(time);
						java.sql.Time sqlTime = new java.sql.Time(sTime.getTime());
						
						if(!checkMeetingHallAvailability(sqlDate)) {
							insertReservationInformation(user.getId(), user.getUsername(), "meeting","-", 0, meetingData.isMeal(),
									"-", sqlDate, sqlTime, meetingData.getDuration(), false, 0, "-" );
							JOptionPane.showMessageDialog(null, "Meeting Reservation confirmed");
							
							btnCalculateMyBill.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									BillCalculatorDAO billCalculate = new BillCalculatorDAO();
									billCalculate.calculate(user);

									frame.dispose();
								}
							});
						} else {
							JOptionPane.showMessageDialog(null, "Meeting Hall already reserved for this date");
						}
						
					} catch(Exception ex) {
						System.out.println("Error in inserting " + ex.getMessage());
					}
				}else {
					JOptionPane.showMessageDialog(null, errorMsg);
				}
				
				
			}
		});
		btnConfirm.setForeground(color);
		btnConfirm.setBounds(349, 360, 89, 23);
		frame.getContentPane().add(btnConfirm);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservation.main(null, user);
				frame.dispose();
			}
		});
		btnBack.setForeground(color);
		btnBack.setBounds(215, 360, 89, 23);
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
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogOut.setForeground(color);
		btnLogOut.setBounds(85, 360, 89, 23);
		frame.getContentPane().add(btnLogOut);
		
		
	}
	
	
	private boolean checkMeetingHallAvailability(java.sql.Date date) {
		ArrayList<String> type = getReservationType(date);
		return type.contains("meeting");
	}
	
	/**
	 * 
	 * @return date from DATE
	 */
	protected String displayDate() {
		String actualDate = DateFormat.getDateInstance().format(meetingData.getReservedate());
		return actualDate;
	}

	/**
	 * set the reservation hours 
	 * @param spinner
	 */
	public void setMeetingDuration(JSpinner spinner) {
		// TODO Auto-generated method stub
		int value = Integer.parseInt(spinner.getValue().toString());
		if(value > 0)
			meetingData.setDuration(value);
		else {
			msg = "Enter a valid meeting duration";
			JOptionPane.showMessageDialog(null, msg );
		}
			
		
	}

	/**
	 * set the meal inclusive/exclusive
	 * @param rdbtnYes
	 * @param rdbtnNo
	 */
	private void setMealListener(JRadioButton rdbtnYes, JRadioButton rdbtnNo) {
		// TODO Auto-generated method stub
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnYes);
		radioGroup.add(rdbtnNo);
		
		class MeetingActionListener implements ActionListener {
		      public void actionPerformed(ActionEvent ex) {
		      String choice = radioGroup.getSelection().getActionCommand();
		      }
		    }

		  class MeetingItemListener implements ItemListener {
		   			@Override
			public void itemStateChanged(ItemEvent ex) {
				// TODO Auto-generated method stub
				String item = ((AbstractButton) ex.getItemSelectable()).getActionCommand();
		        boolean selected = (ex.getStateChange() == ItemEvent.SELECTED);
		        if(item.equals("Yes")) {
			    	  meetingData.setMeal("yes");
			      }else {
			    	  meetingData.setMeal("no");
			      }
			}
		    }

		    ActionListener al = new MeetingActionListener();
		    rdbtnYes.addActionListener(al);
		    rdbtnNo.addActionListener(al);

		    ItemListener il = new MeetingItemListener();
		    rdbtnYes.addItemListener(il);
		    rdbtnNo.addItemListener(il);
	}

	/**
	 * set the reservation date
	 * @param dateChooser
	 */
	private void setReservationDateListener(JDateChooser dateChooser) {
		// TODO Auto-generated method stub
		dateChooser.getDateEditor().addPropertyChangeListener("date", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {
				// TODO Auto-generated method stub
				Date date = (Date) event.getNewValue();
				meetingData.setReservedate(date);;
				}
			
		});
	}
	
	/**
	 * validate the user inputs
	 * @param reservedate
	 * @param duration
	 * @param mealType
	 * @return
	 */
	protected boolean validateInfo(Date reservedate, int duration, String mealType) {
		// TODO Auto-generated method stub
		inputValid = true;
		errorMsg = "Please enter the following field: ";
		if(reservedate == null) {
			errorMsg = "\nDate";
			inputValid = false;
		}
		if(duration <= 0) {
			errorMsg = "\nMeeting Duration";
			inputValid = false;
		}
		if(mealType == null) {
			errorMsg += "\nMeal Type";
			inputValid = false;
		}
			
		return inputValid;
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
	 
	 
	 
	 /**
	  * 
	  * @param date, date for which reservation is made
	  * @return type of reservation for specific date
	  */
	  public ArrayList<String> getReservationType(java.sql.Date date) {
		 String sql = "SELECT resType FROM reservation_info where resDate = ?";
		 ArrayList<String> type = new ArrayList<>();
		 
		 try {
			  helper.connectDB();
			  
			  	  
			//create statement 
			  pstmt = helper.getConnection().prepareStatement(sql);
		  	  
			  pstmt.setDate(1,  date);
			  rs = pstmt.executeQuery(); 
			  while(rs.next())
			  {
				 type.add(rs.getString("resType"));
			  }
			  
			  helper.disconnectDB();
			  
		  } catch(SQLException sx) {
			  System.out.println("Error inserting data into the reservation table");
			  System.out.println(sx.getMessage()); 
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState());
		  }
		 return type;
	  }
	  
	  
	  /**
	   * 
	   * @return all the resrevations for meeting type
	   */
	  public ArrayList<Meeting> listMeetingData(){
		  ArrayList<Meeting> meeting = new ArrayList<>();
		  
		  String sql = "Select * from reservation_info where resType = 'meeting' order by reservation_info.resId";
			try {
				helper.connectDB();
				stmt = helper.getConnection().createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					Meeting m = new Meeting();
					
					meeting.add(m);
				}
				helper.disconnectDB();
			} catch(SQLException sx) {
				System.out.println("Error in connecting database");
				System.out.println(sx.getMessage());
				System.out.println(sx.getErrorCode());
				System.out.println(sx.getSQLState());
			}
			
			return meeting;
	  }
}
