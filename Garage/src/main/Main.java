package main;

import java.util.Map;

import controller.GarageController;
import model.Vehicule;
import repository.GarageRepository;
import service.GarageService;
import utilitaires.FileManager;

public class Main {
    private static final String FILE_PATH = "garage_data.ser";

    public static void main(String[] args) {
        GarageRepository repo = new GarageRepository();
        Map<String, Vehicule> vehicules = FileManager.lireVehiculesDepuisFichier(FILE_PATH);
        for (Map.Entry<String, Vehicule> entry : vehicules.entrySet()) {
            repo.ajouterVehicule(entry.getKey(), entry.getValue());
        }

        GarageService service = new GarageService(repo);
        GarageController controller = new GarageController(service);

        controller.afficherMenu();

        FileManager.sauvegarderVehiculesDansFichier(FILE_PATH, repo.listerVehicules());
    }
}
