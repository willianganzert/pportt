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
    @AuxCadastroConsulta(listaCadastro=false)
    private long idManufaturado;
    
    @Basic(optional = false)
//    @Column(name = "sdcManofaturado")
    @Column()
    @AuxCadastroConsulta(requerido=true,length=150)
    private String sdcManofaturado;
    
//    @Column(name = "sdccompleta")
    @Column()
    @AuxCadastroConsulta(listaConsulta=false,requerido=true,length=600)
    private String sdcCompleta;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufaturado", fetch = FetchType.EAGER)
    private List<ItemPedido> itemPedidoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufaturado", fetch = FetchType.EAGER)
    private List<ProdMan> prodManList;

    public Manufaturado() {
    }

    public Manufaturado(long idManufaturado) {
        this.idManufaturado = idManufaturado;
    }

    public Manufaturado(long idManufaturado, String sdcManofaturado) {
        this.idManufaturado = idManufaturado;
        this.sdcManofaturado = sdcManofaturado;
    }

    public long getIdManufaturado() {
        return idManufaturado;
    }

    public void setIdManufaturado(long idManufaturado) {
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
    public String toString() {
        return "br.com.portaltrading.entidades.Manufaturado[ idManufaturado=" + idManufaturado + " ]";
    }
    
}
