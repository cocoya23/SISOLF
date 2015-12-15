package org.eja.sisolf.service;

import java.util.ArrayList;
import java.util.List;
import org.eja.sisolf.bean.AgenteBean;
import org.eja.sisolf.dao.AgenteDAO;
import org.eja.sisolf.dao.CuentaDAO;
import org.eja.sisolf.entity.Agente;
import org.eja.sisolf.entity.Banco;
import org.eja.sisolf.entity.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static org.eja.sisolf.util.BeansUtil.*;

@Service
@Transactional(readOnly = true)
public class AgentesService {
    
    @Autowired
    private AgenteDAO agenteDAO;
    @Autowired
    private CuentaDAO cuentaDAO;
    
    public List<AgenteBean> obtenerAgentes(){
        
        List<Agente> agentes = agenteDAO.findAll();
        
        return llenarAgenteListBean(agentes);
        
    }
    
    public AgenteBean obtenerAgente(Integer id){
        
        Agente agente = agenteDAO.findById(id);
        
        return llenarBean(agente);
        
    }
    
    public int obtenerNumeroClientes(AgenteBean agenteBean){
        
        Agente agente = agenteDAO.findById(agenteBean.getId());
        
        if(agente.getClienteAgentes()==null) return 0;
        else return agente.getClienteAgentes().size();
        
    }
    
    @Transactional(readOnly = false)
    public void eliminar(AgenteBean agenteBean){
        
        Agente agente = agenteDAO.findById(agenteBean.getId());
        
        agenteDAO.delete(agente);
        
        
    }

    @Transactional(readOnly = false)
    public void guardarActualizarAgente(AgenteBean agenteBean){
        
        Agente agente = new Agente();
        agente.setAgenteId(agenteBean.getId());
        agente.setNombre(agenteBean.getNombre());
        agente.setTelefono(agenteBean.getTelefono());
        agente.setEmail(agenteBean.getEmail());
        
        if(agente.getAgenteId() != null)
            cuentaDAO.deleteAll(agente);
        
        Cuenta cuenta = new Cuenta();
        cuenta.setClabe(agenteBean.getCuenta().getClabe().replaceAll(" ", ""));
        Banco banco = new Banco();
        banco.setBancoId(agenteBean.getCuenta().getBanco().getId());
        
        cuenta.setBanco(banco);
        
        agente.setCuenta(cuenta);
        
        agenteDAO.saveOrUpdate(agente);
        
        agenteBean.setId(agente.getAgenteId());
        
    }

    public AgenteDAO getAgenteDAO() {
        return agenteDAO;
    }

    public void setAgenteDAO(AgenteDAO agenteDAO) {
        this.agenteDAO = agenteDAO;
    }

    public CuentaDAO getCuentaDAO() {
        return cuentaDAO;
    }

    public void setCuentaDAO(CuentaDAO cuentaDAO) {
        this.cuentaDAO = cuentaDAO;
    }

}
