/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 141812
 */
@Entity
public class Pedido implements Serializable {

    @Id
    @Column(name = "PEDIDO_ID")
    @GeneratedValue(strategy = SEQUENCE)
    private long numero;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA")
    private Date dataPedido;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PEDIDO_ID")
    private final List<ItemPedido> itens = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "CLIENTE_ID")
    private Cliente cliente;

    private int numItem = 0;

    public Pedido() {
    }

    public void addItem(int quantidade, Produto produto) {
        numItem++;
        ItemPedido itemPedido = new ItemPedido(quantidade, produto);
        itens.add(itemPedido);
    }

    public ArrayList<ItemPedido> getListItens() {
        ArrayList<ItemPedido> list = new ArrayList<>();
        ItemPedido itemClone;
        
        for (ItemPedido item : itens) {
            itemClone = new ItemPedido(item.getQuantidade(), item.getProduto());
            itemClone.setNumero(item.getNumero());
            list.add(itemClone);
        }
        return list;
    }

    public boolean contemProduto(Produto produto) {
        for (ItemPedido item : itens) {
            if (item.getProduto().equals(produto)) {
                return true;
            }
        }
        return false;
    }

    public void removeItem(int numero) {
        for (ItemPedido item : itens) {
            if (item.getNumero() == numero) {
                itens.remove(item);
                break;
            }
        }
    }

    public void editItem(int numero, int quantidade) {
        for (ItemPedido item : itens) {
            if (item.getNumero() == numero) {
                item.setQuantidade(quantidade);
                break;
            }
        }
    }

    public double totalPedido() {
        double total = 0;
        for (ItemPedido itemPedido : itens) {
            total += itemPedido.totalItem();
        }
        return total;
    }

    public double totalImposto() {
        double total = 0;
        for (ItemPedido itemPedido : itens) {
            total += itemPedido.getQuantidade()
                    * itemPedido.getProduto().getImposto();
        }
        return total;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Date getData() {
        return dataPedido;
    }

    public void setData(Date data) {
        this.dataPedido = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
