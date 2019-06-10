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
import domain.model.Categoria;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import domain.service.CategoriaService;
import infra.data.repository.CategoriaRepository;
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
        try {
            service.save(categoria);
            GrowlMessage.showMessage(FacesMessage.SEVERITY_INFO, "Categoria salva", null);
        } catch (Exception e) {
            GrowlMessage.showMessage(FacesMessage.SEVERITY_ERROR, "Nao foi possivel salvar", null);
        } finally {
            categoria = new Categoria();
            selectedCategoria = null;
        }
    }

    public void removeCategoria() {
        service.remove(selectedCategoria);
    }

    public void removeCategoria(Categoria c) {
        try {
            service.remove(c);
            GrowlMessage.showMessage(FacesMessage.SEVERITY_INFO, "Categoria removida", null);
        } catch (Exception e) {
            GrowlMessage.showMessage(FacesMessage.SEVERITY_ERROR, "Nao foi possivel remover", null);
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
        GrowlMessage.showMessage(FacesMessage.SEVERITY_INFO, "Categoria editada", null);
    }

    public void onRowSelect(SelectEvent event) {
        categoria = selectedCategoria;
    }

    public void onRowUnselect(UnselectEvent event) {
        categoria = new Categoria();
    }
}
