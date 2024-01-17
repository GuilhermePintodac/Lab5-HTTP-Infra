package ch.heig;

public class Voiture {
    private String marque;
    private String panne;

    // Important pour la désérialisation
    public Voiture(){

    }
    public Voiture(String marque, String panne) {
        this.marque = marque;
        this.panne = panne;
    }

    public String getMarque() {
        return marque;
    }

    public String getPanne() {
        return panne;
    }
}
