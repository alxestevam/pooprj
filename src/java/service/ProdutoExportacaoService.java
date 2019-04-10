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
import model.Cliente;
import model.Pedido;
import model.Produto;
import model.ProdutoExportacao;
import model.ProdutoMercadoInterno;

/**
 *
 * @author 141812
 */
public class ProdutoExportacaoService {
    private final EntityManagerFactory emf;

    public ProdutoExportacaoService() {
        emf = Persistence.createEntityManagerFactory("PrjLojaPU");
    }
    
    // <editor-fold defaultstate="collapsed" desc="Remove">
    public void removeProduto(ProdutoExportacao produto) {
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            Produto c = em.find(Produto.class, produto.getCodigo());
            em.remove(c);
            em.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println("Não foi possível excluir");
        }
        finally {
            em.close();
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Read All">
    public List<ProdutoExportacao> getProdutosExportacao() {
        EntityManager em = emf.createEntityManager();
        List<ProdutoExportacao> c = em.createQuery("select c from ProdutoExportacao c").getResultList();
        em.close();
        return c;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Find By Id">
    public ProdutoExportacao getProdutoByCodigo(int codigo) {
        EntityManager em = emf.createEntityManager();
        ProdutoExportacao c = em.find(ProdutoExportacao.class, codigo);
        em.close();
        return c;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Insert">
    public void salvar(ProdutoExportacao produto) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(produto);
            em.getTransaction().commit();
        }
        catch(Exception e) {
            System.out.println("Não foi possivel salvar");
        }
        finally {
            em.close();
        }
    }
    // </editor-fold>


}
