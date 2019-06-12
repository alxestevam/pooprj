/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.service;

import domain.model.Pedido;
import infra.data.repository.PedidoRepository;

/**
 *
 * @author 141812
 */
public class PedidoService extends ServiceBase<Pedido, Integer>{

    public PedidoService() {
        super(new PedidoRepository());
    }


}
