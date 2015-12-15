package org.eja.sisolf.service;

import java.util.List;
import org.eja.sisolf.bean.EntidadFederativaBean;
import org.eja.sisolf.dao.EntidadFederativaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static org.eja.sisolf.util.BeansUtil.*;

@Service
@Transactional(readOnly = true)
public class EntidadesFederativasService {
    
    @Autowired
    private EntidadFederativaDAO entidadFederativaDAO;
    
    public List<EntidadFederativaBean> obtenerEntidadesFederativas(){
        return llenarEntidadFederativaListBean(entidadFederativaDAO.findAll());
    }
    
    public EntidadFederativaBean obtenerEntidadFederativa(Short id){
        return llenarBean(entidadFederativaDAO.findById(id));
    }

    public EntidadFederativaDAO getEntidadFederativaDAO() {
        return entidadFederativaDAO;
    }

    public void setEntidadFederativaDAO(EntidadFederativaDAO entidadFederativaDAO) {
        this.entidadFederativaDAO = entidadFederativaDAO;
    }

}
