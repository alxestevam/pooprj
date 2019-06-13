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
import domain.model.Categoria;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import domain.service.CategoriaService;
import utils.GrowlMessage;

/**
 *
 * @author 141812
 */
@ManagedBean
@SessionScoped
public class CategoriaMB implements Serializable {

    private Categoria categoria = new Categoria();
    private CategoriaService service = new CategoriaService();
    private Categoria selectedCategoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void addCategoria() {
        if (service.save(categoria) != null) {
            GrowlMessage.statusMessage(Categoria.class, GrowlMessage.MessageOption.SAVE, true);
        } else {
            GrowlMessage.statusMessage(Categoria.class, GrowlMessage.MessageOption.SAVE, false);
        }
        categoria = new Categoria();
        selectedCategoria = null;

    }

    public void removeCategoria() {
        removeCategoria(selectedCategoria);
    }

    public void removeCategoria(Categoria c) {
        if (service.remove(c)) {
            GrowlMessage.statusMessage(Categoria.class, GrowlMessage.MessageOption.REMOVE, true);
        } else {
            GrowlMessage.statusMessage(Categoria.class, GrowlMessage.MessageOption.REMOVE, false);
        }
    }

    public List<Categoria> getCategorias() {
        return service.getAll(Categoria.class);
    }

    public Categoria getSelectedCategoria() {
        return selectedCategoria;
    }

    public void setSelectedCategoria(Categoria selectedCategoria) {
        this.selectedCategoria = selectedCategoria;
    }

    public void onRowEdit(RowEditEvent event) {
        GrowlMessage.statusMessage(Categoria.class, GrowlMessage.MessageOption.EDIT, true);
    }

    public void onRowSelect(SelectEvent event) {
        categoria = selectedCategoria;
    }

    public void onRowUnselect(UnselectEvent event) {
        categoria = new Categoria();
    }
}
