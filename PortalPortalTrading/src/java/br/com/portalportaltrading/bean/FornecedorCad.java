/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portalportaltrading.bean;

import br.com.portalportaltrading.componentes.Campo;
import br.com.portalportaltrading.componentes.Coluna;
import br.com.portalportaltrading.componentes.ComunTelas;
import br.com.portalportaltrading.componentes.TabelaConfig;
import br.com.portalportaltrading.util.UtlMsg;
import br.com.portaltrading.annotations.AuxCadastroConsulta;
import br.com.portaltrading.entidades.Empresa;
import br.com.portaltrading.entidades.Fornecedor;
import br.com.portaltrading.jpa.JpaAllEntities;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Willian
 */
@ManagedBean
@ViewScoped
public class FornecedorCad extends ComunTelas implements ImplementsCad{
    private final Class classePrinciapalCad  = Fornecedor.class;
    private TabelaConfig tabelaConfigPricipalCad;
    /** Creates a new instance of FornecedorCad */
    public FornecedorCad() {
        this.sdcTituloTelaCad = UtlMsg.msg("tituloTabela.Fornecedor");
        
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
        colunas.add(new Coluna(UtlMsg.msg("label.Empresa.short.sdcRazaoSocial"), "empresa","sdcRazaoSocial"));
        
        this.tabelaConfigPricipalCad.setColunasTabela(colunas);
        this.tabelaConfigPricipalCad.setQtdPaginas(new Integer(listRegPrincial.size()/10));
        this.tabelaConfigPricipalCad.setListaRegistros(listRegPrincial);
    }
    
    public void rowSelectionListener(RowSelectorEvent event) {
        this.tabelaConfigPricipalCad.setSelected(((Fornecedor) this.tabelaConfigPricipalCad.getListaRegistros().get(event.getRow())).clone());
        this.tabelaConfigPricipalCad.setVisablePopupCad(true);
        this.tabelaConfigPricipalCad.setNovoReg(false);  
    }

    public String novo() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setEmpresa(new Empresa());
        this.tabelaConfigPricipalCad.setSelected(fornecedor);
        this.tabelaConfigPricipalCad.setVisablePopupCad(true);
        this.tabelaConfigPricipalCad.setNovoReg(true);
        return "";
    }

    public String salvar() {
        if(this.validaDadosClasse(this.tabelaConfigPricipalCad.getSelected()) &&
                this.validaDadosClasse(((Fornecedor)this.tabelaConfigPricipalCad.getSelected()).getEmpresa()))
        {
            ((Fornecedor)this.tabelaConfigPricipalCad.getSelected()).getEmpresa().setNidTipo(1);//TipoFornecedor
            ((Fornecedor)this.tabelaConfigPricipalCad.getSelected()).setNidAtivo(1);
            JpaAllEntities.insertOrUpdate(((Fornecedor)this.tabelaConfigPricipalCad.getSelected()).getEmpresa(),
                    (Fornecedor)this.tabelaConfigPricipalCad.getSelected());
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
        JpaAllEntities.delete(((Fornecedor)this.tabelaConfigPricipalCad.getSelected()).getEmpresa(),
                (Fornecedor)this.tabelaConfigPricipalCad.getSelected());
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
}
