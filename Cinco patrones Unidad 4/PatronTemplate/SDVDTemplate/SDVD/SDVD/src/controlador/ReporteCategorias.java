package controlador;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReporteCategorias extends ReporteTemplate {
    
    public ReporteCategorias() {
        this.tituloReporte = "Reporte de Categorías";
        this.nombreArchivo = "Reporte_Categorias";
    }
    
    @Override
    protected void generarContenido() throws DocumentException {
        PdfPTable tabla = crearTabla();
        try {
            llenarTabla(tabla);
            documento.add(tabla);
        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL: " + e);
        }
    }
    
    @Override
    protected PdfPTable crearTabla() throws DocumentException {
        PdfPTable tabla = new PdfPTable(3);
        tabla.addCell("Codigo");
        tabla.addCell("Descripcion");
        tabla.addCell("Estado");
        return tabla;
    }
    
    @Override
    protected void llenarTabla(PdfPTable tabla) throws DocumentException, SQLException {
        Connection cn = Conexion.conectar();
        PreparedStatement pst = cn.prepareStatement("select * from tb_categoria");
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()) {
            tabla.addCell(rs.getString(1));
            tabla.addCell(rs.getString(2));
            tabla.addCell(rs.getString(3));
        }
    }
}