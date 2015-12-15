package org.eja.sisolf.dao;

import org.eja.sisolf.entity.Agente;
import org.eja.sisolf.entity.Cuenta;
import org.eja.sisolf.entity.Empresa;
import org.springframework.stereotype.Repository;

@Repository
public class CuentaDAO extends GenericDAO<Cuenta, Integer>{
    
    private static final String DELETE_ALL_WHERE_CLIENTE = "DELETE FROM Cuenta WHERE agente.agenteId = :idAgente";
    private static final String DELETE_ALL_WHERE_EMPRESA = "DELETE FROM Cuenta WHERE empresa.empresaId = :idEmpresa";
    
    public void deleteAll(Agente agente){
        
        getCurrentSession().createQuery(DELETE_ALL_WHERE_CLIENTE).setInteger("idAgente", agente.getAgenteId()).executeUpdate();
        
    }
    
    public void deleteAll(Empresa empresa){
        
        getCurrentSession().createQuery(DELETE_ALL_WHERE_EMPRESA).setInteger("idEmpresa", empresa.getEmpresaId()).executeUpdate();
        
    }
    
}
