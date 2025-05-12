/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author hecto
 */
public class IvaDoce implements IvaStrategy {
    @Override
    public double calcularIva(double precio) {
        return precio * 0.12;
    }

    @Override
    public String getDescripcion() {
        return "12%";
    }
    
    @Override
public int getPorcentaje() {
    return 12;
}

}