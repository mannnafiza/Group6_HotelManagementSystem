package com.csis.Boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.csis.Controller.AddOrderInventory;
import com.csis.Controller.AddPropertyInventory;
import com.csis.Controller.ChangeInventory;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ManageInventory {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageInventory window = new ManageInventory();
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
	public ManageInventory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 644, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddInventory = new JButton("Add Inventory");
		btnAddInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//panel.setVisible(true);
				AddPropertyInventory.main(null);
			}
		});
		btnAddInventory.setBounds(22, 49, 130, 23);
		frame.getContentPane().add(btnAddInventory);
		
		JButton btnNewOrder = new JButton("New Order");
		btnNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//table.setVisible(true);
				AddOrderInventory.main(null);
				
			}
		});
		btnNewOrder.setBounds(22, 156, 130, 23);
		frame.getContentPane().add(btnNewOrder);
		
		JButton btnChangeInventory = new JButton("Change Inventory");
		btnChangeInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ChangeInventory.main(null);
			}
		});
		btnChangeInventory.setBounds(22, 99, 130, 23);
		frame.getContentPane().add(btnChangeInventory);
		
		table = new JTable();
		table.setBounds(260, 49, 332, 248);
		frame.getContentPane().add(table);
		
		
	}
}
