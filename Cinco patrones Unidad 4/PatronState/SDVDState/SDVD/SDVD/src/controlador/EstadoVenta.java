/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.DetalleVenta;
import vista.InterFacturacion;

/**
 *
 * @author hecto
 */
public interface EstadoVenta {
    void agregarProducto(InterFacturacion contexto, DetalleVenta producto);
    void eliminarProducto(InterFacturacion contexto, int idProducto);
    void registrarVenta(InterFacturacion contexto);
}