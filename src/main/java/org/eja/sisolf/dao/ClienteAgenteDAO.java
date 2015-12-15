package org.eja.sisolf.dao;

import org.eja.sisolf.entity.Cliente;
import org.eja.sisolf.entity.ClienteAgente;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteAgenteDAO extends GenericDAO<ClienteAgente, Cliente>{
    
    private static final String DELETE_ALL_WHERE_CLIENT = "DELETE FROM ClienteAgente WHERE cliente.clienteId = :idCliente";
    
    public void deleteAll(Cliente cliente){
        
        getCurrentSession().createQuery(DELETE_ALL_WHERE_CLIENT).setInteger("idCliente", cliente.getClienteId()).executeUpdate();
        
    }

}
