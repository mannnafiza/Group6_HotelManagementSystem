package com.csis.Boundary;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

public class Reservation {

	private JFrame frame;
	private String username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation window = new Reservation();
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
	public Reservation() {
		initialize();
	}
	
	/**
	 * Get the current username
	 */
	public Reservation(String username) {
		this.username = username;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 581, 391);
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Welcome");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Serif", Font.ITALIC, 20));
		lblTitle.setBounds(216, 54, 100, 25);
		frame.getContentPane().add(lblTitle);
		lblTitle.setText("Welcome " + username);
		
		JLabel lblRooms = new JLabel("");
		lblRooms.setBounds(52, 131, 70, 62);
		Image imgRoom = new ImageIcon(this.getClass().getResource("/room.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblRooms.setIcon(new ImageIcon(imgRoom));
		frame.getContentPane().add(lblRooms);
		
		JLabel lblMeetingText = new JLabel("Meeting Halls");
		lblMeetingText.setForeground(Color.WHITE);
		lblMeetingText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMeetingText.setBounds(184, 227, 125, 25);
		frame.getContentPane().add(lblMeetingText);
		
		JLabel lblMeetings = new JLabel("");
		lblMeetings.setBounds(184, 131, 88, 62);
		Image imgMeeting = new ImageIcon(this.getClass().getResource("/meetinghall.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblMeetings.setIcon(new ImageIcon(imgMeeting));
		frame.getContentPane().add(lblMeetings);
		
		JLabel lblRoomText = new JLabel("Rooms");
		lblRoomText.setForeground(Color.WHITE);
		lblRoomText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoomText.setBounds(52, 227, 57, 25);
		frame.getContentPane().add(lblRoomText);
		
		JLabel lblRestaurant = new JLabel("");
		lblRestaurant.setBounds(343, 131, 80, 62);
		Image imgRestaurant = new ImageIcon(this.getClass().getResource("/restaurant.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblRestaurant.setIcon(new ImageIcon(imgRestaurant));
		frame.getContentPane().add(lblRestaurant);
		
		JLabel lblRestaurantText = new JLabel("Restaurant");
		lblRestaurantText.setForeground(Color.WHITE);
		lblRestaurantText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRestaurantText.setBounds(350, 227, 100, 25);
		frame.getContentPane().add(lblRestaurantText);
		
		JLabel lblBanquet = new JLabel("");
		lblBanquet.setBounds(475, 131, 80, 62);
		frame.getContentPane().add(lblBanquet);
		Image imgBanquet = new ImageIcon(this.getClass().getResource("/banquet.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblBanquet.setIcon(new ImageIcon(imgBanquet));
		
		JLabel lblBanquetText = new JLabel("Banquet");
		lblBanquetText.setForeground(Color.WHITE);
		lblBanquetText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBanquetText.setBounds(485, 227, 80, 25);
		frame.getContentPane().add(lblBanquetText);
		frame.setBackground(UIManager.getColor("ComboBox.buttonDarkShadow"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
