package airline.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
	import java.sql.*; 

public class Add_Customer_Details extends JFrame{
	JTextField textfield,textfield_1,textfield_2,textfield_3,textfield_4,textfield_5,textfield_6;
	
	public Add_Customer_Details() {
		getContentPane().setForeground(Color.BLUE);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Add Customer Details");
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(770,486);
		getContentPane().setLayout(null);
		
		JLabel passport_no=new JLabel("Passport NO");
		passport_no.setFont(new Font("Tahoma",Font.PLAIN,17));
		passport_no.setBounds(60,80,150,27);
		add(passport_no);
		
		textfield=new JTextField();
		textfield.setBounds(200,80,150,27);
		add(textfield);
		
		JLabel pnr_no=new JLabel("PNR_NO");
		pnr_no.setFont(new Font("Tahoma",Font.PLAIN,17));
		pnr_no.setBounds(60,120,150,27);
		add(pnr_no);
		
		textfield_1=new JTextField();
		textfield_1.setBounds(200,120,150,27);
		add(textfield_1);
		
		JLabel address=new JLabel("Address");
		address.setFont(new Font("Tahoma",Font.PLAIN,17));
		address.setBounds(60,170,150,27);
		add(address);
		
		textfield_2=new JTextField();
		textfield_2.setBounds(200,170,150,27);
		add(textfield_2);
		
		JLabel nationality=new JLabel("Nationality");
		nationality.setFont(new Font("Tahoma",Font.PLAIN,17));
		nationality.setBounds(60,220,150,27);
		add(nationality);
		
		textfield_3=new JTextField();
		textfield_3.setBounds(200,220,150,27);
		add(textfield_3);
		
		JLabel name=new JLabel("Name");
		name.setFont(new Font("Tahoma",Font.PLAIN,17));
		name.setBounds(60,270,150,27);
		add(name);
		
		textfield_4=new JTextField();
		textfield_4.setBounds(200,270,150,27);
		add(textfield_4);
		
		JLabel gender=new JLabel("Gender");
		gender.setFont(new Font("Tahoma",Font.PLAIN,17));
		gender.setBounds(60,320,150,27);
		add(gender);
		
		JRadioButton radioButtton1=new JRadioButton("Male");
		radioButtton1.setBackground(Color.WHITE);
		radioButtton1.setBounds(200,320,70,27);
		add(radioButtton1);
		
		JRadioButton radioButtton2=new JRadioButton("Female");
		radioButtton2.setBackground(Color.WHITE);
		radioButtton2.setBounds(280,320,70,27);
		add(radioButtton2);
		
		
		JLabel phno=new JLabel("Phone No.");
		phno.setFont(new Font("Tahoma",Font.PLAIN,17));
		phno.setBounds(60,370,150,27);
		add(phno);
		
		textfield_5=new JTextField();
		textfield_5.setBounds(200,370,150,27);
		add(textfield_5);
		
		JLabel flightcode=new JLabel("Flight Code");
		flightcode.setFont(new Font("Tahoma",Font.PLAIN,17));
		flightcode.setBounds(60,30,150,27);
		add(flightcode);
		
		textfield_6=new JTextField();
		textfield_6.setBounds(200,30,150,27);
		add(textfield_6);
		
		
		JLabel addPassengers=new JLabel("Add Customer Details");
		addPassengers.setFont(new Font("Tahoma",Font.PLAIN,31));
		addPassengers.setForeground(Color.BLUE);
		addPassengers.setBounds(440,24,442,35);
		add(addPassengers);
		
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/emp.png"));
		JLabel image=new JLabel(i1);
		image.setBounds(450,80,280,410);
		add(image);
		
		
		JButton btn=new JButton("Save");
		btn.setForeground(Color.WHITE);
		btn.setBackground(Color.BLACK);
		btn.setBounds(200,420,150,30);
		add(btn);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String Passport_no=textfield.getText();
				String Pnrno=textfield_1.getText();
				String Address=textfield_2.getText();
				String Nation=textfield_3.getText();
				String Name=textfield_4.getText();
				String PhnNo=textfield_5.getText();
				String Flightcode=textfield_6.getText();
				
				String gender=null;
				if(radioButtton1.isSelected()) {
					gender="male";
				}
				else if(radioButtton2.isSelected()) {
					gender="female";
				}
				
				try {
					Conn myDbConnectionObject=new Conn();
					String str="INSERT INTO passenger VALUES('"+Pnrno+"','"+Address+"','"+Nation+"','"+Name+"',"
							+ "'"+gender+"','"+PhnNo+"','"+Passport_no+"','"+Flightcode+"')";
					myDbConnectionObject.dbStatement.executeUpdate(str);
					JOptionPane.showMessageDialog(null, "Customer Added");
					setVisible(false);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		setSize(900,600);
		setVisible(true);
		setLocation(400,200);
	}
	public static void main(String[] args) {
		new Add_Customer_Details();
	}
}





/*package airline.management.system;

import java.awt.EventQueue;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Add_Customer extends JFrame{ //Third Frame

    
	JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;

        public Add_Customer(){
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("ADD CUSTOMER DETAILS");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
			
            JLabel Passportno = new JLabel("PASSPORT NO");
            Passportno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Passportno.setBounds(60, 80, 150, 27);
            add(Passportno);
            
            textField = new JTextField();
            textField.setBounds(200, 80, 150, 27);
            add(textField);
			
            JButton Next = new JButton("SAVE");
            Next.setBounds(200, 420, 150, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            add(Next);
			
            JLabel Pnrno = new JLabel("PNR NO");
            Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Pnrno.setBounds(60, 120, 150, 27);
            add(Pnrno);
			
            textField_1 = new JTextField();
            textField_1.setBounds(200, 120, 150, 27);
            add(textField_1);
            
            JLabel Address = new JLabel("ADDRESS");
            Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Address.setBounds(60, 170, 150, 27);
            add(Address);
			
            textField_2 = new JTextField();
            textField_2.setBounds(200, 170, 150, 27);
            add(textField_2);
            		
            JLabel Nationality = new JLabel("NATIONALITY");
            Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Nationality.setBounds(60, 220, 150, 27);
            add(Nationality);
			
            textField_3 = new JTextField();
            textField_3.setBounds(200, 220, 150, 27);
            add(textField_3);
	
            JLabel Name = new JLabel("NAME");
            Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Name.setBounds(60, 270, 150, 27);
            add(Name);
	
            textField_4 = new JTextField();
            textField_4.setBounds(200, 270, 150, 27);
            add(textField_4);
	
            JLabel Gender = new JLabel("GENDER");
            Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Gender.setBounds(60, 320, 150, 27);
            add(Gender);
		
            JRadioButton NewRadioButton = new JRadioButton("MALE");
            NewRadioButton.setBackground(Color.WHITE);
            NewRadioButton.setBounds(200, 320, 70, 27);
            add(NewRadioButton);
	
            JRadioButton Female = new JRadioButton("FEMALE");
            Female.setBackground(Color.WHITE);
            Female.setBounds(280, 320, 70, 27);
            add(Female);
            
            JLabel Phno = new JLabel("PH NO");
            Phno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Phno.setBounds(60, 370, 150, 27);
            add(Phno);
			
            textField_5 = new JTextField();
            textField_5.setBounds(200, 370, 150, 27);
            add(textField_5);
	
            setVisible(true);
	
            JLabel AddPassengers = new JLabel("ADD CUSTOMER DETAILS");
            AddPassengers.setForeground(Color.BLUE);
            AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
            AddPassengers.setBounds(420, 24, 442, 35);
            add(AddPassengers);
			
    
            JLabel Flightcode = new JLabel("FLIGHT CODE");
            Flightcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Flightcode.setBounds(60, 30, 150, 27);
            add(Flightcode);

            textField_6 = new JTextField();
            textField_6.setBounds(200, 30, 150, 27);
            add(textField_6);
            
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/emp.png"));
            JLabel image = new JLabel(i1);
            image.setBounds(450,80,280,410);
            add(image);

            
            Next.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    String passport_No = textField.getText();
                    String pnr_no = textField_1.getText();
                    String address =  textField_2.getText();
                    String nationality = textField_3.getText();
                    String name = textField_4.getText();
                    String fl_code = textField_6.getText();
                   
                    String gender = null;
                    String ph_no = textField_5.getText();
                    
                    if(NewRadioButton.isSelected()){
                        gender = "male";
                    
                    }else if(Female.isSelected()){
                        gender = "female";
                    }
                    
                    try {
                        conn c = new conn();
                        String str = "INSERT INTO passenger values( '"+pnr_no+"', '"+address+"', '"+nationality+"','"+name+"', '"+gender+"', '"+ph_no+"','"+passport_No+"', '"+fl_code+"')";
                        
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Customer Added");
                        setVisible(false);
                    
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
		}
            });
			
            setSize(900,600);
            setVisible(true);
            setLocation(400,200);
			
	}
        
    public static void main(String[] args){
        new Add_Customer();
    }   
}
*/



