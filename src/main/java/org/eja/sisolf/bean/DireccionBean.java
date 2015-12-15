package org.eja.sisolf.bean;

import java.io.Serializable;


public class DireccionBean implements Serializable{
    
    private Integer id;
    private EntidadFederativaBean entidadFederativa = new EntidadFederativaBean();
    private String direccion;
    private String cp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EntidadFederativaBean getEntidadFederativa() {
        return entidadFederativa;
    }

    public void setEntidadFederativa(EntidadFederativaBean entidadFederativa) {
        this.entidadFederativa = entidadFederativa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }
    
    

}
