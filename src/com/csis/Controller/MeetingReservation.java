package com.csis.Controller;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import com.csis.Entities.Meeting;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
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
import java.util.Date;
import java.awt.event.ActionEvent;

public class MeetingReservation {

	private JFrame frame;
	Meeting meetingData = new Meeting();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MeetingReservation window = new MeetingReservation();
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
	public MeetingReservation() {
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
		
		JLabel lblMeetingReservation = new JLabel("Meeting Reservation");
		lblMeetingReservation.setForeground(Color.WHITE);
		lblMeetingReservation.setFont(new Font("Serif", Font.ITALIC, 20));
		lblMeetingReservation.setBounds(125, 54, 232, 25);
		frame.getContentPane().add(lblMeetingReservation);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBackground(new Color(95, 158, 160));
		lblDate.setBounds(85, 127, 46, 14);
		frame.getContentPane().add(lblDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(164, 121, 91, 20);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		frame.getContentPane().add(dateChooser);
		
		JLabel labelMeetingDuration = new JLabel("Duration");
		labelMeetingDuration.setForeground(Color.WHITE);
		labelMeetingDuration.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelMeetingDuration.setBounds(85, 175, 89, 23);
		frame.getContentPane().add(labelMeetingDuration);
		
		JLabel lblhours = new JLabel("(hours)");
		lblhours.setForeground(Color.WHITE);
		lblhours.setBounds(95, 197, 46, 14);
		frame.getContentPane().add(lblhours);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(167, 171, 29, 35);
		frame.getContentPane().add(spinner);
		
		JLabel lblMeetingMeal = new JLabel("Meal ");
		lblMeetingMeal.setForeground(Color.WHITE);
		lblMeetingMeal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMeetingMeal.setBounds(86, 234, 87, 14);
		frame.getContentPane().add(lblMeetingMeal);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setForeground(Color.WHITE);
		rdbtnYes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnYes.setBackground(new Color(95, 158, 160));
		rdbtnYes.setBounds(88, 255, 109, 23);
		frame.getContentPane().add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setForeground(Color.WHITE);
		rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNo.setBackground(new Color(95, 158, 160));
		rdbtnNo.setBounds(88, 281, 109, 23);
		frame.getContentPane().add(rdbtnNo);
		
		/**
		 * set listeners
		 */
		setReservationDateListener(dateChooser);
		setMealListener(rdbtnYes, rdbtnNo);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setMeetingDuration(spinner);
				System.out.println(displayDate() + " " + meetingData.getDuration() + " " + meetingData.isMeal());
//				JOptionPane option = new JOptionPane();
//				option.showMessageDialog(null, "Confirmed!");
			}
		});
		btnConfirm.setForeground(new Color(51, 153, 102));
		btnConfirm.setBounds(144, 360, 89, 23);
		frame.getContentPane().add(btnConfirm);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	protected String displayDate() {
		String actualDate = DateFormat.getDateInstance().format(meetingData.getReservedate());
		return actualDate;
	}

	protected void setMeetingDuration(JSpinner spinner) {
		// TODO Auto-generated method stub
		meetingData.setDuration(Integer.parseInt(spinner.getValue().toString()));
	}

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
			    	  meetingData.setMeal(true);
			      }else {
			    	  meetingData.setMeal(false);
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
}
