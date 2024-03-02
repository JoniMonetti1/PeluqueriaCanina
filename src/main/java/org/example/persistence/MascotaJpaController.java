/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.example.logic.Mascota;

/**
 *
 * @author jonipcw
 */
public class MascotaJpaController implements Serializable {
    @PersistenceContext(unitName = "pruebaJPApu")
    private EntityManagerFactory emf = null;


    public MascotaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public MascotaJpaController() {
        emf = Persistence.createEntityManagerFactory("PeluqueiraCaninaPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mascota mascota) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mascota);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mascota mascota) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mascota = em.merge(mascota);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void remove(Mascota mascota) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mascota = em.merge(mascota);
            em.remove(mascota);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void eliminarMascotaPorId(int id) {
        EntityTransaction transaction = null;
        EntityManager em = emf.createEntityManager();
        try{
            transaction = em.getTransaction();
            transaction.begin();
            
            Mascota mascota = em.find(Mascota.class, id);
            if(mascota != null) {
                em.remove(mascota);
            } else System.out.println("No se encontro la mascota con el id proporcionado");
            transaction.commit();
        }catch(Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al eliminar la mascota: " + e.getMessage());
        }   
    }

    public Mascota findMascota(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mascota.class, id);
        } finally {
            em.close();
        }
    }
    
    public List<Mascota> findMascotaEntities() {
        EntityManager em = getEntityManager();
        TypedQuery<Mascota> query = em.createQuery("SELECT mascota FROM Mascota mascota", Mascota.class);
        return query.getResultList();
    }
}
