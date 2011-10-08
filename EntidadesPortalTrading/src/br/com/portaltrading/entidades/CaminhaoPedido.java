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
@Table(name = "caminhaopedido")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "CaminhaoPedido.findAll", query = "SELECT c FROM CaminhaoPedido c")})
public class CaminhaoPedido extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="SEQ_CAMINHAOPEDIDO_GENERATOR", sequenceName="SEQ_CAMINHAOPEDIDO",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CAMINHAOPEDIDO_GENERATOR")
    @Basic(optional = false)
    @Column(unique=true, nullable=false, precision=22)
//    @Column(name = "idcaminhaopedido")
    @AuxCadastroConsulta(listaCadastro=false)
    private long idCaminhaoPedido;
    
    @Basic(optional = false)
//    @Column(name = "stcaminhaopedido")
    @Column()
    @AuxCadastroConsulta(listaCadastro=false)
    @TipoInputCombo(valuesTpCombo="0,1,2,3")
    private int stCaminhaoPedido;
    
    @JoinColumn(name = "idPedido")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @AuxCadastroConsulta()
    @TipoInputLookup(campoDisplay="sdcPedido")
    private Pedido pedido;
    
    @JoinColumn(name = "idCaminhao")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @TipoInputLookup(campoIdentificador="scdPlaca",campoDisplay="sdcPedido")
    @AuxCadastroConsulta()
    private Caminhao caminhao;

    public CaminhaoPedido() {
    }

    public CaminhaoPedido(long idcaminhaopedido) {
        this.idCaminhaoPedido = idcaminhaopedido;
    }

    public CaminhaoPedido(long idcaminhaopedido, int stCaminhaoPedido) {
        this.idCaminhaoPedido = idcaminhaopedido;
        this.stCaminhaoPedido = stCaminhaoPedido;
    }

    public long getIdCaminhaoPedido() {
        return idCaminhaoPedido;
    }

    public void setIdCaminhaoPedido(long idcaminhaopedido) {
        this.idCaminhaoPedido = idcaminhaopedido;
    }

    public int getStCaminhaoPedido() {
        return stCaminhaoPedido;
    }

    public void setStCaminhaoPedido(int stCaminhaoPedido) {
        this.stCaminhaoPedido = stCaminhaoPedido;
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Caminhao getCaminhao() {
        return this.caminhao;
    }

    public void setCaminhao(Caminhao caminhao) {
        this.caminhao = caminhao;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Caminhaopedido[ idCaminhaoPedido=" + idCaminhaoPedido + " ]";
    }
    
}
