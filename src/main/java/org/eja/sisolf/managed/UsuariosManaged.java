package org.eja.sisolf.managed;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.eja.sisolf.bean.UsuarioBean;
import org.eja.sisolf.service.UsuariosService;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class UsuariosManaged implements Serializable{
    
    @ManagedProperty("#{usuariosService}")
    private UsuariosService usuariosService;
    
    private List<UsuarioBean> usuarios;
    private UsuarioBean usuario;
    private boolean selected;
    
    @PostConstruct
    public void init(){
        usuarios = usuariosService.obtenerUsuarios();
        usuario = new UsuarioBean();
    }
    public void onUsuarioSelect(SelectEvent event) {
        selected = true;
    }
    
    public void nuevo(){
        usuario = new UsuarioBean();
        selected = false;
    }
    
    public void eliminar() {

        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesContext context = FacesContext.getCurrentInstance();

        FacesMessage message = null;

        try {

            
            usuariosService.eliminar(usuario);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuarios", "Usuario eliminado correctamente");
            usuarios.remove(usuario);
            nuevo();          

        } catch (Exception ex) {
            ex.printStackTrace();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuarios", "Ocurrio un error al eliminar");
        }

        context.addMessage(null, message);

    }

    public void guardar() {

        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesContext context = FacesContext.getCurrentInstance();

        FacesMessage message = null;

        try {
            boolean isUpdate = false;
            if (usuario.getId() != null) {
                isUpdate = true;
            } else {
                if(usuario.getPassword()==null || usuario.getPassword().trim().equals("")){
                    message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuarios", "Indique una contraseña");
                    context.addMessage(null, message);
                    return;
                }
            }

            
            usuariosService.guardarActualizarUsuario(usuario);

            if (usuario.getId() != null) {
                if (!isUpdate) {
                    usuarios.add(usuario);
                }
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuarios", "Usuario guardado con exito");
                nuevo();
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuarios", "Ocurrio un error al guardar");
            }


        } catch (Exception ex) {
            ex.printStackTrace();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuarios", "Ocurrio un error al guardar");
        }

        context.addMessage(null, message);

    }

    public List<UsuarioBean> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioBean> usuarios) {
        this.usuarios = usuarios;
    }

    public UsuarioBean getUsuario() {
        if(usuario==null)usuario = new UsuarioBean();
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public UsuariosService getUsuariosService() {
        return usuariosService;
    }

    public void setUsuariosService(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }
    

}
