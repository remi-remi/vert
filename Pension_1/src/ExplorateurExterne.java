import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;
import java.io.IOException;
import static utils.DbConnection.*;
import static utils.Tools.*;

public class ExplorateurExterne extends JFrame {
	Connection con = getconConnection();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExplorateurExterne frame = new ExplorateurExterne();
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
	public ExplorateurExterne() {
		echo("go");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				echo("CLIC!");
				Adrien(fileChooser.getSelectedFile());
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, fileChooser, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, fileChooser, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, fileChooser, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, fileChooser, -10, SpringLayout.EAST, contentPane);
		contentPane.add(fileChooser);
	}
	
	public byte[] Adrien(File fichier) {
		try {
			byte[] fileContent = Files.readAllBytes(fichier.toPath());
			for (int i : fileContent) {
				echo("le fichier content "+fileContent.length+" bytes");
				Blob imgBlob = null;
				
				try {
					echo("go blob");
					imgBlob = new SerialBlob(fileContent);
					echo("fin blob");
					
					
					
					
					
					String sql="call addBox(?,?,?)";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1,"x");
					ps.setString(2,"x");g
					ps.setString(3,"x");
					try {
						ResultSet rs = ps.executeQuery();
						
					}catch(Exception e){
						
					}
					
					
					Connection con = getconConnection();
				} catch (SerialException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					echo("serial exept");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					echo("sql exept");
				}
				
				
				return fileContent;
			}
		} catch (IOException e1) {
			redcho("oh non impossible d'en faire des bytes !!!");
		}
		return null;
	}
}
