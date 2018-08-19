package Ryhmatyo.Testi2;
import java.util.ArrayList;

public class Kysymys {
 private String kysymys;
 private int oikeavastaus;
 private ArrayList<String> vastausVaihtoehdot = new ArrayList<>();

 public String getKysymys() {
     return kysymys;
 }

 public void setKysymys(String kysymys) {
    this.kysymys = kysymys;
 }

 public Integer getOikeaVastaus() {
    return oikeavastaus;
 }

 public void setOikeaVastaus(int oikeavastaus) {
    this.oikeavastaus = oikeavastaus;
 }

 public ArrayList<String> getVastausVaihtoehdot() {
    return vastausVaihtoehdot;
 }

 public void setVastausVaihtoehdot(ArrayList<String> vastausVaihtoehdot) {
    this.vastausVaihtoehdot = vastausVaihtoehdot;
 }
 }
