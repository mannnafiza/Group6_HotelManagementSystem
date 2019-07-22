package com.csis.Controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
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

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.DateFormatter;

import com.csis.Boundary.AdminLogin;
import com.csis.Boundary.DBHelper;
import com.csis.Boundary.Home;
import com.csis.Boundary.Reservation;
import com.csis.Boundary.RoomService;
import com.csis.Entities.Room;
import com.csis.Entities.UserInfo;
import com.toedter.calendar.JDateChooser;

public class RoomReservationDAO {

	private JFrame frame;
	UserInfo user;
	String[] roomTypes = {"Executive King Double", "Executive Queen Double", "Executive Queen Single",
					"Deluxe King Double", "Deluxe Queen Double", "Deluxe Queen Single", "Regular Double", "Regular Single"};
	String errorMsg;
	boolean inputValid = false;
	Room roomData = new Room();
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
					RoomReservationDAO window = new RoomReservationDAO(user);
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
	public RoomReservationDAO(UserInfo user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Color color = new Color(85, 96, 128);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 642, 464);
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(201, 210, 218));
		frame.getContentPane().setLayout(null);
		
		JLabel lblRmReserveTitle = new JLabel("Room Reservation");
		lblRmReserveTitle.setForeground(color);
		lblRmReserveTitle.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lblRmReserveTitle.setBounds(208, 44, 232, 25);
		frame.getContentPane().add(lblRmReserveTitle);
		
		JLabel lblUsername = new JLabel("");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setForeground(color);
		lblUsername.setBounds(550, 11, 76, 25);
		lblUsername.setText(user.getUsername());
		frame.getContentPane().add(lblUsername);
		
		
		JList listRoomType = new JList(roomTypes);
		listRoomType.setBounds(113, 121, 184, 153);
		frame.getContentPane().add(listRoomType);
		
		
		JLabel lvlRoomType = new JLabel("Room Type");
		lvlRoomType.setForeground(color);
		lvlRoomType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lvlRoomType.setBounds(10, 110, 93, 35);
		frame.getContentPane().add(lvlRoomType);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setForeground(color);
		lblDate.setBounds(343, 137, 46, 20);
		lblDate.setBackground(new Color(95, 158, 160));
		frame.getContentPane().add(lblDate);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setForeground(color);
		lblDuration.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDuration.setBounds(479, 273, 89, 23);
		frame.getContentPane().add(lblDuration);
		
		JSpinner spinDuration = new JSpinner();
		spinDuration.setBounds(518, 307, 29, 35);
		frame.getContentPane().add(spinDuration);
		
		JLabel lblMeal = new JLabel("Meal ");
		lblMeal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMeal.setForeground(color);
		lblMeal.setBounds(351, 277, 87, 14);
		frame.getContentPane().add(lblMeal);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setForeground(color);
		rdbtnYes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnYes.setBounds(353, 298, 109, 23);
		rdbtnYes.setBackground(new Color(201, 210, 218));
		frame.getContentPane().add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setForeground(color);
		rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNo.setBackground(new Color(201, 210, 218));
		rdbtnNo.setBounds(353, 324, 109, 23);
		frame.getContentPane().add(rdbtnNo);
		
		JCheckBox chkAddService = new JCheckBox("Additional Services");
		chkAddService.setForeground(color);
		chkAddService.setFont(new Font("Tahoma", Font.BOLD, 12));
		chkAddService.setBounds(23, 324, 192, 23);
		chkAddService.setBackground(new Color(201, 210, 218));
		frame.getContentPane().add(chkAddService);
		chkAddService.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String resType = "Room";
				RoomService.main(null, resType);
			}
			
		} );
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(401, 137, 91, 20);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		frame.getContentPane().add(dateChooser);
		
		JLabel lbldays = new JLabel("(days)");
		lbldays.setForeground(color);
		lbldays.setBounds(543, 279, 46, 14);
		frame.getContentPane().add(lbldays);
		
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
		spinner.setBounds(401, 189, 89, 25);
		frame.getContentPane().add(spinner);
		
		JButton btnCalculateMyBill = new JButton("Calculate my Bill");		
		btnCalculateMyBill.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCalculateMyBill.setBounds(415, 371, 128, 23);
		btnCalculateMyBill.setForeground(color);
		frame.getContentPane().add(btnCalculateMyBill);
		
		/**
		 * set Listeners
		 */
		setListListener(listRoomType);
		setServiceListener(chkAddService);
		setMealListener(rdbtnYes, rdbtnNo);
		setReservationDateListener(dateChooser);
		
		/**
		 * set action listener for button
		 */
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setStayDuration(spinDuration);
				
				validateInfo(roomData.getRoomType(), roomData.getReserveDate(), roomData.getDuration(), roomData.isMeal());
				if(inputValid) {
					System.out.println(roomData.getRoomType() + " " + roomData.getDuration() + " " + roomData.isAddService() 
					+ " " + roomData.isMeal() + " " + displayDate());
					
					
					
					try {
						
						
						java.sql.Date sqlDate = new java.sql.Date(roomData.getReserveDate().getTime());
						
						String time  = editor.getFormat().format(spinner.getValue());
						SimpleDateFormat smp = new SimpleDateFormat("HH:mm");
						Date sTime = smp.parse(time);
						java.sql.Time sqlTime = new java.sql.Time(sTime.getTime());
						
						System.out.println(sqlDate);
						if(!checkAvailability(sqlDate, roomData.getRoomType())) {
							insertReservationInformation(user.getId(), user.getUsername(), "room", roomData.getRoomType(), roomData.getDuration(), roomData.isMeal(), "-",sqlDate, sqlTime, 0, roomData.isAddService(), 0, "-");
							
							JOptionPane.showMessageDialog(null, "Reservation Confirmed");
							
							btnCalculateMyBill.addActionListener(new ActionListener() {

								public void actionPerformed(ActionEvent arg0) {
									BillCalculator billCalculate = new BillCalculator();
									billCalculate.calculate(user);
									
									frame.dispose();
								}
							});
							
							
						} else {
							JOptionPane.showMessageDialog(null, "Room already reserved for this date");
						}
						
						
						
					} catch(Exception ex) {
						System.out.println("Error in inserting " + ex.getMessage());
					}
					
				}else {
					JOptionPane.showMessageDialog(null, errorMsg);
				}
				
				
				//TODO: get and Validate all data
				
			}
		});
		btnConfirm.setBounds(288, 371, 89, 23);
		btnConfirm.setForeground(color);
		frame.getContentPane().add(btnConfirm);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reservation.main(null, user);
				frame.dispose();
			}
		});
		btnBack.setBounds(156, 371, 89, 23);
		btnBack.setForeground(color);
		frame.getContentPane().add(btnBack);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setForeground(color);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTime.setBackground(new Color(95, 158, 160));
		lblTime.setBounds(343, 187, 54, 25);
		frame.getContentPane().add(lblTime);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnLogOut.setBounds(41, 371, 89, 23);
		frame.getContentPane().add(btnLogOut);
			
	}
	
	
	protected boolean checkAvailability(java.sql.Date sqlDate, String roomType) {
		//boolean result = false;
		ArrayList<String> rooms = new ArrayList<>();
		rooms = getRoomList(sqlDate);
		
		return rooms.contains(roomType);
		
//		if(rooms.contains(roomType)) {
//			int duration = helper.getStayDuration(sqlDate, roomType);
//			java.sql.Date resEndDate = helper.getDate(sqlDate, duration);
//			
//			for(int i = 0; i < duration ; i++) {
//				if(resEndDate == helper.getDate(sqlDate, i)) {
//					result =  true;
//				} else
//					result =  false;
//			}
//		}
//		return result;
	}
	

	/**
	 * 
	 * @return the date from DATE
	 */
	protected String displayDate() {
		String actualDate = DateFormat.getDateInstance().format(roomData.getReserveDate());
		return actualDate;
	}

	/**
	 * set the selected date
	 * @param dateChooser
	 */
	protected void setReservationDateListener(JDateChooser dateChooser) {
		// TODO Auto-generated method stub
		dateChooser.getDateEditor().addPropertyChangeListener("date", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {
				// TODO Auto-generated method stub
				Date date = (Date) event.getNewValue();
					roomData.setReserveDate(date);
			}
				
			
		});
	}

	/**
	 * set if meal inclusive/exclusive
	 * @param rdbtnYes
	 * @param rdbtnNo
	 */
	protected void setMealListener(JRadioButton rdbtnYes, JRadioButton rdbtnNo) {
		// TODO Auto-generated method stub
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnYes);
		radioGroup.add(rdbtnNo);
		
		class RoomActionListener implements ActionListener {
		      public void actionPerformed(ActionEvent ex) {
		      String choice = radioGroup.getSelection().getActionCommand();
		      }
		    }

		  class RoomItemListener implements ItemListener {
		   			@Override
			public void itemStateChanged(ItemEvent ex) {
				// TODO Auto-generated method stub
				String item = ((AbstractButton) ex.getItemSelectable()).getActionCommand();
		        boolean selected = (ex.getStateChange() == ItemEvent.SELECTED);
		        if(item.equals("Yes")) {
			    	  roomData.setMeal("yes");
			      }else {
			    	  roomData.setMeal("no");
			      }
			}
		    }

		    ActionListener al = new RoomActionListener();
		    rdbtnYes.addActionListener(al);
		    rdbtnNo.addActionListener(al);

		    ItemListener il = new RoomItemListener();
		    rdbtnYes.addItemListener(il);
		    rdbtnNo.addItemListener(il);
		  
		
	}

	/**
	 * set the stay duration
	 * @param spinDuration
	 */
	protected void setStayDuration(JSpinner spinDuration) {
		// TODO Auto-generated method stub
		int spinnerValue = Integer.parseInt(spinDuration.getValue().toString());
		roomData.setDuration(spinnerValue);
	}

	/**
	 * set the additional service requirement status
	 * @param chkAddService
	 */
	protected void setServiceListener(JCheckBox chkAddService) {
		// TODO Auto-generated method stub
		chkAddService.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				AbstractButton absButton = (AbstractButton) event.getSource();
				boolean serviceStatus = absButton.isSelected();
				roomData.setAddService(serviceStatus);
			}
			
		});
	}

	/**
	 * set the room type selected
	 * @param listRoomType
	 */
	//TODO: check for default choice (it shows null value)
	public void setListListener(JList listRoomType) {
		listRoomType.addListSelectionListener(new ListSelectionListener() {
						
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(e.getValueIsAdjusting() == true) {
						switch(listRoomType.getSelectedIndex()) {
						case 0:
							roomData.setRoomType("Executive King Double");
							break;
						case 1:
							roomData.setRoomType("Executive Queen Double");
							break;
						case 2:
							roomData.setRoomType("Executive Queen Single");
							break;
						case 3:
							roomData.setRoomType("Deluxe King Double");
							break;
						case 4:
							roomData.setRoomType("Deluxe Queen Double");
							break;
						case 5:
							roomData.setRoomType("Deluxe Queen Single");
							break;
						case 6:
							roomData.setRoomType("Regular Double");
							break;
						case 7:
							roomData.setRoomType("Regular Single");
							break;
						default:
							roomData.setRoomType("invalid");
							break;
					
					}
					
				}
			}
			
		});
	}
	
	/**
	 * validate the user inputs
	 * @param roomType
	 * @param date
	 * @param duration
	 * @param mealType
	 * @return
	 */
	public boolean validateInfo(String roomType, Date date, int duration, String mealType) {
		errorMsg = "Please enter the following field: ";
		inputValid = true;
		
		if(roomType==null) {
			errorMsg += "\nRoom Type";
			inputValid = false;
		}
			
	    if(date == null) {
	    	errorMsg += "\nDate";
	    	inputValid = false;
	    }
			
		if(duration<=0) {
			errorMsg += "\nStay Duration";
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
	   * @param date, date for which user tries to reserve
	   * @return list of rooms for specific date
	   */
	  public ArrayList<String> getRoomList(java.sql.Date date){
		  String sql = "SELECT roomType from reservation_info where resDate = ?";
		  ArrayList<String> roomType = new ArrayList<>();
		  try {
			  helper.connectDB();
			  
			  
			//create statement 
			  pstmt = helper.getConnection().prepareStatement(sql);
		  	  
			  pstmt.setDate(1,  date);
			  rs = pstmt.executeQuery(); 
			  while(rs.next())
			  {
				  roomType.add(rs.getString("roomType"));
			  }
			  
			  helper.disconnectDB();
			  
		  } catch(SQLException sx) {
			  System.out.println("Error inserting data into the reservation table");
			  System.out.println(sx.getMessage()); 
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState());
		  }
		  return roomType;
	  }
	
	
}
