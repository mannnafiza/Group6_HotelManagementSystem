package com.csis.Boundary;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

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
import java.awt.event.ActionEvent;

public class Home {

	private JFrame frame;
	private JTextField txtFieldName;
	private JPasswordField pswrdField;
	private String userName = "";
	private String password = "";

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
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBackground(UIManager.getColor("ComboBox.buttonDarkShadow"));
		frame.setBounds(100, 100, 525, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIcon = new JLabel();
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblIcon.setIcon(new ImageIcon(img));
		lblIcon.setBounds(220, 11, 80, 69);
		frame.getContentPane().add(lblIcon);
		
		JLabel lblTopic = new JLabel("Hotel Management System");
		lblTopic.setBounds(153, 79, 249, 25);
		frame.getContentPane().add(lblTopic);
		lblTopic.setFont(new Font("Serif", Font.ITALIC, 20));
		lblTopic.setForeground(Color.WHITE);
		
		JLabel lbluserIcon = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/usernameIcon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		lbluserIcon.setIcon(new ImageIcon(img));
		lbluserIcon.setBounds(101, 140, 29, 32);
		frame.getContentPane().add(lbluserIcon);
		
		JLabel lblpasswordIcon = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/passwordIcon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		lblpasswordIcon.setIcon(new ImageIcon(img));
		lblpasswordIcon.setBounds(101, 192, 29, 25);
		frame.getContentPane().add(lblpasswordIcon);
		
		Color color = new Color(51, 153, 102);
		
		txtFieldName = new JTextField();
		txtFieldName.setBounds(162, 140, 199, 25);
		frame.getContentPane().add(txtFieldName);
		txtFieldName.setColumns(10);
		//txtFieldName.setText("Kulbirk");
		txtFieldName.setFont(new Font("Serif",Font.PLAIN,16));		
		txtFieldName.setForeground(color);

		pswrdField = new JPasswordField();
		pswrdField.setBounds(162, 192, 199, 25);
		frame.getContentPane().add(pswrdField);
		//pswrdField.setText("Kul1irk");
		pswrdField.setFont(new Font("Serif",Font.PLAIN,14));		
		pswrdField.setForeground(color);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(162, 265, 80, 23);
		frame.getContentPane().add(btnLogin);
		//btnLogin.setBorder(new CustomBorder(8,2));
		//btnLogin.setBackground(new Color(255,255,255));
		btnLogin.setForeground(color);
	
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(281, 265, 80, 23);
		frame.getContentPane().add(btnCancel);
		//btnCancel.setBackground(new Color(105,205,105));
		btnCancel.setForeground(color);
		
		JLabel lblNewMember = new JLabel("New Member?");
		lblNewMember.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewMember.setBounds(162, 310, 108, 25);
		lblNewMember.setForeground(new Color(0,0,0));
		frame.getContentPane().add(lblNewMember);
		
		JLabel lblClickHereTo = new JLabel("Create an account");
		lblClickHereTo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClickHereTo.setBounds(261, 310, 129, 25);
		lblClickHereTo.setForeground(Color.white);
		//lblClickHereTo.setForeground(new Color(205,205,205));
		frame.getContentPane().add(lblClickHereTo);	
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAdmin.setBounds(435, 23, 64, 14);
		frame.getContentPane().add(lblAdmin);
		
		
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
				
			  //Create an instance of Validate class and pass all the inputs given by the user
			  Validate validate = new Validate(userName,password);
			  
			  if(validate.isLoginDataValid()) 
			  {
				  System.out.println("All inputs are valid."); 
				  
				  //create an instance of Authenticate class to verify userName and password inputs
				  Authenticate auth = new Authenticate();
					auth.setUsername(userName);
					auth.setPassword(password);
					
					if(auth.matchUserName() && auth.matchpassword())
					{
						System.out.println("Login Successful");
						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(null,"Login Successful");
						
						//set user information
						UserInfo user = new UserInfo();
						DBHelper helper = new DBHelper();
						user.setUsername(userName);
						user.setId(helper.getUserId(userName));
//						
						//reservation class to be called upon successful login 
						Reservation.main(null,user);
						frame.dispose();
						
					}else
					{
						System.out.println("Login Unsuccessful");
						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(null,"Wrong username or password.");
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
	
	
	
	
}
