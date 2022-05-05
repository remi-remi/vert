package utils;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.*;

public class DbConnection {
	
	private static Connection con = null;
	
	static {
		String url = "jdbc:mysql://192.168.137.215:3306/vert";
		String user = "prof";
		String pass = "prof_1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, user, pass);
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
	}
	
	public static Connection getconConnection() {
		return con;
	}

}
