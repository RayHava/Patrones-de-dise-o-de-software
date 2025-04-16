/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.io.IOException;

public interface ReporteFactory {
    Document crearDocumento() throws DocumentException, FileNotFoundException;
    void agregarContenido(Document documento) throws DocumentException, SQLException, IOException;
    String obtenerNombreArchivo();
}