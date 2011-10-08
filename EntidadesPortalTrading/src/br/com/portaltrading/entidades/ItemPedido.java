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
@Table(name = "itempedido")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Itempedido.findAll", query = "SELECT i FROM Itempedido i")})
public class ItemPedido extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_ITEMPEDIDO_GENERATOR", sequenceName = "SEQ_ITEMPEDIDO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_ITEMPEDIDO_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idItemPedido")
    private Long idItemPedido;
    
//    @Column(name = "qtItens")
    @Column()
    private Integer qtItens;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
//    @Column(name = "vlUnidadePagoCliente")
    @Column()
    private Double vlUnidadePagoCliente;
    
//    @JoinColumn(name = "idpedido", referencedColumnName = "idpedido")
    @JoinColumn(name = "idPedido")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pedido pedido;
    
//    @JoinColumn(name = "idmanufaturado", referencedColumnName = "idmanufaturado")
    @JoinColumn(name = "idManufaturado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Manufaturado manufaturado;

    public ItemPedido() {
    }

    public ItemPedido(Long idItemPedido) {
        this.idItemPedido = idItemPedido;
    }

    public Long getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(Long idItemPedido) {
        this.idItemPedido = idItemPedido;
    }

    public Integer getQtItens() {
        return qtItens;
    }

    public void setQtItens(Integer qtItens) {
        this.qtItens = qtItens;
    }

    public Double getVlUnidadePagoCliente() {
        return vlUnidadePagoCliente;
    }

    public void setVlUnidadePagoCliente(Double vlUnidadePagoCliente) {
        this.vlUnidadePagoCliente = vlUnidadePagoCliente;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Manufaturado getManufaturado() {
        return manufaturado;
    }

    public void setManufaturado(Manufaturado manufaturado) {
        this.manufaturado = manufaturado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItemPedido != null ? idItemPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemPedido)) {
            return false;
        }
        ItemPedido other = (ItemPedido) object;
        if ((this.idItemPedido == null && other.idItemPedido != null) || (this.idItemPedido != null && !this.idItemPedido.equals(other.idItemPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Itempedido[ idItemPedido=" + idItemPedido + " ]";
    }
    
}
