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
@Table(name = "container")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Container.findAll", query = "SELECT c FROM Container c")})
public class Container extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_CONTAINER_GENERATOR", sequenceName = "SEQ_CONTAINER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_CONTAINER_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idContainer")
    private Long idContainer;
    
    @Basic(optional = false)
//    @Column(name = "ntonelagem")
    @Column()
    private double ntonelagem;
    
    @Basic(optional = false)
//    @Column(name = "ncomprimento")
    @Column()
    private double ncomprimento;
    
    @Basic(optional = false)
//    @Column(name = "nlargura")
    @Column()
    private double nlargura;
    
    @Basic(optional = false)
//    @Column(name = "naltura")
    @Column()
    private double naltura;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "container", fetch = FetchType.EAGER)
    private List<ContainerPedido> containerPedidoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "container", fetch = FetchType.EAGER)
    private List<ValorContainer> valoresContainer;
    
//    @JoinColumn(name = "idrepMaritimo", referencedColumnName = "idrepMaritimo")
    @JoinColumn(name = "idRepMaritimo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RepMaritimo repMaritimo;

    public Container() {
    }

    public Container(Long idContainer) {
        this.idContainer = idContainer;
    }

    public Container(Long idContainer, double ntonelagem, double ncomprimento, double nlargura, double naltura) {
        this.idContainer = idContainer;
        this.ntonelagem = ntonelagem;
        this.ncomprimento = ncomprimento;
        this.nlargura = nlargura;
        this.naltura = naltura;
    }

    public Long getIdContainer() {
        return idContainer;
    }

    public void setIdContainer(Long idContainer) {
        this.idContainer = idContainer;
    }

    public double getNtonelagem() {
        return ntonelagem;
    }

    public void setNtonelagem(double ntonelagem) {
        this.ntonelagem = ntonelagem;
    }

    public double getNcomprimento() {
        return ncomprimento;
    }

    public void setNcomprimento(double ncomprimento) {
        this.ncomprimento = ncomprimento;
    }

    public double getNlargura() {
        return nlargura;
    }

    public void setNlargura(double nlargura) {
        this.nlargura = nlargura;
    }

    public double getNaltura() {
        return naltura;
    }

    public void setNaltura(double naltura) {
        this.naltura = naltura;
    }

    @XmlTransient
    public List<ContainerPedido> getContainerPedidoList() {
        return containerPedidoList;
    }

    public void setContainerPedidoList(List<ContainerPedido> containerpedidoList) {
        this.containerPedidoList = containerpedidoList;
    }

    @XmlTransient
    public List<ValorContainer> getValoresContainer() {
        return valoresContainer;
    }

    public void setValoresContainer(List<ValorContainer> valoresContainer) {
        this.valoresContainer = valoresContainer;
    }

    public RepMaritimo getRepMaritimo() {
        return repMaritimo;
    }

    public void setRepMaritimo(RepMaritimo repMaritimo) {
        this.repMaritimo = repMaritimo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContainer != null ? idContainer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Container)) {
            return false;
        }
        Container other = (Container) object;
        if ((this.idContainer == null && other.idContainer != null) || (this.idContainer != null && !this.idContainer.equals(other.idContainer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Container[ idContainer=" + idContainer + " ]";
    }
    
}
