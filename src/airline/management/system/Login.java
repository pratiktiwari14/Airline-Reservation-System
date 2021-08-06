package airline.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	
	TextField t1,t2;
	Label l1,l2;
	Button b1,b2,b3;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	Font f1,f2;
	
	public Login() {
		
		super("Login");
		setBackground(Color.WHITE);
		f1=new Font("TimesRoman",Font.BOLD,20);
		f2=new Font("TimesRoman",Font.BOLD,15);
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		setLayout(gbl);
		
		l1=new Label("USERNAME");
		l1.setFont(f1);
		l2=new Label("PASSWORD");
		l2.setFont(f1);
		
		t1=new TextField(15);
		
		t2=new TextField(15); //JPasswordField p=new JPasswordField(15);
		t2.setEchoChar('*');
		
		b1=new Button("RESET");
		b1.setFont(f2);
		
		b2=new Button("SUBMIT");
		b2.setFont(f2);
		
		b3=new Button("CLOSE");
		b3.setFont(f2);
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(l1,gbc);
		add(l1);
		
		gbc.gridx=2;
		gbc.gridy=0;
		gbl.setConstraints(t1,gbc);
		add(t1);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbl.setConstraints(l2,gbc);
		add(l2);
		
		gbc.gridx=2;
		gbc.gridy=2;
		gbl.setConstraints(t2,gbc);
		add(t2);
		
		gbc.gridx=0;
		gbc.gridy=8;
		gbl.setConstraints(b1,gbc);
		add(b1);
		
		gbc.gridx=2;
		gbc.gridy=8;
		gbl.setConstraints(b2,gbc);
		add(b2);
		
		gbc.gridx=4;
		gbc.gridy=8;
		gbl.setConstraints(b3,gbc);
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		setVisible(true);
		setSize(400,250);
		setLocation(400,200);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1)	 {
			t1.setText("");
			t2.setText("");
		}
		
		if(ae.getSource()==b3) {
			System.exit(0);	
		}
		if(ae.getSource()==b2) {
			try {
				Conn c1=new Conn();
				
				String s1=t1.getText();
				System.out.println("s1 is->"+s1);
				String s2=t2.getText();
				System.out.println("s2 is ->"+s2);
				
				String str= "select * from login where username="+ "'"+s1+"'" +" and password="+"'"+s2+"'";
				System.out.println("query ->"+str);

				ResultSet rs=c1.dbStatement.executeQuery(str);
				if(rs.next()) {
				    System.out.println("Table contains "+rs.getRow()+" rows");
				    rs.close();
					c1.closeConnection();
					
					new Mainframe();
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null,"Invalid login");
					setVisible(false);
				}
			}
			catch(Exception e) {};
		}
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
