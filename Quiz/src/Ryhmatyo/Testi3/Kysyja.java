package Ryhmatyo.Testi3;

/**
 * Created by Administrator on 3.10.2017.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kysyja {

private List<Kysymys> kysymyslista;

public Kysyja() {
List<String> vastaukset1;
kysymyslista = new ArrayList<>();
vastaukset1 = new ArrayList<>();
Kysymys kysymys1 = new Kysymys("Missä Academic Workilla ei ole toimistoa?", vastaukset1, 2);
vastaukset1.add("Helsingissä");
vastaukset1.add("Espsa");
vastaukset1.add("Rovaniemellä");

List<String> vastaukset2 = new ArrayList<>();
Kysymys kysymys2 = new Kysymys("Missä ahkerat Academylaiset opiskelevat? ", vastaukset2, 0);
vastaukset2.add("Espoossa");
vastaukset2.add("Tampereella");
vastaukset2.add("Kouvolassa");

List<String> vastaukset3 = new ArrayList<>();
Kysymys kysymys3 = new Kysymys("Milloin Academylaiset valmistuvat? ", vastaukset3, 0);
vastaukset3.add("Joulukuussa");
vastaukset3.add("Vuoden kuluttua");
vastaukset3.add("Academy kestää ikuisesti");

List<String> vastaukset4 = new ArrayList<>();
Kysymys kysymys4 = new Kysymys("Ovatko Academylaiset hyviä tyyppejä? ", vastaukset4, 1);
vastaukset4.add("No en nyt sanoisi...");
vastaukset4.add("Todellakin!");
vastaukset4.add("Toisinaan");

List<String> vastaukset5 = new ArrayList<>();
Kysymys kysymys5 = new Kysymys ("Kuinka monta oppilasta Academyssa on? ", vastaukset5, 2);
vastaukset5.add("2");
vastaukset5.add("100");
vastaukset5.add("20");

List<String> vastaukset6 = new ArrayList<>();
Kysymys kysymys6 = new Kysymys ("Onko koodaaminen kivaa ", vastaukset6, 1);
vastaukset6.add("Ei todellakaan");
vastaukset6.add("Todellakin!");
vastaukset6.add("Mikä ihmeen koodaaminen?");

List<String> vastaukset7 = new ArrayList<>();
Kysymys kysymys7 = new Kysymys ("Kuka ei ole Academyssa opettajana? ", vastaukset7, 2);
vastaukset7.add("Tommi");
vastaukset7.add("Samu");
vastaukset7.add("Donald Trump");

List<String> vastaukset8 = new ArrayList<>();
Kysymys kysymys8 = new Kysymys ("Kuinka monta i-kirjainta on S(x määrä i:tä)ri:n nimessä? ", vastaukset8, 1);
vastaukset8.add("1");
vastaukset8.add("2");
vastaukset8.add("3");

List<String> vastaukset9 = new ArrayList<>();
Kysymys kysymys9 = new Kysymys ("Valmistuuko länsimetro koskaan? ", vastaukset9, 0);
vastaukset9.add("Toivottavasti");
vastaukset9.add("Kyllä, ensi viikolla");
vastaukset9.add("Ei, Länsimetro on purettu");

List<String> vastaukset10 = new ArrayList<>();
Kysymys kysymys10 = new Kysymys ("Kuka seuraavista ei ole Academyn oppilas? ", vastaukset10, 2);
vastaukset10.add("Jake");
vastaukset10.add("Pekka");
vastaukset10.add("Donald Trump");

List<String> vastaukset11 = new ArrayList<>();
Kysymys kysymys11 = new Kysymys ("Kuinka paljon Academylaiset koodaavat koulutuksensa aikana", vastaukset11, 2);
vastaukset11.add("Mitä on koodaus?");
vastaukset11.add("Eivät yhtään");
vastaukset11.add("Paljon");

kysymyslista.add(kysymys1);
kysymyslista.add(kysymys2);
kysymyslista.add(kysymys3);
kysymyslista.add(kysymys4);
kysymyslista.add(kysymys5);
kysymyslista.add(kysymys6);
kysymyslista.add(kysymys7);
kysymyslista.add(kysymys8);
kysymyslista.add(kysymys9);
kysymyslista.add(kysymys10);
kysymyslista.add(kysymys11);
}

public void sekoitetaanKysymykset() {

Collections.shuffle(kysymyslista);
}






public Kysymys tulostaKysymys(int kysymyksenindeksi) {
Kysymys kysymys = this.kysymyslista.get(kysymyksenindeksi);
System.out.println(kysymys);
return kysymys;
}
}
