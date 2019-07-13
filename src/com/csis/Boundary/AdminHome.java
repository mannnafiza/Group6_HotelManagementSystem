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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.setBounds(100, 100, 642, 464);
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(201, 210, 218));
		frame.getContentPane().setLayout(null);
		
		Color color = new Color(85, 96, 128);
		
		JLabel lblReserve = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/reserve.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblReserve.setIcon(new ImageIcon(img));
		lblReserve.setBounds(50, 221, 108, 135);
		frame.getContentPane().add(lblReserve);
		
		JLabel lblReservation = new JLabel("Reservation");
		lblReservation.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblReservation.setForeground(color);
		lblReservation.setBounds(61, 367, 87, 31);
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
		lblStaff.setBounds(276, 237, 96, 119);
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
		lblStaffText.setForeground(color);
		lblStaffText.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStaffText.setBounds(298, 367, 61, 31);
		frame.getContentPane().add(lblStaffText);
		
		JLabel lblInventory = new JLabel("");
		Image imgInventory = new ImageIcon(this.getClass().getResource("/inventory.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblInventory.setIcon(new ImageIcon(imgInventory));
		lblInventory.setBounds(469, 232, 96, 119);
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
		lblInvenText.setForeground(color);
		lblInvenText.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInvenText.setBounds(479, 367, 77, 31);
		frame.getContentPane().add(lblInvenText);
		
		JLabel lblAdminIcon = new JLabel("");
		Image imgAdmin = new ImageIcon(this.getClass().getResource("/adminlogin.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblAdminIcon.setIcon(new ImageIcon(imgAdmin));
		lblAdminIcon.setBounds(261, 11, 123, 127);
		frame.getContentPane().add(lblAdminIcon);
		
		JLabel label_1 = new JLabel("ADMIN");
		label_1.setForeground(new Color(85, 96, 128));
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		label_1.setBounds(271, 147, 101, 23);
		frame.getContentPane().add(label_1);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin.main(null);
				frame.dispose();
			}
		});
		btnLogOut.setForeground(new Color(85, 96, 128));
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogOut.setBounds(527, 11, 89, 23);
		frame.getContentPane().add(btnLogOut);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
