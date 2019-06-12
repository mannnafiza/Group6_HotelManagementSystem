package com.csis.Boundary;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Canvas;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Registration {

	private JFrame frame;
	private JTextField txtFieldName;
	private JPasswordField pswrdField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
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
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBackground(UIManager.getColor("ComboBox.buttonDarkShadow"));
		frame.setBounds(100, 100, 525, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIcon = new JLabel();
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblIcon.setIcon(new ImageIcon(img));
		lblIcon.setBounds(220, -1, 80, 69);
		frame.getContentPane().add(lblIcon);
		
		JLabel lblTopic = new JLabel("Hotel Management System");
		lblTopic.setBounds(162, 59, 249, 25);
		frame.getContentPane().add(lblTopic);
		lblTopic.setFont(new Font("Serif", Font.ITALIC, 20));
		lblTopic.setForeground(Color.WHITE);
		
		JLabel lbluserIcon = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/usernameIcon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		lbluserIcon.setIcon(new ImageIcon(img));
		lbluserIcon.setBounds(101, 113, 29, 32);
		frame.getContentPane().add(lbluserIcon);
		
		JLabel lblpasswordIcon = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/passwordIcon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		lblpasswordIcon.setIcon(new ImageIcon(img));
		lblpasswordIcon.setBounds(101, 156, 29, 25);
		frame.getContentPane().add(lblpasswordIcon);
		
		Color color = new Color(51, 153, 102);
		
		txtFieldName = new JTextField();
		txtFieldName.setBounds(162, 113, 199, 25);
		frame.getContentPane().add(txtFieldName);
		txtFieldName.setColumns(10);
		txtFieldName.setText("Kulbirk");
		txtFieldName.setFont(new Font("Serif",Font.PLAIN,16));		
		txtFieldName.setForeground(color);

		pswrdField = new JPasswordField();
		pswrdField.setBounds(162, 156, 199, 25);
		frame.getContentPane().add(pswrdField);
		pswrdField.setText("Kulbirk");
		pswrdField.setFont(new Font("Serif",Font.PLAIN,12));		
		pswrdField.setForeground(color);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(162, 277, 80, 23);
		frame.getContentPane().add(btnSignUp);
		//btnLogin.setBorder(new CustomBorder(8,2));
		//btnLogin.setBackground(new Color(255,255,255));
		btnSignUp.setForeground(color);
	
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(281, 277, 80, 23);
		frame.getContentPane().add(btnCancel);
		//btnCancel.setBackground(new Color(105,205,105));
		btnCancel.setForeground(color);
		
		JLabel lblExistingMember = new JLabel("Already a Member?");
		lblExistingMember.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExistingMember.setBounds(141, 310, 129, 25);
		lblExistingMember.setForeground(new Color(0,0,0));
		frame.getContentPane().add(lblExistingMember);
		
		JLabel lblClickHereTo = new JLabel("Click here to login");
		lblClickHereTo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClickHereTo.setBounds(271, 310, 129, 25);
		lblClickHereTo.setForeground(Color.white);
		//lblClickHereTo.setForeground(new Color(205,205,205));
		frame.getContentPane().add(lblClickHereTo);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(new Color(95, 158, 160));
		rdbtnMale.setForeground(Color.WHITE);
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnMale.setBounds(161, 194, 93, 23);
		frame.getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(95, 158, 160));
		rdbtnFemale.setForeground(Color.WHITE);
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnFemale.setBounds(256, 194, 105, 23);
		frame.getContentPane().add(rdbtnFemale);
		
		textField = new JTextField();
		textField.setText("Kulbirk");
		textField.setForeground(new Color(51, 153, 102));
		textField.setFont(new Font("Serif", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(162, 235, 199, 25);
		frame.getContentPane().add(textField);
		
		JLabel lblGenderIcon = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/genderIcon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		lblGenderIcon.setIcon(new ImageIcon(img));
		lblGenderIcon.setBounds(101, 192, 29, 25);
		frame.getContentPane().add(lblGenderIcon);
		
		JLabel lblLocationIcon = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/locationIcon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		lblLocationIcon.setIcon(new ImageIcon(img));
		lblLocationIcon.setBounds(101, 235, 29, 25);
		frame.getContentPane().add(lblLocationIcon);
		
		
		
	}
}
