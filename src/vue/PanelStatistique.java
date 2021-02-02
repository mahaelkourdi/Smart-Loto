package vue;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import models.Statistiques;
import models.Utilities;

import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

/*
 * Panneau ou on affiche les differents statistiques 
 * des numéros compris entre 1 et 49 et les statistiques 
 * du numéro chance
 */
public class PanelStatistique extends JPanel {

    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    
    JTable jtbl = new JTable(model);
    JTable jtbl2 = new JTable(model2);
    
    JPanel cnt = new JPanel();
    
    public PanelStatistique() throws IOException{
    	setSize(700,500);
		
    	model.addColumn("Boule");
        model.addColumn("Reussite Totale");
        model.addColumn("Sortie Recente");
        model.addColumn("Ecart Max");
        model.addColumn("Ecart Actuel");
        model.addColumn("+Affinite");
        model.addColumn("-Affinite");
    	try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/jeuloto", "root", "root");
		        Statement st = con.createStatement();
		        
		        Statistiques stat = new Statistiques();
		        Utilities u = new Utilities();
		        
		        
		        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
		        map = u.extractCSV();
		        
		        Map<Integer, ArrayList<Integer>> map2 = new TreeMap<>();
		        map2 = stat.statF(map);
		        
		        System.out.println(map2);
		        
		        for (int j = 1; j < 50; j++) {
					st.executeUpdate("DELETE FROM STATISTIQUE WHERE id =" + j);
					System.out.println("j" + j);
				}
		        
		        for (int i = 1; i < 50; i++) {
			        ArrayList<Integer> list = map2.get(i);
		        	int a = list.get(0);
		        	int b = list.get(1);
		        	int c = list.get(2);
		        	int d = list.get(3);
		        	int e = list.get(4);
		        	int f = list.get(5);
					st.executeUpdate("INSERT INTO STATISTIQUE ( id, total, recent, ecartMax, ecartActuel, bestAffinity, badAffinity)" + 
							"VALUES(" + i + "," + a + "," + b + "," + c + "," + d + "," + e + "," + f + "); ");
					System.out.println("i"+i);
				}
		        
		        ResultSet Rs = st.executeQuery("SELECT * FROM STATISTIQUE ORDER BY id");
		        while(Rs.next()){
		            model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6),Rs.getString(7)});
		        }
		    	setLayout(null);
		    	JTable jTable = new JTable(model);
		    	JScrollPane pane = new JScrollPane(jTable);
		    	pane.setBounds(35, 23, 647, 187);
		    	add(pane);
				} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	model2.addColumn("Num Chance");
        model2.addColumn("Reussite Totale");
        model2.addColumn("Sortie Recente");
        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/jeuloto", "root", "root");
	        Statement st = con.createStatement();
	        
	        Statistiques stat2 = new Statistiques();
	        Utilities u2 = new Utilities();
	        
	        Map<Integer, Integer> map = new TreeMap<>();
	        map = u2.extractNumChance();
	        
	        Map<Integer, ArrayList<Integer>> map2 = new TreeMap<>();
	        map2 = stat2.statF2(map);
	        
	        System.out.println(map2);
	        
	        for (int j = 1; j < 11; j++) {
				st.executeUpdate("DELETE FROM STATCHANCE WHERE id =" + j);

	        	System.out.println("j" + j);
			}
	        
	        for (int i = 1; i < 11; i++) {
	        	int a = map2.get(i).get(0);
	        	int b = map2.get(i).get(1);
	        	
	        	st.executeUpdate("INSERT INTO STATCHANCE (id, total, recent) "
	        	          +"VALUES ("+ i + "," + a +"," + b + ")");
	        	System.out.println("i" + i);
			}
	        
	        ResultSet Rs = st.executeQuery("SELECT * FROM STATCHANCE ORDER BY id");
	        while(Rs.next()){
	            model2.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getString(3)});
	        }
	    	JTable jTable = new JTable(model2);
	    	JScrollPane pane = new JScrollPane(jTable);
	    	pane.setBounds(35, 229, 647, 146);
	    	add(pane);
	    	
	    	JLabel lblStat = new JLabel("Statistiques de numéro chance  ");
	    	lblStat.setBounds(35, 208, 326, 16);
	    	add(lblStat);
	    	
	    	JLabel lblStat_1 = new JLabel("Statistiques des numéros compris entre 1 et 49 :  ");
	    	lblStat_1.setBounds(35, 6, 326, 16);
	    	add(lblStat_1);
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
		e.printStackTrace();
	}
    }
}
