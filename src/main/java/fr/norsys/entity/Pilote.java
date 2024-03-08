package fr.norsys.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Pilote")
public class Pilote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NP")
    private int numeroPilote;

    @Column(name = "NOM", length = 25)
    private String nomPilote;

    @Column(name = "ADRESSE", length = 40)
    private String adressePilote;
    //@OneToMany(mappedBy = "pilote", cascade = CascadeType.ALL)
    //List<Vol> vols ;

    public Pilote() {
    }

    public Pilote(String nomPilote, String adressePilote) {
        this.nomPilote = nomPilote;
        this.adressePilote = adressePilote;
    }

    public int getNumeroPilote() {
        return numeroPilote;
    }

    public void setNumeroPilote(int numeroPilote) {
        this.numeroPilote = numeroPilote;
    }

    public String getNomPilote() {
        return nomPilote;
    }

    public void setNomPilote(String nomPilote) {
        this.nomPilote = nomPilote;
    }

    public String getAdressePilote() {
        return adressePilote;
    }

    public void setAdressePilote(String adressePilote) {
        this.adressePilote = adressePilote;
    }

}
