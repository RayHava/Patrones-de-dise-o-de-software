/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.FacturaFormat;

/**
 *
 * @author hecto
 */
public class FacturaAdapter {
    private final FacturaFormat facturaFormat;

    public FacturaAdapter(FacturaFormat facturaFormat) {
        this.facturaFormat = facturaFormat;
    }

    public void generar(String nombreCliente, String cedulaCliente, String telefonoCliente,
                      String direccionCliente, String fechaActual, String[][] productos, 
                      String totalPagar) {
        facturaFormat.generarFactura(nombreCliente, cedulaCliente, telefonoCliente,
                                   direccionCliente, fechaActual, productos, totalPagar);
    }

    public String getFormato() {
        return facturaFormat.getExtension().toUpperCase();
    }
    
    // Añadir este nuevo método
    public String getExtension() {
        return facturaFormat.getExtension();
    }
}