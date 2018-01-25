//written by Hennileena Calonius 2017
package academy.Translator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Sanakirja {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int lauseid;
    private String suomi;
    private String ruotsi;
    private String englanti;
    private String espanja;
    private String ranska;

    public int getLauseid() {
        return lauseid;
    }

    public void setLauseid(int lauseid) {
        this.lauseid = lauseid;
    }

    public String getSuomi() {
        return suomi;
    }

    public void setSuomi(String suomi) {
        this.suomi = suomi;
    }

    public String getRuotsi() {
        return ruotsi;
    }

    public void setRuotsi(String ruotsi) {
        this.ruotsi = ruotsi;
    }

    public String getEnglanti() {
        return englanti;
    }

    public void setEnglanti(String englanti) {
        this.englanti = englanti;
    }

    public String getEspanja() {
        return espanja;
    }

    public void setEspanja(String espanja) {
        this.espanja = espanja;
    }

    public String getRanska() {
        return ranska;
    }

    public void setRanska(String ranska) {
        this.ranska = ranska;
    }
}
