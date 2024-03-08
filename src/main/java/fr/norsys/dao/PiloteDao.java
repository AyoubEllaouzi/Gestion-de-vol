package fr.norsys.dao;

import fr.norsys.entity.Pilote;
import fr.norsys.util.Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class PiloteDao implements IPilote{
    private final EntityManager entityManager;
    public PiloteDao() {
        entityManager = new Utils().manageEntity();
    }

    @Override
    public Pilote savePilote(Pilote pilote) {
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(pilote);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return pilote;
    }

    @Override
    public void deletePilote(Pilote pilote) {
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.remove(pilote);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Pilote getPiloteById(int numeroPilote) {
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        Pilote pilote = null;
        try {
            pilote = entityManager.find(Pilote.class, numeroPilote);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return pilote;
    }


    @Override
    public List<Pilote> getAllPilotes() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<Pilote> pilotes = null;
        try {
            Query query = entityManager.createQuery("SELECT p FROM Pilote p");
            pilotes = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return pilotes;
    }
}
