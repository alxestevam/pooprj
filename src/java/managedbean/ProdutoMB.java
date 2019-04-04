/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Categoria;
import model.Produto;
import model.ProdutoExportacao;
import model.ProdutoMercadoInterno;
import org.primefaces.event.RowEditEvent;
import service.CategoriaService;
import service.ProdutoService;

/**
 *
 * @author 141812
 */
@ManagedBean
@SessionScoped
public class ProdutoMB {
    private Produto produto = new Produto();
    private ProdutoService service = new ProdutoService();
    private Produto selectedProduto;
    private CategoriaService categoriaService = new CategoriaService();
    private Categoria selectedCategoria;
    List<String> destinos = Arrays.asList("Exportação", "Mercado Interno");
    private String destino;
    private boolean incentivo;
    private int escolhaTipo;

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
        Categoria cat = produto.getCategoria();
        if (cat != null) {
            if(produto.getTipo() == 0) {
                ProdutoExportacao produtoExportacao = new ProdutoExportacao();
                produtoExportacao.espProduto(produto, destino);
                
                service.addProduto(produtoExportacao);
            }
            else if(produto.getTipo() == 1){
                ProdutoMercadoInterno produtoMercadoInterno = new ProdutoMercadoInterno();
                produtoMercadoInterno.espProduto(produto, incentivo);
                
                service.addProduto(produtoMercadoInterno);
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
    
    public List<Produto> getProdutos(){
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
    
    public List<Categoria> getCategorias(){
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
}
