package com.example.gsb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DepartementObjet {
    private int numero;


    /**
     * convertion d'une réponse json en objet DepartementObjet
     * @param numero
     */
    @JsonCreator
    public DepartementObjet(@JsonProperty("DEPARTEMENT") int numero){
        this.numero = numero;
    }


    /**
     * redéfinition de la méthode toString
     * @return
     */

    @Override
    public String toString(){
        return "Numéro de département : " + this.numero;
    }
}
