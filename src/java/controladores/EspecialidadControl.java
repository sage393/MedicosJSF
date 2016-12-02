/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Especialidad;
import java.io.Serializable;
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
public class EspecialidadControl implements Serializable {
    private List<Especialidad> lstEspecialidades;
    
    @PostConstruct
    public void init(){
        listarEspecialidades();
    }
    
    public List<Especialidad> listarEspecialidades() {
        Especialidad especialidad = new Especialidad();
        lstEspecialidades = especialidad.buscarTodos();
        return lstEspecialidades;
    }

    public List<Especialidad> getLstEspecialidades() {
        return lstEspecialidades;
    }

    public void setLstEspecialidades(List<Especialidad> lstEspecialidades) {
        this.lstEspecialidades = lstEspecialidades;
    }
    
    
    
}
