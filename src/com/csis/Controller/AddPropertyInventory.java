package com.csis.Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.csis.Boundary.DBHelper;
import com.csis.Boundary.ManageInventory;
import com.csis.Entities.AddProperty;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AddPropertyInventory {

	private JFrame frame;
	
	private DefaultTableModel tm = new DefaultTableModel();
	private DBHelper sd = new DBHelper();
	private ListSelectionListener lsl ;
	boolean inputValid = true;
	String errorMsg;
	AddProperty AddPropertyData = new AddProperty(); 
	
	private JTextField textFieldItem;
	private JTextField textFieldType;
	private JTextField textFieldQuantity;
	private JTextField textFieldPrice;
	private JTextField textFieldCategory;
	private JTextField textFieldUnitPrice;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPropertyInventory window = new AddPropertyInventory();
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
	public AddPropertyInventory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 870, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddNewProperty = new JLabel("Add New Property");
		lblAddNewProperty.setFont(new Font("Calibri", Font.BOLD, 13));
		lblAddNewProperty.setBounds(46, 11, 148, 49);
		frame.getContentPane().add(lblAddNewProperty);
		
		JPanel panelAddProperty = new JPanel();
		panelAddProperty.setBounds(129, 71, 330, 311);
		frame.getContentPane().add(panelAddProperty);
		panelAddProperty.setLayout(null);
		
		JLabel lblItem = new JLabel("Item:");
		lblItem.setBounds(30, 35, 46, 14);
		panelAddProperty.add(lblItem);
		
		JLabel labelType = new JLabel("Type:");
		labelType.setBounds(30, 63, 46, 14);
		panelAddProperty.add(labelType);
		
		JLabel labelQuantity = new JLabel("Quantity:");
		labelQuantity.setBounds(18, 88, 46, 14);
		panelAddProperty.add(labelQuantity);
		
		JLabel labelPrice = new JLabel("Price :");
		labelPrice.setBounds(30, 113, 46, 14);
		panelAddProperty.add(labelPrice);
		
		textFieldItem = new JTextField();
		textFieldItem.setColumns(10);
		textFieldItem.setBounds(83, 32, 182, 20);
		panelAddProperty.add(textFieldItem);
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
		textFieldType.setBounds(83, 60, 182, 20);
		panelAddProperty.add(textFieldType);
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
		textFieldQuantity.setBounds(83, 85, 182, 20);
		panelAddProperty.add(textFieldQuantity);
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
		textFieldPrice.setBounds(83, 110, 182, 20);
		panelAddProperty.add(textFieldPrice);
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
		lblCategory.setBounds(18, 144, 58, 14);
		panelAddProperty.add(lblCategory);
		
		JLabel lblUnitPrice = new JLabel("Unit Price:");
		lblUnitPrice.setBounds(18, 175, 58, 14);
		panelAddProperty.add(lblUnitPrice);
		
		textFieldCategory = new JTextField();
		textFieldCategory.setBounds(83, 141, 182, 20);
		panelAddProperty.add(textFieldCategory);
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
		textFieldUnitPrice.setBounds(83, 172, 182, 20);
		panelAddProperty.add(textFieldUnitPrice);
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
				          sd.AddPropertyInv(ns);
				       ManageInventory.main(null);
					} catch(Exception ex) {
						System.out.println("Error in inserting " + ex.getMessage());
						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(null," Please enter all empty Fields.");
				}
				}//else { System.out.print("Please check input ");}
			}
		});
		buttonAddProperty.setBounds(180, 235, 89, 23);
		panelAddProperty.add(buttonAddProperty);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageInventory.main(null);
			}
		});
		btnBack.setBounds(46, 393, 89, 23);
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
	
	
}
