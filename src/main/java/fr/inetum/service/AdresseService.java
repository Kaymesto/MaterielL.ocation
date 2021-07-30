package fr.inetum.service;

import fr.inetum.beans.Adresse;
import fr.inetum.repository.AdresseRepository;

import java.util.ArrayList;

public class AdresseService  {

    private static AdresseRepository adresseRepository = new AdresseRepository();

    public void save(Adresse adresse){
        adresseRepository.save(adresse);
    }

    public void displayAllAdresse(){
        ArrayList<Adresse> listeAdresse = (ArrayList<Adresse>)adresseRepository.getAll(Adresse.class);
        for (Adresse adresse : listeAdresse) {
            System.out.println(adresse);
        }
    }

    public Adresse getAdresse(int id){
        return adresseRepository.get(id, Adresse.class);
    }

    public void updateAdresse(Adresse adresse){
        adresseRepository.update(adresse);
    }

    public void deleteAdresse(Adresse adresse){
        adresseRepository.delete(adresse);
    }

}
