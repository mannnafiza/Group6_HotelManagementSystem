package com.csis.Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.csis.Boundary.DBHelper;
import com.csis.Boundary.ManageInventory;
import com.csis.Entities.AddProperty;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ChangeInventory {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel tm = new DefaultTableModel();
	private DBHelper sd = new DBHelper();
	private ListSelectionListener lsl ;
	private JTextField textFieldUnitPrice;
	private JTextField textFieldCategory;
	private JTextField textFieldPrice;
	private JTextField textFieldQuantity;
	private JTextField textFieldType;
	private JTextField textFieldItem;
	private JTextField textFieldItemId;

	/**     
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeInventory window = new ChangeInventory();
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
	public ChangeInventory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 872, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//create the custom selection listener to add to the table
				lsl = new ListSelectionListener()	{
					public void valueChanged(ListSelectionEvent arg0)	{
						
						//get the value of the selected row's id (column 0)
						int currId = (int) table.getValueAt(table.getSelectedRow(),0);
						
						//Grab the corresponding shoe from the database
						AddProperty ts = sd.getProperty(currId);
						
						//textFieldItem, textFieldType, textFieldQuantity , textFieldPrice , textFieldCategory , textFieldUnitPrice
						textFieldItemId.setText((String.valueOf(ts.getItemId())));
						textFieldItem.setText(ts.getItem());
						textFieldType.setText(ts.getType());
						textFieldQuantity.setText((String.valueOf(ts.getQuantity())));
						textFieldPrice.setText(String.valueOf(ts.getPrice())); 
						textFieldCategory.setText((ts.getCategory()));
						textFieldUnitPrice.setText(String.valueOf(ts.getUnitprice())); 
					}
				};

		
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Calibri Light", Font.BOLD, 13));
		lblStock.setBounds(162, 11, 74, 26);
		frame.getContentPane().add(lblStock);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(162, 48, 664, 263);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnEditInventory = new JButton("Edit Inventory");
		btnEditInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                AddProperty us = new AddProperty();
                us.setItemId(Integer.parseInt(textFieldItemId.getText()));
				us.setItem((textFieldItem.getText()));
				us.setType(textFieldType.getText());
				us.setQuantity(Integer.parseInt(textFieldQuantity.getText()));
				us.setPrice(Float.parseFloat(textFieldPrice.getText()));
				us.setCategory(textFieldCategory.getText());
				us.setUnitprice(Float.parseFloat(textFieldUnitPrice.getText()));
								
				sd.updateGame(us);
				
				updateTable();
				
			}
		});
		btnEditInventory.setBounds(10, 98, 128, 23);
		frame.getContentPane().add(btnEditInventory);
		
		JButton btnDeleteInventory = new JButton("Delete Inventory");
		btnDeleteInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sd.deleteInventory(Integer.parseInt(textFieldItemId.getText()));
				updateTable();
			}
		});
		btnDeleteInventory.setBounds(10, 144, 128, 23);
		frame.getContentPane().add(btnDeleteInventory);
		
		JLabel label = new JLabel("Item:");
		label.setBounds(135, 363, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Type:");
		label_1.setBounds(262, 363, 46, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Quantity:");
		label_2.setBounds(385, 363, 46, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Price :");
		label_3.setBounds(492, 365, 58, 11);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Category:");
		label_4.setBounds(612, 363, 58, 14);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Unit Price:");
		label_5.setBounds(754, 363, 58, 14);
		frame.getContentPane().add(label_5);
		
		textFieldUnitPrice = new JTextField();
		textFieldUnitPrice.setColumns(10);
		textFieldUnitPrice.setBounds(752, 388, 94, 20);
		frame.getContentPane().add(textFieldUnitPrice);
		
		textFieldCategory = new JTextField();
		textFieldCategory.setColumns(10);
		textFieldCategory.setBounds(614, 388, 128, 20);
		frame.getContentPane().add(textFieldCategory);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(490, 388, 114, 20);
		frame.getContentPane().add(textFieldPrice);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setText("");
		textFieldQuantity.setColumns(10);
		textFieldQuantity.setBounds(386, 388, 94, 20);
		frame.getContentPane().add(textFieldQuantity);
		
		textFieldType = new JTextField();
		textFieldType.setText("");
		textFieldType.setColumns(10);
		textFieldType.setBounds(262, 388, 114, 20);
		frame.getContentPane().add(textFieldType);
		
		textFieldItem = new JTextField();
		textFieldItem.setColumns(10);
		textFieldItem.setBounds(135, 388, 115, 20);
		frame.getContentPane().add(textFieldItem);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageInventory.main(null);
			}
		});
		btnBack.setBounds(10, 204, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JButton btnShowInventory = new JButton("Show Inventory");
		btnShowInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable();

				
			}
		});
		btnShowInventory.setBounds(10, 48, 128, 23);
		frame.getContentPane().add(btnShowInventory);
		
		JLabel lblItemId = new JLabel("Item ID");
		lblItemId.setBounds(38, 363, 46, 14);
		frame.getContentPane().add(lblItemId);
		
		textFieldItemId = new JTextField();
		textFieldItemId.setBounds(38, 388, 86, 20);
		frame.getContentPane().add(textFieldItemId);
		textFieldItemId.setColumns(10);
		
		//updateTable();
	}
	
	
private void updateTable()	{
		
		//Remove the List Selection Listern to the table
		table.getSelectionModel().removeListSelectionListener(lsl);
		
		tm = new DefaultTableModel();
		
		//textFieldItem, textFieldType, textFieldQuantity , textFieldPrice , textFieldCategory , textFieldUnitPrice

		//Add the columns
		tm.addColumn("ID");
		tm.addColumn("Item");
		tm.addColumn("Type");
		tm.addColumn("Quantity");
		tm.addColumn("Price");
		tm.addColumn("Category");
		tm.addColumn("UnitPrice");
		
				
		//Add the rows
		ArrayList<AddProperty> sl = new ArrayList<AddProperty>();
		
		//Populate the arraylist with the getShoes
		sl = sd.listAddPropertyInventory();
		
		for (AddProperty s : sl)	{
			tm.addRow(s.getVector());
		}
		
		table.setModel(tm);
		
		//Add the ListSelectionListener back to the table
		table.getSelectionModel().addListSelectionListener(lsl);
	}

}