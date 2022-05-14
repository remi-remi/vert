package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;

import com.mysql.jdbc.Connection;

import model.*;
import utils.DbConnection;

import utils.DbConnection;
import static utils.Tools.redcho;

public class GardiennageDAO {
	static Connection con = DbConnection.getconConnection();

	public GardiennageDAO() {
		// TODO Auto-generated constructor stub
		
	}

	public int updateListGardiennages(ArrayList<Gardiennage> tempListeGardiennages) throws SQLException {
		int alteredLines = 0;

		String sql = "CALL updateGardiennage (?, ?, ?)";

		for (Gardiennage gardiennageActuel : tempListeGardiennages) {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, gardiennageActuel.getNom());
			preparedStatement.setFloat(2, gardiennageActuel.getPrix());
			preparedStatement.setInt(3, gardiennageActuel.getId());
			alteredLines += preparedStatement.executeUpdate();
		}

		return alteredLines;
	}
	
	public static ArrayList<Gardiennage> getGardiennageFromSql(int uIdPension) throws SQLException{

			System.out.println("________________________GetAllGardiennage("+uIdPension+")__________________________");
			System.out.println("[SQL] requete: call getGardiennage("+uIdPension+");");
			//sql = "call getGardiennage(" + uIdPension + ");";
			ArrayList<Gardiennage> ListeGardiennage = new ArrayList<>();
			String sql = "call getGardiennage(?)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uIdPension);
			ResultSet rs = ps.executeQuery();
			
			System.out.println("recuperation :   ");
			System.out.println("| id |type		|tarif|");
			while(rs.next()) {
				System.out.println("| " + rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getFloat(3) + " | ");
				int id = rs.getInt(1);
				String nom = rs.getString(2);
				float prix = rs.getFloat(3);

				
				ListeGardiennage.add(new Gardiennage(id,nom,prix));
			}

		System.out.println("__________________________________________________________________________");
				return ListeGardiennage;
	}

	

	
	/*	public int getGardiennageVersTableau(ArrayList<Gardiennage> ListeGardiennage) throws SQLException {
	int alteredLines = 0;
//	String sql = "CALL alterBox (" + idTab + ", " + taille + ",'" + typeTab + "' , " + prixTab + ")";
	String sql = "CALL alterBox (?, ?, ?)";

	for (Gardiennage var : ListeGardiennage) {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, obj.getId());
			preparedStatement.setFloat(2, obj.getSuperficie());
			preparedStatement.setString(3, obj.getLibelle());
			
			alteredLines += preparedStatement.executeUpdate();
		}

		return alteredLines;
	}*/
	
}
