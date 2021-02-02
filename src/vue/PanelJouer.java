package vue;

import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;

import models.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.sql.DriverManager;
import java.sql.Statement;


/*
 * Panneau permettant de jouer des grilles
 */
public class PanelJouer extends JPanel {
    private  JLabel lblInstruction;
    private  JLabel lblSlectionnerUnJour;
    private  int[] tab1 = new int[6];
    private  JButton btnValider;
    private  ButtonGroup group;


    private  JRadioButton btnLun;
    private  JRadioButton btnMer;
    private  JRadioButton btnSam;

    private String value;
    private  JTextField num1;
    private  JTextField num2;
    private  JTextField num3;
    private  JTextField num4;
    private  JTextField num5;
    private  JTextField num6;
    private User userC;


    /**
     * Create the panel.
     */
    public PanelJouer(User userC) {

        setBounds(100, 0, 590, 300);
        setLayout(null);

        // Champs pour saisir les numéros
        num1 = new JTextField();
        num1.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		char c = e.getKeyChar();
        		if (!Character.isDigit(c)) {
        			e.consume();
        		}
        	}
        });
        num1.setColumns(10);
        num1.setBounds(34, 48, 53, 31);
        add(num1);

        num2 = new JTextField();
        num2.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		char c = e.getKeyChar();
        		if (!Character.isDigit(c)) {
        			e.consume();
        		}
        	}
        });
        num2.setColumns(10);
        num2.setBounds(108, 48, 53, 31);
        add(num2);

        num3 = new JTextField();
        num3.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		char c = e.getKeyChar();
        		if (!Character.isDigit(c)) {
        			e.consume();
        		}
        	}
        });
        num3.setColumns(10);
        num3.setBounds(178, 48, 53, 31);
        add(num3);

        num4 = new JTextField();
        num4.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		char c = e.getKeyChar();
        		if (!Character.isDigit(c)) {
        			e.consume();
        		}
        	}
        });
        num4.setColumns(10);
        num4.setBounds(250, 48, 53, 31);
        add(num4);

        num5 = new JTextField();
        num5.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		char c = e.getKeyChar();
        		if (!Character.isDigit(c)) {
        			e.consume();
        		}
        	}
        });
        num5.setColumns(10);
        num5.setBounds(326, 48, 53, 31);
        add(num5);

        num6 = new JTextField();
        num6.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		char c = e.getKeyChar();
        		if (!Character.isDigit(c)) {
        			e.consume();
        		}
        	}
        });
        num6.setColumns(10);
        num6.setBounds(34, 134, 53, 31);
        add(num6);


        lblInstruction = new JLabel("Saisir 5 numéros de 1 à 49 :");
        lblInstruction.setBounds(24, 20, 432, 16);
        add(lblInstruction);

        lblSlectionnerUnJour = new JLabel("Sélectionner un jour");
        lblSlectionnerUnJour.setBounds(24, 178, 432, 16);
        add(lblSlectionnerUnJour);


        // Boutons pour sélectionner les jours
        group = new ButtonGroup();
        btnLun = new JRadioButton("Lundi");
        btnLun.setBounds(24, 196, 78, 23);
        add(btnLun);

        btnMer = new JRadioButton("Mercredi");
        btnMer.setBounds(178, 196, 96, 23);
        add(btnMer);

        btnSam = new JRadioButton("Samedi");
        btnSam.setBounds(314, 196, 78, 23);
        add(btnSam);

        btnLun.setActionCommand("Lundi");
        btnSam.setActionCommand("Samedi");
        btnMer.setActionCommand("Mercredi");

        group.add(btnLun);
        group.add(btnMer);
        group.add(btnSam);

        JLabel lblNumDeChance = new JLabel("Saisir le numéro de chance entre 1 et 10 : ");
        lblNumDeChance.setBounds(24, 106, 268, 16);
        add(lblNumDeChance);


        btnValider = new JButton("Valider");
        btnValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent h) {
                int i = 0;
                boolean checkGrille = true;
                valider();
                for (i = 0; i < 5; i++) {
                    System.out.println(tab1[i]);
                    checkGrille = true;
                    if (tab1[i] == 0) {
                        JOptionPane.showMessageDialog(null, "Rentrer les 5 numéros",
                                "Hey!", JOptionPane.ERROR_MESSAGE);
                        checkGrille = false;
                        break;
                    }
                }
                if (tab1[5] == 0) {
                    JOptionPane.showMessageDialog(null, "Rentrer le numéro chance",
                            "Hey!", JOptionPane.ERROR_MESSAGE);
                    checkGrille = false;
                }
                if (value == "error") {
                    JOptionPane.showMessageDialog(null, "Veuillez choisir un jour",
                            "Hey!", JOptionPane.ERROR_MESSAGE);
                    checkGrille = false;
                }


                if (checkGrille) {
                    // Envoyer vers la page stat avec les valeurs de notre grille
                    System.out.println("Grille ok :)");
                    System.out.println(value);
                    int a = tab1[0];
					int b = tab1[1];
					int c = tab1[2];
					int d = tab1[3];
					int e = tab1[4];
					int f = tab1[5];
					String v = value;
                    Date aujourdhui = new Date();
                    DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                            DateFormat.SHORT,
                            DateFormat.SHORT);
                    String date = shortDateFormat.format(aujourdhui);

					System.out.println(a +"," + b + "," + c + "," + d + "," + e +","+ f + "," + v);
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/jeuloto", "root", "root");
				        Statement st = con.createStatement();
				        int j = 1;
				        System.out.println(j);
				        st.executeUpdate("INSERT INTO GRILLE ( n1, n2, n3, n4, n5, numChance, iduser, date, dateJour)" +
				        				"VALUES(" + a + "," + b + "," + c + "," + d + "," + e + "," + f + "," + userC.getId() + ",'" + v + "','" + date + "');");
				        j++;
				        System.out.println(j);
					 }catch (Exception g) {
						 System.out.println(g.getMessage());
					}
                    JOptionPane.showMessageDialog(null, "Grille ajoutée avec succès");


                } else {
                    // Ne rien faire
                    System.out.println("Grille non valide :)");
                }

            }
        });

        btnValider.setBounds(467, 246, 117, 29);
        add(btnValider);


    }

