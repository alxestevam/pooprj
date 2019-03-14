/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import service.Dados;

/**
 *
 * @author 141812
 */

@Entity
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="CLIENTE_ID")
    private int codigo;
    private String nome;
    private String endereco;
    private String telefone;
    private int status;
    private double limite;
    
    @Transient
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    
    public Cliente() {
         
    }

    public Cliente(int codigo, String nome, String endereco, String telefone, int status, double limite) {        
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.status = status;
        this.limite = limite;
    }

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
    
    public void removePedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    
}
