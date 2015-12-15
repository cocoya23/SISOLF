package org.eja.sisolf.util;

import java.util.ArrayList;
import java.util.List;
import org.eja.sisolf.bean.AgenteBean;
import org.eja.sisolf.bean.BancoBean;
import org.eja.sisolf.bean.ClienteBean;
import org.eja.sisolf.bean.CuentaBean;
import org.eja.sisolf.bean.DireccionBean;
import org.eja.sisolf.bean.DireccionRetornoBean;
import org.eja.sisolf.bean.EmpresaBean;
import org.eja.sisolf.bean.EntidadFederativaBean;
import org.eja.sisolf.bean.EstadoSolicitudFacturaBean;
import org.eja.sisolf.bean.SolicitudFacturaBean;
import org.eja.sisolf.bean.UsuarioBean;
import org.eja.sisolf.entity.Agente;
import org.eja.sisolf.entity.Banco;
import org.eja.sisolf.entity.Cliente;
import org.eja.sisolf.entity.ClienteAgente;
import org.eja.sisolf.entity.Cuenta;
import org.eja.sisolf.entity.Direccion;
import org.eja.sisolf.entity.DireccionRetorno;
import org.eja.sisolf.entity.Empresa;
import org.eja.sisolf.entity.EntidadFederativa;
import org.eja.sisolf.entity.EstadoSolicitudFactura;
import org.eja.sisolf.entity.SolicitudFactura;
import org.eja.sisolf.entity.Usuario;

public class BeansUtil {

    public static CuentaBean llenarBean(Cuenta cuenta){
        
        CuentaBean cuentaBean = new CuentaBean();
        cuentaBean.setId(cuenta.getCuentaId());
        cuentaBean.setCuenta(cuenta.getCuenta());
        cuentaBean.setClabe(cuenta.getClabe());
        cuentaBean.setBanco(llenarBean(cuenta.getBanco()));
        return cuentaBean;
        
    }
    
    public static List<AgenteBean> llenarAgenteListBean(List<Agente> agentes){
        
        List<AgenteBean> agentesBean = new ArrayList<>();
        
        if(agentes!=null){
            for (Agente agente : agentes) {
                agentesBean.add(llenarBean(agente));
            }
        }
        
        return agentesBean;
        
    }
    
    public static AgenteBean llenarBean(Agente agente){
        
        if(agente==null)return null;
        
        AgenteBean agenteBean = new AgenteBean();
        
        agenteBean.setId(agente.getAgenteId());
        agenteBean.setNombre(agente.getNombre());
        agenteBean.setEmail(agente.getEmail());
        agenteBean.setTelefono(agente.getTelefono());
        agenteBean.setCuenta(llenarBean(agente.getCuenta()));
        
        return agenteBean;
        
    }
    
    public static List<UsuarioBean> llenarUsuarioListBean(List<Usuario> usuarios){
        
        List<UsuarioBean> usuariosBean = new ArrayList<>();
        
        for (Usuario usuario : usuarios) {
            usuariosBean.add(llenarBean(usuario));
        }
        
        return usuariosBean;
        
    }
    
    public static UsuarioBean llenarBean(Usuario usuario){
        
        UsuarioBean usuarioBean = new UsuarioBean();
        
        usuarioBean.setId(usuario.getUsuarioId());
        usuarioBean.setNombre(usuario.getNombre());
        usuarioBean.setUsername(usuario.getUsername());
        usuarioBean.setPassword(usuario.getPassword());
        usuarioBean.setNivel(usuario.getNivel());
        usuarioBean.setEmail(usuario.getEmail());
        usuarioBean.setActivo(usuario.isActivo());
        
        return usuarioBean;
    }
    
    public static List<BancoBean> llenarBancoListBean(List<Banco> bancos){
        
        List<BancoBean> bancosBean = new ArrayList<>();
        
        if(bancos!=null){
            for (Banco banco : bancos) {
                bancosBean.add(llenarBean(banco));
            }
        }
        
        return bancosBean;
    }
    
    public static BancoBean llenarBean(Banco banco){
        
        if(banco==null)return null;
        
        BancoBean bancoBean = new BancoBean();
            
        bancoBean.setId(banco.getBancoId());
        bancoBean.setNombre(banco.getNombre());
        bancoBean.setInstitucion(banco.getInstitucion());
        bancoBean.setNumeroABM(banco.getNumeroAbm());
        
        return bancoBean;
    }
    
    public static List<ClienteBean> llenarClienteListBean(List<Cliente> clientes){
        
        List<ClienteBean> clientesBean = new ArrayList<>();
        
        if(clientes!=null){
            for (Cliente cliente : clientes) {
                clientesBean.add(llenarBean(cliente));
            }
        }
        
        return clientesBean;
    }
    
    public static ClienteBean llenarBean(Cliente cliente){
        
        if(cliente==null)return null;
        
        ClienteBean clienteBean = new ClienteBean();
        clienteBean.setId(cliente.getClienteId());
        clienteBean.setNombre(cliente.getNombre());
        clienteBean.setEmail(cliente.getEmail());
        clienteBean.setTelefono(cliente.getTelefono());
        clienteBean.setPorcentaje(cliente.getPorcentaje());
        clienteBean.setActivo(cliente.isActivo());
        clienteBean.setUsuario(cliente.getUsername());
        
        clienteBean.setAgentes(new ArrayList<AgenteBean>());
        
        if(cliente.getClienteAgentes()!=null){
            
            for (ClienteAgente clienteAgente : cliente.getClienteAgentes()) {
                AgenteBean agenteBean = llenarBean(clienteAgente.getAgente());
                agenteBean.setPuntos(clienteAgente.getPuntos());
                clienteBean.getAgentes().add(agenteBean);
            }
            
        }
        
        return clienteBean;
        
    }
    
