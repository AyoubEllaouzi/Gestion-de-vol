package fr.norsys.dao;

import fr.norsys.entity.Pilote;

import java.util.List;

public interface IPilote {
    Pilote savePilote(Pilote pilote);
    void deletePilote(Pilote pilote);

    Pilote getPiloteById(int numeroPilote);
    List<Pilote> getAllPilotes();}
