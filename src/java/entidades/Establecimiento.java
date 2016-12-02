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
public class Establecimiento implements CatalogosInterface<Establecimiento>{
    private Integer Id_Establecimiento;
    private String nombre;
    private List<Medico> lstMedicos;

    public Establecimiento() {
    }

    public Establecimiento(String nombre) {
        this.nombre = nombre;
    }
    
    

    @Override
    public void insertar() {
        String sql = "INSERT INTO ESTABLECIMIENTO VALUES("
                + "'" + Id_Establecimiento + "',"
                + "'" + nombre + "')";
        DataBaseHelper db = new DataBaseHelper();
        db.modificarRegistro(sql);
    }

    @Override
    public List<Establecimiento> buscarTodos() {
        String sql = "SELECT * FROM ESTABLECIMIENTO";
        DataBaseHelper db = new DataBaseHelper();
        List<Establecimiento> lstEstablecimientos = db.seleccionarRegistros(sql, Establecimiento.class);
        return lstEstablecimientos;
    }

    @Override
    public void modificar() {
        String consultaSQL = "UPDATE ESTABLECIMIENTO SET "
                + "ID_ESTABLECIMIENTO='" + Id_Establecimiento + "', " 
                + "NOMBRE='" + nombre + "', " 
                + "WHERE ID_MEDICO=" + Id_Establecimiento;
        DataBaseHelper.modificarRegistro(consultaSQL);
    }

    @Override
    public Establecimiento buscarPorClave(String clave) {
        String consultaSQL = "SELECT * FROM ESTABLECIMIENTO WHERE ID_ESTABLECIMIENTO = '" + Id_Establecimiento + "'";
        DataBaseHelper db = new DataBaseHelper();
        Establecimiento establecimiento = (Establecimiento) db.seleccionarRegistros(consultaSQL, Establecimiento.class).get(0);
        return establecimiento;
    }

    @Override
    public void borrar() {
        String sql = "DELETE FROM ESTABLECIMIENTO WHERE ID_ESTABLECIMIENTO = '" + Id_Establecimiento + "'";
        DataBaseHelper.modificarRegistro(sql);
    }

    
    
    public Integer getId_Establecimiento() {
        return Id_Establecimiento;
    }

    public void setId_Establecimiento(Integer Id_Establecimiento) {
        this.Id_Establecimiento = Id_Establecimiento;
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
