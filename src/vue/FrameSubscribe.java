package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import business.Services;
import business.ServicesDefault;
import jdbc.DataSource;
import jdbc.Database;
import jdbc.MySqlDataSource;
import models.User;
import services.UserDao;
import services.UserDaoJdbc;

/*
 * Fenetre qui permet l'inscription de l'utilisateur
 */
public class FrameSubscribe extends JFrame {

	private JPanel contentPane;
    private  JTextField username;
    private  JPasswordField password;
    private  JTextField mail;

    private  JButton btnValider;


	/**
	 * Create the frame.
	 */
	public FrameSubscribe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(200, 200, 700, 500);
	        setUndecorated(true);
	        setLocationRelativeTo(null);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);


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

	        JLabel lblUsername = new JLabel("Username");
	        lblUsername.setFont(new Font("PT Sans", Font.PLAIN, 16));
	        lblUsername.setBounds(29, 60, 127, 16);
	        panelInformations.add(lblUsername);

	        JLabel lblPswd = new JLabel("Mot de passe ");
	        lblPswd.setFont(new Font("PT Sans", Font.PLAIN, 16));
	        lblPswd.setBounds(29, 110, 127, 16);
	        panelInformations.add(lblPswd);

	        JLabel lblMail = new JLabel("E-mail");
	        lblMail.setFont(new Font("PT Sans", Font.PLAIN, 16));
	        lblMail.setBounds(29, 160, 127, 16);
	        panelInformations.add(lblMail);
	        
	        username = new JTextField();
	        username.setBounds(168, 50, 453, 36);
	        panelInformations.add(username);
	        username.setColumns(10);

	        password= new JPasswordField();
	        password.setColumns(10);
	        password.setBounds(168, 100, 453, 36);
	        panelInformations.add(password);

	        mail = new JTextField();
	        mail.setColumns(10);
	        mail.setBounds(168, 150, 453, 36);
	        panelInformations.add(mail);
	        
	        
	       
	        


	        btnValider = new JButton("Valider");

	        btnValider.setFont(new Font("PT Sans", Font.PLAIN, 13));
	        btnValider.setBounds(559, 331, 117, 29);
	        panelInformations.add(btnValider);

	    	ActionListener valider = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent a) {
					DataSource ds = new MySqlDataSource();
					Database db = new Database(ds);
					System.out.println(ds.getConnection());
					UserDao u1 = new UserDaoJdbc(db);
					Services s1 = new ServicesDefault(u1);
					s1.insertUser(new User(username.getText(),password.getText(),mail.getText()));
					dispose();
				}
			};
			btnValider.addActionListener(valider);
	        
	        JLabel lblProfil = new JLabel("S'inscrire");
	        lblProfil.setBounds(235, 0, 224, 22);
	        panelInformations.add(lblProfil);
	        lblProfil.setFont(new Font("PT Sans", Font.PLAIN, 22));
	        lblProfil.setHorizontalAlignment(SwingConstants.CENTER);

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
	                FrameSubscribe.this.dispose();
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
	    
	}

}
