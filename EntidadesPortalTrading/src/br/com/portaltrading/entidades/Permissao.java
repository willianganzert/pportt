/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portaltrading.entidades;

import br.com.portaltrading.annotations.AuxCadastroConsulta;
import br.com.portaltrading.annotations.TipoInputCombo;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Willian
 */
@Entity
@Table(name = "permissao")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Permissao.findAll", query = "SELECT p FROM Permissao p")})
public class Permissao extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_PERMISSAO_GENERATOR", sequenceName = "SEQ_PERMISSAO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_PERMISSAO_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idpermissao")
    @AuxCadastroConsulta(listaCadastro=false)
    private long idPermissao;

    @Basic(optional = false)
//    @Column(name = "ssgpermissao")
    @Column()
    @AuxCadastroConsulta(requerido=true,length=4)
    private String ssgPermissao;
    
//    @Column(name = "sdcpermissao")
    @Column()
    @AuxCadastroConsulta(requerido=true,length=150)
    private String sdcPermissao;
    
    
//    @JoinColumn(name = "idcargo", referencedColumnName = "idcargo")
    @JoinColumn(name = "idCargo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @TipoInputCombo(campoDisplay="sdcCargo")
    @AuxCadastroConsulta(requerido=true,pai=true,listaCadastro=false,listaConsulta=false,tipoCampo= AuxCadastroConsulta.TIPO_CAMPO.COMBO)
    private Cargo cargo;

    public Permissao() {
    }

    public Permissao(long idpermissao) {
        this.idPermissao = idpermissao;
    }

    public Permissao(long idPermissao, String ssgPermissao) {
        this.idPermissao = idPermissao;
        this.ssgPermissao = ssgPermissao;
    }

    public long getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(long idPermissao) {
        this.idPermissao = idPermissao;
    }

    public String getSdcPermissao() {
        return sdcPermissao;
    }

    public void setSdcPermissao(String sdcPermissao) {
        this.sdcPermissao = sdcPermissao;
    }

    public String getSsgPermissao() {
        return ssgPermissao;
    }

    public void setSsgPermissao(String ssgPermissao) {
        this.ssgPermissao = ssgPermissao;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }


    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Permissao[ idPermissao=" + idPermissao + " ]";
    }
    
}
