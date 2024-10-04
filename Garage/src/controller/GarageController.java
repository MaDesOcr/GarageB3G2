package controller;
import java.util.Map;
import java.util.Scanner;

import model.Moto;
import model.TypeEssence;
import model.TypeMoto;
import model.Vehicule;
import model.Voiture;
import service.GarageService;

public class GarageController {
    private GarageService garageService;
    private Scanner scanner = new Scanner(System.in);

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    public void afficherMenu() {
        while (true) {
            System.out.println("1. Ajouter un véhicule");
            System.out.println("2. Lister les véhicules");
            System.out.println("3. Supprimer un véhicule");
            System.out.println("4. Quitter");
            int choix = scanner.nextInt();
            scanner.nextLine(); // pour consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    ajouterVehicule();
                    break;
                case 2:
                    listerVehicules();
                    break;
                case 3:
                    supprimerVehicule();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    private void ajouterVehicule() {
        System.out.println("Entrez le type de véhicule (voiture/moto) : ");
        String type = scanner.nextLine();

        System.out.println("Entrez le nom du véhicule : ");
        String nom = scanner.nextLine();

        System.out.println("Entrez la marque : ");
        String marque = scanner.nextLine();

        if (type.equalsIgnoreCase("voiture")) {
            System.out.println("Entrez le type d'essence (ESSENCE/DIESEL/ELECTRIQUE/HYBRIDE) : ");
            TypeEssence typeEssence = TypeEssence.valueOf(scanner.nextLine().toUpperCase());
            Voiture voiture = new Voiture(nom, marque, typeEssence);
            garageService.ajouterVehicule(nom, voiture);
        } else if (type.equalsIgnoreCase("moto")) {
            System.out.println("Entrez le type de moto (CROSS/VILLE/SPORTIVE) : ");
            TypeMoto typeMoto = TypeMoto.valueOf(scanner.nextLine().toUpperCase());
            Moto moto = new Moto(nom, marque, typeMoto);
            garageService.ajouterVehicule(nom, moto);
        } else {
            System.out.println("Type de véhicule invalide.");
        }
    }

    private void listerVehicules() {
        Map<String, Vehicule> vehicules = garageService.listerVehicules();
        for (Vehicule vehicule : vehicules.values()) {
            System.out.println(vehicule.getDetails());
        }
    }

    private void supprimerVehicule() {
        System.out.println("Entrez le nom du véhicule à supprimer : ");
        String nom = scanner.nextLine();
        garageService.supprimerVehicule(nom);
    }
}
