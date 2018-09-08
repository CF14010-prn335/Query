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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "recorrido", catalog = "flota", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recorrido.findAll", query = "SELECT r FROM Recorrido r")
    , @NamedQuery(name = "Recorrido.findByIdRecorrido", query = "SELECT r FROM Recorrido r WHERE r.idRecorrido = :idRecorrido")
    , @NamedQuery(name = "Recorrido.findByCoordenadaInicial", query = "SELECT r FROM Recorrido r WHERE r.coordenadaInicial = :coordenadaInicial")
    , @NamedQuery(name = "Recorrido.findByCoordenadaFinal", query = "SELECT r FROM Recorrido r WHERE r.coordenadaFinal = :coordenadaFinal")
    , @NamedQuery(name = "Recorrido.findByFechaDesde", query = "SELECT r FROM Recorrido r WHERE r.fechaDesde = :fechaDesde")
    , @NamedQuery(name = "Recorrido.findByFechaHasta", query = "SELECT r FROM Recorrido r WHERE r.fechaHasta = :fechaHasta")
    , @NamedQuery(name = "Recorrido.findByHoraDesde", query = "SELECT r FROM Recorrido r WHERE r.horaDesde = :horaDesde")
    , @NamedQuery(name = "Recorrido.findByHoraHasta", query = "SELECT r FROM Recorrido r WHERE r.horaHasta = :horaHasta")})
public class Recorrido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_recorrido", nullable = false)
    private Long idRecorrido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 155)
    @Column(name = "coordenada_inicial", nullable = false, length = 155)
    private String coordenadaInicial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 155)
    @Column(name = "coordenada_final", nullable = false, length = 155)
    private String coordenadaFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_desde", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hasta", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaHasta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_desde", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_hasta", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaHasta;
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva", nullable = false)
    @ManyToOne(optional = false)
    private Viaje idReserva;

    public Recorrido() {
    }

    public Recorrido(Long idRecorrido) {
        this.idRecorrido = idRecorrido;
    }

    public Recorrido(Long idRecorrido, String coordenadaInicial, String coordenadaFinal, Date fechaDesde, Date fechaHasta, Date horaDesde, Date horaHasta) {
        this.idRecorrido = idRecorrido;
        this.coordenadaInicial = coordenadaInicial;
        this.coordenadaFinal = coordenadaFinal;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.horaDesde = horaDesde;
        this.horaHasta = horaHasta;
    }

    public Long getIdRecorrido() {
        return idRecorrido;
    }

    public void setIdRecorrido(Long idRecorrido) {
        this.idRecorrido = idRecorrido;
    }

    public String getCoordenadaInicial() {
        return coordenadaInicial;
    }

    public void setCoordenadaInicial(String coordenadaInicial) {
        this.coordenadaInicial = coordenadaInicial;
    }

    public String getCoordenadaFinal() {
        return coordenadaFinal;
    }

    public void setCoordenadaFinal(String coordenadaFinal) {
        this.coordenadaFinal = coordenadaFinal;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Date getHoraDesde() {
        return horaDesde;
    }

    public void setHoraDesde(Date horaDesde) {
        this.horaDesde = horaDesde;
    }

    public Date getHoraHasta() {
        return horaHasta;
    }

    public void setHoraHasta(Date horaHasta) {
        this.horaHasta = horaHasta;
    }

    public Viaje getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Viaje idReserva) {
        this.idReserva = idReserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecorrido != null ? idRecorrido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recorrido)) {
            return false;
        }
        Recorrido other = (Recorrido) object;
        if ((this.idRecorrido == null && other.idRecorrido != null) || (this.idRecorrido != null && !this.idRecorrido.equals(other.idRecorrido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uesocc.edu.sv.ingenieria.prn335.entities.guia05.Recorrido[ idRecorrido=" + idRecorrido + " ]";
    }
    
}
