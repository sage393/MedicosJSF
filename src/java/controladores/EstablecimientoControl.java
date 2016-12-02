/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Establecimiento;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Antonio
 */
@ManagedBean
@ViewScoped
public class EstablecimientoControl {
    private List<Establecimiento> lstEstablecimientos;
    
    @PostConstruct
    public void init(){
        listarEstablecimientos();
    }
    
    public List<Establecimiento> listarEstablecimientos() {
        Establecimiento establecimiento = new Establecimiento();
        lstEstablecimientos = establecimiento.buscarTodos();
        return lstEstablecimientos;
    }

    public List<Establecimiento> getLstEstablecimiento() {
        return lstEstablecimientos;
    }

    public void setLstEstablecimiento(List<Establecimiento> lstEstablecimiento) {
        this.lstEstablecimientos = lstEstablecimiento;
    }
    
    
}
