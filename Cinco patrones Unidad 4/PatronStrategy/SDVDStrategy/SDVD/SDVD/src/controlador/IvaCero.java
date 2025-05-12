/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author hecto
 */
public class IvaCero implements IvaStrategy {
    @Override
    public double calcularIva(double precio) {
        return 0;
    }

    @Override
    public String getDescripcion() {
        return "No grava IVA";
    }
    
    public int getPorcentaje() {
    return 0;
}
}
