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
import br.com.portaltrading.entidades.Caminhao;
import br.com.portaltrading.entidades.Fornecedor;
import br.com.portaltrading.entidades.Produto;
import br.com.portaltrading.entidades.RepRodoviario;
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
public class ProdutoCad extends ComunTelas implements ImplementsCad{
    private final Class classePrinciapalCad  = Produto.class;
    private TabelaConfig tabelaConfigPricipalCad;
    private List<SelectItem> selectItemsFornecedor;
    private List<Fornecedor> fornecedores;
    private long idFornecedorSelecionado = 0;
    /** Creates a new instance of FornecedorCad */
    public ProdutoCad() {
        this.sdcTituloTelaCad           = UtlMsg.msg("tituloTabela.Produto");
        this.fornecedores               = JpaAllEntities.listAll(Fornecedor.class);
        this.selectItemsFornecedor      = this.convertItens(this.fornecedores);
        this.tabelaConfigPricipalCad    = new TabelaConfig(classePrinciapalCad);
        
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
        this.tabelaConfigPricipalCad.setSelected(((Produto) this.tabelaConfigPricipalCad.getListaRegistros().get(event.getRow())).clone());
        this.tabelaConfigPricipalCad.setVisablePopupCad(true);
        this.tabelaConfigPricipalCad.setNovoReg(false);
    }

    public String novo() {
        this.tabelaConfigPricipalCad.setSelected(new Produto());
        this.tabelaConfigPricipalCad.setVisablePopupCad(true);
        this.tabelaConfigPricipalCad.setNovoReg(true);
        return "";
    }

    public String salvar() {
        if(this.validaDadosClasse(this.tabelaConfigPricipalCad.getSelected()))
        {
            JpaAllEntities.insertOrUpdate((Produto)this.tabelaConfigPricipalCad.getSelected());
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
        JpaAllEntities.delete((Produto)this.tabelaConfigPricipalCad.getSelected());
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
    public void changeFornecedor(ValueChangeEvent event) {  
//        FacesContext facesContext = FacesContext.getCurrentInstance();
        long valorAntigo = (Long) event.getOldValue();
        long valorNovo   = (Long) event.getNewValue();
        if(valorNovo != 0) {
            for (int j = 0; j < fornecedores.size(); j++) {
                Fornecedor fornecedor = fornecedores.get(j);
                if(fornecedor.getId() == valorNovo){
                    ((Produto) this.tabelaConfigPricipalCad.getSelected()).setFornecedor(fornecedor);
                    return;
                }
            }
        }
        else
            ((Produto)this.tabelaConfigPricipalCad.getSelected()).setFornecedor(null);
    }
    private List<SelectItem> convertItens(List<Fornecedor> regsEntidades){
        List<SelectItem> items = new ArrayList<SelectItem>();
        items.add(new SelectItem(0, UtlMsg.msg("label.selecione")));
        
        if(regsEntidades != null && regsEntidades.size() > 0){
            for (Fornecedor fornecedor : regsEntidades) {
                items.add(new SelectItem(fornecedor.getIdFornecedor(),fornecedor.getEmpresa().getSdcRazaoSocial()));                
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

    public long getIdFornecedorSelecionado() {
        return idFornecedorSelecionado;
    }

    public void setIdFornecedorSelecionado(long idFornecedorSelecionado) {
        this.idFornecedorSelecionado = idFornecedorSelecionado;
    }

    public List<SelectItem> getSelectItemsFornecedor() {
        return selectItemsFornecedor;
    }
}
