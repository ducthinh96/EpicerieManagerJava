package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JList;

public class AffichageTicketsPanel {
	private JPanel panel;
	
	public AffichageTicketsPanel ()
	{
		panel = new JPanel();
		panel.setBounds(181, 38, 851, 512);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Historique de transaction");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(325, 0, 239, 40);
		panel.add(lblNewLabel_1);
		
		JList listTickets = new JList();
		listTickets.setBounds(10, 70, 408, 411);
		panel.add(listTickets);
		
		JList listProduits = new JList();
		listProduits.setBounds(433, 70, 408, 411);
		panel.add(listProduits);
		
		JLabel ticketsLabel = new JLabel("Tickets");
		ticketsLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		ticketsLabel.setBounds(10, 50, 111, 14);
		panel.add(ticketsLabel);
		
		JLabel lblProduits = new JLabel("Produits");
		lblProduits.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblProduits.setBounds(433, 51, 111, 14);
		panel.add(lblProduits);
	}
	
	public JPanel getPanel() {
		return panel;
	}
}