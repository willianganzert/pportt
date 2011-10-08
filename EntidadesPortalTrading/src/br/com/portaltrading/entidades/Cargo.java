/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portaltrading.entidades;

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
    private Long idCargo;
    
    @Basic(optional = false)
//    @Column(name = "sdccargo")
    @Column()
    private String sdcCargo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargo", fetch = FetchType.EAGER)
    private List<Permissao> permissoes;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargo", fetch = FetchType.EAGER)
    private List<Funcionario> funcionarios;

    public Cargo() {
    }

    public Cargo(Long idCargo) {
        this.idCargo = idCargo;
    }

    public Cargo(Long idCargo, String sdcCargo) {
        this.idCargo = idCargo;
        this.sdcCargo = sdcCargo;
    }

    public Long getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Long idCargo) {
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
    public int hashCode() {
        int hash = 0;
        hash += (idCargo != null ? idCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.idCargo == null && other.idCargo != null) || (this.idCargo != null && !this.idCargo.equals(other.idCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Cargo[ idCargo=" + idCargo + " ]";
    }
    
}
