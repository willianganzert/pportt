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
@Table(name = "documento")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d")})
public class Documento extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_DOCUMENTO_GENERATOR", sequenceName = "SEQ_DOCUMENTO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_DOCUMENTO_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idDocumento")
    private Long idDocumento;
    
    @Basic(optional = false)
//    @Column(name = "scdDocumento")
    @Column()
    private String scdDocumento;
    
//    @JoinColumn(name = "idTipoDocumento", referencedColumnName = "idTipoDocumento")
    @JoinColumn(name = "idTipoDocumento")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoDocumento tipoDocumento;
//    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @JoinColumn(name = "idCliente")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cliente cliente;

    public Documento() {
    }

    public Documento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Documento(Long idDocumento, String scdDocumento) {
        this.idDocumento    = idDocumento;
        this.scdDocumento   = scdDocumento;
    }

    public Long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getScdDocumento() {
        return scdDocumento;
    }

    public void setScdDocumento(String scdDocumento) {
        this.scdDocumento = scdDocumento;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento idTipoDocumento) {
        this.tipoDocumento = idTipoDocumento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumento != null ? idDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.idDocumento == null && other.idDocumento != null) || (this.idDocumento != null && !this.idDocumento.equals(other.idDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Documento[ idDocumento=" + idDocumento + " ]";
    }
    
}
