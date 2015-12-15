package org.eja.sisolf.bean;

import java.io.Serializable;


public class ArchivoFacturaBean implements Serializable{
    
    private Integer id;
    private TipoArchivoFacturaBean tipoArchivoFactura = new TipoArchivoFacturaBean();
    private byte[] archivo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoArchivoFacturaBean getTipoArchivoFactura() {
        return tipoArchivoFactura;
    }

    public void setTipoArchivoFactura(TipoArchivoFacturaBean tipoArchivoFactura) {
        this.tipoArchivoFactura = tipoArchivoFactura;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

}
