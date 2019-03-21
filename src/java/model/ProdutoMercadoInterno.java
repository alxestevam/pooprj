/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 141812
 */
public class ProdutoMercadoInterno extends Produto {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="PRODMI_ID")
    private int id;
    private boolean incentivo;

    public ProdutoMercadoInterno() {
        this.setTipo(1);
    }

    public ProdutoMercadoInterno(int codigo, String nome, Categoria categoria, double preco, int moeda, double imposto, boolean incentivo) {
        super(codigo, nome, categoria, preco, moeda, imposto);
        this.setTipo(1);
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
