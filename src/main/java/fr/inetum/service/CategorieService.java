package fr.inetum.service;

import fr.inetum.beans.Categorie;
import fr.inetum.repository.CategorieRepository;

import java.util.ArrayList;

public class CategorieService {

    private static CategorieRepository categorieRepository = new CategorieRepository();

    public void save(Categorie categorie){
        categorieRepository.save(categorie);
    }

    public void displayAllCategorie(){
        ArrayList<Categorie> listeCategorie = (ArrayList<Categorie>)categorieRepository.getAll(Categorie.class);
        for (Categorie categorie : listeCategorie) {
            System.out.println(categorie);
        }
    }

    public Categorie getCategorie(int id){
        return categorieRepository.get(id, Categorie.class);
    }

    public void updateCategorie(Categorie categorie){
        categorieRepository.update(categorie);
    }

    public void deleteCategorie(Categorie categorie){
        categorieRepository.delete(categorie);
    }

}
