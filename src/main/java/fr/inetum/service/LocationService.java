package fr.inetum.service;

import fr.inetum.beans.Location;
import fr.inetum.beans.Materiel;
import fr.inetum.repository.LocationRepository;

import java.util.ArrayList;

public class LocationService {

    private static LocationRepository locationRepository = new LocationRepository();

    public void save(Location location){
        locationRepository.save(location);
    }

    public void displayAllLocation(){
        ArrayList<Location> listeLocation = (ArrayList<Location>)locationRepository.getAll(Location.class);
        for (Location location: listeLocation) {
            System.out.println("Le client " + location.getClient().getNom() + " a effectué une location de "+ location.getDureeLocation() + "jours du "
                    + location.getDateDebut()+" au "+ location.getDateFin() + ".");
            for (Materiel materiel : location.getMateriaux()
            ) {
                System.out.println("Le matériel "+ materiel.getDesignation()+ " de la catégorie "
                        + materiel.getCategorie() + " a été loué pour un montant de "
                        +(materiel.getPrixLocationJournalier()*location.getDureeLocation()+"€."));
            }
        }
    }

    public Location getLocation(int id){
        return locationRepository.get(id, Location.class);
    }

    public void updateLocation(Location location){
        locationRepository.update(location);
    }

    public void deleteLocation(Location location){
        locationRepository.delete(location);
    }

}
