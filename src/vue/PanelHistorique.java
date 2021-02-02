package vue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import models.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Desktop;
import java.awt.event.ActionEvent;

/*
 * Panneau ou on affiche les 10 dernieres grilles jouees 
 * On peut telecharger le fichier.csv des tirages gagnants 
 */
public class PanelHistorique extends JPanel {
	DefaultTableModel model = new DefaultTableModel();
	JTable jtbl = new JTable(model);
	JPanel cnt = new JPanel();
    /**
     * Create the panel.
     */
    public PanelHistorique(User userC) {
        setSize(690, 400);
        setLayout(null);

        JButton btnTelecharger = new JButton("Cliquer ici ");

        btnTelecharger.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {

                    File pdfFile = new File("./src/loto_201911.csv");
                    if (pdfFile.exists()) {

                        if (Desktop.isDesktopSupported()) {
                            Desktop.getDesktop().open(pdfFile);
                        } else {
                            System.out.println("Awt Desktop is not supported!");
                        }

                    } else {
                        System.out.println("File is not exists!");
                    }


                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }


        });

        JButton btnUpdate = new JButton("Rafraîchir");

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel mode = (DefaultTableModel)jtbl.getModel();
                mode.setRowCount(0);
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/jeuloto", "root", "root");
                    Statement st = con.createStatement();
                    ResultSet Rs = st.executeQuery("SELECT * FROM GRILLE WHERE iduser = " + userC.getId() + " ORDER BY id DESC LIMIT 10;");
                    while(Rs.next()){
                        model.addRow(new Object[]{Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6),Rs.getString(7),Rs.getString(9),Rs.getString(10)});
                    }
                    model.fireTableDataChanged();
                    JTable jTable = new JTable(model);
                    jTable.setMaximumSize(getMaximumSize());
                    
                    TableColumn column = null;
                    
                    for (int i = 0; i < 8; i++) {
                        column = jTable.getColumnModel().getColumn(i);
                        if (i == 7) {
                            column.setPreferredWidth(100);
                        } else {
                            column.setPreferredWidth(10);
                        }

                    }


                    JScrollPane pane = new JScrollPane(jTable);
                    pane.setBounds(10, 80, 674, 180);
                    add(pane);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }


        });

        btnTelecharger.setBounds(341, 33, 108, 29);
        add(btnTelecharger);

        btnUpdate.setBounds(493, 301, 108, 29);
        add(btnUpdate);

        JLabel lbl = new JLabel("Pour telecharger les derniers resultats du tirage");
        lbl.setBounds(17, 38, 340, 16);
        add(lbl);
        
		model.addColumn("n1");
		model.addColumn("n2");
		model.addColumn("n3");
		model.addColumn("n4");
		model.addColumn("n5");
		model.addColumn("nChance");
		model.addColumn("Jour");
        model.addColumn("Date Grille");
        

   

      
       
        
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/jeuloto", "root", "root");
			Statement st = con.createStatement();
			ResultSet Rs = st.executeQuery("SELECT * FROM GRILLE WHERE iduser = " + userC.getId() + " ORDER BY id DESC LIMIT 10;");
			while(Rs.next()){
				model.addRow(new Object[]{Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6),Rs.getString(7),Rs.getString(9),Rs.getString(10)});
			}
			model.fireTableDataChanged();
			JTable jTable = new JTable(model);
			
			JScrollPane pane = new JScrollPane(jTable);
			pane.setBounds(10, 80, 674, 180);
			add(pane);
			
			  
            TableColumn column = null;
            
            for (int i = 0; i < 8; i++) {
                column = jTable.getColumnModel().getColumn(i);
                if (i == 7) {
                    column.setPreferredWidth(100);
                } else {
                    column.setPreferredWidth(10);
                }

            }
		

	       
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		  



    }
    
}
