package org.eja.sisolf.managed;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class MenuManaged implements Serializable{
    
    public MenuManaged(){
        
    }

    public void abrirDlgAgentes() {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("closable", true);
        options.put("draggable", true);
        options.put("resizable", false);
        options.put("width", 760);
        options.put("contentWidth", 730);
        RequestContext.getCurrentInstance().openDialog("catalogos/agentes",options,null);
    }
    
    public void abrirDlgClientes() {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("closable", true);
        options.put("draggable", true);
        options.put("resizable", false);
        options.put("contentWidth", 600);
        RequestContext.getCurrentInstance().openDialog("catalogos/clientes",options,null);
    }
    
    public void abrirDlgUsuarios() {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("closable", true);
        options.put("draggable", true);
        options.put("resizable", false);
        options.put("contentWidth", 620);
        RequestContext.getCurrentInstance().openDialog("catalogos/usuarios",options,null);
    }
    
    public void abrirDlgEmpresas() {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("closable", true);
        options.put("draggable", true);
        options.put("resizable", false);
        options.put("width", 830);
        options.put("contentWidth", 810);
        RequestContext.getCurrentInstance().openDialog("catalogos/empresas",options,null);
    }

}
