package org.eja.sisolf.entity;
// Generated 01-mar-2015 3:16:22 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ArchivoFactura generated by hbm2java
 */
@Entity
@Table(name = "archivo_factura", catalog = "sisolf"
)
public class ArchivoFactura implements java.io.Serializable {

    private Integer archivoId;
    private SolicitudFactura solicitudFactura;
    private TipoArchivoFactura tipoArchivoFactura;
    private byte[] archivo;

    public ArchivoFactura() {
    }

    public ArchivoFactura(SolicitudFactura solicitudFactura, TipoArchivoFactura tipoArchivoFactura, byte[] archivo) {
        this.solicitudFactura = solicitudFactura;
        this.tipoArchivoFactura = tipoArchivoFactura;
        this.archivo = archivo;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "ArchivoID", unique = true, nullable = false)
    public Integer getArchivoId() {
        return this.archivoId;
    }

    public void setArchivoId(Integer archivoId) {
        this.archivoId = archivoId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SolicitudFacturaID", nullable = false)
    public SolicitudFactura getSolicitudFactura() {
        return this.solicitudFactura;
    }

    public void setSolicitudFactura(SolicitudFactura solicitudFactura) {
        this.solicitudFactura = solicitudFactura;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TipoID", nullable = false)
    public TipoArchivoFactura getTipoArchivoFactura() {
        return this.tipoArchivoFactura;
    }

    public void setTipoArchivoFactura(TipoArchivoFactura tipoArchivoFactura) {
        this.tipoArchivoFactura = tipoArchivoFactura;
    }

    @Column(name = "Archivo", nullable = false)
    public byte[] getArchivo() {
        return this.archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

}