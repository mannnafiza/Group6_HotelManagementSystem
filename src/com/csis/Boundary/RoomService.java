package com.csis.Boundary;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import javax.swing.text.DateFormatter;

import com.csis.Controller.Authenticate;
import com.csis.Controller.Validate;
import com.csis.Entities.Service;
import com.csis.Entities.UserInfo;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.JSpinner;


public class RoomService {

	private JFrame frame;
	private JTextField textFieldTime;
	private JTextField textFieldCustomerName;
    String	customerName  = "";
    String errorMsg;
	boolean inputValid = false;
	Service serviceData = new Service();
	UserInfo user = new UserInfo();
    String resType;
    DBHelper helper = new DBHelper();
    private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private boolean confirmationStatus;
	static Service ns = new Service();
    
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomService window = new RoomService();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] args, String resType) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomService window = new RoomService(resType);
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
	public RoomService() {
		initialize();
	}
	
	public RoomService(String resType) {
		this.resType = resType;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(201, 210, 218));
		frame.setBackground(UIManager.getColor("ComboBox.buttonDarkShadow"));
		frame.setBounds(100, 100, 642, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Color color = new Color(85, 96, 128);
		
		
		JLabel labelRSS = new JLabel("   Room Service  System");
		labelRSS.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		labelRSS.setBounds(321, 69, 324, 41);
		labelRSS.setForeground(color);
		frame.getContentPane().add(labelRSS);
		
		
		JLabel labelRT = new JLabel("Request Type :");
		labelRT.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelRT.setBounds(10, 248, 133, 31);
		labelRT.setForeground(color);
		frame.getContentPane().add(labelRT);
		
		JLabel lblRequestTime = new JLabel("Request Time : ");
		lblRequestTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRequestTime.setBounds(342, 253, 118, 20);
		lblRequestTime.setForeground(color);
		frame.getContentPane().add(lblRequestTime);
	
		textFieldTime = new JTextField();
		textFieldTime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char roomnumberValue = e.getKeyChar();
				if(!Character.isDigit(roomnumberValue) ||  roomnumberValue == KeyEvent.VK_BACK_SPACE   || roomnumberValue ==KeyEvent.VK_DELETE  ) {
					//getToolkit().beep();   
					e.consume();
				}
				
			}
		});
		textFieldTime.setText("00.00");
		textFieldTime.setBounds(470, 253, 49, 20);
		frame.getContentPane().add(textFieldTime);
		textFieldTime.setColumns(10);
		
		JLabel lblMinutes = new JLabel("Hours");
		lblMinutes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMinutes.setBounds(529, 253, 60, 14);
		lblMinutes.setForeground(color);
		frame.getContentPane().add(lblMinutes);
		
		JLabel lblCustomerName = new JLabel("Customer Name :");
		lblCustomerName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCustomerName.setBounds(10, 194, 133, 20);
		lblCustomerName.setForeground(color);
		frame.getContentPane().add(lblCustomerName);
		
		textFieldCustomerName = new JTextField();
		textFieldCustomerName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char customerNameValue = e.getKeyChar();
				if(!Character.isLetter(customerNameValue) ||  customerNameValue == KeyEvent.VK_BACK_SPACE   || customerNameValue ==KeyEvent.VK_DELETE  ) {
					//getToolkit().beep();   
					e.consume();
				}
							
			}
		});
		textFieldCustomerName.setBounds(148, 194, 111, 20);
		frame.getContentPane().add(textFieldCustomerName);
		textFieldCustomerName.setColumns(10);
		

		
		
		JLabel lblIconLogo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/rsLogo.png")).getImage().getScaledInstance(180, 85, Image.SCALE_SMOOTH);
		lblIconLogo.setIcon(new ImageIcon(img));		
		//lblIconLogo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIconLogo.setBounds(121, 0, 177, 176);
		frame.getContentPane().add(lblIconLogo);
		
