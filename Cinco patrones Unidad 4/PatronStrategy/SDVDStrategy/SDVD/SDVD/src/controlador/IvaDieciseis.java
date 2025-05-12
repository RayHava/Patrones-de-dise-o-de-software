/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author hecto
 */
public class IvaDieciseis implements IvaStrategy {
    @Override
    public double calcularIva(double precio) {
        return precio * 0.16;
    }

    @Override
    public String getDescripcion() {
        return "16%";
    }
    
    @Override
public int getPorcentaje() {
    return 16;
}
    
    
}