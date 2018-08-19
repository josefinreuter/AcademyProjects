package Ryhmatyo.Testi2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Visailu {
    private int counter;
    private int pisteet;
    List<Kysymys> kysymykset = new ArrayList<>();

    public Visailu() {
        Kysymys k1 = new Kysymys();
        k1.setKysymys("Mikä Euroviisubiisi voitti Eurovision-laulukisat vuonna 1975?");
        ArrayList<String> vastausvaihtoehdot1 = new ArrayList<>();
        vastausvaihtoehdot1.add("Waterloo");
        vastausvaihtoehdot1.add("Ding a Dong");
        vastausvaihtoehdot1.add("Hallelujah");
        k1.setVastausVaihtoehdot(vastausvaihtoehdot1);
        k1.setOikeaVastaus(1);
        kysymykset.add(k1);

        Kysymys k2 = new Kysymys();
        k2.setKysymys("Minä vuonna alkoi ranskan vallankumous?");
        ArrayList<String> vastausvaihtoehdot2 = new ArrayList<>();
        vastausvaihtoehdot2.add("1798");
        vastausvaihtoehdot2.add("1897");
        vastausvaihtoehdot2.add("1978");
        k2.setVastausVaihtoehdot(vastausvaihtoehdot2);
        k2.setOikeaVastaus(0);
        kysymykset.add(k2);

        Kysymys k3 = new Kysymys();
        k3.setKysymys("Onko Suomen koripallomaajoukkueen lempinimi?");
        ArrayList<String> vastausvaihtoehdot3 = new ArrayList<>();
        vastausvaihtoehdot3.add("Kettuposse");
        vastausvaihtoehdot3.add("Susijengi");
        vastausvaihtoehdot3.add("Karhuryhmä");
        k3.setVastausVaihtoehdot(vastausvaihtoehdot3);
        k3.setOikeaVastaus(1);
        kysymykset.add(k3);

        Kysymys k4 = new Kysymys();
        k4.setKysymys("Kuka suunnitteli Kiasman?");
        ArrayList<String> vastausvaihtoehdot4 = new ArrayList<>();
        vastausvaihtoehdot4.add("Alvar Aalto");
        vastausvaihtoehdot4.add("Carl Ludvig Engel");
        vastausvaihtoehdot4.add("Steven Hall");
        k4.setVastausVaihtoehdot(vastausvaihtoehdot4);
        k4.setOikeaVastaus(2);
        kysymykset.add(k4);

        Kysymys k5 = new Kysymys();
        k5.setKysymys("Mikä on Suomen kansallisperhonen?");
        ArrayList<String> vastausvaihtoehdot5 = new ArrayList<>();
        vastausvaihtoehdot5.add("Neitoperhonen");
        vastausvaihtoehdot5.add("Angervohopetäplä");
        vastausvaihtoehdot5.add("Paatsamasinisiipi");
        k5.setVastausVaihtoehdot(vastausvaihtoehdot5);
        k5.setOikeaVastaus(2);
        kysymykset.add(k5);

        Kysymys k6 = new Kysymys();
        k6.setKysymys("Kuka on Ville Saksi?");
        ArrayList<String> vastausvaihtoehdot6 = new ArrayList<>();
        vastausvaihtoehdot6.add("Terrafamen toimitusjohtaja");
        vastausvaihtoehdot6.add("Länsimetro Oy:n toimitusjohtaja");
        vastausvaihtoehdot6.add("VR:n toimitusjohtaja");
        k6.setVastausVaihtoehdot(vastausvaihtoehdot6);
        k6.setOikeaVastaus(1);
        kysymykset.add(k6);

        Kysymys k7 = new Kysymys();
        k7.setKysymys("Mikä on tunnetun suomalaisräppärin Pikku G:n oikea nimi?");
        ArrayList<String> vastausvaihtoehdot7 = new ArrayList<>();
        vastausvaihtoehdot7.add("Henri Vähäkainu");
        vastausvaihtoehdot7.add("Jare Tiihonen");
        vastausvaihtoehdot7.add("Dan Tolppanen");
        k7.setVastausVaihtoehdot(vastausvaihtoehdot7);
        k7.setOikeaVastaus(1);
        kysymykset.add(k7);

        Kysymys k8 = new Kysymys();
        k8.setKysymys("Kuinka monta kirjaa on kirjasarjassa Harry Potter?");
        ArrayList<String> vastausvaihtoehdot8 = new ArrayList<>();
        vastausvaihtoehdot8.add("Enemmän kuin 4");
        vastausvaihtoehdot8.add("8");
        vastausvaihtoehdot8.add("7");
        k8.setVastausVaihtoehdot(vastausvaihtoehdot8);
        k8.setOikeaVastaus(2);
        kysymykset.add(k8);

        Kysymys k9 = new Kysymys();
        k9.setKysymys("Mikä on Tuvalun pääkaupunki?");
        ArrayList<String> vastausvaihtoehdot9 = new ArrayList<>();
        vastausvaihtoehdot9.add("Futanafu");
        vastausvaihtoehdot9.add("Fifitata");
        vastausvaihtoehdot9.add("Funafuti");
        k9.setVastausVaihtoehdot(vastausvaihtoehdot9);
        k9.setOikeaVastaus(2);
        kysymykset.add(k9);

        Kysymys k10 = new Kysymys();
        k10.setKysymys("Kuka kouluttaa parhaita IT-konsultteja?");
        ArrayList<String> vastausvaihtoehdot10 = new ArrayList<>();
        vastausvaihtoehdot10.add("Academy");
        vastausvaihtoehdot10.add("Amiedu");
        vastausvaihtoehdot10.add("Trainer's House");
        k10.setVastausVaihtoehdot(vastausvaihtoehdot10);
        k10.setOikeaVastaus(0);
        kysymykset.add(k10);

        Collections.shuffle(kysymykset);

        this.counter = 0;
        this.pisteet = 0;
    }

    public String getKysymysTeksti() {
        return kysymykset.get(counter).getKysymys();
    }

    public ArrayList getVastausVaihtoehdot() {
        return kysymykset.get(counter).getVastausVaihtoehdot();
    }

    public boolean tarkistaVastaus(String pelaajanVastaus) {
        boolean tulos = false;
        if (kysymykset.get(counter).getOikeaVastaus().toString().equals(pelaajanVastaus)) {
            pisteet++;
            tulos = true;
        }
        counter++;
        return tulos;
    }

    public int getPisteet() {
        return this.pisteet;
    }

    public boolean hasNextQuestion() {
        if (this.counter < this.kysymykset.size()) return true;
        return false;
    }

}