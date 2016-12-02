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
    private Especialidad especialidad;
    private Establecimiento establecimiento;
    private String nombres;
    private String apellidos;
    private String jvp;
    private boolean estado;

    public Medico() {
    }

    public Medico(Especialidad especialidad, Establecimiento establecimiento, String nombres, String apellidos, String jvp, boolean estado) {
        this.especialidad = especialidad;
        this.establecimiento = establecimiento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.jvp = jvp;
        this.estado = estado;
    }

    public Medico(Integer Id_Medico, Especialidad especialidad, Establecimiento establecimiento, String nombres, String apellidos, String jvp, boolean estado) {
        this.Id_Medico = Id_Medico;
        this.especialidad = especialidad;
        this.establecimiento = establecimiento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.jvp = jvp;
        this.estado = estado;
    }

    
    
    @Override
    public void insertar() {
        String sql = "INSERT INTO MEDICO VALUES("
                + "'" + especialidad.getId_Especialidad() + "',"
                + "'" + establecimiento.getId_Establecimiento() + "',"
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
                + "ID_ESPECIALIDAD='" + 1 + "', "
                + "ID_ESTABLECIMIENTO='" + 1 + "', "
                + "NOMBRES='" + nombres + "', "
                + "APELLIDOS='" + apellidos + "', "
                + "JVP=" + jvp + ", "
                + "ESTADO='" + estado + "'"
                + "WHERE ID_MEDICO=" + Id_Medico;
        DataBaseHelper.modificarRegistro(consultaSQL);
    }

    @Override
    public Medico buscarPorClave(String clave) {
        String consultaSQL = "SELECT * FROM MEDICO WHERE ID_MEDICO = '" + Id_Medico + "'";
        DataBaseHelper db = new DataBaseHelper();
        Medico medico = (Medico) db.seleccionarRegistros(consultaSQL, Medico.class).get(0);
        return medico;
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

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
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
