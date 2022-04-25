import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import java.awt.Window.Type;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Canvas;

/*https://www.tutorialsfield.com/how-to-connect-mysql-database-in-java-using-eclipse/*/

public class Design extends JFrame {

    /**
	 * 
	 */
	JPanel CardBox_ = new JPanel();
	
	private JPanel contientTout;
    private JPanel CardInfo_;
    private JPanel CardLogin_;
    
    private JTextField ulogin;
    private JPasswordField umdp;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JButton verif;
    private JLabel bonjour;
    private JLabel infoNomU;
    private JButton ba;
    private JLabel actuelAdmin;
    private JLabel infoNomPen;
	private JTextField textField;
	private JTextField textField_1;

		 String bddUtilisateur="prof";
		 String bddMdp="prof_1234";
		 String host="jdbc:mysql://192.168.1.49:3306/vert";    /* ou 8080 */
		 String sql;
		 int uIdPension=666;
		 public int nbBox=2;


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
    	setForeground(new Color(255, 215, 0));
    	setBackground(new Color(255, 0, 0));
    	
    	
		 JTable table = new JTable();
		 table.setBackground(new Color(224, 255, 255));
		 table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		 table.setFillsViewportHeight(true);
	     table.setBounds(10, 29, 343, 238);
	     DefaultTableModel dtm = new DefaultTableModel(0, 0);
	     CardBox_.add(table);
	     String header[] = new String[] {"id", "taille", "type","tarif"};																	         
	     dtm.setColumnIdentifiers(header);
	     table.setModel(dtm);															
	     
	     
	     
        setTitle("gestion pension box et gardiennage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 389, 380);
        
        contientTout = new JPanel();												/*CONTIENT TOUT*/
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
        		__CardSelection__.setVisible(false);
        		CardLogin_.setVisible(true);
        		ulogin.setText("");
        		umdp.setText("");
        		
        	}
        });
        boutonDeconnexion.setBounds(188, 79, 165, 115);
        __CardSelection__.add(boutonDeconnexion);
        
        JLabel bienvenue = new JLabel("bienvenue (ulogin)");
        bienvenue.setBackground(Color.LIGHT_GRAY);
        bienvenue.setOpaque(true);
        bienvenue.setHorizontalAlignment(SwingConstants.CENTER);
        bienvenue.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bienvenue.setBounds(10, 11, 343, 57);
        __CardSelection__.add(bienvenue);
        
        JButton btnGP = new JButton("gestion pension");							
        btnGP.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));/*BOUTON GESTION PENSION*/
        btnGP.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardInfo_.setVisible(true);
        		__CardSelection__.setVisible(false);
        	}
        });
        btnGP.setForeground(new Color(0, 0, 0));
        btnGP.setBackground(new Color(176,224,230));
        btnGP.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGP.setBounds(188, 205, 165, 115);
        __CardSelection__.add(btnGP);
        

        JButton btnGB = new JButton("gestion box");									
        btnGB.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));/*BOUTON BOX*/
        btnGB.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dtm.getDataVector().removeAllElements();
        		dtm.fireTableDataChanged();
        		CardBox_.setVisible(true);
        		__CardSelection__.setVisible(false);
        	
        	Tools.print("");
        	Tools.print("|______________________SQL_____________________|");
        	Tools.print("|info sql: host="+host);
        	Tools.print("|user="+bddUtilisateur+" mdp= "+bddMdp);
        	Tools.print("|______________________________________________|");
        	Tools.print("");
        	Tools.print("");


        	              String sql;
        	              sql="call getBoxNombre("+uIdPension+");";
        	              Connection con;
        	              Statement stmt;
        	              ResultSet rs;

        				try {
        					con = DriverManager.getConnection(host,bddUtilisateur,bddMdp);
        		              stmt=con.createStatement();
        		              rs=stmt.executeQuery(sql);
        		              while(rs.next()) {
        		            	 /*nbBox=rs.getInt(1);*/
Tools.print("execution sql: "+sql);
Tools.print("nb de box de cette pension: "+rs.getInt(1));
							  nbBox=rs.getInt(1);
        		              }

        				} catch (SQLException e2) {
Tools.print("ERREUR SQL : "+e2);
        					e2.printStackTrace();
        				}
        	              
        	              sql="call getBox("+uIdPension+");";
        	              
