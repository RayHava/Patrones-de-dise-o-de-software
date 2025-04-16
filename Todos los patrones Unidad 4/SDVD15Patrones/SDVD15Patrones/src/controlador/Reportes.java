package controlador;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.ComponenteReporte;
import modelo.ReporteFactory;

public class Reportes {
    
    /* ========== IMPLEMENTACIÓN FACTORY METHOD ========== */
    
    // Clases internas para cada tipo de reporte
    private class ReporteClientesFactory implements ReporteFactory {
        @Override public String obtenerNombreArchivo() { return "Reporte_Clientes.pdf"; }
        
        @Override
        public Document crearDocumento() throws DocumentException, FileNotFoundException {
            return crearDocumentoBase(obtenerNombreArchivo());
        }

        @Override
        public void agregarContenido(Document documento) throws DocumentException, SQLException, IOException {
            agregarEncabezado(documento, "Reporte de Clientes", "Listado completo de clientes");
            
            PdfPTable tabla = new PdfPTable(5);
            agregarCeldaEncabezado(tabla, "ID");
            agregarCeldaEncabezado(tabla, "Nombre");
            agregarCeldaEncabezado(tabla, "Cédula");
            agregarCeldaEncabezado(tabla, "Teléfono");
            agregarCeldaEncabezado(tabla, "Dirección");
            
            Connection cn = Conexion.getConexion();
            PreparedStatement pst = cn.prepareStatement(
                "SELECT idCliente, CONCAT(nombre, ' ', apellido), cedula, telefono, direccion FROM tb_cliente");
            llenarTabla(tabla, pst);
            
            documento.add(tabla);
        }
    }
    
    private class ReporteUsuariosFactory implements ReporteFactory {
        @Override public String obtenerNombreArchivo() { return "Reporte_Usuarios.pdf"; }
        
        @Override
        public Document crearDocumento() throws DocumentException, FileNotFoundException {
            return crearDocumentoBase(obtenerNombreArchivo());
        }

        @Override
        public void agregarContenido(Document documento) throws DocumentException, SQLException, IOException {
            agregarEncabezado(documento, "Reporte de Usuarios", "Listado de usuarios del sistema");
            
            PdfPTable tabla = new PdfPTable(4);
            agregarCeldaEncabezado(tabla, "ID");
            agregarCeldaEncabezado(tabla, "Usuario");
            agregarCeldaEncabezado(tabla, "Nombre Completo");
            agregarCeldaEncabezado(tabla, "Teléfono");
            
            Connection cn = Conexion.getConexion();
            PreparedStatement pst = cn.prepareStatement(
                "SELECT idUsuario, usuario, CONCAT(nombre, ' ', apellido), telefono FROM tb_usuario");
            llenarTabla(tabla, pst);
            
            documento.add(tabla);
        }
    }
    
    private class ReporteProductosFactory implements ReporteFactory {
        @Override public String obtenerNombreArchivo() { return "Reporte_Productos.pdf"; }
        
        @Override
        public Document crearDocumento() throws DocumentException, FileNotFoundException {
            return crearDocumentoBase(obtenerNombreArchivo());
        }

        @Override
        public void agregarContenido(Document documento) throws DocumentException, SQLException, IOException {
            agregarEncabezado(documento, "Reporte de Productos", "Inventario de productos");
            
            PdfPTable tabla = new PdfPTable(7);
            float[] widths = {1, 3, 2, 2, 3, 2, 3};
            tabla.setWidths(widths);
            
            agregarCeldaEncabezado(tabla, "ID");
            agregarCeldaEncabezado(tabla, "Nombre");
            agregarCeldaEncabezado(tabla, "Cantidad");
            agregarCeldaEncabezado(tabla, "Precio");
            agregarCeldaEncabezado(tabla, "Descripción");
            agregarCeldaEncabezado(tabla, "IVA %");
            agregarCeldaEncabezado(tabla, "Categoría");
            
            Connection cn = Conexion.getConexion();
            PreparedStatement pst = cn.prepareStatement(
                "SELECT p.idProducto, p.nombre, p.cantidad, p.precio, p.descripcion, p.porcentajeIva, c.descripcion " +
                "FROM tb_producto p JOIN tb_categoria c ON p.idCategoria = c.idCategoria");
            llenarTabla(tabla, pst);
            
            documento.add(tabla);
        }
    }
    
