/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
import vista.InterActualizarStock;

/**
 *
 * @author hecto
 */
public class CantidadPositivaHandler implements StockHandler {
    private StockHandler next;
    
    @Override
    public void setNext(StockHandler next) {
        this.next = next;
    }
    
    @Override
    public boolean handle(InterActualizarStock frame) {
        int cantidad = Integer.parseInt(frame.txt_cantidad_nueva.getText().trim());
        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad no puede ser cero ni negativa");
            return false;
        }
        return next == null || next.handle(frame);
    }
}