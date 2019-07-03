package com.csis.Boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class AdminHome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome window = new AdminHome();
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
	public AdminHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 572, 369);
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setLayout(null);
		
		JLabel lblImg = new JLabel("ADMIN");
		lblImg.setForeground(Color.WHITE);
		lblImg.setFont(new Font("Nirmala UI", Font.BOLD, 22));
		
		lblImg.setBounds(250, 39, 110, 57);
		frame.getContentPane().add(lblImg);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/reserve.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(img));
		label.setBounds(56, 135, 96, 119);
		frame.getContentPane().add(label);
		
		JLabel lblReservation = new JLabel("Reservation");
		lblReservation.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReservation.setForeground(Color.WHITE);
		lblReservation.setBounds(56, 265, 87, 31);
		frame.getContentPane().add(lblReservation);
		
		JLabel lblStaff = new JLabel("");
		Image imgStaff = new ImageIcon(this.getClass().getResource("/staff.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblStaff.setIcon(new ImageIcon(imgStaff));
		lblStaff.setBounds(246, 135, 96, 119);
		frame.getContentPane().add(lblStaff);
		
		JLabel lblStaffText = new JLabel("Staff");
		lblStaffText.setForeground(Color.WHITE);
		lblStaffText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStaffText.setBounds(272, 265, 61, 31);
		frame.getContentPane().add(lblStaffText);
		
		JLabel lblInventory = new JLabel("");
		Image imgInventory = new ImageIcon(this.getClass().getResource("/inventory.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblInventory.setIcon(new ImageIcon(imgInventory));
		lblInventory.setBounds(431, 135, 96, 119);
		frame.getContentPane().add(lblInventory);
		
		JLabel lblInvenText = new JLabel("Inventory");
		lblInvenText.setForeground(Color.WHITE);
		lblInvenText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInvenText.setBounds(441, 265, 77, 31);
		frame.getContentPane().add(lblInvenText);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
