package com.example.arist.listedecourses;

/**
 * Created by arist on 07/02/2017.
 */

public class Produit {
    private String categorie;
    private String quantite;
    private String nom;
    private String codeBarre;
    private String prix;
    private String promotion;
    private String emplacement;

    public Produit(String categorie, String quantite, String nom, String codeBarre, String prix, String promotion, String emplacement) {
        this.categorie = categorie;
        this.quantite = quantite;
        this.nom = nom;
        this.codeBarre = codeBarre;
        this.prix = prix;
        this.promotion = promotion;
        this.emplacement = emplacement;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }
}
