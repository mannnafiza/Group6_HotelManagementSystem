package com.csis.Boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.csis.Entities.AddProperty;
import com.csis.Entities.Reviews;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.List;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import javax.swing.JTable;

public class Review {

	private JFrame frame;
    private String review; 
    String line;
    DefaultListModel models ;
    DefaultTableModel model;
    private JTable table;
	private DefaultTableModel tm = new DefaultTableModel();
	private DBHelper sd = new DBHelper();
	private ListSelectionListener lsl ;
	private TextArea textAreaReview;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Review window = new Review();
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
	public Review() {
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 633, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		lsl = (new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				
				int currId = (int) table.getValueAt(table.getSelectedRow(),0);
				
				//Grab the corresponding shoe from the database
				Reviews ts = sd.getReviews(currId);
				
				//textFieldItem, textFieldType, textFieldQuantity , textFieldPrice , textFieldCategory , textFieldUnitPrice
				textAreaReview.setText((String.valueOf(ts.getId())));
				textAreaReview.setText(ts.getComment());
				

				
			}
			
		});
		
		
		
		JLabel lblWhatYouThink = new JLabel("What you think about our service:");
		lblWhatYouThink.setBounds(25, 11, 208, 50);
		frame.getContentPane().add(lblWhatYouThink);
		
		 textAreaReview = new TextArea();
		textAreaReview.setBounds(25, 67, 380, 113);
		frame.getContentPane().add(textAreaReview);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 247, 375, 131);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			review = textAreaReview.getText();
			String File_name = review;
			byte [] buff = File_name.getBytes();
			try {
				
			RandomAccessFile raf  = new RandomAccessFile("File_name.txt" , "rw");
			raf.write(buff);
			raf.seek(3);
				
			}catch(IOException ex){
					ex.printStackTrace();
			}
				
				
				
            Reviews rw = new Reviews();
				
				try {
			          rw.setComment(textAreaReview.getText());
		      
		           	  sd.AddReview(rw);
		           	  
		           	updateTable();
			      // ManageInventory.main(null);
				} catch(Exception ex) {
					System.out.println("Error in inserting " + ex.getMessage());
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(null," Please enter all empty Fields.");
			}
		}});
		btnSubmit.setBounds(43, 213, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnEditComment = new JButton("Delete Comment");
		btnEditComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
			    Reviews us = new Reviews();
						
			  //  us.setId(Integer.parseInt(textAreaReview.getText()));
				us.setComment(textAreaReview.getText());
				
				String uss = us.toString();
				sd.updateReview(uss);
				
				updateTable();
				*/
				
				sd.deleteReview(textAreaReview.getText());
		
				updateTable();
				
				
			}
		});
		btnEditComment.setBounds(245, 213, 138, 23);
		frame.getContentPane().add(btnEditComment);
		
		updateTable();
		
	}
	
private void updateTable()	{
		
		//Remove the List Selection Listern to the table
		table.getSelectionModel().removeListSelectionListener(lsl);
		
		tm = new DefaultTableModel();
		
		//textFieldItem, textFieldType, textFieldQuantity , textFieldPrice , textFieldCategory , textFieldUnitPrice

		//Add the columns
		tm.addColumn("ID");
		tm.addColumn("Comments");
		
		
				
		//Add the rows
		ArrayList<Reviews> sl = new ArrayList<Reviews>();
		
		//Populate the arraylist with the getShoes
		sl = sd.listReview();
		//Reviews r = new Reviews();
		
		for (Reviews r : sl)	{
			tm.addRow(r.getVector());
		}
		
		table.setModel(tm);
		
		//Add the ListSelectionListener back to the table
		table.getSelectionModel().addListSelectionListener(lsl);
	}
}
