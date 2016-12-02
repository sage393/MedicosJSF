/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JAVA
 */
public class DataBaseHelper<T> {

    private static final String URL = "jdbc:mysql://localhost:3306/MEDICOS";
    private static final String USUARIO = "root";
    private static final String PASS = "toor";
    private static Connection con = null;
    private static Statement stm = null;

    public static int modificarRegistro(String consultaSQL) {
        int filas = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USUARIO, PASS);

            stm = con.createStatement();
            filas = stm.executeUpdate(consultaSQL);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        return filas;
    }

    public List<T> seleccionarRegistros(String consultaSQL, Class clase) {
        ResultSet rs = null;
        List<T> lista = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USUARIO, PASS);
            stm = con.createStatement();
            rs = stm.executeQuery(consultaSQL);

            while (rs.next()) {
                T objeto = (T) Class.forName(clase.getName()).newInstance();
                Method[] metodos = objeto.getClass().getDeclaredMethods();
                for (Method metodo : metodos) {
                    if (metodo.getName().startsWith("set")) {
                        for (Parameter parameter : metodo.getParameters()) {
                            String tipo = parameter.getType().toString();
                            switch (tipo) {
                                case "class java.util.Date":
                                    metodo.invoke(objeto, rs.getDate(metodo.getName().substring(3)));
                                    break;
                                case "class java.lang.Integer":
                                    metodo.invoke(objeto, rs.getInt(metodo.getName().substring(3)));
                                    break;
                                case "class java.lang.String":
                                    metodo.invoke(objeto, rs.getString(metodo.getName().substring(3)));
                                    break;
                                case "class java.math.BigDecimal":
                                    metodo.invoke(objeto, rs.getBigDecimal(metodo.getName().substring(3)));
                                    break;
                                        
                            }

                        }
                        
                    }
                    if (objeto.getClass().getName().equals("java.lang.String")) {
                        objeto = (T) rs.getString(1);
                    }
                }
                lista.add(objeto);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }

        }
        return lista;
    }

}
