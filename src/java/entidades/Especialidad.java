/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.List;
import modelos.DataBaseHelper;

/**
 *
 * @author Antonio
 */
public class Especialidad implements CatalogosInterface<Especialidad> {
    private Integer Id_Especialidad;
    private String nombre;
    private List<Medico> lstMedicos;

    public Especialidad() {
    }

    public Especialidad(String nombre) {
        this.nombre = nombre;
    }     
    
    
    
    
    @Override
    public void insertar() {
        String sql = "INSERT INTO ESPECIALIDAD VALUES("
                + "'" + Id_Especialidad + "',"
                + "'" + nombre + "')";
        DataBaseHelper db = new DataBaseHelper();
        db.modificarRegistro(sql);
    }

    @Override
    public List<Especialidad> buscarTodos() {
        String sql = "SELECT * FROM ESPECIALIDAD";
        DataBaseHelper db = new DataBaseHelper();
        List<Especialidad> lstEspecialidad = db.seleccionarRegistros(sql, Especialidad.class);
        return lstEspecialidad;
    }

    @Override
    public void modificar() {
        String consultaSQL = "UPDATE ESPECIALIDAD SET "
                + "ID_ESPECIALIDAD='" + Id_Especialidad + "', " 
                + "NOMBRE='" + nombre + "', " 
                + "WHERE ID_ESPECIALIDAD=" + Id_Especialidad;
        DataBaseHelper.modificarRegistro(consultaSQL);
    }

    @Override
    public Especialidad buscarPorClave(String clave) {
        String consultaSQL = "SELECT * FROM ESPECIALIDAD WHERE ID_ESPECIALIDAD = '" + Id_Especialidad + "'";
        DataBaseHelper db = new DataBaseHelper();
        Especialidad especialidad = (Especialidad) db.seleccionarRegistros(consultaSQL, Especialidad.class).get(0);
        return especialidad;
    }

    @Override
    public void borrar() {
        String sql = "DELETE FROM ESPECIALIDAD WHERE ID_ESPECIALIDAD = '" + Id_Especialidad + "'";
        DataBaseHelper.modificarRegistro(sql);
    }
    


    public Integer getId_Especialidad() {
        return Id_Especialidad;
    }

    public void setId_Especialidad(Integer Id_Especialidad) {
        this.Id_Especialidad = Id_Especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Medico> getLstMedicos() {
        return lstMedicos;
    }

    public void setLstMedicos(List<Medico> lstMedicos) {
        this.lstMedicos = lstMedicos;
    }
    
}
