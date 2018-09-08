/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.prn335.entities;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "estado_vehiculo", catalog = "flota", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoVehiculo.findAll", query = "SELECT e FROM EstadoVehiculo e")
    , @NamedQuery(name = "EstadoVehiculo.findByIdEstadoVehiculo", query = "SELECT e FROM EstadoVehiculo e WHERE e.idEstadoVehiculo = :idEstadoVehiculo")
    , @NamedQuery(name = "EstadoVehiculo.findByFecha", query = "SELECT e FROM EstadoVehiculo e WHERE e.fecha = :fecha")
    , @NamedQuery(name = "EstadoVehiculo.findByEstadoActual", query = "SELECT e FROM EstadoVehiculo e WHERE e.estadoActual = :estadoActual")})
public class EstadoVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_vehiculo", nullable = false)
    private Long idEstadoVehiculo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_actual", nullable = false)
    private boolean estadoActual;
    @JoinColumn(name = "id_tipo_estado_vehiculo", referencedColumnName = "id_tipo_estado_vehiculo", nullable = false)
    @ManyToOne(optional = false)
    private TipoEstadoVehiculo idTipoEstadoVehiculo;
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo", nullable = false)
    @ManyToOne(optional = false)
    private Vehiculo idVehiculo;

    public EstadoVehiculo() {
    }

    public EstadoVehiculo(Long idEstadoVehiculo) {
        this.idEstadoVehiculo = idEstadoVehiculo;
    }

    public EstadoVehiculo(Long idEstadoVehiculo, Date fecha, boolean estadoActual) {
        this.idEstadoVehiculo = idEstadoVehiculo;
        this.fecha = fecha;
        this.estadoActual = estadoActual;
    }

    public Long getIdEstadoVehiculo() {
        return idEstadoVehiculo;
    }

    public void setIdEstadoVehiculo(Long idEstadoVehiculo) {
        this.idEstadoVehiculo = idEstadoVehiculo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(boolean estadoActual) {
        this.estadoActual = estadoActual;
    }

    public TipoEstadoVehiculo getIdTipoEstadoVehiculo() {
        return idTipoEstadoVehiculo;
    }

    public void setIdTipoEstadoVehiculo(TipoEstadoVehiculo idTipoEstadoVehiculo) {
        this.idTipoEstadoVehiculo = idTipoEstadoVehiculo;
    }

    public Vehiculo getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculo idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoVehiculo != null ? idEstadoVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoVehiculo)) {
            return false;
        }
        EstadoVehiculo other = (EstadoVehiculo) object;
        if ((this.idEstadoVehiculo == null && other.idEstadoVehiculo != null) || (this.idEstadoVehiculo != null && !this.idEstadoVehiculo.equals(other.idEstadoVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uesocc.edu.sv.ingenieria.prn335.entities.guia05.EstadoVehiculo[ idEstadoVehiculo=" + idEstadoVehiculo + " ]";
    }
    
}
