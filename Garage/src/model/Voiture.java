package model;
public class Voiture extends Vehicule {
    private TypeEssence typeEssence;

    public Voiture(String nom, String marque, TypeEssence typeEssence) {
        super(nom, marque, 4);
        this.typeEssence = typeEssence;
    }

    @Override
    public String getDetails() {
        return "Voiture: " + nom + ", Marque: " + marque + ", Type d'essence: " + typeEssence;
    }
}
