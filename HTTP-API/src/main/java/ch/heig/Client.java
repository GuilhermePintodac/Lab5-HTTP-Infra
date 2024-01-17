package ch.heig;


public class Client {
    private String nom;

    private Voiture voiture;

    // Important pour la désérialisation
    public Client() {
    }
    public Client(String nom, Voiture voiture) {
        this.nom = nom;
        this.voiture = voiture;
    }

    public String getNom() {
        return nom;
    }

    public Voiture getVoiture() {
        return voiture;
    }
}
