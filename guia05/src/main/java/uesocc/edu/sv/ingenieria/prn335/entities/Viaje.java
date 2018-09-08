/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.prn335.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "viaje", catalog = "flota", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viaje.findAll", query = "SELECT v FROM Viaje v")
    , @NamedQuery(name = "Viaje.findByIdReserva", query = "SELECT v FROM Viaje v WHERE v.idReserva = :idReserva")
    , @NamedQuery(name = "Viaje.findByFechaDesde", query = "SELECT v FROM Viaje v WHERE v.fechaDesde = :fechaDesde")
    , @NamedQuery(name = "Viaje.findByFechaHasta", query = "SELECT v FROM Viaje v WHERE v.fechaHasta = :fechaHasta")
    , @NamedQuery(name = "Viaje.findByKilometros", query = "SELECT v FROM Viaje v WHERE v.kilometros = :kilometros")
    , @NamedQuery(name = "Viaje.findByMotorista", query = "SELECT v FROM Viaje v WHERE v.motorista = :motorista")
    , @NamedQuery(name = "Viaje.findByHoraSalida", query = "SELECT v FROM Viaje v WHERE v.horaSalida = :horaSalida")
    , @NamedQuery(name = "Viaje.findByHoraLlegada", query = "SELECT v FROM Viaje v WHERE v.horaLlegada = :horaLlegada")})
public class Viaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_reserva", nullable = false)
    private Long idReserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_desde", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hasta", nullable = false)
    private int fechaHasta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kilometros", nullable = false)
    private float kilometros;
    @Size(max = 155)
    @Column(name = "motorista", length = 155)
    private String motorista;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones", length = 65535)
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_salida", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaSalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_llegada", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaLlegada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReserva")
    private List<Recorrido> recorridoList;
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Reserva reserva;

    public Viaje() {
    }

    public Viaje(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Viaje(Long idReserva, Date fechaDesde, int fechaHasta, float kilometros, Date horaSalida, Date horaLlegada) {
        this.idReserva = idReserva;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.kilometros = kilometros;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public int getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(int fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public float getKilometros() {
        return kilometros;
    }

    public void setKilometros(float kilometros) {
        this.kilometros = kilometros;
    }

    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Date getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    @XmlTransient
    public List<Recorrido> getRecorridoList() {
        return recorridoList;
    }

    public void setRecorridoList(List<Recorrido> recorridoList) {
        this.recorridoList = recorridoList;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viaje)) {
            return false;
        }
        Viaje other = (Viaje) object;
        if ((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uesocc.edu.sv.ingenieria.prn335.entities.guia05.Viaje[ idReserva=" + idReserva + " ]";
    }
    
}
