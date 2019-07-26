package com.csis.Boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.csis.Controller.OrderInventoryDAO;
import com.csis.Controller.PropertyInventoryDAO;
import com.csis.Controller.ChangeInventoryDAO;
import com.csis.Entities.AddProperty;
import com.csis.Entities.Staff;
import com.csis.Entities.UserInfo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;

public class ManageInventory {

	private JFrame frame;
	private DefaultTableModel tm = new DefaultTableModel();
	private DBHelper sd = new DBHelper();
	private ListSelectionListener listener ;
	UserInfo user;
	private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args, UserInfo user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageInventory window = new ManageInventory(user);
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
	public ManageInventory(UserInfo user) {
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
		frame.setBounds(100, 100, 642, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Color color = new Color(85, 96, 128);
		
		
		/**
		 * define listener for table
		 */
		listener = new ListSelectionListener() {
			
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				updateTable();
			}
			
		};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(178, 29, 438, 328);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JButton btnAddInventory = new JButton("Add Inventory");
		btnAddInventory.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddInventory.setForeground(color);
		btnAddInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//panel.setVisible(true);
				PropertyInventoryDAO.main(null, user);
				frame.dispose();
			}
		});
		btnAddInventory.setBounds(22, 49, 130, 23);
		frame.getContentPane().add(btnAddInventory);
		
		JButton btnNewOrder = new JButton("New Order");
		btnNewOrder.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewOrder.setForeground(color);
		btnNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//table.setVisible(true);
				OrderInventoryDAO.main(null, user);
				frame.dispose();
				
			}
		});
		btnNewOrder.setBounds(22, 156, 130, 23);
		frame.getContentPane().add(btnNewOrder);
		
		JButton btnChangeInventory = new JButton("Change Inventory");
		btnChangeInventory.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnChangeInventory.setForeground(color);
		btnChangeInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ChangeInventoryDAO.main(null, user);
				frame.dispose();
			}
		});
		btnChangeInventory.setBounds(10, 99, 158, 23);
		frame.getContentPane().add(btnChangeInventory);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminHome.main(null, user);
				frame.dispose();
			}
		});
		btnBack.setForeground(new Color(85, 96, 128));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(22, 339, 130, 23);
		frame.getContentPane().add(btnBack);
		
		
		
		updateTable();
	}
	
	
	
private void updateTable()	{
	 	table.getSelectionModel().removeListSelectionListener(listener);
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
		sl = listAddPropertyInventory();
		
		for (AddProperty s : sl)	{
			tm.addRow(s.getVector());
		}
		
		table.setModel(tm);
		table.getSelectionModel().addListSelectionListener(listener);
	}


//method to add inventory 
		public ArrayList<AddProperty> listAddPropertyInventory() 
		{
			ArrayList<AddProperty> s1 = new ArrayList<AddProperty>();

			String sql = "SELECT * FROM propertyInventory_Info order by propertyInventory_Info.itemId";
			try {
				// connect to the database
				sd.connectDB();
				stmt = sd.getConnection().createStatement();
				rs = stmt.executeQuery(sql);

				while (rs.next())
				{      //itemId, Item , Type , Quantity , Price , Category , Unitprice
					 
	                AddProperty s = new AddProperty();
					
					//Get the right type (string) from the right column ("itemId");
					s.setItemId((rs.getInt("itemId")));
					s.setItem((rs.getString("Item")));
					s.setType((rs.getString("Type")));
					s.setQuantity((rs.getInt("Quantity")));
					s.setPrice((rs.getFloat("Price")));
					s.setCategory((rs.getString("Category")));
					s.setUnitprice((rs.getFloat("Unitprice")));
		
					s1.add(s);
					 // System.out.println(s1);
				}

				sd.disconnectDB();
			} catch (SQLException sx) {
				System.out.println("Error fetching data from the database");
				System.out.println(sx.getMessage());
				System.out.println(sx.getErrorCode());
				System.out.println(sx.getSQLState());
			}

			return s1;
		}
}
