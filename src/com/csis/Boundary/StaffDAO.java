package com.csis.Boundary;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.csis.Entities.Staff;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.awt.event.ActionEvent;

public class StaffDAO {

	private JFrame frame;
	private JTable table;
	private JTextField txtUsername;
	private JTextField txtPassword;
	
	private JTextField txtCity;
	JRadioButton rdbtnMale;
	JRadioButton rdbtnFemale;
	private ListSelectionListener listener;
	private DefaultTableModel tm = new DefaultTableModel();
	
	//for deccryption
		private static final String key = "aesEncryptionKey";
		private static final String initVector = "encryptionIntVec";
		private String encryptPass = "";
	
	DBHelper helper = new DBHelper();
	private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	
	private JTextField txtId;
	String option = "";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffDAO window = new StaffDAO();
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
	public StaffDAO() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(201, 210, 218));
		frame.getContentPane().setLayout(null);
		Color color = new Color(85, 96, 128);
		
		/**
		 * define listener for table
		 */
		listener = new ListSelectionListener() {
			
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int currId = (int) table.getValueAt(table.getSelectedRow(), 0);
				Staff staff= getStaffMember(currId);
				txtId.setText(String.valueOf(staff.getId()));
				txtUsername.setText(staff.getUsername());
				txtPassword.setText(staff.getPassword());
				txtCity.setText(staff.getCity());
				String gender = staff.getGender();
				
				if(gender == "male") {
					rdbtnMale.setSelected(true);
					rdbtnFemale.setSelected(false);
				} else {
					rdbtnMale.setSelected(false);
					rdbtnFemale.setSelected(true);
				}
				updateStaffTable();
			}
			
		};
		
		JLabel label = new JLabel("ADMIN");
		label.setForeground(color);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(340, 33, 110, 57);
		frame.getContentPane().add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 116, 624, 177);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setForeground(color);
		lblUsername.setBounds(25, 368, 73, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(color);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(25, 413, 73, 14);
		frame.getContentPane().add(lblPassword);
		
		txtId = new JTextField();
		txtId.setBounds(340, 320, 86, 20);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(146, 366, 128, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(146, 411, 128, 20);
		frame.getContentPane().add(txtPassword);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(color);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGender.setBounds(370, 369, 63, 14);
		frame.getContentPane().add(lblGender);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setForeground(color);
		rdbtnMale.setActionCommand("Male");
		rdbtnMale.setBackground(new Color(201, 210, 218));
		rdbtnMale.setBounds(448, 365, 63, 23);
		frame.getContentPane().add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(201, 210, 218));
		rdbtnFemale.setActionCommand("Female");
		rdbtnFemale.setForeground(color);
		rdbtnFemale.setBounds(526, 365, 87, 23);
		frame.getContentPane().add(rdbtnFemale);
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(rdbtnMale);
		genderGroup.add(rdbtnFemale);
		
		//set listener
		RadioListener listener = new RadioListener();
		rdbtnMale.addActionListener(listener);
		rdbtnMale.addChangeListener(listener);
		rdbtnMale.addItemListener(listener);
		rdbtnFemale.addActionListener(listener);
		rdbtnFemale.addChangeListener(listener);
		rdbtnFemale.addItemListener(listener);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(color);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCity.setBounds(370, 414, 63, 14);
		frame.getContentPane().add(lblCity);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(448, 411, 128, 20);
		frame.getContentPane().add(txtCity);
		
		updateStaffTable();
		
		/**
		 * Event listener for button "ADD"
		 */
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				encryptPass = encrypt(txtPassword.getText());
				//setGender(setGenderListener(rdbtnMale, rdbtnFemale));
				System.out.println("TO ADD GENDER: " + option);
				createStaff(txtUsername.getText(), encryptPass, option , txtCity.getText());
				insertNewUser(txtUsername.getText(), encryptPass, option, txtCity.getText());
				updateStaffTable();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setForeground(color);
		btnAdd.setBounds(57, 462, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		/**
		 * Event Listener for button "REMOVE"
		 */
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteStaffMember(Integer.parseInt(txtId.getText()));
				updateStaffTable();
				txtId.setText("");
				txtUsername.setText("");
				txtPassword.setText("");
				txtCity.setText("");
				rdbtnMale.setSelected(false);
				rdbtnFemale.setSelected(false);
			}
		});
		btnRemove.setForeground(color);
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRemove.setBounds(317, 462, 89, 23);
		frame.getContentPane().add(btnRemove);
		
		/**
		 * Event Listener for button "UPDATE"
		 */
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staff stf = new Staff();
				stf.setId(Integer.parseInt(txtId.getText()));
				stf.setUsername(txtUsername.getText());
				String updatePass = txtPassword.getText();
				stf.setPassword(updatePass);
				stf.setCity(txtCity.getText());
				stf.setGender(option);
				
				updateStaff(stf);
				
				updateStaffTable();
			}
		});
		btnUpdate.setForeground(color);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(560, 462, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(color);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(271, 321, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblAdminIcon = new JLabel("");
		lblAdminIcon.setBounds(220, 11, 123, 94);
		Image imgAdmin = new ImageIcon(this.getClass().getResource("/adminlogin.png")).getImage().getScaledInstance(80, 55, Image.SCALE_SMOOTH);
		lblAdminIcon.setIcon(new ImageIcon(imgAdmin));
		frame.getContentPane().add(lblAdminIcon);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin.main(null);
				frame.dispose();
			}
		});
		btnLogOut.setForeground(new Color(85, 96, 128));
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogOut.setBounds(560, 11, 89, 23);
		frame.getContentPane().add(btnLogOut);
		
		
		frame.setBounds(100, 100, 686, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * update the staff table
	 */
	private void updateStaffTable() {
		// TODO Auto-generated method stub
		table.getSelectionModel().removeListSelectionListener(listener);
		
		tm = new DefaultTableModel();
		tm.addColumn("ID");
		tm.addColumn("Username");
		tm.addColumn("Password");
		tm.addColumn("Gender");
		tm.addColumn("City");
		
		
		ArrayList<Staff> sf = new ArrayList<>();
		sf = listStaff();
		for(Staff staff : sf) {
			tm.addRow(staff.getVector());
		}
		
		table.setModel(tm);
		table.getSelectionModel().addListSelectionListener(listener);
		
		
	}
	
	
	
	/**
	 * listen to the change in radio button value for gender
	 * @author Mann
	 *
	 */
	
	class RadioListener implements ActionListener, ItemListener, ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			System.out.println("ChangeEvent received from: "
 		           + e.getSource());
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			System.out.println("ItemEvent received: " 
 		           + e.getItem()
 		           + " is now "
 		           + ((e.getStateChange() == ItemEvent.SELECTED)?
 			      "selected.":"unselected"));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String factoryName = null;

	        System.out.print("ActionEvent received: ");
	        if (e.getActionCommand() == "Male") {
	        	option = "Male";
	    	    System.out.println(option + " pressed.");
	        } else {
	        	option = "Female";
	    	    System.out.println(option + " pressed.");
	        }
		}
		
	}
	
	
	
	
	
	 /**
	   * create a new staff member
	   * @param username
	   * @param password
	   * @param gender
	   * @param city
	   */
	  public void createStaff(String username, String password, String gender, String city){
			
			String sql = "insert into staff_info (username, password, gender, city) values (?,?,?,?)";
			
			try {
				helper.connectDB();
				
				pstmt = helper.getConnection().prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				pstmt.setString(3, gender);
				pstmt.setString(4, city);
				
				pstmt.executeUpdate();
				helper.disconnectDB();
				
			} catch(SQLException sx) {
				System.out.println("Error in connecting database");
				System.out.println(sx.getMessage());
				System.out.println(sx.getErrorCode());
				System.out.println(sx.getSQLState());
			}
		}	  
	  /**
	   * 
	   * @return list of all staff members
	   */
	  public ArrayList<Staff> listStaff(){
			ArrayList<Staff> staffArr = new ArrayList<>();
			
			String sql = "Select * from staff_info";
			try {
				helper.connectDB();
				stmt = helper.getConnection().createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					Staff s = new Staff();
					s.setId(rs.getInt("id"));
					s.setUsername(rs.getString("username"));
					s.setPassword(rs.getString("password"));
					s.setGender(rs.getString("gender"));
					s.setCity(rs.getString("city"));
					staffArr.add(s);
				}
				helper.disconnectDB();
			} catch(SQLException sx) {
				System.out.println("Error in connecting database");
				System.out.println(sx.getMessage());
				System.out.println(sx.getErrorCode());
				System.out.println(sx.getSQLState());
			}
			
			return staffArr;
		}	  
	  /**
	   * 
	   * @param id
	   * @return a staff member
	   */
	  public Staff getStaffMember(int id) {
			Staff s = new Staff();
			
			String sql = "Select * from staff_info where id = ?";
			
			try {
				helper.connectDB();
				pstmt = helper.getConnection().prepareStatement(sql);
				pstmt.setInt(1,  id);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					s.setId(rs.getInt("id"));
					s.setUsername(rs.getString("username"));
					s.setPassword(rs.getString("password"));
					s.setGender(rs.getString("gender"));
					s.setCity(rs.getString("city"));
				}
				helper.disconnectDB();
			} catch(SQLException sx) {
				System.out.println("Error in connecting database");
				System.out.println(sx.getMessage());
				System.out.println(sx.getErrorCode());
				System.out.println(sx.getSQLState());
			}
			
			return s;
		}	  
	  /**
	   * delete a staff member
	   * @param id
	   */
	  public void deleteStaffMember(int id) {
			String sql = "delete from staff_Info where id = ?";
			try {
				helper.connectDB();
				
				pstmt =helper.getConnection().prepareStatement(sql);
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
				
				helper.disconnectDB();
			} catch(SQLException sx) {
				System.out.println("Error in connecting database");
				System.out.println(sx.getMessage());
				System.out.println(sx.getErrorCode());
				System.out.println(sx.getSQLState());
			}
		}	  
	  /**
	   * update a staff member information
	   * @param s
	   */
	  public void updateStaff(Staff s) {
			String sql = "update staff_Info set username = ?, password = ?, gender = ?, city = ? where id = ?";
					
			try {
				helper.connectDB();
				pstmt = helper.getConnection().prepareStatement(sql);
				pstmt.setString(1, s.getUsername());
				pstmt.setString(2, s.getPassword());
				pstmt.setString(3, s.getGender());
				pstmt.setString(4, s.getCity());
				pstmt.setInt(5, s.getId());
				
				pstmt.executeUpdate();
				helper.disconnectDB();
			} catch(SQLException sx) {
				System.out.println("Error in connecting database");
				System.out.println(sx.getMessage());
				System.out.println(sx.getErrorCode());
				System.out.println(sx.getSQLState());
			}
		}
	  
	  /**
		 * 
		 * @param usrname, name of the user
		 * @param pswd, password of user
		 * @param gendr, gender of user
		 * @param city, city of user
		 */
		  public void insertNewUser(String usrnm, String pswd, String gendr, String city)
		  { // TODO Auto-generated method stub

			  String insertSql = "INSERT INTO user_Info (userName,password,gender,city) " +
				  				"values (?,?,?,?)";
		  
			  try { 
				  helper.connectDB();
		  
				  // create statement
				  pstmt = helper.getConnection().prepareStatement(insertSql);
		  
				  // declare the parameter starting at 1 
				  pstmt.setString(1,usrnm);			
				  pstmt.setString(2, pswd);
				  pstmt.setString(3, gendr);
				  pstmt.setString(4, city);
					  
				  pstmt.executeUpdate();
		  
				  helper.disconnectDB(); 
			  } catch (SQLException sx)
			  {
				  System.out.println("Error inserting data into the database");
				  System.out.println(sx.getMessage()); 
				  System.out.println(sx.getErrorCode());
				  System.out.println(sx.getSQLState());
			  }
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
