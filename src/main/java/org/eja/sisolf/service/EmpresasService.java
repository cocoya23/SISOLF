package org.eja.sisolf.service;

import java.util.List;
import org.eja.sisolf.bean.EmpresaBean;
import org.eja.sisolf.dao.CuentaDAO;
import org.eja.sisolf.dao.EmpresaDAO;
import org.eja.sisolf.entity.Banco;
import org.eja.sisolf.entity.Cuenta;
import org.eja.sisolf.entity.Direccion;
import org.eja.sisolf.entity.Empresa;
import org.eja.sisolf.entity.EntidadFederativa;
import org.eja.sisolf.util.BeansUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static org.eja.sisolf.util.BeansUtil.*;

@Service
@Transactional(readOnly = true)
public class EmpresasService {
    
    @Autowired
    private EmpresaDAO empresaDAO;
    
    @Autowired
    private CuentaDAO cuentaDAO;
    
    public List<EmpresaBean> obtenerEmpresas(){
        return llenarEmpresaListBean(empresaDAO.findAll());
    }
    
    @Transactional(readOnly = false)
    public void eliminar(EmpresaBean empresaBean){
        
        Empresa empresa = empresaDAO.findById(empresaBean.getId());
        
        empresaDAO.delete(empresa);
        
    }

    @Transactional(readOnly = false)
    public void guardarActualizarEmpresa(EmpresaBean empresaBean) {
        
        Empresa empresa = new Empresa();
        empresa.setEmpresaId(empresaBean.getId());
        empresa.setNombre(empresaBean.getNombre());
        empresa.setRfc(empresaBean.getRfc().replaceAll(" ", ""));
        empresa.setRepresentanteLegal(empresaBean.getRepresentanteLegal());
        empresa.setGiro(empresaBean.getGiro());
        empresa.setActividad(empresaBean.getActividad());
        
        Direccion direccion = new Direccion();
        direccion.setDireccion(empresaBean.getDireccion().getDireccion());
        direccion.setCp(empresaBean.getDireccion().getCp());
        
        EntidadFederativa entidadFederativa = new EntidadFederativa();
        System.out.println("Entidad Federativa======"+empresaBean.getDireccion().getEntidadFederativa().getId());
        entidadFederativa.setEntidadFederativaId(empresaBean.getDireccion().getEntidadFederativa().getId());
        direccion.setEntidadFederativa(entidadFederativa);
                
        empresa.setDireccion(direccion);
        
        if(empresa.getEmpresaId()!=null)
            cuentaDAO.deleteAll(empresa);
        
        Cuenta cuenta = new Cuenta();
        cuenta.setClabe(empresaBean.getCuenta().getClabe().replaceAll(" ", ""));
        cuenta.setCuenta(empresaBean.getCuenta().getCuenta().replaceAll(" ", ""));
        
        Banco banco = new Banco();
        banco.setBancoId(empresaBean.getCuenta().getBanco().getId());        
        cuenta.setBanco(banco);
        
        empresa.setCuenta(cuenta);
        
        
        empresaDAO.saveOrUpdate(empresa);
        
        empresaBean.setId(empresa.getEmpresaId());
        
    }
    
    

}
