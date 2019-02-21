/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.Categoria;
import model.Produto;

/**
 *
 * @author 141812
 */
public class CategoriaService {

    private ArrayList<Categoria> categorias = Dados.getCategorias();
    private ArrayList<Produto> produtos = Dados.getProdutos();

    public void addCategoria(Categoria categoria) {
        boolean add = true;
        if(!categoria.getDescricao().equals("")) {
            for(Categoria c : categorias) {
                if(c.getDescricao().equals(categoria.getDescricao())) {
                    add = false;
                    break;
                }
            }
            if(add) {
                categorias.add(categoria);
            }
        }
    }

    public void removeCategoria(Categoria categoria) {
        boolean remove = true;
        
        for(Produto produto : produtos) {
            if(produto.getCategoria().equals(categoria)) {
                remove = false;
                break;
            }
        }
        if(remove)
            categorias.remove(categoria);
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public Categoria getCategoriaByDescricao(String value) {
        for (Categoria c : categorias) {
            if (c.getDescricao().equals(value)) {
                return c;
            }

        }
        return null;
    }


}
