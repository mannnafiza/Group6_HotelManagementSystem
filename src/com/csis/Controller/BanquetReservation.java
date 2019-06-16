package com.csis.Controller;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import com.csis.Boundary.DBHelper;
import com.csis.Entities.Banquet;
import com.csis.Entities.UserInfo;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class BanquetReservation {

	private JFrame frame;
	UserInfo user;
	Banquet banquetData = new Banquet();
	boolean inputValid = false;
	String errorMsg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, UserInfo user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BanquetReservation window = new BanquetReservation(user);
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
	public BanquetReservation(UserInfo user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 446, 462);
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel((String) null);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(344, 11, 76, 14);
		lblUsername.setText(user.getUsername());
		frame.getContentPane().add(lblUsername);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBackground(new Color(95, 158, 160));
		lblDate.setBounds(50, 119, 46, 14);
		frame.getContentPane().add(lblDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(129, 113, 91, 20);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		frame.getContentPane().add(dateChooser);
		
		JLabel lblMeal = new JLabel("Meal ");
		lblMeal.setForeground(Color.WHITE);
		lblMeal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMeal.setBounds(50, 187, 87, 14);
		frame.getContentPane().add(lblMeal);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setForeground(Color.WHITE);
		rdbtnYes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnYes.setBackground(new Color(95, 158, 160));
		rdbtnYes.setBounds(53, 218, 109, 23);
		frame.getContentPane().add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setForeground(Color.WHITE);
		rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNo.setBackground(new Color(95, 158, 160));
		rdbtnNo.setBounds(53, 256, 109, 23);
		frame.getContentPane().add(rdbtnNo);
		
		JLabel lblTitle = new JLabel("Banquet Reservation");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Serif", Font.ITALIC, 20));
		lblTitle.setBounds(106, 40, 232, 25);
		frame.getContentPane().add(lblTitle);
		
		JCheckBox chkAddService = new JCheckBox("Additional Services");
		chkAddService.setForeground(Color.WHITE);
		chkAddService.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chkAddService.setBackground(new Color(95, 158, 160));
		chkAddService.setBounds(44, 317, 192, 23);
		frame.getContentPane().add(chkAddService);
		
		/**
		 * set listeners
		 */
		setDateListener(dateChooser);
		setMealListener(rdbtnYes, rdbtnNo);
		setAddServiceListener(chkAddService);
		
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validateInfo(banquetData.getDate(), banquetData.isMeal());
				if(inputValid) {
					System.out.println(displayDate() + " " +banquetData.isAddService() + " " +banquetData.isMeal());
					
					DBHelper helper = new DBHelper();
					
					try {
						
						java.sql.Date sqlDate = new java.sql.Date(banquetData.getDate().getTime());
						helper.insertReservationInformation(user.getId(), user.getUsername(), "banquet","-", 0, banquetData.isMeal(),
								"-", sqlDate, 0, banquetData.isAddService(), 0, "-" );
						JOptionPane.showMessageDialog(null, "Banquet Reservation confirmed");
					} catch(Exception ex) {
						System.out.println("Error in inserting " + ex.getMessage());
				}
				
				
			}
				else {
					JOptionPane.showMessageDialog(null, errorMsg);
				}
			}
			});
		btnConfirm.setForeground(new Color(51, 153, 102));
		btnConfirm.setBounds(150, 371, 89, 23);
		frame.getContentPane().add(btnConfirm);
		
		
	}
	
	

	protected String displayDate() {
		String actualDate = DateFormat.getDateInstance().format(banquetData.getDate());
		return actualDate;
	}

	private void setAddServiceListener(JCheckBox chkAddService) {
		// TODO Auto-generated method stub
		chkAddService.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				AbstractButton absButton = (AbstractButton) event.getSource();
				boolean serviceStatus = absButton.isSelected();
				banquetData.setAddService(serviceStatus);
			}
			
		});
	}

	private void setMealListener(JRadioButton rdbtnYes, JRadioButton rdbtnNo) {
		// TODO Auto-generated method stub
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnYes);
		radioGroup.add(rdbtnNo);
		
		class BanquetActionListener implements ActionListener {
		      public void actionPerformed(ActionEvent ex) {
		      String choice = radioGroup.getSelection().getActionCommand();
		      }
		    }

		  class BanquetItemListener implements ItemListener {
		   			@Override
			public void itemStateChanged(ItemEvent ex) {
				// TODO Auto-generated method stub
				String item = ((AbstractButton) ex.getItemSelectable()).getActionCommand();
		        boolean selected = (ex.getStateChange() == ItemEvent.SELECTED);
		        if(item.equals("Yes")) {
			    	  banquetData.setMeal("yes");
			      }else {
			    	  banquetData.setMeal("no");
			      }
			}
		    }

		    ActionListener al = new BanquetActionListener();
		    rdbtnYes.addActionListener(al);
		    rdbtnNo.addActionListener(al);

		    ItemListener il = new BanquetItemListener();
		    rdbtnYes.addItemListener(il);
		    rdbtnNo.addItemListener(il);
	}

	private void setDateListener(JDateChooser dateChooser) {
		// TODO Auto-generated method stub
		dateChooser.getDateEditor().addPropertyChangeListener("date", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {
				// TODO Auto-generated method stub
				Date date = (Date) event.getNewValue();
				banquetData.setDate(date);;
				}
			
		});
	}
	
	protected boolean validateInfo(Date date, String mealType) {
		// TODO Auto-generated method stub
		errorMsg = "Please enter the following field: ";
		inputValid = true;
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
}
