/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
public class ProductoFactory {
    
    public static ProductoAb crearProductoEstandar(int idProducto, String nombre, int cantidad, 
                                               double precio, String descripcion, 
                                               int porcentajeIva, int idCategoria, int estado) {
        ProductoAbstractFactory factory = new ProductoEstandarFactory();
        return factory.crearProductoCompleto(idProducto, nombre, cantidad, precio, 
                                           descripcion, porcentajeIva, idCategoria, estado);
    }
    
}