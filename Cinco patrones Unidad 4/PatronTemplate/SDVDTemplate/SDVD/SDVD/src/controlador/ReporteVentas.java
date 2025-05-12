package controlador;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReporteVentas extends ReporteTemplate {
    
    public ReporteVentas() {
        this.tituloReporte = "Reporte de Ventas";
        this.nombreArchivo = "Reporte_Ventas";
    }
    
    @Override
    protected void generarContenido() throws DocumentException {
        float[] columnsWidths = {3, 9, 4, 5, 3};
        PdfPTable tabla = new PdfPTable(columnsWidths);
        tabla.addCell("Codigo");
        tabla.addCell("Cliente");
        tabla.addCell("Tot. Pagar");
        tabla.addCell("Fecha Venta");
        tabla.addCell("Estado");
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select cv.idCabeceraVenta as id, concat(c.nombre, ' ', c.apellido) as cliente, "
                            + "cv.valorPagar as total, cv.fechaVenta as fecha, cv.estado "
                            + "from tb_cabecera_venta as cv, tb_cliente as c "
                            + "where cv.idCliente = c.idCliente;");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                tabla.addCell(rs.getString(1));
                tabla.addCell(rs.getString(2));
                tabla.addCell(rs.getString(3));
                tabla.addCell(rs.getString(4));
                tabla.addCell(rs.getString(5));
            }
            
            documento.add(tabla);
        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL: " + e);
        }
    }
    
    @Override
    protected PdfPTable crearTabla() throws DocumentException {
        return null; // No se usa porque se crea directamente en generarContenido()
    }
    
    @Override
    protected void llenarTabla(PdfPTable tabla) throws DocumentException, SQLException {
        // No se usa porque se maneja todo en generarContenido()
    }
}