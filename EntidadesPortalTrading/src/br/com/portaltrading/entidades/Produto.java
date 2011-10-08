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
@Table(name = "produto")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")})
public class Produto extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_PRODUTO_GENERATOR", sequenceName = "SEQ_PRODUTO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_PRODUTO_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idProduto")
    private Long idProduto;
    
    @Basic(optional = false)
//    @Column(name = "snmProduto")
    @Column()
    private String snmProduto;
    
//    @Column(name = "sdcmarca")
    @Column()
    private String sdcMarca;
    
    @Basic(optional = false)
//    @Column(name = "nidAtivo")
    @Column()
    private int nidAtivo;
    
//    @JoinColumn(name = "idfornecedor", referencedColumnName = "idfornecedor")
    @JoinColumn(name = "idfornecedor")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Fornecedor fornecedor;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto", fetch = FetchType.EAGER)
    private List<ProdMan> prodManList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto", fetch = FetchType.EAGER)
    private List<ValorProduto> valorProdutoList;

    public Produto() {
    }

    public Produto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Produto(Long idProduto, String snmProduto, int nidAtivo) {
        this.idProduto = idProduto;
        this.snmProduto = snmProduto;
        this.nidAtivo = nidAtivo;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getSnmProduto() {
        return snmProduto;
    }

    public void setSnmProduto(String snmProduto) {
        this.snmProduto = snmProduto;
    }

    public String getSdcMarca() {
        return sdcMarca;
    }

    public void setSdcMarca(String sdcMarca) {
        this.sdcMarca = sdcMarca;
    }

    public int getNidAtivo() {
        return nidAtivo;
    }

    public void setNidAtivo(int nidAtivo) {
        this.nidAtivo = nidAtivo;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @XmlTransient
    public List<ProdMan> getProdManList() {
        return prodManList;
    }

    public void setProdManList(List<ProdMan> prodmanList) {
        this.prodManList = prodmanList;
    }

    @XmlTransient
    public List<ValorProduto> getValorProdutoList() {
        return valorProdutoList;
    }

    public void setValorProdutoList(List<ValorProduto> valorProdutoList) {
        this.valorProdutoList = valorProdutoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Produto[ idProduto=" + idProduto + " ]";
    }
    
}
