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
@Table(name = "repmaritimo")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Repmaritimo.findAll", query = "SELECT r FROM Repmaritimo r")})
public class RepMaritimo extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_REPMARITIMO_GENERATOR", sequenceName = "SEQ_REPMARITIMO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_REPMARITIMO_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idRepMaritimo")
    private Long idRepMaritimo;
    
//    @JoinColumn(name = "idempresa", referencedColumnName = "idempresa")
    @JoinColumn(name = "idEmpresa")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empresa empresa;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "repMaritimo", fetch = FetchType.EAGER)
    private List<Container> containeres;

    public RepMaritimo() {
    }

    public RepMaritimo(Long idRepMaritimo) {
        this.idRepMaritimo = idRepMaritimo;
    }

    public Long getIdRepMaritimo() {
        return idRepMaritimo;
    }

    public void setIdRepMaritimo(Long idRepMaritimo) {
        this.idRepMaritimo = idRepMaritimo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @XmlTransient
    public List<Container> getContaineres() {
        return containeres;
    }

    public void setContaineres(List<Container> containeres) {
        this.containeres = containeres;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRepMaritimo != null ? idRepMaritimo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepMaritimo)) {
            return false;
        }
        RepMaritimo other = (RepMaritimo) object;
        if ((this.idRepMaritimo == null && other.idRepMaritimo != null) || (this.idRepMaritimo != null && !this.idRepMaritimo.equals(other.idRepMaritimo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Repmaritimo[ idRepMaritimo=" + idRepMaritimo + " ]";
    }
    
}
