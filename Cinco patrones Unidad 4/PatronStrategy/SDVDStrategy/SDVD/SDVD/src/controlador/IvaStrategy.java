/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

/**
 *
 * @author hecto
 */
public interface IvaStrategy {
    double calcularIva(double precio);
    String getDescripcion();
    int getPorcentaje(); // Nuevo método
}