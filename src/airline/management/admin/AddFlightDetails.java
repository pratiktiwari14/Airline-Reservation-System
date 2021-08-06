package airline.management.admin;

import java.sql.ResultSet;
import java.util.Scanner;

import airline.management.system.Conn;

public class AddFlightDetails {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		
		System.out.println("Insert flight code");
		String flightCode=myObj.nextLine();
		System.out.println("Insert flight name");
		String flightName=myObj.nextLine();
		System.out.println("Insert flight source");
		String source=myObj.nextLine();
		System.out.println("Insert flight destination");
		String destination=myObj.nextLine();
		try {
			Conn c1=new Conn();
			
			String str= "insert into flight values('"+flightCode+"','"+flightName+"','"+source+"','"+destination+"')";
			
			System.out.println("query ->"+str);

			int rs=c1.dbStatement.executeUpdate(str);
			if(rs!=0) {
				System.out.println("insert success rs is :- "+rs);
			}
			c1.closeConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
