package com.csis.Controller;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(201, 210, 218));
		frame.setBackground(UIManager.getColor("ComboBox.buttonDarkShadow"));
		frame.setBounds(100, 100, 642, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Color color = new Color(85, 96, 128);

		
		JLabel labelItem = new JLabel("Item:");
		labelItem.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelItem.setBounds(10, 58, 56, 14);
		labelItem.setForeground(color);
		frame.getContentPane().add(labelItem);
		
		JLabel labelUnitPrice = new JLabel("Unit Price:");
		labelUnitPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelUnitPrice.setBounds(10, 103, 72, 14);
		labelUnitPrice.setForeground(color);
		frame.getContentPane().add(labelUnitPrice);
		
		JLabel labelQuantity = new JLabel("Quantity:");
		labelQuantity.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelQuantity.setBounds(10, 154, 72, 14);
		labelQuantity.setForeground(color);
		frame.getContentPane().add(labelQuantity);
		
		JLabel labelAmount = new JLabel("Amount:");
		labelAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelAmount.setBounds(10, 200, 66, 14);
		labelAmount.setForeground(color);
		frame.getContentPane().add(labelAmount);
		
		textFieldItem = new JTextField();
		textFieldItem.setBounds(87, 56, 86, 20);
		frame.getContentPane().add(textFieldItem);
		textFieldItem.setColumns(10);
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
		
		
		textFieldUnitPrice = new JTextField();
		textFieldUnitPrice.setBounds(87, 101, 86, 20);
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
			
				char UnitPrice = e.getKeyChar();
				if(!Character.isDigit(UnitPrice) ||  UnitPrice == KeyEvent.VK_BACK_SPACE   || UnitPrice ==KeyEvent.VK_DELETE  ) {
					//getToolkit().beep();   
					e.consume();
				}
			}
			
		});
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(87, 152, 86, 20);
		frame.getContentPane().add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
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
				char Quantity = e.getKeyChar();
				if(!Character.isDigit(Quantity) ||  Quantity == KeyEvent.VK_BACK_SPACE   || Quantity ==KeyEvent.VK_DELETE  ) {
					//getToolkit().beep();   
					e.consume();
				}
			}
			
		});
		
		textFieldAmount = new JTextField();
		textFieldAmount.setText("");
		textFieldAmount.setBounds(87, 198, 86, 20);
		frame.getContentPane().add(textFieldAmount);
		textFieldAmount.setColumns(10);
		textFieldAmount.addKeyListener(new KeyListener() {

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
				char Amount = e.getKeyChar();
				if(!Character.isDigit(Amount) ||  Amount == KeyEvent.VK_BACK_SPACE   || Amount ==KeyEvent.VK_DELETE  ) {
					//getToolkit().beep();   
					e.consume();
				}
			}
			
		});
		
		JButton btnAddOrder = new JButton("Add Order");
		btnAddOrder.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddOrder.setForeground(color);
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
								JOptionPane jop = new JOptionPane();
								jop.showMessageDialog(null," Empty Fields .");
						}
							updateTable();
		     
               }//else { System.out.print("Please check input ");}
				
			
		});
		btnAddOrder.setBounds(90, 245, 89, 23);
		frame.getContentPane().add(btnAddOrder);
		
		JLabel lblMakeOrder = new JLabel("Make Order");
		lblMakeOrder.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lblMakeOrder.setBounds(261, 11, 191, 20);
		lblMakeOrder.setForeground(color);
		frame.getContentPane().add(lblMakeOrder);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(198, 58, 399, 313);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setForeground(color);
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
