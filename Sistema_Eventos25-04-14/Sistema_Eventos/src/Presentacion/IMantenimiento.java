/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

/**
 *
 * @author Charlie
 */
public interface IMantenimiento {
    void guardar();
    void seleccionarTabla();
    void modificar();
    void cargarTabla(String busqueda);
}
