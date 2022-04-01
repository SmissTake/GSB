package com.example.gsb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Medecin {

    private int numero;
    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String typeLibelle;
    private float coefNotoriete;


    @JsonCreator
    public Medecin(@JsonProperty("PRA_NUM") int numero, @JsonProperty("PRA_NOM") String nom, @JsonProperty("PRA_PRENOM") String prenom, @JsonProperty("PRA_ADRESSE") String adresse, @JsonProperty("PRA_CP") String codePostal, @JsonProperty("PRA_VILLE") String ville, @JsonProperty("TYP_LIBELLE") String typeLibelle, @JsonProperty("PRA_COEFNOTORIETE") float coefNotoriete) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.typeLibelle = typeLibelle;
        this.coefNotoriete = coefNotoriete;
    }

    public Medecin(){
        super();
    }

    @Override
    public String toString(){
        return "Num " + this.numero + ", " + this.nom + " " + this.prenom + "/n" + this.adresse + ", " + this.codePostal + " " + this.ville + "/n Coef de notoriété : " + this.coefNotoriete;
    }

    /**
     * Setter de numero Medecin
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setTypeLibelle(String typeLibelle) {
        this.typeLibelle = typeLibelle;
    }

    public void setCoefNotoriete(float coefNotoriete) {
        this.coefNotoriete = coefNotoriete;
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

    public String getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    public String getTypeLibelle() {
        return typeLibelle;
    }

    public float getCoefNotoriete() {
        return coefNotoriete;
    }

    public Medecin getMedecin(){
        return this;
    }

}
