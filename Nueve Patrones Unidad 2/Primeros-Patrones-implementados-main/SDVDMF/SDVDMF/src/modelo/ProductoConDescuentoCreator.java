/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
public class ProductoConDescuentoCreator extends ProductoCreator {
    private int idProducto;
    private String nombre;
    private int cantidad;
    private double precio;
    private String descripcion;
    private int porcentajeIva;
    private int idCategoria;
    private int estado;
    private double porcentajeDescuento;
    
    public ProductoConDescuentoCreator(int idProducto, String nombre, int cantidad, double precio, 
                                     String descripcion, int porcentajeIva, int idCategoria, int estado, 
                                     double porcentajeDescuento) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.porcentajeIva = porcentajeIva;
        this.idCategoria = idCategoria;
        this.estado = estado;
        this.porcentajeDescuento = porcentajeDescuento;
    }
    
    @Override
    public ProductoMF crearProducto() {
        return new ProductoConDescuento(idProducto, nombre, cantidad, precio, 
                                      descripcion, porcentajeIva, idCategoria, estado, 
                                      porcentajeDescuento);
    }
}
