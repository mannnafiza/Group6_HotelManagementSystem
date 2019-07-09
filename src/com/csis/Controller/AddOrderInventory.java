package com.csis.Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.csis.Boundary.DBHelper;
import com.csis.Boundary.ManageInventory;
import com.csis.Entities.AddProperty;
import com.csis.Entities.OrderNewInventory;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AddOrderInventory {

	private JFrame frame;
	private JTextField textFieldItem;
	private JTextField textFieldUnitPrice;
	private JTextField textFieldQuantity;
	private JTextField textFieldAmount;
	private JTable table;
	private DefaultTableModel tm = new DefaultTableModel();
	private DBHelper sd = new DBHelper();
	private ListSelectionListener lsl ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrderInventory window = new AddOrderInventory();
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
	public AddOrderInventory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 820, 398);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelItem = new JLabel("Item:");
		labelItem.setBounds(40, 59, 46, 14);
		frame.getContentPane().add(labelItem);
		
		JLabel labelUnitPrice = new JLabel("Unit Price:");
		labelUnitPrice.setBounds(21, 84, 72, 14);
		frame.getContentPane().add(labelUnitPrice);
		
		JLabel labelQuantity = new JLabel("Quantity:");
		labelQuantity.setBounds(31, 114, 46, 14);
		frame.getContentPane().add(labelQuantity);
		
		JLabel labelAmount = new JLabel("Amount:");
		labelAmount.setBounds(30, 139, 56, 14);
		frame.getContentPane().add(labelAmount);
		
		textFieldItem = new JTextField();
		textFieldItem.setBounds(87, 56, 86, 20);
		frame.getContentPane().add(textFieldItem);
		textFieldItem.setColumns(10);
		
		textFieldUnitPrice = new JTextField();
		textFieldUnitPrice.setBounds(87, 84, 86, 20);
		frame.getContentPane().add(textFieldUnitPrice);
		textFieldUnitPrice.setColumns(10);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(87, 111, 86, 20);
		frame.getContentPane().add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		textFieldAmount = new JTextField();
		textFieldAmount.setText("");
		textFieldAmount.setBounds(87, 136, 86, 20);
		frame.getContentPane().add(textFieldAmount);
		textFieldAmount.setColumns(10);
		
		JButton btnAddOrder = new JButton("Add Order");
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OrderNewInventory ns = new OrderNewInventory();
				
		     
							try {
						          ns.setItem(textFieldItem.getText());
						          ns.setQuantity(Integer.parseInt(textFieldQuantity.getText()));
						          ns.setUnitPrice(Float.parseFloat(textFieldUnitPrice.getText()));
						          ns.setAmount(Float.parseFloat(textFieldAmount.getText()));

						          sd.AddOrderInventory(ns);
						     //  ManageInventory.main(null);
							} catch(Exception ex) {
								System.out.println("Error in inserting " + ex.getMessage());
						}
							updateTable();
               }//else { System.out.print("Please check input ");}
				
			
		});
		btnAddOrder.setBounds(87, 173, 89, 23);
		frame.getContentPane().add(btnAddOrder);
		
		JLabel lblMakeOrder = new JLabel("Make Order");
		lblMakeOrder.setFont(new Font("Calibri Light", Font.BOLD, 14));
		lblMakeOrder.setBounds(188, 11, 96, 20);
		frame.getContentPane().add(lblMakeOrder);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(189, 42, 579, 240);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageInventory.main(null);
			}
		});
		btnBack.setBounds(21, 325, 89, 23);
		frame.getContentPane().add(btnBack);
		
		updateTable();
		
	}
	
	
private void updateTable()	{
		
		//Remove the List Selection Listern to the table
		table.getSelectionModel().removeListSelectionListener(lsl);
		
		tm = new DefaultTableModel();
		
		//textFieldItem, textFieldType, textFieldQuantity , textFieldPrice , textFieldCategory , textFieldUnitPrice

		//Add the columns
		//tm.addColumn("ID");
		tm.addColumn("Item");
		tm.addColumn("Quantity");
		tm.addColumn("UnitPrice");
		tm.addColumn("Amount");
		
				
		//Add the rows
		ArrayList<OrderNewInventory> sl = new ArrayList<OrderNewInventory>();
		
		//Populate the arraylist with the getShoes
		sl = sd.listAddOrderInventory();
		
		for (OrderNewInventory s : sl)	{
			tm.addRow(s.getVector());
		}
		
		table.setModel(tm);
		
		//Add the ListSelectionListener back to the table
		table.getSelectionModel().addListSelectionListener(lsl);
	}


}
