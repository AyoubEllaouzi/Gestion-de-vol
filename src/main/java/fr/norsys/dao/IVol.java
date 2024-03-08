package fr.norsys.dao;

import fr.norsys.entity.Vol;

import java.util.Date;
import java.util.List;

public interface IVol {
    Vol saveVol(Vol vol);
    void deleteVol(Vol vol);
    Vol getVolById(String numeroVol);
    List<Vol> getAllVols();

    //exercice
    List<Vol> getVolsByAvion(int numeroAvion);
    List<Vol> getVolsDepartByVille(String villeDepart);
    List<Vol> getVolsArriveeByVilleAndHoraire(String villeArrivee, int heureDebut, int heureFin);
    int getTotalVolsByPilote(int numeroPilote);
    List<Vol> getVolsBetweenDates(Date dateDebut, Date dateFin);
}
