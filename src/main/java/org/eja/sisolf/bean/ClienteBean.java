package org.eja.sisolf.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClienteBean implements Serializable{
    
    private Integer id;
    private String nombre;
    private String email;
    private String telefono;
    private float porcentaje;
    private String usuario;
    private String password;
    private List<AgenteBean> agentes = new ArrayList<>(0);
    private boolean activo;

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

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public List<AgenteBean> getAgentes() {
        return agentes;
    }

    public void setAgentes(List<AgenteBean> agentes) {
        this.agentes = agentes;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.nombre);
        hash = 61 * hash + Objects.hashCode(this.email);
        hash = 61 * hash + Objects.hashCode(this.telefono);
        hash = 61 * hash + Objects.hashCode(this.porcentaje);
        hash = 61 * hash + Objects.hashCode(this.usuario);
        hash = 61 * hash + Objects.hashCode(this.password);
        hash = 61 * hash + Objects.hashCode(this.agentes);
        hash = 61 * hash + (this.activo ? 1 : 0);
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
        final ClienteBean other = (ClienteBean) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.porcentaje, other.porcentaje)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.agentes, other.agentes)) {
            return false;
        }
        if (this.activo != other.activo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+id;
    }
    
}
