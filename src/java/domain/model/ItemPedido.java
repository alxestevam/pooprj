/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author 141812
 */
@Entity
public class ItemPedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ITEMPEDIDO_ID")
    private int numero;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "PRODUTO_ID")
    private Produto produto;

    public ItemPedido() {
    }

    public ItemPedido(int quantidade, Produto produto) {
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
