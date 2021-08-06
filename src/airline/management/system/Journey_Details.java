package airline.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Journey_Details extends JFrame {
	JTable table;
	JButton show;
	JLabel ReservationDetails,Pnrno,Ticketid,Fcode,JnyDate,JnyTime,Source,Destination,
	label,label1;
	
	public static void main(String[] args) {
		new Journey_Details();
	}
	
	public Journey_Details() {
		setTitle("Journey Details");
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(null);
		
		Source=new JLabel("Source");
		Source.setFont(new Font("Thoma",Font.PLAIN,19));
		Source.setBounds(60,100,150,27);
		add(Source);
		
		Destination=new JLabel("Destination");
		Destination.setFont(new Font("Thoma",Font.PLAIN,19));
		Destination.setBounds(350,100,150,27);
		add(Destination);
		
		Destination=new JLabel("Destination");
		Destination.setFont(new Font("Thoma",Font.PLAIN,19));
		Destination.setBounds(350,100,150,27);
		add(Destination);
		
		show=new JButton("Show");
		show.setBounds(680,100,100,30);
		add(show);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		ReservationDetails=new JLabel("Reservation Details");
		ReservationDetails.setFont(new Font("Thoma",Font.PLAIN,19));
		ReservationDetails.setBounds(280,27,359,31);
		add(ReservationDetails);
		
		ReservationDetails=new JLabel("Reservation Details");
		ReservationDetails.setFont(new Font("Thoma",Font.PLAIN,19));
		ReservationDetails.setBounds(280,27,359,31);
		add(ReservationDetails);
		
		Pnrno=new JLabel("Pnr_No");
		Pnrno.setFont(new Font("Thoma",Font.PLAIN,19));
		Pnrno.setBounds(79,270,83,20);
		add(Pnrno);
		
		Ticketid=new JLabel("Ticket ID");
		Ticketid.setFont(new Font("Thoma",Font.PLAIN,19));
		Ticketid.setBounds(172,270,100,20);
		add(Ticketid);
		
		Fcode=new JLabel("Flight_code");
		Fcode.setFont(new Font("Thoma",Font.PLAIN,19));
		Fcode.setBounds(280,270,103,20);
		add(Fcode);
		
		JnyDate=new JLabel("Journey Date");
		JnyDate.setFont(new Font("Thoma",Font.PLAIN,19));
		JnyDate.setBounds(410,270,120,20);
		add(JnyDate);
		
		JnyTime=new JLabel("Journey Time");
		JnyTime.setFont(new Font("Thoma",Font.PLAIN,19));
		JnyTime.setBounds(550,270,120,20);
		add(JnyTime);
		
		
		String []item1= {"Bagalore","Mumbai","Chennai","Patna","Delhi","Hyderabad"};
		JComboBox combobox1=new JComboBox(item1);
		combobox1.setBounds(150,100,150,27);
		add(combobox1);
		
		String []item2= {"Bagalore","Mumbai","Chennai","Patna","Delhi","Hyderabad"};
		JComboBox combobox2=new JComboBox(item2);
		combobox2.setBounds(500,100,150,27);
		add(combobox2);
		
		table=new JTable();
		table.setBounds(38,310,770,130);
		add(table);
		
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {	
				try {
					String src=(String) combobox1.getSelectedItem();
					String dst=(String) combobox2.getSelectedItem();
					
					Conn c=new Conn();	
					String str="select pnr_no,ticket_id,f_code,jny_date,jny_time,src,dst from reservation "
							+ "where src='"+src+"' and dst='"+dst+"'";
					ResultSet rs=c.dbStatement.executeQuery(str);
					
					if(rs.next()) {
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					else {
					JOptionPane.showMessageDialog(null, "No Flight Between Source and Destination");
					}
				}
				catch(Exception e) {}
			}
		});
		setSize(860,600);
		setLocation(400,200);
		setVisible(true);
	}
}


