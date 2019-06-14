package com.csis.Controller;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BanquetReservation {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BanquetReservation window = new BanquetReservation();
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
	public BanquetReservation() {
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
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBackground(new Color(95, 158, 160));
		lblDate.setBounds(50, 119, 46, 14);
		frame.getContentPane().add(lblDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(129, 113, 91, 20);
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
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane option = new JOptionPane();
				option.showMessageDialog(null, "confirmed!");
			}
		});
		btnConfirm.setForeground(new Color(51, 153, 102));
		btnConfirm.setBounds(150, 371, 89, 23);
		frame.getContentPane().add(btnConfirm);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
