/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class HTMLFactura implements FacturaFormat {
    @Override
    public void generarFactura(String nombreCliente, String cedulaCliente, String telefonoCliente,
                             String direccionCliente, String fechaActual, String[][] productos, 
                             String totalPagar) {
        try {
            String nombreArchivo = "Factura_" + nombreCliente.replace(" ", "_") + "_" + 
                                 fechaActual.replace("/", "_") + ".html";
            String rutaCompleta = "src/html/" + nombreArchivo;
            
            FileWriter writer = new FileWriter(rutaCompleta);
            
            writer.write("<!DOCTYPE html>\n");
            writer.write("<html lang='es'>\n");
            writer.write("<head>\n");
            writer.write("    <meta charset='UTF-8'>\n");
            writer.write("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n");
            writer.write("    <title>Factura " + nombreCliente + "</title>\n");
            writer.write("    <style>\n");
            writer.write("        body { font-family: Arial, sans-serif; margin: 0; padding: 20px; }\n");
            writer.write("        .header { text-align: center; margin-bottom: 20px; }\n");
            writer.write("        .title { font-size: 24px; font-weight: bold; margin-bottom: 10px; }\n");
            writer.write("        .empresa-info { margin-bottom: 30px; }\n");
            writer.write("        .cliente-info { margin-bottom: 20px; }\n");
            writer.write("        table { width: 100%; border-collapse: collapse; margin-bottom: 20px; }\n");
            writer.write("        th, td { padding: 8px; text-align: left; border-bottom: 1px solid #ddd; }\n");
            writer.write("        th { background-color: #f2f2f2; font-weight: bold; }\n");
            writer.write("        .total { text-align: right; font-weight: bold; font-size: 18px; }\n");
            writer.write("        .footer { text-align: center; margin-top: 30px; font-style: italic; }\n");
            writer.write("    </style>\n");
            writer.write("</head>\n");
            writer.write("<body>\n");
            
            // Encabezado
            writer.write("    <div class='header'>\n");
            writer.write("        <div class='title'>FACTURA</div>\n");
            writer.write("        <div>MISCELÁNEA CALICANTO</div>\n");
            writer.write("        <div>Av. Principal #123 - Ciudad, País</div>\n");
            writer.write("        <div>Tel: 555-123456 - RUC: 1234567890123</div>\n");
            writer.write("    </div>\n");
            
            // Información de la factura y fecha
            writer.write("    <div class='empresa-info'>\n");
            writer.write("        <div><strong>Fecha:</strong> " + fechaActual + "</div>\n");
            writer.write("    </div>\n");
            
            // Información del cliente
            writer.write("    <div class='cliente-info'>\n");
            writer.write("        <h3>DATOS DEL CLIENTE</h3>\n");
            writer.write("        <div><strong>Nombre:</strong> " + nombreCliente + "</div>\n");
            writer.write("        <div><strong>Cédula:</strong> " + cedulaCliente + "</div>\n");
            writer.write("        <div><strong>Teléfono:</strong> " + telefonoCliente + "</div>\n");
            writer.write("        <div><strong>Dirección:</strong> " + direccionCliente + "</div>\n");
            writer.write("    </div>\n");
            
            // Tabla de productos
            writer.write("    <table>\n");
            writer.write("        <thead>\n");
            writer.write("            <tr>\n");
            writer.write("                <th>Cant.</th>\n");
            writer.write("                <th>Descripción</th>\n");
            writer.write("                <th>P. Unit.</th>\n");
            writer.write("                <th>IVA</th>\n");
            writer.write("                <th>Total</th>\n");
            writer.write("            </tr>\n");
            writer.write("        </thead>\n");
            writer.write("        <tbody>\n");
            
            // Productos
            for (String[] producto : productos) {
                writer.write("            <tr>\n");
                writer.write("                <td>" + producto[1] + "</td>\n");
                writer.write("                <td>" + producto[0] + "</td>\n");
                writer.write("                <td>$" + producto[2] + "</td>\n");
                writer.write("                <td>12%</td>\n");
                writer.write("                <td>$" + producto[3] + "</td>\n");
                writer.write("            </tr>\n");
            }
            
            writer.write("        </tbody>\n");
            writer.write("    </table>\n");
            
            // Total
            writer.write("    <div class='total'>\n");
            writer.write("        TOTAL A PAGAR: $" + totalPagar + "\n");
            writer.write("    </div>\n");
            
            // Pie de página
            writer.write("    <div class='footer'>\n");
            writer.write("        ¡Gracias por su compra!\n");
            writer.write("    </div>\n");
            
            writer.write("</body>\n");
            writer.write("</html>");
            
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al generar HTML: " + e);
        }
    }

    @Override
    public String getExtension() {
        return "html";
    }
}