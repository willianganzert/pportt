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
import br.com.portaltrading.entidades.Container;
import br.com.portaltrading.entidades.RepMaritimo;
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
public class ContainerCad extends ComunTelas implements ImplementsCad{
    private final Class classePrinciapalCad  = Container.class;
    private TabelaConfig tabelaConfigPricipalCad;
    private List<SelectItem> repItemsMaritimos;
    private List<RepMaritimo> repMaritimos;
    private long idRepMaritimoSelected = 0;
    /** Creates a new instance of ContainerCad */
    public ContainerCad() {
        this.sdcTituloTelaCad       = UtlMsg.msg("tituloTabela.Container");
        this.repMaritimos           = JpaAllEntities.listAll(RepMaritimo.class);
        this.repItemsMaritimos      = this.convertItensRepresentante(this.repMaritimos);
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
        this.tabelaConfigPricipalCad.setSelected(((Container) this.tabelaConfigPricipalCad.getListaRegistros().get(event.getRow())).clone());
        this.idRepMaritimoSelected = ((Container) this.tabelaConfigPricipalCad.getSelected()).getRepMaritimo().getIdRepMaritimo();
        this.tabelaConfigPricipalCad.setVisablePopupCad(true);
        this.tabelaConfigPricipalCad.setNovoReg(false);
    }

    public String novo() {
        this.tabelaConfigPricipalCad.setSelected(new Container());
        this.tabelaConfigPricipalCad.setVisablePopupCad(true);
        this.tabelaConfigPricipalCad.setNovoReg(true);
        return "";
    }

    public String salvar() {
        if(this.validaDadosClasse(this.tabelaConfigPricipalCad.getSelected()))
        {
            JpaAllEntities.insertOrUpdate((Container)this.tabelaConfigPricipalCad.getSelected());
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
        JpaAllEntities.delete((Container)this.tabelaConfigPricipalCad.getSelected());
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
    public void changeRepMaritimo(ValueChangeEvent event) {  
//        FacesContext facesContext = FacesContext.getCurrentInstance();
        long valorAntigo = (Long) event.getOldValue();
        long valorNovo   = (Long) event.getNewValue();
        if(valorNovo != 0) {
            for (int j = 0; j < repMaritimos.size(); j++) {
                RepMaritimo repMaritimo = repMaritimos.get(j);
                if(repMaritimo.getIdRepMaritimo() == valorNovo){
                    ((Container) this.tabelaConfigPricipalCad.getSelected()).setRepMaritimo(repMaritimo);
                    return;
                }
            }
        }
        else
            ((Container)this.tabelaConfigPricipalCad.getSelected()).setRepMaritimo(null);
    }
    private List<SelectItem> convertItensRepresentante(List<RepMaritimo> repMaritimos){
        List<SelectItem> items = new ArrayList<SelectItem>();
        items.add(new SelectItem(0, UtlMsg.msg("label.selecione")));
        
        if(repMaritimos != null && repMaritimos.size() > 0){
            for (RepMaritimo repMaritimo : repMaritimos) {
                items.add(new SelectItem(repMaritimo.getIdRepMaritimo(),repMaritimo.getEmpresa().getSdcRazaoSocial()));                
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

    public List<SelectItem> getRepItemsMaritimos() {
        return repItemsMaritimos;
    }

    public void setRepItemsMaritimos(List<SelectItem> repItemsMaritimos) {
        this.repItemsMaritimos = repItemsMaritimos;
    }

    public long getIdRepMaritimoSelected() {
        return idRepMaritimoSelected;
    }

    public void setIdRepMaritimoSelected(long idRepMaritimoSelected) {
        this.idRepMaritimoSelected = idRepMaritimoSelected;
    }
    
    
}
