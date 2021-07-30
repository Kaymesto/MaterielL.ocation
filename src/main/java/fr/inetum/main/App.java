package fr.inetum.main;

import fr.inetum.beans.*;
import fr.inetum.service.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class App {

    public static void main(String [] args) {

        AdresseService adresseService = new AdresseService();
        CategorieService categorieService = new CategorieService();
        ClientService clientService = new ClientService();
        LocationService locationService = new LocationService();
        MaterielService materielService = new MaterielService();



//        Date date = null;
//        try {
//            date =new SimpleDateFormat("dd/MM/yyyy").parse("20/07/2021");
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        materielService.nbMateriauxLoues(date);


        Categorie categorie1 = new Categorie("MI", "materiel industriel");
        categorie1.setId(3);
        Categorie categorie2 = new Categorie("OI", "outillage industriel");
        categorie2.setId(4);
        Categorie categorie3 = new Categorie("MB", "materiel de bureau");
        categorie3.setId(5);
        Materiel materiel1 = new Materiel("REF001","Bureau", new Date(), 50.00F);
        materiel1.setCategorie(categorie3);
        Materiel materiel2 = new Materiel("REF001","Imprimante", new Date(), 80.00F);
        materiel2.setCategorie(categorie3);
        Materiel materiel3 = new Materiel("REF001","Marteau piqueur", new Date(), 30.00F);
        materiel3.setCategorie(categorie2);
        Date date1 = null;
        Date date2 = null;
        Date date3 = null;
        Date date4 = null;
        try {
            date1 =new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2021");
            date2 =new SimpleDateFormat("dd/MM/yyyy").parse("28/08/2021");
//            date3 =new SimpleDateFormat("dd/MM/yyyy").parse("12/08/2021");
//            date4 =new SimpleDateFormat("dd/MM/yyyy").parse("16/08/2021");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Location location1 = new Location(date1,date2,(int)(date2.getTime() -date1.getTime()));

        materiel1.getLocations().add(location1);
        materiel2.getLocations().add(location1);
        location1.getMateriaux().add(materiel1);
        location1.getMateriaux().add(materiel2);
        locationService.save(location1);

//        location1.setClient(clientService.getClient(1));
//        Location location2 = new Location(date3,date4,(int)(date4.getTime() -date3.getTime()));
//        location2.getMateriaux().add(materiel2);
//        location2.getMateriaux().add(materiel3);
//        location2.setClient(clientService.getClient(2));
//        locationService.save(location1);
//        locationService.save(location2);

        // clientService.displayAllClients();
        // categorieService.displayAllCategorie();
        // adresseService.displayAllAdresse();
        // locationService.displayAllLocation();
        // materielService.displayAllMateriel();



//
//        // Création des clients et adresses
//        Adresse adresse = new Adresse("123","Rue Bidon","75009","Paris");
//        Adresse adresse1 = new Adresse("321","Rue Nodib","69007","Lyon");
//        Client client = new Client("Kevin","0601020304",0);
//        Client client1 = new Client("Constantin","0609080706",1);
//        client.setAddress(adresse);
//        client1.setAddress(adresse1);
//        clientService.save(client);
//        clientService.save(client1);
//
//
//
//        // Création des catégories
//        Categorie categorie1 = new Categorie("MI", "materiel industriel");
//        Categorie categorie2 = new Categorie("OI", "outillage industriel");
//        Categorie categorie3 = new Categorie("MB", "materiel de bureau");
//        categorieService.save(categorie1);
//        categorieService.save(categorie2);
//        categorieService.save(categorie3);



    }

}
