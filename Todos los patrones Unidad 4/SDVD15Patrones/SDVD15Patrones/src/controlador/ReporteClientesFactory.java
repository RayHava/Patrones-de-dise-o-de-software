/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ReporteFactory;

/**
 *
 * @author hecto
 */
public class ReporteClientesFactory implements ReporteFactory {
    @Override
    public Document crearDocumento() throws DocumentException, FileNotFoundException {
        String ruta = System.getProperty("user.home");
        Document documento = new Document();
        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Clientes.pdf"));
        return documento;
    }

    @Override
    public void agregarContenido(Document documento) throws DocumentException, SQLException, IOException {
        // Código para agregar contenido específico de clientes
        Image header = Image.getInstance("src/img/header1.jpg");
        header.scaleToFit(650, 1000);
        header.setAlignment(Chunk.ALIGN_CENTER);
        
        Paragraph parrafo = new Paragraph();
        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
        parrafo.add("Reporte creado por \nMiscelanea Calicanto\n\n");
        parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
        parrafo.add("Reporte de Clientes \n\n");

        documento.add(header);
        documento.add(parrafo);

        PdfPTable tabla = new PdfPTable(5);
        tabla.addCell("Codigo");
        tabla.addCell("Nombres");
        tabla.addCell("Cedula");
        tabla.addCell("Telefono");
        tabla.addCell("Direccion");

        Connection cn = Conexion.getConexion();
        PreparedStatement pst = cn.prepareStatement(
                "select idCliente, concat(nombre, ' ', apellido) as nombres, cedula, telefono, direccion from tb_cliente");
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            do {
                tabla.addCell(rs.getString(1));
                tabla.addCell(rs.getString(2));
                tabla.addCell(rs.getString(3));
                tabla.addCell(rs.getString(4));
                tabla.addCell(rs.getString(5));
            } while (rs.next());
            documento.add(tabla);
        }
    }

    @Override
    public String obtenerNombreArchivo() {
        return "Reporte_Clientes.pdf";
    }
    
    public void generarReporte(ReporteFactory factory) {
    try {
        Document documento = factory.crearDocumento();
        documento.open();
        factory.agregarContenido(documento);
        documento.close();
        JOptionPane.showMessageDialog(null, "Reporte " + factory.obtenerNombreArchivo() + " creado");
    } catch (DocumentException | FileNotFoundException e) {
        System.out.println("Error al generar documento: " + e);
    } catch (IOException | SQLException e) {
        System.out.println("Error al procesar contenido: " + e);
    }
}

// Método original modificado para usar el Factory
public void ReportesClientes() {
    generarReporte(new ReporteClientesFactory());
}
}
