package airline.management.system;

import java.sql.*;

public class Conn {
	Connection dbConnection;
	public Statement dbStatement;
	
	public Conn(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConnection=DriverManager.getConnection("jdbc:mysql:///project1","root","");
			dbStatement=dbConnection.createStatement();
		}
		catch(Exception e){
			System.out.println("connection with db failed");
			System.out.println(e);
		}
	}
	public void closeConnection() {
		try {
			dbConnection.close();
		} catch (SQLException e) {
			System.out.println("connection did not close");
			e.printStackTrace();
		}
	}
}

