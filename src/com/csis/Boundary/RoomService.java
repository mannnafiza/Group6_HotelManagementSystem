package com.csis.Boundary;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import java.awt.Checkbox;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.DateFormatter;

import com.csis.Controller.Authenticate;
import com.csis.Controller.BanquetReservation;
import com.csis.Controller.RoomReservation;
import com.csis.Controller.Validate;
import com.csis.Entities.Service;
import com.csis.Entities.UserInfo;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;

import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import java.awt.Choice;


public class RoomService {

	private JFrame frame;
	private JTextField textFieldTime;
	private JTextField textFieldCustomerName;
	private JTextField textFieldRoomNumber;
	 Validate validate = new Validate();
    private String	customerName  = "";
    String errorMsg;
	boolean inputValid = false;
	Service serviceData = new Service();
	UserInfo user = new UserInfo();
    String resType;
    
    
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
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		//frame.setBackground(UIManager.getColor("" ));
		frame.setBackground(UIManager.getColor("Blue"));
		frame.setBounds(100, 100, 801, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel labelRSS = new JLabel("   Room Service  System");
		labelRSS.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelRSS.setBounds(206, 11, 324, 41);
		frame.getContentPane().add(labelRSS);
		
		JLabel labelRT = new JLabel("Request Type :");
		labelRT.setBounds(34, 248, 109, 31);
		frame.getContentPane().add(labelRT);
		
		JLabel lblRequestTime = new JLabel("Request Time : ");
		lblRequestTime.setBounds(371, 253, 89, 20);
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
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setBounds(529, 253, 46, 14);
		frame.getContentPane().add(lblMinutes);
		
		JLabel lblCustomerName = new JLabel("Customer Name :");
		lblCustomerName.setBounds(34, 194, 109, 20);
		frame.getContentPane().add(lblCustomerName);
		
		JLabel lblRoomNumber = new JLabel("Room Number(1 to 100) :");
		lblRoomNumber.setBounds(316, 193, 144, 22);
		frame.getContentPane().add(lblRoomNumber);
		
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

		
		textFieldRoomNumber = new JTextField();
		textFieldRoomNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char roomnumberValue = arg0.getKeyChar();
				if(!Character.isDigit(roomnumberValue) ||  roomnumberValue == KeyEvent.VK_BACK_SPACE   || roomnumberValue ==KeyEvent.VK_DELETE  ) {
					//getToolkit().beep();   
					arg0.consume();
				}
				
			}
		});
		textFieldRoomNumber.setBounds(470, 194, 111, 20);
		frame.getContentPane().add(textFieldRoomNumber);
		textFieldRoomNumber.setColumns(10);
		
//serviceData.getResType().equals("Banquet")
		if(resType == "Banquet") {
			textFieldRoomNumber.setVisible(false);
			lblRoomNumber.setVisible(false);
		}else {
			textFieldRoomNumber.setVisible(true);
			lblRoomNumber.setVisible(true);
		}
		
		
		
		JLabel lblIconLogo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/rsLogo.jpg")).getImage().getScaledInstance(180, 85, Image.SCALE_SMOOTH);
		lblIconLogo.setIcon(new ImageIcon(img));		
		//lblIconLogo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIconLogo.setBounds(204, 39, 210, 130);
		frame.getContentPane().add(lblIconLogo);
		
//		frame.add(btnProceed);
//		frame.pack();
//      frame.setVisible(true);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(121, 290, 79, 86);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JRadioButton rdbtnVeg = new JRadioButton("Veg");
		rdbtnVeg.setBackground(new Color(95, 158, 160));
		rdbtnVeg.setBounds(6, 7, 109, 23);
		panel.add(rdbtnVeg);
		
		JRadioButton rdbtnNonveg = new JRadioButton("Non-Veg");
		rdbtnNonveg.setBackground(new Color(95, 158, 160));
		rdbtnNonveg.setBounds(6, 38, 109, 23);
		panel.add(rdbtnNonveg);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.setBounds(558, 401, 96, 23);
		frame.getContentPane().add(btnProceed);
		
		JCheckBox checkboxMeal = new JCheckBox("Meal");
		checkboxMeal.setBackground(new Color(95, 158, 160));
		checkboxMeal.setBounds(128, 252, 60, 23);
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

        JSpinner spinnerTime = new JSpinner(model);
		/*spinnerTime.setBounds(414, 283, 50, 20);
		frame.getContentPane().add(spinnerTime);*/

        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerTime, "HH:mm"); //add "HH:mm a" for am/pm
        DateFormatter formatter = (DateFormatter)editor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false); 
        formatter.setOverwriteMode(true);

        spinnerTime.setEditor(editor);
        spinnerTime.setForeground(Color.WHITE);
        spinnerTime.setBounds(470, 284, 60, 25);
		frame.getContentPane().add(spinnerTime);
		
	//setMealListener(rdbtnVeg , rdbtnNonveg);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				textFieldTime.setText("");
				textFieldCustomerName.setText("");
				textFieldRoomNumber.setText("");
				//checkboxMeal;
				//checkboxHouseKeeping.disable();
				//rdbtnNonveg , rdbtnVeg , checkboxMeal, checkboxHouseKeeping
			}
		});
		btnCancel.setBounds(459, 401, 89, 23);
		frame.getContentPane().add(btnCancel);
	
		btnProceed.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
						        
				customerName  = textFieldCustomerName.getText();
					
				  //Create an instance of Validate class and pass all the inputs given by the user
				  Validate validate = new Validate(customerName );
					DBHelper helper = new DBHelper();
					user.setUsername(customerName);
					user.setId(helper.getUserId(customerName));

			
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
								//room number
								int roomNo = Integer.parseInt(textFieldRoomNumber.getText());
								float time = Float.parseFloat(textFieldTime.getText());
								if( roomNo>=1  &&  roomNo<100 ) {
									serviceData.setRoomNumber(roomNo);
								}else {
									JOptionPane.showMessageDialog(frame, "Please enter a valid room number");
							      }
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
							JOptionPane jop = new JOptionPane();
							jop.showMessageDialog(null," Empty Fields .");
							
						}
						
					    	//Build the new Student
								Service ns = new Service();
								ns.setCustomerName(textFieldCustomerName.getText());
								System.out.println("Res TYPE: "+ serviceData.getResType());
								ns.setResType(serviceData.getResType());
								if(ns.getResType().equals("Room"))
									ns.setRoomNumber(Integer.parseInt(textFieldRoomNumber.getText()));
								else
									ns.setRoomNumber(Integer.parseInt("0"));
								ns.setMealNeeded(serviceData.getMealNeeded());
								ns.setHouseKeepingNeeded(serviceData.getHouseKeepingNeeded());
								ns.setMealType(serviceData.getMealType() );  
								ns.setTime(Float.parseFloat((textFieldTime.getText())));
								
								helper.roomService(ns);
		
			}
			
		});
				
	}

	
}