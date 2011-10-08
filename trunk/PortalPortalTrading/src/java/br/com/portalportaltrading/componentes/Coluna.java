/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portalportaltrading.componentes;

/**
 *
 * @author Willian
 */
public class Coluna {
    private String labelColuna = "";
    private String snmCampoColuna = "";
    private String snmCampoColunaPai = "";

    public Coluna(String labelColuna, String snmCampoColuna) {
        this.labelColuna    = labelColuna;
        this.snmCampoColuna = snmCampoColuna;
        this.snmCampoColunaPai = null;
    }
    public Coluna(String labelColuna, String snmCampoColuna, String snmCampoColunaPai) {
        this.labelColuna    = labelColuna;
        this.snmCampoColuna = snmCampoColuna;
        this.snmCampoColunaPai = snmCampoColunaPai;
    }

    public String getLabelColuna() {
        return labelColuna;
    }

    public void setLabelColuna(String labelColuna) {
        this.labelColuna = labelColuna;
    }

    public String getSnmCampoColuna() {
        return snmCampoColuna;
    }

    public void setSnmCampoColuna(String snmCampoColuna) {
        this.snmCampoColuna = snmCampoColuna;
    }

    public String getSnmCampoColunaPai() {
        return snmCampoColunaPai;
    }

    public void setSnmCampoColunaPai(String snmCampoColunaPai) {
        this.snmCampoColunaPai = snmCampoColunaPai;
    }
    
}
