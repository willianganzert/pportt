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
    @AuxCadastroConsulta(listaCadastro=false)
    private long idContainer;
    
    @Basic(optional = false)
//    @Column(name = "ntonelagem")
    @Column()
    @AuxCadastroConsulta(requerido=true,tipoDado= AuxCadastroConsulta.TIPO_DADO.POSITIVO)
    private double ntonelagem;
    
    @Basic(optional = false)
//    @Column(name = "ncomprimento")
    @Column()
    @AuxCadastroConsulta(requerido=true,tipoDado= AuxCadastroConsulta.TIPO_DADO.POSITIVO)
    private double ncomprimento;
    
    @Basic(optional = false)
//    @Column(name = "nlargura")
    @Column()
    @AuxCadastroConsulta(requerido=true,tipoDado= AuxCadastroConsulta.TIPO_DADO.POSITIVO)
    private double nlargura;
    
    @Basic(optional = false)
//    @Column(name = "naltura")
    @Column()
    @AuxCadastroConsulta(requerido=true,tipoDado= AuxCadastroConsulta.TIPO_DADO.POSITIVO)
    private double naltura;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "container", fetch = FetchType.EAGER)
    private List<ContainerPedido> containerPedidoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "container", fetch = FetchType.EAGER)
    private List<ValorContainer> valoresContainer;
    
//    @JoinColumn(name = "idrepMaritimo", referencedColumnName = "idrepMaritimo")
    @JoinColumn(name = "idRepMaritimo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @AuxCadastroConsulta(listaConsulta=false,requerido=true,pai=true)
    private RepMaritimo repMaritimo;

    public Container() {
    }

    public Container(long idContainer) {
        this.idContainer = idContainer;
    }

    public Container(long idContainer, double ntonelagem, double ncomprimento, double nlargura, double naltura) {
        this.idContainer = idContainer;
        this.ntonelagem = ntonelagem;
        this.ncomprimento = ncomprimento;
        this.nlargura = nlargura;
        this.naltura = naltura;
    }

    public long getIdContainer() {
        return idContainer;
    }

    public void setIdContainer(long idContainer) {
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
    public String toString() {
        return "br.com.portaltrading.entidades.Container[ idContainer=" + idContainer + " ]";
    }
    
}
