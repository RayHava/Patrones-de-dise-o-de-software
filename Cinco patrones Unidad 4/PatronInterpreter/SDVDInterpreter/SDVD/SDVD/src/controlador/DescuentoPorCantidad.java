package controlador;

public class DescuentoPorCantidad implements ExpresionDescuento {
    private int cantidadMinima;
    private double descuentoFijo;
    
    public DescuentoPorCantidad(int cantidadMinima, double descuentoFijo) {
        this.cantidadMinima = cantidadMinima;
        this.descuentoFijo = descuentoFijo;
    }
    
    @Override
    public double calcularDescuento(double precio, int cantidad) {
        return cantidad >= cantidadMinima ? descuentoFijo : 0;
    }
    
    @Override
    public String getDescripcion() {
        return "Descuento de $" + descuentoFijo + " por comprar " + cantidadMinima + " o más unidades";
    }
}