package com.csis.Controller;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.csis.Boundary.DBHelper;
import com.csis.Boundary.ManageInventory;
import com.csis.Entities.AddProperty;
import com.csis.Entities.UserInfo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.awt.event.ActionEvent;

public class PropertyInventoryDAO {

	private JFrame frame;
	
	private DefaultTableModel tm = new DefaultTableModel();
	private DBHelper sd = new DBHelper();
	private ListSelectionListener lsl ;
	boolean inputValid = true;
	String errorMsg;
	AddProperty AddPropertyData = new AddProperty(); 
	UserInfo user;
	
	private JTextField textFieldItem;
	private JTextField textFieldType;
	private JTextField textFieldQuantity;
	private JTextField textFieldPrice;
	private JTextField textFieldCategory;
	private JTextField textFieldUnitPrice;
	
	private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, UserInfo user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PropertyInventoryDAO window = new PropertyInventoryDAO(user);
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
	public PropertyInventoryDAO(UserInfo user) {
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
		
		JLabel lblAddNewProperty = new JLabel("Add New Property");
		lblAddNewProperty.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lblAddNewProperty.setBounds(245, 0, 288, 34);
		lblAddNewProperty.setForeground(color);
		frame.getContentPane().add(lblAddNewProperty);
		

		
		JLabel lblItem = new JLabel("Item:");
		lblItem.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblItem.setBounds(210, 56, 71, 25);
		lblItem.setForeground(color);
		frame.getContentPane().add(lblItem);
		
		JLabel labelType = new JLabel("Type:");
		labelType.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelType.setBounds(210, 107, 89, 29);
		labelType.setForeground(color);
		frame.getContentPane().add(labelType);
		
		JLabel labelQuantity = new JLabel("Quantity:");
		labelQuantity.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelQuantity.setBounds(210, 165, 102, 29);
		labelQuantity.setForeground(color);
		frame.getContentPane().add(labelQuantity);
		
		JLabel labelPrice = new JLabel("Price :");
		labelPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelPrice.setBounds(210, 227, 64, 20);
		labelPrice.setForeground(color);
		frame.getContentPane().add(labelPrice);
		
		textFieldItem = new JTextField();
		textFieldItem.setColumns(10);
		textFieldItem.setBounds(335, 60, 182, 20);
		textFieldItem.setForeground(color);
		frame.getContentPane().add(textFieldItem);
		textFieldItem.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
			
				char item = arg0.getKeyChar();
				if(!Character.isLetter(item) ||  item == KeyEvent.VK_BACK_SPACE   || item ==KeyEvent.VK_DELETE  ) {
					//getToolkit().beep();   
					arg0.consume();
				}
				
			}
			
			
		});
		
		textFieldType = new JTextField();
		textFieldType.setText("");
		textFieldType.setColumns(10);
		textFieldType.setBounds(335, 113, 182, 20);
		textFieldType.setForeground(color);
		frame.getContentPane().add(textFieldType);
		textFieldType.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				char item = e.getKeyChar();
				if(!Character.isLetter(item) ||  item == KeyEvent.VK_BACK_SPACE   || item ==KeyEvent.VK_DELETE  ) {
					//getToolkit().beep();   
					e.consume();
				}
			}
			
		});
		textFieldQuantity = new JTextField();
		textFieldQuantity.setText("");
		textFieldQuantity.setColumns(10);
		textFieldQuantity.setBounds(335, 171, 182, 20);
		textFieldQuantity.setForeground(color);
		frame.getContentPane().add(textFieldQuantity);
		textFieldQuantity.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				char item = e.getKeyChar();
				if(!Character.isDigit(item) ||  item == KeyEvent.VK_BACK_SPACE   || item ==KeyEvent.VK_DELETE  ) {
					//getToolkit().beep();   
					e.consume();
				}
			}
			
			
		});
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(335, 229, 182, 20);
		textFieldPrice.setForeground(color);
		frame.getContentPane().add(textFieldPrice);
		textFieldPrice.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				char item = e.getKeyChar();
				if(!Character.isDigit(item) ||  item == KeyEvent.VK_BACK_SPACE   || item ==KeyEvent.VK_DELETE  ) {
					//getToolkit().beep();   
					e.consume();
				}
			}
			
		});		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCategory.setBounds(210, 277, 102, 29);
		lblCategory.setForeground(color);
		frame.getContentPane().add(lblCategory);
		
		JLabel lblUnitPrice = new JLabel("Unit Price:");
		lblUnitPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUnitPrice.setForeground(color);
		lblUnitPrice.setBounds(210, 324, 115, 29);
		frame.getContentPane().add(lblUnitPrice);
		
		textFieldCategory = new JTextField();
		textFieldCategory.setBounds(335, 283, 182, 20);
		frame.getContentPane().add(textFieldCategory);
		textFieldCategory.setColumns(10);
		textFieldCategory.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				char item = e.getKeyChar();
				if(!Character.isLetter(item) ||  item == KeyEvent.VK_BACK_SPACE   || item ==KeyEvent.VK_DELETE  ) {
					//getToolkit().beep();   
					e.consume();
				}
			}
			
		});
		
		textFieldUnitPrice = new JTextField();
		textFieldUnitPrice.setBounds(335, 333, 182, 20);
		frame.getContentPane().add(textFieldUnitPrice);
		textFieldUnitPrice.setColumns(10);
		textFieldUnitPrice.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				char item = e.getKeyChar();
				if(!Character.isDigit(item) ||  item == KeyEvent.VK_BACK_SPACE   || item ==KeyEvent.VK_DELETE  ) {
					//getToolkit().beep();   
					e.consume();
				}
			}
			
		});
		
		JButton buttonAddProperty = new JButton("Add");
		buttonAddProperty.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonAddProperty.setForeground(color);
		buttonAddProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//textFieldItem, textFieldType,textFieldQuantity, textFieldPrice, textFieldCategory, textFieldUnitPrice
				//Build the new Student
				
				AddProperty ns = new AddProperty();
				
        validateProperty_info( AddPropertyData.getItem(),  AddPropertyData.getType(), AddPropertyData.getQuantity(),
	         	AddPropertyData.getPrice() ,AddPropertyData.getCategory() ,AddPropertyData.getUnitprice());
				//if(inputValid)
				{
					try {
				          ns.setItem(textFieldItem.getText());
			           	  ns.setType(textFieldType.getText());
				          ns.setQuantity(Integer.parseInt(textFieldQuantity.getText()));
				          ns.setPrice(Float.parseFloat(textFieldPrice.getText()));
				          ns.setCategory(textFieldCategory.getText());
				          ns.setUnitprice(Float.parseFloat(textFieldUnitPrice.getText()));
				          AddPropertyInv(ns);
				       ManageInventory.main(null, user);
				       frame.dispose();
					} catch(Exception ex) {
						System.out.println("Error in inserting " + ex.getMessage());
						JOptionPane.showMessageDialog(null," Please enter all empty Fields.");
				}
				}//else { System.out.print("Please check input ");}
			}
		});
		buttonAddProperty.setBounds(410, 393, 89, 23);
		frame.getContentPane().add(buttonAddProperty);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setForeground(color);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageInventory.main(null, user);
				frame.dispose();
			}
		});
		btnBack.setBounds(273, 393, 89, 23);
		frame.getContentPane().add(btnBack);
		
		
	}
	
	
	/**
	 * validate the user inputs
	 * @param date
	 * @param mealType
	 * @return
	 */
	protected boolean validateProperty_info(String Item, String Type, Integer Quantity,float Price , String Category , float Unitprice    ) {
		// TODO Auto-generated method stub
		errorMsg = "Please enter the following field: ";
		inputValid = true;
		if(Item == null) {
			errorMsg += "\nItem";
			inputValid = false;
		}
		if(Type == null) {
			errorMsg += "\nType";
			inputValid = false;
		}
		if(Quantity == null) {
			errorMsg += "\nQuantity";
			inputValid = false;
		}
		if(Price == 0) {
			errorMsg += "\nMeal Type";
			inputValid = false;
		}
		if(Category == null) {
			errorMsg += "\nCategory";
			inputValid = false;
		}
		if(Unitprice == 0) {
			errorMsg += "\nUnitprice";
			inputValid = false;
	 	}
		return inputValid;
	}
	
	
	/**
	 * 
	 * @param ap is the object of inventory items
	 * @return the count of inventory items
	 */
		public int AddPropertyInv(AddProperty ap)	{
			 int propertyInv = 0;		
			
			String sql = "Insert into propertyInventory_Info(Item  , Type  ,Quantity  ,Price , Category , Unitprice  )" 
					+ " VALUES ('" + ap.getItem() + "','" + ap.getType() + "','" + ap.getQuantity() 
					+ "','" + ap.getPrice() + "','" + ap.getCategory() + "','" + ap.getUnitprice() + "');";
			
			try { // itemId , Item , Type , Quantity , Price , Category , Unitprice
				//Connect to the database
				sd.connectDB();
				
				//Create the statement
				this.stmt = sd.getConnection().createStatement();
				
				//Execute the statement
				propertyInv = stmt.executeUpdate(sql , Statement.RETURN_GENERATED_KEYS);

				sd.disconnectDB();			
				
			} catch (SQLException sx) {
				System.out.println("Error Connecting to Database");
				System.out.println(sx.getMessage());
				System.out.println(sx.getErrorCode());
				System.out.println(sx.getSQLState());
				
			}
			System.out.println("Inserted new Property Inventory: " + propertyInv);
			return propertyInv;
			
		}
	
}
