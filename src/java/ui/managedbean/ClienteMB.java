/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.managedbean;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import domain.model.Cliente;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import domain.service.ClienteService;
import utils.GrowlMessage;

/**
 *
 * @author 141812
 */
@ManagedBean
@SessionScoped
public class ClienteMB implements Serializable {

    private Cliente cliente = new Cliente();
    private final ClienteService service = new ClienteService();
    private Cliente selectedCliente;
    private boolean editandoCliente;

    public boolean isEditandoCliente() {
        return editandoCliente;
    }

    public void setEditandoCliente(boolean editandoCliente) {
        this.editandoCliente = editandoCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addCliente() {

        if (service.save(cliente) != null) {
            GrowlMessage.statusMessage(Cliente.class, GrowlMessage.MessageOption.SAVE, true);
        } else {
            GrowlMessage.statusMessage(Cliente.class, GrowlMessage.MessageOption.SAVE, false);
        }
        selectedCliente = null;
        cliente = new Cliente();

    }

    public void removeCliente() {
        removeCliente(selectedCliente);

    }

    public void removeCliente(Cliente c) {
        if (service.remove(c)) {
            GrowlMessage.statusMessage(Cliente.class, GrowlMessage.MessageOption.REMOVE, true);
        } else {
            GrowlMessage.statusMessage(Cliente.class, GrowlMessage.MessageOption.REMOVE, false);
        }
    }

    public List<Cliente> getClientes() {
        return service.getAll(Cliente.class);
    }

    public Cliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }

    public void onRowEdit(RowEditEvent event) {
        GrowlMessage.statusMessage(Cliente.class, GrowlMessage.MessageOption.EDIT, true);
    }

    public void onRowSelect(SelectEvent event) {
        cliente = selectedCliente;
    }

    public void onRowUnselect(UnselectEvent event) {
        cliente = new Cliente();
    }
}
