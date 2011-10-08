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
import br.com.portaltrading.entidades.TipoDocumento;
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
public class TipoDocumentoCad extends ComunTelas implements ImplementsCad{
    private final Class classePrinciapalCad  = TipoDocumento.class;
    
    private TipoDocumento tipoDocumento;
    private TabelaConfig tabelaConfigPricipalCad;
    
    public TipoDocumentoCad() {
        this.sdcTituloTelaCad = UtlMsg.msg("tituloTabela.TipoDocumento");
        
        this.tabelaConfigPricipalCad = new TabelaConfig(classePrinciapalCad);
        
        List<Coluna> colunas = new ArrayList<Coluna>();
        List<Campo> camposCad = new ArrayList<Campo>();
        List listRegPrincial = JpaAllEntities.listAll(classePrinciapalCad);
        
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
            if(a != null && a.listaCadastro())
            {
                camposCad.add(new Campo(UtlMsg.msg(
                        "label." + tabelaConfigPricipalCad.getClasseTabela().getSimpleName() + ".short." +
                        field.getName()), field.getName(),"text",a.length(),a.requerido()));
            }
        }
        
        this.tabelaConfigPricipalCad.setColunasTabela(colunas);
        this.tabelaConfigPricipalCad.setCamposTabelaCad(camposCad);
        this.tabelaConfigPricipalCad.setQtdPaginas(new Integer(listRegPrincial.size()/10));
        this.tabelaConfigPricipalCad.setListaRegistros(listRegPrincial);
    }
    
    public void rowSelectionListener(RowSelectorEvent event) {
        this.tabelaConfigPricipalCad.setSelected(((TipoDocumento) this.tabelaConfigPricipalCad.getListaRegistros().get(event.getRow())).clone());
        this.tabelaConfigPricipalCad.setVisablePopupCad(true);
    }

    public String novo() {
        this.tabelaConfigPricipalCad.setSelected(new TipoDocumento());
        this.tabelaConfigPricipalCad.setVisablePopupCad(true);
        return "";
    }
    public String salvar() {
        if(this.validaDadosClasse(this.tabelaConfigPricipalCad.getSelected()))
        {
            JpaAllEntities.insertOrUpdate((TipoDocumento)this.tabelaConfigPricipalCad.getSelected());
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
        JpaAllEntities.delete((TipoDocumento)this.tabelaConfigPricipalCad.getSelected());
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

    public TabelaConfig getTabelaConfigPricipalCad() {
        return tabelaConfigPricipalCad;
    }

    public void setTabelaConfigPricipalCad(TabelaConfig tabelaConfigPricipalCad) {
        this.tabelaConfigPricipalCad = tabelaConfigPricipalCad;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
}
