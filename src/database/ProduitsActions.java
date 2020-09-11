package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProduitsActions {
	
	public static boolean ajouterProduit(int id, String nom, String desc, int prixVente, int qteMin, int qteStock, String unite, String statut, int cateID)
	{
		try {
			Connection cnx = DBConnection.ConnectToDatabase();
			Statement st = cnx.createStatement();

			Produits p = new Produits(id, nom, desc, prixVente, qteMin, qteStock, unite, statut, cateID);
			String insertStatement = p.createInsertStatement();
			
			System.out.println(insertStatement);

			st.execute(insertStatement);
			cnx.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static List<Produits> getProduitsDB()
	{
		List<Produits> listeProduits = new ArrayList<Produits>();
		
		try {
			Connection cnx = DBConnection.ConnectToDatabase();

			Statement st = cnx.createStatement();

			// Recuperer et ajouter tous les produits
			ResultSet resProduits = st.executeQuery("SELECT * FROM produits");
			while (resProduits.next()) {
				int prod_id = resProduits.getInt("prod_id");
				String prod_nom = resProduits.getString("prod_nom");
				String prod_description = resProduits.getString("prod_description");
				int prod_prix_vente_ttc = resProduits.getInt("prod_prix_vente_ttc");
				int prod_quantite_min = resProduits.getInt("prod_quantite_min");
				int prod_quantite_stock = resProduits.getInt("prod_quantite_stock");
				String prod_unite = resProduits.getString("prod_unite");
				String prod_statut = resProduits.getString("prod_statut");
				int prod_cate_id = resProduits.getInt("cate_id");
				
				
				Produits u = new Produits(prod_id, prod_nom, prod_description, prod_prix_vente_ttc, prod_quantite_min, prod_quantite_stock, prod_unite, prod_statut, prod_cate_id);
				listeProduits.add(u);
			}
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeProduits;
	}
	
	public static ResultSet getProduitSingle(String nomProduit) {
		ResultSet getProduitSingle = null;

		try {
			Connection cnx = DBConnection.ConnectToDatabase();

			Statement st = cnx.createStatement();

			// Recuperer et ajouter tous les tickets
			getProduitSingle = st.executeQuery("SELECT " + 
					"    prod_nom AS Nom," + 
					"    prod_prix_vente_ttc AS Prix," + 
					"    prod_quantite_min AS Quantit�_min," + 
					"    prod_quantite_stock AS Stock," + 
					"    prod_unite AS Unit�_Mesure," +
					"    prod_statut AS Statut " +
					"FROM" + 
					"    produits" + 
					"        WHERE" + 
					"    prod_nom = '" + nomProduit + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getProduitSingle;
	}
}
