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
@Table(name = "tipo_parte", catalog = "flota", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoParte.findAll", query = "SELECT t FROM TipoParte t")
    , @NamedQuery(name = "TipoParte.findByIdTipoParte", query = "SELECT t FROM TipoParte t WHERE t.idTipoParte = :idTipoParte")
    , @NamedQuery(name = "TipoParte.findByNombre", query = "SELECT t FROM TipoParte t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoParte.findByActivo", query = "SELECT t FROM TipoParte t WHERE t.activo = :activo")})
public class TipoParte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_parte", nullable = false)
    private Integer idTipoParte;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoParte")
    private List<SubTipoParte> subTipoParteList;

    public TipoParte() {
    }

    public TipoParte(Integer idTipoParte) {
        this.idTipoParte = idTipoParte;
    }

    public TipoParte(Integer idTipoParte, String nombre, boolean activo) {
        this.idTipoParte = idTipoParte;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Integer getIdTipoParte() {
        return idTipoParte;
    }

    public void setIdTipoParte(Integer idTipoParte) {
        this.idTipoParte = idTipoParte;
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

    @XmlTransient
    public List<SubTipoParte> getSubTipoParteList() {
        return subTipoParteList;
    }

    public void setSubTipoParteList(List<SubTipoParte> subTipoParteList) {
        this.subTipoParteList = subTipoParteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoParte != null ? idTipoParte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoParte)) {
            return false;
        }
        TipoParte other = (TipoParte) object;
        if ((this.idTipoParte == null && other.idTipoParte != null) || (this.idTipoParte != null && !this.idTipoParte.equals(other.idTipoParte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uesocc.edu.sv.ingenieria.prn335.entities.guia05.TipoParte[ idTipoParte=" + idTipoParte + " ]";
    }
    
}
