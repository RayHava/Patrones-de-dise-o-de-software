/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
public interface ProductoFactory {
    Producto crearProductoBasico();
    Producto crearProductoPremium();
    Producto crearProductoPersonalizado(int idProducto, String nombre, int cantidad, 
                                      double precio, String descripcion, 
                                      int porcentajeIva, int idCategoria, int estado);
}
