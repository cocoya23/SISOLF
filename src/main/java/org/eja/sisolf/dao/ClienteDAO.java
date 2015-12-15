package org.eja.sisolf.dao;

import org.eja.sisolf.entity.Cliente;
import org.eja.sisolf.entity.Usuario;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDAO extends GenericDAO<Cliente, Integer>{
    
    public Cliente getByUsername(String username){
        
        Criteria criteria = this.createCriteria();
        criteria.add(Restrictions.eq("username", username));
        
        return (Cliente) criteria.uniqueResult();
    }
    

}
