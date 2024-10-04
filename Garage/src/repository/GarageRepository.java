package repository;
import java.util.HashMap;
import java.util.Map;

import model.Vehicule;

public class GarageRepository {
    private Map<String, Vehicule> vehicules = new HashMap<>();

    public void ajouterVehicule(String id, Vehicule vehicule) {
        vehicules.put(id, vehicule);
    }

    public Vehicule obtenirVehicule(String id) {
        return vehicules.get(id);
    }

    public void supprimerVehicule(String id) {
        vehicules.remove(id);
    }

    public Map<String, Vehicule> listerVehicules() {
        return vehicules;
    }
}
