package Ryhmatyo.Testi1;

import java.util.*;

/**
 * Created by Administrator on 29.9.2017.
 */
public class Kysymys {


    String kysymysteksti;
    List<String> vastausvaihtoehdot = new ArrayList<>();
    int oikeanVaihtoehdonIndeksi;
    List<Kysymys> kysymysLista = new ArrayList<>();


    public Kysymys() {

    }

    //Metodi luo uuden kysymyksen kolmella parametrilla
    public void luoKysymys(String kysymysteksti, List<String> vastausvaihtoehdot, int oikeanVaihtoehdonIndeksi) {
        this.kysymysteksti = kysymysteksti;
        this.vastausvaihtoehdot = vastausvaihtoehdot;
        this.oikeanVaihtoehdonIndeksi = oikeanVaihtoehdonIndeksi;

    }

    //Metodi luo vastausvaihtoehdot ja asettaa ne listaan.
    public void luoVastausvaihtoehdot(String a, String b, String c){
        vastausvaihtoehdot.add(a);
        vastausvaihtoehdot.add(b);
        vastausvaihtoehdot.add(c);
    }



    @Override
    public String toString() {
        return kysymysteksti + '\n'  +
                "0) " + vastausvaihtoehdot.get(0) + '\n' +
                "1) " + vastausvaihtoehdot.get(1) + '\n' +
                "2) " + vastausvaihtoehdot.get(2) + '\n';
    }
}


