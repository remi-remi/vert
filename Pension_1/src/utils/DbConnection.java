package utils;

import java.sql.DriverManager;
import utils.DbConnection;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.*;
import static utils.Tools.*;

public class DbConnection {
	static String url = "jdbc:mysql://192.168.0.39:3306/vert";
	static String user = "prof";
	static String pass = "prof_1234";
	private static Connection con = null;
	
	static {
		System.out.println("");
		System.out.println("|______________________SQL_____________________|");
		System.out.println("|>info sql:");
		System.out.println("|host=" + url);
		System.out.println("|user=" + user + " mdp= " + pass);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, user, pass);
			System.out.println("|  [SQL Connection OK]");
		}catch(ClassNotFoundException | SQLException e){
			System.out.println("|  [SQL DBConnection erreur : ]");
			e.printStackTrace();
		}
		System.out.println("|______________________________________________|");
		System.out.println("");
		System.out.println("");
	}
	
	public static Connection getconConnection() {
		System.out.println("");
		System.out.println("|__________________SQL GetCon_________________|");
		System.out.println("|>info sql:");
		System.out.println("|	host=" + url);
		System.out.println("|		user=" + user);
		System.out.println("|		mdp= " + pass);
		System.out.println("|_____________________________________________|");
		System.out.println("");
		System.out.println("");
		return con;
	}
	
	
	public static void ExecutionSql(String sql,List<String> input) {
		String in = "";
		System.out.println("liste:");
		for (int i = 0; i < input.size()-1; i++) {
		in=in+"'";
		in=in+input.get(i);
		in=in+"',";	
		}
		in=in+"'"+input.get(input.size()-1)+"'";
		System.out.println("call "+sql+"("+in+");");
		
	}
	
	
	

}
