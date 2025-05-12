/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.DetalleVenta;
import vista.InterFacturacion;

/**
 *
 * @author hecto
 */
public class EstadoPagado implements EstadoVenta {
    @Override
    public void agregarProducto(InterFacturacion contexto, DetalleVenta producto) {
        JOptionPane.showMessageDialog(null, "No se pueden agregar productos a una venta ya pagada");
    }

    @Override
    public void eliminarProducto(InterFacturacion contexto, int idProducto) {
        JOptionPane.showMessageDialog(null, "No se pueden eliminar productos de una venta ya pagada");
    }

    @Override
    public void registrarVenta(InterFacturacion contexto) {
        JOptionPane.showMessageDialog(null, "La venta ya ha sido registrada");
    }
}