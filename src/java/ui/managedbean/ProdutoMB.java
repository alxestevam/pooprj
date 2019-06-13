/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.managedbean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import domain.model.Categoria;
import domain.model.Produto;
import domain.model.ProdutoExportacao;
import domain.model.ProdutoMercadoInterno;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import domain.service.CategoriaService;
import domain.service.ProdutoExportacaoService;
import domain.service.ProdutoMercadoInternoService;
import utils.GrowlMessage;

/**
 *
 * @author 141812
 */
@ManagedBean
@SessionScoped
public class ProdutoMB implements Serializable {

    private Produto produto = new Produto();
    private final ProdutoMercadoInternoService serviceMI
            = new ProdutoMercadoInternoService();
    private final ProdutoExportacaoService serviceExp
            = new ProdutoExportacaoService();
    private ProdutoExportacao selectedProdutoExp;
    private ProdutoMercadoInterno selectedProdutoMI;
    private final CategoriaService categoriaService 
            = new CategoriaService();
    private Categoria selectedCategoria;
    List<String> destinos = Arrays.asList("Exportação", "Mercado Interno");
    private String destino;
    private boolean incentivo;
    private int escolhaTipo;
    private int categoriaId;

    public ProdutoExportacao getSelectedProdutoExp() {
        return selectedProdutoExp;
    }

    public void setSelectedProdutoExp(ProdutoExportacao selectedProdutoExp) {
        this.selectedProdutoExp = selectedProdutoExp;
    }

    public ProdutoMercadoInterno getSelectedProdutoMI() {
        return selectedProdutoMI;
    }

    public void setSelectedProdutoMI(ProdutoMercadoInterno selectedProdutoMI) {
        this.selectedProdutoMI = selectedProdutoMI;
    }

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
        Categoria cat = (Categoria) categoriaService.getById(Categoria.class, categoriaId);
        boolean status = false;

        if (cat != null) {
            if (getEscolhaTipo() == 0) {
                ProdutoExportacao produtoExportacao = new ProdutoExportacao();
                produtoExportacao.espProduto(produto, destino);

                if(serviceExp.save(produtoExportacao) != null) {
                    status = true;
                }
            } else if (getEscolhaTipo() == 1) {
                ProdutoMercadoInterno produtoMercadoInterno = new ProdutoMercadoInterno();
                produtoMercadoInterno.espProduto(produto, incentivo);

                if(serviceMI.save(produtoMercadoInterno) != null) {
                    status = true;
                }
            }
            
            if(status) {
                GrowlMessage.statusMessage(Produto.class, GrowlMessage.MessageOption.SAVE, true);
            } else {
                GrowlMessage.statusMessage(Produto.class, GrowlMessage.MessageOption.SAVE, false);
            }

            produto = new Produto();
        }

    }

    public void removeProdutoMercadoInterno() {
        removeProdutoMercadoInterno(selectedProdutoMI);
    }

    public void removeProdutoMercadoInterno(ProdutoMercadoInterno p) {
        if(serviceMI.remove(p)) {
            GrowlMessage.statusMessage(Produto.class, GrowlMessage.MessageOption.REMOVE, true);
        } else {
            GrowlMessage.statusMessage(Produto.class, GrowlMessage.MessageOption.REMOVE, false);
        }
    }

    public void removeProdutoExportacao() {
        removeProdutoExportacao(selectedProdutoExp);
    }

    public void removeProdutoExportacao(ProdutoExportacao p) {
        if(serviceExp.remove(p)) {
            GrowlMessage.statusMessage(Produto.class, GrowlMessage.MessageOption.REMOVE, true);
        } else {
            GrowlMessage.statusMessage(Produto.class, GrowlMessage.MessageOption.REMOVE, false);
        }
    }

    public List<ProdutoExportacao> getProdutosExportacao() {
        return serviceExp.getAll(ProdutoExportacao.class);
    }

    public List<ProdutoMercadoInterno> getProdutosMercadoInterno() {
        return serviceMI.getAll(ProdutoMercadoInterno.class);
    }

    public Categoria getSelectedCategoria() {
        return selectedCategoria;
    }

    public void setSelectedCategoria(Categoria selectedCategoria) {
        this.selectedCategoria = selectedCategoria;
    }

    public List<Categoria> getCategorias() {
        return categoriaService.getAll(Categoria.class);
    }

    public void onRowEdit(RowEditEvent event) {
        GrowlMessage.statusMessage(Produto.class, GrowlMessage.MessageOption.EDIT, true);
    }

    public void onRowSelectExp(SelectEvent event) {
        produto = selectedProdutoExp;
        destino = selectedProdutoExp.getDestino();
    }

    public void onRowSelectMI(SelectEvent event) {
        produto = selectedProdutoMI;
        incentivo = selectedProdutoMI.isIncentivo();
    }

    public void onRowUnselectExp(UnselectEvent event) {
        produto = new Produto();
    }

    public void onRowUnselectMI(UnselectEvent event) {
        produto = new Produto();
    }
}
