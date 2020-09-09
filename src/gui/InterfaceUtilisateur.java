package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class InterfaceUtilisateur implements Runnable {

	private JFrame frmAjoutDunNouveau;
	private final JPanel TopPanel = new JPanel();
	private JTextField dateHeure;
	private JTextField headText;
	private JPanel LeftPanel;
	private JPanel panelGestionStock;
	private JLabel lblNewLabel;
	private JLayeredPane PanelsStack;
	private JPanel panelAjouterProduit;
	private JPanel panelModifierQuantiteStock;
	private JPanel panelCreerNouveauTicket;
	private JPanel panelParcourirFichierClient;
	private JPanel panelAjouterNouveauClient;

	public void run() {
		try {
			InterfaceUtilisateur window = new InterfaceUtilisateur();
			window.frmAjoutDunNouveau.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public InterfaceUtilisateur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAjoutDunNouveau = new JFrame();
		frmAjoutDunNouveau.setTitle("Epicerie Manager");
		frmAjoutDunNouveau.setBounds(100, 100, 1048, 589);
		frmAjoutDunNouveau.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAjoutDunNouveau.getContentPane().setLayout(null);
		TopPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		TopPanel.setBounds(0, 0, 1032, 39);
		frmAjoutDunNouveau.getContentPane().add(TopPanel);
		TopPanel.setLayout(null);

		dateHeure = new JTextField();
		dateHeure.setEditable(false);
		dateHeure.setBounds(10, 11, 164, 18);
		TopPanel.add(dateHeure);
		dateHeure.setColumns(10);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Date date = new Date();

		dateHeure.setText(date.toString());

		headText = new JTextField();
		headText.setEditable(false);
		headText.setFont(new Font("Tahoma", Font.BOLD, 11));
		headText.setText("Projet Java - Outil Caisse/Inventaire d'\u00E9picerie");
		headText.setColumns(10);
		headText.setBounds(433, 11, 275, 18);
		TopPanel.add(headText);
		
		PanelsStack = new JLayeredPane();
		PanelsStack.setBounds(181, 38, 851, 512);
		frmAjoutDunNouveau.getContentPane().add(PanelsStack);
		PanelsStack.setLayout(new CardLayout(0, 0));
		
		panelAjouterProduit = new AjoutProduitPanel().getPanel();
		PanelsStack.add(panelAjouterProduit, "name_6306658276400");
		
		panelModifierQuantiteStock = new ModificationQuantiteStockPanel().getPanel();
		PanelsStack.add(panelModifierQuantiteStock, "name_6306670600200");
		
		panelCreerNouveauTicket = new CreationNouveauTicketPanel().getPanel();
		PanelsStack.add(panelCreerNouveauTicket, "name_6306682648400");
		
		panelParcourirFichierClient = new AffichageFichierClientPanel().getPanel();
		PanelsStack.add(panelParcourirFichierClient, "name_6306694792400");
		
		panelAjouterNouveauClient = new AjoutClientPanel().getPanel();
		PanelsStack.add(panelAjouterNouveauClient, "name_6306706746800");

		LeftPanel = new JPanel();
		LeftPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		LeftPanel.setBounds(0, 38, 182, 512);
		frmAjoutDunNouveau.getContentPane().add(LeftPanel);
		LeftPanel.setLayout(null);

		panelGestionStock = new JPanel();
		panelGestionStock.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelGestionStock.setBounds(10, 11, 162, 154);
		LeftPanel.add(panelGestionStock);
		panelGestionStock.setLayout(null);

		lblNewLabel = new JLabel("Gestion des stocks");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(0, 0, 162, 30);
		panelGestionStock.add(lblNewLabel);
		
		JButton btnAjouterProduit = new JButton("Ajouter un produit");
		btnAjouterProduit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelAjouterProduit);
			}
		});
		btnAjouterProduit.setMargin(new Insets(2, 2, 2, 2));
		btnAjouterProduit.setBounds(10, 41, 142, 30);
		panelGestionStock.add(btnAjouterProduit);
		
		JButton btnModifierQuantite = new JButton("Modifier quantit\u00E9 stock");
		btnModifierQuantite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelModifierQuantiteStock);
			}
		});
		btnModifierQuantite.setMargin(new Insets(2, 2, 2, 2));
		btnModifierQuantite.setBounds(10, 76, 142, 31);
		panelGestionStock.add(btnModifierQuantite);
		
		JPanel panelGestionCaisse = new JPanel();
		panelGestionCaisse.setLayout(null);
		panelGestionCaisse.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelGestionCaisse.setBounds(10, 176, 162, 154);
		LeftPanel.add(panelGestionCaisse);
		
		JLabel lblVentes = new JLabel("Gestion Caisse");
		lblVentes.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentes.setForeground(Color.BLACK);
		lblVentes.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVentes.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblVentes.setBackground(SystemColor.activeCaption);
		lblVentes.setBounds(0, 0, 162, 30);
		panelGestionCaisse.add(lblVentes);
		
		JButton btnCreerNewTicket = new JButton("Cr\u00E9er nouveau ticket");
		btnCreerNewTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelCreerNouveauTicket);
			}
		});
		btnCreerNewTicket.setMargin(new Insets(2, 2, 2, 2));
		btnCreerNewTicket.setBounds(10, 41, 142, 30);
		panelGestionCaisse.add(btnCreerNewTicket);
		
		JPanel panelGestionClientele = new JPanel();
		panelGestionClientele.setLayout(null);
		panelGestionClientele.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelGestionClientele.setBounds(10, 341, 162, 154);
		LeftPanel.add(panelGestionClientele);
		
		JLabel lblGestionFichierClient = new JLabel("Gestion Fichier Client");
		lblGestionFichierClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionFichierClient.setForeground(Color.BLACK);
		lblGestionFichierClient.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGestionFichierClient.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblGestionFichierClient.setBackground(SystemColor.activeCaption);
		lblGestionFichierClient.setBounds(0, 0, 162, 30);
		panelGestionClientele.add(lblGestionFichierClient);
		
		JButton btnParcourirFichierClient = new JButton("Parcourir fichier client");
		btnParcourirFichierClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelParcourirFichierClient);
			}
		});
		btnParcourirFichierClient.setMargin(new Insets(2, 2, 2, 2));
		btnParcourirFichierClient.setBounds(10, 41, 142, 30);
		panelGestionClientele.add(btnParcourirFichierClient);
		
		JButton btnAjouterUnNouveau = new JButton("Ajouter nouveau client");
		btnAjouterUnNouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelAjouterNouveauClient);
			}
		});
		btnAjouterUnNouveau.setMargin(new Insets(2, 2, 2, 2));
		btnAjouterUnNouveau.setBounds(10, 77, 142, 30);
		panelGestionClientele.add(btnAjouterUnNouveau);
	}
	
	public void switchPanels(JPanel panel) {
		PanelsStack.removeAll();
		PanelsStack.add(panel);
		PanelsStack.repaint();
		PanelsStack.revalidate();
	}
}