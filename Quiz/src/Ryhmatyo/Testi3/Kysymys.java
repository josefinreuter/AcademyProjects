package Ryhmatyo.Testi3;

/**
 * Created by Administrator on 3.10.2017.
 */
import java.util.List;


public class Kysymys {

private String kysymysteksti;
private List<String> vastausvaihtoehdot;
private int oikeavastausindeksi;


public Kysymys(String kysymysteksti, List<String> vastausvaihtoehdot, int oikeavastausindeksi) {


        this.kysymysteksti = kysymysteksti;
        this.vastausvaihtoehdot = vastausvaihtoehdot;
        this.oikeavastausindeksi = oikeavastausindeksi;
    }


    public int getOikeavastausindeksi() {
return oikeavastausindeksi;
}

@Override
public String toString() {
    return kysymysteksti + '\n' +
            "0 " + vastausvaihtoehdot.get(0) + '\n' +
            "1 " + vastausvaihtoehdot.get(1) + '\n' +
            "2 " + vastausvaihtoehdot.get(2) + '\n';
}
}

