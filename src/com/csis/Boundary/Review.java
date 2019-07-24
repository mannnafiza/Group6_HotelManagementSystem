package com.csis.Boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.List;
import javax.swing.JScrollPane;
import java.awt.TextArea;

public class Review {

	private JFrame frame;
    private String review; 
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
		frame.setBounds(100, 100, 528, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWhatYouThink = new JLabel("What you think about our service:");
		lblWhatYouThink.setBounds(43, 11, 208, 50);
		frame.getContentPane().add(lblWhatYouThink);
		
		TextArea textAreaReview = new TextArea();
		textAreaReview.setBounds(43, 67, 380, 160);
		frame.getContentPane().add(textAreaReview);
		
		
		
		
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
				
				try {
				  File archivo = new File("C:/Temp/Group6_HotelManagementSystem/File_name.txt");
				    FileReader fr = new FileReader(archivo);
				    BufferedReader br = new BufferedReader(fr);

				    Vector<String> lines = new Vector<String>();

				    String line;
				    while ((line = br.readLine()) != null) {
				      lines.add(line);
				    }
				   
				    JOptionPane.showMessageDialog(null, new JScrollPane(new JList(lines)));
				    fr.close();
				  }catch(IOException ex){
				         ex.printStackTrace();
			}
		}
		});
		btnSubmit.setBounds(335, 254, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		
		
		
	}
}
