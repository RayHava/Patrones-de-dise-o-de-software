package controlador;

public interface ExpresionDescuento {
    double calcularDescuento(double precio, int cantidad);
    String getDescripcion();
}