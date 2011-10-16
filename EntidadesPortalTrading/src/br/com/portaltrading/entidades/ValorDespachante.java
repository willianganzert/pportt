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
@Table(name = "valordespachante")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Valordespachante.findAll", query = "SELECT v FROM Valordespachante v")})
public class ValorDespachante extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="SEQ_VALORDESPACHANTE_GENERATOR", sequenceName="SEQ_VALORDESPACHANTE",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_VALORDESPACHANTE_GENERATOR")
    @Basic(optional = false)
    @Column(unique=true, nullable=false, precision=22)
//    @Column(name = "idvalordespachante")
    @AuxCadastroConsulta(listaConsulta=false)
    private long idValorDespachante;
    
    @Basic(optional = false)
//    @Column(name = "vldespachante")
    @Column()
    @AuxCadastroConsulta(requerido=true)
    private double vlDespachante;
    
//    @Column(name = "ddtinativo")
    @Column()
    @Temporal(TemporalType.DATE)
    private Date ddtInativo;
    
//    @JoinColumn(name = "iddespachante", referencedColumnName = "iddespachante")
    @JoinColumn(name = "idDespachante")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Despachante despachante;

    public ValorDespachante() {
    }

    public ValorDespachante(long idValorDespachante) {
        this.idValorDespachante = idValorDespachante;
    }

    public ValorDespachante(long idValorDespachante, double vlDespachante) {
        this.idValorDespachante = idValorDespachante;
        this.vlDespachante = vlDespachante;
    }

    public long getIdValorDespachante() {
        return idValorDespachante;
    }

    public void setIdValorDespachante(long idValorDespachante) {
        this.idValorDespachante = idValorDespachante;
    }

    public double getVlDespachante() {
        return vlDespachante;
    }

    public void setVlDespachante(double vlDespachante) {
        this.vlDespachante = vlDespachante;
    }

    public Date getDdtInativo() {
        return ddtInativo;
    }

    public void setDdtInativo(Date ddtInativo) {
        this.ddtInativo = ddtInativo;
    }

    public Despachante getDespachante() {
        return despachante;
    }

    public void setDespachante(Despachante despachante) {
        this.despachante = despachante;
    }
    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Valordespachante[ idValorDespachante=" + idValorDespachante + " ]";
    }
    
}
