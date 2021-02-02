package vue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.awt.Desktop;

import models.Cnp;
import models.SystemReducteur;

/*
 * Panneau qui permet d'utiliser le system reducteur
 */
public class PanelReducteur extends JPanel {


    private  int[] tab1 = new int[12]; //Premier tableau d'entiers

    private  JTextField num1;
    private  JTextField num2;
    private  JTextField num3;
    private  JTextField num4;
    private  JTextField num5;
    private  JTextField num6;
    private  JTextField num7;
    private  JTextField num8;
    private  JTextField num9;
    private  JTextField num10;
    private  JTextField num11;
    private  JTextField num12;

    private  ButtonGroup grpObjectif;

    private int objectif;


    /**
     * Create the panel.
     */
    public PanelReducteur() {
        setBounds(100, 0, 548, 335);
        setLayout(null);

        JLabel lblInstruction = new JLabel("Saisir au moins 6 numéros compris entre 1 et 49:");
        lblInstruction.setBounds(17, 25, 329, 16);
        add(lblInstruction);

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
        num1.setBounds(17, 53, 51, 34);
        add(num1);
        num1.setColumns(10);

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
        num2.setBounds(80, 53, 51, 34);
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
        num3.setBounds(142, 53, 51, 34);
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
        num4.setBounds(210, 53, 51, 34);
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
        num5.setBounds(274, 53, 51, 34);
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
        num6.setBounds(343, 53, 51, 34);
        add(num6);

        num7 = new JTextField();
        num7.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		char c = e.getKeyChar();
        		if (!Character.isDigit(c)) {
        			e.consume();
        		}
        	}
        });
        num7.setColumns(10);
        num7.setBounds(17, 99, 51, 34);
        add(num7);

        num8 = new JTextField();
        num8.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		char c = e.getKeyChar();
        		if (!Character.isDigit(c)) {
        			e.consume();
        		}
        	}
        });
        num8.setColumns(10);
        num8.setBounds(79, 99, 51, 34);
        add(num8);

        num9 = new JTextField();
        num9.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		char c = e.getKeyChar();
        		if (!Character.isDigit(c)) {
        			e.consume();
        		}
        	}
        });
        num9.setColumns(10);
        num9.setBounds(142, 99, 51, 34);
        add(num9);

        num10 = new JTextField();
        num10.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		char c = e.getKeyChar();
        		if (!Character.isDigit(c)) {
        			e.consume();
        		}
        	}
        });
        num10.setColumns(10);
        num10.setBounds(210, 99, 51, 34);
        add(num10);

        num11 = new JTextField();
        num11.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		char c = e.getKeyChar();
        		if (!Character.isDigit(c)) {
        			e.consume();
        		}
        	}
        });
        num11.setColumns(10);
        num11.setBounds(274, 99, 51, 34);
        add(num11);

        num12 = new JTextField();
        num12.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		char c = e.getKeyChar();
        		if (!Character.isDigit(c)) {
        			e.consume();
        		}
        	}
        });
        num12.setColumns(10);
        num12.setBounds(343, 99, 51, 34);
        add(num12);

     
        // Objectifs
        JLabel lblObjectif = new JLabel("Séléctionner le nombre des bons numéros souhaités :");
        lblObjectif.setBounds(17, 145, 346, 16);
        add(lblObjectif);

        JRadioButton btn3 = new JRadioButton("3");
        btn3.setBounds(17, 173, 144, 23);
        add(btn3);

        JRadioButton btn4 = new JRadioButton("4");
        btn4.setBounds(163, 173, 144, 23);
        add(btn4);

        JRadioButton btn5 = new JRadioButton("5");
        btn5.setBounds(320, 173, 169, 23);
        add(btn5);

        btn3.setActionCommand("3");
        btn4.setActionCommand("4");
        btn5.setActionCommand("5");

        grpObjectif = new ButtonGroup();
        grpObjectif.add(btn3);
        grpObjectif.add(btn4);
        grpObjectif.add(btn5);


        JButton btnValider = new JButton("Valider");
        btnValider.setBounds(425, 300, 117, 29);

        btnValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                boolean checkGrille = true;
                Valider();
                int cpt = 0;
                for(int i =0; i < tab1.length ; i++) {
                    checkGrille = true;
                    
                    if (tab1[i] != 0) {
                        cpt++;
                    }
                }
                if (cpt < 6) {
                    JOptionPane.showMessageDialog(null, "Saisir au moins 6 numéros",
                            "Hey!", JOptionPane.ERROR_MESSAGE);
                    checkGrille = false;
                }
                if (objectif == 0) {
                    JOptionPane.showMessageDialog(null, "Choisir le nombre de bons numéros souhaité",
                            "Hey!", JOptionPane.ERROR_MESSAGE);
                    checkGrille = false;
                }


                if(checkGrille) {
                    System.out.println("Grille ok :)");
                    String text = "";
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    for (int i = 0; i < tab1.length; i++) {
                        if (tab1[i] != 0) {
                            list.add(tab1[i]);
                            text = text + " " + tab1[i];
                        }

                    }

                    SystemReducteur tf = new SystemReducteur(list.size(), 5, 4);
                    TreeMap<Integer, ArrayList<Integer>> listFinal = new TreeMap<Integer, ArrayList<Integer>>();
                    listFinal = SysReducteur(list, tf);
                    //System.out.println(listFinal);

                    JOptionPane.showMessageDialog(null, "Voici vos résultats !");
                    
                    try {

                    	//Parcours de la tree map et enregistrement dans un tableau de string
                    	String[] result = new String[listFinal.size() + 1];
                    	Set<Integer> keys = listFinal.keySet();
                    	for (int key: keys) {
                    		//System.out.println("La valeur de " + key + " est : " + listFinal.get(key));
                    		result[key] = "La proposition  " + key + " est : " + listFinal.get(key);
                    	}
                    	System.out.println("La réponse est: "+result[1] );
	            	   File file = new File("SystemeReducteur.txt");
	
	            	   // créer le fichier s'il n'existe pas
	            	   if (!file.exists()) {
	            	    file.createNewFile();
	            	   }
	
	            	   FileWriter fw = new FileWriter(file.getAbsoluteFile());
	            	   BufferedWriter bw = new BufferedWriter(fw);
	            	   bw.write("Les valeurs choisies sont:");
	            	   bw.newLine();
	            	   bw.write(text);
	            	   bw.newLine();
	            	   bw.write("La ou les différentes solution(s):");
	            	   bw.newLine();
	            	   for (int i = 1; i < listFinal.size(); i++) {
	            		   bw.write(result[i]);
	            		   bw.newLine();
	            	   }
	            	   bw.close();
	
	            	   Desktop desktop = Desktop.getDesktop();
	                   if(file.exists()) desktop.open(file);

                    } catch (IOException e1) {
                	   e1.printStackTrace();
                	}
                    
                    


                } else {
                    // Ne rien faire
                    System.out.println("Grille non valide :)");
                }

            }


        });


        add(btnValider);


    }

    private boolean StringOrNot(String s) {
        boolean x = false;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0' || s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '6' || s.charAt(i) == '7' || s.charAt(i) == '8' || s.charAt(i) == '9') {

            } else x = true;
        }
        return x;
    }

    public void Valider() {
        //On stockes les valeurs entr�es dans le premier tableau
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
        if (StringOrNot(num6.getText()) || num6.getText().equals("") || Integer.valueOf(num6.getText()).intValue() < 1 || Integer.valueOf(num6.getText()).intValue() > 49) {
            tab1[5] = 0;
        } else {
            tab1[5] = Integer.valueOf(num6.getText()).intValue();
        }

        if (StringOrNot(num7.getText()) || num7.getText().equals("") || Integer.valueOf(num7.getText()).intValue() < 1 || Integer.valueOf(num7.getText()).intValue() > 49) {
            tab1[6] = 0;
        } else {
            tab1[6] = Integer.valueOf(num7.getText()).intValue();
        }
        if (StringOrNot(num8.getText()) || num8.getText().equals("") || Integer.valueOf(num8.getText()).intValue() < 1 || Integer.valueOf(num8.getText()).intValue() > 49) {
            tab1[7] = 0;
        } else {
            tab1[7] = Integer.valueOf(num8.getText()).intValue();
        }
        if (StringOrNot(num9.getText()) || num9.getText().equals("") || Integer.valueOf(num9.getText()).intValue() < 1 || Integer.valueOf(num9.getText()).intValue() > 49) {
            tab1[8] = 0;
        } else {
            tab1[8] = Integer.valueOf(num9.getText()).intValue();
        }
        if (StringOrNot(num10.getText()) || num10.getText().equals("") || Integer.valueOf(num10.getText()).intValue() < 1 || Integer.valueOf(num10.getText()).intValue() > 49) {
            tab1[9] = 0;
        } else {
            tab1[9] = Integer.valueOf(num10.getText()).intValue();
        }
        if (StringOrNot(num11.getText()) || num11.getText().equals("") || Integer.valueOf(num11.getText()).intValue() < 1 || Integer.valueOf(num11.getText()).intValue() > 49) {
            tab1[10] = 0;
        } else {
            tab1[10] = Integer.valueOf(num11.getText()).intValue();
        }
        if (StringOrNot(num12.getText()) || num12.getText().equals("") || Integer.valueOf(num12.getText()).intValue() < 1 || Integer.valueOf(num12.getText()).intValue() > 49) {
            tab1[11] = 0;
        } else {
            tab1[11] = Integer.valueOf(num12.getText()).intValue();
        }
        if (grpObjectif.getSelection() == null) {
            objectif = 0;
        } else {
            objectif = Integer.parseInt(grpObjectif.getSelection().getActionCommand());
        }
    }

    public static TreeMap<Integer, ArrayList<Integer>> SysReducteur(ArrayList<Integer> list, SystemReducteur tf) {
        TreeMap<Integer, ArrayList<Integer>> listeF = new TreeMap<Integer, ArrayList<Integer>>();
        //SystemReducteur tf = new SystemReducteur(list.size(),6,K);
        ArrayList<Integer> listeEmplacement = new ArrayList<Integer>();

        // calcul des solutions et conserve la meilleure
        int[] bestsolution = null;
        for (int loop = 0; loop < 100; loop++) {
            int[] solutions = tf.computeSolutions();
            if (bestsolution == null || solutions.length < bestsolution.length) {
                System.out.println("found a solution of size:" + solutions.length);
                bestsolution = solutions;
            }
        }

        int j = 0;
        // affiche la meilleure solution
        for (int solution : bestsolution) {
            ArrayList<Integer> listeCombi = new ArrayList<Integer>();

            listeEmplacement = Cnp.combi(solution);

            j++;

            for (int i = 0; i <= 4; i++) {
                int tmp = listeEmplacement.get(i);

                listeCombi.add(list.get(tmp - 1));


            }
            listeF.put(j, listeCombi);

        }

        return listeF;

    }


}



