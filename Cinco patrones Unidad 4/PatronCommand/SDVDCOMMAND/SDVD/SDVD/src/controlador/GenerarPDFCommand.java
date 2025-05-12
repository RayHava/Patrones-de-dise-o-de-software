/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author hecto
 */

import controlador.VentaPDF;
import vista.InterFacturacion;

public class GenerarPDFCommand implements ICommand {
    private VentaPDF pdfGenerator;
    private InterFacturacion interfaz;

    public GenerarPDFCommand(VentaPDF pdfGenerator, InterFacturacion interfaz) {
        this.pdfGenerator = pdfGenerator;
        this.interfaz = interfaz;
    }

    @Override
    public void execute() {
        pdfGenerator.DatosCliente(interfaz.idCliente);
        pdfGenerator.generarFacturaPDF();
    }

    @Override
    public void undo() {
        // Opcional: Eliminar el PDF generado (si es necesario)
    }
}