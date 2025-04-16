/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author hecto
 */
public class ReporteMemento {
    private final String estado;
    private final String tipoReporte;
    private final String rutaArchivo;

    public ReporteMemento(String estado, String tipoReporte, String rutaArchivo) {
        this.estado = estado;
        this.tipoReporte = tipoReporte;
        this.rutaArchivo = rutaArchivo;
    }

    // Getters
    public String getEstado() { return estado; }
    public String getTipoReporte() { return tipoReporte; }
    public String getRutaArchivo() { return rutaArchivo; }
}

