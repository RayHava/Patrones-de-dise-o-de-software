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
public class EstadoPendiente implements EstadoVenta {
    @Override
    public void agregarProducto(InterFacturacion contexto, DetalleVenta producto) {
        contexto.getListaProductos().add(producto);
        contexto.actualizarTotales();
        JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
    }

    @Override
    public void eliminarProducto(InterFacturacion contexto, int idProducto) {
        contexto.getListaProductos().remove(idProducto - 1);
        contexto.actualizarTotales();
        JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
    }

    @Override
    public void registrarVenta(InterFacturacion contexto) {
        if (contexto.getListaProductos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos para registrar");
            return;
        }
        
        // Lógica para registrar la venta
        contexto.setEstado(new EstadoPagado());
        JOptionPane.showMessageDialog(null, "Venta registrada con éxito");
    }
}