// Valider la grille jouée

    private boolean StringOrNot(String s) {
        boolean x = false;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0' || s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '6' || s.charAt(i) == '7' || s.charAt(i) == '8' || s.charAt(i) == '9') {

            } else x = true;
        }
        return x;
    }

    public void valider() {
        //On stockes les valeurs entr�es dans le tableau

        if (StringOrNot(num1.getText()) || num1.getText().equals("") || Integer.valueOf(num1.getText()).intValue() < 1 || Integer.valueOf(num1.getText()).intValue() > 49) {
            tab1[0] = 0;
        } else {
            tab1[0] = Integer.valueOf(num1.getText()).intValue();
        }
        if (StringOrNot(num2.getText()) || num2.getText().equals("") || Integer.valueOf(num2.getText()).intValue() < 1 || Integer.valueOf(num2.getText()).intValue() > 49) {
            tab1[1] = 0;
        } else {
            tab1[1] = Integer.valueOf(num2.getText()).intValue();
        }
        if (StringOrNot(num3.getText()) || num3.getText().equals("") || Integer.valueOf(num3.getText()).intValue() < 1 || Integer.valueOf(num3.getText()).intValue() > 49) {
            tab1[2] = 0;
        } else {
            tab1[2] = Integer.valueOf(num3.getText()).intValue();
        }
        if (StringOrNot(num4.getText()) || num4.getText().equals("") || Integer.valueOf(num4.getText()).intValue() < 1 || Integer.valueOf(num4.getText()).intValue() > 49) {
            tab1[3] = 0;
        } else {
            tab1[3] = Integer.valueOf(num4.getText()).intValue();
        }
        if (StringOrNot(num5.getText()) || num5.getText().equals("") || Integer.valueOf(num5.getText()).intValue() < 1 || Integer.valueOf(num5.getText()).intValue() > 49) {
            tab1[4] = 0;
        } else {
            tab1[4] = Integer.valueOf(num5.getText()).intValue();
        }
        if (StringOrNot(num6.getText()) || num6.getText().equals("") || Integer.valueOf(num6.getText()).intValue() < 1 || Integer.valueOf(num6.getText()).intValue() > 10) {
            tab1[5] = 0;
        } else {
            tab1[5] = Integer.valueOf(num6.getText()).intValue();
        }
        if (group.getSelection() == null) {
            value = "error";
        } else  {
            value = group.getSelection().getActionCommand();
        }
       /* int a = tab1[0];
		int b = tab1[1];
		int c = tab1[2];
		int d = tab1[3];
		int e = tab1[4];
		int f = tab1[5];
		String v = value;
		System.out.println(a +"," + b + "," + c + "," + d + "," + e +","+ f + "," + v);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/jeuloto", "root", "root");
	        Statement st = con.createStatement();
	        int j =1;
	        System.out.println(j);
	        st.executeUpdate("INSERT INTO GRILLE ( n1, n2, n3, n4, n5, numChance, iduser, date)" +
	        				"VALUES(" + a + "," + b + "," + c + "," + d + "," + e + "," + f + "," + userC.getId() + ",'" + v + "');");
	       System.out.println(j++);
		
		 }catch (Exception g) {
			 System.out.println(g.getMessage());
		}*/
    }
}