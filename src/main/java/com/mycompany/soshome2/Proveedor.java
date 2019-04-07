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
@Table(name = "proveedor")
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "cedulap")
    private String cedulap;
    
    @Column(name = "nombre")
    private String nombre;
   
    @Column(name = "apellido")
    private String apellido;
    
    @Column(name = "clave")
    private String clave;
    
    @Column(name = "genero")
    private String genero;
    
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "calificacion")
    private Integer calificacion;
    
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "localidad")
    private String localidad;
    
    @Column(name = "profesion")
    private String profesion;
    
    public Proveedor() {
    }

    public Proveedor(String cedulap) {
        this.cedulap = cedulap;
    }

    

    public String getCedulap() {
        return cedulap;
    }

    public void setCedulap(String cedulap) {
        this.cedulap = cedulap;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulap != null ? cedulap.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.cedulap == null && other.cedulap != null) || (this.cedulap != null && !this.cedulap.equals(other.cedulap))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.soshome2.Proveedor[ cedulap=" + cedulap + " ]";
    }
    
}
