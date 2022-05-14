/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author OEM
 */
@Entity
@Table(name = "JUEGOS_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JuegosUsuario.findAll", query = "SELECT j FROM JuegosUsuario j")
    , @NamedQuery(name = "JuegosUsuario.findByIdjuegousu", query = "SELECT j FROM JuegosUsuario j WHERE j.idjuegousu = :idjuegousu")
    , @NamedQuery(name = "JuegosUsuario.findByIntentosr", query = "SELECT j FROM JuegosUsuario j WHERE j.intentosr = :intentosr")
    , @NamedQuery(name = "JuegosUsuario.findByIntentost", query = "SELECT j FROM JuegosUsuario j WHERE j.intentost = :intentost")
    , @NamedQuery(name = "JuegosUsuario.findByFechaHora", query = "SELECT j FROM JuegosUsuario j WHERE j.fechaHora = :fechaHora")})
public class JuegosUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDJUEGOUSU")
    private Integer idjuegousu;
    @Column(name = "INTENTOSR")
    private Integer intentosr;
    @Column(name = "INTENTOST")
    private Integer intentost;
    @Column(name = "FECHA_HORA")
    @Temporal(TemporalType.DATE)
    private Date fechaHora;
    @JoinColumn(name = "PALABRA", referencedColumnName = "IDPALABRA")
    @ManyToOne
    private Palabras palabra;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario idusuario;

    public JuegosUsuario() {
    }

    public JuegosUsuario(Integer idjuegousu) {
        this.idjuegousu = idjuegousu;
    }

    public Integer getIdjuegousu() {
        return idjuegousu;
    }

    public void setIdjuegousu(Integer idjuegousu) {
        this.idjuegousu = idjuegousu;
    }

    public Integer getIntentosr() {
        return intentosr;
    }

    public void setIntentosr(Integer intentosr) {
        this.intentosr = intentosr;
    }

    public Integer getIntentost() {
        return intentost;
    }

    public void setIntentost(Integer intentost) {
        this.intentost = intentost;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Palabras getPalabra() {
        return palabra;
    }

    public void setPalabra(Palabras palabra) {
        this.palabra = palabra;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idjuegousu != null ? idjuegousu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JuegosUsuario)) {
            return false;
        }
        JuegosUsuario other = (JuegosUsuario) object;
        if ((this.idjuegousu == null && other.idjuegousu != null) || (this.idjuegousu != null && !this.idjuegousu.equals(other.idjuegousu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.JuegosUsuario[ idjuegousu=" + idjuegousu + " ]";
    }
    
}
