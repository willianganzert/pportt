/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portaltrading.entidades;

import br.com.portaltrading.annotations.AuxCadastroConsulta;
import br.com.portaltrading.annotations.TipoInputCombo;
import br.com.portaltrading.annotations.TipoInputLookup;
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
@Table(name = "containerpedido")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Containerpedido.findAll", query = "SELECT c FROM Containerpedido c")})
public class ContainerPedido extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_CONTAINERPEDIDO_GENERATOR", sequenceName = "SEQ_CONTAINERPEDIDO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_CONTAINERPEDIDO_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idContainerPedido")
    @AuxCadastroConsulta(listaCadastro=false)
    private long idContainerPedido;
    
    @Basic(optional = false)
//    @Column(name = "stEmbarque")
    @Column()
    @TipoInputCombo(valuesTpCombo="1,2,3,4")
    @AuxCadastroConsulta(listaConsulta=false, tipoCampo= AuxCadastroConsulta.TIPO_CAMPO.COMBO)
    private int stEmbarque;
    
//    @JoinColumn(name = "idpedido", referencedColumnName = "idpedido")
    @JoinColumn(name = "idPedido")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @TipoInputLookup(campoDisplay="sdcPedido")
    private Pedido pedido;
    
//    @JoinColumn(name = "idcontainer", referencedColumnName = "idcontainer")
    @JoinColumn(name = "idContainer")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @TipoInputLookup(campoDisplay="ntonelagem")
    @AuxCadastroConsulta(pai=true,requerido=true)
    private Container container;

    public ContainerPedido() {
    }

    public ContainerPedido(long idContainerPedido) {
        this.idContainerPedido = idContainerPedido;
    }

    public ContainerPedido(long idContainerPedido, int stEmbarque) {
        this.idContainerPedido = idContainerPedido;
        this.stEmbarque = stEmbarque;
    }

    public long getIdContainerPedido() {
        return idContainerPedido;
    }

    public void setIdContainerPedido(long idContainerPedido) {
        this.idContainerPedido = idContainerPedido;
    }

    public int getStEmbarque() {
        return stEmbarque;
    }

    public void setStEmbarque(int stEmbarque) {
        this.stEmbarque = stEmbarque;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Containerpedido[ idContainerPedido=" + idContainerPedido + " ]";
    }
    
}
