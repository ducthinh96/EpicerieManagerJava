#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Utilisateurs
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Utilisateurs(
        utls_id        Int  Auto_increment  NOT NULL ,
        utls_nom       Varchar (200) NOT NULL ,
        utls_prenom    Varchar (200) NOT NULL ,
        utls_telephone Varchar (50) NOT NULL ,
        utls_mail      Varchar (200) NOT NULL ,
        utls_adresse   Varchar (200) NOT NULL ,
        utls_mdp       Varchar (200) NOT NULL ,
        utls_caisse    Varchar (10) NOT NULL ,
        utls_manager   Bool Default false NOT NULL
	,CONSTRAINT Utilisateurs_PK PRIMARY KEY (utls_id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Tickets
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Tickets(
        tckt_id          Int  Auto_increment  NOT NULL ,
        tckt_date        Date NOT NULL ,
        tck_statut       Varchar (50) NOT NULL ,
        tckt_commentaire Varchar (50) ,
        utls_id          Int NOT NULL
	,CONSTRAINT Tickets_PK PRIMARY KEY (tckt_id)

	,CONSTRAINT Tickets_Utilisateurs_FK FOREIGN KEY (utls_id) REFERENCES Utilisateurs(utls_id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Categories
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Categories(
        cate_id      Int  Auto_increment  NOT NULL ,
        cate_libelle Varchar (200) NOT NULL
	,CONSTRAINT Categories_PK PRIMARY KEY (cate_id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Produits
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Produits(
        prod_id             Int  Auto_increment  NOT NULL ,
        prod_nom            Varchar (200) NOT NULL ,
        prod_description    Varchar (1000) NOT NULL ,
        prod_prix_vente_ttc Float NOT NULL ,
        prod_quantite_min   Int NOT NULL ,
        prod_quantite_stock Float NOT NULL ,
        prod_unite          Varchar (50) NOT NULL ,
        prod_statut         Varchar (50) NOT NULL ,
        cate_id             Int NOT NULL
	,CONSTRAINT Produits_PK PRIMARY KEY (prod_id)

	,CONSTRAINT Produits_Categories_FK FOREIGN KEY (cate_id) REFERENCES Categories(cate_id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Tickets_Produits
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Tickets_Produits(
        tckt_id            Int NOT NULL ,
        prod_id            Int NOT NULL ,
        tckt_prod_id       Int Auto_increment NOT NULL ,
        tckt_prod_quantite Float NOT NULL
	,CONSTRAINT Tickets_Produits_PK PRIMARY KEY (tckt_id,prod_id)
    ,KEY(tckt_prod_id)

	,CONSTRAINT Tickets_Produits_Tickets_FK FOREIGN KEY (tckt_id) REFERENCES Tickets(tckt_id) ON DELETE CASCADE ON UPDATE CASCADE
	,CONSTRAINT Tickets_Produits_Produits0_FK FOREIGN KEY (prod_id) REFERENCES Produits(prod_id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB;
