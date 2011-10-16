/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portaltrading.entidades;

import br.com.portaltrading.annotations.AuxCadastroConsulta;
import br.com.portaltrading.annotations.TipoInputCombo;
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
@Table(name = "funcionario")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")})
public class Funcionario extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_FUNCIONARIO_GENERATOR", sequenceName = "SEQ_FUNCIONARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_FUNCIONARIO_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idFuncionario")
    @AuxCadastroConsulta(listaCadastro=false)
    private long idFuncionario;
    
    @Basic(optional = false)
//    @Column(name = "snmFuncionario")
    @Column()
    @AuxCadastroConsulta(requerido=true,length=250)
    private String snmFuncionario;
    
    @Basic(optional = false)
//    @Column(name = "scdRg")
    @Column()
    @AuxCadastroConsulta(listaConsulta=false,requerido=true,length=20)
    private String scdRg;
    
    @Basic(optional = false)
//    @Column(name = "scdCpf")
    @Column()
    @AuxCadastroConsulta(listaConsulta=false,requerido=true,length=20)
    private String scdCpf;
    
//    @Column(name = "scdclt")
    @Column()
    @AuxCadastroConsulta(listaConsulta=false,requerido=true,length=20)
    private String scdClt;
    
    @Basic(optional = false)
//    @Column(name = "ddtCadastro")
    @Column()
    @Temporal(TemporalType.DATE)
    private Date ddtCadastro;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario", fetch = FetchType.LAZY)
    private List<Pedido> pedidos;
    
//    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @JoinColumn(name = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;
    
//    @JoinColumn(name = "idcargo", referencedColumnName = "idcargo")
    @JoinColumn(name = "idCargo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @TipoInputCombo(campoDisplay="sdcCargo")
    @AuxCadastroConsulta(listaConsulta=false, tipoCampo= AuxCadastroConsulta.TIPO_CAMPO.COMBO,pai=true,requerido=true)
    private Cargo cargo;

    public Funcionario() {
    }

    public Funcionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Funcionario(long idFuncionario, String snmFuncionario, String scdRg, String scdCpf, Date ddtCadastro) {
        this.idFuncionario = idFuncionario;
        this.snmFuncionario = snmFuncionario;
        this.scdRg = scdRg;
        this.scdCpf = scdCpf;
        this.ddtCadastro = ddtCadastro;
    }

    public long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getSnmFuncionario() {
        return snmFuncionario;
    }

    public void setSnmFuncionario(String snmFuncionario) {
        this.snmFuncionario = snmFuncionario;
    }

    public String getScdRg() {
        return scdRg;
    }

    public void setScdRg(String scdRg) {
        this.scdRg = scdRg;
    }

    public String getScdCpf() {
        return scdCpf;
    }

    public void setScdCpf(String scdCpf) {
        this.scdCpf = scdCpf;
    }

    public String getScdClt() {
        return scdClt;
    }

    public void setScdClt(String scdclt) {
        this.scdClt = scdclt;
    }

    public Date getDdtCadastro() {
        return ddtCadastro;
    }

    public void setDdtCadastro(Date ddtCadastro) {
        this.ddtCadastro = ddtCadastro;
    }

    @XmlTransient
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Funcionario[ idFuncionario=" + idFuncionario + " ]";
    }
    
}
