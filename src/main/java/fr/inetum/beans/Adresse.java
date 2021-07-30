package fr.inetum.beans;

import javax.persistence.*;

@Entity
@Table(name = "Adresse", schema = "locationmateriel", uniqueConstraints=
@UniqueConstraint(columnNames= "id"))
public class Adresse {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="numeroRue")
    private String numeroRue;
    @Column(name="nomRue")
    private String nomRue;
    @Column(name="codePostal")
    private String codePostal;
    @Column(name="ville")
    private String ville;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn( name="client_codeClient" )
    private Client client;

    public Adresse() {
    }

    public Adresse(String numeroRue, String nomRue, String codePostal, String ville) {
        this.numeroRue = numeroRue;
        this.nomRue = nomRue;
        this.codePostal = codePostal;
        this.ville = ville;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroRue() {
        return numeroRue;
    }

    public void setNumeroRue(String numeroRue) {
        this.numeroRue = numeroRue;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    @Override
    public String toString(){
        return this.numeroRue + " " + this.nomRue + " " + this.codePostal + " " + this.ville + ".";
    }


}
