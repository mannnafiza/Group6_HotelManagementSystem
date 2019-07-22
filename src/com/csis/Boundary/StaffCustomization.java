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
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class StaffCustomization {

	private JFrame frame;
	private JTable table;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtCity;
	JRadioButton rdbtnMale;
	JRadioButton rdbtnFemale;
	private ListSelectionListener listener;
	private DefaultTableModel tm = new DefaultTableModel();
	DBHelper helper = new DBHelper();
	private JTextField txtId;
	String option = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffCustomization window = new StaffCustomization();
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
	public StaffCustomization() {
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
				Staff staff= helper.getStaffMember(currId);
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
				
				//setGender(setGenderListener(rdbtnMale, rdbtnFemale));
				System.out.println("TO ADD GENDER: " + option);
				helper.createStaff(txtUsername.getText(), txtPassword.getText(), option , txtCity.getText());
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
				helper.deleteStaffMember(Integer.parseInt(txtId.getText()));
				updateStaffTable();
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
				stf.setPassword(txtPassword.getText());
				stf.setCity(txtCity.getText());
				stf.setGender(option);
				
				helper.updateStaff(stf);
				
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
		sf = helper.listStaff();
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
}
