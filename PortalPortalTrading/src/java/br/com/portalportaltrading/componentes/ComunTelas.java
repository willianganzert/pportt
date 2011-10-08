/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portalportaltrading.componentes;

import br.com.portalportaltrading.util.UtlMsg;
import br.com.portaltrading.annotations.AuxCadastroConsulta;
import java.lang.reflect.Field;

/**
 *
 * @author Willian
 */
public class ComunTelas {
    private boolean showPopup;
    protected String sdcTituloTelaCad;
    private String sdcTitulo;
    private String sdcMensagem;
    private String tipoMensagem;
    
    public void chamaInfoPopup(String sdcMsg){
        chamaInfoPopup("Informativo", sdcMsg);
    }
    public void chamaInfoPopup(String sdcTitulo,String sdcMsg){
        this.tipoMensagem   = "info";
        this.sdcTitulo      = sdcTitulo.startsWith("label.")?UtlMsg.msg(sdcTitulo):sdcTitulo;
        this.sdcMensagem    = sdcTitulo.startsWith("info.")?UtlMsg.msg(sdcMsg):sdcMsg;
        this.showPopup      = true;
    }
    public void chamaAlertaPopup(String sdcMsg){
        chamaAlertaPopup("Alerta", sdcMsg);
    }
    public void chamaAlertaPopup(String sdcTitulo,String sdcMsg){
        this.tipoMensagem   = "alerta";
        this.sdcTitulo      = sdcTitulo.startsWith("label.")?UtlMsg.msg(sdcTitulo):sdcTitulo;
        this.sdcMensagem    = sdcTitulo.startsWith("alerta.")?UtlMsg.msg(sdcMsg):sdcMsg;
        this.showPopup      = true;
    }
    public void chamaErroPopup(String sdcMsg){
        chamaErroPopup("Erro", sdcMsg);
    }
    public void chamaErroPopup(String sdcTitulo,String sdcMsg){
        this.tipoMensagem   = "erro";
        this.sdcTitulo      = sdcTitulo.startsWith("label.")?UtlMsg.msg(sdcTitulo):sdcTitulo;
        this.sdcMensagem    = sdcTitulo.startsWith("erro.")?UtlMsg.msg(sdcMsg):sdcMsg;
        this.showPopup      = true;
    }

    public String fechaMensagem() {
        this.showPopup = false;
        return "";
    }
    
    public boolean validaDadosClasse(Object object){
        boolean valido = true;
        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length && valido; i++) {
            Field field = fields[i];
            AuxCadastroConsulta acc = field.getAnnotation(AuxCadastroConsulta.class);
            if(acc != null)
            {
                field.setAccessible(true);
                try
                {
                    if(acc.tipoDado().compareTo(AuxCadastroConsulta.TIPO_DADO.ALFA) == 0 && acc.length() != -1)
                    {
                        valido = ((String)field.get(object)).length() <= acc.length();
                    }
                    else if(acc.tipoDado().compareTo(AuxCadastroConsulta.TIPO_DADO.POSITIVO) == 0)
                    {
                        valido = ((Number)field.get(object)).longValue() >= 0L;
                    }
                    
                    if(acc.requerido())
                    {
                        valido = field.get(object) != null;
                        if(valido)
                            valido = ((String)field.get(object)).length() > 0;
                    }
                }catch(Exception e)
                {
                    System.out.println("ERRO AO VALIDAR DADOS. Exception: " + e.getMessage());
                    valido = false;
                }
            }
        }
        return valido;
    }
    
    public String getSdcMensagem() {
        return sdcMensagem;
    }

    public void setSdcMensagem(String sdcMensagem) {
        this.sdcMensagem = sdcMensagem;
    }

    public String getSdcTitulo() {
        return sdcTitulo;
    }

    public void setSdcTitulo(String sdcTitulo) {
        this.sdcTitulo = sdcTitulo;
    }

    public boolean isShowPopup() {
        return showPopup;
    }

    public void setShowPopup(boolean showPopup) {
        this.showPopup = showPopup;
    }

    public String getTipoMensagem() {
        return tipoMensagem;
    }

    public void setTipoMensagem(String tipoMensagem) {
        this.tipoMensagem = tipoMensagem;
    }

    public String getSdcTituloTelaCad() {
        return sdcTituloTelaCad;
    }    
}
