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
public class CategoriaService extends ServiceBase<Categoria, Integer> {
    
    public CategoriaService() {
        super(new CategoriaRepository());
    }
    
    @Override
    public Categoria save(Categoria obj) {
        if(obj.getDescricao() == null) return null;
        
        obj.setDescricao(obj.getDescricao().trim().toUpperCase());
        
        if(obj.getDescricao().isEmpty()) return null;
        
        return (Categoria) _repository.save(obj);
    }

}
