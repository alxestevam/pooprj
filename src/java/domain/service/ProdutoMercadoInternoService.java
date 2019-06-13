/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.service;

import domain.model.ProdutoMercadoInterno;
import infra.data.repository.ProdutoMercadoInternoRepository;

/**
 *
 * @author 141812
 */
public class ProdutoMercadoInternoService extends ServiceBase<ProdutoMercadoInterno, Integer> {

    public ProdutoMercadoInternoService() {
        super(new ProdutoMercadoInternoRepository());
    }
    
    @Override
    public ProdutoMercadoInterno save(ProdutoMercadoInterno obj) {
        if (obj.getNome()== null) return null;
       
        obj.setNome(obj.getNome().trim().toUpperCase());
        
        if(obj.getNome().isEmpty()) return null;
        
        return (ProdutoMercadoInterno) _repository.save(obj);
    }

}
