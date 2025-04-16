/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.File;
import modelo.HTMLFactura;
import modelo.PDFFactura;

public class FacturacionFacade {
    private FacturaAdapter adapter;

    public FacturacionFacade(String formato) {
        crearCarpetasSiNoExisten(); // Asegurar que las carpetas existan
        setFormato(formato);
    }

    public void setFormato(String formato) {
        if (formato.equalsIgnoreCase("PDF")) {
            this.adapter = new FacturaAdapter(new PDFFactura());
        } else if (formato.equalsIgnoreCase("HTML")) {
            this.adapter = new FacturaAdapter(new HTMLFactura());
        }
    }
    
    private void crearCarpetasSiNoExisten() {
        File carpetaPdf = new File("src/pdf");
        File carpetaHtml = new File("src/html");
        
        if (!carpetaPdf.exists()) {
            carpetaPdf.mkdirs();
            System.out.println("Carpeta PDF creada");
        }
        
        if (!carpetaHtml.exists()) {
            carpetaHtml.mkdirs();
            System.out.println("Carpeta HTML creada");
        }
    }

   public String generarFacturaCompleta(String nombreCliente, String cedulaCliente, String telefonoCliente,
                                 String direccionCliente, String fechaActual, String[][] productos, 
                                 String totalPagar) {
    if (adapter == null) {
        System.err.println("Error: No se ha configurado un adaptador de factura");
        return null;
    }
    
    try {
        System.out.println("Generando factura en formato " + adapter.getFormato());
        String nombreArchivo = "Factura_" + nombreCliente.replace(" ", "_") + "_" + 
                             fechaActual.replace("/", "_") + "." + adapter.getExtension();
        
        String rutaCompleta = "src/" + adapter.getExtension() + "/" + nombreArchivo;
        
        File carpeta = new File("src/" + adapter.getExtension());
        if (!carpeta.exists()) {
            if (!carpeta.mkdirs()) {
                System.err.println("Error al crear directorio: " + carpeta.getAbsolutePath());
                return null;
            }
        }
        
        adapter.generar(nombreCliente, cedulaCliente, telefonoCliente,
                      direccionCliente, fechaActual, productos, totalPagar);
        
        System.out.println("Documento generado en: " + rutaCompleta);
        return rutaCompleta;
    } catch (Exception e) {
        System.err.println("Error en FacturacionFacade: " + e.getMessage());
        e.printStackTrace();
        return null;
    }
}
}