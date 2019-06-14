package com.csis.Controller;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

import com.csis.Entities.Room;
import com.toedter.calendar.JDateChooser;

public class RoomReservation {

	private JFrame frame;
	Room roomData = new Room();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomReservation window = new RoomReservation();
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
	public RoomReservation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Color color = new Color(51, 153, 102);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 581, 462);
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.getContentPane().setLayout(null);
		
		JLabel lblRmReserveTitle = new JLabel("Room Reservation");
		lblRmReserveTitle.setForeground(Color.WHITE);
		lblRmReserveTitle.setFont(new Font("Serif", Font.ITALIC, 20));
		lblRmReserveTitle.setBounds(208, 44, 232, 25);
		frame.getContentPane().add(lblRmReserveTitle);
		
		//bahr kdna
		String[] roomTypes = {"Executive King Double", "Executive Queen Double", "Executive Queen Single",
				"Deluxe King Double", "Deluxe Queen Double", "Deluxe Queen Single", "Regular Double", "Regular Single"};
		
		
		JList listRoomType = new JList(roomTypes);
		listRoomType.setBounds(113, 121, 184, 153);
		frame.getContentPane().add(listRoomType);
		
		
		JLabel lvlRoomType = new JLabel("Room Type");
		lvlRoomType.setForeground(Color.WHITE);
		lvlRoomType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lvlRoomType.setBounds(23, 122, 80, 35);
		frame.getContentPane().add(lvlRoomType);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(351, 143, 46, 14);
		lblDate.setBackground(new Color(95, 158, 160));
		frame.getContentPane().add(lblDate);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setForeground(Color.WHITE);
		lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDuration.setBounds(351, 193, 89, 23);
		frame.getContentPane().add(lblDuration);
		
		JSpinner spinDuration = new JSpinner();
		spinDuration.setBounds(433, 189, 29, 35);
		frame.getContentPane().add(spinDuration);
		
		JLabel lblMeal = new JLabel("Meal ");
		lblMeal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMeal.setForeground(Color.WHITE);
		lblMeal.setBounds(351, 277, 87, 14);
		frame.getContentPane().add(lblMeal);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setForeground(Color.WHITE);
		rdbtnYes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnYes.setBounds(353, 298, 109, 23);
		rdbtnYes.setBackground(new Color(95, 158, 160));
		frame.getContentPane().add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setForeground(Color.WHITE);
		rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNo.setBackground(new Color(95, 158, 160));
		rdbtnNo.setBounds(353, 324, 109, 23);
		frame.getContentPane().add(rdbtnNo);
		
		JCheckBox chkAddService = new JCheckBox("Additional Services");
		chkAddService.setForeground(Color.WHITE);
		chkAddService.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chkAddService.setBounds(23, 324, 192, 23);
		chkAddService.setBackground(new Color(95, 158, 160));
		frame.getContentPane().add(chkAddService);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(401, 137, 91, 20);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		frame.getContentPane().add(dateChooser);
		
		JLabel lbldays = new JLabel("(days)");
		lbldays.setForeground(Color.WHITE);
		lbldays.setBounds(361, 215, 46, 14);
		frame.getContentPane().add(lbldays);
		
		
		/**
		 * set Listeners
		 */
		setListListener(listRoomType);
		setServiceListener(chkAddService);
		setMealListener(rdbtnYes, rdbtnNo);
		setReservationDateListener(dateChooser);
		
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setStayDuration(spinDuration);
				System.out.println(roomData.getRoomType() + " " + roomData.getDuration() + " " + roomData.isAddService() 
				+ " " + roomData.isMeal() + " " + displayDate());
				//TODO: get and Validate all data
				//JOptionPane.showMessageDialog(null, "Confirmed!");
			}
		});
		btnConfirm.setBounds(223, 371, 89, 23);
		btnConfirm.setForeground(color);
		frame.getContentPane().add(btnConfirm);
		
	}
	


	protected String displayDate() {
		String actualDate = DateFormat.getDateInstance().format(roomData.getReserveDate());
		return actualDate;
	}

	protected void setReservationDateListener(JDateChooser dateChooser) {
		// TODO Auto-generated method stub
		dateChooser.getDateEditor().addPropertyChangeListener("date", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {
				// TODO Auto-generated method stub
				Date date = (Date) event.getNewValue();
				roomData.setReserveDate(date);
				}
			
		});
	}

	protected void setMealListener(JRadioButton rdbtnYes, JRadioButton rdbtnNo) {
		// TODO Auto-generated method stub
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnYes);
		radioGroup.add(rdbtnNo);
		
		class RoomActionListener implements ActionListener {
		      public void actionPerformed(ActionEvent ex) {
		      String choice = radioGroup.getSelection().getActionCommand();
		      }
		    }

		  class RoomItemListener implements ItemListener {
		   			@Override
			public void itemStateChanged(ItemEvent ex) {
				// TODO Auto-generated method stub
				String item = ((AbstractButton) ex.getItemSelectable()).getActionCommand();
		        boolean selected = (ex.getStateChange() == ItemEvent.SELECTED);
		        if(item.equals("Yes")) {
			    	  roomData.setMeal(true);
			      }else {
			    	  roomData.setMeal(false);
			      }
			}
		    }

		    ActionListener al = new RoomActionListener();
		    rdbtnYes.addActionListener(al);
		    rdbtnNo.addActionListener(al);

		    ItemListener il = new RoomItemListener();
		    rdbtnYes.addItemListener(il);
		    rdbtnNo.addItemListener(il);
		  
		
	}

	protected void setStayDuration(JSpinner spinDuration) {
		// TODO Auto-generated method stub
		roomData.setDuration(Integer.parseInt(spinDuration.getValue().toString()));
	}

	protected void setServiceListener(JCheckBox chkAddService) {
		// TODO Auto-generated method stub
		chkAddService.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				AbstractButton absButton = (AbstractButton) event.getSource();
				boolean serviceStatus = absButton.isSelected();
				roomData.setAddService(serviceStatus);
			}
			
		});
	}

	//TODO: check for default choice (it shows null value)
	public void setListListener(JList listRoomType) {
		listRoomType.addListSelectionListener(new ListSelectionListener() {
						
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(e.getValueIsAdjusting() == true) {
					switch(listRoomType.getSelectedIndex()) {
					case 0:
						roomData.setRoomType("Executive King Double");
						break;
					case 1:
						roomData.setRoomType("Executive Queen Double");
						break;
					case 2:
						roomData.setRoomType("Executive Queen Single");
						break;
					case 3:
						roomData.setRoomType("Deluxe King Double");
						break;
					case 4:
						roomData.setRoomType("Deluxe Queen Double");
						break;
					case 5:
						roomData.setRoomType("Deluxe Queen Single");
						break;
					case 6:
						roomData.setRoomType("Regular Double");
						break;
					case 7:
						roomData.setRoomType("Regular Single");
						break;
					default:
						roomData.setRoomType("Invalid choice for room type");
						break;
							
					}
				}
			}
			
		});
	}
	
}
