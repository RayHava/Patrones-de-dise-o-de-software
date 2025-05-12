/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author hecto
 */

import controlador.Ctrl_RegistrarVenta;
import java.util.Iterator;
import javax.swing.JOptionPane;
import modelo.CabeceraVenta;
import modelo.DetalleVenta;
import vista.InterFacturacion;

public class RegistrarVentaCommand implements ICommand {
    private Ctrl_RegistrarVenta controlador;
    private CabeceraVenta cabecera;
    private DetalleVenta detalle;
    private InterFacturacion interfaz;

    public RegistrarVentaCommand(Ctrl_RegistrarVenta controlador, CabeceraVenta cabecera, DetalleVenta detalle, InterFacturacion interfaz) {
        this.controlador = controlador;
        this.cabecera = cabecera;
        this.detalle = detalle;
        this.interfaz = interfaz;
    }

    @Override
    public void execute() {
        if (controlador.guardar(cabecera)) {
            // Guardar detalles y actualizar stock
            for (DetalleVenta item : interfaz.listaProductos) {
                detalle.setIdProducto(item.getIdProducto());
                detalle.setCantidad(item.getCantidad());
                controlador.guardarDetalle(detalle);
                interfaz.RestarStockProductos(item.getIdProducto(), item.getCantidad());
            }
            JOptionPane.showMessageDialog(null, "Venta registrada exitosamente");
        }
    }

    @Override
    public void undo() {
        // Marcar la cabecera como anulada y revertir stock
        cabecera.setEstado(0); // 0 = anulado
        controlador.actualizar(cabecera, cabecera.getIdCabeceraventa());
        
        for (DetalleVenta item : interfaz.listaProductos) {
            interfaz.RestarStockProductos(item.getIdProducto(), -item.getCantidad()); // Sumar stock
        }
    }
}