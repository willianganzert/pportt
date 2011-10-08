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
@Table(name = "manufaturado")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Manufaturado.findAll", query = "SELECT m FROM Manufaturado m")})
public class Manufaturado extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_MANUFATURADO_GENERATOR", sequenceName = "SEQ_MANUFATURADO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_MANUFATURADO_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idManufaturado")
    private Long idManufaturado;
    
    @Basic(optional = false)
//    @Column(name = "sdcManofaturado")
    @Column()
    private String sdcManofaturado;
    
//    @Column(name = "sdccompleta")
    @Column()
    private String sdcCompleta;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufaturado", fetch = FetchType.EAGER)
    private List<ItemPedido> itemPedidoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufaturado", fetch = FetchType.EAGER)
    private List<ProdMan> prodManList;

    public Manufaturado() {
    }

    public Manufaturado(Long idManufaturado) {
        this.idManufaturado = idManufaturado;
    }

    public Manufaturado(Long idManufaturado, String sdcManofaturado) {
        this.idManufaturado = idManufaturado;
        this.sdcManofaturado = sdcManofaturado;
    }

    public Long getIdManufaturado() {
        return idManufaturado;
    }

    public void setIdManufaturado(Long idManufaturado) {
        this.idManufaturado = idManufaturado;
    }

    public String getSdcManofaturado() {
        return sdcManofaturado;
    }

    public void setSdcManofaturado(String sdcManofaturado) {
        this.sdcManofaturado = sdcManofaturado;
    }

    public String getSdcCompleta() {
        return sdcCompleta;
    }

    public void setSdcCompleta(String sdccompleta) {
        this.sdcCompleta = sdccompleta;
    }

    @XmlTransient
    public List<ItemPedido> getItemPedidoList() {
        return itemPedidoList;
    }

    public void setItemPedidoList(List<ItemPedido> itemPedidoList) {
        this.itemPedidoList = itemPedidoList;
    }

    @XmlTransient
    public List<ProdMan> getProdManList() {
        return prodManList;
    }

    public void setProdManList(List<ProdMan> prodManList) {
        this.prodManList = prodManList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idManufaturado != null ? idManufaturado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manufaturado)) {
            return false;
        }
        Manufaturado other = (Manufaturado) object;
        if ((this.idManufaturado == null && other.idManufaturado != null) || (this.idManufaturado != null && !this.idManufaturado.equals(other.idManufaturado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Manufaturado[ idManufaturado=" + idManufaturado + " ]";
    }
    
}
