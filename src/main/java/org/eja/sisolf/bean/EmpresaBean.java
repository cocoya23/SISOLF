package org.eja.sisolf.bean;

import java.io.Serializable;
import java.util.Objects;


public class EmpresaBean implements Serializable{
    
    private Short id;
    private String nombre;
    private String rfc;
    private String representanteLegal;
    private String giro;
    private String actividad;
    private DireccionBean direccion = new DireccionBean();
    private CuentaBean cuenta = new CuentaBean();

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public DireccionBean getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionBean direccion) {
        this.direccion = direccion;
    }

    public CuentaBean getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaBean cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmpresaBean other = (EmpresaBean) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + "";
    }
    
}