//		frame.add(btnProceed);
//		frame.pack();
//      frame.setVisible(true);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(121, 290, 79, 86);
		panel.setForeground(color);
		panel.setBackground(new Color(201, 210, 218));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JRadioButton rdbtnVeg = new JRadioButton("Veg");
		rdbtnVeg.setBackground(new Color(95, 158, 160));
		rdbtnVeg.setBounds(6, 7, 109, 23);
		rdbtnVeg.setForeground(color);
		rdbtnVeg.setBackground(new Color(201, 210, 218));
		panel.add(rdbtnVeg);
		
		JRadioButton rdbtnNonveg = new JRadioButton("Non-Veg");
		rdbtnNonveg.setBackground(new Color(95, 158, 160));
		rdbtnNonveg.setBounds(6, 38, 109, 23);
		rdbtnNonveg.setForeground(color);
		rdbtnNonveg.setBackground(new Color(201, 210, 218));
		panel.add(rdbtnNonveg);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProceed.setBounds(503, 391, 96, 23);
		btnProceed.setForeground(color);
		frame.getContentPane().add(btnProceed);
		
		JCheckBox checkboxMeal = new JCheckBox("Meal");
		checkboxMeal.setBackground(new Color(95, 158, 160));
		checkboxMeal.setBounds(128, 252, 60, 23);
		checkboxMeal.setForeground(color);
		checkboxMeal.setBackground(new Color(201, 210, 218));
		frame.getContentPane().add(checkboxMeal);
		checkboxMeal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
		        
				if(checkboxMeal.isSelected()) {
				   panel.setVisible(true);
				   
				}else {
					panel.setVisible(false);
				} 
				
	
			}
			
		});
		
		JCheckBox checkboxHouseKeeping = new JCheckBox("House Keeping");
		checkboxHouseKeeping.setBackground(new Color(95, 158, 160));
		checkboxHouseKeeping.setBounds(190, 252, 123, 23);
		checkboxHouseKeeping.setForeground(color);
		checkboxHouseKeeping.setBackground(new Color(201, 210, 218));
		frame.getContentPane().add(checkboxHouseKeeping);
		checkboxHouseKeeping.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	
		
		
		Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 24); // 24 == 12 PM == 00:00:00
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        SpinnerDateModel model = new SpinnerDateModel();
        model.setValue(calendar.getTime());

