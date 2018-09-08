/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.prn335.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "tipo_estado_vehiculo", catalog = "flota", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEstadoVehiculo.findAll", query = "SELECT t FROM TipoEstadoVehiculo t")
    , @NamedQuery(name = "TipoEstadoVehiculo.findByIdTipoEstadoVehiculo", query = "SELECT t FROM TipoEstadoVehiculo t WHERE t.idTipoEstadoVehiculo = :idTipoEstadoVehiculo")
    , @NamedQuery(name = "TipoEstadoVehiculo.findByNombre", query = "SELECT t FROM TipoEstadoVehiculo t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoEstadoVehiculo.findByActivo", query = "SELECT t FROM TipoEstadoVehiculo t WHERE t.activo = :activo")
    , @NamedQuery(name = "TipoEstadoVehiculo.findByNoDisponible", query = "SELECT t FROM TipoEstadoVehiculo t WHERE t.noDisponible = :noDisponible")})
public class TipoEstadoVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_estado_vehiculo", nullable = false)
    private Integer idTipoEstadoVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 155)
    @Column(name = "nombre", nullable = false, length = 155)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "observaciones", nullable = false, length = 65535)
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_disponible", nullable = false)
    private boolean noDisponible;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEstadoVehiculo")
    private List<EstadoVehiculo> estadoVehiculoList;

    public TipoEstadoVehiculo() {
    }

    public TipoEstadoVehiculo(Integer idTipoEstadoVehiculo) {
        this.idTipoEstadoVehiculo = idTipoEstadoVehiculo;
    }

    public TipoEstadoVehiculo(Integer idTipoEstadoVehiculo, String nombre, boolean activo, String observaciones, boolean noDisponible) {
        this.idTipoEstadoVehiculo = idTipoEstadoVehiculo;
        this.nombre = nombre;
        this.activo = activo;
        this.observaciones = observaciones;
        this.noDisponible = noDisponible;
    }

    public Integer getIdTipoEstadoVehiculo() {
        return idTipoEstadoVehiculo;
    }

    public void setIdTipoEstadoVehiculo(Integer idTipoEstadoVehiculo) {
        this.idTipoEstadoVehiculo = idTipoEstadoVehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean getNoDisponible() {
        return noDisponible;
    }

    public void setNoDisponible(boolean noDisponible) {
        this.noDisponible = noDisponible;
    }

    @XmlTransient
    public List<EstadoVehiculo> getEstadoVehiculoList() {
        return estadoVehiculoList;
    }

    public void setEstadoVehiculoList(List<EstadoVehiculo> estadoVehiculoList) {
        this.estadoVehiculoList = estadoVehiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEstadoVehiculo != null ? idTipoEstadoVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEstadoVehiculo)) {
            return false;
        }
        TipoEstadoVehiculo other = (TipoEstadoVehiculo) object;
        if ((this.idTipoEstadoVehiculo == null && other.idTipoEstadoVehiculo != null) || (this.idTipoEstadoVehiculo != null && !this.idTipoEstadoVehiculo.equals(other.idTipoEstadoVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uesocc.edu.sv.ingenieria.prn335.entities.guia05.TipoEstadoVehiculo[ idTipoEstadoVehiculo=" + idTipoEstadoVehiculo + " ]";
    }
    
}
