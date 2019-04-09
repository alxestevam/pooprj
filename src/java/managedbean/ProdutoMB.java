/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Categoria;
import model.Cliente;
import model.Produto;
import model.ProdutoExportacao;
import model.ProdutoMercadoInterno;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import service.CategoriaService;
import service.ProdutoExportacaoService;

/**
 *
 * @author 141812
 */
@ManagedBean
@SessionScoped
public class ProdutoMB implements Serializable {

    private Produto produto = new Produto();
    private ProdutoExportacaoService service = new ProdutoExportacaoService();
    private Produto selectedProduto;
    private CategoriaService categoriaService = new CategoriaService();
    private Categoria selectedCategoria;
    List<String> destinos = Arrays.asList("Exportação", "Mercado Interno");
    private String destino;
    private boolean incentivo;
    private int escolhaTipo;
    private int categoriaId;

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getEscolhaTipo() {
        return escolhaTipo;
    }

    public void setEscolhaTipo(int escolhaTipo) {
        this.escolhaTipo = escolhaTipo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public boolean isIncentivo() {
        return incentivo;
    }

    public void setIncentivo(boolean incentivo) {
        this.incentivo = incentivo;
    }

    public List<String> getDestinos() {
        return destinos;
    }

    public void setDestinos(List<String> destinos) {
        this.destinos = destinos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void addProduto() {
        Categoria cat = categoriaService.getCategoriaById(categoriaId);
        
        if (cat != null) {
            if (getEscolhaTipo() == 0) {
                ProdutoExportacao produtoExportacao = new ProdutoExportacao();
                produtoExportacao.espProduto(produto, destino);

                service.salvar(produtoExportacao);
            } else if (getEscolhaTipo() == 1) {
                ProdutoMercadoInterno produtoMercadoInterno = new ProdutoMercadoInterno();
                produtoMercadoInterno.espProduto(produto, incentivo);

                service.salvar(produtoMercadoInterno);
            }

            produto = new Produto();
        }

    }

    public void removeProduto() {
        service.removeProduto(selectedProduto);
    }

    public void removeProduto(Produto c) {
        service.removeProduto(c);
    }

    public List<Produto> getProdutos() {
        return service.getProdutos();
    }

    public Produto getSelectedProduto() {
        return selectedProduto;
    }

    public Categoria getSelectedCategoria() {
        return selectedCategoria;
    }

    public void setSelectedCategoria(Categoria selectedCategoria) {
        this.selectedCategoria = selectedCategoria;
    }

    public List<Categoria> getCategorias() {
        return categoriaService.getCategorias();
    }

    public void setSelectedProduto(Produto selectedProduto) {
        this.selectedProduto = selectedProduto;
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Produto Editado",
                ((Produto) event.getObject()).getNome());
        FacesContext.getCurrentInstance().
                addMessage(null, msg);
    }

    public void onRowSelect(SelectEvent event) {
        produto = selectedProduto;
    }

    public void onRowUnselect(UnselectEvent event) {
        produto = new Produto();
    }
}
