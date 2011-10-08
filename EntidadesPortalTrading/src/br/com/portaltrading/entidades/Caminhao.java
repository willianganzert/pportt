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
@Table(name = "caminhao")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Caminhao.findAll", query = "SELECT c FROM Caminhao c")})
public class Caminhao extends ComunEntidades implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="SEQ_CAMINHAO_GENERATOR", sequenceName="SEQ_CAMINHAO",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CAMINHAO_GENERATOR")
    @Basic(optional = false)
    @Column(unique=true, nullable=false, precision=22)
//    @Column(name = "idCaminhao")
    @AuxCadastroConsulta(listaCadastro=false)
    private long idCaminhao;
    
    @Basic(optional = false)
//    @Column(name = "sdcModelo")
    @Column()
    @AuxCadastroConsulta(requerido=true, length=20)
    private String sdcModelo;
    
    @Basic(optional = false)
//    @Column(name = "ndtAno")
    @Column()
    @AuxCadastroConsulta(listaConsulta=false, tipoDado=AuxCadastroConsulta.TIPO_DADO.POSITIVO)
    private int ndtAno;
    
    @Basic(optional = false)
//    @Column(name = "scdPlaca")
    @Column()
    @AuxCadastroConsulta(length=10)
    private String scdPlaca;
    
//    @Column(name = "snmmotorista")
    @Column()
    @AuxCadastroConsulta(length=50)
    private String snmMotorista;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caminhao", fetch = FetchType.LAZY)
    private List<CaminhaoPedido> caminhaoPedidoList;
    
//    @JoinColumn(name = "idreprodoviario", referencedColumnName = "idreprodoviario")
    @JoinColumn(name = "idRepRodoviario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RepRodoviario repRodoviario;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caminhao", fetch = FetchType.EAGER)
    private List<ValorCaminhao> valoresCaminhao;

    public Caminhao() {
    }

    public Caminhao(long idCaminhao) {
        this.idCaminhao = idCaminhao;
    }

    public Caminhao(long idCaminhao, String sdcModelo, int ndtAno, String scdPlaca) {
        this.idCaminhao = idCaminhao;
        this.sdcModelo = sdcModelo;
        this.ndtAno = ndtAno;
        this.scdPlaca = scdPlaca;
    }

    public long getIdCaminhao() {
        return idCaminhao;
    }

    public void setIdCaminhao(long idCaminhao) {
        this.idCaminhao = idCaminhao;
    }

    public String getSdcModelo() {
        return sdcModelo;
    }

    public void setSdcModelo(String sdcModelo) {
        this.sdcModelo = sdcModelo;
    }

    public int getNdtAno() {
        return ndtAno;
    }

    public void setNdtAno(int ndtAno) {
        this.ndtAno = ndtAno;
    }

    public String getScdPlaca() {
        return scdPlaca;
    }

    public void setScdPlaca(String scdPlaca) {
        this.scdPlaca = scdPlaca;
    }

    public String getSnmMotorista() {
        return snmMotorista;
    }

    public void setSnmMotorista(String snmMotorista) {
        this.snmMotorista = snmMotorista;
    }

    @XmlTransient
    public List<CaminhaoPedido> getCaminhaoPedidoList() {
        return caminhaoPedidoList;
    }

    public void setCaminhaoPedidoList(List<CaminhaoPedido> caminhaoPedidoList) {
        this.caminhaoPedidoList = caminhaoPedidoList;
    }

    public RepRodoviario getRepRodoviario() {
        return repRodoviario;
    }

    public void setRepRodoviario(RepRodoviario repRodoviario) {
        this.repRodoviario = repRodoviario;
    }

    @XmlTransient
    public List<ValorCaminhao> getValoresCaminhao() {
        return valoresCaminhao;
    }

    public void setValoresCaminhao(List<ValorCaminhao> valoresCaminhao) {
        this.valoresCaminhao = valoresCaminhao;
    }
    
}
