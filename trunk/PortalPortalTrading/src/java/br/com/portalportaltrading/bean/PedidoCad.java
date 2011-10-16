/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portalportaltrading.bean;

import br.com.portalportaltrading.componentes.Coluna;
import br.com.portalportaltrading.componentes.ComunTelas;
import br.com.portalportaltrading.componentes.TabelaConfig;
import br.com.portalportaltrading.util.UtlMsg;
import br.com.portaltrading.annotations.AuxCadastroConsulta;
import br.com.portaltrading.entidades.Pedido;
import br.com.portaltrading.entidades.Cliente;
import br.com.portaltrading.jpa.JpaAllEntities;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author Adam
 */
@ManagedBean
@ViewScoped
public class PedidoCad extends ComunTelas implements ImplementsCad{
    private final Class classePrinciapalCad  = Pedido.class;
    private TabelaConfig tabelaConfigPricipalCad;
    private List<SelectItem> itemsClientes;
    private List<Cliente> clientes;
    private long idClienteSelected = 0;
    /** Creates a new instance of Pedido */
    public PedidoCad() {
        this.sdcTituloTelaCad       = UtlMsg.msg("tituloTabela.Pedido");
        this.clientes                = JpaAllEntities.listAll(Cliente.class);
        this.itemsClientes               = this.convertClientes(this.clientes);
        this.tabelaConfigPricipalCad = new TabelaConfig(classePrinciapalCad);
        
        List<Coluna> colunas    = new ArrayList<Coluna>();
        List listRegPrincial    = JpaAllEntities.listAll(classePrinciapalCad);
        
        Field[] fields = classePrinciapalCad.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            AuxCadastroConsulta a = field.getAnnotation(AuxCadastroConsulta.class);
            if(a != null && a.listaConsulta())
            {
                colunas.add(new Coluna(UtlMsg.msg(
                        "label." + tabelaConfigPricipalCad.getClasseTabela().getSimpleName() + ".short." +
                        field.getName()), field.getName()));                
            }
        }
        
        this.tabelaConfigPricipalCad.setColunasTabela(colunas);
        this.tabelaConfigPricipalCad.setQtdPaginas(new Integer(listRegPrincial.size()/10));
        this.tabelaConfigPricipalCad.setListaRegistros(listRegPrincial);
    }
    
    public void rowSelectionListener(RowSelectorEvent event) {
        this.tabelaConfigPricipalCad.setSelected(((Pedido) this.tabelaConfigPricipalCad.getListaRegistros().get(event.getRow())).clone());
        this.idClienteSelected = ((Pedido) this.tabelaConfigPricipalCad.getSelected()).getCliente().getIdCliente();
        this.tabelaConfigPricipalCad.setVisablePopupCad(true);
        this.tabelaConfigPricipalCad.setNovoReg(false);
    }

    public String novo() {
        this.tabelaConfigPricipalCad.setSelected(new Pedido());
        this.tabelaConfigPricipalCad.setVisablePopupCad(true);
        this.tabelaConfigPricipalCad.setNovoReg(true);
        return "";
    }

    public String salvar() {
        if(this.validaDadosClasse(this.tabelaConfigPricipalCad.getSelected()))
        {
            JpaAllEntities.insertOrUpdate((Pedido)this.tabelaConfigPricipalCad.getSelected());
            this.tabelaConfigPricipalCad.setVisablePopupCad(false);
            
            List listRegPrincial = JpaAllEntities.listAll(classePrinciapalCad);
            this.tabelaConfigPricipalCad.setQtdPaginas(new Integer(listRegPrincial.size()/10));
            this.tabelaConfigPricipalCad.setListaRegistros(listRegPrincial);
        }
        else
        {
            chamaErroPopup("erro.dadosInvalidos");
        }
        return "";
    }

    public String excluir() {
        JpaAllEntities.delete((Pedido)this.tabelaConfigPricipalCad.getSelected());
        this.tabelaConfigPricipalCad.setVisablePopupCad(false);
        
        List listRegPrincial = JpaAllEntities.listAll(classePrinciapalCad);
        this.tabelaConfigPricipalCad.setQtdPaginas(new Integer(listRegPrincial.size()/10));
        this.tabelaConfigPricipalCad.setListaRegistros(listRegPrincial);
        return "";
    }

    public String cancelar() {
        this.tabelaConfigPricipalCad.setVisablePopupCad(false);        
        return "";
    }
    public void changeCliente(ValueChangeEvent event) {  
//        FacesContext facesContext = FacesContext.getCurrentInstance();
        long valorAntigo = (Long) event.getOldValue();
        long valorNovo   = (Long) event.getNewValue();
        if(valorNovo != 0) {
            for (int j = 0; j < clientes.size(); j++) {
                Cliente cliente = clientes.get(j);
                if(cliente.getIdCliente() == valorNovo){
                    ((Pedido) this.tabelaConfigPricipalCad.getSelected()).setCliente(cliente);
                    return;
                }
            }
        }
        else
            ((Pedido)this.tabelaConfigPricipalCad.getSelected()).setCliente(null);
    }
    private List<SelectItem> convertClientes(List<Cliente> clientes){
        List<SelectItem> items = new ArrayList<SelectItem>();
        items.add(new SelectItem(0, UtlMsg.msg("label.selecione")));
        
        if(clientes != null && clientes.size() > 0){
            for (Cliente cliente : clientes) {
                items.add(new SelectItem(cliente.getIdCliente(),cliente.getSnmCliente()));                
            }
        }
        return items;
    }
    /*
     * 
     * GetSet
     * 
     */

    public TabelaConfig getTabelaConfigPricipalCad() {
        return tabelaConfigPricipalCad;
    }

    public void setTabelaConfigPricipalCad(TabelaConfig tabelaConfigPricipalCad) {
        this.tabelaConfigPricipalCad = tabelaConfigPricipalCad;
    }

    public List<SelectItem> getItemsClientes() {
        return itemsClientes;
    }

    public void setItemsClientes(List<SelectItem> itemsClientes) {
        this.itemsClientes = itemsClientes;
    }

    public long getIdClienteSelected() {
        return idClienteSelected;
    }

    public void setIdClienteSelected(long idClienteSelected) {
        this.idClienteSelected = idClienteSelected;
    }
    
    
}