    private class ReporteCategoriasFactory implements ReporteFactory {
        @Override public String obtenerNombreArchivo() { return "Reporte_Categorias.pdf"; }
        
        @Override
        public Document crearDocumento() throws DocumentException, FileNotFoundException {
            return crearDocumentoBase(obtenerNombreArchivo());
        }

        @Override
        public void agregarContenido(Document documento) throws DocumentException, SQLException, IOException {
            agregarEncabezado(documento, "Reporte de Categorías", "Listado de categorías de productos");
            
            PdfPTable tabla = new PdfPTable(3);
            agregarCeldaEncabezado(tabla, "ID");
            agregarCeldaEncabezado(tabla, "Descripción");
            agregarCeldaEncabezado(tabla, "Estado");
            
            Connection cn = Conexion.getConexion();
            PreparedStatement pst = cn.prepareStatement(
                "SELECT idCategoria, descripcion, estado FROM tb_categoria");
            llenarTabla(tabla, pst);
            
            documento.add(tabla);
        }
    }
    
    private class ReporteVentasFactory implements ReporteFactory {
        @Override public String obtenerNombreArchivo() { return "Reporte_Ventas.pdf"; }
        
        @Override
        public Document crearDocumento() throws DocumentException, FileNotFoundException {
            return crearDocumentoBase(obtenerNombreArchivo());
        }

        @Override
        public void agregarContenido(Document documento) throws DocumentException, SQLException, IOException {
            agregarEncabezado(documento, "Reporte de Ventas", "Historial completo de ventas");
            
            PdfPTable tabla = new PdfPTable(5);
            float[] widths = {1, 4, 2, 2, 1};
            tabla.setWidths(widths);
            
            agregarCeldaEncabezado(tabla, "ID");
            agregarCeldaEncabezado(tabla, "Cliente");
            agregarCeldaEncabezado(tabla, "Total");
            agregarCeldaEncabezado(tabla, "Fecha");
            agregarCeldaEncabezado(tabla, "Estado");
            
            Connection cn = Conexion.getConexion();
            PreparedStatement pst = cn.prepareStatement(
                "SELECT cv.idCabeceraVenta, CONCAT(c.nombre, ' ', c.apellido), " +
                "cv.valorPagar, cv.fechaVenta, cv.estado " +
                "FROM tb_cabecera_venta cv JOIN tb_cliente c ON cv.idCliente = c.idCliente");
            llenarTabla(tabla, pst);
            
            documento.add(tabla);
        }
    }
    
    private class ReporteVentasDiaFactory implements ReporteFactory {
        @Override public String obtenerNombreArchivo() { return "Reporte_Ventas_Dia.pdf"; }
        
        @Override
        public Document crearDocumento() throws DocumentException, FileNotFoundException {
            return crearDocumentoBase(obtenerNombreArchivo());
        }

