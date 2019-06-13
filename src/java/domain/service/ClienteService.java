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
    
    @Override
    public Cliente save(Cliente obj) {
        if (obj.getEndereco() != null && obj.getNome() != null) return null;
        
        obj.setEndereco(obj.getEndereco().trim().toUpperCase());
        obj.setNome(obj.getNome().trim().toUpperCase());
        
        if(obj.getEndereco().isEmpty() || obj.getNome().isEmpty()) return null;
        
        return (Cliente) _repository.save(obj);
    }
}
