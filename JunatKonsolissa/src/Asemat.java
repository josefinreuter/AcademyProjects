import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.util.*;
import static java.lang.Integer.parseInt;
import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.ChronoUnit.SECONDS;
import static java.util.Collections.sort;
/**
 * Created by Minna Vares on 17.10.2017.
 * Tässä luokassa voidaan hakea asemittain saapuvia ja lähteviä junia.}
 */
public class Asemat {
    public static Koodinmurtaja kaanna = new Koodinmurtaja();
    /*Tällä metodilla haetaan tietyn
    aseman data annetun urlin perusteella*/
    private static List<Juna> lueAsemanJSONData(String urli) {
        String baseurl = "https://rata.digitraffic.fi/api/v1";
        String jatkoUrl = urli;
        List<Juna> junat = new ArrayList<>();
        try {
            URL url = new URL(baseurl + jatkoUrl);
            ObjectMapper mapper = new ObjectMapper();
            CollectionType tarkempiListanTyyppi = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Juna.class);
            junat = mapper.readValue(url, tarkempiListanTyyppi);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return junat;
    }
    /*Tämä metodi palauttaa taulukkotulosteen
    tietyn aseman lahtevista junista juuri tällä hetkellä +-60 min
    URL: /live-trains/station/<station_shortcode>?minutes_before_departure=<minutes_before_departure>&minutes_after_departure=<minutes_after_departure>&minutes_before_arrival=<minutes_before_arrival>&minutes_after_arrival=<minutes_after_arrival>&version=<change_number>&includeNonstopping=<includeNonstopping
    Esimerkiksi: /live-trains/station/HKI?minutes_before_departure=15&minutes_after_departure=15&minutes_before_arrival=15&minutes_after_arrival=15
     /live-trains/station/HKI?arrived_trains=5&arriving_trains=&5departed_trains=5&departing_trains=5&include_nonstopping=false
    */
    public static void lahtevatJunatNyt(String asema) {
        String asemanNimi = kaanna.murraKoodi(asema);
        try{System.out.println("Lähtevät junat asemalta " + asemanNimi + ":");
            String osoite = "/live-trains/station/" + asema + "?arrived_trains=0&arriving_trains=0&departed_trains=0&departing_trains=20&include_nonstopping=false";
            List<Juna> asemanJunat = lueAsemanJSONData(osoite);
            luoJunaTaulukkoLahtevat(asemanJunat, asema);
            System.out.println();
        }catch (Exception e){
            System.out.println("Tietoja ei voida lukea asemalta "+asema+". Asemaa ei ehkä ole" );
        }
    }
    /*Tämä metodi palauttaa taulukkotulosteen tietyn
        aseman saapuvista junista juuri tällä hetkellä
        /live-trains/station/HKI?minutes_before_departure=15&minutes_after_departure=15&minutes_before_arrival=15&minutes_after_arrival=15
        tai arrived_trains=0&arriving_trains=20&departed_trains=0&departing_trains=0&include_nonstopping=false
*/
    public static void saapuvatJunatNyt(String asema) {
        String osoite = "/live-trains/station/" + asema + "?arrived_trains=0&arriving_trains=20&departed_trains=0&departing_trains=0&include_nonstopping=false";
        List<Juna> asemanJunat = lueAsemanJSONData(osoite);
        String asemanNimi = kaanna.murraKoodi(asema);
        System.out.println("Saapuvat junat asemalle " + asemanNimi + ": ");
        luoJunaTaulukkoSaapuvat(asemanJunat, asema);
    }
    /*Metodi luo Saapuvien junien taulukon ja tulostaa sen*/
    private static void luoJunaTaulukkoSaapuvat(List<Juna> asemanJunat, String asemanKoodi) {
        ArrayList<String> asematiedot = new ArrayList<>();
        //tähän taulukkoon lähtöaika, juna, määränpää ja raide(String commercialTrack);
        Date saapumisAika;
        String junatyyppi;
        String lahtoasema;
        String raide;
        int junannro;
        int indeksi = 0;
        Koodinmurtaja kaanna = new Koodinmurtaja();
        MyohastynytJaSyy myohassa = new MyohastynytJaSyy();
        List<TimeTableRow> aikataulu;
        for (int i = 0; i < asemanJunat.size(); i++) {
            aikataulu = asemanJunat.get(i).timeTableRows;
            for (int j = 0; j < aikataulu.size() ; j++) {
                String sSC = aikataulu.get(j).stationShortCode;
                if (sSC.equals(asemanKoodi))
                    indeksi = j;
            }
            saapumisAika = asemanJunat.get(i).timeTableRows.get(indeksi).scheduledTime;
            DateFormat da = new SimpleDateFormat("dd.MM. HH:mm");
            junatyyppi = asemanJunat.get(i).getCommuterLineID();
            raide = asemanJunat.get(i).timeTableRows.get(indeksi).commercialTrack;
            junannro =  asemanJunat.get(i).getTrainNumber();
            lahtoasema = kaanna.murraKoodi(asemanJunat.get(i).timeTableRows.get(0).stationShortCode);
            if(lahtoasema.length()>12){
                lahtoasema = lahtoasema.substring(0,11);
            }
            StringBuilder tiedot = new StringBuilder();
            tiedot.append(da.format(saapumisAika));
            tiedot.append("\t");
            tiedot.append(junatyyppi);
            tiedot.append("\t");
            tiedot.append(raide);
            tiedot.append("\t\t");
            tiedot.append(lahtoasema);
            tiedot.append("\t\t");
            String onko = myohassa.onkoJunaAikataulussaint(junannro);
            if(!"Juna on aikataulussa.".equals(onko)){
                tiedot.append(onko);
            }
            asematiedot.add(tiedot.toString());
        }
        String paateasema = "Pääteasema";
        String otsikot = "Saapuu\t\t  Nro \tRaide\tLähtöasema\t\tAikataulutiedot";
        String alaviiva = "pvm.____klo__________________________________________";
        Collections.sort(asematiedot);
        asematiedot.add(0, alaviiva);
        asematiedot.add(0, otsikot);
        for (int k = 0; k < asematiedot.size(); k++) {
            System.out.println(asematiedot.get(k));
        }
    }
    /*Tämä metodi luo ja tulostaa lähtevien junien taulukon haetuista junista */
    public static void luoJunaTaulukkoLahtevat(List<Juna> asemanJunat, String asemanKoodi) {
        ArrayList<String> asematiedot = new ArrayList<>();
        //tähän taulukkoon lähtöaika, juna, määränpää ja raide(String commercialTrack);
        Date lahtoAika;
        String junatyyppi;
        String maaranpaa;
        String raide;
        int indeksi = 0;
        Koodinmurtaja kaanna = new Koodinmurtaja();
        List<TimeTableRow> aikataulu;
        MyohastynytJaSyy myohassa = new MyohastynytJaSyy();
        for (int i = 0; i < asemanJunat.size(); i++) {
            aikataulu = asemanJunat.get(i).timeTableRows;
            for (int j = 0; j < aikataulu.size() ; j++) {
                String sSC = aikataulu.get(j).stationShortCode;
                if (sSC.equals(asemanKoodi))
                    indeksi = j;
            }
            lahtoAika = asemanJunat.get(i).timeTableRows.get(indeksi).scheduledTime;
            DateFormat da = new SimpleDateFormat("dd.MM. HH:mm");
            junatyyppi = asemanJunat.get(i).getCommuterLineID();
            raide = asemanJunat.get(i).timeTableRows.get(indeksi).commercialTrack;
            int loppu = asemanJunat.get(i).timeTableRows.size() - 1;
            maaranpaa = kaanna.murraKoodi(asemanJunat.get(i).timeTableRows.get(loppu).stationShortCode);
            if(maaranpaa.length()>12){
                maaranpaa = maaranpaa.substring(0,11);
            }
            int junannro = asemanJunat.get(i).getTrainNumber();
            StringBuilder tiedot = new StringBuilder();
            tiedot.append(da.format(lahtoAika));
            tiedot.append("\t");
            tiedot.append(junatyyppi);
            tiedot.append("\t");
            tiedot.append(raide);
            tiedot.append("\t");
            tiedot.append(maaranpaa);
            String onko = myohassa.onkoJunaAikataulussaint(junannro);
            tiedot.append("\t\t");
            if(!"Juna on aikataulussa.".equals(onko)){
                tiedot.append(onko);
            }
            asematiedot.add(tiedot.toString());
        }
        String otsikot = "Lähtee\t\tNro raide \tPääteasema\t\tAikataulutiedot";
        String alaviiva = "pvm.____klo________________________________________________________________";
        Collections.sort(asematiedot);
        asematiedot.add(0, alaviiva);
        asematiedot.add(0, otsikot);
        for (int k = 0; k < asematiedot.size(); k++) {
            System.out.println(asematiedot.get(k));
        }
    }
}