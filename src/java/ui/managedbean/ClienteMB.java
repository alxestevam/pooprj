/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.managedbean;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import domain.model.Cliente;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import domain.service.ClienteService;
import infra.data.repository.ClienteRepository;

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
        service.save(cliente);
        selectedCliente = null;
        cliente = new Cliente();
    }

    public void removeCliente() {
        service.remove(selectedCliente);
    }

    public void removeCliente(Cliente c) {
        service.remove(c);
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
        FacesMessage msg = new FacesMessage("Cliente Editado "
                + ((Cliente) event.getObject()).getCodigo());
        FacesContext.getCurrentInstance().
                addMessage(null, msg);
    }

    public void onRowSelect(SelectEvent event) {
        cliente = selectedCliente;
    }

    public void onRowUnselect(UnselectEvent event) {
        cliente = new Cliente();
    }
}
