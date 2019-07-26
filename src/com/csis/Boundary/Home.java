package com.csis.Boundary;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

import com.csis.Controller.Authenticate;
import com.csis.Controller.Validate;
import com.csis.Entities.UserInfo;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Base64;
import java.awt.event.ActionEvent;

public class Home {

	public JFrame frame;
	public JTextField txtFieldName;
	public JPasswordField pswrdField;
	private String userName = "";
	private String password = "";
	private String encryptedPassword = "";
	public JButton btnLogin;
	public String msg = "";
	
	//for decryption
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
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
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
		lblIcon.setBounds(308, 16, 117, 105);
		frame.getContentPane().add(lblIcon);
		
		JLabel lblTopic = new JLabel("Hotel Management System");
		lblTopic.setBounds(233, 132, 249, 25);
		frame.getContentPane().add(lblTopic);
		lblTopic.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lblTopic.setForeground(color);
		
		
		
		JLabel lbluserIcon = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/usernameicon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		lbluserIcon.setIcon(new ImageIcon(img));
		lbluserIcon.setBounds(166, 182, 29, 32);
		frame.getContentPane().add(lbluserIcon);
		
		JLabel lblpasswordIcon = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/passwordicon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		lblpasswordIcon.setIcon(new ImageIcon(img));
		lblpasswordIcon.setBounds(166, 235, 36, 46);
		frame.getContentPane().add(lblpasswordIcon);
		img = new ImageIcon(this.getClass().getResource("/icon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		
		JLabel lblAdminIcon = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/adminlogin.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		lblAdminIcon.setIcon(new ImageIcon(img));
		lblAdminIcon.setBounds(10, 16, 42, 52);
		frame.getContentPane().add(lblAdminIcon);
		
		txtFieldName = new JTextField();
		txtFieldName.setBounds(320, 189, 199, 25);
		frame.getContentPane().add(txtFieldName);
		txtFieldName.setColumns(10);
		txtFieldName.setFont(new Font("Serif",Font.PLAIN,16));		
		txtFieldName.setForeground(color);

		pswrdField = new JPasswordField();
		pswrdField.setBounds(320, 246, 199, 25);
		frame.getContentPane().add(pswrdField);
		pswrdField.setFont(new Font("Serif",Font.PLAIN,14));		
		pswrdField.setForeground(color);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setBounds(236, 326, 80, 23);
		frame.getContentPane().add(btnLogin);
		btnLogin.setForeground(color);
	
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.setBounds(362, 326, 80, 23);
		frame.getContentPane().add(btnCancel);
		btnCancel.setForeground(color);
		
		JLabel lblNewMember = new JLabel("New Member?");
		lblNewMember.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewMember.setBounds(223, 374, 108, 25);
		lblNewMember.setForeground(Color.DARK_GRAY);
		frame.getContentPane().add(lblNewMember);
		
		JLabel lblClickHereTo = new JLabel("Create an account");
		lblClickHereTo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClickHereTo.setBounds(327, 374, 129, 25);
		lblClickHereTo.setForeground(Color.DARK_GRAY);
		//lblClickHereTo.setForeground(new Color(205,205,205));
		frame.getContentPane().add(lblClickHereTo);	
		
		JLabel lblAdmin = new JLabel("Admin Login");
		lblAdmin.setForeground(color);
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdmin.setBounds(47, 36, 91, 14);
		frame.getContentPane().add(lblAdmin);
		
		JLabel lblUName = new JLabel("Username");
		lblUName.setForeground(color);
		lblUName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUName.setBounds(205, 192, 101, 21);
		frame.getContentPane().add(lblUName);
		
		JLabel lblPswd = new JLabel("Password");
		lblPswd.setForeground(color);
		lblPswd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPswd.setBounds(205, 246, 101, 25);
		frame.getContentPane().add(lblPswd);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setBounds(523, 197, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setBounds(523, 253, 46, 14);
		frame.getContentPane().add(label_1);
		
				
		lblAdminIcon.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				AdminLogin.main(null);
				frame.dispose();
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
		
		
		lblAdmin.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				AdminLogin.main(null);
				frame.dispose();
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
		
		//ActionListener to process all the input values given by the user
		btnLogin.addActionListener(new ActionListener()
		{		  
		  @Override public void actionPerformed(ActionEvent e)
		  { 
			  // TODO Auto-generated  method stub
			  userName = txtFieldName.getText();
			  password = new String(pswrdField.getPassword());
			  encryptedPassword = encrypt(password);
			  
				
			  //Create an instance of Validate class and pass all the inputs given by the user
			  Validate validate = new Validate(userName,password);
			  
			  if(validate.isLoginDataValid()) 
			  {
				  System.out.println("All inputs are valid."); 
				  
				  //create an instance of Authenticate class to verify userName and password inputs
				  Authenticate auth = new Authenticate("Login Task");
					auth.setUsername(userName);
					auth.setPassword(encryptedPassword);

					if(auth.matchUserName() && auth.matchpassword())
					{
						System.out.println("Login Successful");
						JOptionPane.showMessageDialog(null,"Login Successful");
						msg = "Login Successful";
						
						//set user information
						UserInfo user = new UserInfo();
						DBHelper helper = new DBHelper();
						user.setUsername(userName);
						user.setId(helper.getUserId(userName));
					
						//reservation class to be called upon successful login 
						Reservation.main(null,user);
						frame.dispose();
						
					}else
					{
						System.out.println("Login Unsuccessful");
						JOptionPane.showMessageDialog(null,"Wrong username or password.");
						msg = "Wrong username or password.";
					}
						
			  } else
				  msg = validate.errorMsg;
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
			}		
		});
		
		//Switch the screen to Registration, if the user is new to the hotel's website
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
						
						Registration.main(null);
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
			//return Base64.encodeBase64String(encrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param encrypted is the encrypted password
	 * @return the decrypted password
	 */
	public static String decrypt(String encrypted) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));//Base64.decode(encrypted));

			return new String(original);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
}
