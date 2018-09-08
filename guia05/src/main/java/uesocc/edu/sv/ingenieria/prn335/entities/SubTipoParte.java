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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "sub_tipo_parte", catalog = "flota", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubTipoParte.findAll", query = "SELECT s FROM SubTipoParte s")
    , @NamedQuery(name = "SubTipoParte.findByIdSubTipoParte", query = "SELECT s FROM SubTipoParte s WHERE s.idSubTipoParte = :idSubTipoParte")
    , @NamedQuery(name = "SubTipoParte.findByNombre", query = "SELECT s FROM SubTipoParte s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SubTipoParte.findByActivo", query = "SELECT s FROM SubTipoParte s WHERE s.activo = :activo")})
public class SubTipoParte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sub_tipo_parte", nullable = false)
    private Integer idSubTipoParte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 155)
    @Column(name = "nombre", nullable = false, length = 155)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones", length = 65535)
    private String observaciones;
    @JoinColumn(name = "id_tipo_parte", referencedColumnName = "id_tipo_parte", nullable = false)
    @ManyToOne(optional = false)
    private TipoParte idTipoParte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSubTipoParte")
    private List<Parte> parteList;

    public SubTipoParte() {
    }

    public SubTipoParte(Integer idSubTipoParte) {
        this.idSubTipoParte = idSubTipoParte;
    }

    public SubTipoParte(Integer idSubTipoParte, String nombre, boolean activo) {
        this.idSubTipoParte = idSubTipoParte;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Integer getIdSubTipoParte() {
        return idSubTipoParte;
    }

    public void setIdSubTipoParte(Integer idSubTipoParte) {
        this.idSubTipoParte = idSubTipoParte;
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

    public TipoParte getIdTipoParte() {
        return idTipoParte;
    }

    public void setIdTipoParte(TipoParte idTipoParte) {
        this.idTipoParte = idTipoParte;
    }

    @XmlTransient
    public List<Parte> getParteList() {
        return parteList;
    }

    public void setParteList(List<Parte> parteList) {
        this.parteList = parteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubTipoParte != null ? idSubTipoParte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubTipoParte)) {
            return false;
        }
        SubTipoParte other = (SubTipoParte) object;
        if ((this.idSubTipoParte == null && other.idSubTipoParte != null) || (this.idSubTipoParte != null && !this.idSubTipoParte.equals(other.idSubTipoParte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uesocc.edu.sv.ingenieria.prn335.entities.guia05.SubTipoParte[ idSubTipoParte=" + idSubTipoParte + " ]";
    }
    
}
