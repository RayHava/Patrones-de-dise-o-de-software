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
public class NumerosValidosHandler implements StockHandler {
    private StockHandler next;
    
    @Override
    public void setNext(StockHandler next) {
        this.next = next;
    }
    
    @Override
    public boolean handle(InterActualizarStock frame) {
        try {
            Integer.parseInt(frame.txt_cantidad_nueva.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "En la cantidad no se admiten caracteres no numéricos");
            return false;
        }
        return next == null || next.handle(frame);
    }
}