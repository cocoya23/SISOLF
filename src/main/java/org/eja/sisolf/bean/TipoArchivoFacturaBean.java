package org.eja.sisolf.bean;

import java.io.Serializable;

public class TipoArchivoFacturaBean implements Serializable {

    private Byte id;
    private String tipo;

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    

}
