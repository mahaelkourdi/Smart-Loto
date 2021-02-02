package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import business.Services;
import business.ServicesDefault;
import jdbc.DataSource;
import jdbc.Database;
import jdbc.MySqlDataSource;
import models.User;
import services.UserDao;
import services.UserDaoJdbc;

import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/*
 * Fenetre qui permet de modifier les informations
 * d'un utilisateur
 */
public class FrameProfil extends JFrame {

    private  JPanel contentPane;
    private  JTextField username;
    private  JPasswordField password;
    private  JTextField mail;
    private  JButton btnValider;
    private User user1;
    

    public FrameProfil(User userC) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 700, 500);
        setUndecorated(true);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        this.user1=userC;
        JPanel PanelHeader = new JPanel();
        PanelHeader.setBounds(0, 0, 700, 20);
        PanelHeader.setBackground(new Color(220, 220, 220));
        contentPane.add(PanelHeader);
        PanelHeader.setLayout(null);

        JButton buttonClose = new JButton("X");
        buttonClose.setBounds(670, 0, 30, 20);
        PanelHeader.add(buttonClose);

        JPanel panelInformations = new JPanel();
        panelInformations.setBounds(0, 98, 694, 366);
        contentPane.add(panelInformations);
        panelInformations.setLayout(null);
        
        JLabel lblNom = new JLabel("Username");
        lblNom.setFont(new Font("PT Sans", Font.PLAIN, 16));
        lblNom.setBounds(29, 130, 127, 16);
        panelInformations.add(lblNom);

        
        JLabel lblMail = new JLabel("E-mail");
        lblMail.setFont(new Font("PT Sans", Font.PLAIN, 16));
        lblMail.setBounds(29, 264, 127, 16);
        panelInformations.add(lblMail);
        
        username = new JTextField();
        username.setBounds(168, 120, 453, 36);
        panelInformations.add(username);
        username.setColumns(10);
        username.setText(userC.getUsername());

        password = new JPasswordField();
        password.setColumns(10);
        password.setBounds(168, 181, 453, 36);
        panelInformations.add(password);
        password.setText(userC.getPassword());

        mail = new JTextField();
        mail.setColumns(10);
        mail.setBounds(168, 254, 453, 36);
        panelInformations.add(mail);
        mail.setText(userC.getEmail());

        userActionListener modifier = new userActionListener(user1, username, password, mail, this);
		
        btnValider = new JButton("Modifier");
        btnValider.addActionListener(modifier);
        this.repaint();
        btnValider.setFont(new Font("PT Sans", Font.PLAIN, 13));
        btnValider.setBounds(559, 331, 117, 29);
        panelInformations.add(btnValider);

        btnValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String nomSaisi = username.getText();
                String pwdSaisi = password.getText();
                String mailSaisi = mail.getText();


                JOptionPane.showMessageDialog(null, "Vos modifications sont enregistrées avec succès");
                setVisible(false);
                FrameProfil.this.dispose();

            }
        });


        JLabel lblProfil = new JLabel("Profil");
        lblProfil.setBounds(235, 29, 224, 22);
        panelInformations.add(lblProfil);
        lblProfil.setFont(new Font("PT Sans", Font.PLAIN, 22));
        lblProfil.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lblPswd = new JLabel("Mot de passe");
        lblPswd.setBounds(29, 191, 94, 16);
        panelInformations.add(lblPswd);

        JPanel panelModifier = new JPanel();
        panelModifier.setBounds(0, 20, 694, 77);
        contentPane.add(panelModifier);
        panelModifier.setLayout(null);

        JLabel lblSmartLoto = new JLabel("Smart-Loto");
        lblSmartLoto.setBounds(6, 24, 113, 32);
        panelModifier.add(lblSmartLoto);
        lblSmartLoto.setForeground(new Color(168, 193, 197));
        lblSmartLoto.setFont(new Font("SignPainter", Font.PLAIN, 32));

        buttonClose.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Etes vous sûrs de vouloir fermer l'application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0)
                    ;
                FrameProfil.this.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonClose.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonClose.setForeground(Color.WHITE);
            }

        });
        repaint();
    }
    public class userActionListener implements ActionListener{
    	private JTextField username;
    	private JPasswordField password;
    	private JTextField mail;
    	private User user1;
    	private JFrame panel;
    	
    	public userActionListener(User user1, JTextField username, JPasswordField password, JTextField mail, JFrame panel) {
    		this.user1 = user1;
    		this.username = username;
    		this.password = password;
    		this.mail = mail;
    		this.panel = panel;
    	}
    	public void actionPerformed(ActionEvent a) {
    		DataSource ds = new MySqlDataSource();
    		Database db = new Database(ds);
    		System.out.println(ds.getConnection());
    		UserDao u1 = new UserDaoJdbc(db);
    		Services s1 = new ServicesDefault(u1);
    		List<User> listuser = s1.selectUsers();
    		for (User user : listuser) {
    			User userNew = new User(user1.getId(),username.getText(),password.getText(),mail.getText());
    			if (userNew.getId().equals(user.getId())) {
    				user = userNew;
    				user1.setUsername(username.getText());
    				user1.setPassword(password.getText());
    				user1.setEmail(mail.getText());
    				s1.updateUser(user);
    				username.setText(user.getUsername());
    				password.setText(user.getPassword());
    				mail.setText(user.getEmail());
    			}
    		}
    		panel.repaint();
    	}
    }
}