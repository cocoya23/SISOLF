package org.eja.sisolf.managed;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.eja.sisolf.service.AgentesService;
import org.eja.sisolf.service.BancosService;
import org.eja.sisolf.service.ClientesService;
import org.eja.sisolf.service.EntidadesFederativasService;

@ManagedBean
@ApplicationScoped
public class ConvertersManaged implements Serializable{
    
    
    @ManagedProperty("#{agentesService}")
    private AgentesService agentesService;
    
    @ManagedProperty("#{clientesService}")
    private ClientesService clientesService;
    
    @ManagedProperty("#{bancosService}")
    private BancosService bancosService;
    
    @ManagedProperty("#{entidadesFederativasService}")    
    private EntidadesFederativasService entidadesFederativasService;
    
    private BancoConverter bancoConverter;
    private AgenteConverter agenteConverter;
    private EntidadFederativaConverter entidadFederativaConverter;
    
    public ConvertersManaged(){
        bancoConverter = new BancoConverter();
        agenteConverter = new AgenteConverter();
        entidadFederativaConverter = new EntidadFederativaConverter();
    }
    
    private class BancoConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {

            return value == null ? null : bancosService.obtenerBanco(Short.parseShort(value));

        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            return value == null ? "null" : value.toString();
        }

    }
    
    private class AgenteConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {

            return value == null ? null : agentesService.obtenerAgente(Integer.parseInt(value));

        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            return value == null ? "null" : value.toString();
        }

    }
    
    private class EntidadFederativaConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {

            return value == null ? null : entidadesFederativasService.obtenerEntidadFederativa(Short.parseShort(value));

        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            return value == null ? "null" : value.toString();
        }
        
    }

    public AgenteConverter getAgenteConverter() {
        return agenteConverter;
    }

    public void setAgenteConverter(AgenteConverter agenteConverter) {
        this.agenteConverter = agenteConverter;
    }
    
    public BancoConverter getBancoConverter() {
        return bancoConverter;
    }

    public void setBancoConverter(BancoConverter bancoConverter) {
        this.bancoConverter = bancoConverter;
    }

    public AgentesService getAgentesService() {
        return agentesService;
    }

    public void setAgentesService(AgentesService agentesService) {
        this.agentesService = agentesService;
    }

    public ClientesService getClientesService() {
        return clientesService;
    }

    public void setClientesService(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    public BancosService getBancosService() {
        return bancosService;
    }

    public void setBancosService(BancosService bancosService) {
        this.bancosService = bancosService;
    }

    public EntidadesFederativasService getEntidadesFederativasService() {
        return entidadesFederativasService;
    }

    public void setEntidadesFederativasService(EntidadesFederativasService entidadesFederativasService) {
        this.entidadesFederativasService = entidadesFederativasService;
    }

    public EntidadFederativaConverter getEntidadFederativaConverter() {
        return entidadFederativaConverter;
    }

    public void setEntidadFederativaConverter(EntidadFederativaConverter entidadFederativaConverter) {
        this.entidadFederativaConverter = entidadFederativaConverter;
    }
       

}
