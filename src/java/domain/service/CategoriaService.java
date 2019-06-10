/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.service;

import domain.model.Categoria;
import infra.data.repository.CategoriaRepository;

/**
 *
 * @author 141812
 */
public class CategoriaService extends ServiceBase<CategoriaRepository, Categoria, Integer> {
    
    public CategoriaService() {
        super(new CategoriaRepository());
    }

}
