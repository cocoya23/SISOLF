package org.eja.sisolf.util;

import java.util.ArrayList;
import java.util.List;
import org.eja.sisolf.bean.TipoUsuario;
import org.eja.sisolf.bean.UsuarioBean;
import org.eja.sisolf.service.ClientesService;
import org.eja.sisolf.service.UsuariosService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserAuthentication implements UserDetailsService{
    
    private UsuariosService usuariosService;
    private ClientesService clientesService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        
        UsuarioBean usuario = usuariosService.obtenPorUsuarioLogin(username);
        
        if(usuario==null)
            usuario = clientesService.obtenerPorUsernameLogin(username);
        
        
        if(usuario==null)
            throw new UsernameNotFoundException("Usuario no encontrado");
            
        List<GrantedAuthority> grantedAuthoritys = new ArrayList<>();
        
        if(usuario.getTipoUsuario().equals(TipoUsuario.Despacho)){
            switch(usuario.getNivel()){
                case 1:
                    grantedAuthoritys.add(new SimpleGrantedAuthority("ROLE_SALE"));
                    break;
                case 2:
                    grantedAuthoritys.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
                    break;
                case 3:
                    grantedAuthoritys.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                    break;
                case 4:
                    grantedAuthoritys.add(new SimpleGrantedAuthority("ROLE_ROOT"));
                    break;
            }
        } else {
            switch(usuario.getNivel()){
                case 1:
                    grantedAuthoritys.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
                    break;
            }
        }
        
        User user = new User(usuario.getUsername(), usuario.getPassword(), grantedAuthoritys);
        
        return user;
        
    }

    public UsuariosService getUsuariosService() {
        return usuariosService;
    }

    public void setUsuariosService(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    public ClientesService getClientesService() {
        return clientesService;
    }

    public void setClientesService(ClientesService clientesService) {
        this.clientesService = clientesService;
    }
    
}
