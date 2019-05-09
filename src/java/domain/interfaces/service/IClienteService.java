/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.interfaces.service;

import domain.model.Cliente;
import java.util.List;

/**
 *
 * @author 171150
 */
public interface IClienteService {
    void removeCliente(Cliente cliente);
    List<Cliente> getClientes();
    Cliente getClienteByCodigo(int codigo);
    void salvar(Cliente cliente);
}
