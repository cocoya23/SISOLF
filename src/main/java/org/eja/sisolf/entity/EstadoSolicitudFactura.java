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
 * EstadoSolicitudFactura generated by hbm2java
 */
@Entity
@Table(name = "estado_solicitud_factura", catalog = "sisolf", uniqueConstraints = @UniqueConstraint(columnNames = "Estado")
)
public class EstadoSolicitudFactura implements java.io.Serializable {

    private Byte estadoId;
    private String estado;
    private Set<SolicitudFactura> solicitudFacturas = new HashSet<SolicitudFactura>(0);

    public EstadoSolicitudFactura() {
    }

    public EstadoSolicitudFactura(String estado) {
        this.estado = estado;
    }

    public EstadoSolicitudFactura(String estado, Set<SolicitudFactura> solicitudFacturas) {
        this.estado = estado;
        this.solicitudFacturas = solicitudFacturas;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "EstadoID", unique = true, nullable = false)
    public Byte getEstadoId() {
        return this.estadoId;
    }

    public void setEstadoId(Byte estadoId) {
        this.estadoId = estadoId;
    }

    @Column(name = "Estado", unique = true, nullable = false, length = 200)
    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estadoSolicitudFactura")
    public Set<SolicitudFactura> getSolicitudFacturas() {
        return this.solicitudFacturas;
    }

    public void setSolicitudFacturas(Set<SolicitudFactura> solicitudFacturas) {
        this.solicitudFacturas = solicitudFacturas;
    }

}
