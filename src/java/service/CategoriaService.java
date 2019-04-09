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

    private ArrayList<Categoria> categorias = Dados.getCategorias();
    private ArrayList<Produto> produtos = Dados.getProdutos();
    
    private EntityManagerFactory emf;

    public CategoriaService() {
        emf = Persistence.createEntityManagerFactory("PrjLojaPU");
    }

    public void removeCategoria(Categoria categoria) {
        boolean remove = true;
        
        for(Produto produto : produtos) {
            if(produto.getCategoria().equals(categoria)) {
                remove = false;
                break;
            }
        }
        if(remove) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Categoria c = em.find(Categoria.class, categoria.getId());
            em.remove(c);
            em.getTransaction().commit();
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

    public Categoria getCategoriaByDescricao(String value) {
        for (Categoria c : categorias) {
            if (c.getDescricao().equals(value)) {
                return c;
            }

        }
        return null;
    }
    
    public void salvar(Categoria c) {
        boolean add = true;
        if(!c.getDescricao().equals("")) {
            for(Categoria i : categorias) {
                if(i.getDescricao().equals(c.getDescricao())) {
                    add = false;
                    break;
                }
            }
            if(add) {
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                em.merge(c);
                em.getTransaction().commit();
                em.close();
            }
        }
    }


}
