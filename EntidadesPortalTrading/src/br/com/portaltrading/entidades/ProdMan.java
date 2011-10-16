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
@Table(name = "prodman")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Prodman.findAll", query = "SELECT p FROM Prodman p")})
public class ProdMan extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_PRODMAN_GENERATOR", sequenceName = "SEQ_PRODMAN", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_PRODMAN_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idprodman")
    private long idProdMan;
    
//    @JoinColumn(name = "idproduto", referencedColumnName = "idproduto")
    @JoinColumn(name = "idProduto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Produto produto;
    
//    @JoinColumn(name = "idmanufaturado", referencedColumnName = "idmanufaturado")
    @JoinColumn(name = "idManufaturado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Manufaturado manufaturado;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodMan", fetch = FetchType.EAGER)
    private List<ProdutoValidado> produtosValidados;

    public ProdMan() {
    }

    public ProdMan(long idprodman) {
        this.idProdMan = idprodman;
    }

    public long getIdProdMan() {
        return idProdMan;
    }

    public void setIdProdMan(long idProdMan) {
        this.idProdMan = idProdMan;
    }

    public Produto getIdProduto() {
        return produto;
    }

    public void setIdProduto(Produto produto) {
        this.produto = produto;
    }

    public Manufaturado getManufaturado() {
        return manufaturado;
    }

    public void setManufaturado(Manufaturado manufaturado) {
        this.manufaturado = manufaturado;
    }

    @XmlTransient
    public List<ProdutoValidado> getProdutosValidados() {
        return produtosValidados;
    }

    public void setProdutosValidados(List<ProdutoValidado> produtosValidados) {
        this.produtosValidados = produtosValidados;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Prodman[ idProdMan=" + idProdMan + " ]";
    }
    
}