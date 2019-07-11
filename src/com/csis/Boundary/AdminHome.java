package com.csis.Boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.jws.soap.SOAPBinding.Use;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.csis.Entities.UserInfo;

import java.awt.Font;

public class AdminHome {

	private JFrame frame;
	UserInfo user;

	/**
	 * Launch the application
	 * @param args 
	 * @param user object of UserInfo
	 */
	public static void main(String[] args, UserInfo user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome window = new AdminHome(user);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application
	 * @param user object of UserInfo
	 */
	public AdminHome(UserInfo user) {
		this.user = user;
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
		
		JLabel lblReserve = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/reserve.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblReserve.setIcon(new ImageIcon(img));
		lblReserve.setBounds(56, 135, 96, 119);
		frame.getContentPane().add(lblReserve);
		
		JLabel lblReservation = new JLabel("Reservation");
		lblReservation.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReservation.setForeground(Color.WHITE);
		lblReservation.setBounds(56, 265, 87, 31);
		frame.getContentPane().add(lblReservation);
		
		/**
		 * Event listener for reservation module
		 */
		lblReserve.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Reservation.main(null, user);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		JLabel lblStaff = new JLabel("");
		Image imgStaff = new ImageIcon(this.getClass().getResource("/staff.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblStaff.setIcon(new ImageIcon(imgStaff));
		lblStaff.setBounds(246, 135, 96, 119);
		frame.getContentPane().add(lblStaff);
		
		/**
		 * Event listener for staff module
		 */
		lblStaff.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				StaffCustomization.main(null);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
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
		
		/**
		 * Event Listener for inventory module
		 */
		lblInventory.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				ManageInventory.main(null);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel lblInvenText = new JLabel("Inventory");
		lblInvenText.setForeground(Color.WHITE);
		lblInvenText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInvenText.setBounds(441, 265, 77, 31);
		frame.getContentPane().add(lblInvenText);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
