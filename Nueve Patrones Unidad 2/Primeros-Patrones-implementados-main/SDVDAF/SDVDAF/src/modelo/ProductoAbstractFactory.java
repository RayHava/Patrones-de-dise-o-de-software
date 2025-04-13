/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
public abstract class ProductoAbstractFactory {
    public abstract ProductoAb crearProducto();
    
    public abstract ProductoAb crearProductoCompleto(int idProducto, String nombre, int cantidad, 
                                                  double precio, String descripcion, 
                                                  int porcentajeIva, int idCategoria, int estado);
}
