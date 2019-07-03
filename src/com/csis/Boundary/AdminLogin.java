package com.csis.Boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminLogin {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
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
	public AdminLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 445, 328);
		frame.getContentPane().setLayout(null);
		
		JLabel lblImg = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/admin.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblImg.setIcon(new ImageIcon(img));
		lblImg.setBounds(180, 11, 67, 93);
		frame.getContentPane().add(lblImg);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(85, 126, 67, 21);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(85, 173, 67, 21);
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(180, 127, 130, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(180, 174, 130, 20);
		frame.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(169, 224, 89, 23);
		frame.getContentPane().add(btnLogin);
	}
}
