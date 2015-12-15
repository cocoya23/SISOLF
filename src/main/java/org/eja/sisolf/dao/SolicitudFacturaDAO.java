package org.eja.sisolf.dao;

import java.util.List;
import org.eja.sisolf.entity.SolicitudFactura;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class SolicitudFacturaDAO extends GenericDAO<SolicitudFactura, Integer>{
    
    public List<SolicitudFactura> getSolicitudesPaginadasOrderDescFechaSolicitud(int inicio,int numRegistros){
        
        Criteria criteria = createCriteria();
        criteria.setFirstResult(inicio);
        criteria.setMaxResults(numRegistros);
        criteria.addOrder(Order.desc("fechaSolicitud"));
        
        return criteria.list();
        
    }
    
    public List<SolicitudFactura> getSolicitudesPaginadasPorUsuarioOrderDescFechaSolicitud(int idUsuario,int inicio,int numRegistros){
        
        Criteria criteria = createCriteria();
        criteria.setFirstResult(inicio);
        criteria.setMaxResults(numRegistros);
        criteria.add(Restrictions.eq("usuario.usuarioId", idUsuario));
        criteria.addOrder(Order.desc("fechaSolicitud"));
        
        return criteria.list();
        
    }
    
    public List<SolicitudFactura> getSolicitudesPorUsuarioOrderDescFechaSolicitud(int idUsuario){
        
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("usuario.usuarioId", idUsuario));
        criteria.addOrder(Order.desc("fechaSolicitud"));
        
        return criteria.list();
        
    }
    
    public List<SolicitudFactura> getSolicitudesPaginadasPorClienteOrderDescFechaSolicitud(int idCliente,int inicio,int numRegistros){
        
        Criteria criteria = createCriteria();
        criteria.setFirstResult(inicio);
        criteria.setMaxResults(numRegistros);
        criteria.add(Restrictions.eq("cliente.clienteId", idCliente));
        criteria.addOrder(Order.desc("fechaSolicitud"));
        
        return criteria.list();
        
    }
    
    public List<SolicitudFactura> getSolicitudesPorClienteOrderDescFechaSolicitud(int idCliente){
        
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("cliente.clienteId", idCliente));
        criteria.addOrder(Order.desc("fechaSolicitud"));
        
        return criteria.list();
        
    }
    
}
