/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portaltrading.entidades;

import br.com.portaltrading.annotations.AuxCadastroConsulta;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Willian
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_USUARIO_GENERATOR", sequenceName = "SEQ_USUARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_USUARIO_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idUsuario")
    @AuxCadastroConsulta(listaCadastro=false)
    private long idUsuario;
    
    @Basic(optional = false)
//    @Column(name = "ddtcriacao")
    @Column()
    @Temporal(TemporalType.DATE)
    private Date ddtCriacao;
    
    @Basic(optional = false)
//    @Column(name = "sdcmail")
    @Column()
    @AuxCadastroConsulta(requerido=true,length=60)
    private String sdcMail;
    
    @Basic(optional = false)
//    @Column(name = "sdcsenha")
    @Column()
    private String sdcSenha;
    
//    @Column(name = "dtultimoacesso")
    @Column()
    @Temporal(TemporalType.DATE)
    private Date dtUltimoAcesso;
    
//    @Column(name = "dtinativo")
    @Column()
    @Temporal(TemporalType.DATE)
    @AuxCadastroConsulta(listaConsulta=false,tipoDado= AuxCadastroConsulta.TIPO_DADO.DATA,requerido=true)
    private Date dtInativo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<Funcionario> funcionario;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<Cliente> cliente;

    public Usuario() {
    }

    public Usuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(long idUsuario, Date ddtCriacao, String sdcMail, String sdcSenha) {
        this.idUsuario = idUsuario;
        this.ddtCriacao = ddtCriacao;
        this.sdcMail = sdcMail;
        this.sdcSenha = sdcSenha;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getDdtCriacao() {
        return ddtCriacao;
    }

    public void setDdtCriacao(Date ddtCriacao) {
        this.ddtCriacao = ddtCriacao;
    }

    public String getSdcMail() {
        return sdcMail;
    }

    public void setSdcMail(String sdcMail) {
        this.sdcMail = sdcMail;
    }

    public String getSdcSenha() {
        return sdcSenha;
    }

    public void setSdcSenha(String sdcSenha) {
        this.sdcSenha = sdcSenha;
    }

    public Date getDtUltimoAcesso() {
        return dtUltimoAcesso;
    }

    public void setDtUltimoAcesso(Date dtUltimoAcesso) {
        this.dtUltimoAcesso = dtUltimoAcesso;
    }

    public Date getDtInativo() {
        return dtInativo;
    }

    public void setDtInativo(Date dtInativo) {
        this.dtInativo = dtInativo;
    }
    
    

    @XmlTransient
    public List<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(List<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }

    @XmlTransient
    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
