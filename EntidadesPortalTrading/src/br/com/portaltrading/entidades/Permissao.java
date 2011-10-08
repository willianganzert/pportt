/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portaltrading.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Willian
 */
@Entity
@Table(name = "permissao")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Permissao.findAll", query = "SELECT p FROM Permissao p")})
public class Permissao extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_PERMISSAO_GENERATOR", sequenceName = "SEQ_PERMISSAO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_PERMISSAO_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idpermissao")
    private Long idPermissao;
    
//    @Column(name = "sdcpermissao")
    @Column()
    private String sdcPermissao;
    
    @Basic(optional = false)
//    @Column(name = "ssgpermissao")
    @Column()
    private String ssgPermissao;
    
//    @JoinColumn(name = "idcargo", referencedColumnName = "idcargo")
    @JoinColumn(name = "idCargo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cargo cargo;

    public Permissao() {
    }

    public Permissao(Long idpermissao) {
        this.idPermissao = idpermissao;
    }

    public Permissao(Long idPermissao, String ssgPermissao) {
        this.idPermissao = idPermissao;
        this.ssgPermissao = ssgPermissao;
    }

    public Long getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(Long idPermissao) {
        this.idPermissao = idPermissao;
    }

    public String getSdcPermissao() {
        return sdcPermissao;
    }

    public void setSdcPermissao(String sdcPermissao) {
        this.sdcPermissao = sdcPermissao;
    }

    public String getSsgPermissao() {
        return ssgPermissao;
    }

    public void setSsgPermissao(String ssgPermissao) {
        this.ssgPermissao = ssgPermissao;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermissao != null ? idPermissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permissao)) {
            return false;
        }
        Permissao other = (Permissao) object;
        if ((this.idPermissao == null && other.idPermissao != null) || (this.idPermissao != null && !this.idPermissao.equals(other.idPermissao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Permissao[ idPermissao=" + idPermissao + " ]";
    }
    
}
