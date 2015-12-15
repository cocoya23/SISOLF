package org.eja.sisolf.managed;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.eja.sisolf.bean.BancoBean;
import org.eja.sisolf.bean.EmpresaBean;
import org.eja.sisolf.bean.EntidadFederativaBean;
import org.eja.sisolf.service.BancosService;
import org.eja.sisolf.service.EmpresasService;
import org.eja.sisolf.service.EntidadesFederativasService;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class EmpresasManaged implements Serializable{
    
    @ManagedProperty("#{empresasService}")
    private EmpresasService empresasService;
    
    @ManagedProperty("#{entidadesFederativasService}")    
    private EntidadesFederativasService entidadesFederativasService;
    
    @ManagedProperty("#{bancosService}")
    private BancosService bancosService;
    
    private List<EmpresaBean> empresas;
    private List<EntidadFederativaBean> entidadesFederativas;
    private List<BancoBean> bancos;
    private EntidadFederativaBean entidadFederativa;
    private EmpresaBean empresa;
    
    private boolean selected;
    
    @PostConstruct
    public void init() {
        empresas = empresasService.obtenerEmpresas();
        empresa = new EmpresaBean();
        entidadesFederativas = entidadesFederativasService.obtenerEntidadesFederativas();
        bancos = bancosService.obtenerBancos();
    }
    
    public void onEmpresaSelect(SelectEvent event) {
        selected = true;
    }
    
    public void nuevo() {
        selected = false;
        empresa = new EmpresaBean();
    }
    
    public void guardar(){
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesContext context = FacesContext.getCurrentInstance();

        FacesMessage message = null;

        try {
            boolean isUpdate = false;
            if (empresa.getId() != null) {
                isUpdate = true;
            } 
            if (empresa.getCuenta().getClabe().startsWith(empresa.getCuenta().getBanco().getNumeroABM())) {
                empresasService.guardarActualizarEmpresa(empresa);
                if (empresa.getId() != null) {
                                          
                    if(!isUpdate) empresas.add(empresa);
                    
                    nuevo();
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Clientes", "Cliente guardado exitosamente.");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Clientes", "Ocurrio un error al guardar");
                }

            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Clientes", "La CLABE no coincide con el banco");
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Clientes", "Ocurrio un error al guardar");
        }

        context.addMessage(null, message);
    }
    
    public void eliminar(){
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesContext context = FacesContext.getCurrentInstance();

        FacesMessage message = null;

        try {

            empresasService.eliminar(empresa);
            empresas.remove(empresa);
            nuevo();
            
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Clientes", "Cliente eliminado correctamente");
            
        } catch (Exception ex) {
            ex.printStackTrace();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Clientes", "Ocurrio un error al eliminar");
        }

        context.addMessage(null, message);
    }

    public EmpresasService getEmpresasService() {
        return empresasService;
    }

    public void setEmpresasService(EmpresasService empresasService) {
        this.empresasService = empresasService;
    }

    public List<EmpresaBean> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<EmpresaBean> empresas) {
        this.empresas = empresas;
    }

    public EmpresaBean getEmpresa() {
        if(empresa==null) empresa = new EmpresaBean();
        return empresa;
    }

    public void setEmpresa(EmpresaBean empresa) {
        this.empresa = empresa;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public EntidadesFederativasService getEntidadesFederativasService() {
        return entidadesFederativasService;
    }

    public void setEntidadesFederativasService(EntidadesFederativasService entidadesFederativasService) {
        this.entidadesFederativasService = entidadesFederativasService;
    }

    public List<EntidadFederativaBean> getEntidadesFederativas() {
        return entidadesFederativas;
    }

    public void setEntidadesFederativas(List<EntidadFederativaBean> entidadesFederativas) {
        this.entidadesFederativas = entidadesFederativas;
    }

    public EntidadFederativaBean getEntidadFederativa() {
        return entidadFederativa;
    }

    public void setEntidadFederativa(EntidadFederativaBean entidadFederativa) {
        this.entidadFederativa = entidadFederativa;
    }

    public BancosService getBancosService() {
        return bancosService;
    }

    public void setBancosService(BancosService bancosService) {
        this.bancosService = bancosService;
    }

    public List<BancoBean> getBancos() {
        return bancos;
    }

    public void setBancos(List<BancoBean> bancos) {
        this.bancos = bancos;
    }
    
}
