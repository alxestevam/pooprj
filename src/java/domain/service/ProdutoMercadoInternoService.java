/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import domain.model.Produto;
import domain.model.ProdutoMercadoInterno;

/**
 *
 * @author 141812
 */
public class ProdutoMercadoInternoService {

    private final EntityManagerFactory emf;

    public ProdutoMercadoInternoService() {
        emf = Persistence.createEntityManagerFactory("PrjLojaPU");
    }

    // <editor-fold defaultstate="collapsed" desc="Remove">
    public void removeProduto(ProdutoMercadoInterno produto) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Produto c = em.find(Produto.class, produto.getCodigo());
            em.remove(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Não foi possível excluir");
        } finally {
            em.close();
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Read All">
    public List<ProdutoMercadoInterno> getProdutosMercadoInterno() {
        EntityManager em = emf.createEntityManager();
        List<ProdutoMercadoInterno> c = em.createQuery("select c from ProdutoMercadoInterno c").getResultList();
        em.close();
        return c;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Find By Id">
    public ProdutoMercadoInterno getProdutoByCodigo(int codigo) {
        EntityManager em = emf.createEntityManager();
        ProdutoMercadoInterno c = em.find(ProdutoMercadoInterno.class, codigo);
        em.close();
        return c;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Insert">
    public void salvar(ProdutoMercadoInterno produto) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Não foi possivel salvar");
        } finally {
            em.close();
        }
    }
    // </editor-fold>

}
