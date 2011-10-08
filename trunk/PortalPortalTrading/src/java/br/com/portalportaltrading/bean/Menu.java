package br.com.portalportaltrading.bean;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIOutput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


/**
 *
 * @author willian
 */
@ManagedBean
@SessionScoped
public class Menu {

    public Menu() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ExternalContext etx = ctx.getExternalContext();
        
    }

//    public EntSegUsuario retornaUsuario(){
//        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        String snmLogin = request.getUserPrincipal().getName();
//
//        EntSegUsuario segUsuario = JpaSegUsuario.findByLogin(snmLogin);
//
//        return segUsuario;
//    }
    public void redirect() throws IOException{
        String url = "../cadastros/UsuarioCad.jsf";
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.sendRedirect(url);
    }

}
