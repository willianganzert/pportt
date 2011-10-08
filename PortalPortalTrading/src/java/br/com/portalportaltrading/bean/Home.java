package br.com.portalportaltrading.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Willian
 *
 */
@ManagedBean
@SessionScoped
public class Home {

    public Home() {
    }

    public String logoff() {
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);        
        sessao.invalidate();        
        return "logoff";
    }

}
