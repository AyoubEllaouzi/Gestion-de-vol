package fr.norsys.dao;

import fr.norsys.entity.Avion;
import fr.norsys.util.Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class AvionDao implements IAvion{
    private EntityManager entityManager;
    public AvionDao() {
       entityManager = new Utils().manageEntity();
    }

    @Override
    public Avion saveAvion(Avion avion) {
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(avion);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return avion;
    }

    @Override
    public void deleteAvion(Avion avion) {
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.remove(avion);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Avion getAvionById(int numeroAvion) {
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        Avion avion = null;
        try {
            avion = entityManager.find(Avion.class, numeroAvion);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return avion;
    }

    @Override
    public List<Avion> getAllAvions() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<Avion> avions = null;
        try {
            Query query = entityManager.createQuery("SELECT a FROM Avion a");
            avions = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return avions;
    }
}
