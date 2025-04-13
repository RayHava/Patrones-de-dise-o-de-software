/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
public class ProductFlyweight {
    private final int idProducto;
    private final String nombre;
    private final double precio;
    private final int porcentajeIva;
    private final String descripcion;
    private final String categoria;

    public ProductFlyweight(int idProducto, String nombre, double precio, 
                          int porcentajeIva, String descripcion, String categoria) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.porcentajeIva = porcentajeIva;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    // Getters
    public int getIdProducto() { return idProducto; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getPorcentajeIva() { return porcentajeIva; }
    public String getDescripcion() { return descripcion; }
    public String getCategoria() { return categoria; }
}