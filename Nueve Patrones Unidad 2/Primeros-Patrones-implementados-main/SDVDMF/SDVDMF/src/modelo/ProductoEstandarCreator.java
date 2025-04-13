/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
public class ProductoEstandarCreator extends ProductoCreator {
    private int idProducto;
    private String nombre;
    private int cantidad;
    private double precio;
    private String descripcion;
    private int porcentajeIva;
    private int idCategoria;
    private int estado;
    
    public ProductoEstandarCreator(int idProducto, String nombre, int cantidad, double precio, 
                                 String descripcion, int porcentajeIva, int idCategoria, int estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.porcentajeIva = porcentajeIva;
        this.idCategoria = idCategoria;
        this.estado = estado;
    }
    
    @Override
    public ProductoMF crearProducto() {
        return new ProductoEstandar(idProducto, nombre, cantidad, precio, 
                                  descripcion, porcentajeIva, idCategoria, estado);
    }
}
