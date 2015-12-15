package org.eja.sisolf.managed;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext; 
import org.eja.sisolf.bean.AgenteBean;
import org.eja.sisolf.bean.BancoBean;
import org.eja.sisolf.service.AgentesService;
import org.eja.sisolf.service.BancosService;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class AgentesManaged implements Serializable {

    @ManagedProperty("#{bancosService}")
    private BancosService bancosService;

    @ManagedProperty("#{agentesService}")
    private AgentesService agentesService;

    private List<BancoBean> bancos;
    private List<AgenteBean> agentes;
    private AgenteBean agente;
    private boolean update;
    private boolean delete;
    

    public AgentesManaged() {
        
    }

    @PostConstruct
    public void init() {
        bancos = bancosService.obtenerBancos();
        agentes = agentesService.obtenerAgentes();
        agente = new AgenteBean();
    }

    public void onAgenteSelect(SelectEvent event) {
        update = true;
        delete = true;
    }

    public void nuevo() {
        update = false;
        delete = false;
        agente = new AgenteBean();
    }

    public void eliminar() {

        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesContext context = FacesContext.getCurrentInstance();

        FacesMessage message = null;

        try {

            if(agentesService.obtenerNumeroClientes(agente)==0){
                agentesService.eliminar(agente);
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Agentes", "Agente eliminado correctamente");
                agentes.remove(agente);
                nuevo();
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Agentes", "El agente todavia tiene clientes asociados");
            }           

        } catch (Exception ex) {
            ex.printStackTrace();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Agentes", "Ocurrio un error al eliminar");
        }

        context.addMessage(null, message);

    }

    public void guardar() {

        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesContext context = FacesContext.getCurrentInstance();

        FacesMessage message = null;

        try {
            boolean isUpdate = false;
            if (agente.getId() != null) {
                isUpdate = true;
            }

            if (agente.getCuenta().getClabe().startsWith(agente.getCuenta().getBanco().getNumeroABM())) {
                agentesService.guardarActualizarAgente(agente);

                if (agente.getId() != null) {
                    if (!isUpdate) {
                        agentes.add(agente);
                    }
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Agentes", "Agente guardado con exito");
                    nuevo();
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Agentes", "Ocurrio un error al guardar");
                }

            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Agentes", "La CLABE no coincide con el banco");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Agentes", "Ocurrio un error al guardar");
        }

        context.addMessage(null, message);

    }

    public AgentesService getAgentesService() {
        return agentesService;
    }

    public void setAgentesService(AgentesService agentesService) {
        this.agentesService = agentesService;
    }

    public List<BancoBean> getBancos() {
        return bancos;
    }

    public void setBancos(List<BancoBean> bancos) {
        this.bancos = bancos;
    }

    public List<AgenteBean> getAgentes() {
        return agentes;
    }

    public void setAgentes(List<AgenteBean> agentes) {
        this.agentes = agentes;
    }

    public AgenteBean getAgente() {
        if (agente == null) {
            agente = new AgenteBean();
        }
        return agente;
    }

    public void setAgente(AgenteBean agente) {

        this.agente = agente;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public BancosService getBancosService() {
        return bancosService;
    }

    public void setBancosService(BancosService bancosService) {
        this.bancosService = bancosService;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

}
