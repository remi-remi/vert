package utils;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.*;

public class DbConnection {
	
	private static Connection con = null;
	
	static {
		String url = "jdbc:mysql://192.168.1.49:3306/vert";
		String user = "prof";
		String pass = "prof_1234";
		System.out.println("");
		System.out.println("|______________________SQL_____________________|");
		System.out.println("|info sql: host=" + url);
		System.out.println("|user=" + user + " mdp= " + pass);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, user, pass);
			System.out.println("|  [SQL OK]");
		}catch(ClassNotFoundException | SQLException e){
			System.out.println("|  [SQL DBConnection erreur : ]");
			e.printStackTrace();
		}
		System.out.println("|______________________________________________|");
		System.out.println("");
		System.out.println("");
	}
	
	public static Connection getconConnection() {
		return con;
	}

}
