/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;

/**
 *
 * @author 141812
 */
@Entity
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy=SEQUENCE)
    @Column(name="CATEGORIA_ID")
    private int id;
    private String descricao;
    
    public Categoria() {
        
    }
    
    public Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Categoria{" + "descricao=" + descricao + '}';
    }
    
    
}
