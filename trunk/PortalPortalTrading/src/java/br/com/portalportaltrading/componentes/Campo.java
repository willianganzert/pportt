/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portalportaltrading.componentes;

/**
 *
 * @author Willian
 */
public class Campo {
    private String labelCampo = "";
    private String snmCampo = "";
    private String stpCampo = "";
    private int length = -1;
    private boolean requerido = false;

    public Campo(String labelColuna, String snmCampo, String stpCampo,int length,boolean requerido) {
        this.labelCampo    = labelColuna;
        this.snmCampo = snmCampo; 
        this.stpCampo = stpCampo;
        this.length = length;
        this.requerido = requerido;
    }

    public String getLabelCampo() {
        return labelCampo;
    }

    public void setLabelCampo(String labelColuna) {
        this.labelCampo = labelColuna;
    }

    public String getSnmCampo() {
        return snmCampo;
    }

    public void setSnmCampo(String snmCampo) {
        this.snmCampo = snmCampo;
    }

    public String getStpCampo() {
        return stpCampo;
    }

    public void setStpCampo(String stpCampo) {
        this.stpCampo = stpCampo;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isRequerido() {
        return requerido;
    }

    public void setRequerido(boolean requerido) {
        this.requerido = requerido;
    }
    
    
}
