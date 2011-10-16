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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "cliente")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})
public class Cliente extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_CLIENTE_GENERATOR", sequenceName = "SEQ_CLIENTE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_CLIENTE_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idCliente")
    @AuxCadastroConsulta(listaCadastro=false)
    private long idCliente;
    
    @Basic(optional = false)
//    @Column(name = "snmCliente")
    @Column(name = "snmCliente")
    @AuxCadastroConsulta(length=250,requerido=true)
    private String snmCliente;
    
    @Basic(optional = false)
//    @Column(name = "ddtNascimento")
    @Column()
    @Temporal(TemporalType.DATE)
    @AuxCadastroConsulta(listaConsulta=false,tipoDado= AuxCadastroConsulta.TIPO_DADO.DATA,requerido=true)
    private Date ddtNascimento;
    
//    @Column(name = "sdcfone")
    @Column()
    @AuxCadastroConsulta(listaConsulta=false,length=15)
    private String sdcFone;
    
    @Basic(optional = false)
//    @Column(name = "sdcEmailContato")
    @Column()
    @AuxCadastroConsulta(listaConsulta=false,requerido=true,length=60)
    private String sdcEmailContato;
    
    @Basic(optional = false)
//    @Column(name = "sdcEndereco")
    @Column()
    @AuxCadastroConsulta(listaConsulta=false,requerido=true,length=250)
    private String sdcEndereco;
    
    @Basic(optional = false)
//    @Column(name = "snmCidade")
    @Column()
    @AuxCadastroConsulta(requerido=true,length=50)
    private String snmCidade;
    
    @Basic(optional = false)
//    @Column(name = "snmUf")
    @Column()
    @AuxCadastroConsulta(listaConsulta=false,requerido=true,length=50)
    private String snmUf;
    
    @Basic(optional = false)
//    @Column(name = "snmPais")
    @Column()
    @AuxCadastroConsulta(requerido=true,length=50)
    private String snmPais;
    
//    @Column(name = "nidstatus")
    @Column()
    @AuxCadastroConsulta(listaConsulta=false)
    private Integer nidStatus;
    
//    @Column(name = "ddtcadastro")
    @Column()
    @Temporal(TemporalType.DATE)
    private Date ddtCadastro;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Pedido> pedidos;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Documento> documentos;
    
//    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @JoinColumn(name = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;

    public Cliente() {
    }

    public Cliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(long idCliente, String snmCliente, Date ddtNascimento, String sdcEmailContato, String sdcEndereco, String snmCidade, String snmUf, String snmPais) {
        this.idCliente = idCliente;
        this.snmCliente = snmCliente;
        this.ddtNascimento = ddtNascimento;
        this.sdcEmailContato = sdcEmailContato;
        this.sdcEndereco = sdcEndereco;
        this.snmCidade = snmCidade;
        this.snmUf = snmUf;
        this.snmPais = snmPais;
    }

    public Date getDdtCadastro() {
        return ddtCadastro;
    }

    public void setDdtCadastro(Date ddtCadastro) {
        this.ddtCadastro = ddtCadastro;
    }

    public Date getDdtNascimento() {
        return ddtNascimento;
    }

    public void setDdtNascimento(Date ddtNascimento) {
        this.ddtNascimento = ddtNascimento;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getNidStatus() {
        return nidStatus;
    }

    public void setNidStatus(Integer nidStatus) {
        this.nidStatus = nidStatus;
    }

    public String getSdcEmailContato() {
        return sdcEmailContato;
    }

    public void setSdcEmailContato(String sdcEmailContato) {
        this.sdcEmailContato = sdcEmailContato;
    }

    public String getSdcEndereco() {
        return sdcEndereco;
    }

    public void setSdcEndereco(String sdcEndereco) {
        this.sdcEndereco = sdcEndereco;
    }

    public String getSdcFone() {
        return sdcFone;
    }

    public void setSdcFone(String sdcFone) {
        this.sdcFone = sdcFone;
    }

    public String getSnmCidade() {
        return snmCidade;
    }

    public void setSnmCidade(String snmCidade) {
        this.snmCidade = snmCidade;
    }

    public String getSnmCliente() {
        return snmCliente;
    }

    public void setSnmCliente(String snmCliente) {
        this.snmCliente = snmCliente;
    }

    public String getSnmPais() {
        return snmPais;
    }

    public void setSnmPais(String snmPais) {
        this.snmPais = snmPais;
    }

    public String getSnmUf() {
        return snmUf;
    }

    public void setSnmUf(String snmUf) {
        this.snmUf = snmUf;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

    @XmlTransient
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @XmlTransient
    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
