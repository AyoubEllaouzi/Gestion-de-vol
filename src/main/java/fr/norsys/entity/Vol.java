package fr.norsys.entity;

import javax.persistence.*;

@Entity
@Table(name = "Vol")
public class Vol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NV", length = 6)
    private int numeroVol;

    @ManyToOne
    @JoinColumn(name = "NP")
    private Pilote pilote;

    @ManyToOne
    @JoinColumn(name = "NA")
    private Avion avion;

    @Column(name = "VD", length = 10)
    private String villeDepart;

    @Column(name = "VA", length = 10)
    private String villeArrivee;

    @Column(name = "HD")
    private int heureDepart;

    @Column(name = "HA")
    private int heureArrivee;

    public Vol() {
    }

    public Vol(Pilote pilote, Avion avion, String villeDepart, String villeArrivee, int heureDepart, int heureArrivee) {
        this.pilote = pilote;
        this.avion = avion;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
    }

    public int getNumeroVol() {
        return numeroVol;
    }

    public void setNumeroVol(int numeroVol) {
        this.numeroVol = numeroVol;
    }

    public Pilote getPilote() {
        return pilote;
    }

    public void setPilote(Pilote pilote) {
        this.pilote = pilote;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public int getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(int heureDepart) {
        this.heureDepart = heureDepart;
    }

    public int getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(int heureArrivee) {
        this.heureArrivee = heureArrivee;
    }
}