//        JSpinner spinnerTime = new JSpinner(model);
//		/*spinnerTime.setBounds(414, 283, 50, 20);
//		frame.getContentPane().add(spinnerTime);*/
//
//        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerTime, "HH:mm"); //add "HH:mm a" for am/pm
//        DateFormatter formatter = (DateFormatter)editor.getTextField().getFormatter();
//        formatter.setAllowsInvalid(false); 
//        formatter.setOverwriteMode(true);
//
//        spinnerTime.setEditor(editor);
//        spinnerTime.setForeground(Color.WHITE);
//        spinnerTime.setBounds(470, 284, 60, 25);
//		frame.getContentPane().add(spinnerTime);
		
	//setMealListener(rdbtnVeg , rdbtnNonveg);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.setForeground(color);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				textFieldTime.setText("");
				textFieldCustomerName.setText("");
				//checkboxMeal;
				//checkboxHouseKeeping.disable();
				//rdbtnNonveg , rdbtnVeg , checkboxMeal, checkboxHouseKeeping
				
				Reservation.main(null, user);
			}
		});
		btnCancel.setBounds(404, 391, 89, 23);
		frame.getContentPane().add(btnCancel);
	
		btnProceed.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
						        
				customerName  = textFieldCustomerName.getText();
					
				  //Create an instance of Validate class and pass all the inputs given by the user
				  Validate validate = new Validate(customerName );
					
					user.setUsername(customerName);
					user.setId(getUserId(customerName));

			
					  //create an instance of Authenticate class to verify userName and password inputs
					  Authenticate auth = new Authenticate();
					  auth.setUsername(customerName );
						try {
					   //  if(validate.isCustmerDataValid()) {
					    	 
					    	 if(auth.matchUserName()) {
					    	    //customername
						        serviceData.setResType(resType);
								System.out.println("Valid Username");
								serviceData.setCustomerName(textFieldCustomerName.getText());
								float time = Float.parseFloat(textFieldTime.getText());
								
								if(time >=1.00) {
								    serviceData.setTime(Float.parseFloat(textFieldTime.getText()));
								}
								 else {
										JOptionPane.showMessageDialog(frame, "Please Enter a Valid Time");		
										}
									//mealstatus
							   if(checkboxMeal.isSelected()) {
								  String mealStatus = "Yes";
								  serviceData.setMealNeeded(mealStatus);
									     //meal type
									     if(rdbtnVeg.isSelected()) {
										  String mealService = "Veg";
										  serviceData.setMealType(mealService);
									      }else  {
										  String mealServices = "Non-Veg";
										  serviceData.setMealType(mealServices);
									      }
							   }
							    else {
								       String mealStatus = "No";
								       serviceData.setMealNeeded(mealStatus);
								     }  
								        //housekeeping
							   if(checkboxHouseKeeping.isSelected()) {
								    String houseKeepingStatus = "Yes";
								    serviceData.setHouseKeepingNeeded(houseKeepingStatus);
							     } 
								 else {
								         String houseKeepingStatus = "No";
								         serviceData.setHouseKeepingNeeded(houseKeepingStatus);	
								       } 
					 }
					  else {
					  		  System.out.println(" Please check user Username ");
				               JOptionPane.showMessageDialog(frame, "Please check user Username ");
					       }
					    	 				
					    	 frame.dispose();
					    	 
					    	 /*Service ns = new Service();
								ns.setCustomerName(textFieldCustomerName.getText());
								ns.setResType(serviceData.getResType());
								ns.setRoomNumber(Integer.parseInt(textFieldRoomNumber.getText()));
								ns.setServiceTypeMeal(serviceData.getServiceTypeMeal());
								ns.setServiceTypeHouseKeeping(serviceData.getServiceTypeHouseKeeping());
								ns.setMealType(serviceData.getMealType() );  
								ns.setTime(Float.parseFloat((textFieldTime.getText())));
								
								helper.roomService(ns);
					    	 */
						} catch(Exception ex) {
							System.out.println("Error in inserting " + ex.getMessage());
							JOptionPane.showMessageDialog(null," Empty Fields .");
							
						}
						

					/*    	//Build the new 
								Service ns = new Service();
								ns.setCustomerName(textFieldCustomerName.getText());
								System.out.println("Res TYPE: "+ serviceData.getResType());
								ns.setResType(serviceData.getResType());
								
								ns.setMealNeeded(serviceData.getMealNeeded());
								ns.setHouseKeepingNeeded(serviceData.getHouseKeepingNeeded());
								ns.setMealType(serviceData.getMealType() );  
								ns.setTime(Float.parseFloat((textFieldTime.getText())));
							*/	
							//	roomService(ns);
						Service ns = new Service();
						addData(ns);
		

					    	
						ns.setCustomerName(textFieldCustomerName.getText());
						System.out.println("Res TYPE: "+ serviceData.getResType());
						ns.setResType(serviceData.getResType());
						
						ns.setMealNeeded(serviceData.getMealNeeded());
						ns.setHouseKeepingNeeded(serviceData.getHouseKeepingNeeded());
						ns.setMealType(serviceData.getMealType() );  
						ns.setTime(Float.parseFloat((textFieldTime.getText())));
							


			}
			
		});
				
	}
	
	
	//insert the data
	public void insertDataAfterConfirm() {
		if(getConfirmationStatus()) {
			Service service = RoomService.ns;
			System.out.println(service.getCustomerName());
			roomService(service);
		}
			
	}

	
	//method to get id of user
	  public int getUserId(String username) 
		{
		  int userId = 0;
		  
		  String sql = "SELECT * FROM user_Info where userName = ?";
		  
		  try {
			  helper.connectDB();
		  
			  //create statement 
			  pstmt = helper.getConnection().prepareStatement(sql);
		  	  
			  pstmt.setString(1, username);
			  rs = pstmt.executeQuery(); 
			  while(rs.next())
			  {
				  userId =  rs.getInt("id");
			  }
		  
		  helper.disconnectDB();
		  }catch(SQLException sx)
		  {
			  System.out.println("Error fetching data from the database");
			  System.out.println(sx.getMessage());
			  System.out.println(sx.getErrorCode());
			  System.out.println(sx.getSQLState()); 
		  }
		  
		  return userId;
		}

	//method to add user room service info into the roomService_Info  table at the time of reservation
	  public int roomService(Service serviceData)	{ //, serviceType  .   "','" + serviceData.isServiceType() +  
	  	 int roomService = 0;		
	  	//Get all the shoes! Shoes for days!
	  	String sql = "Insert into roomService_Info (customerName , resType , mealNeeded , houseKeepingNeeded , mealType, time  )" 
	  			+ " VALUES ('" + serviceData.getCustomerName()  + "','" + serviceData.getResType()  + "','"  + serviceData.getMealNeeded() 
	  			+ "','" + serviceData.getHouseKeepingNeeded() + "','" + serviceData.getMealType() +"','" + serviceData.getTime() +"');";
	  	
	  	try {
	  		//Connect to the database
	  		helper.connectDB();
	  		
	  		//Create the statement
	  		this.stmt = helper.getConnection().createStatement();
	  		
	  		//Execute the statement
	  		roomService = stmt.executeUpdate(sql , Statement.RETURN_GENERATED_KEYS);

	  		helper.disconnectDB();			
	  		
	  	} catch (SQLException sx) {
	  		System.out.println("Error Connecting to Database");
	  		System.out.println(sx.getMessage());
	  		System.out.println(sx.getErrorCode());
	  		System.out.println(sx.getSQLState());
	  		
	  	}
	  	System.out.println("Inserted new Room Service: " + roomService);
	  	return roomService;
	  	
	  }  
	  
	  
	  public void setConfirmationStatus(boolean status) {
		  confirmationStatus = status;
	  }
	  
	  public boolean getConfirmationStatus() {
		  return confirmationStatus;
		  }
	
	  public int addData(Service ns ) {
		  
		//Build the new 
			//Service ns = new Service();
			ns.setCustomerName(textFieldCustomerName.getText());
			System.out.println("Res TYPE: "+ serviceData.getResType());
			ns.setResType(serviceData.getResType());
			
			ns.setMealNeeded(serviceData.getMealNeeded());
			ns.setHouseKeepingNeeded(serviceData.getHouseKeepingNeeded());
			ns.setMealType(serviceData.getMealType() );  
			ns.setTime(Float.parseFloat((textFieldTime.getText())));
			
			return roomService(ns);
	  }
}