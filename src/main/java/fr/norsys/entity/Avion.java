package fr.norsys.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Avion")
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NA")
    private int numeroAvion;

    @Column(name = "NOM", length = 12)
    private String nomAvion;

    @Column(name = "CAPACITE")
    private int capaciteAvion;

    @Column(name = "LOCALITE", length = 10)
    private String localite;

    //@OneToMany(mappedBy = "avion", cascade = CascadeType.ALL)
    //List<Vol> vols ;

    public Avion() {
    }

    public Avion(String nomAvion, int capaciteAvion, String localite) {
        this.nomAvion = nomAvion;
        this.capaciteAvion = capaciteAvion;
        this.localite = localite;
    }

    public int getNumeroAvion() {
        return numeroAvion;
    }

    public void setNumeroAvion(int numeroAvion) {
        this.numeroAvion = numeroAvion;
    }

    public String getNomAvion() {
        return nomAvion;
    }

    public void setNomAvion(String nomAvion) {
        this.nomAvion = nomAvion;
    }

    public int getCapaciteAvion() {
        return capaciteAvion;
    }

    public void setCapaciteAvion(int capaciteAvion) {
        this.capaciteAvion = capaciteAvion;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }


}
