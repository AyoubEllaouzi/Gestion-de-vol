package fr.norsys;

import fr.norsys.dao.AvionDao;
import fr.norsys.dao.PiloteDao;
import fr.norsys.dao.VolDao;
import fr.norsys.entity.Avion;
import fr.norsys.entity.Pilote;
import fr.norsys.entity.Vol;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        AvionDao avionDao = new AvionDao();
        PiloteDao piloteDao = new PiloteDao();
        VolDao volDao = new VolDao();

        Avion avion1 = new Avion("avion1",100,"maroc");
        Avion avion2 = new Avion("avion2",150,"maroc");
        Avion avion3 = new Avion("avion3",80,"maroc");

        avionDao.saveAvion(avion1);
        avionDao.saveAvion(avion2);
        avionDao.saveAvion(avion3);


        Pilote pilote1 = new Pilote("Anas", "adr p1");
        Pilote pilote2 = new Pilote("yassine", "adr p2");
        Pilote pilote3 = new Pilote("Mourad", "adr p3");

        piloteDao.savePilote(pilote1);
        piloteDao.savePilote(pilote2);
        piloteDao.savePilote(pilote3);


        Vol vol1 = new Vol(pilote1, avion1,"Rabat", "Paris", 6,20);
        Vol vol2 = new Vol(pilote2, avion2,"Rabat", "New york", 9,22);
        Vol vol3 = new Vol(pilote3, avion3,"Rabat", "Chicago", 22,9);

        volDao.saveVol(vol1);
        volDao.saveVol(vol2);
        volDao.saveVol(vol3);


    }
}