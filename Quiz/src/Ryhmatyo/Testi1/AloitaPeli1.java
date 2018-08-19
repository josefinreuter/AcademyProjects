package Ryhmatyo.Testi1;

import java.util.List;

/**
 * Created by Administrator on 29.9.2017.
 * @author ChrisOlaf
 */
public class AloitaPeli1 {

    public void aloitaPeli (){

        //Luodaan tietovisan kysymykset
        Kysymys k1 = new Kysymys();
        k1.luoVastausvaihtoehdot("Kyllä", "Ei", "Ehkä");
        k1.luoKysymys("Onko hauki kala?", k1.vastausvaihtoehdot, 0);

        Kysymys k2 = new Kysymys();
        k2.luoVastausvaihtoehdot("Ei", "Ehkä", "Kyllä");
        k2.luoKysymys("Onko ahven kala?", k2.vastausvaihtoehdot, 2);

        Kysymys k3 = new Kysymys();
        k3.luoVastausvaihtoehdot("Yhdellä i:llä", "Kahdella i:llä", "Kolmella i:llä");
        k3.luoKysymys("Monella i-kirjaimellä S(x määrä i:tä)ri:n nimi kirjoitetaan?", k3.vastausvaihtoehdot, 1);

        Kysymys k4 = new Kysymys();
        k4.luoVastausvaihtoehdot("10011 oppilasta", "10100 oppilasta", "21 oppilasta");
        k4.luoKysymys("Montako oppilasta Academyssa on?", k4.vastausvaihtoehdot, 1);

        Kysymys k5 = new Kysymys();
        k5.luoVastausvaihtoehdot("Joooo!", "Tietenkin!", "Ehdottomasti :)");
        k5.luoKysymys("Onko tämä kivaa?", k5.vastausvaihtoehdot, 0);

        Kysymys k6 = new Kysymys();
        k6.luoVastausvaihtoehdot("Ctrl + V", "Ctrl + C", "Ctrl + X");
        k6.luoKysymys("Mikä pikakomento käytetään tiedostojen kopioimiseen?", k6.vastausvaihtoehdot, 1);

        Kysymys k7 = new Kysymys();
        k7.luoVastausvaihtoehdot("Ctrl + V", "Ctrl + C", "Ctrl + X");
        k7.luoKysymys("Mikä pikakomento käytetään tiedostojen liittämiseen?", k7.vastausvaihtoehdot, 0);

        Kysymys k8 = new Kysymys();
        k8.luoVastausvaihtoehdot("Ctrl + V", "Ctrl + C", "Ctrl + X");
        k8.luoKysymys("Mikä pikakomento käytetään tiedostojen leikkaamiseen?", k8.vastausvaihtoehdot, 2);

        Kysymys k9 = new Kysymys();
        k9.luoVastausvaihtoehdot("Pelkosenniemi", "Inari", "Utsjoki");
        k9.luoKysymys("Suomessa on yksi saamelaisenemmistöinen kunta, mikä?", k9.vastausvaihtoehdot, 2);

        Kysymys k10 = new Kysymys();
        k10.luoVastausvaihtoehdot("Lappelainen puukko", "Lappelainen muki", "Poronheittäjien lasso");
        k10.luoKysymys("Mikä on leuku?", k10.vastausvaihtoehdot, 0);

        Kysymys k11 = new Kysymys();
        k11.luoVastausvaihtoehdot("Yhdeksän", "Viisi", "Neljä");
        k11.luoKysymys("Montako aistia on kissalla?", k11.vastausvaihtoehdot, 1);

        Kysymys k12 = new Kysymys();
        k12.luoVastausvaihtoehdot("Ei virallisesti", "On kuulunut vuodesta 1950", "On kuulunut vuodesta 1995");
        k12.luoKysymys("Kuuluuko Suomi Skandinaviaan?", k12.vastausvaihtoehdot, 0);

        Kysymys k13 = new Kysymys();
        k13.luoVastausvaihtoehdot("Paistettua kalaa", "Keitettyä kalaa", "Kuivattua kalaa");
        k13.luoKysymys("Mitä on kapakala?", k13.vastausvaihtoehdot, 2);

        Kysymys k14 = new Kysymys();
        k14.luoVastausvaihtoehdot("Mauste", "Rasvatonta maitoa", "Jotain muuta");
        k14.luoKysymys("Mitä on kurri?", k14.vastausvaihtoehdot, 1);

        Kysymys k15 = new Kysymys();
        k15.luoVastausvaihtoehdot("Voitolta!", "Aivan mahtavalta :)", "Ei miltään");
        k15.luoKysymys("Miltä tuntui kun sai tietovisan toimimaan?", k15.vastausvaihtoehdot, 0);

        //Luodaan kysymyslista
        Kysymys k = new Kysymys();
        k.kysymysLista.add(k1);
        k.kysymysLista.add(k2);
        k.kysymysLista.add(k3);
        k.kysymysLista.add(k4);
        k.kysymysLista.add(k5);
        k.kysymysLista.add(k6);
        k.kysymysLista.add(k7);
        k.kysymysLista.add(k8);
        k.kysymysLista.add(k9);
        k.kysymysLista.add(k10);
        k.kysymysLista.add(k11);
        k.kysymysLista.add(k12);
        k.kysymysLista.add(k13);
        k.kysymysLista.add(k14);
        k.kysymysLista.add(k15);


        //Luodaan uusi Pelaa-olio ja kutsutaan Pelaa-luokan metodit
        Pelaa p = new Pelaa();
        p.pelinKulkuKahdella(k.kysymysLista);
        //p.pelinKulkuYhdella(k.kysymysLista);


    }


}
