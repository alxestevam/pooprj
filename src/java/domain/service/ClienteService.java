/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.service;

import domain.model.Cliente;
import infra.data.repository.ClienteRepository;

/**
 *
 * @author 141812
 */
public class ClienteService extends ServiceBase<Cliente, Integer>{

    public ClienteService() {
        super(new ClienteRepository());
    }
}
