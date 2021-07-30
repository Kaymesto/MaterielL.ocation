package fr.inetum.beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categorie", schema = "locationmateriel", uniqueConstraints=
@UniqueConstraint(columnNames= "id"))
public class Categorie {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="code")
    private String code;
    @Column(name="libelle")
    private String libelle;
    @OneToMany
    (mappedBy = "categorie", fetch = FetchType.EAGER)
    private List<Materiel> materiaux;

    public Categorie() {
        this.materiaux = new ArrayList<Materiel>();
    }


    public Categorie(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
        this.materiaux = new ArrayList<Materiel>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString(){
        return "Le code de la catégorie est : " + this.code + " et son libellé est : " + this.libelle + ".";
    }

}
