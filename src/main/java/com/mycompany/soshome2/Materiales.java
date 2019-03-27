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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manga
 */
@Entity
@Table(name = "materiales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiales.findAll", query = "SELECT m FROM Materiales m")
    , @NamedQuery(name = "Materiales.findByIdmaterial", query = "SELECT m FROM Materiales m WHERE m.idmaterial = :idmaterial")
    , @NamedQuery(name = "Materiales.findByMaterial", query = "SELECT m FROM Materiales m WHERE m.material = :material")
    , @NamedQuery(name = "Materiales.findByCantidad", query = "SELECT m FROM Materiales m WHERE m.cantidad = :cantidad")
    , @NamedQuery(name = "Materiales.findByValor", query = "SELECT m FROM Materiales m WHERE m.valor = :valor")})
public class Materiales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "idmaterial")
    private String idmaterial;
    @Size(max = 255)
    @Column(name = "material")
    private String material;
    @Size(max = 255)
    @Column(name = "cantidad")
    private String cantidad;
    @Column(name = "valor")
    private Integer valor;
    @JoinColumn(name = "cedulac", referencedColumnName = "cedulac")
    @ManyToOne
    private Cliente cedulac;
    @JoinColumn(name = "idcoti", referencedColumnName = "idcoti")
    @ManyToOne
    private Cotizacion idcoti;

    public Materiales() {
    }

    public Materiales(String idmaterial) {
        this.idmaterial = idmaterial;
    }

    public String getIdmaterial() {
        return idmaterial;
    }

    public void setIdmaterial(String idmaterial) {
        this.idmaterial = idmaterial;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Cliente getCedulac() {
        return cedulac;
    }

    public void setCedulac(Cliente cedulac) {
        this.cedulac = cedulac;
    }

    public Cotizacion getIdcoti() {
        return idcoti;
    }

    public void setIdcoti(Cotizacion idcoti) {
        this.idcoti = idcoti;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmaterial != null ? idmaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiales)) {
            return false;
        }
        Materiales other = (Materiales) object;
        if ((this.idmaterial == null && other.idmaterial != null) || (this.idmaterial != null && !this.idmaterial.equals(other.idmaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.soshome2.Materiales[ idmaterial=" + idmaterial + " ]";
    }
    
}
