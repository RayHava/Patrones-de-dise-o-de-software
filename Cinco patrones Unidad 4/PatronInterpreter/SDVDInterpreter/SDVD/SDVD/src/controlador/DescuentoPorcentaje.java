package controlador;

public class DescuentoPorcentaje implements ExpresionDescuento {
    private double porcentaje;
    
    public DescuentoPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    @Override
    public double calcularDescuento(double precio, int cantidad) {
        return (precio * cantidad) * (porcentaje / 100);
    }
    
    @Override
    public String getDescripcion() {
        return porcentaje + "% de descuento";
    }
}