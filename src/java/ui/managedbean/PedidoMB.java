/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import domain.model.Cliente;
import domain.model.ItemPedido;
import domain.model.Pedido;
import domain.model.Produto;
import domain.model.ProdutoExportacao;
import domain.model.ProdutoMercadoInterno;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import domain.service.ClienteService;
import domain.service.PedidoService;
import domain.service.ProdutoExportacaoService;
import domain.service.ProdutoMercadoInternoService;
import utils.GrowlMessage;

/**
 *
 * @author 141812
 */
@ManagedBean
@SessionScoped
public class PedidoMB implements Serializable {

    private Pedido pedido = new Pedido();
    private final PedidoService service
            = new PedidoService();
    private Pedido selectedPedido;
    private ItemPedido selectedItem;
    private final ClienteService clienteService
            = new ClienteService();
    private Produto produto;
    private final ProdutoMercadoInternoService produtoMIService
            = new ProdutoMercadoInternoService();
    private final ProdutoExportacaoService produtoExpService
            = new ProdutoExportacaoService();
    private int clienteId;
    private int produtoId;
    private int quantidade;

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public ItemPedido getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(ItemPedido selectedItem) {
        this.selectedItem = selectedItem;
    }

    public List<Produto> getProdutos() {
        List<Produto> produtos = new ArrayList<>();
        for (Produto p : getProdutosExportacao()) {
            produtos.add(p);
        }
        for (Produto p : getProdutosMercadoInterno()) {
            produtos.add(p);
        }
        return produtos;
    }

    public List<ProdutoExportacao> getProdutosExportacao() {
        return produtoExpService.getAll(ProdutoExportacao.class);
    }

    public List<ProdutoMercadoInterno> getProdutosMercadoInterno() {
        return produtoMIService.getAll(ProdutoMercadoInterno.class);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void addPedido() {
        boolean status = false;
        Cliente cli = (Cliente) clienteService.getById(Cliente.class, clienteId);
        pedido.setCliente(cli);
        Calendar c = Calendar.getInstance();
        pedido.setData(c.getTime());
        status = service.save(pedido) != null;
        pedido.getCliente().addPedido(pedido);
        status = status && (clienteService.save(pedido.getCliente()) != null);
        pedido = new Pedido();
        
        if(status) {
            GrowlMessage.statusMessage(Pedido.class, GrowlMessage.MessageOption.SAVE, true);
        } else {
            GrowlMessage.statusMessage(Pedido.class, GrowlMessage.MessageOption.SAVE, false);
        }
    }

    public void addItemPedido() {
        ProdutoExportacao pE
                = (ProdutoExportacao) produtoExpService.getById(ProdutoExportacao.class, produtoId);
        ProdutoMercadoInterno pMI
                = (ProdutoMercadoInterno) produtoMIService.getById(ProdutoMercadoInterno.class, produtoId);

        Produto p;

        if (pE == null) {
            p = pMI;
        } else {
            p = pE;
        }

        if (quantidade != 0) {
            pedido.addItem(quantidade, p);
        }
        quantidade = 0;
    }

    public void removeItemPedido(Pedido pedido, ItemPedido item) {
        pedido.removeItem(item.getNumero());
    }

    public void removePedido() {
        removePedido(selectedPedido);
    }

    public void removePedido(Pedido c) {
        if(service.remove(c)) {
            GrowlMessage.statusMessage(Pedido.class, GrowlMessage.MessageOption.REMOVE, true);
        } else {
            GrowlMessage.statusMessage(Pedido.class, GrowlMessage.MessageOption.REMOVE, false);
        }
    }

    public List<Pedido> getPedidos() {
        return service.getAll(Pedido.class);
    }

    public List<Cliente> getClientes() {
        return clienteService.getAll(Cliente.class);
    }

    public Pedido getSelectedPedido() {
        return selectedPedido;
    }

    public void setSelectedPedido(Pedido selectedPedido) {
        this.selectedPedido = selectedPedido;
    }

    public void onRowEdit(RowEditEvent event) {
        GrowlMessage.statusMessage(Pedido.class, GrowlMessage.MessageOption.EDIT, true);
    }

    public void onRowSelect(SelectEvent event) {
        pedido = selectedPedido;
    }

    public void onRowUnselect(UnselectEvent event) {
        pedido = new Pedido();
    }
}
