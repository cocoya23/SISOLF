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
 * Cliente generated by hbm2java
 */
@Entity
@Table(name = "cliente", catalog = "sisolf", uniqueConstraints = @UniqueConstraint(columnNames = "Username")
)
public class Cliente implements java.io.Serializable {

    private Integer clienteId;
    private String nombre;
    private String email;
    private String telefono;
    private float porcentaje;
    private String username;
    private String password;
    private boolean activo;
    private Set<SolicitudFactura> solicitudFacturas = new HashSet<SolicitudFactura>(0);
    private Set<ClienteAgente> clienteAgentes = new HashSet<ClienteAgente>(0);

    public Cliente() {
    }

    public Cliente(String nombre, String email, String telefono, float porcentaje, String username, String password, boolean activo) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.porcentaje = porcentaje;
        this.username = username;
        this.password = password;
        this.activo = activo;
    }

    public Cliente(String nombre, String email, String telefono, float porcentaje, String username, String password, boolean activo, Set<SolicitudFactura> solicitudFacturas, Set<ClienteAgente> clienteAgentes) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.porcentaje = porcentaje;
        this.username = username;
        this.password = password;
        this.activo = activo;
        this.solicitudFacturas = solicitudFacturas;
        this.clienteAgentes = clienteAgentes;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "ClienteID", unique = true, nullable = false)
    public Integer getClienteId() {
        return this.clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
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

    @Column(name = "Telefono", nullable = false, length = 200)
    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Column(name = "Porcentaje", nullable = false, precision = 6, scale = 3)
    public float getPorcentaje() {
        return this.porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
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

    @Column(name = "Activo", nullable = false)
    public boolean isActivo() {
        return this.activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    public Set<SolicitudFactura> getSolicitudFacturas() {
        return this.solicitudFacturas;
    }

    public void setSolicitudFacturas(Set<SolicitudFactura> solicitudFacturas) {
        this.solicitudFacturas = solicitudFacturas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    public Set<ClienteAgente> getClienteAgentes() {
        return this.clienteAgentes;
    }

    public void setClienteAgentes(Set<ClienteAgente> clienteAgentes) {
        this.clienteAgentes = clienteAgentes;
    }

}
