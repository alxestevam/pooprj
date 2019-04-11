/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Cliente;

/**
 *
 * @author 141812
 */
public class ClienteService implements Serializable {

    private final EntityManagerFactory emf;

    public ClienteService() {
        emf = Persistence.createEntityManagerFactory("PrjLojaPU");
    }

    private final PedidoService pedidoService = new PedidoService();

    // <editor-fold defaultstate="collapsed" desc="Remove">
    public void removeCliente(Cliente cliente) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Cliente c = em.find(Cliente.class, cliente.getCodigo());
            em.remove(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Não foi possivel remover");
        } finally {
            em.close();
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Read All">
    public List<Cliente> getClientes() {
        EntityManager em = emf.createEntityManager();
        List<Cliente> c = em.createQuery("select c from Cliente c").getResultList();
        em.close();
        return c;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Find By Id">
    public Cliente getClienteByCodigo(int codigo) {
        EntityManager em = emf.createEntityManager();
        Cliente c = em.find(Cliente.class, codigo);
        em.close();
        return c;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Inserir">
    public void salvar(Cliente cliente) {
        if (!cliente.getNome().equals("")
                && !cliente.getEndereco().equals("")
                && !cliente.getTelefone().equals("")) {

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
            em.close();
        }
    }
    // </editor-fold>

}
