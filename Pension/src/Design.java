import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import DAO.BoxDAO;
import model.Box;

/*https://www.tutorialsfield.com/how-to-connect-mysql-database-in-java-using-eclipse/*/

public class Design extends JFrame {

	/**
	 * 
	 */
	JPanel CardBox_ = new JPanel();
	
	private ArrayList<Box> boxes;

	private JPanel contientTout;
	private JPanel CardInfo_;
	private JPanel CardLogin_;

	private JTextField ulogin;
	private JPasswordField umdp;
	private JLabel identifiant;
	private JLabel motDePasse;
	private JButton verif;
	private JLabel bonjour;
	private JTextField nBoxType;
	private JTextField nBoxTaille;

	String bddUtilisateur = "prof";
	String bddMdp = "prof_1234";
	String host = "jdbc:mysql://192.168.1.49:3306/vert"; /* 3306 ou 8080 */
	/* 3306 ou 8080 */
	String sql;
	int uIdPension = 0;
	public int nbBox = 0;
	private JTable tablePension;

	/// var pension
	String pensionVille = null;
	String pensionAdresse = null;
	String pensionTelephone = null;
	String pensionResponsable = null;

	String pensionNom = null;
	String pensionAdresseSiegeSocial = null;
	String pensionNomDirigeant = null;
	String pensionAdresseLogo = null;
	String pensionPrixVaccin = null;
	String pensionPrixVermifuge = null;
	BoxDAO boxDAO = new BoxDAO();

    ///___________________________________
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Design frame = new Design();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * Create the frame.
	 */
	public Design() {
		System.out.print("test");
		setForeground(new Color(255, 215, 0));
		setBackground(Color.WHITE);

		JTable table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table.setBackground(new Color(224, 255, 255));
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setFillsViewportHeight(true);
		table.setBounds(78, 139, 405, 250);
		DefaultTableModel tableModel = new DefaultTableModel(0, 0) {
			/**
			* 
			*/
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int line, int column) {
				if (column == 0 || column == 3)
					return false;
				else
					return true;

			}
		};
		
		tablePension = new JTable();
		tablePension.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tablePension.setBackground(new Color(224, 255, 255));
		tablePension.setFont(new Font("Dialog", Font.PLAIN, 15)); 	
		tablePension.setModel(new DefaultTableModel(new Object[][] { 
			{ "nom de la pension", null },
			{ "responsable", null }, 
			{ "ville", null }, 
			{ "adresse", null },
			{ "telephone", null }, 
			{ "nom dirigeant", null },
			{ "adresse siege social", null }, 
			{ "lien vers le logo", null },
			{ "prix vaccin", null }, 
			{ "prix vermifuge", null }, 
			},
			new String[] { "nom", "valeur" }));
			tablePension.getColumnModel().getColumn(0).setPreferredWidth(181);
			tablePension.getColumnModel().getColumn(1).setPreferredWidth(272);
			tablePension.setBounds(12, 126, 392, 160);

		String header[] = new String[] { "id", "taille", "type", "tarif" };
		tableModel.setColumnIdentifiers(header);
		table.setModel(tableModel);
		JScrollPane vneScrollPane = new JScrollPane(table);
		vneScrollPane.setBounds(7, 40, 396, 305);
		CardBox_.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		CardBox_.add(vneScrollPane);

		setTitle("gestion pension box et gardiennage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 450);

		contientTout = new JPanel(); 
		contientTout.setAlignmentY(11.0f);
		contientTout.setAlignmentX(1.0f);/* CONTIENT TOUT */
		contientTout.setBackground(new Color(127, 255, 212));
		contientTout.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contientTout);
		contientTout.setLayout(new CardLayout(0, 0));

		JPanel __CardSelection__ = new JPanel();
		__CardSelection__.setVisible(false);
		contientTout.add(__CardSelection__, "name_273988110161100");
		__CardSelection__.setLayout(null);

