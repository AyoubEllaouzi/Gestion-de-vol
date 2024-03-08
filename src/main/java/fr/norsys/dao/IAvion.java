package fr.norsys.dao;

import fr.norsys.entity.Avion;

import java.util.List;

public interface IAvion {
    Avion saveAvion(Avion avion);
    void deleteAvion(Avion avion);
    Avion getAvionById(int numeroAvion);
    List<Avion> getAllAvions();
}
