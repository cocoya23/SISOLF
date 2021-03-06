package org.eja.sisolf.entity;
// Generated 01-mar-2015 3:16:22 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", catalog = "sisolf", uniqueConstraints = @UniqueConstraint(columnNames = "Username")
)
public class Usuario implements java.io.Serializable {

    private Integer usuarioId;
    private String username;
    private String password;
    private String nombre;
    private String email;
    private byte nivel;
    private boolean activo;
    private Set<SolicitudFactura> solicitudFacturas = new HashSet<SolicitudFactura>(0);

    public Usuario() {
    }

    public Usuario(String username, String password, String nombre, String email, byte nivel, boolean activo) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.email = email;
        this.nivel = nivel;
        this.activo = activo;
    }

    public Usuario(String username, String password, String nombre, String email, byte nivel, boolean activo, Set<SolicitudFactura> solicitudFacturas) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.email = email;
        this.nivel = nivel;
        this.activo = activo;
        this.solicitudFacturas = solicitudFacturas;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "UsuarioID", unique = true, nullable = false)
    public Integer getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Column(name = "Username", unique = true, nullable = false, length = 50)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "Password", nullable = false, length = 100)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "Nombre", nullable = false, length = 200)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "Email", nullable = false, length = 200)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "Nivel", nullable = false)
    public byte getNivel() {
        return this.nivel;
    }

    public void setNivel(byte nivel) {
        this.nivel = nivel;
    }

    @Column(name = "Activo", nullable = false)
    public boolean isActivo() {
        return this.activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    public Set<SolicitudFactura> getSolicitudFacturas() {
        return this.solicitudFacturas;
    }

    public void setSolicitudFacturas(Set<SolicitudFactura> solicitudFacturas) {
        this.solicitudFacturas = solicitudFacturas;
    }

}
