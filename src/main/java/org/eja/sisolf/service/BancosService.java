package org.eja.sisolf.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eja.sisolf.bean.BancoBean;
import org.eja.sisolf.dao.BancoDAO;
import org.eja.sisolf.entity.Banco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static org.eja.sisolf.util.BeansUtil.*;

@Service
@Transactional(readOnly = true)
public class BancosService{
    
    @Autowired
    private BancoDAO bancoDAO;
    
    public List<BancoBean> obtenerBancos(){
        
        List<Banco> bancos = bancoDAO.findAll();
        
        List<BancoBean> bancosBean = llenarBancoListBean(bancos);
        
        Collections.sort(bancosBean, BancoBean.BY_NOMBRE_ASC);
        
        return bancosBean;
        
    }
    
    public BancoBean obtenerBanco(Short id){
        
        Banco banco = bancoDAO.findById(id);
        
        return llenarBean(banco);
        
    }

    public BancoDAO getBancoDAO() {
        return bancoDAO;
    }

    public void setBancoDAO(BancoDAO bancoDAO) {
        this.bancoDAO = bancoDAO;
    }

}
