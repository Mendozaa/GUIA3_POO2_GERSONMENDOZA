/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gersonfrancisco
 */
@Entity
@Table(name = "prueba", catalog = "regivisitas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prueba.findAll", query = "SELECT p FROM Prueba p"),
    @NamedQuery(name = "Prueba.findByCodiPrueba", query = "SELECT p FROM Prueba p WHERE p.codiPrueba = :codiPrueba"),
    @NamedQuery(name = "Prueba.findByNombPrueba", query = "SELECT p FROM Prueba p WHERE p.nombPrueba = :nombPrueba")})
public class Prueba implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_prueba")
    private Integer codiPrueba;
    @Size(max = 25)
    @Column(name = "nomb_prueba")
    private String nombPrueba;

    public Prueba() {
    }

    public Prueba(Integer codiPrueba) {
        this.codiPrueba = codiPrueba;
    }

    public Integer getCodiPrueba() {
        return codiPrueba;
    }

    public void setCodiPrueba(Integer codiPrueba) {
        this.codiPrueba = codiPrueba;
    }

    public String getNombPrueba() {
        return nombPrueba;
    }

    public void setNombPrueba(String nombPrueba) {
        this.nombPrueba = nombPrueba;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiPrueba != null ? codiPrueba.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prueba)) {
            return false;
        }
        Prueba other = (Prueba) object;
        if ((this.codiPrueba == null && other.codiPrueba != null) || (this.codiPrueba != null && !this.codiPrueba.equals(other.codiPrueba))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Prueba[ codiPrueba=" + codiPrueba + " ]";
    }
    
}
