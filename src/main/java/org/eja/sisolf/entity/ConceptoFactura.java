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
 * ConceptoFactura generated by hbm2java
 */
@Entity
@Table(name = "concepto_factura", catalog = "sisolf"
)
public class ConceptoFactura implements java.io.Serializable {

    private Integer conceptoId;
    private SolicitudFactura solicitudFactura;
    private String concepto;
    private float precioUnitario;
    private float cantidad;
    private float total;

    public ConceptoFactura() {
    }

    public ConceptoFactura(SolicitudFactura solicitudFactura, String concepto, float precioUnitario, float cantidad, float total) {
        this.solicitudFactura = solicitudFactura;
        this.concepto = concepto;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.total = total;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "ConceptoID", unique = true, nullable = false)
    public Integer getConceptoId() {
        return this.conceptoId;
    }

    public void setConceptoId(Integer conceptoId) {
        this.conceptoId = conceptoId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SolicitudFacturaID", nullable = false)
    public SolicitudFactura getSolicitudFactura() {
        return this.solicitudFactura;
    }

    public void setSolicitudFactura(SolicitudFactura solicitudFactura) {
        this.solicitudFactura = solicitudFactura;
    }

    @Column(name = "Concepto", nullable = false, length = 300)
    public String getConcepto() {
        return this.concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    @Column(name = "PrecioUnitario", nullable = false, precision = 15, scale = 3)
    public float getPrecioUnitario() {
        return this.precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Column(name = "Cantidad", nullable = false, precision = 12, scale = 0)
    public float getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    @Column(name = "Total", nullable = false, precision = 15, scale = 3)
    public float getTotal() {
        return this.total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

}
