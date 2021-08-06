package airline.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Flight_Info extends JFrame {
	private JTable table;
	private JTextField textfield;
	
	public static void main(String[] args) {
		new Flight_Info().setVisible(true);
	}
	
	public Flight_Info() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setFont(new Font("Tahoma",Font.PLAIN,13));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(860,535);
		setLayout(null);
		setVisible(true);
		
		JLabel Fcode=new JLabel("FLIGHT CODE");
		Fcode.setFont(new Font("Tahoma",Font.PLAIN,17));
		Fcode.setBounds(50,100,200,30);
		add(Fcode);
		
		JLabel flighrDetails=new JLabel("FLIGHT INFORMATION");
		flighrDetails.setForeground(new Color(100,149,237));
		flighrDetails.setFont(new Font("Tahoma",Font.PLAIN,31));
		flighrDetails.setBounds(50,20,570,35);
		add(flighrDetails);
		
		JButton btnshow=new JButton("Show");
		btnshow.setFont(new Font("Tahoma",Font.PLAIN,20));
		
		btnshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				String code= textfield.getText();
				
				try {
					Conn c=new Conn();
					String str="select f_code,f_name,src,dst,capacity,class_code,class_name from flight,sector where f_code='"+code+"'";
					//String str="select f_code,f_name,src,dst from flight where f_code='"+code+"'";

					ResultSet rs=c.dbStatement.executeQuery(str);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		btnshow.setBounds(220,150,120,30);
		add(btnshow);
		
		table=new JTable();
		table.setBackground(Color.WHITE);
		table.setBounds(23,250,800,300);
		
		JScrollPane pane=new JScrollPane(table);
		pane.setBackground(Color.WHITE);
		pane.setBounds(23,250,800,300);
		add(pane);
		
		textfield=new JTextField();
		textfield.setBounds(220,100,200,30);
		add(textfield);
		
		JLabel flightcode=new JLabel("FlightCode");
		flightcode.setFont(new Font("Tahoma",Font.PLAIN,13));
		flightcode.setBounds(23,220,126,14);
		add(flightcode);
		
		JLabel flightname=new JLabel("FlightName");
		flightname.setFont(new Font("Tahoma",Font.PLAIN,13));
		flightname.setBounds(145,220,120,14);
		add(flightname);
		
		JLabel source=new JLabel("Source");
		source.setFont(new Font("Tahoma",Font.PLAIN,13));
		source.setBounds(275,220,104,14);
		add(source);
		
		JLabel destination=new JLabel("Destination");
		destination.setFont(new Font("Tahoma",Font.PLAIN,13));
		destination.setBounds(367,220,120,14);
		add(destination);
		
		JLabel capacity=new JLabel("Capacity");
		capacity.setFont(new Font("Tahoma",Font.PLAIN,13));
		capacity.setBounds(497,220,111,14);
		add(capacity);
		
		JLabel classcode=new JLabel("ClassCode");
		classcode.setFont(new Font("Tahoma",Font.PLAIN,13));
		classcode.setBounds(587,220,120,14);
		add(classcode);
		
		JLabel classname=new JLabel("Classname");
		classname.setFont(new Font("Tahoma",Font.PLAIN,13));
		classname.setBounds(700,220,111,14);
		add(classname);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(900,650);
		setVisible(true);
		setLocation(400,200);
	}
}
