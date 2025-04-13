/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
public class ProductoEstandar extends ProductoP {
    
    public ProductoEstandar() {
        super();
    }
    
    public ProductoEstandar(int idProducto, String nombre, int cantidad, double precio, 
                           String descripcion, int porcentajeIva, int idCategoria, int estado) {
        super(idProducto, nombre, cantidad, precio, descripcion, porcentajeIva, idCategoria, estado);
    }
    
    @Override
    public double calcularPrecioFinal() {
        return precio + (precio * porcentajeIva / 100.0);
    }
    
    @Override
    public ProductoPrototype clonar() {
        // Implementación del método clonar para ProductoEstandar (clonación profunda)
        return new ProductoEstandar(
            this.idProducto,
            this.nombre,
            this.cantidad,
            this.precio,
            this.descripcion,
            this.porcentajeIva,
            this.idCategoria,
            this.estado
        );
    }
}
