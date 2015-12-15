package org.eja.sisolf.managed;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.eja.sisolf.bean.TipoUsuario;
import org.eja.sisolf.bean.UsuarioBean;
import org.eja.sisolf.service.ClientesService;
import org.eja.sisolf.service.UsuariosService;
import org.eja.sisolf.util.CifradoUtil;
import org.primefaces.context.RequestContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@ManagedBean
@SessionScoped
public class SessionManaged implements Serializable{
    
    @ManagedProperty("#{usuariosService}")
    private UsuariosService usuariosService;
    
    @ManagedProperty("#{clientesService}")
    private ClientesService clientesService;
    
    private UsuarioBean usuario;
    private String actualPassword;
    private String nuevoPassword;
    
    @PostConstruct
    public void init(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal().getClass());
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User){
            User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if(principal.getAuthorities().iterator().next().getAuthority().equals("ROLE_CLIENT"))
                usuario = clientesService.obtenerPorUsernameLogin(principal.getUsername());
            else
            usuario = usuariosService.obtenPorUsuarioLogin(principal.getUsername());
        }
        
    }
    
    public void cambiaPassword(){
        
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesContext context = FacesContext.getCurrentInstance();

        FacesMessage message = null;
        boolean ok = false;
        try {
            if(CifradoUtil.cifrar(actualPassword).equals(usuario.getPassword())){
                usuario.setPassword(CifradoUtil.cifrar(nuevoPassword));
                if(usuario.getTipoUsuario().equals(TipoUsuario.Despacho))
                    usuariosService.cambiarContrasena(usuario);
                else
                    clientesService.cambiarContrasena(usuario);
                init();
                ok = true;
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cambio de contraseña", "La contraseña fue actualizada correctamente");
            }else{
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Cambio de contraseña", "La contraseña actual no es correcta");
            }
        } catch (Exception ex){
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cambio de contraseña", "Ocurrio un error al cambiar la contraseña");
        }
        
        requestContext.addCallbackParam("ok", ok);
        context.addMessage(null, message);
        
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

    public UsuariosService getUsuariosService() {
        return usuariosService;
    }

    public void setUsuariosService(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    public String getActualPassword() {
        return actualPassword;
    }

    public void setActualPassword(String actualPassword) {
        this.actualPassword = actualPassword;
    }

    public String getNuevoPassword() {
        return nuevoPassword;
    }

    public void setNuevoPassword(String nuevoPassword) {
        this.nuevoPassword = nuevoPassword;
    }

    public ClientesService getClientesService() {
        return clientesService;
    }

    public void setClientesService(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

}
