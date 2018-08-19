package Ryhmatyo.Testi2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 29/09/2017.
 */
public class AloitaPeli2 {

    public void aloitaPeli() {

        Scanner s = new Scanner(System.in);
        Visailu visa = new Visailu();
        // tervehdys
        System.out.println("Tervetuloa Yleistieto2017-visaan!");
        System.out.println("Visassa on kymmenen kysymystä, joista jokaisessa on kolme vastausvaihtoehtoa.");
        System.out.println("Syötä vastaukseksi oikean vaihtoehdon numero (0, 1, tai 2).");


        while (visa.hasNextQuestion()) {
            System.out.println(visa.getKysymysTeksti());
            ArrayList vastaukset = visa.getVastausVaihtoehdot();
            for (int i=0; i<vastaukset.size(); i++) {
                System.out.print(i + ") " + vastaukset.get(i) + "  ");
            }
            String vastaus = s.nextLine();
            visa.tarkistaVastaus(vastaus);
            //??? printtaa oikein tai väärin
        }
        System.out.println("Onnea! Sait " + visa.getPisteet() + " oikein" +
                " 10 kysymyksestä.");
    }

}
