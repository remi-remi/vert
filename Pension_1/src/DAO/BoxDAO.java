package DAO;

import java.sql.Connection;
import static utils.Tools.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Box;
import utils.DbConnection;

public class BoxDAO {

	private static Connection con = DbConnection.getconConnection();

	public int updateList(ArrayList<Box> boxes) throws SQLException {
		int alteredLines = 0;
//		String sql = "CALL alterBox (" + idTab + ", " + taille + ",'" + typeTab + "' , " + prixTab + ")";
		String sql = "CALL alterBox (?, ?, ?)";

		for (Box box : boxes) {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, box.getId());
			preparedStatement.setFloat(2, box.getSuperficie());
			preparedStatement.setString(3, box.getLibelle());
			alteredLines += preparedStatement.executeUpdate();
		}

		return alteredLines;
	}
	
	public ArrayList<Box> getAll(int uIdPension) throws SQLException{
		
		System.out.println("________________________GetAll("+uIdPension+")__________________________");
		System.out.println("[SQL] requete: call getBox("+uIdPension+");");
		//sql = "call getBox(" + uIdPension + ");";
		ArrayList<Box> boxes = new ArrayList<>();
		String sql = "call getBox(?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, uIdPension);
		ResultSet rs = ps.executeQuery();
		
		System.out.println("recuperation :   ");
		System.out.println("| id | taille | type           |tarif|");
		while(rs.next()) {
			System.out.println("| " + rs.getInt(1) + " | " + rs.getFloat(2) + " | " + rs.getString(3) + " | "+ rs.getFloat(4) + " |");
			int id = rs.getInt(1);
			float superficie = rs.getFloat(2);
			String libelle = rs.getString(3);
			float tarif = rs.getFloat(4);
			
			boxes.add(new Box(id, superficie, libelle, uIdPension, tarif));
		}
		System.out.println("__________________________________________________________________________");
		return boxes;
	}
	
	
	public boolean add(Box box) throws SQLException{
		String sql="call addBox(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,box.getLibelle());
		ps.setInt(2,box.getIdPension());
		ps.setFloat(3,box.getSuperficie());
		try {
			ResultSet rs = ps.executeQuery();
			return true;
		}catch(Exception e){
			return false;
		}
		
		
	}

}
