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
public class Medico implements CatalogosInterface<Medico> {

    private Integer Id_Medico;
    private Integer Id_Especialidad;
    private Integer Id_Establecimiento;
    private String nombres;
    private String apellidos;
    private String jvp;
    private boolean estado;

    public Medico() {
    }

    public Medico(Integer Id_Especialidad, Integer Id_Establecimiento, String nombres, String apellidos, String jvp, boolean estado) {
        this.Id_Especialidad = Id_Especialidad;
        this.Id_Establecimiento = Id_Establecimiento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.jvp = jvp;
        this.estado = estado;
    }

    public Medico(Integer Id_Medico, Integer Id_Especialidad, Integer Id_Establecimiento, String nombres, String apellidos, String jvp, boolean estado) {
        this.Id_Medico = Id_Medico;
        this.Id_Especialidad = Id_Especialidad;
        this.Id_Establecimiento = Id_Establecimiento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.jvp = jvp;
        this.estado = estado;
    }
    
    @Override
    public void insertar() {
        String sql = "INSERT INTO MEDICO VALUES("
                + "'" + Id_Especialidad + "',"
                + "'" + Id_Establecimiento + "',"
                + "'" + nombres + "',"
                + "'" + apellidos + "',"
                + "'" + jvp + "',"
                + "'" + estado + "')";
        DataBaseHelper db = new DataBaseHelper();
        db.modificarRegistro(sql);
    }

    @Override
    public List<Medico> buscarTodos() {
        String sql = "SELECT * FROM MEDICO";
        DataBaseHelper db = new DataBaseHelper();
        List<Medico> lstMedicos = db.seleccionarRegistros(sql, Medico.class);
        return lstMedicos;
    }

    public List<Medico> buscarHabilitados() {
        String sql = "SELECT * FROM MEDICO WHERE ESTADO = '" + true + "'";
        DataBaseHelper db = new DataBaseHelper();
        List<Medico> lstMedicos = db.seleccionarRegistros(sql, Medico.class);
        return lstMedicos;
    }

    public List<Medico> buscarInhabilitados() {
        String sql = "SELECT * FROM MEDICO WHERE ESTADO = '" + false + "'";
        DataBaseHelper db = new DataBaseHelper();
        List<Medico> lstMedicos = db.seleccionarRegistros(sql, Medico.class);
        return lstMedicos;
    }

    @Override
    public void modificar() {
        String consultaSQL = "UPDATE MEDICO SET "
                + "ID_ESPECIALIDAD='" + Id_Especialidad + "', "
                + "ID_ESTABLECIMIENTO='" + Id_Establecimiento + "', "
                + "NOMBRES='" + nombres + "', "
                + "APELLIDOS='" + apellidos + "', "
                + "JVP=" + jvp + ", "
                + "ESTADO='" + estado + "'"
                + "WHERE ID_MEDICO=" + Id_Medico;
        DataBaseHelper.modificarRegistro(consultaSQL);
    }

    @Override
    public void borrar() {
        String sql = "DELETE FROM MEDICO WHERE ID_MEDICO = '" + Id_Medico + "'";
        DataBaseHelper.modificarRegistro(sql);
    }

    public Integer getId_Medico() {
        return Id_Medico;
    }

    public void setId_Medico(Integer Id_Medico) {
        this.Id_Medico = Id_Medico;
    }

    public Integer getId_Especialidad() {
        return Id_Especialidad;
    }

    public void setId_Especialidad(Integer Id_Especialidad) {
        this.Id_Especialidad = Id_Especialidad;
    }

    public Integer getId_Establecimiento() {
        return Id_Establecimiento;
    }

    public void setId_Establecimiento(Integer Id_Establecimiento) {
        this.Id_Establecimiento = Id_Establecimiento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getJvp() {
        return jvp;
    }

    public void setJvp(String jvp) {
        this.jvp = jvp;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
