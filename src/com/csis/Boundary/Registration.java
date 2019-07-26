package com.csis.Boundary;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

import com.csis.Controller.Authenticate;
import com.csis.Controller.RegistrationDAO;
import com.csis.Controller.Validate;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Base64;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Registration {

	public JFrame frame;
	public JTextField txtFieldName;
	public JPasswordField pswrdField;
	public JTextField txtFieldCity;
	public ButtonGroup btngrp = new ButtonGroup();
	public JRadioButton rdbtnMale;
	public JRadioButton rdbtnFemale;
	public JButton btnSignUp;
	public JButton btnCancel;
	private String userName = "";
	private String password = "";
	private String encryptedPassword = "";
	public String gender = "";
	private String city = "";
	public RegistrationDAO registrationDAO =  new RegistrationDAO();
	
	//for encryption
	private static final String key = "aesEncryptionKey";
	private static final String initVector = "encryptionIntVec";
	
	/**
	 * Launch the application
	 * @param args
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
		frame.getContentPane().setBackground(new Color(201, 210, 218));
		frame.setBackground(UIManager.getColor("ComboBox.buttonDarkShadow"));
		frame.setBounds(100, 100, 642, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Color color = new Color(85, 96, 128);
		
		JLabel lblIcon = new JLabel();
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblIcon.setIcon(new ImageIcon(img));
		lblIcon.setBounds(257, 6, 80, 69);
		frame.getContentPane().add(lblIcon);
		
		JLabel lblTopic = new JLabel("Hotel Management System");
		lblTopic.setBounds(175, 86, 249, 25);
		frame.getContentPane().add(lblTopic);
		lblTopic.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lblTopic.setForeground(color);
		
		JLabel lbluserIcon = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/usernameIcon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		lbluserIcon.setIcon(new ImageIcon(img));
		lbluserIcon.setBounds(101, 136, 29, 32);
		frame.getContentPane().add(lbluserIcon);
		
		JLabel lblpasswordIcon = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/passwordIcon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		lblpasswordIcon.setIcon(new ImageIcon(img));
		lblpasswordIcon.setBounds(101, 187, 42, 38);
		frame.getContentPane().add(lblpasswordIcon);
			
		txtFieldName = new JTextField();
		txtFieldName.setBounds(257, 145, 199, 25);
		frame.getContentPane().add(txtFieldName);
		txtFieldName.setColumns(10);
		txtFieldName.setFont(new Font("Serif",Font.PLAIN,16));		
		txtFieldName.setForeground(color);

		pswrdField = new JPasswordField();
		pswrdField.setBounds(257, 192, 199, 25);
		frame.getContentPane().add(pswrdField);
		pswrdField.setFont(new Font("Serif",Font.PLAIN,12));		
		pswrdField.setForeground(color);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSignUp.setBounds(222, 336, 80, 23);
		frame.getContentPane().add(btnSignUp);
		btnSignUp.setForeground(color);
			
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.setBounds(326, 336, 80, 23);
		frame.getContentPane().add(btnCancel);
		btnCancel.setForeground(color);
		
		JLabel lblExistingMember = new JLabel("Already a Member?");
		lblExistingMember.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExistingMember.setBounds(188, 389, 129, 25);
		lblExistingMember.setForeground(Color.DARK_GRAY);
		frame.getContentPane().add(lblExistingMember);
		
		JLabel lblClickHereTo = new JLabel("Click here to login");
		lblClickHereTo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClickHereTo.setBounds(327, 389, 129, 25);
		lblClickHereTo.setForeground(Color.DARK_GRAY);
		frame.getContentPane().add(lblClickHereTo);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(256, 238, 93, 23);
		frame.getContentPane().add(rdbtnMale);
		rdbtnMale.setBackground(new Color(201, 210, 218));
		rdbtnMale.setForeground(color);
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnMale.setSelected(true);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(201, 210, 218));
		rdbtnFemale.setForeground(color);
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnFemale.setBounds(351, 238, 105, 23);
		frame.getContentPane().add(rdbtnFemale);
		
		txtFieldCity = new JTextField();
		txtFieldCity.setForeground(color);
		txtFieldCity.setFont(new Font("Serif", Font.PLAIN, 16));
		txtFieldCity.setColumns(10);
		txtFieldCity.setBounds(257, 282, 199, 25);
		frame.getContentPane().add(txtFieldCity);
		
		JLabel lblGenderIcon = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/genderIcon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		lblGenderIcon.setIcon(new ImageIcon(img));
		lblGenderIcon.setBounds(101, 236, 29, 35);
		frame.getContentPane().add(lblGenderIcon);
		
		JLabel lblLocationIcon = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/locationIcon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		lblLocationIcon.setIcon(new ImageIcon(img));
		lblLocationIcon.setBounds(101, 279, 29, 38);
		frame.getContentPane().add(lblLocationIcon);
		
		btngrp.add(rdbtnMale);
		btngrp.add(rdbtnFemale);
		
		JLabel label = new JLabel("Username");
		label.setForeground(new Color(85, 96, 128));
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(146, 145, 101, 21);
		frame.getContentPane().add(label);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(85, 96, 128));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(146, 196, 101, 21);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(85, 96, 128));
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(149, 238, 101, 21);
		frame.getContentPane().add(lblGender);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(new Color(85, 96, 128));
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCity.setBounds(146, 285, 101, 21);
		frame.getContentPane().add(lblCity);
		
		/**
		 * button event listener
		 */
		btnSignUp.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				userName = txtFieldName.getText();
				password = new String(pswrdField.getPassword());
				encryptedPassword = encrypt(password);
				city = txtFieldCity.getText();
				if(rdbtnMale.isSelected())
					gender = "male";
				else if(rdbtnFemale.isSelected())
					gender = "Female";
				
				
				//Create an instance of Validate class and pass all the inputs given by the user
				Validate validate = new Validate(userName, password , gender, city);
				if(validate.isSignUpDataValid())
				{
					System.out.println("All the inputs are valid.");
					Authenticate auth = new Authenticate("Registration Task");
					auth.setUsername(userName);
					if(auth.matchUserName())
					{
						System.out.println("The username already exists, choose a different one.");
						JOptionPane.showMessageDialog(null,"The username already exists, choose a different one.");
					}else
					{
						//store the user inputs in the user_Info table
						registrationDAO.insertNewUser(userName, encryptedPassword, gender, city);
						ArrayList<String> newList = new ArrayList<>();
						newList = registrationDAO.getUserProfile(userName);
						
						//to see the profile of newly added user
						for(String str: newList)
						{
							System.out.println(str);
						}	
						Home.main(null);
						frame.dispose();
					}
				}
			}			
		});
		
		//ActionListener to reset all the input fields
				btnCancel.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						// TODO Auto-generated method stub
						txtFieldName.setText("");
						pswrdField.setText("");
						rdbtnMale.setSelected(true);
						txtFieldCity.setText("");
					}		
				});
		
		lblClickHereTo.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
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
				
				Home.main(null);
				frame.dispose();
			}
	
		});

	}
	
	
	
	/***
	 * 
	 * @param value is the original password in string format
	 * @return the encrypted hashed value of password as a string
	 */
	public static String encrypt(String value) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value.getBytes());
			return Base64.getEncoder().encodeToString(encrypted);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
