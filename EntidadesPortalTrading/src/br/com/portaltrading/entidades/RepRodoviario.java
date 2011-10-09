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
@Table(name = "reprodoviario")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Reprodoviario.findAll", query = "SELECT r FROM Reprodoviario r")})
public class RepRodoviario extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_REPRODOVIARIO_GENERATOR", sequenceName = "SEQ_REPRODOVIARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_REPRODOVIARIO_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idreprodoviario")
    private long idRepRodoviario;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "repRodoviario", fetch = FetchType.EAGER)
    private List<Caminhao> caminhoes;
    
//    @JoinColumn(name = "idempresa", referencedColumnName = "idempresa")
    @JoinColumn(name = "idEmpresa")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empresa empresa;

    public RepRodoviario() {
    }

    public RepRodoviario(Long idRepRodoviario) {
        this.idRepRodoviario = idRepRodoviario;
    }

    public long getIdRepRodoviario() {
        return idRepRodoviario;
    }

    public void setIdRepRodoviario(Long idRepRodoviario) {
        this.idRepRodoviario = idRepRodoviario;
    }

    @XmlTransient
    public List<Caminhao> getCaminhoes() {
        return caminhoes;
    }

    public void setCaminhoes(List<Caminhao> caminhoes) {
        this.caminhoes = caminhoes;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.RepRodoviario[ idRepRodoviario=" + idRepRodoviario + " ]";
    }
    
}
