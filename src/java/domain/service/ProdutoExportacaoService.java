/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.service;

import domain.model.ProdutoExportacao;
import infra.data.repository.ProdutoExportacaoRepository;

/**
 *
 * @author 141812
 */
public class ProdutoExportacaoService extends ServiceBase<ProdutoExportacao, Integer> {

    public ProdutoExportacaoService() {
        super(new ProdutoExportacaoRepository());
    }
    
    @Override
    public ProdutoExportacao save(ProdutoExportacao obj) {
        if (obj.getNome()== null) return null;
       
        obj.setNome(obj.getNome().trim().toUpperCase());
        
        if(obj.getNome().isEmpty()) return null;
        
        return (ProdutoExportacao) _repository.save(obj);
    }

}
