package fr.inetum.service;

import fr.inetum.beans.Materiel;
import fr.inetum.repository.MaterielRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaterielService {

    private static MaterielRepository materielRepository = new MaterielRepository();

    public void save(Materiel materiel){
        materielRepository.save(materiel);
    }

    public void displayAllMateriel(){
        ArrayList<Materiel> listeMateriel = (ArrayList<Materiel>)materielRepository.getAll(Materiel.class);
        for (Materiel materiel : listeMateriel) {
            System.out.println(materiel);
        }
    }

    public Materiel getMateriel(int id){
        return materielRepository.get(id, Materiel.class);
    }

    public void updateMateriel(Materiel materiel){
        materielRepository.update(materiel);
    }

    public void deleteMateriel (Materiel materiel){
        materielRepository.delete(materiel);
    }

    public void nbMateriauxLoues(Date date){
        List<Materiel> listeMateriel = materielRepository.getMaterieuxDate(date);
        for (Materiel materiel : listeMateriel) {
            System.out.println(materiel);
        }
    }
}
