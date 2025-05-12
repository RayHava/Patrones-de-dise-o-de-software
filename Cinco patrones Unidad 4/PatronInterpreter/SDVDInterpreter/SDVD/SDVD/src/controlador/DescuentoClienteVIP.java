package controlador;

public class DescuentoClienteVIP implements ExpresionDescuento {
    private boolean esVIP;
    
    public DescuentoClienteVIP(boolean esVIP) {
        this.esVIP = esVIP;
    }
    
    @Override
    public double calcularDescuento(double precio, int cantidad) {
        return esVIP ? (precio * cantidad) * 0.10 : 0; // 10% de descuento para VIPs
    }
    
    @Override
    public String getDescripcion() {
        return esVIP ? "10% de descuento VIP" : "Sin descuento VIP";
    }
}