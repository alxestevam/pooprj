/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;

/**
 *
 * @author 141812
 */
@Entity
public class ProdutoMercadoInterno extends Produto {

    private boolean incentivo;

    public ProdutoMercadoInterno() {
    }

    public ProdutoMercadoInterno(int codigo, String nome, Categoria categoria, double preco, int moeda, double imposto, boolean incentivo) {
        super(codigo, nome, categoria, preco, moeda, imposto);
        //this.setTipo(1);
        this.incentivo = incentivo;
    }

    public void espProduto(Produto p, boolean incentivo) {
        copiaProduto(p);
        this.incentivo = incentivo;
    }

    public boolean isIncentivo() {
        return incentivo;
    }

    public void setIncentivo(boolean incentivo) {
        this.incentivo = incentivo;
    }
}
