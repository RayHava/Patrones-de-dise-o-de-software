package controlador;

public class Reportes {

    public void ReportesClientes() {
        ReporteTemplate reporte = new ReporteClientes();
        reporte.generarReporte();
    }
    
    public void ReportesProductos() {
        ReporteTemplate reporte = new ReporteProductos();
        reporte.generarReporte();
    }
    
    public void ReportesCategorias() {
        ReporteTemplate reporte = new ReporteCategorias();
        reporte.generarReporte();
    }
    
    public void ReportesVentas() {
        ReporteTemplate reporte = new ReporteVentas();
        reporte.generarReporte();
    }
    
    public void ReportesVentasDia() {
        ReporteTemplate reporte = new ReporteVentasDia();
        reporte.generarReporte();
    }
}