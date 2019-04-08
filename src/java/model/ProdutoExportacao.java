/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 141812
 */
@Entity
public class ProdutoExportacao extends Produto {
    private String destino;

    public ProdutoExportacao() {
        //this.setTipo(0);
    }

    public ProdutoExportacao(int codigo, String nome, Categoria categoria, double preco, int moeda, double imposto, String destino) {
        super(codigo, nome, categoria, preco, moeda, imposto);
        //this.setTipo(0);
        this.destino = destino;
    }
    
    
    public void espProduto(Produto p, String destino) {
        copiaProduto(p);
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    
}
