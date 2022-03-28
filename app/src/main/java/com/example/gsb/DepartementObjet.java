package com.example.gsb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DepartementObjet {
    private int numero;

    @JsonCreator
    public DepartementObjet(@JsonProperty("DEPARTEMENT") int numero){
        this.numero = numero;
    }
    @Override
    public String toString(){
        return "Numéro de département : " + this.numero;
    }
}
