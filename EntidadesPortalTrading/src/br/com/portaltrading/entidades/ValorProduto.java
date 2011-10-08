/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portaltrading.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Willian
 */
@Entity
@Table(name = "valorproduto")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Valorproduto.findAll", query = "SELECT v FROM Valorproduto v")})
public class ValorProduto extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="SEQ_VALORPRODUTO_GENERATOR", sequenceName="SEQ_VALORPRODUTO",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_VALORPRODUTO_GENERATOR")
    @Basic(optional = false)
    @Column(unique=true, nullable=false, precision=22)
//    @Column(name = "idValorProduto")
    private Long idValorProduto;
    @Basic(optional = false)
//    @Column(name = "vlProduto")
    @Column()
    private double vlProduto;
    
//    @Column(name = "ddtinativo")
    @Column()
    @Temporal(TemporalType.DATE)
    private Date ddtInativo;
    
//    @JoinColumn(name = "idproduto", referencedColumnName = "idproduto")
    @JoinColumn(name = "idProduto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Produto produto;

    public ValorProduto() {
    }

    public ValorProduto(Long idValorProduto) {
        this.idValorProduto = idValorProduto;
    }

    public ValorProduto(Long idValorProduto, double vlProduto) {
        this.idValorProduto = idValorProduto;
        this.vlProduto = vlProduto;
    }

    public Long getIdValorProduto() {
        return idValorProduto;
    }

    public void setIdValorProduto(Long idValorProduto) {
        this.idValorProduto = idValorProduto;
    }

    public double getVlProduto() {
        return vlProduto;
    }

    public void setVlProduto(double vlProduto) {
        this.vlProduto = vlProduto;
    }

    public Date getDdtInativo() {
        return ddtInativo;
    }

    public void setDdtInativo(Date ddtinativo) {
        this.ddtInativo = ddtinativo;
    }

    public Produto getIdProduto() {
        return produto;
    }

    public void setIdProduto(Produto idproduto) {
        this.produto = idproduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idValorProduto != null ? idValorProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValorProduto)) {
            return false;
        }
        ValorProduto other = (ValorProduto) object;
        if ((this.idValorProduto == null && other.idValorProduto != null) || (this.idValorProduto != null && !this.idValorProduto.equals(other.idValorProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Valorproduto[ idValorProduto=" + idValorProduto + " ]";
    }
    
}
