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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "despachante")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Despachante.findAll", query = "SELECT d FROM Despachante d")})
public class Despachante extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_DESPACHANTE_GENERATOR", sequenceName = "SEQ_DESPACHANTE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_DESPACHANTE_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idDespachante")
    private Long idDespachante;
    
    @Basic(optional = false)
//    @Column(name = "snmRepDespachante")
    @Column()
    private String snmRepDespachante;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "despachante", fetch = FetchType.EAGER)
    private List<Pedido> pedidos;
    
//    @JoinColumn(name = "idempresa", referencedColumnName = "idempresa")
    @JoinColumn(name = "idEmpresa")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empresa empresa;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "despachante", fetch = FetchType.EAGER)
    private List<ValorDespachante> valoresDespachante;

    public Despachante() {
    }

    public Despachante(Long idDespachante) {
        this.idDespachante = idDespachante;
    }

    public Despachante(Long idDespachante, String snmRepDespachante) {
        this.idDespachante = idDespachante;
        this.snmRepDespachante = snmRepDespachante;
    }

    public Long getIdDespachante() {
        return idDespachante;
    }

    public void setIdDespachante(Long idDespachante) {
        this.idDespachante = idDespachante;
    }

    public String getSnmRepDespachante() {
        return snmRepDespachante;
    }

    public void setSnmRepDespachante(String snmRepDespachante) {
        this.snmRepDespachante = snmRepDespachante;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    
   

    @XmlTransient
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @XmlTransient
    public List<ValorDespachante> getValoresDespachante() {
        return valoresDespachante;
    }

    public void setValoresDespachante(List<ValorDespachante> valorDespachante) {
        this.valoresDespachante = valorDespachante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDespachante != null ? idDespachante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Despachante)) {
            return false;
        }
        Despachante other = (Despachante) object;
        if ((this.idDespachante == null && other.idDespachante != null) || (this.idDespachante != null && !this.idDespachante.equals(other.idDespachante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Despachante[ idDespachante=" + idDespachante + " ]";
    }
    
}
