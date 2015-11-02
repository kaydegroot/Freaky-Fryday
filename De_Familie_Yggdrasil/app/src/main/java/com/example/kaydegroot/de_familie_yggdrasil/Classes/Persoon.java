package com.example.kaydegroot.de_familie_yggdrasil.Classes;

/**
 * Created by kay de groot on 9-10-2015.
 */
public class Persoon {
    private int ID;
    private String roepnaam;
    private String geboortenaam;
    private String achternaam;
    private String tussenvoegsel;
    private Datum geboortedatum;
    private Datum overlijdinsdatum;
    private int generatie;
    private int ouder1ID;
    private int ouder2ID;

    public Persoon(int ID, String roepnaam, String geboortenaam, String achternaam, String tussenvoegsel, Datum geboortedatum, int generatie, int ouder1ID, int ouder2ID) {
        this.ID = ID;
        this.roepnaam = roepnaam;
        this.geboortenaam = geboortenaam;
        this.achternaam = achternaam;
        this.tussenvoegsel = tussenvoegsel;
        this.geboortedatum = geboortedatum;
        this.overlijdinsdatum = null;
        this.generatie = generatie;
        this.ouder1ID = ouder1ID;
        this.ouder2ID = ouder2ID;
        this.overlijdinsdatum=null;
    }

    public Persoon(int ID, String roepnaam, String geboortenaam, String achternaam, String tussenvoegsel, Datum geboortedatum, Datum overlijdinsdatum, int generatie, int ouder1ID, int ouder2ID) {
        this.ID = ID;
        this.roepnaam = roepnaam;
        this.geboortenaam = geboortenaam;
        this.achternaam = achternaam;
        this.tussenvoegsel = tussenvoegsel;
        this.geboortedatum = geboortedatum;
        this.overlijdinsdatum = overlijdinsdatum;
        this.generatie = generatie;
        this.ouder1ID = ouder1ID;
        this.ouder2ID = ouder2ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRoepnaam() {
        return roepnaam;
    }

    public void setRoepnaam(String roepnaam) {
        this.roepnaam = roepnaam;
    }

    public String getGeboortenaam() {
        return geboortenaam;
    }

    public void setGeboortenaam(String geboortenaam) {
        this.geboortenaam = geboortenaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public Datum getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Datum geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public Datum getOverlijdinsdatum() {
        return overlijdinsdatum;
    }

    public void setOverlijdinsdatum(Datum overlijdinsdatum) {
        this.overlijdinsdatum = overlijdinsdatum;
    }

    public int getGeneratie() {
        return generatie;
    }

    public void setGeneratie(int generatie) {
        this.generatie = generatie;
    }

    public int getOuder1ID() {
        return ouder1ID;
    }

    public void setOuder1ID(int ouder1ID) {
        this.ouder1ID = ouder1ID;
    }

    public int getOuder2ID() {
        return ouder2ID;
    }

    public void setOuder2ID(int ouder2ID) {
        this.ouder2ID = ouder2ID;
    }
}
