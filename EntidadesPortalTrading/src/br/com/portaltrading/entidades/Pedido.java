/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portaltrading.entidades;

import br.com.portaltrading.annotations.AuxCadastroConsulta;
import br.com.portaltrading.annotations.TipoInputCombo;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Willian
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")})
public class Pedido extends ComunEntidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_PEDIDO_GENERATOR", sequenceName = "SEQ_PEDIDO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_PEDIDO_GENERATOR")
    @Column(unique = true, nullable = false, precision = 22)
//    @Column(name = "idPedido")
    @AuxCadastroConsulta(listaCadastro=false)
    private long idPedido;
    
    //    @Column(name = "sdcpedido")
    @Column()
    @AuxCadastroConsulta(length=60,requerido=true)
    private String sdcPedido;
            
    @Basic(optional = false)
//    @Column(name = "stPedido")
    @Column()
    @TipoInputCombo(valuesTpCombo="1,2,3")
    @AuxCadastroConsulta(listaConsulta=false, tipoCampo= AuxCadastroConsulta.TIPO_CAMPO.COMBO)
    private int stPedido;
    
    @Basic(optional = false)
//    @Column(name = "ddtPedido")
    @Column()
    @Temporal(TemporalType.DATE)
    @AuxCadastroConsulta(listaConsulta=false,tipoDado= AuxCadastroConsulta.TIPO_DADO.DATA,requerido=true)
    private Date ddtPedido;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
//    @Column(name = "vltotal")
    @Column()
    @AuxCadastroConsulta(requerido=true)
    private double vlTotal;
    
//    @Column(name = "ddtsaida")
    @Column()
    @Temporal(TemporalType.DATE)
    @AuxCadastroConsulta(listaConsulta=false,tipoDado= AuxCadastroConsulta.TIPO_DADO.DATA)
    private Date ddtSaida;
    
//    @Column(name = "ddtchegada")
    @Column()
    @Temporal(TemporalType.DATE)
    @AuxCadastroConsulta(listaConsulta=false,tipoDado= AuxCadastroConsulta.TIPO_DADO.DATA)
    private Date ddtChegada;
    
//    @Column(name = "stlaudo")
    @Column()
    @TipoInputCombo(valuesTpCombo="1,2,3")
    @AuxCadastroConsulta(listaConsulta=false, tipoCampo= AuxCadastroConsulta.TIPO_CAMPO.COMBO)
    private int stLaudo;
    
//    @Column(name = "ddtlaudo")
    @Column()
    @Temporal(TemporalType.DATE)
    @AuxCadastroConsulta(listaConsulta=false,tipoDado= AuxCadastroConsulta.TIPO_DADO.DATA)
    private Date ddtLaudo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.EAGER)
    private List<CaminhaoPedido> caminhoesPedido;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.EAGER)
    private List<ItemPedido> itensPedido;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.EAGER)
    private List<ContainerPedido> containeresPedido;
    
//    @JoinColumn(name = "idfuncionario", referencedColumnName = "idfuncionario")
    @JoinColumn(name = "idFuncionario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Funcionario funcionario;
    
//    @JoinColumn(name = "iddespachante", referencedColumnName = "iddespachante")
    @JoinColumn(name = "idDespachante")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @TipoInputCombo(campoDisplay="snmRepDespachante")
    @AuxCadastroConsulta(listaConsulta=false, tipoCampo= AuxCadastroConsulta.TIPO_CAMPO.COMBO,pai=true,requerido=true)
    private Despachante despachante;
    
//    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @JoinColumn(name = "idcliente")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cliente cliente;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.EAGER)
    private List<ProdutoValidado> produtosValidados;

    public Pedido() {
    }

    public Pedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido(long idPedido, int stPedido, Date ddtPedido) {
        this.idPedido = idPedido;
        this.stPedido = stPedido;
        this.ddtPedido = ddtPedido;
    }

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public String getSdcPedido() {
        return sdcPedido;
    }

    public void setSdcPedido(String sdcPedido) {
        this.sdcPedido = sdcPedido;
    }
    
    public int getStPedido() {
        return stPedido;
    }

    public void setStPedido(int stPedido) {
        this.stPedido = stPedido;
    }

    public Date getDdtPedido() {
        return ddtPedido;
    }

    public void setDdtPedido(Date ddtPedido) {
        this.ddtPedido = ddtPedido;
    }

    public double getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(double vlTotal) {
        this.vlTotal = vlTotal;
    }

    public Date getDdtSaida() {
        return ddtSaida;
    }

    public void setDdtSaida(Date ddtSaida) {
        this.ddtSaida = ddtSaida;
    }

    public Date getDdtChegada() {
        return ddtChegada;
    }

    public void setDdtChegada(Date ddtChegada) {
        this.ddtChegada = ddtChegada;
    }

    public int getStLaudo() {
        return stLaudo;
    }

    public void setStLaudo(int stLaudo) {
        this.stLaudo = stLaudo;
    }

    public Date getDdtLaudo() {
        return ddtLaudo;
    }

    public void setDdtLaudo(Date ddtLaudo) {
        this.ddtLaudo = ddtLaudo;
    }

    @XmlTransient
    public List<CaminhaoPedido> getCaminhoesPedido() {
        return caminhoesPedido;
    }

    public void setCaminhoesPedido(List<CaminhaoPedido> caminhoesPedido) {
        this.caminhoesPedido = caminhoesPedido;
    }

    @XmlTransient
    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    @XmlTransient
    public List<ContainerPedido> getContaineresPedido() {
        return containeresPedido;
    }

    public void setContaineresPedido(List<ContainerPedido> containeresPedido) {
        this.containeresPedido = containeresPedido;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Despachante getDespachante() {
        return despachante;
    }

    public void setDespachante(Despachante despachante) {
        this.despachante = despachante;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @XmlTransient
    public List<ProdutoValidado> getProdutosValidados() {
        return produtosValidados;
    }

    public void setProdutosValidados(List<ProdutoValidado> produtosValidados) {
        this.produtosValidados = produtosValidados;
    }

    @Override
    public String toString() {
        return "br.com.portaltrading.entidades.Pedido[ idPedido=" + idPedido + " ]";
    }
    
}
