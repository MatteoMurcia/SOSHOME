/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soshome2;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author manga
 */
@Entity
@Table(name = "cotizacion")

public class Cotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idcoti")
    private String idcoti;
   
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "estimaciontiempo")
    private String estimaciontiempo;
    
    @Column(name = "comentario")
    private String comentario;
    

    public Cotizacion() {
    }

    public Cotizacion(String idcoti) {
        this.idcoti = idcoti;
    }

    public String getIdcoti() {
        return idcoti;
    }

    public void setIdcoti(String idcoti) {
        this.idcoti = idcoti;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstimaciontiempo() {
        return estimaciontiempo;
    }

    public void setEstimaciontiempo(String estimaciontiempo) {
        this.estimaciontiempo = estimaciontiempo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcoti != null ? idcoti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotizacion)) {
            return false;
        }
        Cotizacion other = (Cotizacion) object;
        if ((this.idcoti == null && other.idcoti != null) || (this.idcoti != null && !this.idcoti.equals(other.idcoti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.soshome2.Cotizacion[ idcoti=" + idcoti + " ]";
    }
    
}
