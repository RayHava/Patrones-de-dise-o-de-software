/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

public class ReporteOriginator {
    private String estado;
    private String tipoReporte;
    private String rutaArchivo;

    public void setEstado(String estado, String tipoReporte, String rutaArchivo) {
        this.estado = estado;
        this.tipoReporte = tipoReporte;
        this.rutaArchivo = rutaArchivo;
    }

    public ReporteMemento guardarEstado() {
        return new ReporteMemento(estado, tipoReporte, rutaArchivo);
    }

    public void restaurarEstado(ReporteMemento memento) {
        this.estado = memento.getEstado();
        this.tipoReporte = memento.getTipoReporte();
        this.rutaArchivo = memento.getRutaArchivo();
    }
}
