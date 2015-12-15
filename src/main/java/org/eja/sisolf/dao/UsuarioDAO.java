package org.eja.sisolf.dao;

import org.eja.sisolf.entity.Usuario;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO extends GenericDAO<Usuario, Integer>{
    
    public Usuario getByUsername(String username){
        
        Criteria criteria = this.createCriteria();
        criteria.add(Restrictions.eq("username", username));
        
        return (Usuario) criteria.uniqueResult();
        
    }

}
