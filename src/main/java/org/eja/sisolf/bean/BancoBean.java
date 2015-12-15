package org.eja.sisolf.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;


public class BancoBean implements Serializable{
    
    private Short id;
    private String institucion;
    private String nombre;
    private String numeroABM;
    private List<AgenteBean> agentes = new ArrayList<>(0);
    
    public static final OrderByNombreAsc BY_NOMBRE_ASC = new OrderByNombreAsc();
    
    private static class OrderByNombreAsc implements Comparator<BancoBean>{

        @Override
        public int compare(BancoBean o1, BancoBean o2) {
            return o1.getNombre().compareTo(o2.getNombre());
        }       
        
    }
    
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroABM() {
        return numeroABM;
    }

    public void setNumeroABM(String numeroABM) {
        this.numeroABM = numeroABM;
    }

    public List<AgenteBean> getAgentes() {
        return agentes;
    }

    public void setAgentes(List<AgenteBean> agentes) {
        this.agentes = agentes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.institucion);
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.numeroABM);
        hash = 59 * hash + Objects.hashCode(this.agentes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BancoBean other = (BancoBean) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.institucion, other.institucion)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.numeroABM, other.numeroABM)) {
            return false;
        }
        if (!Objects.equals(this.agentes, other.agentes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+id;
    }

}
