/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import java.sql.SQLException;
import java.io.IOException;

public interface ComponenteReporte {
    void agregar(Document documento) throws DocumentException, SQLException, IOException;
}