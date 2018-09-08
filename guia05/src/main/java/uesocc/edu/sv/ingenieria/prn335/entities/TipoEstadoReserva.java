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
@Table(name = "tipo_estado_reserva", catalog = "flota", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEstadoReserva.findAll", query = "SELECT t FROM TipoEstadoReserva t")
    , @NamedQuery(name = "TipoEstadoReserva.findByIdTipoEstadoReserva", query = "SELECT t FROM TipoEstadoReserva t WHERE t.idTipoEstadoReserva = :idTipoEstadoReserva")
    , @NamedQuery(name = "TipoEstadoReserva.findByNombre", query = "SELECT t FROM TipoEstadoReserva t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoEstadoReserva.findByActivo", query = "SELECT t FROM TipoEstadoReserva t WHERE t.activo = :activo")
    , @NamedQuery(name = "TipoEstadoReserva.findByIndicaAprobacion", query = "SELECT t FROM TipoEstadoReserva t WHERE t.indicaAprobacion = :indicaAprobacion")})
public class TipoEstadoReserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_estado_reserva", nullable = false)
    private Integer idTipoEstadoReserva;
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
    @Column(name = "indica_aprobacion", nullable = false)
    private boolean indicaAprobacion;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones", length = 65535)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEstadoReserva")
    private List<EstadoReserva> estadoReservaList;

    public TipoEstadoReserva() {
    }

    public TipoEstadoReserva(Integer idTipoEstadoReserva) {
        this.idTipoEstadoReserva = idTipoEstadoReserva;
    }

    public TipoEstadoReserva(Integer idTipoEstadoReserva, String nombre, boolean activo, boolean indicaAprobacion) {
        this.idTipoEstadoReserva = idTipoEstadoReserva;
        this.nombre = nombre;
        this.activo = activo;
        this.indicaAprobacion = indicaAprobacion;
    }

    public Integer getIdTipoEstadoReserva() {
        return idTipoEstadoReserva;
    }

    public void setIdTipoEstadoReserva(Integer idTipoEstadoReserva) {
        this.idTipoEstadoReserva = idTipoEstadoReserva;
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

    public boolean getIndicaAprobacion() {
        return indicaAprobacion;
    }

    public void setIndicaAprobacion(boolean indicaAprobacion) {
        this.indicaAprobacion = indicaAprobacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<EstadoReserva> getEstadoReservaList() {
        return estadoReservaList;
    }

    public void setEstadoReservaList(List<EstadoReserva> estadoReservaList) {
        this.estadoReservaList = estadoReservaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEstadoReserva != null ? idTipoEstadoReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEstadoReserva)) {
            return false;
        }
        TipoEstadoReserva other = (TipoEstadoReserva) object;
        if ((this.idTipoEstadoReserva == null && other.idTipoEstadoReserva != null) || (this.idTipoEstadoReserva != null && !this.idTipoEstadoReserva.equals(other.idTipoEstadoReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uesocc.edu.sv.ingenieria.prn335.entities.guia05.TipoEstadoReserva[ idTipoEstadoReserva=" + idTipoEstadoReserva + " ]";
    }
    
}
