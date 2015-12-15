package org.eja.sisolf.managed;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.eja.sisolf.bean.UsuarioBean;
import org.eja.sisolf.service.UsuariosService;
import org.primefaces.context.RequestContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean
@SessionScoped
public class LoginManaged implements Serializable {

    private String username;
    private String password;

    @ManagedProperty("#{usuariosService}")
    private UsuariosService usuariosService;
    
    @ManagedProperty("#{authenticationManager}")
    private AuthenticationManager authenticationManager;

    @PostConstruct
    public void init() {

    }

    public String login() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesContext context = FacesContext.getCurrentInstance();
        boolean loggedIn = false;
        String pagina = "login";

        
        try{
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            //Obtenemos la autenticación
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            //se la pasamos al contexto de spring
            SecurityContextHolder.getContext().setAuthentication(authentication);
            loggedIn = true;
            if(authentication.getAuthorities().iterator().next().getAuthority().equals("ROLE_CLIENT"))
                pagina = "cliente";
            else
                pagina = "despacho";
        } catch (AuthenticationException ex){
            ex.printStackTrace();
        }
        
        FacesMessage message = null;

        if (!loggedIn) {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario y/o contraseña incorrectos", "");
            context.addMessage(null, message);
        }
        
        requestContext.addCallbackParam("loggedIn", loggedIn);
        requestContext.addCallbackParam("pagina", pagina);
        return pagina;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsuariosService getUsuariosService() {
        return usuariosService;
    }

    public void setUsuariosService(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

}
