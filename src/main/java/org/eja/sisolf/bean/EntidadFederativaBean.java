package org.eja.sisolf.bean;

import java.util.Objects;


public class EntidadFederativaBean {
    
    private Short id;
    private String entidadFederativa;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getEntidadFederativa() {
        return entidadFederativa;
    }

    public void setEntidadFederativa(String entidadFederativa) {
        this.entidadFederativa = entidadFederativa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.entidadFederativa);
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
        final EntidadFederativaBean other = (EntidadFederativaBean) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.entidadFederativa, other.entidadFederativa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + "";
    }

}
