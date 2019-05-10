/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.data.repository;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import domain.interfaces.repository.IRepositoryBase;
import javax.persistence.Persistence;

/**
 *
 * @author 171150
 */
public class RepositoryBase<T extends Serializable, I> implements IRepositoryBase<T, I> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    
    public RepositoryBase() {

        emf = Persistence.createEntityManagerFactory("PrjLojaPU");

    }

    public EntityManager getEntityManager() {
        if (em == null) {
            em = emf.createEntityManager();
        }
        return em;
    }

    public void closeEntityManager() {
        if (em != null) {
            em.close();
        }

        em = null;
    }

    @Override
    public T save(T entity) {
        T saved = null;

        getEntityManager().getTransaction().begin();
        saved = getEntityManager().merge(entity);
        getEntityManager().getTransaction().commit();

        return saved;
    }

    @Override
    public void remove(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(entity);
        getEntityManager().getTransaction().commit();
    }

    @Override
    public T getById(Class<T> classe, I pk) {
        try {
            return getEntityManager().find(classe, pk);
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<T> getAll(Class<T> classe) {

        return getEntityManager().
                createQuery(
                        "select o from "
                        + classe.getSimpleName() + " o")
                .getResultList();
    }

}
