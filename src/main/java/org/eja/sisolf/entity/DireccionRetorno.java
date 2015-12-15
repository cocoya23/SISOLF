package org.eja.sisolf.entity;
// Generated 01-mar-2015 3:16:22 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * DireccionRetorno generated by hbm2java
 */
@Entity
@Table(name = "direccion_retorno", catalog = "sisolf"
)
public class DireccionRetorno implements java.io.Serializable {

    private int direccionId;
    private Direccion direccion;
    private SolicitudFactura solicitudFactura;
    private String nombre;

    public DireccionRetorno() {
    }

    public DireccionRetorno(Direccion direccion, SolicitudFactura solicitudFactura, String nombre) {
        this.direccion = direccion;
        this.solicitudFactura = solicitudFactura;
        this.nombre = nombre;
    }

    @GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "direccion"))
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "DireccionID", unique = true, nullable = false)
    public int getDireccionId() {
        return this.direccionId;
    }

    public void setDireccionId(int direccionId) {
        this.direccionId = direccionId;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public Direccion getDireccion() {
        return this.direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SolicitudFacturaID", nullable = false)
    public SolicitudFactura getSolicitudFactura() {
        return this.solicitudFactura;
    }

    public void setSolicitudFactura(SolicitudFactura solicitudFactura) {
        this.solicitudFactura = solicitudFactura;
    }

    @Column(name = "Nombre", nullable = false, length = 200)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}