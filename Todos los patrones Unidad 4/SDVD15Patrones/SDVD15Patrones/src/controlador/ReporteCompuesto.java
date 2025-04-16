/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author hecto
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import java.sql.SQLException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.ComponenteReporte;

public class ReporteCompuesto implements ComponenteReporte {
    private List<ComponenteReporte> componentes = new ArrayList<>();

    public void agregarComponente(ComponenteReporte componente) {
        componentes.add(componente);
    }

    @Override
    public void agregar(Document documento) throws DocumentException, SQLException, IOException {
        for (ComponenteReporte componente : componentes) {
            componente.agregar(documento);
        }
    }
}