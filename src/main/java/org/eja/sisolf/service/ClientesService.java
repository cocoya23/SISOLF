package org.eja.sisolf.service;

import java.util.List;
import org.eja.sisolf.bean.AgenteBean;
import org.eja.sisolf.bean.ClienteBean;
import org.eja.sisolf.bean.TipoUsuario;
import org.eja.sisolf.bean.UsuarioBean;
import org.eja.sisolf.dao.AgenteDAO;
import org.eja.sisolf.dao.ClienteAgenteDAO;
import org.eja.sisolf.dao.ClienteDAO;
import org.eja.sisolf.entity.Agente;
import org.eja.sisolf.entity.Cliente;
import org.eja.sisolf.entity.ClienteAgente;
import org.eja.sisolf.util.CifradoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static org.eja.sisolf.util.BeansUtil.*;

@Service
@Transactional(readOnly = true)
public class ClientesService {
    
    @Autowired
    private ClienteDAO clienteDAO;
    @Autowired
    private ClienteAgenteDAO clienteAgenteDAO;
    
    public List<ClienteBean> obtenerClientes(){
        return llenarClienteListBean(clienteDAO.findAll());
    }
    
    public UsuarioBean obtenerPorUsernameLogin(String username){
        Cliente cliente = clienteDAO.getByUsername(username);
        
        if(cliente==null) return null;
        
        UsuarioBean usuarioBean = new UsuarioBean();
        usuarioBean.setId(cliente.getClienteId());
        usuarioBean.setUsername(cliente.getUsername());
        usuarioBean.setPassword(cliente.getPassword());
        usuarioBean.setNombre(cliente.getNombre());
        usuarioBean.setActivo(cliente.isActivo());
        usuarioBean.setEmail(cliente.getEmail());
        usuarioBean.setNivel((byte)1);
        usuarioBean.setTipoUsuario(TipoUsuario.Cliente);
        
        return usuarioBean;
    }
    
    @Transactional(readOnly = false)
    public void eliminar(ClienteBean clienteBean){
        
        Cliente cliente = clienteDAO.findById(clienteBean.getId());
        
        clienteDAO.delete(cliente);
        
    }
    
    @Transactional(readOnly = false)
    public void guardarActualizarCliente(ClienteBean clienteBean){
        
        clienteBean.setUsuario(clienteBean.getEmail().substring(0, clienteBean.getEmail().indexOf("@")));
        clienteBean.setPassword(CifradoUtil.nuevaClave());
        
        Cliente cliente = new Cliente();
        cliente.setClienteId(clienteBean.getId());
        cliente.setNombre(clienteBean.getNombre());
        cliente.setEmail(clienteBean.getEmail());
        cliente.setTelefono(clienteBean.getTelefono());
        cliente.setPorcentaje(clienteBean.getPorcentaje());
        cliente.setActivo(clienteBean.isActivo());
        cliente.setUsername(clienteBean.getUsuario());
        cliente.setPassword(CifradoUtil.cifrar(clienteBean.getPassword()));
        
        if(cliente.getClienteId()!=null)
            clienteAgenteDAO.deleteAll(cliente);
        
        for (AgenteBean agenteBean : clienteBean.getAgentes()) {
            
            Agente agente = new Agente();
            agente.setAgenteId(agenteBean.getId());
            
            ClienteAgente clienteAgente = new ClienteAgente(agente, cliente, agenteBean.getPuntos());
                
            cliente.getClienteAgentes().add(clienteAgente);
            
        }
        
        clienteDAO.saveOrUpdate(cliente);
        clienteBean.setId(cliente.getClienteId());
        
    }
    
    @Transactional(readOnly = false)
    public void regenerarCotrasena(ClienteBean clienteBean) {
        
        clienteBean.setPassword(CifradoUtil.nuevaClave());
        
        Cliente cliente = clienteDAO.findById(clienteBean.getId());
        cliente.setPassword(CifradoUtil.cifrar(clienteBean.getPassword()));
        
        clienteDAO.update(cliente);
        
    }
    
    @Transactional(readOnly = false)
    public void cambiarContrasena(UsuarioBean usuario) {
        
        Cliente cliente = clienteDAO.findById(usuario.getId());
        cliente.setPassword(usuario.getPassword());
        
        clienteDAO.update(cliente);
        
    }

    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public void setClienteDAO(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public ClienteAgenteDAO getClienteAgenteDAO() {
        return clienteAgenteDAO;
    }

    public void setClienteAgenteDAO(ClienteAgenteDAO clienteAgenteDAO) {
        this.clienteAgenteDAO = clienteAgenteDAO;
    }

    
}
