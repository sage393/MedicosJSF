/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Especialidad;
import entidades.Establecimiento;
import entidades.Medico;
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
public class MedicoControl implements Serializable {
    private List<Medico> lstMedicos;

    @PostConstruct
    public void init(){
        listarMedicos();
    }
    
    public List<Medico> listarMedicos() {
        Medico medico = new Medico();
        lstMedicos = medico.buscarHabilitados();
        return lstMedicos;
    }
    
    public String nombreEspecialidad(Integer i) {
        Especialidad especialidad = Especialidad.buscarPorClave(i);
        return especialidad.getNombre();
    }
    
    public String nombreEstablecimiento(Integer i) {
        Establecimiento establecimiento = Establecimiento.buscarPorClave(i);
        return establecimiento.getNombre();
    }
    
    public void eliminarMedico(Medico x) {
        Medico medico = new Medico(x.getId_Medico(), x.getId_Especialidad(), x.getId_Establecimiento(), x.getNombres(), x.getApellidos(), x.getJvp(), false);
        medico.modificar();
        listarMedicos();
    }

    public List<Medico> getLstMedicos() {
        return lstMedicos;
    }

    public void setLstMedicos(List<Medico> lstMedicos) {
        this.lstMedicos = lstMedicos;
    }
    
    
}
