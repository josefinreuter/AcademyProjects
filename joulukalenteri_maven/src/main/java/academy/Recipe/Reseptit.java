package academy.Recipe;
//Written by Riina Purovesi 2017
import javax.persistence.*;

@Entity
public class Reseptit {
    @Id
    @GeneratedValue
    private int reseptiid;
    private String nimi;
    private String kuvaus;

    public int getReseptiid() {
        return reseptiid;
    }

    public void setReseptiid(int reseptiid) {
        this.reseptiid = reseptiid;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }
}
