package com.example.kaydegroot.de_familie_yggdrasil.Classes;

/**
 * Created by kay de groot on 9-10-2015.
 */
public class Datum {
    private int dag;
    private int maand;
    private int jaar;

    public Datum(int dag, int maand, int jaar) {
        this.dag = dag;
        this.maand = maand;
        this.jaar = jaar;
    }

    public Datum(String date){
        fromString(date);
    }

    @Override
    public String toString() {
        return dag + "-" + maand + "-" + jaar;
    }

    public void fromString(String d){
        String[] tijd = d.split("-");
        this.dag= Integer.parseInt(tijd[0]);
        this.maand= Integer.parseInt(tijd[1]);
        this.jaar= Integer.parseInt(tijd[2]);
    }

    public int getDag() {
        return dag;
    }

    public void setDag(int dag) {
        this.dag = dag;
    }

    public int getMaand() {
        return maand;
    }

    public void setMaand(int maand) {
        this.maand = maand;
    }

    public int getJaar() {
        return jaar;
    }

    public void setJaar(int jaar) {
        this.jaar = jaar;
    }
}
