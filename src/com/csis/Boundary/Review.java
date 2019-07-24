package com.csis.Boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.List;
import javax.swing.JScrollPane;

public class Review {

	private JFrame frame;
	private JTextField textFieldreview;
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
		frame.setBounds(100, 100, 820, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldreview = new JTextField();
		textFieldreview.setBounds(219, 13, 473, 23);
		frame.getContentPane().add(textFieldreview);
		textFieldreview.setColumns(10);
		
		JLabel lblWhatYouThink = new JLabel("What you think about our service:");
		lblWhatYouThink.setBounds(10, 11, 199, 27);
		frame.getContentPane().add(lblWhatYouThink);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(219, 72, 575, 240);
		frame.getContentPane().add(scrollPane);
		
		List list = new List();
		scrollPane.setViewportView(list);

		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				review = textFieldreview.getText();
				String File_name = review;
				byte [] buff = File_name.getBytes();
				try {
					
					RandomAccessFile raf  = new RandomAccessFile("File_name.txt" , "rw");
					raf.write(buff);
					raf.seek(3);
				}catch(IOException ex){
					ex.printStackTrace();
				}
				
			}
		});
		btnSubmit.setBounds(705, 13, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		
		
	}
}
