/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.List;

/**
 *
 * @author Antonio
 */
public interface CatalogosInterface<T> {
    public void insertar();

    public List<T> buscarTodos();

    public void modificar();

    public T buscarPorClave(String clave);

    public void borrar();
}
