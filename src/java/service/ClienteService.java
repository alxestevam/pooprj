/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.Serializable;
import java.util.ArrayList;
import model.Cliente;
import model.Pedido;

/**
 *
 * @author 141812
 */
public class ClienteService implements Serializable {

    private final ArrayList<Cliente> clientes = Dados.getClientes();
    private final PedidoService pedidoService = new PedidoService();

    public void addCliente(Cliente cliente) {
        if(!cliente.getNome().equals("") &&
           !cliente.getEndereco().equals("") &&
           !cliente.getTelefone().equals("")) {
            if(clientes.isEmpty()) {
                cliente.setCodigo(1);
            } else {
                cliente.setCodigo(clientes.get(clientes.size() - 1).getCodigo() + 1);
            }
            
            clientes.add(cliente);
        }
    }

    public void removeCliente(Cliente cliente) {
      
        for(Pedido pedido : cliente.getPedidos()) {
            pedidoService.removePedido(pedido);
        }
        clientes.remove(cliente);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public Cliente getClienteByCodigo(int codigo) {
        for (Cliente c : clientes) {
            if (c.getCodigo() == codigo) {
                return c;
            }

        }
        return null;
    }


}
