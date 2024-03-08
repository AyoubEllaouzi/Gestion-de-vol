package fr.norsys.dao;

import fr.norsys.entity.Vol;
import fr.norsys.util.Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class VolDao implements IVol{
    private EntityManager entityManager;

    public VolDao() {
        entityManager = new Utils().manageEntity();
    }

    @Override
    public Vol saveVol(Vol vol) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            entityManager.persist(vol);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return vol;
    }

    @Override
    public void deleteVol(Vol vol) {
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.remove(vol);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Vol getVolById(String numeroVol) {
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        Vol vol = null;
        try {
            vol = entityManager.find(Vol.class, numeroVol);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return vol;
    }

    @Override
    public List<Vol> getAllVols() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<Vol> vols = null;
        try {
            Query query = entityManager.createQuery("SELECT v FROM Vol v");
            vols = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return vols;
    }
//__________________________________________________________________________________________
    @Override
    public List<Vol> getVolsByAvion(int numeroAvion) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<Vol> vols = null;
        try {
            Query query = entityManager.createQuery("SELECT v FROM Vol v WHERE v.avion.numeroAvion = :numeroAvion");
            query.setParameter("numeroAvion", numeroAvion);
            vols = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return vols;
    }


    @Override
    public List<Vol> getVolsDepartByVille(String villeDepart) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<Vol> vols = null;
        try {
            Query query = entityManager.createQuery("SELECT v FROM Vol v WHERE v.villeDepart = :villeDepart");
            query.setParameter("villeDepart", villeDepart);
            vols = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return vols;
    }


    @Override
    public List<Vol> getVolsArriveeByVilleAndHoraire(String villeArrivee, int heureDebut, int heureFin) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<Vol> vols = null;
        try {
            Query query = entityManager.createQuery("SELECT v FROM Vol v WHERE v.villeArrivee = :villeArrivee AND v.heureArrivee BETWEEN :heureDebut AND :heureFin");
            query.setParameter("villeArrivee", villeArrivee);
            query.setParameter("heureDebut", heureDebut);
            query.setParameter("heureFin", heureFin);
            vols = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return vols;
    }


    @Override
    public int getTotalVolsByPilote(int numeroPilote) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        int count = 0;
        try {
            Query query = entityManager.createQuery("SELECT COUNT(v) FROM Vol v WHERE v.pilote.numeroPilote = :numeroPilote");
            query.setParameter("numeroPilote", numeroPilote);
            count = ((Number) query.getSingleResult()).intValue();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return count;
    }


    @Override
    public List<Vol> getVolsBetweenDates(Date dateDebut, Date dateFin) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<Vol> vols = null;
        try {
            Query query = entityManager.createQuery("SELECT v FROM Vol v WHERE v.heureDepart BETWEEN :dateDebut AND :dateFin");
            query.setParameter("dateDebut", dateDebut.getHours());
            query.setParameter("dateFin", dateFin.getHours());
            vols = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return vols;
    }


}
