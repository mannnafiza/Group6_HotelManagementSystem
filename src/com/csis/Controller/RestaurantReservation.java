package com.csis.Controller;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Date;

import com.csis.Entities.Restaurant;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class RestaurantReservation {

	private JFrame frame;
	Restaurant restaurantData = new Restaurant();
	String errorMsg;
	boolean inputValid = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantReservation window = new RestaurantReservation();
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
	public RestaurantReservation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 560, 462);
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Restaurant Reservation");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Serif", Font.ITALIC, 20));
		lblTitle.setBounds(212, 41, 232, 25);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBackground(new Color(95, 158, 160));
		lblDate.setBounds(63, 174, 46, 25);
		frame.getContentPane().add(lblDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(175, 167, 91, 20);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		frame.getContentPane().add(dateChooser);
		
		JRadioButton rdbtnBreakfast = new JRadioButton("Breakfast");
		rdbtnBreakfast.setSelected(true);
		rdbtnBreakfast.setForeground(Color.WHITE);
		rdbtnBreakfast.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnBreakfast.setBounds(175, 125, 91, 23);
		rdbtnBreakfast.setBackground(new Color(95, 158, 160));
		frame.getContentPane().add(rdbtnBreakfast);
		
		JRadioButton rdbtnBrunch = new JRadioButton("Brunch");
		rdbtnBrunch.setForeground(Color.WHITE);
		rdbtnBrunch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnBrunch.setBackground(new Color(95, 158, 160));
		rdbtnBrunch.setBounds(264, 125, 78, 23);
		frame.getContentPane().add(rdbtnBrunch);
		
		JRadioButton rdbtnLunch = new JRadioButton("Lunch");
		rdbtnLunch.setForeground(Color.WHITE);
		rdbtnLunch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnLunch.setBackground(new Color(95, 158, 160));
		rdbtnLunch.setBounds(344, 125, 78, 23);
		frame.getContentPane().add(rdbtnLunch);
		
		JRadioButton rdbtnDinner = new JRadioButton("Dinner");
		rdbtnDinner.setForeground(Color.WHITE);
		rdbtnDinner.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnDinner.setBackground(new Color(95, 158, 160));
		rdbtnDinner.setBounds(424, 125, 109, 23);
		frame.getContentPane().add(rdbtnDinner);
		
		JLabel lblReservationFor = new JLabel("Reservation for:");
		lblReservationFor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReservationFor.setForeground(Color.WHITE);
		lblReservationFor.setBounds(63, 123, 118, 25);
		frame.getContentPane().add(lblReservationFor);
		
		JLabel lblGuest = new JLabel("# Guest");
		lblGuest.setForeground(Color.WHITE);
		lblGuest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGuest.setBounds(63, 224, 72, 26);
		frame.getContentPane().add(lblGuest);
		
		JSpinner spinGuests = new JSpinner();
		spinGuests.setBounds(175, 229, 29, 31);
		frame.getContentPane().add(spinGuests);
		
		JLabel lblMealType = new JLabel("Meal Type");
		lblMealType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMealType.setForeground(Color.WHITE);
		lblMealType.setBounds(63, 280, 72, 25);
		frame.getContentPane().add(lblMealType);
		
		JRadioButton rdbtnVeg = new JRadioButton("Veg");
		rdbtnVeg.setForeground(Color.WHITE);
		rdbtnVeg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnVeg.setBounds(175, 282, 72, 23);
		rdbtnVeg.setBackground(new Color(95, 158, 160));
		frame.getContentPane().add(rdbtnVeg);
		
		JRadioButton rdbtnNonVeg = new JRadioButton("Non Veg");
		rdbtnNonVeg.setForeground(Color.WHITE);
		rdbtnNonVeg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNonVeg.setBackground(new Color(95, 158, 160));
		rdbtnNonVeg.setBounds(264, 282, 109, 23);
		frame.getContentPane().add(rdbtnNonVeg);
		
		/**
		 * set listeners
		 */
		setDateListener(dateChooser);
		setMealListener(rdbtnVeg, rdbtnNonVeg);
		setReservationForListener(rdbtnBreakfast, rdbtnBrunch, rdbtnLunch, rdbtnDinner);
		
		JButton button = new JButton("Confirm");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumberOfGuest(spinGuests);
				validateInfo(restaurantData.getDate(), restaurantData.getNoOfGuest(), restaurantData.getMealType());
				if(inputValid) {
					System.out.println(restaurantData.getMealType() + " " + restaurantData.getNoOfGuest() + " " 
							+ restaurantData.getDate() + " " + displayDate());
				} else {
					JOptionPane.showMessageDialog(null, errorMsg);
				}	
			}
		});
		button.setForeground(new Color(51, 153, 102));
		button.setBounds(239, 328, 89, 23);
		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	protected String displayDate() {
		String actualDate = DateFormat.getDateInstance().format(restaurantData.getDate());
		return actualDate;
	}
	
	private void setReservationForListener(JRadioButton rdbtnBreakfast, JRadioButton rdbtnBrunch,
			JRadioButton rdbtnLunch, JRadioButton rdbtnDinner) {
		// TODO Auto-generated method stub
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnBreakfast);
		radioGroup.add(rdbtnBrunch);
		radioGroup.add(rdbtnLunch);
		radioGroup.add(rdbtnDinner);
		
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
		        boolean selected = (ex.getStateChange() == ItemEvent.SELECTED);
		        if(item.equals("Breakfast")) {
			    	  restaurantData.setReservationFor("Breakfast");;
			      }else if(item.equals("Brunch")){
			    	  restaurantData.setReservationFor("Brunch");
			      }else if(item.equals("Lunch")) {
			    	  restaurantData.setReservationFor("Lunch");
			      }else {
			    	  restaurantData.setReservationFor("Dinner");
			      }
			}
		    }

		    ActionListener al = new RestaurantActionListener();
		    rdbtnBreakfast.addActionListener(al);
		    rdbtnBrunch.addActionListener(al);
		    rdbtnLunch.addActionListener(al);
		    rdbtnDinner.addActionListener(al);

		    ItemListener il = new RestaurantItemListener();
		    rdbtnBreakfast.addItemListener(il);
		    rdbtnBrunch.addItemListener(il);
		    rdbtnLunch.addItemListener(il);
		    rdbtnDinner.addItemListener(il);
	}

	protected void setNumberOfGuest(JSpinner spinGuests) {
		// TODO Auto-generated method stub
		restaurantData.setNoOfGuest(Integer.parseInt(spinGuests.getValue().toString()));
	}

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
}
