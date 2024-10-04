package utilitaires;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import model.Vehicule;

public class FileManager {

    public static Map<String, Vehicule> lireVehiculesDepuisFichier(String cheminFichier) {
        Map<String, Vehicule> vehicules = new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(cheminFichier))) {
            vehicules = (Map<String, Vehicule>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Aucun fichier trouvé ou fichier vide.");
        }
        return vehicules;
    }

    public static void sauvegarderVehiculesDansFichier(String cheminFichier, Map<String, Vehicule> vehicules) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(cheminFichier))) {
            oos.writeObject(vehicules);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
