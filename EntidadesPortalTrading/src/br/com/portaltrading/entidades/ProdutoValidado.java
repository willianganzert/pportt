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
@Table(name = "produtovalidado")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Produtovalidado.findAll", query = "SELECT p FROM Produtovalidado p")})
public class ProdutoValidado extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_PRODUTOVALIDADO_GENERATOR", sequenceName = "SEQ_PRODUTOVALIDADO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_PRODUTOVALIDADO_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idProdutoValidado")
    private Long idProdutoValidado;
    
    @Basic(optional = false)
//    @Column(name = "stProduto")
    @Column()
    private int stProduto;
//    @Column(name = "spaproduto")
    @Column()
    private String spaProduto;
    
//    @JoinColumn(name = "idprodman", referencedColumnName = "idprodman")
    @JoinColumn(name = "idProdman")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ProdMan prodMan;
    
//    @JoinColumn(name = "idpedido", referencedColumnName = "idpedido")
    @JoinColumn(name = "idPedido")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pedido pedido;

    public ProdutoValidado() {
    }

    public ProdutoValidado(Long idProdutoValidado) {
        this.idProdutoValidado = idProdutoValidado;
    }

    public ProdutoValidado(Long idProdutoValidado, int stProduto) {
        this.idProdutoValidado = idProdutoValidado;
        this.stProduto = stProduto;
    }

    public Long getIdProdutoValidado() {
        return idProdutoValidado;
    }

    public void setIdProdutoValidado(Long idProdutoValidado) {
        this.idProdutoValidado = idProdutoValidado;
    }

    public int getStProduto() {
        return stProduto;
    }

    public void setStProduto(int stProduto) {
        this.stProduto = stProduto;
    }

    public String getSpaProduto() {
        return spaProduto;
    }

    public void setSpaProduto(String spaProduto) {
        this.spaProduto = spaProduto;
    }

    public ProdMan getProdMan() {
        return prodMan;
    }

    public void setProdMan(ProdMan prodMan) {
        this.prodMan = prodMan;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProdutoValidado != null ? idProdutoValidado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoValidado)) {
            return false;
        }
        ProdutoValidado other = (ProdutoValidado) object;
        if ((this.idProdutoValidado == null && other.idProdutoValidado != null) || (this.idProdutoValidado != null && !this.idProdutoValidado.equals(other.idProdutoValidado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Produtovalidado[ idProdutoValidado=" + idProdutoValidado + " ]";
    }
    
}
