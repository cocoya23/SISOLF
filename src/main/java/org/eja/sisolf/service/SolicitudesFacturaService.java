package org.eja.sisolf.service;

import java.util.List;
import org.eja.sisolf.bean.SolicitudFacturaBean;
import org.eja.sisolf.dao.SolicitudFacturaDAO;
import org.eja.sisolf.entity.SolicitudFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static org.eja.sisolf.util.BeansUtil.*;


@Service
@Transactional(readOnly = true)
public class SolicitudesFacturaService {
    
    @Autowired
    private SolicitudFacturaDAO solicitudFacturaDAO;
    
    public List<SolicitudFacturaBean> obtenerSolicitudesCliente(int idCliente){
        
        List<SolicitudFactura> solicitudesFactura = solicitudFacturaDAO.getSolicitudesPorClienteOrderDescFechaSolicitud(idCliente);
        return llenarSolicitudFacturaListBean(solicitudesFactura);
        
    }

    public SolicitudFacturaDAO getSolicitudFacturaDAO() {
        return solicitudFacturaDAO;
    }

    public void setSolicitudFacturaDAO(SolicitudFacturaDAO solicitudFacturaDAO) {
        this.solicitudFacturaDAO = solicitudFacturaDAO;
    }

    
}
