public class Henkilo {
    private int hloid;
    private String nimi;
    private String nimimerkki;
    private String kuvaus;
    private String kuvausteksti;
    private String rooli;

    public Henkilo(){

    }

    public Henkilo(int hloid, String nimi, String nimimerkki, String kuvaus, String kuvausteksti, String rooli) {
        this.hloid = hloid;
        this.nimi = nimi;
        this.nimimerkki = nimimerkki;
        this.kuvaus = kuvaus;
        this.kuvausteksti = kuvausteksti;
        this.rooli = rooli;
    }

    public int getHloid() {
        return hloid;
    }

    public void setHloid(int hloid) {
        this.hloid = hloid;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getNimimerkki() {
        return nimimerkki;
    }

    public void setNimimerkki(String nimimerkki) {
        this.nimimerkki = nimimerkki;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public String getKuvausteksti() {
        return kuvausteksti;
    }

    public void setKuvausteksti(String kuvausteksti) {
        this.kuvausteksti = kuvausteksti;
    }

    public String getRooli() {
        return rooli;
    }

    public void setRooli(String rooli) {
        this.rooli = rooli;
    }
}
