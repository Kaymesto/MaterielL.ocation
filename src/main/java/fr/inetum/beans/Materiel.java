package fr.inetum.beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Materiel", schema = "locationmateriel", uniqueConstraints=
@UniqueConstraint(columnNames= "id"))
public class Materiel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="refInterne")
    private String refInterne;
    @Column(name="designation")
    private String designation;
    @Column(name="dateAchat")
    private Date dateAchat;
    @Column(name="prixLocationJournalier")
    private Float prixLocationJournalier;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "materiel_location",
            joinColumns = @JoinColumn(name = "materiaux_id"),
            inverseJoinColumns = @JoinColumn(name = "locations_id"))
    private List<Location> locations;
    @ManyToOne
    @JoinColumn(name="categorie_id")
    private Categorie categorie;


    public Materiel() {
        this.locations = new ArrayList<Location>();
    }

    public Materiel(String refInterne, String designation, Date dateAchat, Float prixLocationJournalier) {
        this.refInterne = refInterne;
        this.designation = designation;
        this.dateAchat = dateAchat;
        this.prixLocationJournalier = prixLocationJournalier;
        this.locations = new ArrayList<Location>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRefInterne() {
        return refInterne;
    }

    public void setRefInterne(String refInterne) {
        this.refInterne = refInterne;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Float getPrixLocationJournalier() {
        return prixLocationJournalier;
    }

    public void setPrixLocationJournalier(Float prixLocationJournalier) {
        this.prixLocationJournalier = prixLocationJournalier;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString(){
        return "Le matériel "+ this.designation + " est de la catégorie " + this.categorie + ".";
    }
}
