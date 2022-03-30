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

/*https://www.tutorialsfield.com/how-to-connect-mysql-database-in-java-using-eclipse/*/

public class Design extends JFrame {

    /**
	 * 
	 */
	private JPanel contientTout;
    private JPanel info;
    private JPanel loginpanel;
    private JTextField ulogin;
    private JPasswordField umdp;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JButton verif;
    private JLabel debug;
    private JLabel bonjour;
    private JLabel nomU;
    private JButton ba;
    private JLabel adminlabel;
    private JTable table;

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
        setTitle("formulaire de connection");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 618, 484);
        contientTout = new JPanel();
        contientTout.setBackground(Color.RED);
        contientTout.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contientTout);
        contientTout.setLayout(new CardLayout(0, 0));
        
        info = new JPanel();
        info.setBackground(Color.WHITE);
        contientTout.add(info, "name_39649989349900");
        info.setLayout(null);
        
        bonjour = new JLabel("bonjour");
        bonjour.setBounds(425, 15, 46, 14);
        info.add(bonjour);
        
        nomU = new JLabel("Responsable:");
        nomU.setBounds(10, 36, 75, 14);
        info.add(nomU);
        
        ba = new JButton("admin?");
        ba.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 try {
						
						
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/condb","root","root");
						
						Statement stmt=con.createStatement();
						
						String sql="select admin from login where utilisateur='"+ulogin.getText()+"'";
						
						ResultSet rs=stmt.executeQuery(sql);
						if(rs.next()) {
							String eee = rs.getString("Place1");
							adminlabel.setText((eee));
						}
						else {};


        		 }catch(Exception e1) {};
        		
        	}
        });
        ba.setBounds(481, 11, 101, 23);
        info.add(ba);
        
        adminlabel = new JLabel("jacki chan");
        adminlabel.setBounds(142, 36, 517, 14);
        info.add(adminlabel);
        
        JLabel lblNewLabel_2 = new JLabel("ville:");
        lblNewLabel_2.setBounds(10, 61, 46, 14);
        info.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("paris");
        lblNewLabel_3.setBounds(142, 61, 46, 14);
        info.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("adresse:");
        lblNewLabel_4.setBounds(10, 86, 46, 14);
        info.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("10 rue de paris");
        lblNewLabel_5.setBounds(142, 86, 116, 14);
        info.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("telephone:");
        lblNewLabel_6.setBounds(10, 111, 75, 14);
        info.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("06 06 06 06 06");
        lblNewLabel_7.setBounds(142, 111, 116, 14);
        info.add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("Nom de la pension:");
        lblNewLabel_8.setBounds(10, 136, 101, 14);
        info.add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("pensionde la seine");
        lblNewLabel_9.setBounds(142, 136, 116, 14);
        info.add(lblNewLabel_9);
        
        JLabel lblNewLabel_10 = new JLabel("adresse siege:");
        lblNewLabel_10.setBounds(10, 161, 101, 14);
        info.add(lblNewLabel_10);
        
        JLabel lblNewLabel_11 = new JLabel("9 rue de paris");
        lblNewLabel_11.setBounds(142, 161, 116, 14);
        info.add(lblNewLabel_11);
        
        JLabel lblNewLabel_12 = new JLabel("Lien logo:");
        lblNewLabel_12.setBounds(10, 186, 101, 14);
        info.add(lblNewLabel_12);
        
        JLabel lblNewLabel_13 = new JLabel("vert.com/ressources/logo.png");
        lblNewLabel_13.setBounds(142, 186, 145, 14);
        info.add(lblNewLabel_13);
        
        JLabel lblNewLabel_14 = new JLabel("prix par vaccin:");
        lblNewLabel_14.setBounds(10, 211, 101, 14);
        info.add(lblNewLabel_14);
        
        JLabel lblNewLabel_15 = new JLabel("prix par vermifuge:");
        lblNewLabel_15.setBounds(10, 236, 101, 14);
        info.add(lblNewLabel_15);
        
        JLabel lblNewLabel_16 = new JLabel("6.5");
        lblNewLabel_16.setBounds(142, 211, 46, 14);
        info.add(lblNewLabel_16);
        
        JLabel lblNewLabel_17 = new JLabel("5.6");
        lblNewLabel_17.setBounds(142, 236, 46, 14);
        info.add(lblNewLabel_17);
        
        JButton btnNewButton = new JButton("editer les informations");
        btnNewButton.setBounds(36, 261, 178, 23);
        info.add(btnNewButton);
        info.setVisible(false);
        
        loginpanel = new JPanel();
        loginpanel.setBackground(Color.LIGHT_GRAY);
        loginpanel.setLayout(null);
        contientTout.add(loginpanel, "name_39649998733200");
        loginpanel.setVisible(true);
        
        ulogin = new JTextField();
        ulogin.setColumns(10);
        ulogin.setBackground(Color.WHITE);
        ulogin.setBounds(10, 36, 86, 20);
        loginpanel.add(ulogin);
        
        umdp = new JPasswordField();
        umdp.setBackground(Color.WHITE);
        umdp.setBounds(106, 36, 86, 20);
        loginpanel.add(umdp);
        
        lblNewLabel = new JLabel("login");
        lblNewLabel.setBounds(10, 11, 46, 14);
        loginpanel.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("mot de passe");
        lblNewLabel_1.setBounds(106, 11, 96, 14);
        loginpanel.add(lblNewLabel_1);
        
        verif = new JButton("connecter");
        verif.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		loginpanel.setVisible(false);

        		 try {
                     											debug.setText("Class.forName(\"com.mysql.jdbc.Driver\").newInstance();");
                     nomU.setText(ulogin.getText());
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     											debug.setText("con=DriverManager.getConnection(\"jdbc:mysql://localhost:8080/condb\",\"root\",\"root\")");
                     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/condb","root","root"); /* ou 8080*/
                     											debug.setText("Statement stmt=con.createStatement();");
                     Statement stmt=con.createStatement();
                     											debug.setText("\"select * from login where utilisateur='\"+ulogin+\"' and mdp='\"+umdp+\"'\";");
                     String sql="select * from login where utilisateur='"+ulogin.getText()+"' and mdp='"+umdp.getText()+"'";
                     ResultSet rs=stmt.executeQuery(sql);
                     debug.setText("OK!");
                     if(rs.next()) {
                     verif.setText("OK!");
                     }
                     else
                     verif.setText("erreur : / ");
                     
                 }catch(Exception e1) {};
                 
        		
        	}
        });
        verif.setBounds(202, 35, 85, 23);
        loginpanel.add(verif);
        
        debug = new JLabel("");
        debug.setBounds(10, 67, 277, 20);
        loginpanel.add(debug);
        
        JPanel panel = new JPanel();
        contientTout.add(panel, "name_6630839708200");
        panel.setLayout(null);
        
        table = new JTable();
        JTable table = new JTable(new DefaultTableModel(
        	new Object[][] {
        		{"type de gardiennage", "id","superficie"},
        		{"interieur", "1","5.6"},
        		{"exterieur", "2","3.6"},

        	},
        	new String[] {
        		"New column", "New column", "New column"
        	}
        ));
        table.setBackground(Color.WHITE);
        table.setBounds(10, 44, 572, 201);
        panel.add(table);

        
        JLabel lblNewLabel_18 = new JLabel("liste des box de la pension:");
        lblNewLabel_18.setBounds(10, 21, 153, 22);
        panel.add(lblNewLabel_18);
        
        JButton btnNewButton_1 = new JButton("enregistrer");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_1.setBounds(10, 258, 89, 23);
        panel.add(btnNewButton_1);
        
        JLabel lblNewLabel_19 = new JLabel("pension de paris");
        lblNewLabel_19.setBounds(143, 25, 127, 14);
        panel.add(lblNewLabel_19);
        
        JButton btnNewButton_2 = new JButton("ajouter une ligne");
        btnNewButton_2.setBounds(118, 258, 127, 23);
        panel.add(btnNewButton_2);
    }
}
