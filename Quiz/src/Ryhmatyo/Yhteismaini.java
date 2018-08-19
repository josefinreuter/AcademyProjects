package Ryhmatyo;

import Ryhmatyo.Testi1.AloitaPeli1;
import Ryhmatyo.Testi2.AloitaPeli2;
import Ryhmatyo.Testi3.AloitaPeli3;

import java.util.Scanner;

/**
 * Created by Administrator on 3.10.2017.
 */
public class Yhteismaini {
    public static void main(String[] args) {
        int valinta = 0;

        while (true) {
        System.out.println("Valitse peli 1, 2 tai 3: ");
        Scanner lukija = new Scanner(System.in);
        valinta = lukija.nextInt();

            if (valinta == 1) {
                AloitaPeli1 luo = new AloitaPeli1();
                luo.aloitaPeli();
            } else if (valinta == 2) {
                AloitaPeli2 tee = new AloitaPeli2();
                tee.aloitaPeli();
            } else if (valinta == 3) {
                AloitaPeli3 aja = new AloitaPeli3();
                aja.aloitaPeli();
            }
        }
    }
}
