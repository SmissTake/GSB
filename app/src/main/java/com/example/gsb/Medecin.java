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

    /**
     * création à partir d'une reponse json de l'objet Medecin
     * @param numero
     * @param nom
     * @param prenom
     * @param adresse
     * @param codePostal
     * @param ville
     * @param typeLibelle
     * @param coefNotoriete
     */

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

    /**
     *  redéfinitionde la méthode toString
     * @return
     */
    @Override
    public String toString(){
        return "Num " + this.numero + ", " + this.nom + " " + this.prenom + "/n" + this.adresse + ", " + this.codePostal + " " + this.ville + "/n Coef de notoriété : " + this.coefNotoriete;
    }

    /**
     * setter de numéro
     * @param numero
     */

    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * setter de nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * setter de prenom
     * @param prenom
     */

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * setter d'adresse
     * @param adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * setter de code postal
     * @param codePostal
     */

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * setter de ville
     * @param ville
     */

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setTypeLibelle(String typeLibelle) {
        this.typeLibelle = typeLibelle;
    }

    /**
     * setter de coefNotoriete
     * @param coefNotoriete
     */
    public void setCoefNotoriete(float coefNotoriete) {
        this.coefNotoriete = coefNotoriete;
    }

    /**
     * getter de numero
     * @return
     */
    public int getNumero() {
        return numero;
    }

    /**
     * getter de nom
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * getter de prenom
     * @return
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * getter d'adresse
     * @return
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * getter de code postal
     * @return
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * getter de ville
     * @return
     */
    public String getVille() {
        return ville;
    }

    /**
     * getter de typeLibelle
     * @return
     */
    public String getTypeLibelle() {
        return typeLibelle;
    }

    /**
     * getter de coefNotoriete
     * @return
     */
    public float getCoefNotoriete() {
        return coefNotoriete;
    }

    /**
     * retourne l'objet médecin
     * @return
     */
    public Medecin getMedecin(){
        return this;
    }

}
