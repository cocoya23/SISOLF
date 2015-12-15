package org.eja.sisolf.managed;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.eja.sisolf.bean.ConceptoFacturaBean;
import org.eja.sisolf.bean.SolicitudFacturaBean;
import org.eja.sisolf.service.SolicitudesFacturaService;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.FlowEvent;

@ManagedBean
@ViewScoped
public class SolicitudesFacturaManaged implements Serializable{
    
    @ManagedProperty("#{solicitudesFacturaService}")
    private SolicitudesFacturaService solicitudesFacturaService;
    
    @ManagedProperty("#{sessionManaged}")
    private SessionManaged sessionManaged;
    
    private List<SolicitudFacturaBean> solicitudesFacturaCliente;
    private List<ConceptoFacturaBean> conceptosFactura;
    private SolicitudFacturaBean solicitudFactura;
    private ConceptoFacturaBean conceptoFactura;
    
    @PostConstruct
    public void init(){
        solicitudesFacturaCliente = solicitudesFacturaService.obtenerSolicitudesCliente(sessionManaged.getUsuario().getId());
    }
    
    public void agregarConcepto(){
        
    }
    
    public void quitarConcepto(){
        
    }
    
    
    public void onConceptosCellEdit(CellEditEvent event) {
        
    }
    
    public void nuevaSolicitudFactura(){
        
    }
    
    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }
    
    

    public List<SolicitudFacturaBean> getSolicitudesFacturaCliente() {
        return solicitudesFacturaCliente;
    }

    public void setSolicitudesFacturaCliente(List<SolicitudFacturaBean> solicitudesFacturaCliente) {
        this.solicitudesFacturaCliente = solicitudesFacturaCliente;
    }

    public SolicitudesFacturaService getSolicitudesFacturaService() {
        return solicitudesFacturaService;
    }

    public void setSolicitudesFacturaService(SolicitudesFacturaService solicitudesFacturaService) {
        this.solicitudesFacturaService = solicitudesFacturaService;
    }

    public SessionManaged getSessionManaged() {
        return sessionManaged;
    }

    public void setSessionManaged(SessionManaged sessionManaged) {
        this.sessionManaged = sessionManaged;
    }

    public List<ConceptoFacturaBean> getConceptosFactura() {
        return conceptosFactura;
    }

    public void setConceptosFactura(List<ConceptoFacturaBean> conceptosFactura) {
        this.conceptosFactura = conceptosFactura;
    }

    public SolicitudFacturaBean getSolicitudFactura() {
        return solicitudFactura;
    }

    public void setSolicitudFactura(SolicitudFacturaBean solicitudFactura) {
        this.solicitudFactura = solicitudFactura;
    }

    public ConceptoFacturaBean getConceptoFactura() {
        return conceptoFactura;
    }

    public void setConceptoFactura(ConceptoFacturaBean conceptoFactura) {
        this.conceptoFactura = conceptoFactura;
    }

}
