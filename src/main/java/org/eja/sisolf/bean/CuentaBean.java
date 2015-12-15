package org.eja.sisolf.bean;

import java.io.Serializable;
import java.util.Objects;


public class CuentaBean implements Serializable{
    
    private Integer id;
    private String cuenta;
    private String clabe;
    private BancoBean banco = new BancoBean();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public BancoBean getBanco() {
        return banco;
    }

    public void setBanco(BancoBean banco) {
        this.banco = banco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.cuenta);
        hash = 71 * hash + Objects.hashCode(this.clabe);
        hash = 71 * hash + Objects.hashCode(this.banco);
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
        final CuentaBean other = (CuentaBean) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cuenta, other.cuenta)) {
            return false;
        }
        if (!Objects.equals(this.clabe, other.clabe)) {
            return false;
        }
        if (!Objects.equals(this.banco, other.banco)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + "";
    }

}
