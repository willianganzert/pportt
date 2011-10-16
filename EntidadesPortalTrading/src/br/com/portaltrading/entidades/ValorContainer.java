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
@Table(name = "valorcontainer")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Valorcontainer.findAll", query = "SELECT v FROM Valorcontainer v")})
public class ValorContainer extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="SEQ_VALORCONTAINER_GENERATOR", sequenceName="SEQ_VALORCONTAINER",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_VALORCONTAINER_GENERATOR")
    @Basic(optional = false)
    @Column(unique=true, nullable=false, precision=22)
//    @Column(name = "idValorContainer")
    @AuxCadastroConsulta(listaCadastro=false)
    private long idValorContainer;
    
    @Basic(optional = false)
//    @Column(name = "vlcontainer")
    @Column()
    @AuxCadastroConsulta(requerido=true)
    private double vlContainer;
    
//    @Column(name = "ddtinativo")
    @Column()
    @Temporal(TemporalType.DATE)
    private Date ddtInativo;
    
//    @JoinColumn(name = "idcontainer", referencedColumnName = "idcontainer")
    @JoinColumn(name = "idContainer")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Container container;

    public ValorContainer() {
    }

    public ValorContainer(long idValorContainer) {
        this.idValorContainer = idValorContainer;
    }

    public ValorContainer(long idValorContainer, double vlContainer) {
        this.idValorContainer = idValorContainer;
        this.vlContainer = vlContainer;
    }

    public long getIdValorContainer() {
        return idValorContainer;
    }

    public void setIdValorContainer(long idValorContainer) {
        this.idValorContainer = idValorContainer;
    }

    public double getVlContainer() {
        return vlContainer;
    }

    public void setVlContainer(double vlContainer) {
        this.vlContainer = vlContainer;
    }

    public Date getDdtInativo() {
        return ddtInativo;
    }

    public void setDdtInativo(Date ddtInativo) {
        this.ddtInativo = ddtInativo;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Valorcontainer[ idValorContainer=" + idValorContainer + " ]";
    }
    
}
