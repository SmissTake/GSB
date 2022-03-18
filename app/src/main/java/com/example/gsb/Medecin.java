package com.example.gsb;

public class Medecin {

    private int numero;
    private String nom;
    private String prenom;
    private String adresse;
    private int cp;
    private String ville;
    private float coef;

    public Medecin(int numero, String nom, String prenom, String adresse, int cp, String ville, float coef) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.cp = cp;
        this.ville = ville;
        this.coef = coef;
    }

    @Override
    public String toString(){
        return "Num " + this.numero + ", " + this.nom + " " + this.prenom + "/n" + this.adresse + ", " + this.cp + " " + this.ville + "/n Coef de notoriété : " + this.coef;
    }

    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getCp() {
        return cp;
    }

    public String getVille() {
        return ville;
    }

    public float getCoef() {
        return coef;
    }

    public Medecin getMedecin(){
        return this;
    }
}
