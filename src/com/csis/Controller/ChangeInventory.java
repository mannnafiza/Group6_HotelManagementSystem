package com.csis.Controller;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.csis.Boundary.DBHelper;
import com.csis.Boundary.ManageInventory;
import com.csis.Entities.AddProperty;
import com.csis.Entities.UserInfo;

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
	
	UserInfo user;

	/**     
	 * Launch the application.
	 */
	public static void main(String[] args, UserInfo user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeInventory window = new ChangeInventory(user);
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
	public ChangeInventory(UserInfo user) {
		this.user = user;
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
		frame.setBounds(100, 100, 872, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Color color = new Color(85, 96, 128);
		
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
		lblStock.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lblStock.setBounds(356, 11, 74, 26);
		lblStock.setForeground(color);
		frame.getContentPane().add(lblStock);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(162, 48, 664, 263);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnEditInventory = new JButton("Edit Inventory");
		btnEditInventory.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditInventory.setForeground(color);
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
								
				sd.updateInventory(us);
				
				updateTable();
				
			}
		});
		btnEditInventory.setBounds(10, 98, 128, 23);
		frame.getContentPane().add(btnEditInventory);
		
		JButton btnDeleteInventory = new JButton("Delete Inventory");
		btnDeleteInventory.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDeleteInventory.setForeground(color);
		btnDeleteInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sd.deleteInventory(Integer.parseInt(textFieldItemId.getText()));
				updateTable();
			}
		});
		btnDeleteInventory.setBounds(10, 144, 142, 23);
		frame.getContentPane().add(btnDeleteInventory);
		
		JLabel label = new JLabel("Item:");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(135, 363, 691, 14);
		label.setForeground(color);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Type:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(262, 363, 564, 14);
		label_1.setForeground(color);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Quantity:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(385, 363, 441, 14);
		label_2.setForeground(color);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Price :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(492, 365, 334, 11);
		label_3.setForeground(color);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Category:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(612, 363, 214, 14);
		label_4.setForeground(color);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Unit Price:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(754, 363, 72, 14);
		label_5.setForeground(color);
		frame.getContentPane().add(label_5);
		
		textFieldUnitPrice = new JTextField();
		textFieldUnitPrice.setColumns(10);
		textFieldUnitPrice.setBounds(752, 388, 94, 20);
		textFieldUnitPrice.setForeground(color);
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
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setForeground(color);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageInventory.main(null, user);
			}
		});
		btnBack.setBounds(10, 204, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JButton btnShowInventory = new JButton("Show Inventory");
		btnShowInventory.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnShowInventory.setForeground(color);
		btnShowInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable();

				
			}
		});
		btnShowInventory.setBounds(10, 48, 128, 23);
		frame.getContentPane().add(btnShowInventory);
		
		JLabel lblItemId = new JLabel("Item ID");
		lblItemId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblItemId.setBounds(38, 363, 788, 14);
		lblItemId.setForeground(color);
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
