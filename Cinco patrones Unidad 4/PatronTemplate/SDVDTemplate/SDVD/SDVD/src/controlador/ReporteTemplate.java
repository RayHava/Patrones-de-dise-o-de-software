package controlador;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public abstract class ReporteTemplate {
    protected Document documento;
    protected String tituloReporte;
    protected String nombreArchivo;
    
    public final void generarReporte() {
        documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + nombreArchivo + ".pdf"));
            
            // Configuración común del documento
            configurarDocumento();
            
            documento.open();
            
            // Agregar cabecera común
            agregarCabecera();
            
            // Agregar título específico
            agregarTitulo();
            
            // Generar contenido específico del reporte
            generarContenido();
            
            documento.close();
            
            JOptionPane.showMessageDialog(null, "Reporte creado: " + nombreArchivo);
            
        } catch (DocumentException | FileNotFoundException e) {
            System.out.println("Error al crear el documento: " + e);
        } catch (IOException e) {
            System.out.println("Error de IO: " + e);
        }
    }
    
    private void configurarDocumento() throws DocumentException, IOException {
        // Configuración común para todos los reportes
        documento.setPageSize(PageSize.A4);
        documento.setMargins(30, 30, 30, 30);
    }
    
    private void agregarCabecera() throws DocumentException, IOException {
        Image header = Image.getInstance("src/img/header1.jpg");
        header.scaleToFit(650, 1000);
        header.setAlignment(Chunk.ALIGN_CENTER);
        documento.add(header);
        
        Paragraph parrafo = new Paragraph();
        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
        parrafo.add("Reporte creado por \nMiscelanea Calicanto\n\n");
        parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
        documento.add(parrafo);
    }
    
    private void agregarTitulo() throws DocumentException {
        Paragraph titulo = new Paragraph(tituloReporte + "\n\n");
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        titulo.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.BLACK));
        documento.add(titulo);
    }
    
    // Métodos abstractos que deben implementar las subclases
    protected abstract void generarContenido() throws DocumentException;
    protected abstract PdfPTable crearTabla() throws DocumentException;
    protected abstract void llenarTabla(PdfPTable tabla) throws DocumentException, SQLException;
}