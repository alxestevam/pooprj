/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import org.primefaces.event.RowEditEvent;
import service.ClienteService;
import service.PedidoService;
import service.ProdutoService;

/**
 *
 * @author 141812
 */
@ManagedBean
@SessionScoped
public class PedidoMB implements Serializable {
    private Pedido pedido = new Pedido();
    private final PedidoService service = new PedidoService();
    private Pedido selectedPedido;
    private ItemPedido selectedItem;
    private final ClienteService clienteService = new ClienteService();
    private Produto produto;
    private final ProdutoService produtoService = new ProdutoService();
    private int quantidade;

    public ItemPedido getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(ItemPedido selectedItem) {
        this.selectedItem = selectedItem;
    }
    
    public List<Produto> getProdutos() {
        return produtoService.getProdutos();
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
        Calendar c = Calendar.getInstance();
        pedido.setData(c.getTime());
        service.addPedido(pedido);
        pedido.getCliente().addPedido(pedido);
        pedido = new Pedido();
    }
    
    public void addItemPedido() {
        if(quantidade != 0)
            pedido.addItem(quantidade, produto);
        quantidade = 0;
    }
    
    public void removeItemPedido(Pedido pedido, ItemPedido item) {
        pedido.removeItem(item.getNumero());
    }
    
    public void removePedido() {
        service.removePedido(selectedPedido);
    }
    
    public void removePedido(Pedido c) {
        service.removePedido(c);
    }
    
    public List<Pedido> getPedidos(){
        return service.getPedidos();
    }
    
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }

    public Pedido getSelectedPedido() {
        return selectedPedido;
    }

    public void setSelectedPedido(Pedido selectedPedido) {
        this.selectedPedido = selectedPedido;
    }    
    
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Pedido Editado nº" +
                ((Pedido) event.getObject()).getNumero());
        FacesContext.getCurrentInstance().
                addMessage(null, msg);
    }
}