        @Override
        public void agregarContenido(Document documento) throws DocumentException, SQLException, IOException {
            agregarEncabezado(documento, "Reporte de Ventas del Día", "Ventas realizadas hoy");
            
            PdfPTable tabla = new PdfPTable(5);
            float[] widths = {1, 4, 2, 2, 1};
            tabla.setWidths(widths);
            
            agregarCeldaEncabezado(tabla, "ID");
            agregarCeldaEncabezado(tabla, "Cliente");
            agregarCeldaEncabezado(tabla, "Total");
            agregarCeldaEncabezado(tabla, "Fecha");
            agregarCeldaEncabezado(tabla, "Estado");
            
            Connection cn = Conexion.getConexion();
            PreparedStatement pst = cn.prepareStatement(
                "SELECT cv.idCabeceraVenta, CONCAT(c.nombre, ' ', c.apellido), " +
                "cv.valorPagar, cv.fechaVenta, cv.estado " +
                "FROM tb_cabecera_venta cv JOIN tb_cliente c ON cv.idCliente = c.idCliente " +
                "WHERE DATE(cv.fechaVenta) = CURRENT_DATE");
            
            double totalVentas = llenarTablaConTotal(tabla, pst);
            
            documento.add(tabla);
            
            // Agregar total del día
            Paragraph total = new Paragraph("\n\nTotal de ventas del día: " + totalVentas, 
                new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
            total.setAlignment(Element.ALIGN_RIGHT);
            documento.add(total);
        }
    }
    
    /* ========== MÉTODOS BASE PARA FACTORY ========== */
    
