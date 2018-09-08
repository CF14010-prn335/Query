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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "estado_reserva", catalog = "flota", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoReserva.findAll", query = "SELECT e FROM EstadoReserva e")
    , @NamedQuery(name = "EstadoReserva.findByIdEstadoReserva", query = "SELECT e FROM EstadoReserva e WHERE e.idEstadoReserva = :idEstadoReserva")
    , @NamedQuery(name = "EstadoReserva.findByFecha", query = "SELECT e FROM EstadoReserva e WHERE e.fecha = :fecha")
    , @NamedQuery(name = "EstadoReserva.findByActual", query = "SELECT e FROM EstadoReserva e WHERE e.actual = :actual")
    , @NamedQuery(name = "EstadoReserva.findByResponsable", query = "SELECT e FROM EstadoReserva e WHERE e.responsable = :responsable")})
public class EstadoReserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_reserva", nullable = false)
    private Long idEstadoReserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actual", nullable = false)
    private boolean actual;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones", length = 65535)
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 155)
    @Column(name = "responsable", nullable = false, length = 155)
    private String responsable;
    @JoinColumn(name = "id_tipo_estado_reserva", referencedColumnName = "id_tipo_estado_reserva", nullable = false)
    @ManyToOne(optional = false)
    private TipoEstadoReserva idTipoEstadoReserva;
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva", nullable = false)
    @ManyToOne(optional = false)
    private Reserva idReserva;

    public EstadoReserva() {
    }

    public EstadoReserva(Long idEstadoReserva) {
        this.idEstadoReserva = idEstadoReserva;
    }

    public EstadoReserva(Long idEstadoReserva, Date fecha, boolean actual, String responsable) {
        this.idEstadoReserva = idEstadoReserva;
        this.fecha = fecha;
        this.actual = actual;
        this.responsable = responsable;
    }

    public Long getIdEstadoReserva() {
        return idEstadoReserva;
    }

    public void setIdEstadoReserva(Long idEstadoReserva) {
        this.idEstadoReserva = idEstadoReserva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean getActual() {
        return actual;
    }

    public void setActual(boolean actual) {
        this.actual = actual;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public TipoEstadoReserva getIdTipoEstadoReserva() {
        return idTipoEstadoReserva;
    }

    public void setIdTipoEstadoReserva(TipoEstadoReserva idTipoEstadoReserva) {
        this.idTipoEstadoReserva = idTipoEstadoReserva;
    }

    public Reserva getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Reserva idReserva) {
        this.idReserva = idReserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoReserva != null ? idEstadoReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoReserva)) {
            return false;
        }
        EstadoReserva other = (EstadoReserva) object;
        if ((this.idEstadoReserva == null && other.idEstadoReserva != null) || (this.idEstadoReserva != null && !this.idEstadoReserva.equals(other.idEstadoReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uesocc.edu.sv.ingenieria.prn335.entities.guia05.EstadoReserva[ idEstadoReserva=" + idEstadoReserva + " ]";
    }
    
}
