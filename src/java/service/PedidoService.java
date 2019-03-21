/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Pedido;
import model.Produto;

/**
 *
 * @author 141812
 */
public class PedidoService {

    private final ArrayList<Pedido> pedidos = Dados.getPedidos();
    
    private final EntityManagerFactory emf;
    
    public PedidoService()
    {
        emf = Persistence.createEntityManagerFactory("PrjLojaPU");
    }
    
    public void addPedido(Pedido pedido) {
    	if(pedido.getCliente() != null) {
            if(pedidos.isEmpty()) {
                pedido.setNumero(1);
            }else {
                pedido.setNumero(pedidos.get(pedidos.size() - 1).getNumero() + 1);
            }
            pedidos.add(pedido);
        }   
    }

    public void removePedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public Pedido getPedidoByNumero(int numero) {
        for (Pedido c : pedidos) {
            if (c.getNumero() == numero) {
                return c;
            }

        }
        return null;
    }

    public void salvar(Pedido pedido)
    {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
                em.persist(pedido);
            em.getTransaction().commit();
        em.close();
    }

}
