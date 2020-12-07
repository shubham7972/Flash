package generatedClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionClass {
	
public static Connection getConnection() {
	Connection con=null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "root");
			
		} catch (SQLException e) {			
			e.printStackTrace();
			System.out.println("Failed to create the database connection."); 
		}
		

	} catch (ClassNotFoundException e) {		
		e.printStackTrace();
		System.out.println("Driver not found.");
	}
	
	return con;	
}
}

