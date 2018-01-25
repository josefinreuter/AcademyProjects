package academy.Quiz;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Vastaukset {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String teksti;
    private boolean oikeavastaus;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kysymysid")@JsonIgnore
    private Kysymykset kysymykset;

    public Kysymykset getKysymykset() {
        return kysymykset;
    }

    public void setKysymykset(Kysymykset kysymykset) {
        this.kysymykset = kysymykset;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeksti() {
        return teksti;
    }

    public void setTeksti(String teksti) {
        this.teksti = teksti;
    }

    public boolean getOikeavastaus() {
        return oikeavastaus;
    }

    public void setOikeavastaus(boolean oikeavastaus) {
        this.oikeavastaus = oikeavastaus;
    }

}
