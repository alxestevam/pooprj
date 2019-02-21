/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 141812
 */
public class ItemPedido {
    private int numero;
    private int quantidade;
    private Produto produto;
    
    public ItemPedido(int numero, int quantidade, Produto produto) {
        this.numero = numero;
        this.quantidade = quantidade;
        this.produto = produto;
    }
    
    public double totalItem() {
        return quantidade * produto.getPreco();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
}
