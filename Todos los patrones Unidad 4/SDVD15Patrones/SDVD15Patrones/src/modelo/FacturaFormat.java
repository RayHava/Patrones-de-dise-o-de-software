/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
public interface FacturaFormat {
    void generarFactura(String nombreCliente, String cedulaCliente, String telefonoCliente, 
                        String direccionCliente, String fechaActual, String[][] productos, 
                        String totalPagar);
    String getExtension();
}