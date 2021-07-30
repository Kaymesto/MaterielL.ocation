package fr.inetum.beans;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Client", schema = "locationmateriel", uniqueConstraints=
@UniqueConstraint(columnNames= "codeClient"))
public class Client {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="codeClient")
    private int codeClient;
    @Column(name="nom")
    private String nom;
    @Column(name="telephone")
    private String telephone;
    @Column(name="type")
    private int type;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn( name="adresse" )
    private Adresse address;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Location> locations;


    public Client() {
    }

    public Client(String nom, String telephone, int type) {
        this.nom = nom;
        this.telephone = telephone;
        this.type = type;
    }

    public Adresse getAddress() {
        return address;
    }

    public void setAddress(Adresse address) {
        this.address = address;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public int getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(int codeClient) {
        this.codeClient = codeClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
