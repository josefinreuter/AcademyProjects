package Ryhmatyo.Testi3;

import java.util.Scanner;

/**
 * Created by Administrator on 3.10.2017.
 */
public class AloitaPeli3 {



public void aloitaPeli() {
    Scanner lukija = new Scanner(System.in);
    Kysyja kysyja = new Kysyja();
    kysyja.sekoitetaanKysymykset();
    int pisteet = 0;
    int indeksi = 0;

    for (int i = 0; i < 10; i++) {
        Kysymys kysymys = kysyja.tulostaKysymys(indeksi);
    System.out.print("Anna vastauksen numero: ");
    int vastaus = Integer.parseInt(lukija.nextLine());
    if (vastaus == kysymys.getOikeavastausindeksi()) {
    System.out.println("\n"+ "Oikein! Sait pisteen!");
    pisteet++;
    System.out.println("Pisteesi: " + pisteet + "\n");
    indeksi++;
    } else {
    System.out.println("Väärä vastaus! Peli päättyi!");
    System.out.println("Pisteesi: " + pisteet);
    break;
}

}
}
    }
