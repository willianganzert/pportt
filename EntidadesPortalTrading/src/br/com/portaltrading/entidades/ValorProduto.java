/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portaltrading.entidades;

import br.com.portaltrading.annotations.AuxCadastroConsulta;
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
    @AuxCadastroConsulta(listaConsulta=false)
    private long idValorProduto;
    @Basic(optional = false)
//    @Column(name = "vlProduto")
    @Column()
    @AuxCadastroConsulta(requerido=true)
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

    public ValorProduto(long idValorProduto) {
        this.idValorProduto = idValorProduto;
    }

    public ValorProduto(long idValorProduto, double vlProduto) {
        this.idValorProduto = idValorProduto;
        this.vlProduto = vlProduto;
    }

    public long getIdValorProduto() {
        return idValorProduto;
    }

    public void setIdValorProduto(long idValorProduto) {
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
    public String toString() {
        return "br.com.portaltrading.entidades.Valorproduto[ idValorProduto=" + idValorProduto + " ]";
    }
    
}
