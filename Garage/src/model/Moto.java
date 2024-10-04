package model;
public class Moto extends Vehicule {
    private TypeMoto typeMoto;

    public Moto(String nom, String marque, TypeMoto typeMoto) {
        super(nom, marque, 2);
        this.typeMoto = typeMoto;
    }

    @Override
    public String getDetails() {
        return "Moto: " + nom + ", Marque: " + marque + ", Type: " + typeMoto;
    }
}
