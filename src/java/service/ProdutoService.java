/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.Cliente;
import model.Pedido;
import model.Produto;

/**
 *
 * @author 141812
 */
public class ProdutoService {

    private ArrayList<Produto> produtos = Dados.getProdutos();
    private final ArrayList<Cliente> clientes = Dados.getClientes();

    public void addProduto(Produto produto) {
        if(produtos.isEmpty()) {
                produto.setCodigo(1);
        } else {
                produto.setCodigo(produtos.get(produtos.size() - 1).getCodigo() + 1);
        }
        produtos.add(produto);
    }

    public void removeProduto(Produto produto) {
        boolean remove = true;
        
        for(Cliente cliente : clientes) {
            for(Pedido pedido : cliente.getPedidos()) {
                if(pedido.contemProduto(produto)) {
                    remove = false;
                    break;
                }
            }
            if(!remove) break;
        }
        if(remove)
            produtos.remove(produto);
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public Produto getProdutoByNome(String value) {
        for (Produto c : produtos) {
            if (c.getNome().equals(value)) {
                return c;
            }

        }
        return null;
    }


}
