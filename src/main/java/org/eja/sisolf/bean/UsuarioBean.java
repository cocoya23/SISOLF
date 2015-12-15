package org.eja.sisolf.bean;

import java.io.Serializable;
import java.util.Objects;


public class UsuarioBean implements Serializable{
    
    private Integer id;
    private String nombre;
    private String username;
    private String password;
    private String email;
    private TipoUsuario tipoUsuario;
    private byte nivel;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte getNivel() {
        return nivel;
    }

    public void setNivel(byte nivel) {
        this.nivel = nivel;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.nombre);
        hash = 19 * hash + Objects.hashCode(this.username);
        hash = 19 * hash + Objects.hashCode(this.password);
        hash = 19 * hash + Objects.hashCode(this.email);
        hash = 19 * hash + this.nivel;
        hash = 19 * hash + (this.activo ? 1 : 0);
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
        final UsuarioBean other = (UsuarioBean) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (this.nivel != other.nivel) {
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
