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
import domain.model.ItemPedido;

/**
 *
 * @author 141812
 */
public class ItemPedidoService {

    private final EntityManagerFactory emf;

    public ItemPedidoService() {
        emf = Persistence.createEntityManagerFactory("PrjLojaPU");
    }

    // <editor-fold defaultstate="collapsed" desc="Remove">
    /**
     * @deprecated @param itemPedido
     */
    public void removeItemPedido(ItemPedido itemPedido) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            ItemPedido c = em.find(ItemPedido.class, itemPedido.getNumero());
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
    public List<ItemPedido> getItensPedidos() {
        EntityManager em = emf.createEntityManager();
        List<ItemPedido> c = em.createQuery("select c from ItemPedido c").getResultList();
        em.close();
        return c;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Find By Id">
    public ItemPedido getItemPedidoByNumero(int numero) {
        EntityManager em = emf.createEntityManager();
        ItemPedido c = em.find(ItemPedido.class, numero);
        em.close();
        return c;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Insert">
    public void salvar(ItemPedido itemPedido) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(itemPedido);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Não foi possivel salvar");
        } finally {
            em.close();
        }
    }
    // </editor-fold>

}
