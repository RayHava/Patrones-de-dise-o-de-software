package controlador;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReporteClientes extends ReporteTemplate {
    
    public ReporteClientes() {
        this.tituloReporte = "Reporte de Clientes";
        this.nombreArchivo = "Reporte_Clientes";
    }
    
    @Override
    protected void generarContenido() throws DocumentException {
        PdfPTable tabla = crearTabla();
        try {
            llenarTabla(tabla);
        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL: " + e);
        }
        documento.add(tabla);
    }
    
    @Override
    protected PdfPTable crearTabla() throws DocumentException {
        PdfPTable tabla = new PdfPTable(5);
        tabla.addCell("Codigo");
        tabla.addCell("Nombres");
        tabla.addCell("Cedula");
        tabla.addCell("Telefono");
        tabla.addCell("Direccion");
        return tabla;
    }
    
    @Override
    protected void llenarTabla(PdfPTable tabla) throws DocumentException, SQLException {
        Connection cn = Conexion.conectar();
        PreparedStatement pst = cn.prepareStatement(
                "select idCliente, concat(nombre, ' ', apellido) as nombres, cedula, telefono, direccion from tb_cliente");
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()) {
            tabla.addCell(rs.getString(1));
            tabla.addCell(rs.getString(2));
            tabla.addCell(rs.getString(3));
            tabla.addCell(rs.getString(4));
            tabla.addCell(rs.getString(5));
        }
    }
}