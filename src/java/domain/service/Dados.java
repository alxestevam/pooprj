/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.service;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import domain.model.Categoria;
import domain.model.Cliente;
import domain.model.Pedido;
import domain.model.Produto;
import domain.model.ProdutoExportacao;
import domain.model.ProdutoMercadoInterno;

/**
 *
 * @author glauc
 */
public class Dados {
    private static ArrayList<Categoria> LISTA_CATEGORIAS;
    private static ArrayList<Produto> LISTA_PRODUTOSEXP;
    private static ArrayList<Produto> LISTA_PRODUTOSMI;
    private static ArrayList<Cliente> LISTA_CLIENTES;
    private static ArrayList<Pedido> LISTA_PEDIDOS;
    private static EntityManagerFactory emf;
    
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("PrjLojaPU");
        Dados.init();
        
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            for(Categoria c : LISTA_CATEGORIAS)
                em.merge(c);
            for(Produto c : LISTA_PRODUTOSEXP)
                em.merge(c);
            for(Produto c : LISTA_PRODUTOSMI)
                em.merge(c);
            for(Cliente c : LISTA_CLIENTES)
                em.merge(c);
            for(Pedido c : LISTA_PEDIDOS)
                em.merge(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Não foi possivel salvar");
        } finally {
            em.close();
        }
    }

    private static void init() {
        LISTA_CATEGORIAS = new ArrayList();
        LISTA_PRODUTOSEXP = new ArrayList();
        LISTA_PRODUTOSMI = new ArrayList();
        LISTA_CLIENTES = new ArrayList();
        LISTA_PEDIDOS = new ArrayList();
        
        Categoria bebidas_alcoolicas = new Categoria("Bebidas Alcoólicas");
        Categoria bebidas_nao_alcoolicas = new Categoria("Bebidas Não Alcoólicas");
        Categoria alimentos = new Categoria("Alimentos");
        Categoria eletrodomesticos = new Categoria("Eletrodomésticos");
        Categoria eletronicos = new Categoria("Eletrônicos");
        
        Produto askov = new ProdutoMercadoInterno(1, "Askov (Un)", bebidas_alcoolicas, 22, 0, 5, true);
        Produto jack = new ProdutoMercadoInterno(2, "Jack Daniels (Un)", bebidas_alcoolicas, 135, 0, 15, true);
        Produto catuaba = new ProdutoMercadoInterno(3, "Catuaba (Un)", bebidas_alcoolicas, 15, 0, 5, true);
        Produto agua = new ProdutoMercadoInterno(4, "Água (L)", bebidas_nao_alcoolicas, 5, 0, 2, false);
        Produto leite = new ProdutoMercadoInterno(5, "Leite (L)", bebidas_nao_alcoolicas, 3, 0, 0.3, false);
        Produto suco = new ProdutoMercadoInterno(6, "Tang (Un)", bebidas_nao_alcoolicas, 0.99, 0, 0.15, false);
        Produto pao = new ProdutoMercadoInterno(7, "Pão (un)", alimentos, 0.40, 0, 0.05, true);
        Produto picanha = new ProdutoMercadoInterno(8, "Picanha (kg)", alimentos, 33, 0, 5, true);
        Produto pizza = new ProdutoExportacao(9, "Pizza", alimentos, 22, 0, 5, "China");
        Produto geladeira = new ProdutoExportacao(10, "Geladeira", eletrodomesticos, 1550, 0, 120, "China");
        Produto fogao = new ProdutoExportacao(11, "Fogão", eletrodomesticos, 1120, 0, 110, "Estados Unidos");
        Produto cafeteira = new ProdutoExportacao(12, "Cafeteira", eletrodomesticos, 95, 0, 10, "Estados Unidos");
        Produto dvd = new ProdutoExportacao(13, "DVD - Player", eletronicos, 350, 0, 50, "Portugal");
        Produto pc = new ProdutoExportacao(14, "Computador", eletronicos, 2250, 0, 260, "Portugal");
        Produto ps4 = new ProdutoExportacao(15, "Playstation 4", eletronicos, 1850, 0, 340, "China");
        
        Cliente a = new Cliente(1, "Alexandre Estevam", "Av. Dr Lauro de Souza Lima", "11996910034", 0, 0);
        Cliente b = new Cliente(2, "Felipe Eiji", "Rua. Sei la", "11923456789", 0, 0);
        Cliente c = new Cliente(3, "Jesus Christ", "Heaven", "777777", 0, 0);
        
        Date systemDate = new Date();
        
        Pedido d = new Pedido();
        d.addItem(1, fogao);
        d.addItem(1, picanha);
        d.setData(systemDate);
        d.setCliente(a);
        
        Pedido e = new Pedido();
        e.addItem(2, geladeira);
        e.addItem(4, pizza);
        e.setData(systemDate);
        e.setCliente(b);
        
        LISTA_CATEGORIAS.add(bebidas_alcoolicas);
        LISTA_CATEGORIAS.add(bebidas_nao_alcoolicas);
        LISTA_CATEGORIAS.add(alimentos);
        LISTA_CATEGORIAS.add(eletrodomesticos);
        LISTA_CATEGORIAS.add(eletronicos);
        
        LISTA_PRODUTOSMI.add(askov);
        LISTA_PRODUTOSMI.add(jack);
        LISTA_PRODUTOSMI.add(catuaba);
        LISTA_PRODUTOSMI.add(agua);
        LISTA_PRODUTOSMI.add(leite);
        LISTA_PRODUTOSMI.add(suco);
        LISTA_PRODUTOSMI.add(pao);
        LISTA_PRODUTOSMI.add(picanha);
        LISTA_PRODUTOSEXP.add(pizza);
        LISTA_PRODUTOSEXP.add(geladeira);
        LISTA_PRODUTOSEXP.add(fogao);        
        LISTA_PRODUTOSEXP.add(cafeteira);
        LISTA_PRODUTOSEXP.add(dvd);
        LISTA_PRODUTOSEXP.add(pc);
        LISTA_PRODUTOSEXP.add(ps4);
        
        LISTA_CLIENTES.add(a);
        LISTA_CLIENTES.add(b);
        LISTA_CLIENTES.add(c);
        
        LISTA_PEDIDOS.add(d);
        LISTA_PEDIDOS.add(e);
        
        
        
        
    }

}
