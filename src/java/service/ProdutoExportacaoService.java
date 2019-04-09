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

/**
 *
 * @author 141812
 */
public class ProdutoExportacaoService {


    private EntityManagerFactory emf;
    private ClienteService clienteService = new ClienteService();

    public ProdutoExportacaoService() {
        emf = Persistence.createEntityManagerFactory("PrjLojaPU");
    }

    public void removeProduto(Produto produto) {
        boolean remove = true;
        
        for(Cliente cliente : clienteService.getClientes()) {
            for(Pedido pedido : cliente.getPedidos()) {
                if(pedido.contemProduto(produto)) {
                    remove = false;
                    break;
                }
            }
            if(!remove) break;
        }
        if(remove) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Produto c = em.find(Produto.class, produto.getCodigo());
            em.remove(c);
            em.getTransaction().commit();
            em.close();
        }
    }

    public List<Produto> getProdutos() {
        EntityManager em = emf.createEntityManager();
        List<Produto> c = em.createQuery("select c from Produto c").getResultList();
        em.close();
        return c;
    }

    public Produto getProdutoByNome(String value) {
        for (Produto c : getProdutos()) {
            if (c.getNome().equals(value)) {
                return c;
            }

        }
        return null;
    }
    
    public void salvar(Produto produto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(produto);
        em.getTransaction().commit();
        em.close();
    }


}
