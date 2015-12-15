package org.eja.sisolf.service;

import java.util.List;
import org.eja.sisolf.bean.TipoUsuario;
import org.eja.sisolf.bean.UsuarioBean;
import org.eja.sisolf.dao.UsuarioDAO;
import org.eja.sisolf.entity.Usuario;
import org.eja.sisolf.util.CifradoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static org.eja.sisolf.util.BeansUtil.*;

@Service
@Transactional(readOnly = true)
public class UsuariosService {
    
    @Autowired
    private UsuarioDAO usuarioDAO;
    
    public UsuarioBean obtenPorUsuarioLogin(String username){
        
        Usuario usuario = usuarioDAO.getByUsername(username);
        
        if(usuario==null) return null;
        
        UsuarioBean usuarioBean = new UsuarioBean();        
        usuarioBean.setId(usuario.getUsuarioId());
        usuarioBean.setNombre(usuario.getNombre());
        usuarioBean.setUsername(usuario.getUsername());
        usuarioBean.setPassword(usuario.getPassword());
        usuarioBean.setNivel(usuario.getNivel());
        usuarioBean.setEmail(usuario.getEmail());
        usuarioBean.setActivo(usuario.isActivo());
        usuarioBean.setTipoUsuario(TipoUsuario.Despacho);
        
        return usuarioBean;
        
    }
    
    public List<UsuarioBean> obtenerUsuarios(){
        
        List<Usuario> usuarios = usuarioDAO.findAll();
        
        return llenarUsuarioListBean(usuarios);
        
    }
    
    @Transactional(readOnly = false)
    public void eliminar(UsuarioBean usuarioBean) {
        
        Usuario usuario = usuarioDAO.findById(usuarioBean.getId());
        
        usuarioDAO.delete(usuario);
        
    }

    @Transactional(readOnly = false)
    public void guardarActualizarUsuario(UsuarioBean usuarioBean) {
        
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(usuarioBean.getId());
        if(usuarioBean.getId()!=null){
            usuario = usuarioDAO.findById(usuarioBean.getId());
        }
        usuario.setNombre(usuarioBean.getNombre());
        usuario.setNivel(usuarioBean.getNivel());
        usuario.setEmail(usuarioBean.getEmail());
        usuario.setActivo(usuarioBean.isActivo());
        usuario.setUsername(usuarioBean.getUsername());
        if(usuarioBean.getPassword()!=null && !usuarioBean.getPassword().trim().equals(""))
            usuario.setPassword(CifradoUtil.cifrar(usuarioBean.getPassword()));
        
        usuarioDAO.saveOrUpdate(usuario);
        
        usuarioBean.setId(usuario.getUsuarioId());
        
    }
    
    @Transactional(readOnly = false)
    public void cambiarContrasena(UsuarioBean usuarioBean){
        
        Usuario usuario = usuarioDAO.findById(usuarioBean.getId());
        usuario.setPassword(usuarioBean.getPassword());
        usuarioDAO.update(usuario);
        
    }
    
    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

}
