package fi.academy.papu;

import java.io.Serializable;

public class Viesti implements Serializable{
    private String otsikko;
    private String nimimerkki;
    private String ajankohta;
    private String viesti;
    private int hloID;
    private int viestiID;
    private int vastausID;
    private int alueID;

    public Viesti() {
    }

    public Viesti(String otsikko, String nimimerkki, String ajankohta, String viesti, int hloID, int viestiID, int vastausID, int alueID) {
        this.otsikko = otsikko;
        this.nimimerkki = nimimerkki;
        this.ajankohta = ajankohta;
        this.viesti = viesti;
        this.hloID = hloID;
        this.viestiID = viestiID;
        this.vastausID = vastausID;
        this.alueID = alueID;
    }

    public String getOtsikko() {
        return otsikko;
    }

    public void setOtsikko(String otsikko) {
        this.otsikko = otsikko;
    }

    public String getNimimerkki() {
        return nimimerkki;
    }

    public void setNimimerkki(String nimimerkki) {
        this.nimimerkki = nimimerkki;
    }

    public String getAjankohta() {
        return ajankohta;
    }

    public void setAjankohta(String ajankohta) {
        this.ajankohta = ajankohta;
    }

    public String getViesti() {
        return viesti;
    }

    public void setViesti(String viesti) {
        this.viesti = viesti;
    }

    public int getHloID() {
        return hloID;
    }

    public void setHloID(int hloID) {
        this.hloID = hloID;
    }

    public int getViestiID() {
        return viestiID;
    }

    public void setViestiID(int viestiID) {
        this.viestiID = viestiID;
    }

    public int getVastausID() {
        return vastausID;
    }

    public void setVastausID(int vastausID) {
        this.vastausID = vastausID;
    }

    public int getAlueID() {
        return alueID;
    }

    public void setAlueID(int alueID) {
        this.alueID = alueID;
    }

}


