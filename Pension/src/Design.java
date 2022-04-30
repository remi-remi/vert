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
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Canvas;
import javax.swing.JSeparator;

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
	private JTextField nBoxType;
	private JTextField nBoxTaille;

		 String bddUtilisateur="prof";
		 String bddMdp="prof_1234";
		 String host="jdbc:mysql://172.29.103.11:3306/vert";    /*3306 ou 8080 */
		 String sql;
		 int uIdPension=666;
		 public int nbBox=666;
		 private JTable tablePension;


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
    	setBackground(Color.WHITE);
    	
    	
		 JTable table = new JTable();
		 table.setBackground(new Color(224, 255, 255));
		 table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		 table.setFillsViewportHeight(true);
	     table.setBounds(78, 139, 405, 250);
	     DefaultTableModel tableModel = new DefaultTableModel(0, 0) {
	    	 @Override
	    	 public boolean isCellEditable(int line, int column) {
	    		 if(column == 0 || column == 3)
	    			 return false;
	    		 else
	    			 return true;
	    	 }
	     };

	    	   
	    	   
	     String header[] = new String[] {"id", "taille", "type","tarif"};
	     tableModel.setColumnIdentifiers(header);
	     table.setModel(tableModel);															
	     JScrollPane vneScrollPane = new JScrollPane(table);
	     vneScrollPane.setBounds(7, 40, 396, 305);
	     CardBox_.add(vneScrollPane);
	     
        setTitle("gestion pension box et gardiennage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 430, 435);
        
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
        boutonDeconnexion.setBounds(210, 85, 190, 145);
        __CardSelection__.add(boutonDeconnexion);
        
        JLabel bienvenue = new JLabel("bienvenue (ulogin)");
        bienvenue.setBackground(Color.LIGHT_GRAY);
        bienvenue.setOpaque(true);
        bienvenue.setHorizontalAlignment(SwingConstants.CENTER);
        bienvenue.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bienvenue.setBounds(10, 10, 390, 60);
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
        btnGP.setBounds(210, 242, 190, 145);
        __CardSelection__.add(btnGP);
        

        JButton btnGB = new JButton("gestion box");									
        btnGB.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));/*BOUTON BOX*/
        btnGB.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tableModel.getDataVector().removeAllElements();
        		tableModel.fireTableDataChanged();
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
        	              Tools.print("|--------------sql des box n: "+uIdPension+"--------------|");
        	              
        	    	   try {		/*                 \/                           <-  changer options SQL ici  */
        	    		   
        	    		   Tools.print("requete: "+sql);
        	               /*infoNomU.setText(ulogin.getText());*/
        	               Class.forName("com.mysql.jdbc.Driver");
        	               con=DriverManager.getConnection(host,bddUtilisateur,bddMdp);
        	               stmt=con.createStatement();
        	               rs=stmt.executeQuery(sql);
        	               int ligne=1;
        	               Tools.print("");
        				   while (rs.next()) {
        					   
        					   Tools.print("----ajout d'une ligne----|");
        					   

        		               tableModel.addRow(new Object[] {rs.getString(1),rs.getFloat(2),rs.getString(3),rs.getString(4),});
        		               Tools.print("id="+rs.getString(1)+" taille= "+rs.getFloat(2)+" gardiennage= "+rs.getString(3)+" prix= "+rs.getString(4));
        		               Tools.print("");
        		               ligne++;
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
        btnGB.setBounds(10, 85, 190, 145);
        __CardSelection__.add(btnGB);
        
        JButton btnGG = new JButton("gestion gardiennage");
        btnGG.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        btnGG.setActionCommand("gestion gardiennage");/*BOUTON GARDIENNAGE*/
        btnGG.setForeground(Color.BLACK);
        btnGG.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGG.setBackground(Color.ORANGE);
        btnGG.setBounds(10, 242, 190, 145);
        __CardSelection__.add(btnGG);
    
        CardLogin_ = new JPanel();
        CardLogin_.setBackground(Color.WHITE);
        CardLogin_.setLayout(null);
        contientTout.add(CardLogin_, "name_39649998733200");
        CardLogin_.setVisible(true);
        
        ulogin = new JTextField();
        ulogin.setColumns(10);
        ulogin.setBackground(Color.WHITE);
        ulogin.setBounds(12, 44, 120, 30);
        CardLogin_.add(ulogin);
        
        umdp = new JPasswordField();
        umdp.setBackground(Color.WHITE);
        umdp.setBounds(138, 44, 120, 30);
        CardLogin_.add(umdp);
        
        lblNewLabel = new JLabel("login");
        lblNewLabel.setBounds(12, 18, 46, 14);
        CardLogin_.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("mot de passe");
        lblNewLabel_1.setBounds(142, 18, 96, 14);
        CardLogin_.add(lblNewLabel_1);
        
        JLabel logintxt = new JLabel("");
        logintxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
        logintxt.setHorizontalAlignment(SwingConstants.CENTER);
        logintxt.setOpaque(true);
        logintxt.setBackground(Color.LIGHT_GRAY);
        logintxt.setForeground(new Color(255, 0, 0));
        logintxt.setBounds(12, 84, 394, 42);
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
        			 Tools.print(sql);
        			 sql="call getCon('"+ulogin.getText()+"','"+umdp.getText()+"');";
        			 
        			 
        			 Tools.print("infoNomU.setText(ulogin.getText());)");
                     /*infoNomU.setText(ulogin.getText());*/
                     Class.forName("com.mysql.jdbc.Driver");
                     Tools.print("Statement stmt=con.createStatement();"+"host = "+host+"SQL utilisateur = "+bddUtilisateur+"SQL mdp ="+bddMdp);
                     Connection con=DriverManager.getConnection(host,bddUtilisateur,bddMdp);
                     																				
                     Statement stmt=con.createStatement();
                     logintxt.setText(" L'identifiant ou le mot de passe est incorrect");
                     
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
        verif.setBounds(269, 30, 137, 42);
        CardLogin_.add(verif);

        
        CardInfo_ = new JPanel();									/*INFO sur la pension*/
        CardInfo_.setVisible(false);
        CardInfo_.setBackground(Color.WHITE);
        contientTout.add(CardInfo_, "name_39649989349900");
        CardInfo_.setLayout(null);
        
        bonjour = new JLabel("bonjour");
        bonjour.setBounds(425, 15, 46, 14);
        CardInfo_.add(bonjour);
        
        JButton btnNewButton = new JButton("editer les informations");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Tools.print("ligne ~365 action manquante : enregistrer");
        		sql="";														//--------------------Envoi des info de la pension vers le sql


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
        });
        btnNewButton.setBounds(197, 353, 212, 36);
        CardInfo_.add(btnNewButton);
        
        JButton pensionVersSelection = new JButton("retour");
        pensionVersSelection.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardInfo_.setVisible(false);
        		__CardSelection__.setVisible(true);
        		
        	}
        });
        
        pensionVersSelection.setBounds(318, 11, 89, 23);
        CardInfo_.add(pensionVersSelection);
        
        tablePension = new JTable();
        tablePension.setFont(new Font("Dialog", Font.PLAIN, 15));											//----------------prend les info de la pension pour les afficher--------------------
        

        
		 try {
			 Tools.print(sql);
			 sql="select * from pension where id='1';";

             Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection(host,bddUtilisateur,bddMdp);				
             Statement stmt=con.createStatement();
             ResultSet rs=stmt.executeQuery(sql);

             if(rs.next()) {

             }
             else {}
          }
		 catch(Exception e1) {};
        
        
        
        
        tablePension.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"nom de la pension", ""},
        		{"responsable", ""},
        		{"ville", ""},
        		{"adresse", null},
        		{"telephone", null},
        		{"nom dirigeant", ""},
        		{"adresse siege social", ""},
        		{"lien vers le logo", null},
        		{"prix vaccin", null},
        		{"prix vermifuge", null},
        	},
        	new String[] {
        		"nom", "valeur"
        	}
        )
   		        		
        		);
        tablePension.getColumnModel().getColumn(0).setPreferredWidth(181);
        tablePension.getColumnModel().getColumn(1).setPreferredWidth(272);

        	
        	
        	
   	     ;
        	
        ;
        tablePension.setBounds(12, 141, 394, 170);
        CardInfo_.add(tablePension);
        
        JLabel decoPension = new JLabel("N I F T Y");
        decoPension.setBackground(Color.GRAY);
        decoPension.setOpaque(true);
        decoPension.setHorizontalAlignment(SwingConstants.CENTER);
        decoPension.setFont(new Font("Dialog", Font.BOLD, 20));
        decoPension.setBounds(12, 55, 394, 74);
        CardInfo_.add(decoPension);
        CardInfo_.setVisible(false);

        
        contientTout.add(CardBox_, "name_278764592863900");
        CardBox_.setLayout(null);

        
        JLabel texte1 = new JLabel("liste des box:");
        texte1.setBounds(10, 4, 116, 22);
        CardBox_.add(texte1);
        
        JButton enegistrerBox = new JButton("enregistrer");
        enegistrerBox.setFont(new Font("Tahoma", Font.PLAIN, 10));
        enegistrerBox.setBounds(12, 367, 89, 22);
        enegistrerBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        																			///------------------------------recupération des box creation d'un objet

        	
        	ArrayList<Box> boxList =new ArrayList<>();
        	Tools.print("nbBox="+nbBox);
       		for(int i = 0; i<nbBox;i++){
       			int idTab =Integer.parseInt(table.getValueAt((i), 0).toString());
       			Float taille =Float.parseFloat(table.getValueAt((i), 1).toString());
       			String typeTab =table.getValueAt(i, 2).toString();
       			Float tailleTab =Float.parseFloat(table.getValueAt(i, 3).toString());
       			
       			boxList.add(new Box(idTab,taille.toString(),typeTab,tailleTab));

       			Tools.print("");
       			Tools.print("______________ligne de la box n: "+i+"____________________");
       			Tools.print("| id | taille | type           |tarif|");
       			Tools.print("| "+idTab+" | "+taille.toString()+"    |"+typeTab.toString()+"| "+tailleTab.toString()+" |");  	

				sql="CALL alterBox ("+idTab+", "+taille+",'"+typeTab+"' , "+tailleTab+")";														//--------------------objet part vers SQL


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
        texte2.setBounds(121, 8, 135, 14);
        CardBox_.add(texte2);
        
        JButton ajouterBox = new JButton("ajouter box");
        ajouterBox.setHorizontalAlignment(SwingConstants.LEFT);
        ajouterBox.setFont(new Font("Tahoma", Font.PLAIN, 10));
        ajouterBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {											                                    //-----------------------AddBox
        		
   
				sql="call addBox (oLibelle varchar(30), oIdPension int, oSuperficie float);";
				sql="call addBox ('"+nBoxType.getText()+"', '"+uIdPension+"', '"+nBoxTaille.getText()+"');";


				Connection con;
				try {
					con = DriverManager.getConnection(host,bddUtilisateur,bddMdp);
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					nbBox++;
			Tools.print("requéte:  "+sql);
				} catch (SQLException e1) {
					Tools.print("ERREUR ! dans la requéte:  "+sql);
					e1.printStackTrace();
				}
        		
        	}
        });

        ajouterBox.setBounds(316, 366, 89, 23);
        CardBox_.add(ajouterBox);
        
        JButton retourGestionBox = new JButton("retour");
        retourGestionBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {  		

        		CardBox_.setVisible(false);
        		__CardSelection__.setVisible(true);
        		
        	}
        });
        
        retourGestionBox.setBounds(316, 5, 89, 23);
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
        CardBox_.add(lblType);}	
}