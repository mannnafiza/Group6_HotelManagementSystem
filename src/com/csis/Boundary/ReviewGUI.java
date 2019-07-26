package com.csis.Boundary;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.csis.Entities.AddProperty;
import com.csis.Entities.Review;

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
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import java.awt.Font;


public class ReviewGUI {

	private JFrame frame;
    private String review; 
    String line;
    DefaultListModel models ;
    DefaultTableModel model;
    private JTable table;
	private DefaultTableModel tm = new DefaultTableModel();
	private ListSelectionListener lsl ;
	private TextArea textAreaReview;
	
	DBHelper helper = new DBHelper();
	private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	
	ArrayList<String> reviewList = new ArrayList<>();;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReviewGUI window = new ReviewGUI();
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
	public ReviewGUI() {
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(201, 210, 218));
		frame.setBounds(100, 100, 642, 464);
		frame.getContentPane().setLayout(null);
		
		Color color = new Color(85, 96, 128);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * define the listener
		 */
		lsl = (new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				
				int currId = (int) table.getValueAt(table.getSelectedRow(),0);
				
				//Grab the corresponding shoe from the database
				Review ts = getReviews(currId);
				
				//textFieldItem, textFieldType, textFieldQuantity , textFieldPrice , textFieldCategory , textFieldUnitPrice
				textAreaReview.setText((String.valueOf(ts.getId())));
				textAreaReview.setText(ts.getComment());
						
			}
			
		});
		
		
		
		JLabel lblWhatYouThink = new JLabel("What you think about our service:");
		lblWhatYouThink.setBounds(25, 58, 208, 50);
		lblWhatYouThink.setForeground(color);
		frame.getContentPane().add(lblWhatYouThink);
		
		 textAreaReview = new TextArea();
		textAreaReview.setBounds(25, 114, 380, 113);
		frame.getContentPane().add(textAreaReview);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 283, 568, 131);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(color);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//insert into review table		
				Review rw = new Review();
				
				try {
			          rw.setComment(textAreaReview.getText());
		           	  AddReview(rw);
		           	  updateTable();
				} catch(Exception ex) {
					System.out.println("Error in inserting " + ex.getMessage());
					JOptionPane.showMessageDialog(null," Please enter all empty Fields.");
			}
		}});
		btnSubmit.setBounds(411, 114, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblReview = new JLabel("Review");
		lblReview.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lblReview.setBounds(289, 11, 116, 50);
		lblReview.setForeground(color);
		frame.getContentPane().add(lblReview);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.main(null);
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogOut.setForeground(new Color(85, 96, 128));
		btnLogOut.setBounds(527, 11, 89, 23);
		frame.getContentPane().add(btnLogOut);
		
		updateTable();
		
	}
	
	private void updateTable()	{
		
		//Remove the List Selection Listern to the table
		table.getSelectionModel().removeListSelectionListener(lsl);
		tm = new DefaultTableModel();
		
		
		//Add the columns
		tm.addColumn("ID");
		tm.addColumn("Comments");
		
		//Add the rows
		ArrayList<Review> sl = new ArrayList<Review>();
		
		//Populate the arraylist with the getShoes
		sl = listReview();
		
		for (Review r : sl)	{
			tm.addRow(r.getVector());
		}
		
		table.setModel(tm);
		
		//Add the ListSelectionListener back to the table
		table.getSelectionModel().addListSelectionListener(lsl);
		
		//writeTo Review File
		reviewList = getReviewList();
		writeToFile("Reviews_Report", reviewList);
		
	}




/**
 * 
 * @param fileName is the name of the file to be created
 * @return the message for confirmation of file generation
 */
public String writeToFile(String fileName, ArrayList<String> data) {
	PrintWriter writer = null;
	try {
		writer = new PrintWriter(fileName + ".txt", "UTF-8");
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		return "Report Not Generated";
	} catch (UnsupportedEncodingException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		return "Report Not Generated";
	}
	
	for(int i = 0; i < data.size(); i++) {
		writer.println(data.get(i) + "\n");
		writer.println("---------------------------------------------------------------------------------------------------------------------------"+
		"---------------------------------------------------------------------------------------------------------------------------");
	}
	
	writer.close();
	return "Report Generated";
}

