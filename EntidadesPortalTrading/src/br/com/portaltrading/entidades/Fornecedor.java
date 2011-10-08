/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portaltrading.entidades;

import br.com.portaltrading.annotations.AuxCadastroConsulta;
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
@Table(name = "fornecedor")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f")})
public class Fornecedor extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_FORNECEDOR_GENERATOR", sequenceName = "SEQ_FORNECEDOR", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_FORNECEDOR_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idfornecedor")
    @AuxCadastroConsulta(listaCadastro=false)
    private long idFornecedor;
    
    @Basic(optional = false)
//    @Column(name = "nidativo")
    @Column()
    private int nidAtivo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedor", fetch = FetchType.EAGER)
    private List<Produto> produtos;
    
//    @JoinColumn(name = "idempresa", referencedColumnName = "idempresa")
    @JoinColumn(name = "idEmpresa")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empresa empresa;

    public Fornecedor() {
    }

    public Fornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public int getNidAtivo() {
        return nidAtivo;
    }

    public void setNidAtivo(int nidAtivo) {
        this.nidAtivo = nidAtivo;
    }
    
    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtos;
    }

    public void setProdutoList(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Fornecedor[ idFornecedor=" + idFornecedor + " ]";
    }
    
}
