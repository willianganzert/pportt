package br.com.portalportaltrading.bean;

import br.com.portalportaltrading.componentes.Coluna;
import br.com.portalportaltrading.componentes.ComunTelas;
import br.com.portalportaltrading.componentes.TabelaConfig;
import br.com.portaltrading.entidades.Usuario;
import br.com.portaltrading.jpa.UsuarioJpaController;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Willian
 *
 */
@ManagedBean
@ViewScoped
public class UsuarioCad extends ComunTelas implements ImplementsCad{

    private Usuario usuario;
    private TabelaConfig tabelaConfig;
    boolean visivelUsuarioCad = false;
    int icount = 0;
    public UsuarioCad() {
        this.sdcTituloTelaCad = "Usuário";
        
        this.usuario = new Usuario();
        this.tabelaConfig = new TabelaConfig("usuario");
        
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("EntidadesPortalTradingPU");
        UsuarioJpaController usuarioJpaController = new UsuarioJpaController(emf);
        List<Coluna> colunas = new ArrayList<Coluna>();
        List usuarios = usuarioJpaController.findUsuarioEntities();
        colunas.add(new Coluna("IDENTIFICADOR", "idUsuario"));
        colunas.add(new Coluna("Email", "sdcMail"));
        this.tabelaConfig.setColunasTabela(colunas);
        this.tabelaConfig.setQtdPaginas(new Integer(usuarios.size()/10));
        this.tabelaConfig.setListaRegistros(usuarios);
    }

    public void rowSelectionListener(RowSelectorEvent event) {
//        RowSelector rowSelecte = (RowSelector) event.getComponent(); 
        this.usuario            = (Usuario) ((Usuario) this.tabelaConfig.getListaRegistros().get(event.getRow())).clone();
        this.visivelUsuarioCad  = true;
    }
    public String salvar() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("EntidadesPortalTradingPU");
        UsuarioJpaController usuarioJpaController = new UsuarioJpaController(emf);
        usuario.setDdtCriacao(new Date());
        if(usuario.getIdUsuario() != 0)
        {
            try {
            usuarioJpaController.edit(usuario);
            } catch (Exception ex) {
                Logger.getLogger(UsuarioCad.class.getName()).log(Level.SEVERE, null, ex);
                chamaErroPopup("Não foi possível gravar registros.");
            }
        }
        else
        {
            usuarioJpaController.create(usuario);
            chamaInfoPopup("Registro salvo com Sucesso!");
        }
        return "";
    }

    public String excluir() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("EntidadesPortalTradingPU");
        UsuarioJpaController usuarioJpaController = new UsuarioJpaController(emf);
        usuario.setDdtCriacao(new Date());
        
        try {
            usuarioJpaController.destroy(usuario.getIdUsuario());
        } catch (Exception ex) {
            Logger.getLogger(UsuarioCad.class.getName()).log(Level.SEVERE, null, ex);
            chamaErroPopup("Erro! Registro não pode ser excluído.");
        }
        return "";
    }

    public String cancelar() {
        this.usuario = new Usuario();
        this.visivelUsuarioCad = false;
        icount++;
        System.out.println("cancelar" + icount);
        return "";
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TabelaConfig getTabelaConfig() {
        return tabelaConfig;
    }

    public void setTabelaConfig(TabelaConfig tabelaConfig) {
        this.tabelaConfig = tabelaConfig;
    }

    public boolean isVisivelUsuarioCad() {
        return visivelUsuarioCad;
    }

    public String novo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
