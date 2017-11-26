package fi.academy.papu;

public class Viesti0 {
    private int viestiID;
    private  int alueID;

    public Viesti0() {
    }

    public Viesti0(int viestiID, int aiheID) {
        this.viestiID = viestiID;
        this.alueID = aiheID;
    }

    public int getViestiID() {
        return viestiID;
    }

    public void setViestiID(int viestiID) {
        this.viestiID = viestiID;
    }

    public int getAlueID() {
        return alueID;
    }

    public void setAlueID(int alueID) {
        this.alueID = alueID;
    }
}
