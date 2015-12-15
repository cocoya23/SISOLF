package org.eja.sisolf.bean;

import java.io.Serializable;
import java.util.Date;


public class SolicitudFacturaBean implements Serializable{
    
    private Integer id;
    private ClienteBean cliente = new ClienteBean();
    private EmpresaBean empresa = new EmpresaBean();
    private EstadoSolicitudFacturaBean estadoSolicitudFactura = new EstadoSolicitudFacturaBean();
    private UsuarioBean usuario = new UsuarioBean();
    private Date fechaSolicitud;
    private float subtotal;
    private float iva;
    private float total;
    private float retorno;
    private String razonSocial;
    private String rfc;
    private DireccionBean direccion = new DireccionBean();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClienteBean getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBean cliente) {
        this.cliente = cliente;
    }

    public EmpresaBean getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaBean empresa) {
        this.empresa = empresa;
    }

    public EstadoSolicitudFacturaBean getEstadoSolicitudFactura() {
        return estadoSolicitudFactura;
    }

    public void setEstadoSolicitudFactura(EstadoSolicitudFacturaBean estadoSolicitudFactura) {
        this.estadoSolicitudFactura = estadoSolicitudFactura;
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getRetorno() {
        return retorno;
    }

    public void setRetorno(float retorno) {
        this.retorno = retorno;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public DireccionBean getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionBean direccion) {
        this.direccion = direccion;
    }

}
