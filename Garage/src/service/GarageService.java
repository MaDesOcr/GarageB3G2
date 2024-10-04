package service;

import java.util.Map;

import model.Vehicule;
import repository.GarageRepository;

public class GarageService {
    private GarageRepository garageRepo;

    public GarageService(GarageRepository garageRepo) {
        this.garageRepo = garageRepo;
    }

    public void ajouterVehicule(String id, Vehicule vehicule) {
        garageRepo.ajouterVehicule(id, vehicule);
    }

    public Vehicule obtenirVehicule(String id) {
        return garageRepo.obtenirVehicule(id);
    }

    public void supprimerVehicule(String id) {
        garageRepo.supprimerVehicule(id);
    }

    public Map<String, Vehicule> listerVehicules() {
        return garageRepo.listerVehicules();
    }
}
