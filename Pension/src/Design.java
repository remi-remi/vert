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
    private JTextField debug;
    private JTextField textField;
    private JLabel infoNomPen;
    private JTable table;
    private JTable table_1;
		 String bddUtilisateur="prof";
		 String bddMdp="prof_1234";
		 String host="jdbc:mysql://192.168.1.49:3306/vert";    /* ou 8080 */
		 String sql="call getCon ('remi55','1234');";
		 private JTextField debug2;

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
        setTitle("gestion pension box et gardiennage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 992, 351);
        
        contientTout = new JPanel();												/*CONTIENT TOUT*/
        contientTout.setBackground(Color.BLUE);
        contientTout.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contientTout);
        contientTout.setLayout(new CardLayout(0, 0));
        
        JPanel __CardSelection__ = new JPanel();
        __CardSelection__.setVisible(false);
        contientTout.add(__CardSelection__, "name_273988110161100");
        __CardSelection__.setLayout(null);
        
        JButton deconnexion = new JButton("d\u00E9connexion");
        deconnexion.setForeground(Color.BLACK);
        deconnexion.setFont(new Font("Tahoma", Font.PLAIN, 15));
        deconnexion.setBackground(new Color(255, 102, 102));
        deconnexion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		__CardSelection__.setVisible(false);
        		CardLogin_.setVisible(true);
        		ulogin.setText("");
        		umdp.setText("");
        		
        	}
        });
        deconnexion.setBounds(195, 42, 175, 83);
        __CardSelection__.add(deconnexion);
        
        JLabel bienvenue = new JLabel("bienvenue (ulogin)");
        bienvenue.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bienvenue.setBounds(10, 10, 356, 21);
        __CardSelection__.add(bienvenue);
        
        JButton btnGP = new JButton("gestion de la pension");							/*BOUTON GESTION PENSION*/
        btnGP.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardInfo_.setVisible(true);
        		__CardSelection__.setVisible(false);
        	}
        });
        btnGP.setForeground(new Color(0, 0, 0));
        btnGP.setBackground(new Color(152, 251, 152));
        btnGP.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGP.setBounds(195, 136, 175, 83);
        __CardSelection__.add(btnGP);
        
        
        
        JButton btnGB = new JButton("gestion des box");									/*BOUTON BOX*/
        btnGB.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardBox_.setVisible(true);
        		__CardSelection__.setVisible(false);
        	}
        });
        btnGB.setForeground(Color.BLACK);
        btnGB.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGB.setBackground(new Color(176, 224, 230));
        btnGB.setBounds(10, 42, 175, 83);
        __CardSelection__.add(btnGB);
        
        JButton btnGG = new JButton("gestion gardiennage");							
        btnGG.setActionCommand("gestion gardiennage");/*BOUTON GARDIENNAGE*/
        btnGG.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		
        		
        	}
        });
        btnGG.setForeground(Color.BLACK);
        btnGG.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGG.setBackground(Color.ORANGE);
        btnGG.setBounds(10, 136, 175, 83);
        __CardSelection__.add(btnGG);
    
    
        CardLogin_ = new JPanel();
        CardLogin_.setBackground(Color.WHITE);
        CardLogin_.setLayout(null);
        contientTout.add(CardLogin_, "name_39649998733200");
        CardLogin_.setVisible(true);
        
        ulogin = new JTextField();
        ulogin.setColumns(10);
        ulogin.setBackground(Color.WHITE);
        ulogin.setBounds(10, 36, 86, 20);
        CardLogin_.add(ulogin);
        
        umdp = new JPasswordField();
        umdp.setBackground(Color.WHITE);
        umdp.setBounds(106, 36, 86, 20);
        CardLogin_.add(umdp);
        
        lblNewLabel = new JLabel("login");
        lblNewLabel.setBounds(10, 11, 46, 14);
        CardLogin_.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("mot de passe");
        lblNewLabel_1.setBounds(106, 11, 96, 14);
        CardLogin_.add(lblNewLabel_1);
        
        JLabel logintxt = new JLabel("placeholder-----------------------------------------------------------------------------------------------------------------------------------");
        logintxt.setBackground(Color.BLACK);
        logintxt.setForeground(Color.RED);
        logintxt.setBounds(10, 67, 301, 42);
        CardLogin_.add(logintxt);
        
        verif = new JButton("connecter");
        verif.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		/* AUTO CON !!! -------------------------------------------------------------------------------------------------------------------------------------------!!!!!!!!!!!!!-
        		
        		ulogin.setText("remi3");
        		umdp.setText("1234");
        		System.out.println("|AUTO CON ACTIF !!!|");

        	    AUTO CON !!! -------------------------------------------------------------------------------------------------------------------------------------------!!!!!!!!!!!!!-*/
        		
        		
        		
        		 try {		/*                 \/                           <-  changer options SQL ici  */
        			 String bddUtilisateur="prof";
        			 String bddMdp="prof_1234";
        			 String host="jdbc:mysql://192.168.1.49:3306/vert";    /* ou 8080 */
        			 sql="call getCon('"+ulogin.getText()+"','"+umdp.getText()+"');";
        			 
System.out.println("infoNomU.setText(ulogin.getText());)");
                     infoNomU.setText(ulogin.getText());
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
System.out.println("Statement stmt=con.createStatement();"+"host = "+host+"SQL utilisateur = "+bddUtilisateur+"SQL mdp ="+bddMdp);
                     Connection con=DriverManager.getConnection(host,bddUtilisateur,bddMdp); 			/* ou 8080*/
                     																				
                     Statement stmt=con.createStatement();
                     logintxt.setText(" L’identifiant ou le mot de passe est incorrect");
                     
                     ResultSet rs=stmt.executeQuery(sql);
System.out.println("sql="+sql);
                     if(rs.next()) {
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
        verif.setBounds(202, 35, 109, 23);
        CardLogin_.add(verif);
        
        JButton btnNewButton_3 = new JButton("test envoi");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		try {		/*                 \/                           <-  changer options SQL ici  */
          			 String bddUtilisateur="prof";
          			 String bddMdp="prof_1234";
          			 String host="jdbc:mysql://192.168.1.49:3306/vert";    /* ou 8080 */
          			 String sql="call getCon ('remi55','1234');";
                       																				debug.setText("Class.forName(\"com.mysql.jdbc.Driver\").newInstance();");
                       Class.forName("com.mysql.jdbc.Driver").newInstance();
                       																				debug.setText("erreur config con sql");
                       Connection con=DriverManager.getConnection(host,bddUtilisateur,bddMdp); 			/* ou 8080*/
                       																				debug.setText("erreur L 262 Statement stmt=con.createStatement();");
                       Statement stmt=con.createStatement();
                       
                       																				debug.setText("erreur L228 dans: la requéte:  "+sql);
                       stmt.executeQuery(sql);
                       																				debug.setText("erreur dans: resultset");
                       ResultSet rs=stmt.executeQuery("call getCon ('remi55','1234');");
                       																		debug.setText("erreur dans: if");
                 	      if (rs.wasNull()) {
                 	    	  debug.setText("null");
                 	      }

							debug.setText("precedant:  "+debug.getText()+" ACTUEL non non null");
                       
                       																				
                   }catch(Exception e1) {
																	debug.setText("plantage?");
                   };
        		
        		
        }
        }
        
        );
        btnNewButton_3.setBounds(321, 35, 89, 23);
        CardLogin_.add(btnNewButton_3);
        
        debug = new JTextField();
        debug.setHorizontalAlignment(SwingConstants.CENTER);
        debug.setText("----------------------------debugage----------------------------");
        debug.setForeground(Color.BLUE);
        debug.setBackground(Color.LIGHT_GRAY);
        debug.setBounds(10, 67, 1179, 42);
        CardLogin_.add(debug);
        debug.setColumns(10);

        
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
        
        JLabel actuelNomPen = new JLabel("pensionde la seine");
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
        btnNewButton.setBounds(36, 261, 178, 23);
        CardInfo_.add(btnNewButton);
        
        JButton pensionVersSelection = new JButton("retour");
        pensionVersSelection.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardInfo_.setVisible(false);
        		__CardSelection__.setVisible(true);
        		
        	}
        });
        pensionVersSelection.setBounds(326, 11, 89, 23);
        CardInfo_.add(pensionVersSelection);
        CardInfo_.setVisible(false);

        
        
        contientTout.add(CardBox_, "name_278764592863900");
        CardBox_.setLayout(null);



        
        JLabel texte1 = new JLabel("liste des box de la pension:");
        texte1.setBounds(10, 21, 153, 22);
        CardBox_.add(texte1);
        
        JButton enegistrerBox = new JButton("enregistrer");
        enegistrerBox.setBounds(10, 258, 89, 23);
        enegistrerBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        CardBox_.add(enegistrerBox);
        
        JLabel texte2 = new JLabel("pension de paris");
        texte2.setBounds(178, 25, 127, 14);
        CardBox_.add(texte2);
        
        JButton ajouterBox = new JButton("ajouter une ligne");
        ajouterBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        	}
        });

        	
        	


        ajouterBox.setBounds(118, 258, 152, 23);
        CardBox_.add(ajouterBox);
        
        textField = new JTextField();
        textField.setBounds(689, 76, 86, 20);
        CardBox_.add(textField);
        textField.setColumns(10);
        
        JButton retourGestionBox = new JButton("retour");
        retourGestionBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardBox_.setVisible(false);
        		__CardSelection__.setVisible(true);
        		
        	}
        });
        retourGestionBox.setBounds(493, 0, 89, 23);
        CardBox_.add(retourGestionBox);
        
        debug2 = new JTextField();
        debug2.setBounds(218, 227, 738, 20);
        CardBox_.add(debug2);
        debug2.setColumns(10);
        
        

        																		// create object of table and table model
        JTable table = new JTable();
        table.setBounds(20, 54, 422, 161);
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        CardBox_.add(table);
        																		// add header of the table
