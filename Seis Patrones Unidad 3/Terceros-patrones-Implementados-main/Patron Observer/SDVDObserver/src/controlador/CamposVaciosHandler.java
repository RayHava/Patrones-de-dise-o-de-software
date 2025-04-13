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
public class CamposVaciosHandler implements StockHandler {
    private StockHandler next;
    
    @Override
    public void setNext(StockHandler next) {
        this.next = next;
    }
    
    @Override
    public boolean handle(InterActualizarStock frame) {
        if (frame.txt_cantidad_nueva.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese una nueva cantidad para sumar el stock del producto");
            return false;
        }
        return next == null || next.handle(frame);
    }
}