		JButton boutonDeconnexion = new JButton("d\u00E9connexion");
		boutonDeconnexion.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		boutonDeconnexion.setForeground(Color.BLACK);
		boutonDeconnexion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		boutonDeconnexion.setBackground(new Color(255, 102, 102));
		boutonDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deconnectionUtilisateur(__CardSelection__);
			}
		});
		boutonDeconnexion.setBounds(214, 86, 190, 145);
		__CardSelection__.add(boutonDeconnexion);

		JLabel bienvenue = new JLabel("bienvenue (ulogin)");
		bienvenue.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		bienvenue.setBackground(Color.LIGHT_GRAY);
		bienvenue.setOpaque(true);
		bienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bienvenue.setBounds(10, 10, 394, 65);
		__CardSelection__.add(bienvenue);

		JButton btnGP = new JButton("gestion pension");
		btnGP.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));/* BOUTON GESTION PENSION */
		btnGP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remplirGestionPensionParSql(__CardSelection__);
			}

			
		});
		btnGP.setForeground(new Color(0, 0, 0));
		btnGP.setBackground(new Color(176, 224, 230));
		btnGP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGP.setBounds(214, 242, 190, 145);
		__CardSelection__.add(btnGP);

		JButton btnGB = new JButton("gestion box");
		btnGB.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));/* BOUTON BOX */
		btnGB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardBox_.setVisible(true);
				__CardSelection__.setVisible(false);
				sqlBoxVersTable(tableModel);
			}


		});

		btnGB.setForeground(Color.BLACK);
		btnGB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGB.setBackground(new Color(152, 251, 152));
		btnGB.setBounds(10, 85, 190, 145);
		__CardSelection__.add(btnGB);

		JButton btnGG = new JButton("gestion gardiennage");
		btnGG.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnGG.setActionCommand("gestion gardiennage");/* BOUTON GARDIENNAGE */
		btnGG.setForeground(Color.BLACK);
		btnGG.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGG.setBackground(Color.ORANGE);
		btnGG.setBounds(10, 242, 190, 145);
		__CardSelection__.add(btnGG);

		CardLogin_ = new JPanel();
		CardLogin_.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		CardLogin_.setBackground(Color.WHITE);
		CardLogin_.setLayout(null);
		contientTout.add(CardLogin_, "name_39649998733200");
		CardLogin_.setVisible(true);

		ulogin = new JTextField();
		ulogin.setHorizontalAlignment(SwingConstants.CENTER);
		ulogin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ulogin.setColumns(10);
		ulogin.setBackground(Color.WHITE);
		ulogin.setBounds(30, 140, 110, 30);
		CardLogin_.add(ulogin);

		umdp = new JPasswordField();
		umdp.setHorizontalAlignment(SwingConstants.CENTER);
		umdp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		umdp.setBackground(Color.WHITE);
		umdp.setBounds(150, 140, 110, 30);
		CardLogin_.add(umdp);

		identifiant = new JLabel("identifiant");
		identifiant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		identifiant.setBounds(30, 115, 110, 14);
		CardLogin_.add(identifiant);

		motDePasse = new JLabel("mot de passe");
		motDePasse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		motDePasse.setBounds(150, 115, 110, 14);
		CardLogin_.add(motDePasse);

		JLabel logintxt = new JLabel("");
		logintxt.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		logintxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		logintxt.setHorizontalAlignment(SwingConstants.CENTER);
		logintxt.setOpaque(true);
		logintxt.setBackground(Color.LIGHT_GRAY);
		logintxt.setForeground(new Color(255, 0, 0));
		logintxt.setBounds(10, 193, 394, 80);
		CardLogin_.add(logintxt);

		verif = new JButton("connecter");
		verif.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		verif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try { /* \/ <- changer options SQL ici */
					sql = "call getCon('" + ulogin.getText() + "','" + String.valueOf(umdp.getPassword()) + "');";

					Class.forName("com.mysql.jdbc.Driver");
					Tools.print("Statement stmt=con.createStatement();" + "host = " + host + "SQL utilisateur = "
							+ bddUtilisateur + "SQL mdp =" + bddMdp);
					Connection con = DriverManager.getConnection(host, bddUtilisateur, bddMdp);

					Statement stmt = con.createStatement();
					logintxt.setText(" L'identifiant ou le mot de passe est incorrect");

					ResultSet rs = stmt.executeQuery(sql);

					Tools.print("authentification de lutilisateur en sql=" + sql);

					if (rs.next()) {
						uIdPension = rs.getInt(11);
						Tools.print("nb de la pension: " + uIdPension);
						bienvenue.setText("Bienvenue " + ulogin.getText()); /* texte de l'Ã©crant de sÃ©lÃ©ction */
						verif.setText("OK");
						CardLogin_.setVisible(false);
						__CardSelection__.setVisible(true);
					} else {

					}
				} catch (Exception e1) {
				}
				;

			}
		});
		verif.setBounds(270, 115, 120, 55);
		CardLogin_.add(verif);

		CardInfo_ = new JPanel(); 
		CardInfo_.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));/* INFO sur la pension */
		CardInfo_.setVisible(false);
		CardInfo_.setBackground(Color.WHITE);
		contientTout.add(CardInfo_, "name_39649989349900");
		CardInfo_.setLayout(null);

		bonjour = new JLabel("bonjour");
		bonjour.setBounds(425, 15, 46, 14);
		CardInfo_.add(bonjour);
		

		JButton btnNewButton = new JButton("enregistrer les informations");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				envoyerDonnéeSaisiesPension();

			}
		});
		btnNewButton.setBounds(192, 354, 212, 36);
		CardInfo_.add(btnNewButton);

		JButton pensionVersSelection = new JButton("retour");
		pensionVersSelection.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pensionVersSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardInfo_.setVisible(false);
				__CardSelection__.setVisible(true);

			}
		});

		pensionVersSelection.setBounds(315, 11, 89, 23);
		CardInfo_.add(pensionVersSelection);																				

		JLabel decoPension = new JLabel("N I F T Y");
		decoPension.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		decoPension.setBackground(Color.GRAY);
		decoPension.setOpaque(true);
		decoPension.setHorizontalAlignment(SwingConstants.CENTER);
		decoPension.setFont(new Font("Dialog", Font.BOLD, 20));
		decoPension.setBounds(12, 11, 390, 78);
		CardInfo_.add(decoPension);
		
		tablePension = new JTable();

			tablePension.setModel(new DefaultTableModel(new Object[][] { 
				{ "nom de la pension", null },
				{ "responsable", null }, 
				{ "ville", null }, 
				{ "adresse", null },
				{ "telephone", null }, 
				{ "nom dirigeant", null },
				{ "adresse siege social", null }, 
				{ "lien vers le logo", null },
				{ "prix vaccin", null }, 
				{ "prix vermifuge", null }, 
				},
				new String[] { "nom", "valeur" }
		));
		tablePension.setBackground(new Color(175, 238, 238));
		tablePension.setBounds(12, 101, 392, 241);
		CardInfo_.add(tablePension);
		CardInfo_.setVisible(false);

		contientTout.add(CardBox_, "name_278764592863900");
		CardBox_.setLayout(null);

		JLabel texte1 = new JLabel("liste des box:");
		texte1.setBounds(10, 4, 116, 22);
		CardBox_.add(texte1);

		JButton enegistrerBox = new JButton("enregistrer");
		enegistrerBox.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		enegistrerBox.setFont(new Font("Tahoma", Font.PLAIN, 10));
		enegistrerBox.setBounds(12, 367, 89, 22);
		enegistrerBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
																	/// ------------------------------recupÃ©ration des box creation d'un objet
				Tools.print("enregistrement...");
				Tools.print("");

				ArrayList<Box> tempBoxes = new ArrayList<>();
				
				for (int i = 0; i < boxes.size(); i++) {
					
					int idTab = Integer.parseInt(table.getValueAt((i), 0).toString());
					Float taille = Float.parseFloat(table.getValueAt((i), 1).toString());
					String typeTab = table.getValueAt(i, 2).toString();
					Float prixTab = Float.parseFloat(table.getValueAt(i, 3).toString());
					
					Box tempBox = new Box(idTab, taille, typeTab, prixTab);
					Tools.print("______________ligne de la box n: " + i + "____________________");
					Tools.print("| id | taille | type           |tarif|");
					Tools.print("| " + idTab + " | " + taille.toString() + "    |" + typeTab.toString() + "| "+ prixTab.toString() + " |");
					if(!boxes.get(i).equals(tempBox)) {
						tempBoxes.add(tempBox);
						Tools.print("|  [box modifiée]");
					}else {Tools.print("|  box non modifiée");}
					
					BoxDAO boxDAO = new BoxDAO();
					try {
						boxDAO.updateList(tempBoxes);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				Tools.print("______________________________________________________");
				
			}
				Tools.print("enregistrement términé ");
				}});

		CardBox_.add(enegistrerBox);

		JLabel texte2 = new JLabel("pension de paris");
		texte2.setBounds(121, 8, 135, 14);
		CardBox_.add(texte2);

		JButton ajouterBox = new JButton("ajouter box");
		ajouterBox.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		ajouterBox.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ajouterBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // -----------------------AddBox
				addBoxAuTableau(tableModel);
			}
		});

		ajouterBox.setBounds(316, 366, 89, 23);
		CardBox_.add(ajouterBox);

		JButton retourGestionBox = new JButton("retour");
		retourGestionBox.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		retourGestionBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fermerCardBox(__CardSelection__);
			}
		});

		autoCon();
		
		JLabel laMiseAuVert = new JLabel("Outil de gestion La mise au vert");
		laMiseAuVert.setHorizontalAlignment(SwingConstants.CENTER);
		laMiseAuVert.setFont(new Font("Tahoma", Font.PLAIN, 20));
		laMiseAuVert.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		laMiseAuVert.setBackground(new Color(50, 205, 50));
		laMiseAuVert.setOpaque(true);
		laMiseAuVert.setBounds(10, 11, 394, 80);
		CardLogin_.add(laMiseAuVert);
		
		JLabel deco = new JLabel("");
		deco.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		deco.setOpaque(true);
		deco.setBackground(SystemColor.controlHighlight);
		deco.setBounds(10, 102, 394, 80);
		CardLogin_.add(deco);

		retourGestionBox.setBounds(316, 6, 89, 23);
		CardBox_.add(retourGestionBox);

		nBoxType = new JTextField();
		nBoxType.setBounds(132, 370, 86, 20);
		CardBox_.add(nBoxType);
		nBoxType.setColumns(10);

		nBoxTaille = new JTextField();
		nBoxTaille.setBounds(220, 370, 86, 20);
		CardBox_.add(nBoxTaille);
		nBoxTaille.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(121, 351, 16, 50);
		CardBox_.add(separator);

		JLabel lblTailleBox = new JLabel("taille");
		lblTailleBox.setBounds(224, 351, 70, 15);
		CardBox_.add(lblTailleBox);

		JLabel lblType = new JLabel("type");
		lblType.setBounds(132, 351, 70, 15);
		CardBox_.add(lblType);
		///---------------------------------------------------------------------------------------------methods \/------------------------------------------------------------------------------------------------------------
	}

	private void autoCon() {
		ulogin.setText("remi3");
		umdp.setText("1234");
		Tools.print("|AUTO CON ACTIF !!!|");
	}
	private void remplirGestionPensionParSql(JPanel __CardSelection__) {
		// --------------------------------prend les INFO DE LA PENSION pour les
		// afficher dans l'editeur de pension--------------------
		try {
			sql = "call getPension(1);";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(host, bddUtilisateur, bddMdp);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			Tools.print(
					"____________________________________________[Get info de la pension]_________________________________________________");
			if (rs.next()) {
				Tools.print("requï¿½te:  " + sql + " =  " + rs.getString(1) + "|" + rs.getString(2) + "|"
						+ rs.getString(3) + "|" + rs.getString(4) + "|");
				pensionVille = rs.getString(1);
				pensionAdresse = rs.getString(2);
				pensionTelephone = rs.getString(3);
				pensionResponsable = rs.getString(4);

			} else {
			}
		} catch (Exception e1) {
			Tools.print("" + e1);
		}

		Tools.print(
				"_____________________________________________________________________________________________________________________");

		try {
			sql = "call getParametres(1);";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(host, bddUtilisateur, bddMdp);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			Tools.print(
					"____________________________________________[Get parametres de la pension]_________________________________________________");

			if (rs.next()) {
				Tools.print("requï¿½te:  " + sql + " =  " + rs.getString(1) + "|" + rs.getString(2) + "|"
						+ rs.getString(3) + "|" + rs.getString(4) + "|" + rs.getString(5) + "|"
						+ rs.getString(6) + "|");

				pensionNom = rs.getString(1);
				pensionAdresseSiegeSocial = rs.getString(2);
				pensionNomDirigeant = rs.getString(3);
				pensionAdresseLogo = rs.getString(4);
				pensionPrixVaccin = rs.getString(5);
				pensionPrixVermifuge = rs.getString(6);
			} else {
			}
		} catch (Exception e11) {
			Tools.print("" + e11);
		}
		;
		Tools.print(
				"_____________________________________________________________________________________________________________________");
		Tools.print("");

		Tools.print("---------   ajout de la table");
		/// PARTIE COUPÃ‰E ICI ENTREE DANS LE tablePensionU

		CardInfo_.setVisible(true);
		__CardSelection__.setVisible(false);
	}

	private void envoyerDonnéeSaisiesPension() {
		///-----------------------------------------ENVOYER les donnï¿½e saisies dans PENSION				BOUTON ENREGISTRER PENSION
			
			sql = "call updateParametres('"+tablePension.getValueAt(0,1).toString()+"','"+tablePension.getValueAt(6,1).toString()+"','"+tablePension.getValueAt(5,1).toString()+"','"+tablePension.getValueAt(7,1).toString()+"','"+tablePension.getValueAt(8,1).toString()+"','"+tablePension.getValueAt(9,1).toString()+"','"+uIdPension+"');";
			Tools.print(sql);
			
			
			Tools.print("enregistrer");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(host, bddUtilisateur, bddMdp);
				Statement stmt = con.createStatement();
				stmt.executeQuery(sql);
				Tools.print("____________________________________________[Update info de la pension]_________________________________________________");
					Tools.print("requï¿½te:  "+sql);

				} catch (Exception e1) {
				Tools.print("[envoyerDonnéeSaisiesPension]: [SQL ALERT] " + e1);
			}

			Tools.print("_____________________________________________________________________________________________________________________");
			Tools.print("");
	}
	
	private void sqlBoxVersTable(DefaultTableModel tableModel) {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
		
		BoxDAO boxDAO = new BoxDAO();
		
		try {
			boxes = boxDAO.getAll(uIdPension);
			
			for (Box box : boxes) {
				tableModel.addRow(new Object[] { box.getId(), box.getSuperficie(), box.getLibelle(), box.getTarif()});
			}
		} catch (SQLException e1) {
			System.err.print(e1.getMessage());
			e1.printStackTrace();
		}
	}

	private void deconnectionUtilisateur(JPanel __CardSelection__) {
		__CardSelection__.setVisible(false);
		CardLogin_.setVisible(true);
		ulogin.setText("");
		umdp.setText("");
	}

	private void fermerCardBox(JPanel __CardSelection__) {
		CardBox_.setVisible(false);
		__CardSelection__.setVisible(true);
	}

	private void addBoxAuTableau(DefaultTableModel tableModel) {
		try {
			boxDAO.add(new Box(nBoxType.getText(), uIdPension, Float.parseFloat(nBoxTaille.getText())));
			sqlBoxVersTable(tableModel);
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Tools.print("float exeption");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Tools.print("sql exeption");
		}
	}
}