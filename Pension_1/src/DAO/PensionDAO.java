package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Box;
import utils.DbConnection;
import static utils.Tools.*;
import model.Pension;

public class PensionDAO {
	/// var pension

	private static Connection con = DbConnection.getconConnection();
	
	
	public Pension recupererPensionParSql(int uIdPension) {
		String pensionVille = null;
		String pensionAdresse = null;
		String pensionTelephone = null;
		String pensionResponsable = null;
		String pensionNom = null;
		
		String pensionAdresseSiegeSocial = null;
		String pensionNomDirigeant = null;
		String pensionAdresseLogo = null;
		Float pensionPrixVaccin = null;
		Float pensionPrixVermifuge = null;
		// --------------------------------prend les INFO DE LA PENSION pour les
		// afficher dans l'editeur de pension--------------------
		String sql = "call getPension("+uIdPension+");";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			echo(
					"____________________________________________["+sql+"]_________________________________________________");
			if (rs.next()) {
				echo("requete:  " + sql);
			    echo(rs.getString(1) + "|" + rs.getString(2) + "|"+ rs.getString(3) + "|" + rs.getString(4) + "|");
				pensionVille = rs.getString(1);
				pensionAdresse = rs.getString(2);
				pensionTelephone = rs.getString(3);
				pensionResponsable = rs.getString(4);

			} else {
			}
		} catch (Exception e1) {
			echo("" + e1);
		}

		echo(
				"_____________________________________________________________________________________________________________________");

		try {
			sql = "call getParametres("+uIdPension+");";
			echo("requete:  " + sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			echo(
					"____________________________________________["+sql+"]_________________________________________________");

			if (rs.next()) {
				echo("requete:  "+ sql);
				echo(rs.getString(1) + "|" + rs.getString(2) + "|"+ rs.getString(3) + "|" + rs.getString(4) + "|" + rs.getString(5) + "|"+ rs.getString(6) + "|");
				pensionNom = rs.getString(1);
				pensionAdresseSiegeSocial = rs.getString(2);
				pensionNomDirigeant = rs.getString(3);
				pensionAdresseLogo = rs.getString(4);
				pensionPrixVaccin = rs.getFloat(5);
				pensionPrixVermifuge = rs.getFloat(6);
			} else {
			}
		} catch (Exception e11) {
			echo("" + e11);
		}
		echo("Pension = pensionVille,pensionAdresse,pensionTelephone,pensionResponsable,pensionNom,pensionAdresseSiegeSocial,pensionNomDirigeant,pensionAdresseLogo,pensionPrixVaccin,pensionPrixVermifuge");
		echo("Pension ="+"|"+pensionVille+"|"+pensionAdresse+"|"+pensionTelephone+"|"+pensionResponsable+"|"+pensionNom+"|"+pensionAdresseSiegeSocial+"|"+pensionNomDirigeant+"|"+pensionAdresseLogo+"|"+pensionPrixVaccin+"|"+pensionPrixVermifuge);
		Pension pension = new Pension(pensionVille,pensionAdresse,pensionTelephone,pensionResponsable,pensionNom,pensionAdresseSiegeSocial,pensionNomDirigeant,pensionAdresseLogo,pensionPrixVaccin,pensionPrixVermifuge);
		;
		echo(
				"_____________________________________________________________________________________________________________________");
		echo("");

		echo("---------   ajout dans table");
		return pension;
	}

}
