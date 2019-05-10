/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.service;

import domain.interfaces.repository.IClienteRepository;
import domain.interfaces.service.IClienteService;
import java.util.List;
import domain.model.Cliente;

/**
 *
 * @author 141812
 */
public class ClienteService implements IClienteService {

    private final IClienteRepository clienteRepository;

    public ClienteService(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    
    @Override
    public void removeCliente(Cliente cliente) {
        clienteRepository.remove(cliente);
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.getAll(Cliente.class);
    }

    @Override
    public Cliente getClienteByCodigo(int codigo) {
        return clienteRepository.getById(Cliente.class, codigo);
    }

    @Override
    public void salvar(Cliente cliente) {
        clienteRepository.save(cliente);
    }
    
}
