package airline.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Cancel extends JFrame {
	private JTextField textfield,textfield_1,textfield_2,textfield_3,textfield_4;
	
	public static void main(String[] args) {
		new Cancel();
	}
	public Cancel () {
		initialize();
	}
	
	private void initialize() {
		setTitle("Cancellation");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100,100,401,72);
		setLayout(null);
	
		JLabel cancellation=new JLabel("Cancellation");
		cancellation.setFont(new Font("Tahoma",Font.PLAIN,31));
		cancellation.setBounds(185,24,259,38);
		add(cancellation);
		
		ImageIcon i2= new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/cancel.png"));
		JLabel image2=new JLabel(i2);
		image2.setBounds(470,100,250,250);
		add(image2);
		
		JLabel passengerNo=new JLabel("Passenger No");
		passengerNo.setFont(new Font("Tahoma",Font.PLAIN,17));
		passengerNo.setBounds(60,100,132,26);
		add(passengerNo);
		
		JLabel cancellationNo=new JLabel("Cancellation No");
		cancellationNo.setFont(new Font("Tahoma",Font.PLAIN,17));
		cancellationNo.setBounds(60,150,150,27);
		add(cancellationNo);
	
		JLabel cancellationDate=new JLabel("Cancellation Date");
		cancellationDate.setFont(new Font("Tahoma",Font.PLAIN,17));
		cancellationDate.setBounds(60,200,180,27);
		add(cancellationDate);
		
		JLabel ticketID=new JLabel("Ticket ID");
		ticketID.setFont(new Font("Tahoma",Font.PLAIN,17));
		ticketID.setBounds(60,250,150,27);
		add(ticketID);
		
		JLabel flightCode=new JLabel("Flight Code");
		flightCode.setFont(new Font("Tahoma",Font.PLAIN,17));
		flightCode.setBounds(60,300,150,27);
		add(flightCode);
		
		JButton cancel=new JButton("CANCEL");
		cancel.setFont(new Font("Tahoma",Font.PLAIN,14));
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.BLACK);
		cancel.setBounds(250,350,150,30);
		add(cancel);
		
		textfield=new JTextField();
		textfield.setBounds(250,100,150,27);
		add(textfield);
		
		textfield_1=new JTextField();
		textfield_1.setBounds(250,150,150,27);
		add(textfield_1);
		
		textfield_2=new JTextField();
		textfield_2.setBounds(250,200,150,27);
		add(textfield_2);
		
		textfield_3=new JTextField();
		textfield_3.setBounds(250,250,150,27);
		add(textfield_3);
		
		textfield_4=new JTextField();
		textfield_4.setBounds(250,300,150,27);
		add(textfield_4);
		
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String passengerNo=textfield.getText();
				String cancellationNo=textfield.getText();
				String cancellationDate=textfield.getText();
				String ticketID=textfield.getText();
				String flightCode=textfield.getText();	
				
				try {
					Conn c=new Conn();
					String str="INSERT INTO cancellation VALUES('"+passengerNo+"','"
					+cancellationNo+"',"+ "'"+cancellationDate+"','"
							+ticketID+"','"+flightCode+"')";
					c.dbStatement.executeUpdate(str);
					JOptionPane.showMessageDialog(null, "Ticket Cancelled");
					setVisible(false);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		setSize(860,500);
		setLocation(400,200);
		setVisible(true);
	}
}










