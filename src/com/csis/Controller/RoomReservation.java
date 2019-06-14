package com.csis.Controller;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class RoomReservation {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomReservation window = new RoomReservation();
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
	public RoomReservation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Color color = new Color(51, 153, 102);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 581, 462);
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.getContentPane().setLayout(null);
		
		JLabel lblRmReserveTitle = new JLabel("Room Reservation");
		lblRmReserveTitle.setForeground(Color.WHITE);
		lblRmReserveTitle.setFont(new Font("Serif", Font.ITALIC, 20));
		lblRmReserveTitle.setBounds(208, 44, 232, 25);
		frame.getContentPane().add(lblRmReserveTitle);
		
		JList listRoomType = new JList();
		listRoomType.setBounds(113, 121, 138, 153);
		frame.getContentPane().add(listRoomType);
		
		JLabel lvlRoomType = new JLabel("Room Type");
		lvlRoomType.setForeground(Color.WHITE);
		lvlRoomType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lvlRoomType.setBounds(23, 122, 80, 35);
		frame.getContentPane().add(lvlRoomType);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setForeground(Color.WHITE);
		lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDuration.setBounds(353, 134, 70, 23);
		frame.getContentPane().add(lblDuration);
		
		JSpinner spinDuration = new JSpinner();
		spinDuration.setBounds(433, 137, 29, 20);
		frame.getContentPane().add(spinDuration);
		
		JLabel lblMeal = new JLabel("Meal ");
		lblMeal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMeal.setForeground(Color.WHITE);
		lblMeal.setBounds(353, 194, 87, 14);
		frame.getContentPane().add(lblMeal);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setForeground(Color.WHITE);
		rdbtnYes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnYes.setBounds(353, 215, 109, 23);
		rdbtnYes.setBackground(new Color(95, 158, 160));
		frame.getContentPane().add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setForeground(Color.WHITE);
		rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNo.setBackground(new Color(95, 158, 160));
		rdbtnNo.setBounds(353, 241, 109, 23);
		frame.getContentPane().add(rdbtnNo);
		
		JCheckBox chkAddService = new JCheckBox("Additional Services");
		chkAddService.setForeground(Color.WHITE);
		chkAddService.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chkAddService.setBounds(23, 324, 192, 23);
		chkAddService.setBackground(new Color(95, 158, 160));
		frame.getContentPane().add(chkAddService);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(223, 371, 89, 23);
		btnConfirm.setForeground(color);
		frame.getContentPane().add(btnConfirm);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
