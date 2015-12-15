package org.eja.sisolf.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class AgenteBean implements Serializable{
    
    private Integer id;
    private String nombre;
    private String email;
    private String telefono;
    private CuentaBean cuenta = new CuentaBean();
    private float puntos;
    private List<ClienteBean> clientes = new ArrayList<>(0);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public float getPuntos() {
        return puntos;
    }

    public void setPuntos(float puntos) {
        this.puntos = puntos;
    }

    public List<ClienteBean> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteBean> clientes) {
        this.clientes = clientes;
    }

    public CuentaBean getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaBean cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final AgenteBean other = (AgenteBean) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+id;
    }

}
