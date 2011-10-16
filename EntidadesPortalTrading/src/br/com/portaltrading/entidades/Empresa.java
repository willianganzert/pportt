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
@Table(name = "empresa")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")})
public class Empresa extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_EMPRESA_GENERATOR", sequenceName = "SEQ_EMPRESA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_EMPRESA_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idempresa")
    @AuxCadastroConsulta(listaCadastro=false,tipoDado=AuxCadastroConsulta.TIPO_DADO.POSITIVO)
    private long idEmpresa;
    
    @Basic(optional = false)
//    @Column(name = "sdcrazaosocial")
    @Column()
    @AuxCadastroConsulta(length=50,requerido=true)
    private String sdcRazaoSocial;
    
    @Basic(optional = false)
//    @Column(name = "scdcnpj")
    @Column()
    @AuxCadastroConsulta(length=20)
    private String scdCnpj;
    
    @Basic(optional = false)
//    @Column(name = "nidtipo")
    @Column()
    @AuxCadastroConsulta(listaConsulta=false,listaCadastro=false,tipoCampo=AuxCadastroConsulta.TIPO_CAMPO.CHECK,tipoDado=AuxCadastroConsulta.TIPO_DADO.NUMERICO)
    private int nidTipo;
    
    @Basic(optional = false)
//    @Column(name = "sdcendereco")
    @Column()
    @AuxCadastroConsulta(listaConsulta=false,length=100,requerido=true)
    private String sdcEndereco;
    
    @Basic(optional = false)
//    @Column(name = "snmfantasia")
    @Column()
    @AuxCadastroConsulta(listaConsulta=false,length=50)
    private String snmFantasia;
    
    @Basic(optional = false)
//    @Column(name = "snmrepresentante")
    @Column()
    @AuxCadastroConsulta(listaConsulta=false,length=50,requerido=true)
    private String snmRepresentante;
    
//    @Column(name = "scdcep")
    @Column()
    @AuxCadastroConsulta(listaConsulta=false,length=15)
    private String scdCep;
    
    @Basic(optional = false)
//    @Column(name = "sdcfone")
    @Column()
    @AuxCadastroConsulta(length=15,requerido=true)
    private String sdcFone;
    
//    @Column(name = "snmcidade")
    @Column()
    @AuxCadastroConsulta(listaConsulta=false)
    private String snmCidade;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.EAGER)
    private List<RepRodoviario> repRodoviarioList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.EAGER)
    private List<Fornecedor> fornecedorList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.EAGER)
    private List<Despachante> despachanteList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.EAGER)
    private List<RepMaritimo> repMaritimoList;

    public Empresa() {
    }

    public Empresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa(Long idEmpresa, String sdcRazaoSocial, String scdCnpj, String sdcEndereco, String snmFantasia, String snmRepresentante, String sdcFone) {
        this.idEmpresa = idEmpresa;
        this.sdcRazaoSocial = sdcRazaoSocial;
        this.scdCnpj = scdCnpj;
        this.sdcEndereco = sdcEndereco;
        this.snmFantasia = snmFantasia;
        this.snmRepresentante = snmRepresentante;
        this.sdcFone = sdcFone;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getSdcRazaoSocial() {
        return sdcRazaoSocial;
    }

    public void setSdcRazaoSocial(String sdcRazaoSocial) {
        this.sdcRazaoSocial = sdcRazaoSocial;
    }

    public String getScdCnpj() {
        return scdCnpj;
    }

    public void setScdCnpj(String scdCnpj) {
        this.scdCnpj = scdCnpj;
    }

    public int getNidTipo() {
        return nidTipo;
    }

    public void setNidTipo(int nidTipo) {
        this.nidTipo = nidTipo;
    }

    public String getSdcEndereco() {
        return sdcEndereco;
    }

    public void setSdcEndereco(String sdcEndereco) {
        this.sdcEndereco = sdcEndereco;
    }

    public String getSnmFantasia() {
        return snmFantasia;
    }

    public void setSnmFantasia(String snmFantasia) {
        this.snmFantasia = snmFantasia;
    }

    public String getSnmRepresentante() {
        return snmRepresentante;
    }

    public void setSnmRepresentante(String snmRepresentante) {
        this.snmRepresentante = snmRepresentante;
    }

    public String getScdCep() {
        return scdCep;
    }

    public void setScdCep(String scdCep) {
        this.scdCep = scdCep;
    }

    public String getSdcFone() {
        return sdcFone;
    }

    public void setSdcFone(String sdcFone) {
        this.sdcFone = sdcFone;
    }

    public String getSnmCidade() {
        return snmCidade;
    }

    public void setSnmCidade(String snmCidade) {
        this.snmCidade = snmCidade;
    }

    @XmlTransient
    public List<RepRodoviario> getRepRodoviarioList() {
        return repRodoviarioList;
    }

    public void setRepRodoviarioList(List<RepRodoviario> repRodoviarioList) {
        this.repRodoviarioList = repRodoviarioList;
    }

    @XmlTransient
    public List<Fornecedor> getFornecedorList() {
        return fornecedorList;
    }

    public void setFornecedorList(List<Fornecedor> fornecedorList) {
        this.fornecedorList = fornecedorList;
    }

    @XmlTransient
    public List<Despachante> getDespachanteList() {
        return despachanteList;
    }

    public void setDespachanteList(List<Despachante> despachanteList) {
        this.despachanteList = despachanteList;
    }

    @XmlTransient
    public List<RepMaritimo> getRepmaritimoList() {
        return repMaritimoList;
    }

    public void setRepmaritimoList(List<RepMaritimo> repMaritimoList) {
        this.repMaritimoList = repMaritimoList;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Empresa[ idEmpresa=" + idEmpresa + " ]";
    }
    
}
