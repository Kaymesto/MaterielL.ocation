package fr.inetum.beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Location", schema = "locationmateriel", uniqueConstraints=
@UniqueConstraint(columnNames= "id"))
public class Location {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="dateDebut")
    private Date dateDebut;
    @Column(name="dateFin")
    private Date dateFin;
    @Column(name="dureeLocation")
    private int dureeLocation;
    @ManyToMany(mappedBy = "locations")
    private List<Materiel> materiaux;
    @ManyToOne
    @JoinColumn(name="client_codeClient")
    private Client client;

    public Location() {
        this.materiaux = new ArrayList<Materiel>();
    }

    public Location(Date dateDebut, Date dateFin, int dureeLocation) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.dureeLocation = dureeLocation;
        this.materiaux = new ArrayList<Materiel>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getDureeLocation() {
        return dureeLocation;
    }

    public void setDureeLocation(int dureeLocation) {
        this.dureeLocation = dureeLocation;
    }

    public List<Materiel> getMateriaux() {
        return materiaux;
    }

    public void setMateriaux(List<Materiel> materiaux) {
        this.materiaux = materiaux;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
