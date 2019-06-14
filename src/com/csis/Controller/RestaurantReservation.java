package com.csis.Controller;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Date;

import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RestaurantReservation {

	private JFrame frame;

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
		lblDate.setBounds(63, 118, 46, 14);
		frame.getContentPane().add(lblDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(142, 112, 91, 20);
		frame.getContentPane().add(dateChooser);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTime.setBounds(345, 120, 46, 14);
		frame.getContentPane().add(lblTime);
		
		JSpinner spinTime = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spinTime, "HH:mm:ss");
		spinTime.setEditor(timeEditor);
		spinTime.setValue(new Date());
		spinTime.setBounds(403, 117, 99, 20);
		frame.getContentPane().add(spinTime);
		
		JLabel lblGuest = new JLabel("# Guest");
		lblGuest.setForeground(Color.WHITE);
		lblGuest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGuest.setBounds(63, 188, 72, 14);
		frame.getContentPane().add(lblGuest);
		
		JSpinner spinGuests = new JSpinner();
		spinGuests.setBounds(162, 187, 29, 20);
		frame.getContentPane().add(spinGuests);
		
		JLabel lblMealType = new JLabel("Meal Type");
		lblMealType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMealType.setForeground(Color.WHITE);
		lblMealType.setBounds(63, 253, 72, 25);
		frame.getContentPane().add(lblMealType);
		
		JRadioButton rdbtnVeg = new JRadioButton("Veg");
		rdbtnVeg.setForeground(Color.WHITE);
		rdbtnVeg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnVeg.setBounds(167, 256, 72, 23);
		rdbtnVeg.setBackground(new Color(95, 158, 160));
		frame.getContentPane().add(rdbtnVeg);
		
		JRadioButton rdbtnNonVeg = new JRadioButton("Non Veg");
		rdbtnNonVeg.setForeground(Color.WHITE);
		rdbtnNonVeg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNonVeg.setBackground(new Color(95, 158, 160));
		rdbtnNonVeg.setBounds(252, 255, 109, 23);
		frame.getContentPane().add(rdbtnNonVeg);
		
		JButton button = new JButton("Confirm");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane option = new JOptionPane();
				option.showMessageDialog(null, "confirmed!");
			}
		});
		button.setForeground(new Color(51, 153, 102));
		button.setBounds(239, 328, 89, 23);
		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
