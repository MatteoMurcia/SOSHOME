/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soshome2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manga
 */
@Entity
@Table(name = "listaenviados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listaenviados.findAll", query = "SELECT l FROM Listaenviados l")
    , @NamedQuery(name = "Listaenviados.findById", query = "SELECT l FROM Listaenviados l WHERE l.id = :id")})
public class Listaenviados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "idservice", referencedColumnName = "idservice")
    @ManyToOne
    private Servicio idservice;
    @JoinColumn(name = "cedulap", referencedColumnName = "cedulap")
    @ManyToOne
    private Proveedor cedulap;

    public Listaenviados() {
    }

    public Listaenviados(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Servicio getIdservice() {
        return idservice;
    }

    public void setIdservice(Servicio idservice) {
        this.idservice = idservice;
    }

    public Proveedor getCedulap() {
        return cedulap;
    }

    public void setCedulap(Proveedor cedulap) {
        this.cedulap = cedulap;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listaenviados)) {
            return false;
        }
        Listaenviados other = (Listaenviados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.soshome2.Listaenviados[ id=" + id + " ]";
    }
    
}
