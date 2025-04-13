/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author hecto
 */
import javax.swing.JOptionPane;
import vista.InterActualizarStock;

public class ProductoSeleccionadoHandler implements StockHandler {
    private StockHandler next;
    
    @Override
    public void setNext(StockHandler next) {
        this.next = next;
    }
    
    @Override
    public boolean handle(InterActualizarStock frame) {
        if (frame.jComboBox_producto.getSelectedItem().equals("Seleccione producto:")) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
            return false;
        }
        return next == null || next.handle(frame);
    }
}