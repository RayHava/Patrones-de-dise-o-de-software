package controlador;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReporteProductos extends ReporteTemplate {
    
    public ReporteProductos() {
        this.tituloReporte = "Reporte de Productos";
        this.nombreArchivo = "Reporte_Productos";
    }
    
    @Override
    protected void generarContenido() throws DocumentException {
        float[] columnsWidths = {3, 5, 4, 5, 7, 5, 6};
        PdfPTable tabla = new PdfPTable(columnsWidths);
        tabla.addCell("Codigo");
        tabla.addCell("Nombre");
        tabla.addCell("Cant.");
        tabla.addCell("Precio");
        tabla.addCell("Descripcion");
        tabla.addCell("Por. Iva");
        tabla.addCell("Categoria");
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select p.idProducto, p.nombre, p.cantidad, p.precio, p.descripcion, "
                            + "p.porcentajeIva, c.descripcion as categoria, p.estado "
                            + "from tb_producto as p, tb_categoria as c "
                            + "where p.idCategoria = c.idCategoria;");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                tabla.addCell(rs.getString(1));
                tabla.addCell(rs.getString(2));
                tabla.addCell(rs.getString(3));
                tabla.addCell(rs.getString(4));
                tabla.addCell(rs.getString(5));
                tabla.addCell(rs.getString(6));
                tabla.addCell(rs.getString(7));
            }
            
            documento.add(tabla);
        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL: " + e);
        }
    }
    
    // Implementación de métodos abstractos no utilizados en este caso
    @Override
    protected PdfPTable crearTabla() throws DocumentException {
        return null;
    }
    
    @Override
    protected void llenarTabla(PdfPTable tabla) throws DocumentException, SQLException {
    }
}