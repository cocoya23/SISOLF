package org.eja.sisolf.managed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.eja.sisolf.bean.AgenteBean;
import org.eja.sisolf.bean.ClienteBean;
import org.eja.sisolf.service.AgentesService;
import org.eja.sisolf.service.ClientesService;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class ClientesManaged implements Serializable{
    
    @ManagedProperty("#{agentesService}")
    private AgentesService agentesService;
    
    @ManagedProperty("#{clientesService}")
    private ClientesService clientesService;
    
    private List<AgenteBean> agentes;
    private List<AgenteBean> agentesCliente;
    private List<ClienteBean> clientes;
    private ClienteBean cliente;
    private AgenteBean agenteNuevo;
    private AgenteBean agenteCliente;
    private boolean update;
    private boolean delete;
    private float totalPuntos;
    
    
    @PostConstruct
    public void init() {
        clientes = clientesService.obtenerClientes();
        agentes = agentesService.obtenerAgentes();
        cliente = new ClienteBean();
    }
    
    public void onClienteSelect(SelectEvent event) {
        update = true;
        delete = true;
        agentesCliente = cliente.getAgentes();
        contarPuntos();
    }
    
    public void onCellEdit(CellEditEvent event) {
        contarPuntos();        
    }
    
    public void contarPuntos(){
        totalPuntos = 0f;
        if(agentesCliente!=null){
            for (AgenteBean agente : agentesCliente) {
                totalPuntos += agente.getPuntos();
            }
        }
        totalPuntos = cliente.getPorcentaje()-totalPuntos;
    }
    
    public void agregarAgente(){
        if(agentesCliente==null)agentesCliente = new ArrayList<AgenteBean>();
        boolean existe = false;
        for (AgenteBean agente : agentesCliente) {
            if(agenteNuevo.getId().equals(agente.getId())) existe = true;
        }
        if(!existe){
            agentesCliente.add(agenteNuevo);
        }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Clientes", "Ya tiene a este agente"));
        }
        contarPuntos();
    }
    
    public void quitarAgente(){
        if(agenteCliente!=null && agentesCliente!=null)
            agentesCliente.remove(agenteCliente);
        contarPuntos();
    }
    
    public void nuevo() {
        update = false;
        delete = false;
        cliente = new ClienteBean();
        agentesCliente = new ArrayList<>();
        contarPuntos();
    }
    
    public void eliminar() {

        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesContext context = FacesContext.getCurrentInstance();

        FacesMessage message = null;

        try {

            clientesService.eliminar(cliente);
            clientes.remove(cliente);
            nuevo();
            
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Clientes", "Cliente eliminado correctamente");
            
        } catch (Exception ex) {
            ex.printStackTrace();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Clientes", "Ocurrio un error al eliminar");
        }

        context.addMessage(null, message);

    }

    public void guardar() {

        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesContext context = FacesContext.getCurrentInstance();

        FacesMessage message = null;

        try {
            boolean isUpdate = false;
            if (cliente.getId() != null) {
                isUpdate = true;
            }
            contarPuntos();
            if(totalPuntos==0f){
                cliente.setAgentes(agentesCliente);
                clientesService.guardarActualizarCliente(cliente);
                
                if(!isUpdate) clientes.add(cliente);
            
                nuevo();
                
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Clientes", "Cliente guardado exitosamente.");
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Clientes", "Los puntos asignados a los agentes son incorrectos.");
            }
            
            

        } catch (Exception ex) {
            ex.printStackTrace();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Clientes", "Ocurrio un error al guardar");
        }

        context.addMessage(null, message);

    }
    
    public void regenerarContrasena(){
        
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesContext context = FacesContext.getCurrentInstance();

        FacesMessage message = null;
        
        try{
            
            clientesService.regenerarCotrasena(cliente);
            
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Clientes", "Usuario y contraseña"
                    + "<br/>Usuario: "+cliente.getUsuario()
                    +"<br/>Contraseña: "+cliente.getPassword()
                    +"<br/>Copie la contraseña ya que no se volvera a mostrar.");
            context.addMessage("sticky", message);
        } catch (Exception ex){
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Clientes", "Ocurrio un error al regenerar la contraseña");
            context.addMessage(null, message);
        }
        
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

    public List<AgenteBean> getAgentes() {
        return agentes;
    }

    public void setAgentes(List<AgenteBean> agentes) {
        this.agentes = agentes;
    }

    public List<ClienteBean> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteBean> clientes) {
        this.clientes = clientes;
    }

    public ClienteBean getCliente() {
        if(cliente==null)cliente = new ClienteBean();
        return cliente;
    }

    public void setCliente(ClienteBean cliente) {
        this.cliente = cliente;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public AgenteBean getAgenteNuevo() {
        return agenteNuevo;
    }

    public void setAgenteNuevo(AgenteBean agenteNuevo) {
        this.agenteNuevo = agenteNuevo;
    }

    public AgenteBean getAgenteCliente() {
        return agenteCliente;
    }

    public void setAgenteCliente(AgenteBean agenteCliente) {
        this.agenteCliente = agenteCliente;
    }

    public List<AgenteBean> getAgentesCliente() {
        return agentesCliente;
    }

    public void setAgentesCliente(List<AgenteBean> agentesCliente) {
        this.agentesCliente = agentesCliente;
    }

    public float getTotalPuntos() {
        return totalPuntos;
    }

    public void setTotalPuntos(float totalPuntos) {
        this.totalPuntos = totalPuntos;
    }

}
