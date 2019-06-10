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
public class ProdutoMercadoInternoService extends ServiceBase<ProdutoMercadoInternoRepository, ProdutoMercadoInterno, Integer> {

    public ProdutoMercadoInternoService() {
        super(new ProdutoMercadoInternoRepository());
    }

}
