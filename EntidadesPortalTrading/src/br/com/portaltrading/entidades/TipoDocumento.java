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
@Table(name = "tipodocumento")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Tipodocumento.findAll", query = "SELECT t FROM Tipodocumento t")})
public class TipoDocumento extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_TIPODOCUMENTO_GENERATOR", sequenceName = "SEQ_TIPODOCUMENTO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_TIPODOCUMENTO_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idtipodocumento")
    @AuxCadastroConsulta(listaCadastro=false)
    private long idTipoDocumento;
    
    @Basic(optional = false)
//    @Column(name = "ssgdocumento")
    @Column()
    @AuxCadastroConsulta(listaConsulta=false, requerido=true, length=5)
    private String ssgDocumento;
    
//    @Column(name = "sdcdocumento")
    @Column()
    @AuxCadastroConsulta(requerido=true, length=50)
    private String sdcDocumento;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumento", fetch = FetchType.EAGER)
    private List<Documento> documentos;

    public TipoDocumento() {
    }

    public TipoDocumento(long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public TipoDocumento(String ssgDocumento,String sdcDocumento) {
        this.ssgDocumento = ssgDocumento;
        this.sdcDocumento = sdcDocumento;
    }

    public long getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getSsgDocumento() {
        return ssgDocumento;
    }

    public void setSsgDocumento(String ssgDocumento) {
        this.ssgDocumento = ssgDocumento;
    }

    public String getSdcDocumento() {
        return sdcDocumento;
    }

    public void setSdcDocumento(String sdcDocumento) {
        this.sdcDocumento = sdcDocumento;
    }

    @XmlTransient
    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Tipodocumento[ idTipoDocumento=" + idTipoDocumento + " ]";
    }
    
}
