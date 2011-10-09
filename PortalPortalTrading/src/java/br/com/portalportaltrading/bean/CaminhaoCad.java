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
import br.com.portaltrading.entidades.RepRodoviario;
import br.com.portaltrading.jpa.JpaAllEntities;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Adam
 */
@ManagedBean
@ViewScoped
public class CaminhaoCad extends ComunTelas implements ImplementsCad{
    private final Class classePrinciapalCad  = Caminhao.class;
    private TabelaConfig tabelaConfigPricipalCad;
    private List<SelectItem> repItemsRodoviarios;
    private List<RepRodoviario> repRodoviarios;
    /** Creates a new instance of FornecedorCad */
    public CaminhaoCad() {
        this.sdcTituloTelaCad = UtlMsg.msg("tituloTabela.Caminhao");
        this.repRodoviarios         = JpaAllEntities.listAll(RepRodoviario.class);
        this.repItemsRodoviarios    = this.convertItensRepresentante(this.repRodoviarios);
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
        this.tabelaConfigPricipalCad.setSelected(((Caminhao) this.tabelaConfigPricipalCad.getListaRegistros().get(event.getRow())).clone());
        this.tabelaConfigPricipalCad.setVisablePopupCad(true);
        this.tabelaConfigPricipalCad.setNovoReg(false);
    }

    public String novo() {
        this.tabelaConfigPricipalCad.setSelected(new Caminhao());
        this.tabelaConfigPricipalCad.setVisablePopupCad(true);
        this.tabelaConfigPricipalCad.setNovoReg(true);
        return "";
    }

    public String salvar() {
        if(this.validaDadosClasse(this.tabelaConfigPricipalCad.getSelected()))
        {
            JpaAllEntities.insertOrUpdate((Caminhao)this.tabelaConfigPricipalCad.getSelected());
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
        JpaAllEntities.delete((Caminhao)this.tabelaConfigPricipalCad.getSelected());
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
    public void changeRepRodoviario()
    {
        for (int i = 0; i < repItemsRodoviarios.size(); i++) {
            SelectItem selectItem = repItemsRodoviarios.get(i);        
            for (int j = 0; j < repRodoviarios.size(); j++) {
                RepRodoviario repRodoviario = repRodoviarios.get(j);
                if(repRodoviario.getIdRepRodoviario() == ((Long)selectItem.getValue()).longValue()){
                    ((Caminhao)this.tabelaConfigPricipalCad.getSelected()).setRepRodoviario(repRodoviario);
                    return;
                }
            }
        }        
    }
    private List<SelectItem> convertItensRepresentante(List<RepRodoviario> repRodoviarios){
        List<SelectItem> items = new ArrayList<SelectItem>();
        if(repRodoviarios != null && repRodoviarios.size() > 0){
            for (RepRodoviario repRodoviario : repRodoviarios) {
                items.add(new SelectItem(repRodoviario.getIdRepRodoviario(),repRodoviario.getEmpresa().getSdcRazaoSocial()));                
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
}
