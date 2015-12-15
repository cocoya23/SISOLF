package org.eja.sisolf.bean;

import java.io.Serializable;

public class EstadoSolicitudFacturaBean implements Serializable {

    private Byte id;
    private String estado;

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

}
