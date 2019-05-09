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
import domain.model.Pedido;
import domain.model.Produto;

/**
 *
 * @author 141812
 */
public class PedidoService {

    private final EntityManagerFactory emf;

    public PedidoService() {
        emf = Persistence.createEntityManagerFactory("PrjLojaPU");
    }

    // <editor-fold defaultstate="collapsed" desc="Insert">
    public void salvar(Pedido pedido) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(pedido);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Não foi possivel salvar");
        } finally {
            em.close();
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Remove">
    public void removePedido(Pedido pedido) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Produto c = em.find(Produto.class, pedido.getNumero());
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
    public List<Pedido> getPedidos() {
        EntityManager em = emf.createEntityManager();
        List<Pedido> c = em.createQuery("select c from Pedido c").getResultList();
        em.close();
        return c;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Find By Id">
    public Pedido getPedidoByNumero(int numero) {
        EntityManager em = emf.createEntityManager();
        Pedido c = em.find(Pedido.class, numero);
        em.close();
        return c;
    }
    // </editor-fold>

}
