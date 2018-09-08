/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.prn335.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "tipo_vehiculo", catalog = "flota", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoVehiculo.findAll", query = "SELECT t FROM TipoVehiculo t")
    , @NamedQuery(name = "TipoVehiculo.findByIdTipoVehiculo", query = "SELECT t FROM TipoVehiculo t WHERE t.idTipoVehiculo = :idTipoVehiculo")
    , @NamedQuery(name = "TipoVehiculo.findByNombre", query = "SELECT t FROM TipoVehiculo t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoVehiculo.findByPesoMinLbs", query = "SELECT t FROM TipoVehiculo t WHERE t.pesoMinLbs = :pesoMinLbs")
    , @NamedQuery(name = "TipoVehiculo.findByPesoMaxLbs", query = "SELECT t FROM TipoVehiculo t WHERE t.pesoMaxLbs = :pesoMaxLbs")
    , @NamedQuery(name = "TipoVehiculo.findByCantidadEjes", query = "SELECT t FROM TipoVehiculo t WHERE t.cantidadEjes = :cantidadEjes")
    , @NamedQuery(name = "TipoVehiculo.findByActivo", query = "SELECT t FROM TipoVehiculo t WHERE t.activo = :activo")})
public class TipoVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_vehiculo", nullable = false)
    private Integer idTipoVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso_min_lbs", precision = 12)
    private Float pesoMinLbs;
    @Column(name = "peso_max_lbs", precision = 12)
    private Float pesoMaxLbs;
    @Column(name = "cantidad_ejes")
    private Integer cantidadEjes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion", length = 65535)
    private String descripcion;
    @OneToMany(mappedBy = "idTipoVehiculo")
    private List<Modelo> modeloList;

    public TipoVehiculo() {
    }

    public TipoVehiculo(Integer idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public TipoVehiculo(Integer idTipoVehiculo, String nombre, boolean activo) {
        this.idTipoVehiculo = idTipoVehiculo;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Integer getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(Integer idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPesoMinLbs() {
        return pesoMinLbs;
    }

    public void setPesoMinLbs(Float pesoMinLbs) {
        this.pesoMinLbs = pesoMinLbs;
    }

    public Float getPesoMaxLbs() {
        return pesoMaxLbs;
    }

    public void setPesoMaxLbs(Float pesoMaxLbs) {
        this.pesoMaxLbs = pesoMaxLbs;
    }

    public Integer getCantidadEjes() {
        return cantidadEjes;
    }

    public void setCantidadEjes(Integer cantidadEjes) {
        this.cantidadEjes = cantidadEjes;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Modelo> getModeloList() {
        return modeloList;
    }

    public void setModeloList(List<Modelo> modeloList) {
        this.modeloList = modeloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoVehiculo != null ? idTipoVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoVehiculo)) {
            return false;
        }
        TipoVehiculo other = (TipoVehiculo) object;
        if ((this.idTipoVehiculo == null && other.idTipoVehiculo != null) || (this.idTipoVehiculo != null && !this.idTipoVehiculo.equals(other.idTipoVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uesocc.edu.sv.ingenieria.prn335.entities.guia05.TipoVehiculo[ idTipoVehiculo=" + idTipoVehiculo + " ]";
    }
    
}
