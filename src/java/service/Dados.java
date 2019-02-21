/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.Categoria;
import model.Cliente;
import model.Pedido;
import model.Produto;
import model.ProdutoExportacao;
import model.ProdutoMercadoInterno;

/**
 *
 * @author glauc
 */
public class Dados {
    private static ArrayList<Categoria> LISTA_CATEGORIAS;
    private static ArrayList<Produto> LISTA_PRODUTOS;
    private static ArrayList<Cliente> LISTA_CLIENTES;
    private static ArrayList<Pedido> LISTA_PEDIDOS;

    private static void init() {
        LISTA_CATEGORIAS = new ArrayList();
        LISTA_PRODUTOS = new ArrayList();
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
        
        LISTA_CATEGORIAS.add(bebidas_alcoolicas);
        LISTA_CATEGORIAS.add(bebidas_nao_alcoolicas);
        LISTA_CATEGORIAS.add(alimentos);
        LISTA_CATEGORIAS.add(eletrodomesticos);
        LISTA_CATEGORIAS.add(eletronicos);
        
        LISTA_PRODUTOS.add(askov);
        LISTA_PRODUTOS.add(jack);
        LISTA_PRODUTOS.add(catuaba);
        LISTA_PRODUTOS.add(agua);
        LISTA_PRODUTOS.add(leite);
        LISTA_PRODUTOS.add(suco);
        LISTA_PRODUTOS.add(pao);
        LISTA_PRODUTOS.add(picanha);
        LISTA_PRODUTOS.add(pizza);
        LISTA_PRODUTOS.add(geladeira);
        LISTA_PRODUTOS.add(fogao);        
        LISTA_PRODUTOS.add(cafeteira);
        LISTA_PRODUTOS.add(dvd);
        LISTA_PRODUTOS.add(pc);
        LISTA_PRODUTOS.add(ps4);
        
        LISTA_CLIENTES.add(a);
        LISTA_CLIENTES.add(b);
        LISTA_CLIENTES.add(c);
        
    }
    
    public static ArrayList<Categoria> getCategorias() {
        if (LISTA_CATEGORIAS == null) {
            init();
        }
        return LISTA_CATEGORIAS;
    }
    
    public static ArrayList<Produto> getProdutos() {
        if (LISTA_PRODUTOS == null) {
            init();
        }
        return LISTA_PRODUTOS;
    }
    
    public static ArrayList<Cliente> getClientes() {
        if (LISTA_CLIENTES == null) {
            init();
        }
        return LISTA_CLIENTES;
    }
    
    public static ArrayList<Pedido> getPedidos() {
        if (LISTA_PEDIDOS == null) {
            init();
        }
        return LISTA_PEDIDOS;
    }

}
