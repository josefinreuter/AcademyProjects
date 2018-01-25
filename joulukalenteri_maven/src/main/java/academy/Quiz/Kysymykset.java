package academy.Quiz;

import javax.persistence.*;
import java.util.List;

@Entity
public class Kysymykset {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String kysymys;

    @OneToMany(mappedBy = "kysymykset", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vastaukset> vastaukset;

    public List<Vastaukset> getVastaukset() {
        return vastaukset;
    }

    public void setVastaukset(List<Vastaukset> vastaukset) {
        this.vastaukset = vastaukset;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKysymys() {
        return kysymys;
    }

    public void setKysymys(String kysymys) {
        this.kysymys = kysymys;
    }
}
