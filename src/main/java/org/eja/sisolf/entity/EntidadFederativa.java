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
 * EntidadFederativa generated by hbm2java
 */
@Entity
@Table(name = "entidad_federativa", catalog = "sisolf", uniqueConstraints = @UniqueConstraint(columnNames = "EntidadFederativa")
)
public class EntidadFederativa implements java.io.Serializable {

    private Short entidadFederativaId;
    private String entidadFederativa;
    private Set<Direccion> direccions = new HashSet<Direccion>(0);

    public EntidadFederativa() {
    }

    public EntidadFederativa(String entidadFederativa) {
        this.entidadFederativa = entidadFederativa;
    }

    public EntidadFederativa(String entidadFederativa, Set<Direccion> direccions) {
        this.entidadFederativa = entidadFederativa;
        this.direccions = direccions;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "EntidadFederativaID", unique = true, nullable = false)
    public Short getEntidadFederativaId() {
        return this.entidadFederativaId;
    }

    public void setEntidadFederativaId(Short entidadFederativaId) {
        this.entidadFederativaId = entidadFederativaId;
    }

    @Column(name = "EntidadFederativa", unique = true, nullable = false, length = 100)
    public String getEntidadFederativa() {
        return this.entidadFederativa;
    }

    public void setEntidadFederativa(String entidadFederativa) {
        this.entidadFederativa = entidadFederativa;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "entidadFederativa")
    public Set<Direccion> getDireccions() {
        return this.direccions;
    }

    public void setDireccions(Set<Direccion> direccions) {
        this.direccions = direccions;
    }

}
