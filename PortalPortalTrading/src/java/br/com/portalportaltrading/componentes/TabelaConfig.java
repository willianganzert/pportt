/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portalportaltrading.componentes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Willian
 */
public class TabelaConfig {
    private String sidDadosTabela = "";
    private String snmTabela = "";
    private long qtdPaginas = 0;
    private List<Coluna> colunasTabela;
    private List<Campo> camposTabelaCad;
    private List listaRegistros;
    private Object selected;
    private Class classeTabela;
    private boolean visablePopupCad;
    private boolean novoReg;
    
    public TabelaConfig(String sidDadosTabela) {
        this.sidDadosTabela = sidDadosTabela;
        this.colunasTabela = new ArrayList();
        this.camposTabelaCad = new ArrayList();
        this.listaRegistros = new ArrayList();
        this.visablePopupCad = false;
    }
    public TabelaConfig(Class c) {
        this.sidDadosTabela = c.getSimpleName();
        this.colunasTabela = new ArrayList<Coluna>();
        this.listaRegistros = new ArrayList();
        this.camposTabelaCad = new ArrayList();
        this.classeTabela = c;
        this.visablePopupCad = false;
    }
   
//    public abstract void rowSelectionListener(RowSelectorEvent event);

    public long getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(long qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    public String getSidDadosTabela() {
        return sidDadosTabela;
    }

    public void setSidDadosTabela(String sidDadosTabela) {
        this.sidDadosTabela = sidDadosTabela;
    }

    public String getSnmTabela() {
        return snmTabela;
    }

    public void setSnmTabela(String snmTabela) {
        this.snmTabela = snmTabela;
    }

    public List<Coluna> getColunasTabela() {
        return colunasTabela;
    }

    public void setColunasTabela(List<Coluna> colunasTabela) {
        this.colunasTabela = colunasTabela;
    }

    

    public List getListaRegistros() {
        return listaRegistros;
    }

    public void setListaRegistros(List listaRegistros) {
        this.listaRegistros = listaRegistros;
    }

    public Object getSelected() {
        return selected;
    }

    public void setSelected(Object selected) {
        this.selected = selected;
    }

    public Class getClasseTabela() {
        return classeTabela;
    }

    public void setClasseTabela(Class classeTabela) {
        this.classeTabela = classeTabela;
    }

    public List<Campo> getCamposTabelaCad() {
        return camposTabelaCad;
    }

    public void setCamposTabelaCad(List<Campo> camposTabelaCad) {
        this.camposTabelaCad = camposTabelaCad;
    }

    public boolean isVisablePopupCad() {
        return visablePopupCad;
    }

    public void setVisablePopupCad(boolean visablePopupCad) {
        this.visablePopupCad = visablePopupCad;
    }

    public boolean isNovoReg() {
        return novoReg;
    }

    public void setNovoReg(boolean novoReg) {
        this.novoReg = novoReg;
    }
    
    
}
