package com.example.mathias.autonomiaapp;

import java.io.Serializable;
import io.realm.RealmObject;

/**
 * Created by Mathias on 02/12/2017.
 */

public class Autonomia extends RealmObject implements Serializable {
    private double kilometragem;
    private double litros;
    private String dataA;
    private String posto;

    public Autonomia(){

    }

    public Autonomia(double kilometragem, double litros, String dataA, String posto){
        this.kilometragem = kilometragem;
        this.litros = litros;
        this.dataA = dataA;
        this.posto = posto;

    }
    public double getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(double kilometragem) {
        this.kilometragem = kilometragem;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public String getDataA() {
        return dataA;
    }

    public void setDataA(String dataA) {
        this.dataA = dataA;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }
}