//method to review
public int AddReview(Review rm)	{
	 int reviewNo = 0;		
	
	String sql = "Insert into review_Info(Comment )" 
			+ " VALUES ('" + rm.getComment()  + "');";
	
	try { 
		//Connect to the database
		helper.connectDB();
		
		//Create the statement
		this.stmt = helper.getConnection().createStatement();
		
		//Execute the statement
		reviewNo = stmt.executeUpdate(sql , Statement.RETURN_GENERATED_KEYS);

		helper.disconnectDB();			
		
	} catch (SQLException sx) {
		System.out.println("Error Connecting to Database");
		System.out.println(sx.getMessage());
		System.out.println(sx.getErrorCode());
		System.out.println(sx.getSQLState());
		
	}
	System.out.println("Inserted new COmment: " + reviewNo);
	return reviewNo;
	
}


public Review getReviews(int id) {
	
	Review review = new Review();
		
		String sql = "SELECT * FROM review_Info WHERE id  = ?";
		
		try {
			
			//Connect to the database
			helper.connectDB();
			
			//Create the statement
			pstmt = helper.getConnection().prepareStatement(sql);
			
			//Declare the parameter (starting at 1)
			pstmt.setInt(1,id);
			
			rs = pstmt.executeQuery();
			
			while (rs.next())	{
				
				//Get the right type (string) from the right column ("");									
				review.setId((rs.getInt("id")));
				review.setComment((rs.getString("Comment")));
							
			} 
			
			helper.disconnectDB();
				
			} catch (SQLException sx) {
				System.out.println("Error Connecting to Database");
				System.out.println(sx.getMessage());
				System.out.println(sx.getErrorCode());
				System.out.println(sx.getSQLState());
				
			}
			return review;			
		}

public void updateReview(String rvs)	{		

	Review rv = new Review();
	String updateSql = "UPDATE review_Info SET " + 
			"Comment  = ? " +
			"WHERE id = ?";
	
	//itemId , Item , Type , Quantity , Price , Category , Unitprice
	
	try {
			helper.connectDB();
			
			pstmt = helper.getConnection().prepareStatement(updateSql);
	
			
		//	pstmt.setInt(1, rv.getId());  				
			pstmt.setString(1, rv.getComment());
			
			pstmt.executeUpdate();
			
			helper.disconnectDB();
			
	} catch (SQLException sx) {
		System.out.println("Error Connecting to Database");
		System.out.println(sx.getMessage());
		System.out.println(sx.getErrorCode());
		System.out.println(sx.getSQLState());
		
	}	
}





//method for review list
public ArrayList<Review> listReview() 
{
	ArrayList<Review> s1 = new ArrayList<Review>();

	String sql = "SELECT * FROM review_Info";
	try {
		// connect to the database
		helper.connectDB();
		this.stmt = helper.getConnection().createStatement();
		rs = stmt.executeQuery(sql);

		while (rs.next())
		{   
			 
			Review s = new Review();
			
			//Get the right type (string) from the right column ("itemId");
			s.setId((rs.getInt("Id")));
			s.setComment((rs.getString("Comment")));
						
			s1.add(s);
			 // System.out.println(s1);
		}

		helper.disconnectDB();
	} catch (SQLException sx) {
		System.out.println("Error fetching data from the database");
		System.out.println(sx.getMessage());
		System.out.println(sx.getErrorCode());
		System.out.println(sx.getSQLState());
	}

	return s1;
}

/**
 * 
 * @return list of reviews as arraylist
 */
public ArrayList<String> getReviewList(){
	ArrayList<String> s1 = new ArrayList<String>();
	  
	  String sql = "SELECT * FROM review_info";
	  
	  try {
		  helper.connectDB();
		  this.stmt = helper.getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next())
			{
			
			  s1.add("Review Id: " + rs.getInt("id") + "\n" + "Review : " + rs.getString("Comment") );
			  System.out.println(s1);
		  }	  
	  helper.disconnectDB();
	  }catch(SQLException sx)
	  {
		  System.out.println("Error fetching data from the database");
		  System.out.println(sx.getMessage());
		  System.out.println(sx.getErrorCode());
		  System.out.println(sx.getSQLState()); 
	  }
	  
	  return s1;
	
}


}
