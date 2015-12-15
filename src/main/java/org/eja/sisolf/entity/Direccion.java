package org.eja.sisolf.entity;
// Generated 01-mar-2015 3:16:22 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Direccion generated by hbm2java
 */
@Entity
@Table(name = "direccion", catalog = "sisolf"
)
public class Direccion implements java.io.Serializable {

    private Integer direccionId;
    private EntidadFederativa entidadFederativa;
    private String direccion;
    private String cp;
    private Set<Empresa> empresas = new HashSet<Empresa>(0);
    private Set<SolicitudFactura> solicitudFacturas = new HashSet<SolicitudFactura>(0);
    private DireccionRetorno direccionRetorno;

    public Direccion() {
    }

    public Direccion(EntidadFederativa entidadFederativa, String direccion, String cp) {
        this.entidadFederativa = entidadFederativa;
        this.direccion = direccion;
        this.cp = cp;
    }

    public Direccion(EntidadFederativa entidadFederativa, String direccion, String cp, Set<Empresa> empresas, Set<SolicitudFactura> solicitudFacturas, DireccionRetorno direccionRetorno) {
        this.entidadFederativa = entidadFederativa;
        this.direccion = direccion;
        this.cp = cp;
        this.empresas = empresas;
        this.solicitudFacturas = solicitudFacturas;
        this.direccionRetorno = direccionRetorno;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "DireccionID", unique = true, nullable = false)
    public Integer getDireccionId() {
        return this.direccionId;
    }

    public void setDireccionId(Integer direccionId) {
        this.direccionId = direccionId;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "EntidadFederativaID", nullable = false)
    public EntidadFederativa getEntidadFederativa() {
        return this.entidadFederativa;
    }

    public void setEntidadFederativa(EntidadFederativa entidadFederativa) {
        this.entidadFederativa = entidadFederativa;
    }

    @Column(name = "Direccion", nullable = false, length = 500)
    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "CP", nullable = false, length = 5)
    public String getCp() {
        return this.cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "direccion")
    public Set<Empresa> getEmpresas() {
        return this.empresas;
    }

    public void setEmpresas(Set<Empresa> empresas) {
        this.empresas = empresas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "direccion")
    public Set<SolicitudFactura> getSolicitudFacturas() {
        return this.solicitudFacturas;
    }

    public void setSolicitudFacturas(Set<SolicitudFactura> solicitudFacturas) {
        this.solicitudFacturas = solicitudFacturas;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "direccion")
    public DireccionRetorno getDireccionRetorno() {
        return this.direccionRetorno;
    }

    public void setDireccionRetorno(DireccionRetorno direccionRetorno) {
        this.direccionRetorno = direccionRetorno;
    }

}
