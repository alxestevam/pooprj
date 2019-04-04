/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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
public class CategoriaService {

    private ArrayList<Categoria> categorias = Dados.getCategorias();
    private ArrayList<Produto> produtos = Dados.getProdutos();
    
    private EntityManagerFactory emf;

    public CategoriaService() {
        emf = Persistence.createEntityManagerFactory("PrjLojaPU");
    }
    
    

    public void addCategoria(Categoria categoria) {
        boolean add = true;
        if(!categoria.getDescricao().equals("")) {
            for(Categoria c : categorias) {
                if(c.getDescricao().equals(categoria.getDescricao())) {
                    add = false;
                    break;
                }
            }
            if(add) {
                categorias.add(categoria);
            }
        }
    }

    public void removeCategoria(Categoria categoria) {
        boolean remove = true;
        
        for(Produto produto : produtos) {
            if(produto.getCategoria().equals(categoria)) {
                remove = false;
                break;
            }
        }
        if(remove)
            categorias.remove(categoria);
    }

    public List<Categoria> getCategorias() {
        EntityManager em = emf.createEntityManager();
        List<Categoria> c = em.createQuery("select c from Categoria c").getResultList();
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
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
    }


}
