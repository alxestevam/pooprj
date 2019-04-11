/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Categoria;
import model.Produto;

/**
 *
 * @author 141812
 */
public class CategoriaService implements Serializable {

    private EntityManagerFactory emf;

    public CategoriaService() {
        emf = Persistence.createEntityManagerFactory("PrjLojaPU");
    }

    public void removeCategoria(Categoria categoria) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Categoria c = em.find(Categoria.class, categoria.getId());
            em.remove(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Não foi possivel remover");
        } finally {
            em.close();
        }
    }

    public List<Categoria> getCategorias() {
        EntityManager em = emf.createEntityManager();
        List<Categoria> c = em.createQuery("select c from Categoria c").getResultList();
        em.close();
        return c;
    }

    public Categoria getCategoriaById(int id) {
        EntityManager em = emf.createEntityManager();
        Categoria c = em.find(Categoria.class, id);
        em.close();
        return c;
    }

    public void salvar(Categoria c) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        }
        catch(Exception e) {
            System.out.println("Não foi possivel salvar");
        }
        finally {
            em.close();
        }
    }

}