String header[] = new String[] { "id", "type", "superficie" };
       																			// add header in table model     
        dtm.setColumnIdentifiers(header);
        																		//set model into the table object
              table.setModel(dtm);
              																	// add row dynamically into the table              
System.out.println("|______________________SQL_____________________|");
System.out.println("|info sql: host="+host);
System.out.println("|user="+bddUtilisateur+" mdp= "+bddMdp);
System.out.println("|______________________________________________|");
System.out.println("");
System.out.println("");
System.out.println("");

              
              int idBox=0;
       for (int count = 1; count <= 6; count++) {

    	   idBox ++;
   		
System.out.println("|--------------Boucle sql box n°"+idBox+"--------------|");
    	   try {		/*                 \/                           <-  changer options SQL ici  */

    		   String sql="select * from box where id='"+idBox+"';";

System.out.println("requete: "+sql);
System.out.println("idBox :"+idBox);

               infoNomU.setText(ulogin.getText());
               Class.forName("com.mysql.jdbc.Driver").newInstance();
               Connection con=DriverManager.getConnection(host,bddUtilisateur,bddMdp); 			/* ou 8080*/
               Statement stmt=con.createStatement();
               ResultSet rs=stmt.executeQuery(sql);
               										
System.out.println("---recup info: ");

			   while (rs.next()) {
System.out.println(" ajout d'une ligne");
	               dtm.addRow(new Object[] {rs.getInt(1),rs.getInt(2),rs.getInt(3),});
	               System.out.println("id="+rs.getInt(1)+" id gardiennage= "+rs.getInt(2)+" idpension= "+rs.getInt(3));
		        }
System.out.println("---fin recup ");
               		debug2.setText(debug2.getText()+"idBox"); 
System.out.println("fin du try catch");
               		
               if(rs.next()) {
            	   
               }
               else {}
               }catch(Exception e1) {
System.out.println("erreur= "+e1);
               };

System.out.println("|----------------------------------------------|");
System.out.println("");
System.out.println("");
System.out.println("");

       }
        }
    }	




