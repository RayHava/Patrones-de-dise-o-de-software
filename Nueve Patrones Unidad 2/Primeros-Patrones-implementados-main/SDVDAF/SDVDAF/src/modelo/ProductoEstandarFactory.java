/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
public class ProductoEstandarFactory extends ProductoAbstractFactory {
    
    @Override
    public ProductoAb crearProducto() {
        return new ProductoEstandar();
    }
    
    @Override
    public ProductoAb crearProductoCompleto(int idProducto, String nombre, int cantidad, 
                                         double precio, String descripcion, 
                                         int porcentajeIva, int idCategoria, int estado) {
        return new ProductoEstandar(idProducto, nombre, cantidad, precio, 
                                   descripcion, porcentajeIva, idCategoria, estado);
    }
}
