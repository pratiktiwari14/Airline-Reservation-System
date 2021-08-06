package airline.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mainframe extends JFrame {
	public static void main(String[] args) {
		new Mainframe().setVisible(true);
	}
	
	public Mainframe() {
		super("AIRLINE RESERVATION MANAGEMENT SYSTEM");
		initialize();
	}
	private void initialize() {
		setForeground(Color.CYAN);
		setLayout(null);
		
		JLabel newlabel=new JLabel(""); 
		newlabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/front.jpg")));
		newlabel.setBounds(0,0,1920,990);
		add(newlabel);
		
		JLabel airlineManagementSystem=new JLabel("Air India Welcomes You");
		airlineManagementSystem.setForeground(Color.BLUE);
		airlineManagementSystem.setFont(new Font("Tahoma",Font.PLAIN,36));
		airlineManagementSystem.setBounds(700,60,1000,55);
		newlabel.add(airlineManagementSystem);
		
		JMenuBar menubar=new JMenuBar();
		setJMenuBar(menubar);
		
		JMenu airlineSystem=new JMenu("Airline System");
		airlineSystem.setForeground(Color.BLUE);
		menubar.add(airlineSystem);
		
		JMenuItem flightDetails=new JMenuItem("Flight_Info");
		airlineSystem.add(flightDetails);
		
		JMenuItem reservationDetails=new JMenuItem("Add_Customer_Details");
		airlineSystem.add(reservationDetails);
		
		JMenuItem passengerDetails=new JMenuItem("Journey_Details");
		airlineSystem.add(passengerDetails);
		
		JMenuItem cancellation=new JMenuItem("Cancellation");
		airlineSystem.add(cancellation);
		
		JMenuItem sectorDetails_1=new JMenuItem("Payment_Details");
		airlineSystem.add(sectorDetails_1);
		
		JMenu ticket=new JMenu("Ticket");
		airlineSystem.setForeground(Color.RED);
		menubar.add(ticket);
		
		JMenu list=new JMenu("List");
		airlineSystem.setForeground(Color.BLUE);
		menubar.add(list);
		
		JMenu misc=new JMenu("Misc");
		airlineSystem.setForeground(Color.RED);
		menubar.add(misc);
		
		
		passengerDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new Flight_Info();
			}
		});
		
		reservationDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					new Add_Customer_Details();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		passengerDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					new Journey_Details();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		sectorDetails_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					new Payment_Details();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		cancellation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new Cancel();
			}
		});
		
		setSize(1950,1090);
		setVisible(true);
		
	}
}
