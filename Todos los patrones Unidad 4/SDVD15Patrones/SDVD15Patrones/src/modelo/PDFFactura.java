/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDFFactura implements FacturaFormat {
    private static final Font TITLE_FONT = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
    private static final Font HEADER_FONT = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
    private static final Font NORMAL_FONT = new Font(Font.FontFamily.HELVETICA, 10);
    
    @Override
    public void generarFactura(String nombreCliente, String cedulaCliente, String telefonoCliente,
                             String direccionCliente, String fechaActual, String[][] productos, 
                             String totalPagar) {
        try {
            String nombreArchivo = "Factura_" + nombreCliente.replace(" ", "_") + "_" + 
                                 fechaActual.replace("/", "_") + ".pdf";
            String rutaCompleta = "src/pdf/" + nombreArchivo;
            
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(rutaCompleta));
            doc.open();

            // Encabezado
            Paragraph title = new Paragraph("FACTURA", TITLE_FONT);
            title.setAlignment(Element.ALIGN_CENTER);
            doc.add(title);
            
            doc.add(Chunk.NEWLINE);
            
            // Información de la empresa
            PdfPTable empresaTable = new PdfPTable(2);
            empresaTable.setWidthPercentage(100);
            empresaTable.setWidths(new float[]{30f, 70f});
            
            empresaTable.addCell(createCell("MISCELÁNEA CALICANTO", HEADER_FONT, Element.ALIGN_LEFT, false));
            empresaTable.addCell(createCell("Fecha: " + fechaActual, NORMAL_FONT, Element.ALIGN_RIGHT, false));
            empresaTable.addCell(createCell("Av. Principal #123", NORMAL_FONT, Element.ALIGN_LEFT, false));
            empresaTable.addCell(createCell("Tel: 555-123456", NORMAL_FONT, Element.ALIGN_RIGHT, false));
            empresaTable.addCell(createCell("Ciudad, País", NORMAL_FONT, Element.ALIGN_LEFT, false));
            empresaTable.addCell(createCell("RUC: 1234567890123", NORMAL_FONT, Element.ALIGN_RIGHT, false));
            
            doc.add(empresaTable);
            doc.add(Chunk.NEWLINE);
            
            // Información del cliente
            PdfPTable clienteTable = new PdfPTable(2);
            clienteTable.setWidthPercentage(100);
            clienteTable.setWidths(new float[]{20f, 80f});
            
            clienteTable.addCell(createCell("CLIENTE:", HEADER_FONT, Element.ALIGN_LEFT, true));
            clienteTable.addCell(createCell("", HEADER_FONT, Element.ALIGN_LEFT, false));
            clienteTable.addCell(createCell("Nombre:", NORMAL_FONT, Element.ALIGN_LEFT, false));
            clienteTable.addCell(createCell(nombreCliente, NORMAL_FONT, Element.ALIGN_LEFT, false));
            clienteTable.addCell(createCell("Cédula:", NORMAL_FONT, Element.ALIGN_LEFT, false));
            clienteTable.addCell(createCell(cedulaCliente, NORMAL_FONT, Element.ALIGN_LEFT, false));
            clienteTable.addCell(createCell("Teléfono:", NORMAL_FONT, Element.ALIGN_LEFT, false));
            clienteTable.addCell(createCell(telefonoCliente, NORMAL_FONT, Element.ALIGN_LEFT, false));
            clienteTable.addCell(createCell("Dirección:", NORMAL_FONT, Element.ALIGN_LEFT, false));
            clienteTable.addCell(createCell(direccionCliente, NORMAL_FONT, Element.ALIGN_LEFT, false));
            
            doc.add(clienteTable);
            doc.add(Chunk.NEWLINE);
            
            // Tabla de productos
            PdfPTable productosTable = new PdfPTable(5);
            productosTable.setWidthPercentage(100);
            productosTable.setWidths(new float[]{10f, 40f, 15f, 15f, 20f});
            
            // Encabezados de la tabla
            productosTable.addCell(createCell("Cant.", HEADER_FONT, Element.ALIGN_CENTER, true));
            productosTable.addCell(createCell("Descripción", HEADER_FONT, Element.ALIGN_LEFT, true));
            productosTable.addCell(createCell("P. Unit.", HEADER_FONT, Element.ALIGN_RIGHT, true));
            productosTable.addCell(createCell("IVA", HEADER_FONT, Element.ALIGN_RIGHT, true));
            productosTable.addCell(createCell("Total", HEADER_FONT, Element.ALIGN_RIGHT, true));
            
            // Agregar productos
            for (String[] producto : productos) {
                productosTable.addCell(createCell(producto[1], NORMAL_FONT, Element.ALIGN_CENTER, false));
                productosTable.addCell(createCell(producto[0], NORMAL_FONT, Element.ALIGN_LEFT, false));
                productosTable.addCell(createCell("$" + producto[2], NORMAL_FONT, Element.ALIGN_RIGHT, false));
                productosTable.addCell(createCell("12%", NORMAL_FONT, Element.ALIGN_RIGHT, false));
                productosTable.addCell(createCell("$" + producto[3], NORMAL_FONT, Element.ALIGN_RIGHT, false));
            }
            
            doc.add(productosTable);
            doc.add(Chunk.NEWLINE);
            
            // Total
            PdfPTable totalTable = new PdfPTable(2);
            totalTable.setWidthPercentage(50);
            totalTable.setHorizontalAlignment(Element.ALIGN_RIGHT);
            totalTable.setWidths(new float[]{30f, 20f});
            
            totalTable.addCell(createCell("TOTAL A PAGAR:", HEADER_FONT, Element.ALIGN_RIGHT, false));
            totalTable.addCell(createCell("$" + totalPagar, HEADER_FONT, Element.ALIGN_RIGHT, false));
            
            doc.add(totalTable);
            doc.add(Chunk.NEWLINE);
            
            // Mensaje final
            Paragraph gracias = new Paragraph("¡Gracias por su compra!", NORMAL_FONT);
            gracias.setAlignment(Element.ALIGN_CENTER);
            doc.add(gracias);
            
            doc.close();
        } catch (DocumentException | IOException e) {
            System.out.println("Error al generar PDF: " + e);
        }
    }
    
    private PdfPCell createCell(String text, Font font, int alignment, boolean header) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(header ? PdfPCell.BOTTOM : PdfPCell.NO_BORDER);
        if (header) {
            cell.setBorderWidthBottom(2f);
            cell.setPaddingBottom(5f);
        }
        return cell;
    }

    @Override
    public String getExtension() {
        return "pdf";
    }
}