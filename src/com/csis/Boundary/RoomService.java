package com.csis.Boundary;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Checkbox;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.csis.Controller.Authenticate;
import com.csis.Controller.Validate;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RoomService {

	private JFrame frame;
	private JTextField textFieldTime;
	private JTextField textFieldCustomerName;
	private JTextField textFieldRoomNumber;
	private Validate validate = new Validate();
    private String	CustomerName = "";
    
    
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
		//frame.setBackground(UIManager.getColor("" ));
		frame.setBackground(UIManager.getColor("Blue"));
		frame.setBounds(100, 100, 445, 392);
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
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.setBounds(180, 292, 89, 23);
		frame.getContentPane().add(btnProceed);
		
		JLabel lblIconLogo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/rsLogo.jpg")).getImage().getScaledInstance(180, 85, Image.SCALE_SMOOTH);
		lblIconLogo.setIcon(new ImageIcon(img));		
		//lblIconLogo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIconLogo.setBounds(98, 53, 167, 81);
		frame.getContentPane().add(lblIconLogo);
		
//		frame.add(btnProceed);
//		frame.pack();
//        frame.setVisible(true);
		
		btnProceed.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						
//						String name = JOptionPane.showInputDialog(frame,
//						"What kind meal name want? " , null);
						
						
						boolean checked = checkboxMeal.getState();
						boolean checked2 = checkboxHouseKeeping.getState();

						if (textFieldRoomNumber.getText().equals("") && textFieldCustomerName.getText().equals("") && textFieldTime.getText().equals(" ")){
							
							JOptionPane.showMessageDialog(frame, "Please enter your name , room number and time .");
							
						     }
						  else 
						   { 
							  Authenticate auth = new Authenticate();
								auth.setUsername(CustomerName);
							// if( auth.matchUserName() ) {
								
//								 JOptionPane jop = new JOptionPane();
//									jop.showMessageDialog(null,"The username already exists, choose a different one.");
//						       
							     if ( checkboxMeal.getState() == true ) {
//							   	 btnProceed.setEnabled(true);
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
//							  }
//							 else {
//								 JOptionPane jop = new JOptionPane();
//									jop.showMessageDialog(null,"Your name does not exit in our reservation system.");
//								 
//							 }
						   }
						}
				}
				);
	}
}
