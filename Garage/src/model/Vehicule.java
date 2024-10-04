package model;
public abstract class Vehicule implements java.io.Serializable {
    protected String nom;
    protected String marque;
    protected int nbRoues;

    public Vehicule(String nom, String marque, int nbRoues) {
        this.nom = nom;
        this.marque = marque;
        this.nbRoues = nbRoues;
    }

    public abstract String getDetails();
}
