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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "valorcaminhao")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Valorcaminhao.findAll", query = "SELECT v FROM Valorcaminhao v")})
public class ValorCaminhao extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="SEQ_VALORCAMINHAO_GENERATOR", sequenceName="SEQ_VALORCAMINHAO",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_VALORCAMINHAO_GENERATOR")
    @Basic(optional = false)
    @Column(unique=true, nullable=false, precision=22)
//    @Column(name = "idvalorcaminhao")
    @AuxCadastroConsulta(listaCadastro=false)
    private long idValorCaminhao;
    
    @Basic(optional = false)
//    @Column(name = "vlcaminhao")
    @Column()
    @AuxCadastroConsulta(listaConsulta=false,requerido=true)
    private double vlCaminhao;
    
//    @Column(name = "ddtinativo")
    @Column()
    @Temporal(TemporalType.DATE)
    private Date ddtInativo;
    
//    @JoinColumn(name = "idcaminhao", referencedColumnName = "idcaminhao")
    @JoinColumn(name = "idCaminhao")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Caminhao caminhao;

    public ValorCaminhao() {
    }

    public ValorCaminhao(long idValorCaminhao) {
        this.idValorCaminhao = idValorCaminhao;
    }

    public ValorCaminhao(long idValorCaminhao, double vlCaminhao) {
        this.idValorCaminhao = idValorCaminhao;
        this.vlCaminhao = vlCaminhao;
    }

    public long getIdValorCaminhao() {
        return idValorCaminhao;
    }

    public void setIdValorCaminhao(long idValorCaminhao) {
        this.idValorCaminhao = idValorCaminhao;
    }

    public double getVlCaminhao() {
        return vlCaminhao;
    }

    public void setVlCaminhao(double vlCaminhao) {
        this.vlCaminhao = vlCaminhao;
    }

    public Date getDdtInativo() {
        return ddtInativo;
    }

    public void setDdtInativo(Date ddtInativo) {
        this.ddtInativo = ddtInativo;
    }

    public Caminhao getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(Caminhao caminhao) {
        this.caminhao = caminhao;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Valorcaminhao[ idValorCaminhao=" + idValorCaminhao + " ]";
    }
    
}
