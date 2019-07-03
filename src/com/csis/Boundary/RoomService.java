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
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.csis.Controller.Authenticate;
import com.csis.Controller.Validate;
import com.csis.Entities.Service;
import com.csis.Entities.UserInfo;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

public class RoomService {

	private JFrame frame;
	private JTextField textFieldTime;
	private JTextField textFieldCustomerName;
	private JTextField textFieldRoomNumber;
	private Validate validate = new Validate();
    private String	customerName  = "";
    String errorMsg;
	boolean inputValid = false;
	Service ser = new Service();
    
    
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

	/**
	 * Create the application.
	 */
	public RoomService() {
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
		frame.setBounds(100, 100, 479, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel labelRSS = new JLabel("   Room Service  System");
		labelRSS.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelRSS.setBounds(111, 11, 206, 41);
		frame.getContentPane().add(labelRSS);
		
		JLabel labelRT = new JLabel("Request Type :");
		labelRT.setBounds(65, 217, 109, 31);
		frame.getContentPane().add(labelRT);
		
		Checkbox checkboxMeal = new Checkbox("Meal");
		checkboxMeal.setBounds(180, 217, 95, 31);
		frame.getContentPane().add(checkboxMeal);
		
		Checkbox checkboxHouseKeeping = new Checkbox("HouseKeeping");
		checkboxHouseKeeping.setBounds(279, 217, 109, 31);
		frame.getContentPane().add(checkboxHouseKeeping);
		
		JLabel lblRequestTime = new JLabel("Request Time : ");
		lblRequestTime.setBounds(65, 248, 89, 20);
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
		textFieldTime.setText("00:00 ");
		textFieldTime.setBounds(174, 248, 49, 20);
		frame.getContentPane().add(textFieldTime);
		textFieldTime.setColumns(10);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setBounds(233, 251, 46, 14);
		frame.getContentPane().add(lblMinutes);
		
		JLabel lblCustomerName = new JLabel("Customer Name :");
		lblCustomerName.setBounds(54, 163, 109, 20);
		frame.getContentPane().add(lblCustomerName);
		
		JLabel lblRoomNumber = new JLabel("Room Number :");
		lblRoomNumber.setBounds(65, 189, 89, 22);
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
		textFieldCustomerName.setBounds(166, 163, 109, 20);
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
		textFieldRoomNumber.setBounds(164, 194, 111, 20);
		frame.getContentPane().add(textFieldRoomNumber);
		textFieldRoomNumber.setColumns(10);
		
		JLabel lblIconLogo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/rsLogo.jpg")).getImage().getScaledInstance(180, 85, Image.SCALE_SMOOTH);
		lblIconLogo.setIcon(new ImageIcon(img));		
		//lblIconLogo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIconLogo.setBounds(98, 53, 167, 81);
		frame.getContentPane().add(lblIconLogo);
		
//		frame.add(btnProceed);
//		frame.pack();
//      frame.setVisible(true);
	
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.setBounds(180, 292, 89, 23);
		frame.getContentPane().add(btnProceed);
		btnProceed.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				 // TODO Auto-generated  method stub
				customerName  = textFieldCustomerName.getText();
					
				  //Create an instance of Validate class and pass all the inputs given by the user
				  Validate validate = new Validate(customerName );
				  boolean checked = checkboxMeal.getState();
				  boolean checked2 = checkboxHouseKeeping.getState();
			
					  //create an instance of Authenticate class to verify userName and password inputs
					  Authenticate auth = new Authenticate();
						auth.setUsername(customerName );
						
						if(auth.matchUserName() || validate.isCustmerDataValid())
						{
							System.out.println("Valid Username");
							
							//set user information
							UserInfo user = new UserInfo();
							DBHelper helper = new DBHelper();
							user.setUsername(customerName );
							user.setId(helper.getUserId(customerName ));
						  
						//	validateInfo(ser.getRoomNumber(),  ser.getTime());
						//	if(inputValid) {
							//	try {
									
									//java.sql.Date sqlDate = new java.sql.Date(roomData.getReserveDate().getTime());
									
								//	helper.insertRoomServiceInformation(ser.getCustomerName(),  ser.getRoomNumber(), ser.getServiceType(), ser.getTime());
									
								
							//check validation
									if(checkboxMeal.getState() == true ) {
//						   	             btnProceed.setEnabled(true);
						                 String names = JOptionPane.showInputDialog(
								         "What kind meal "+ textFieldCustomerName.getText()  +" want?");
						                  JOptionPane.showMessageDialog(frame, "Thanks for your request");
					    		 
					                 }
					                  else if (checkboxHouseKeeping.getState() == true) {
					    		             String names = JOptionPane.showInputDialog(
										    	"What type of service "+ textFieldCustomerName.getText() +" for house Keeping");
							 		             JOptionPane.showMessageDialog(frame, "Thanks for your request");
					    	         }
					                  else {
					    	   
						                     JOptionPane.showMessageDialog(frame, "Please select your request type. Thanks");
					    	         }
								
							
							}else
						      {
							  System.out.println("Check Username ");
							  JOptionPane jop = new JOptionPane();
						    	jop.showMessageDialog(null,"heck Username , Room Number and Check Time.");
						    }						
		
			}
			
		});
		
		
	}
	
	
	protected boolean validateInfo(int roomNumber, float time) {
		// TODO Auto-generated method stub
		inputValid = true;
		errorMsg = "Please enter the following field: ";
		
		if(roomNumber <= 0) {
			errorMsg = "\n Room Number";
			inputValid = false;
		}
		if(time <= 0) {
			errorMsg += "\n Time";
			inputValid = false;
		}
			
		return inputValid;
	}
	
}	