    public static List<EmpresaBean> llenarEmpresaListBean(List<Empresa> empresas){
        
        List<EmpresaBean> empresasBean = new ArrayList<>();
        for (Empresa empresa : empresas) {
            empresasBean.add(llenarBean(empresa));
        }
        return empresasBean;
        
    }
    
    public static EmpresaBean llenarBean(Empresa empresa){
        
        EmpresaBean empresaBean = new EmpresaBean();
        empresaBean.setId(empresa.getEmpresaId());
        empresaBean.setNombre(empresa.getNombre());
        empresaBean.setRepresentanteLegal(empresa.getRepresentanteLegal());
        empresaBean.setGiro(empresa.getGiro());
        empresaBean.setActividad(empresa.getGiro());
        empresaBean.setRfc(empresa.getRfc());
        empresaBean.setDireccion(llenarBean(empresa.getDireccion()));
        empresaBean.setCuenta(llenarBean(empresa.getCuenta()));
        
        return empresaBean;
        
    }
    
    public static List<EntidadFederativaBean> llenarEntidadFederativaListBean(List<EntidadFederativa> entidadesFederativas){
        
        List<EntidadFederativaBean> entidadesFederativasBean = new ArrayList<>();
        for (EntidadFederativa entidadesFederativa : entidadesFederativas) {
            entidadesFederativasBean.add(llenarBean(entidadesFederativa));
        }
        return entidadesFederativasBean;
        
    }
    
    public static EntidadFederativaBean llenarBean(EntidadFederativa entidadFederativa){
        EntidadFederativaBean entidadFederativaBean = new EntidadFederativaBean();
        entidadFederativaBean.setId(entidadFederativa.getEntidadFederativaId());
        entidadFederativaBean.setEntidadFederativa(entidadFederativa.getEntidadFederativa());
        return entidadFederativaBean;
    }
    
    public static List<SolicitudFacturaBean> llenarSolicitudFacturaListBean(List<SolicitudFactura> SolicitudesFactura){
        
        List<SolicitudFacturaBean> solicitudesFacturaBean = new ArrayList<>();
        for (SolicitudFactura solicitudFactura : SolicitudesFactura) {
            solicitudesFacturaBean.add(llenarBean(solicitudFactura));
        }
        return solicitudesFacturaBean;
        
    }
    
    public static SolicitudFacturaBean llenarBean(SolicitudFactura solicitudFactura){
        SolicitudFacturaBean solicitudFacturaBean = new SolicitudFacturaBean();
        solicitudFacturaBean.setId(solicitudFactura.getSolicitudFacturaId());
        solicitudFacturaBean.setFechaSolicitud(solicitudFactura.getFechaSolicitud());
        solicitudFacturaBean.setSubtotal(solicitudFactura.getSubtotal());
        solicitudFacturaBean.setIva(solicitudFactura.getIva());
        solicitudFacturaBean.setTotal(solicitudFactura.getIva());
        solicitudFacturaBean.setRetorno(solicitudFactura.getRetorno());
        solicitudFacturaBean.setRazonSocial(solicitudFactura.getRazonSocial());
        solicitudFacturaBean.setRfc(solicitudFactura.getRfc());
        solicitudFacturaBean.setDireccion(llenarBean(solicitudFactura.getDireccion()));
        solicitudFacturaBean.setCliente(llenarBean(solicitudFactura.getCliente()));
        solicitudFacturaBean.setUsuario(llenarBean(solicitudFactura.getUsuario()));
        solicitudFacturaBean.setEmpresa(llenarBean(solicitudFactura.getEmpresa()));
        solicitudFacturaBean.setEstadoSolicitudFactura(llenarBean(solicitudFactura.getEstadoSolicitudFactura()));
        return solicitudFacturaBean;
    }
    
    public static EstadoSolicitudFacturaBean llenarBean(EstadoSolicitudFactura estadoSolicitudFactura){
        EstadoSolicitudFacturaBean estadoSolicitudFacturaBean = new EstadoSolicitudFacturaBean();
        estadoSolicitudFacturaBean.setId(estadoSolicitudFactura.getEstadoId());
        estadoSolicitudFacturaBean.setEstado(estadoSolicitudFactura.getEstado());
        return estadoSolicitudFacturaBean;
    }
    
    public static DireccionBean llenarBean(Direccion direccion){
        
        DireccionBean direccionBean = new DireccionBean();
        direccionBean.setId(direccion.getDireccionId());
        direccionBean.setDireccion(direccion.getDireccion());
        direccionBean.setCp(direccion.getCp());
        direccionBean.setEntidadFederativa(llenarBean(direccion.getEntidadFederativa()));
        return direccionBean;
        
    }
    
    public static DireccionRetornoBean llenarBean(DireccionRetorno direccion){
        
        DireccionRetornoBean direccionRetornoBean = new DireccionRetornoBean();
        direccionRetornoBean.setId(direccion.getDireccionId());
        direccionRetornoBean.setNombre(direccion.getNombre());
        direccionRetornoBean.setDireccion(direccion.getDireccion().getDireccion());
        direccionRetornoBean.setCp(direccion.getDireccion().getCp());
        direccionRetornoBean.setEntidadFederativa(llenarBean(direccion.getDireccion().getEntidadFederativa()));
        
        return direccionRetornoBean;
        
    }
    
}