Tools.print("");
Tools.print("|--------------sql des box n° "+uIdPension+"--------------|");
        	    	   try {		/*                 \/                           <-  changer options SQL ici  */
Tools.print("requete: "+sql);
        	               infoNomU.setText(ulogin.getText());
        	               Class.forName("com.mysql.jdbc.Driver").newInstance();
        	               con=DriverManager.getConnection(host,bddUtilisateur,bddMdp);
        	               stmt=con.createStatement();
        	               rs=stmt.executeQuery(sql);
        	               										
Tools.print("");
        				   while (rs.next()) {
        					   
Tools.print("----ajout d'une ligne----|");
							
        		               dtm.addRow(new Object[] {rs.getString(1),rs.getFloat(2),rs.getString(3),rs.getString(4),});
Tools.print("id="+rs.getString(1)+" taille= "+rs.getFloat(2)+" gardiennage= "+rs.getString(3)+" prix= "+rs.getString(4));
Tools.print("");
        			        }
Tools.print("-------------------------|");

        	    	   }
        	    	   		catch(Exception e1) {
        	               };
Tools.print("");
Tools.print("|---------------------------------------------|");
Tools.print("");
Tools.print("");

        	}
        });
        
        btnGB.setForeground(Color.BLACK);
        btnGB.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGB.setBackground(new Color(152, 251, 152));
        btnGB.setBounds(10, 79, 165, 115);
        __CardSelection__.add(btnGB);
        
        JButton btnGG = new JButton("gestion gardiennage");
        btnGG.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        btnGG.setActionCommand("gestion gardiennage");/*BOUTON GARDIENNAGE*/
        btnGG.setForeground(Color.BLACK);
        btnGG.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGG.setBackground(Color.ORANGE);
        btnGG.setBounds(10, 205, 165, 115);
        __CardSelection__.add(btnGG);
    
        CardLogin_ = new JPanel();
        CardLogin_.setBackground(Color.WHITE);
        CardLogin_.setLayout(null);
        contientTout.add(CardLogin_, "name_39649998733200");
        CardLogin_.setVisible(true);
        
        ulogin = new JTextField();
        ulogin.setColumns(10);
        ulogin.setBackground(Color.WHITE);
        ulogin.setBounds(10, 36, 100, 20);
        CardLogin_.add(ulogin);
        
        umdp = new JPasswordField();
        umdp.setBackground(Color.WHITE);
        umdp.setBounds(120, 36, 100, 20);
        CardLogin_.add(umdp);
        
        lblNewLabel = new JLabel("login");
        lblNewLabel.setBounds(10, 11, 46, 14);
        CardLogin_.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("mot de passe");
        lblNewLabel_1.setBounds(120, 11, 96, 14);
        CardLogin_.add(lblNewLabel_1);
        
        JLabel logintxt = new JLabel("");
        logintxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
        logintxt.setHorizontalAlignment(SwingConstants.CENTER);
        logintxt.setOpaque(true);
        logintxt.setBackground(Color.LIGHT_GRAY);
        logintxt.setForeground(new Color(255, 0, 0));
        logintxt.setBounds(10, 67, 343, 42);
        CardLogin_.add(logintxt);
        
        verif = new JButton("connecter");
        verif.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		/* AUTO CON !!! -------------------------------------------------------------------------------------------------------------------------------------------!!!!!!!!!!!!!-
      		
        		*/ulogin.setText("remi3");
        		umdp.setText("1234");
        		Tools.print("|AUTO CON ACTIF !!!|");

        	    /*AUTO CON !!! -------------------------------------------------------------------------------------------------------------------------------------------!!!!!!!!!!!!!-*/
        		
        		
        		
        		 try {		/*                 \/                           <-  changer options SQL ici  */
        			 String bddUtilisateur="prof";
        			 String bddMdp="prof_1234";
        			 String host="jdbc:mysql://192.168.1.49:3306/vert";    /* ou 8080 */
        			 sql="call getCon('"+ulogin.getText()+"','"+umdp.getText()+"');";
        			 
        			 
Tools.print("infoNomU.setText(ulogin.getText());)");
                     infoNomU.setText(ulogin.getText());
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
Tools.print("Statement stmt=con.createStatement();"+"host = "+host+"SQL utilisateur = "+bddUtilisateur+"SQL mdp ="+bddMdp);
                     Connection con=DriverManager.getConnection(host,bddUtilisateur,bddMdp); 			/* ou 8080*/
                     																				
                     Statement stmt=con.createStatement();
                     logintxt.setText(" L’identifiant ou le mot de passe est incorrect");
                     
                     ResultSet rs=stmt.executeQuery(sql);
                     
Tools.print("authentification de lutilisateur en sql="+sql);


                     if(rs.next()) {
                     uIdPension=rs.getInt(11);
Tools.print("nb de la pension: "+uIdPension);
                     bienvenue.setText("Bienvenue "+ulogin.getText()); 			/*texte de l'écrant de séléction*/
                     verif.setText("OK");
                     CardLogin_.setVisible(false);
             		 __CardSelection__.setVisible(true);
                     }
                     else {
                     
                     }
                  }
        		 catch(Exception e1) {};
                 
        		
        	}
        });
        verif.setBounds(253, 35, 100, 23);
        CardLogin_.add(verif);

        
        CardInfo_ = new JPanel();									/*INFO sur la pension*/
        CardInfo_.setVisible(false);
        CardInfo_.setBackground(Color.WHITE);
        contientTout.add(CardInfo_, "name_39649989349900");
        CardInfo_.setLayout(null);
        
        bonjour = new JLabel("bonjour");
        bonjour.setBounds(425, 15, 46, 14);
        CardInfo_.add(bonjour);
        
        infoNomU = new JLabel("Responsable:");
        infoNomU.setBounds(10, 36, 75, 14);
        CardInfo_.add(infoNomU);
        
        ba = new JButton("admin?");
        ba.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
								
        	}
        });
        
        ba.setBounds(481, 11, 101, 23);
        CardInfo_.add(ba);
        
        actuelAdmin = new JLabel("jacki chan");
        actuelAdmin.setBounds(142, 36, 517, 14);
        CardInfo_.add(actuelAdmin);
        
        JLabel infoVille = new JLabel("ville:");
        infoVille.setBounds(10, 61, 46, 14);
        CardInfo_.add(infoVille);
        
        JLabel actuelVille = new JLabel("paris");
        actuelVille.setBounds(142, 61, 46, 14);
        CardInfo_.add(actuelVille);
        
        JLabel infoAdresse = new JLabel("adresse:");
        infoAdresse.setBounds(10, 86, 46, 14);
        CardInfo_.add(infoAdresse);
        
        JLabel actuelAdresse = new JLabel("10 rue de paris");
        actuelAdresse.setBounds(142, 86, 116, 14);
        CardInfo_.add(actuelAdresse);
        
        JLabel infoTel = new JLabel("telephone:");
        infoTel.setBounds(10, 111, 75, 14);
        CardInfo_.add(infoTel);
        
        JLabel actuelNum = new JLabel("06 06 06 06 06");
        actuelNum.setBounds(142, 111, 116, 14);
        CardInfo_.add(actuelNum);
        
        infoNomPen = new JLabel("Nom de la pension:");
        infoNomPen.setBounds(10, 136, 101, 14);
        CardInfo_.add(infoNomPen);
        
        JLabel actuelNomPen = new JLabel("pension de la seine");
        actuelNomPen.setBounds(142, 136, 116, 14);
        CardInfo_.add(actuelNomPen);
        
        JLabel infoAdresseSi = new JLabel("adresse siege:");
        infoAdresseSi.setBounds(10, 161, 101, 14);
        CardInfo_.add(infoAdresseSi);
        
        JLabel actuelSiege = new JLabel("9 rue de paris");
        actuelSiege.setBounds(142, 161, 116, 14);
        CardInfo_.add(actuelSiege);
        
        JLabel infoLienLo = new JLabel("Lien logo:");
        infoLienLo.setBounds(10, 186, 101, 14);
        CardInfo_.add(infoLienLo);
        
        JLabel actuelLienLo = new JLabel("vert.com/ressources/logo.png");
        actuelLienLo.setBounds(142, 186, 145, 14);
        CardInfo_.add(actuelLienLo);
        
        JLabel infoPrixVa = new JLabel("prix par vaccin:");
        infoPrixVa.setBounds(10, 211, 101, 14);
        CardInfo_.add(infoPrixVa);
        
        JLabel infoPrixVer = new JLabel("prix par vermifuge:");
        infoPrixVer.setBounds(10, 236, 101, 14);
        CardInfo_.add(infoPrixVer);
        
        JLabel actuelPrixVa = new JLabel("6.5");
        actuelPrixVa.setBounds(142, 211, 46, 14);
        CardInfo_.add(actuelPrixVa);
        
        JLabel actuelPrixVer = new JLabel("5.6");
        actuelPrixVer.setBounds(142, 236, 46, 14);
        CardInfo_.add(actuelPrixVer);
        
        JButton btnNewButton = new JButton("editer les informations");
        btnNewButton.setBounds(80, 297, 178, 23);
        CardInfo_.add(btnNewButton);
        
        JButton pensionVersSelection = new JButton("retour");
        pensionVersSelection.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardInfo_.setVisible(false);
        		__CardSelection__.setVisible(true);
        		
        	}
        });
        pensionVersSelection.setBounds(264, 11, 89, 23);
        CardInfo_.add(pensionVersSelection);
        CardInfo_.setVisible(false);

        
        
        contientTout.add(CardBox_, "name_278764592863900");
        CardBox_.setLayout(null);



        
        JLabel texte1 = new JLabel("liste des box:");
        texte1.setBounds(10, 4, 89, 22);
        CardBox_.add(texte1);
        
        JButton enegistrerBox = new JButton("enregistrer");
        enegistrerBox.setFont(new Font("Tahoma", Font.PLAIN, 10));
        enegistrerBox.setBounds(10, 308, 89, 23);
        enegistrerBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        																			///------------------------------recupération des box creation d'un objet

        	float ft=1.991f;
        	
        	ArrayList<Box> boxList =new ArrayList<>();
        	Tools.print("nbBox="+nbBox);
       		for(int i = 0; i<nbBox;i++){
       			int idTab =Integer.parseInt(table.getValueAt((i), 0).toString());
       			Float taille =Float.parseFloat(table.getValueAt((i), 1).toString());
       			String typeTab =table.getValueAt(i, 2).toString();
       			Float tailleTab =Float.parseFloat(table.getValueAt(i, 3).toString());
       			Integer a=1;
       			
       			boxList.add(new Box(idTab,taille.toString(),typeTab,tailleTab));

Tools.print("");
Tools.print("______________ligne de la box n: "+i+"____________________");

Tools.print("| id | taille | type           |tarif|");
Tools.print("| "+idTab+" | "+taille.toString()+"    |"+typeTab.toString()+"| "+tailleTab.toString()+" |");  	




			String test;
				test=boxList.get(0).getSQL();

				sql="CALL alterBox ("+idTab+", "+taille+",'"+typeTab+"' , "+tailleTab+")";																										//--------------------objet part vers SQL
				//sql="CALL alterBox (int id, taille float, libelle char, prix double)";

				Connection con;
				try {
					con = DriverManager.getConnection(host,bddUtilisateur,bddMdp);
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(sql);


					PreparedStatement preparedStatement = con.prepareStatement(sql);
					/*preparedStatement.setInt(1, id);*/
		/*ResultSet resultSet = */
		preparedStatement.executeQuery();
		Tools.print("requéte:  "+sql);
				} catch (SQLException e1) {
					Tools.print("ERREUR ! dans la requéte:  "+sql);
					e1.printStackTrace();
				} 
				
       		}
Tools.print("______________________________________________________");



        	}
        });
		      		
        CardBox_.add(enegistrerBox);
        
        JLabel texte2 = new JLabel("pension de paris");
        texte2.setBounds(87, 8, 135, 14);
        CardBox_.add(texte2);
        
        JButton ajouterBox = new JButton("ajouter une ligne");
        ajouterBox.setHorizontalAlignment(SwingConstants.LEFT);
        ajouterBox.setFont(new Font("Tahoma", Font.PLAIN, 10));
        ajouterBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        	}
        });

        ajouterBox.setBounds(237, 278, 116, 23);
        CardBox_.add(ajouterBox);
        
        JButton retourGestionBox = new JButton("retour");
        retourGestionBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {  		

        		CardBox_.setVisible(false);
        		__CardSelection__.setVisible(true);
        		
        	}
        });
        retourGestionBox.setBounds(274, 4, 89, 23);
        CardBox_.add(retourGestionBox);
        
        textField = new JTextField();
        textField.setBounds(10, 279, 86, 20);
        CardBox_.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(106, 279, 86, 20);
        CardBox_.add(textField_1);
        textField_1.setColumns(10);}	
}