package com.csis.Boundary;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Checkbox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RoomService {

	private JFrame frame;
	private JTextField textFieldT;
	private JTextField textFieldCN;
	private JTextField textFieldRN;

	/**
	 * Launch the application.
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel labelRSS = new JLabel("Room Service  System");
		labelRSS.setBounds(148, 11, 106, 31);
		frame.getContentPane().add(labelRSS);
		
		JLabel labelRT = new JLabel("Request Type :");
		labelRT.setBounds(39, 107, 95, 31);
		frame.getContentPane().add(labelRT);
		
		Checkbox checkboxM = new Checkbox("Meal");
		checkboxM.setBounds(140, 107, 95, 31);
		frame.getContentPane().add(checkboxM);
		
		Checkbox checkboxHK = new Checkbox("HouseKeeping");
		checkboxHK.setBounds(245, 107, 95, 31);
		frame.getContentPane().add(checkboxHK);
		
		JLabel lblRequestTime = new JLabel("Request Time : ");
		lblRequestTime.setBounds(39, 138, 75, 20);
		frame.getContentPane().add(lblRequestTime);
		
		textFieldT = new JTextField();
		textFieldT.setText("00:00 ");
		textFieldT.setBounds(134, 138, 49, 20);
		frame.getContentPane().add(textFieldT);
		textFieldT.setColumns(10);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setBounds(193, 141, 46, 14);
		frame.getContentPane().add(lblMinutes);
		
		JLabel lblCustomerName = new JLabel("Customer Name :");
		lblCustomerName.setBounds(39, 53, 95, 20);
		frame.getContentPane().add(lblCustomerName);
		
		JLabel lblRoomNumber = new JLabel("Room Number :");
		lblRoomNumber.setBounds(39, 79, 75, 31);
		frame.getContentPane().add(lblRoomNumber);
		
		textFieldCN = new JTextField();
		textFieldCN.setBounds(149, 53, 86, 20);
		frame.getContentPane().add(textFieldCN);
		textFieldCN.setColumns(10);

		
		textFieldRN = new JTextField();
		textFieldRN.setBounds(149, 81, 86, 20);
		frame.getContentPane().add(textFieldRN);
		textFieldRN.setColumns(10);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.setBounds(140, 182, 89, 23);
		frame.getContentPane().add(btnProceed);
		
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
						
						
						boolean checked = checkboxM.getState();
						boolean checked2 = checkboxHK.getState();

						if (textFieldRN.getText().equals("") && textFieldCN.getText().equals("")){

							JOptionPane.showMessageDialog(frame, "Please enter your name and room number.");

						     }
						     else {
						    	   if ( checkboxM.getState() == true  ) {
//								    	 btnProceed.setEnabled(true);
								        String names = JOptionPane.showInputDialog(
										"What kind meal "+ "textFieldCN " +" want?");
								        JOptionPane.showMessageDialog(frame, "Thanks for your request");
						    		 
						    	   }else if (checkboxHK.getState() == true) {
						    		   String names = JOptionPane.showInputDialog(
												"What type of service "+ "textFieldCN " +" for house Keeping");
										        JOptionPane.showMessageDialog(frame, "Thanks for your request");
						    	   }else if( !textFieldT.getText().equals(" ")) {
								        JOptionPane.showMessageDialog(frame, "Please mention the time  when you need service");
						    	   }
						    	   
						    	   else {
						    	   
							        JOptionPane.showMessageDialog(frame, "Please select your request type. Thanks");
						    	   }
						
					}
			
					}		
				}
				);
	}
}
