package com.csis.Boundary;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class StaffCustomization {

	private JFrame frame;
	private JTable table;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtCity;

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
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("ADMIN");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Nirmala UI", Font.BOLD, 22));
		label.setBounds(262, 31, 110, 57);
		frame.getContentPane().add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 116, 624, 177);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.GRAY);
		scrollPane.setViewportView(table);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(27, 326, 73, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(27, 371, 73, 14);
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(148, 324, 128, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(148, 369, 128, 20);
		frame.getContentPane().add(txtPassword);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGender.setBounds(372, 327, 63, 14);
		frame.getContentPane().add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setForeground(Color.WHITE);
		rdbtnMale.setBackground(Color.BLACK);
		rdbtnMale.setBounds(450, 323, 63, 23);
		frame.getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(Color.BLACK);
		rdbtnFemale.setForeground(Color.WHITE);
		rdbtnFemale.setBounds(528, 323, 87, 23);
		frame.getContentPane().add(rdbtnFemale);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(Color.WHITE);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCity.setBounds(372, 372, 63, 14);
		frame.getContentPane().add(lblCity);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(450, 369, 128, 20);
		frame.getContentPane().add(txtCity);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setBounds(52, 422, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.setForeground(Color.WHITE);
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRemove.setBackground(Color.BLACK);
		btnRemove.setBounds(312, 422, 89, 23);
		frame.getContentPane().add(btnRemove);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setBounds(555, 422, 89, 23);
		frame.getContentPane().add(btnUpdate);
		frame.setBounds(100, 100, 686, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