    private Document crearDocumentoBase(String nombreArchivo) throws DocumentException, FileNotFoundException {
        String ruta = System.getProperty("user.home");
        Document documento = new Document();
        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + nombreArchivo));
        return documento;
    }
    
    private void agregarEncabezado(Document documento, String titulo, String subtitulo) 
            throws DocumentException, IOException {
        Image header = Image.getInstance("src/img/header1.jpg");
        header.scaleToFit(650, 1000);
        header.setAlignment(Element.ALIGN_CENTER);
        
        Paragraph parrafo = new Paragraph();
        parrafo.setAlignment(Element.ALIGN_CENTER);
        parrafo.add("Reporte creado por \nMiscelanea Calicanto\n\n");
        parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
        parrafo.add(titulo + "\n\n");
        parrafo.add(subtitulo + "\n\n");

        documento.add(header);
        documento.add(parrafo);
    }
    
    private void agregarCeldaEncabezado(PdfPTable tabla, String texto) {
        PdfPCell celda = new PdfPCell(new Phrase(texto));
        celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabla.addCell(celda);
    }
    
    private void llenarTabla(PdfPTable tabla, PreparedStatement pst) throws SQLException {
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            for (int i = 1; i <= tabla.getNumberOfColumns(); i++) {
                tabla.addCell(rs.getString(i) != null ? rs.getString(i) : "");
            }
        }
    }
    
    private double llenarTablaConTotal(PdfPTable tabla, PreparedStatement pst) throws SQLException {
        double total = 0;
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            for (int i = 1; i <= tabla.getNumberOfColumns(); i++) {
                tabla.addCell(rs.getString(i) != null ? rs.getString(i) : "");
            }
            total += rs.getDouble(3); // Sumar la columna de total
        }
        return total;
    }
    
    /* ========== MÉTODOS PÚBLICOS PARA GENERAR REPORTES ========== */
    
    public void ReportesClientes() {
        generarReporteConMemento(new ReporteClientesFactory());
    }
    
    public void ReportesUsuarios() {
        generarReporteConMemento(new ReporteUsuariosFactory());
    }
    
    public void ReportesProductos() {
        generarReporteConMemento(new ReporteProductosFactory());
    }
    
    public void ReportesCategorias() {
        generarReporteConMemento(new ReporteCategoriasFactory());
    }
    
    public void ReportesVentas() {
        generarReporteConMemento(new ReporteVentasFactory());
    }
    
    public void ReportesVentasDia() {
        generarReporteConMemento(new ReporteVentasDiaFactory());
    }
    
    /* ========== IMPLEMENTACIÓN MEMENTO ========== */
    
    public void generarReporteConMemento(ReporteFactory factory) {
        ReporteOriginator originator = new ReporteOriginator();
        originator.setEstado("Generando", factory.getClass().getSimpleName(), 
            System.getProperty("user.home") + "/Desktop/" + factory.obtenerNombreArchivo());
        
        ReporteMemento memento = originator.guardarEstado();
        
        try {
            Document documento = factory.crearDocumento();
            documento.open();
            factory.agregarContenido(documento);
            documento.close();
            
            originator.setEstado("Completado", factory.getClass().getSimpleName(), 
                System.getProperty("user.home") + "/Desktop/" + factory.obtenerNombreArchivo());
            
            JOptionPane.showMessageDialog(null, "Reporte generado exitosamente: " + factory.obtenerNombreArchivo());
        } catch (Exception e) {
            originator.restaurarEstado(memento);
            JOptionPane.showMessageDialog(null, 
                "Error al generar reporte. Estado restaurado.", 
                "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al generar reporte: " + e);
        }
    }
    
    /* ========== IMPLEMENTACIÓN COMPOSITE ========== */
    
    public class EncabezadoComponente implements ComponenteReporte {
        private final String titulo;
        private final String subtitulo;
        
        public EncabezadoComponente(String titulo, String subtitulo) {
            this.titulo = titulo;
            this.subtitulo = subtitulo;
        }
        
        @Override
        public void agregar(Document documento) throws DocumentException, IOException {
            agregarEncabezado(documento, titulo, subtitulo);
        }
    }
    
    public class TablaComponente implements ComponenteReporte {
        private final String consulta;
        private final String[] encabezados;
        
        public TablaComponente(String consulta, String[] encabezados) {
            this.consulta = consulta;
            this.encabezados = encabezados;
        }
        
        @Override
        public void agregar(Document documento) throws DocumentException, SQLException {
            PdfPTable tabla = new PdfPTable(encabezados.length);
            
            for (String encabezado : encabezados) {
                agregarCeldaEncabezado(tabla, encabezado);
            }
            
            Connection cn = Conexion.getConexion();
            PreparedStatement pst = cn.prepareStatement(consulta);
            llenarTabla(tabla, pst);
            
            documento.add(tabla);
        }
    }
    
    public void generarReporteCompleto() {
        try {
            String ruta = System.getProperty("user.home");
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Completo.pdf"));
            
            documento.open();
            
            // Crear reporte compuesto
            ReporteCompuesto reporte = new ReporteCompuesto();
            
            // Agregar componentes
            reporte.agregarComponente(new EncabezadoComponente(
                "Reporte Completo del Sistema", 
                "Resumen general de todas las áreas"));
            
            reporte.agregarComponente(new TablaComponente(
                "SELECT COUNT(*) as total, 'Clientes' as tipo FROM tb_cliente " +
                "UNION SELECT COUNT(*), 'Productos' FROM tb_producto " +
                "UNION SELECT COUNT(*), 'Usuarios' FROM tb_usuario " +
                "UNION SELECT COUNT(*), 'Ventas Hoy' FROM tb_cabecera_venta WHERE DATE(fechaVenta) = CURRENT_DATE",
                new String[]{"Cantidad", "Tipo"}));
            
            reporte.agregarComponente(new TablaComponente(
                "SELECT c.descripcion as Categoria, COUNT(p.idProducto) as Productos, " +
                "SUM(p.cantidad) as Existencia FROM tb_categoria c " +
                "LEFT JOIN tb_producto p ON c.idCategoria = p.idCategoria " +
                "GROUP BY c.descripcion",
                new String[]{"Categoría", "Productos", "Existencia"}));
            
            reporte.agregarComponente(new TablaComponente(
                "SELECT DATE(fechaVenta) as Fecha, COUNT(*) as Ventas, " +
                "SUM(valorPagar) as Total FROM tb_cabecera_venta " +
                "GROUP BY DATE(fechaVenta) ORDER BY Fecha DESC LIMIT 7",
                new String[]{"Fecha", "Ventas", "Total"}));
            
            // Generar el reporte compuesto
            reporte.agregar(documento);
            
            documento.close();
            
            JOptionPane.showMessageDialog(null, "Reporte completo generado exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                "Error al generar reporte completo", 
                "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al generar reporte completo: " + e);
        }
    }
}
