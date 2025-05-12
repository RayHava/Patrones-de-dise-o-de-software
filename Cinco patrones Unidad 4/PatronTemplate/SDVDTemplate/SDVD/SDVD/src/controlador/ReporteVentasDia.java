package controlador;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReporteVentasDia extends ReporteTemplate {
    
    public ReporteVentasDia() {
        this.tituloReporte = "Reporte de Ventas del Día";
        this.nombreArchivo = "Reporte_Ventas_Dia";
    }
    
    @Override
    protected void generarContenido() throws DocumentException {
        PdfPTable tabla = crearTabla();
        double totalVentasDia = 0.0;
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT cv.idCabeceraVenta AS id, "
                    + "CONCAT(c.nombre, ' ', c.apellido) AS cliente, "
                    + "cv.valorPagar AS total, cv.fechaVenta AS fecha, cv.estado "
                    + "FROM tb_cabecera_venta AS cv "
                    + "JOIN tb_cliente AS c ON cv.idCliente = c.idCliente "
                    + "WHERE DATE(cv.fechaVenta) = CURRENT_DATE;");
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                do {
                    tabla.addCell(rs.getString(1));
                    tabla.addCell(rs.getString(2));
                    tabla.addCell(rs.getString(3));
                    tabla.addCell(rs.getString(4));
                    tabla.addCell(rs.getString(5));
                    
                    totalVentasDia += rs.getDouble(3);
                } while (rs.next());
                
                documento.add(tabla);
                documento.add(new Paragraph("\n\nTotal de Ventas del Día: " + totalVentasDia + " MXN"));
            } else {
                documento.add(new Paragraph("\n\nNo se han realizado ventas hoy."));
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL: " + e);
        }
    }
    
    @Override
    protected PdfPTable crearTabla() throws DocumentException {
        float[] columnsWidths = {3, 9, 4, 5, 3};
        PdfPTable tabla = new PdfPTable(columnsWidths);
        tabla.addCell("Codigo");
        tabla.addCell("Cliente");
        tabla.addCell("Tot. Pagar");
        tabla.addCell("Fecha Venta");
        tabla.addCell("Estado");
        return tabla;
    }
    
    @Override
    protected void llenarTabla(PdfPTable tabla) throws DocumentException, SQLException {
        // Implementación vacía porque ya se maneja en generarContenido()
    }
}