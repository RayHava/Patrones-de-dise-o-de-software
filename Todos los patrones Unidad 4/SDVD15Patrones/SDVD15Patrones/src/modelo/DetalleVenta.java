package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DetalleVenta {
    private int idDetalleVenta;
    private int idCabeceraVenta;
    private Producto productFlyweight;
    private int cantidad;
    private double subTotal;
    private double descuento;
    private double iva;
    private double totalPagar;
    private int estado;

    // Constructor con Flyweight
    public DetalleVenta(int idDetalleVenta, int idCabeceraVenta, 
                       Producto productFlyweight, int cantidad, 
                       double subTotal, double descuento, double iva, 
                       double totalPagar, int estado) {
        this.idDetalleVenta = idDetalleVenta;
        this.idCabeceraVenta = idCabeceraVenta;
        this.productFlyweight = productFlyweight;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.descuento = descuento;
        this.iva = iva;
        this.totalPagar = totalPagar;
        this.estado = estado;
    }

    // Getters
    public int getIdDetalleVenta() { return idDetalleVenta; }
    public int getIdCabeceraVenta() { return idCabeceraVenta; }
    public int getCantidad() { return cantidad; }
    public double getSubTotal() { return subTotal; }
    public double getDescuento() { return descuento; }
    public double getIva() { return iva; }
    public double getTotalPagar() { return totalPagar; }
    public int getEstado() { return estado; }
    public Producto getProductFlyweight() { return productFlyweight; }
    
    // Métodos de compatibilidad
    public int getIdProducto() { return productFlyweight.getIdProducto(); }
    public String getNombre() { return productFlyweight.getNombre(); }
    public double getPrecioUnitario() { return productFlyweight.getPrecio(); }

    // Setters
    public void setIdDetalleVenta(int idDetalleVenta) { this.idDetalleVenta = idDetalleVenta; }
    public void setIdCabeceraVenta(int idCabeceraVenta) { this.idCabeceraVenta = idCabeceraVenta; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setSubTotal(double subTotal) { this.subTotal = subTotal; }
    public void setDescuento(double descuento) { this.descuento = descuento; }
    public void setIva(double iva) { this.iva = iva; }
    public void setTotalPagar(double totalPagar) { this.totalPagar = totalPagar; }
    public void setEstado(int estado) { this.estado = estado; }
}