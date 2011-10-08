/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portalportaltrading.teste;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Willian
 */
@ManagedBean
@RequestScoped
public class WelcomeBean {

    private String smyName;
    /** Creates a new instance of WelcomeBean */
    public WelcomeBean() {
        smyName = "Willian";
    }

    public String getSmyName() {
        return smyName;
    }

    public void setSmyName(String smyName) {
        this.smyName = smyName;
    }
    
}
