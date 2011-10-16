/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portaltrading.entidades;

import br.com.portaltrading.annotations.AuxCadastroConsulta;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Willian
 */
@Entity
@Table(name = "cargo")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c")})
public class Cargo extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_CARGO_GENERATOR", sequenceName = "SEQ_CARGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_CARGO_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idcargo")
    @AuxCadastroConsulta(listaCadastro=false)
    private long idCargo;
    
    @Basic(optional = false)
//    @Column(name = "sdccargo")
    @Column()
    @AuxCadastroConsulta(requerido=true,length=150)
    private String sdcCargo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargo", fetch = FetchType.EAGER)
    private List<Permissao> permissoes;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargo", fetch = FetchType.EAGER)
    private List<Funcionario> funcionarios;

    public Cargo() {
    }

    public Cargo(long idCargo) {
        this.idCargo = idCargo;
    }

    public Cargo(long idCargo, String sdcCargo) {
        this.idCargo = idCargo;
        this.sdcCargo = sdcCargo;
    }

    public long getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(long idCargo) {
        this.idCargo = idCargo;
    }

    public String getSdcCargo() {
        return sdcCargo;
    }

    public void setSdcCargo(String sdcCargo) {
        this.sdcCargo = sdcCargo;
    }

    @XmlTransient
    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    @XmlTransient
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Cargo[ idCargo=" + idCargo + " ]";
    }
    
}
