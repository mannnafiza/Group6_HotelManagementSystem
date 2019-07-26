package com.csis.Boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

import com.csis.Controller.Authenticate;
import com.csis.Controller.Validate;
import com.csis.Entities.UserInfo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class AdminLogin {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	String username = "";
	String password = "";

	//fields for encryption
	private static final String key = "aesEncryptionKey";
	private static final String initVector = "encryptionIntVec";

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
		frame.getContentPane().setBackground(new Color(201, 210, 218));
		frame.setBounds(100, 100, 642, 464);
		frame.getContentPane().setLayout(null);
		
		Color color = new Color(85, 96, 128);
		
		JLabel lblImg = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/adminlogin.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblImg.setIcon(new ImageIcon(img));
		lblImg.setBounds(256, 11, 123, 146);
		frame.getContentPane().add(lblImg);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setForeground(color);
		lblUsername.setBounds(176, 221, 106, 21);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(color);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(176, 282, 89, 21);
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(313, 222, 130, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(313, 283, 130, 20);
		frame.getContentPane().add(txtPassword);
		
		/**
		 * Action Listener for Login button
		 */
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setForeground(color);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// get user inputs
				username = txtUsername.getText();
				password = new String(txtPassword.getPassword());
				
				//Create an instance of Validate class and pass all the inputs given by the user
				Validate validate = new Validate(username,password);
				
				if(validate.isLoginDataValid()) {
					System.out.println("Admin inputs are valid."); 
					
					//create an instance of Authenticate class to verify userName and password inputs
					Authenticate auth = new Authenticate();
					auth.setUsername(username);
					auth.setPassword(encrypt(password));
						
						if(auth.matchAdminUserName() && auth.matchAdminpassword())
						{
							System.out.println("Login Successful");
							JOptionPane.showMessageDialog(null," Admin Login Successful");
							
							//set user information
							UserInfo user = new UserInfo();
							DBHelper helper = new DBHelper();
							user.setUsername(username);
							user.setId(helper.getUserId(username));
							
							AdminHome.main(null, user);
							frame.dispose();
						}
				}
				  
			}
		});
		btnLogin.setBounds(256, 348, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.setForeground(color);
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblAdmin.setBounds(256, 159, 101, 23);
		frame.getContentPane().add(lblAdmin);
		
		JLabel lblUserLogin = new JLabel("");
		lblUserLogin.setBounds(10, 11, 80, 62);
		lblUserLogin.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Home.main(null);
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
		
		
		Image imgUser = new ImageIcon(this.getClass().getResource("/user.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblUserLogin.setIcon(new ImageIcon(imgUser));
		frame.getContentPane().add(lblUserLogin);
		
		JLabel lblUserLogin_1 = new JLabel("User Login");
		lblUserLogin_1.setForeground(color);
		lblUserLogin_1.setBounds(20, 71, 80, 14);
		frame.getContentPane().add(lblUserLogin_1);
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
			//return Base64.encodeBase64String(encrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
