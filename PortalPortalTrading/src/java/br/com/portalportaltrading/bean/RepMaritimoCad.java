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
import br.com.portaltrading.entidades.RepMaritimo;
import br.com.portaltrading.jpa.JpaAllEntities;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Adam
 */
@ManagedBean
@ViewScoped
public class RepMaritimoCad extends ComunTelas implements ImplementsCad{
    private final Class classePrinciapalCad  = RepMaritimo.class;
    private TabelaConfig tabelaConfigPricipalCad;
    /** Creates a new instance of FornecedorCad */
    public RepMaritimoCad() {
        this.sdcTituloTelaCad = UtlMsg.msg("tituloTabela.RepMaritimo");
        
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
        this.tabelaConfigPricipalCad.setSelected(((RepMaritimo) this.tabelaConfigPricipalCad.getListaRegistros().get(event.getRow())).clone());
        this.tabelaConfigPricipalCad.setVisablePopupCad(true);
    }

    public String novo() {
        RepMaritimo repMaritimo = new RepMaritimo();
        repMaritimo.setEmpresa(new Empresa());
        this.tabelaConfigPricipalCad.setSelected(repMaritimo);
        this.tabelaConfigPricipalCad.setVisablePopupCad(true);
        return "";
    }

    public String salvar() {
        if(this.validaDadosClasse(this.tabelaConfigPricipalCad.getSelected()))
        {
            ((RepMaritimo)this.tabelaConfigPricipalCad.getSelected()).getEmpresa().setNidTipo(1);//TipoFornecedor
//            ((RepMaritimo)this.tabelaConfigPricipalCad.getSelected()).setNidAtivo(2);
            JpaAllEntities.insertOrUpdate(((RepMaritimo)this.tabelaConfigPricipalCad.getSelected()).getEmpresa(),
                    (RepMaritimo)this.tabelaConfigPricipalCad.getSelected());
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
        JpaAllEntities.delete(((RepMaritimo)this.tabelaConfigPricipalCad.getSelected()).getEmpresa(),(RepMaritimo)this.tabelaConfigPricipalCad.getSelected());
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
