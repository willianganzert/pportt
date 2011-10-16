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
@Table(name = "despachante")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Despachante.findAll", query = "SELECT d FROM Despachante d")})
public class Despachante extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_DESPACHANTE_GENERATOR", sequenceName = "SEQ_DESPACHANTE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_DESPACHANTE_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idDespachante")
    @AuxCadastroConsulta(listaCadastro=false)
    private long idDespachante;
    
    @Basic(optional = false)
//    @Column(name = "snmRepDespachante")
    @Column()
    @AuxCadastroConsulta(length=50)
    private String snmRepDespachante;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "despachante", fetch = FetchType.EAGER)
    private List<Pedido> pedidos;
    
//    @JoinColumn(name = "idempresa", referencedColumnName = "idempresa")
    @JoinColumn(name = "idEmpresa")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empresa empresa;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "despachante", fetch = FetchType.EAGER)
    private List<ValorDespachante> valoresDespachante;

    public Despachante() {
    }

    public Despachante(long idDespachante) {
        this.idDespachante = idDespachante;
    }

    public Despachante(long idDespachante, String snmRepDespachante) {
        this.idDespachante = idDespachante;
        this.snmRepDespachante = snmRepDespachante;
    }

    public long getIdDespachante() {
        return idDespachante;
    }

    public void setIdDespachante(long idDespachante) {
        this.idDespachante = idDespachante;
    }

    public String getSnmRepDespachante() {
        return snmRepDespachante;
    }

    public void setSnmRepDespachante(String snmRepDespachante) {
        this.snmRepDespachante = snmRepDespachante;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    
   

    @XmlTransient
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @XmlTransient
    public List<ValorDespachante> getValoresDespachante() {
        return valoresDespachante;
    }

    public void setValoresDespachante(List<ValorDespachante> valorDespachante) {
        this.valoresDespachante = valorDespachante;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Despachante[ idDespachante=" + idDespachante + " ]";
    }
    
}
