package fr.inetum.service;

import fr.inetum.beans.Client;
import fr.inetum.beans.Location;
import fr.inetum.beans.Materiel;
import fr.inetum.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;

public class ClientService {

    private static ClientRepository clientRepository = new ClientRepository();

    public void save(Client client){
        clientRepository.save(client);
    }

    public void displayAllClients(){
        ArrayList<Client> listeClients = (ArrayList<Client>)clientRepository.getAll(Client.class);
        for (Client client : listeClients) {
            String message = "Le client s'appelle " + client.getNom() + ", son numéro est le " + client.getTelephone()
                                +", son adresse est "+ client.getAddress();
            if(client.getType()==0 )message += " Le client est un particulier.";
            else if(client.getType()==1) message += " Le client est une entreprise.";
            System.out.println(message);
            for (Location location: client.getLocations()) {
                System.out.println("Le client a effectué une location de "+ location.getDureeLocation() + "jours du "
                + location.getDateDebut()+" au "+ location.getDateFin() + ".");
                for (Materiel materiel : location.getMateriaux()
                     ) {
                    System.out.println("Le matériel "+ materiel.getDesignation()+ " de la catégorie "
                    + materiel.getCategorie() + " a été loué pour un montant de "
                            +(materiel.getPrixLocationJournalier()*location.getDureeLocation()+"€."));
                }
            }
        }
    }

    public Client getClient(int id){
        return clientRepository.get(id, Client.class);
    }

    public void updateClient(Client client){
        clientRepository.update(client);
    }

    public void deleteClient(Client client){
        clientRepository.delete(client);
    }

}
