package fr.norsys.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Utils {
    public EntityManager manageEntity(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vol");
        return entityManagerFactory.createEntityManager();
    }
}
