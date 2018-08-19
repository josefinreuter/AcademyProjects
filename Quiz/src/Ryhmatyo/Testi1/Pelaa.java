package Ryhmatyo.Testi1;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Administrator on 30.9.2017.
 */
public class Pelaa {


    public void pelinKulkuYhdella(List<Kysymys> kysymysLista){
        Kysymys k = new Kysymys();
        k.kysymysLista = kysymysLista;


        Random rnd = new Random();
        int arvottavienLkm = 10;
        int pisteet = 0;

        for (int i = 0; i <arvottavienLkm; i++) {

            int index = rnd.nextInt(kysymysLista.size());

            System.out.println(i + 1 +". " + kysymysLista.get(index));
            System.out.println("Anna Vastauksesi: ");
            try {
                Scanner lukija = new Scanner(System.in);
                String vastaus = lukija.nextLine();
                if(vastaus.trim().equals("")){
                    System.out.println("Väärä vastaus :( Oikea vastaus olisi ollut: " + kysymysLista.get(index).oikeanVaihtoehdonIndeksi + ")");
                    System.out.println("Pisteesi: " + pisteet);
                    System.out.println("--------------------------------------------" );
                    System.out.println("  ");
                    continue;
                }
                int v = Integer.parseInt(vastaus);
                if (v == (kysymysLista.get(index).oikeanVaihtoehdonIndeksi)) {
                    System.out.println("HYVIN MENI!");
                    pisteet++;
                    System.out.println("Pisteesi: " + pisteet);
                    System.out.println("--------------------------------------------" );
                    System.out.println("  ");
                }else{
                    System.out.println("Väärä vastaus :( Oikea vastaus olisi ollut: " + kysymysLista.get(index).oikeanVaihtoehdonIndeksi + ")");
                    System.out.println("Pisteesi: " + pisteet);
                    System.out.println("--------------------------------------------" );
                    System.out.println("  ");
                }
            } catch (Exception e) {
                System.out.println("OHO! Annoit kirjaimen, siinä meni vuorosi :(");
                System.out.println("--------------------------------------------" );
                System.out.println("  ");
            }

            kysymysLista.remove(index);

        }

        System.out.println("Peli loppui, sait " + pisteet + " pistettä!");
        System.out.println("--------------------------------------------" );
        System.out.println("  ");
    }


    public void pelinKulkuKahdella(List<Kysymys> kysymysLista){
        Kysymys k = new Kysymys();
        k.kysymysLista = kysymysLista;

        Random rnd = new Random();
        int arvottavienLkm = 10;
        int pisteetPel1 = 0;
        int pisteetPel2 = 0;
        String pelaaja1 = null;
        String pelaaja2 = null;
        Scanner lukija = new Scanner(System.in);


        System.out.println("Anna pelaajatunnuksesi pelaaja 1: ");
        pelaaja1 = lukija.nextLine();
        System.out.println("Anna pelaajatunnuksesi pelaaja 2: ");
        pelaaja2 = lukija.nextLine();

        for (int i = 0; i <arvottavienLkm; i++) {

            int index = rnd.nextInt(kysymysLista.size());

            System.out.println("---------------------------------------------");
            System.out.println(i + 1 +". " + kysymysLista.get(index));
            System.out.println("Anna vastauksesi " + pelaaja1 + ": ");
            try {
                String vastaus1 = lukija.nextLine();
                if(vastaus1.trim().equals("")){
                    i--;
                    continue;
                }
                int v1 = Integer.parseInt(vastaus1);
                if (v1 == (kysymysLista.get(index).oikeanVaihtoehdonIndeksi)) {
                    pisteetPel1++;

                }
            } catch (Exception e) {
                System.out.println("OHO! Annoit kirjaimen, siinä meni vuorosi :(");
                System.out.println("  ");
            }

            System.out.println("Anna vastauksesi " + pelaaja2 +": ");
            try{
                String vastaus2 = lukija.nextLine();
                if(vastaus2.trim().equals("")){
                    i--;
                    if(pisteetPel1 > 0){
                        pisteetPel1--;
                    }
                    System.out.println("  ");
                    System.out.println("Oikea vastaus oli: " + kysymysLista.get(index).oikeanVaihtoehdonIndeksi + ")");
                    System.out.println("  ");
                    System.out.println("Pistetilanne:");
                    System.out.println(pelaaja1 + ": " + pisteetPel1 + " pistettä.");
                    System.out.println(pelaaja2 + ": " + pisteetPel2 + " pistettä.");
                    System.out.println("  ");
                    continue;
                }
                int v2 = Integer.parseInt(vastaus2);
                if (v2 == (kysymysLista.get(index).oikeanVaihtoehdonIndeksi)) {
                    pisteetPel2++;
                }

                System.out.println("  ");
                System.out.println("Oikea vastaus oli: " + kysymysLista.get(index).oikeanVaihtoehdonIndeksi + ")");
                System.out.println("  ");
                System.out.println("Pistetilanne:");
                System.out.println(pelaaja1 + ": " + pisteetPel1 + " pistettä.");
                System.out.println(pelaaja2 + ": " + pisteetPel2 + " pistettä.");
                System.out.println("  ");

            }catch (Exception e){
                System.out.println("OHO! Annoit kirjaimen, siinä meni vuorosi :(");
                System.out.println("  ");
            }

            kysymysLista.remove(index);

        }

        System.out.println("---------------------------------------------");
        System.out.println("Peli loppui");
        System.out.println(pelaaja1 + " sai " + pisteetPel1 + " pistettä!");
        System.out.println(pelaaja2 + " sai " + pisteetPel2 + " pistettä!");
        if(pisteetPel1 != pisteetPel2) {
            System.out.println(pisteetPel1 > pisteetPel2 ? "Onneksi olkoon " + pelaaja1 + ", sinä voitit!" : "Onneksi olkoon " + pelaaja2 + ", sinä voitit!");
        }else{
            System.out.println("Tasapeli! :)");
        }
        System.out.println("--------------------------------------------" );
        System.out.println("  ");
    }

}



