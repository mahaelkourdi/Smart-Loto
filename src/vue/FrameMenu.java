package vue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Panel;

import models.User;

import javax.swing.SwingConstants;
import java.awt.Component;


/*
 * Fenetre principale de l'application 
 */
public class FrameMenu extends JFrame{

    private  JPanel contentPane;
    private  JPanel PanelHome;
    private  JPanel PanelStatistique;
    private  JPanel PanelHistorique;
    private  JPanel PanelReducteur;
    private  JFrame connexion;
    private int posX = 0;   //Position X de la souris au clic
    private int posY = 0;   //Position Y de la souris au clic
    private  JButton btnDeconnexion;
    private  JButton btnProfil;
    private JFrame frameProfile;

    /**
     * Create the frame.
     */
    public FrameMenu(User userC) throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 700, 500);
        setUndecorated(true);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        contentPane.setLayout(null);
       


        PanelHome = new PanelHome(userC);
        PanelHome.setBounds(0, 0, 700, 500);
        PanelStatistique = new PanelStatistique();
        PanelStatistique.setLocation(0, 0);
        PanelStatistique.setAlignmentY(Component.CENTER_ALIGNMENT);
        PanelStatistique.setAlignmentX(Component.CENTER_ALIGNMENT);
        PanelStatistique.setSize(680, 480);
        PanelHistorique = new PanelHistorique(userC);
        PanelHistorique.setSize(700, 500);
        PanelReducteur = new PanelReducteur();
        PanelReducteur.setSize(700, 500);


        JPanel PanelHeader = new JPanel();
        PanelHeader.setBackground(new Color(220, 220, 220));
        PanelHeader.setBounds(0, 0, 700, 20);
        contentPane.add(PanelHeader);
        PanelHeader.setLayout(null);

        JButton btnClose = new JButton("X");
        btnClose.setBounds(670, 0, 30, 20);
        PanelHeader.add(btnClose);

        JPanel panelConnexion = new JPanel();
        panelConnexion.setBackground(new Color(238, 238, 238));
        panelConnexion.setBounds(0, 19, 700, 41);
        contentPane.add(panelConnexion);
        panelConnexion.setLayout(null);

        JLabel lblSmartLoto = new JLabel("Smart-Loto");
        lblSmartLoto.setBounds(0, 6, 126, 41);
        lblSmartLoto.setForeground(new Color(168, 193, 197));
        lblSmartLoto.setFont(new Font("SignPainter", Font.PLAIN, 32));

        panelConnexion.add(lblSmartLoto);

        btnProfil = new JButton("Gérer mon compte");
        btnProfil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == btnProfil) {
                    frameProfile = new FrameProfil(userC);
                    frameProfile.setVisible(true);
                    //setVisible(false);
                    frameProfile.revalidate();
                    frameProfile.repaint();

                }
            }
        });
        btnProfil.setBounds(405, 6, 168, 29);
        panelConnexion.add(btnProfil);


        connexion = new Connexion();
        btnDeconnexion = new JButton("Déconnexion");
        btnDeconnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnDeconnexion) {
                    FrameMenu.this.dispose();
                    connexion.setVisible(true);


                }
            }
        });
        btnDeconnexion.setBounds(577, 6, 117, 29);
        panelConnexion.add(btnDeconnexion);


        JPanel panelDashboard = new JPanel();
        panelDashboard.setBounds(0, 59, 700, 49);
        contentPane.add(panelDashboard);
        panelDashboard.setLayout(null);

        JPanel paneHome = new JPanel();
        paneHome.addMouseListener(new PanelButtonMouseAdapter(paneHome) {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuClicked(PanelHome);
                PanelHome.updateUI();
            }


        });
        paneHome.setBounds(6, 6, 138, 37);
        panelDashboard.add(paneHome);
        paneHome.setLayout(null);

        JLabel lblHome = new JLabel("Accueil");
        lblHome.setFont(new Font("PT Sans", Font.PLAIN, 17));
        lblHome.setBounds(6, 0, 126, 37);
        lblHome.setHorizontalAlignment(SwingConstants.CENTER);
        paneHome.add(lblHome);

        JPanel paneStatistique = new JPanel();
        paneStatistique.addMouseListener(new PanelButtonMouseAdapter(paneStatistique) {
            @Override

            public void mouseClicked(MouseEvent e) {
                menuClicked(PanelStatistique);
            }


        });

        paneStatistique.setBounds(188, 6, 138, 37);
        panelDashboard.add(paneStatistique);
        paneStatistique.setLayout(null);

        JLabel lblStatistiques = new JLabel("Statistiques");
        lblStatistiques.setBounds(18, 6, 98, 21);
        lblStatistiques.setHorizontalAlignment(SwingConstants.CENTER);
        lblStatistiques.setFont(new Font("PT Sans", Font.PLAIN, 17));
        paneStatistique.add(lblStatistiques);

        JPanel paneHistorique = new JPanel();
        paneHistorique.addMouseListener(new PanelButtonMouseAdapter(paneHistorique) {
            @Override

            public void mouseClicked(MouseEvent e) {
            	
                menuClicked(PanelHistorique);
              
            }


        });
        paneHistorique.setBounds(355, 6, 138, 37);
        panelDashboard.add(paneHistorique);
        paneHistorique.setLayout(null);

        JLabel lblHistorique = new JLabel("Historique");
        lblHistorique.setBounds(28, 6, 86, 21);
        lblHistorique.setHorizontalAlignment(SwingConstants.CENTER);
        lblHistorique.setFont(new Font("PT Sans", Font.PLAIN, 17));
        paneHistorique.add(lblHistorique);

        JPanel paneReducteur = new JPanel();
        paneReducteur.addMouseListener(new PanelButtonMouseAdapter(paneReducteur) {
            @Override

            public void mouseClicked(MouseEvent e) {
                menuClicked(PanelReducteur);
                
            }


        });

        paneReducteur.setBounds(542, 6, 138, 37);
        panelDashboard.add(paneReducteur);
        paneReducteur.setLayout(null);

        JLabel lblSystmeRducteur = new JLabel("Système");
        lblSystmeRducteur.setBounds(38, 6, 70, 21);
        lblSystmeRducteur.setHorizontalAlignment(SwingConstants.CENTER);
        lblSystmeRducteur.setFont(new Font("PT Sans", Font.PLAIN, 17));
        paneReducteur.add(lblSystmeRducteur);

        JPanel panelMainContent = new JPanel();
        panelMainContent.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        panelMainContent.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panelMainContent.setBounds(0, 105, 700, 389);
        contentPane.add(panelMainContent);
        panelMainContent.setLayout(null);

        panelMainContent.add(PanelHome);
        panelMainContent.add(PanelStatistique);
        panelMainContent.add(PanelHistorique);
        panelMainContent.add(PanelReducteur);

        menuClicked(PanelHome);

        btnClose.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Etes vous sûrs de vouloir fermer l'application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
                    FrameMenu.this.dispose();
                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnClose.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnClose.setForeground(Color.WHITE);
            }

        });


        // Bouger la fenêtre

        addMouseListener(new MouseAdapter() {
            @Override
            //on recupere les coordonnées de la souris
            public void mousePressed(MouseEvent e) {
                posX = e.getX();    //Position X de la souris au clic
                posY = e.getY();    //Position Y de la souris au clic
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            // A chaque deplacement on recalcul le positionnement de la fenetre
            public void mouseDragged(MouseEvent e) {
                int depX = e.getX() - posX;
                int depY = e.getY() - posY;
                setLocation(getX() + depX, getY() + depY);
            }
        });


    }

    public void menuClicked(JPanel panel) {
        PanelHome.setVisible(false);
        PanelStatistique.setVisible(false);
        PanelHistorique.setVisible(false);
        PanelReducteur.setVisible(false);
        panel.revalidate();
		panel.repaint();
        panel.setVisible(true);


    }


    private class PanelButtonMouseAdapter extends MouseAdapter {

        JPanel panel;

        public PanelButtonMouseAdapter(JPanel panel) {
            this.panel = panel;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            panel.setBackground(new Color(168, 193, 197));


        }


        @Override
        public void mouseExited(MouseEvent e) {
            panel.setBackground(new Color(238, 238, 238));


        }

        @Override
        public void mousePressed(MouseEvent e) {
            panel.setBackground(new Color(238, 238, 238));


        }

        @Override
        public void mouseReleased(MouseEvent e) {
            panel.setBackground(new Color(238, 238, 238));


        }

    }
}
		
		
