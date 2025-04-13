/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
public class ProductoDirector {
    
    // Construye un producto estándar básico
    public Producto construirProductoEstandarBasico(ProductoBuilder builder, int idProducto, String nombre) {
        return builder
            .setIdProducto(idProducto)
            .setNombre(nombre)
            .setCantidad(0)
            .setPrecio(0.0)
            .setDescripcion("")
            .setPorcentajeIva(19)  // IVA por defecto
            .setIdCategoria(1)     // Categoría por defecto
            .setEstado(1)          // Estado activo por defecto
            .build();
    }
    
    // Construye un producto con descuento básico
    public Producto construirProductoDescuentoBasico(ProductoConDescuentoBuilder builder, 
                                                   int idProducto, String nombre, double porcentajeDescuento) {
        return builder
            .setIdProducto(idProducto)
            .setNombre(nombre)
            .setCantidad(0)
            .setPrecio(0.0)
            .setDescripcion("")
            .setPorcentajeIva(19)  // IVA por defecto
            .setIdCategoria(1)     // Categoría por defecto
            .setEstado(1)          // Estado activo por defecto
            //.setPorcentajeDescuento(porcentajeDescuento)
            .build();
    }
    
    // Construye un producto en promoción básico
    public Producto construirProductoPromocionBasico(ProductoPromocionBuilder builder, 
                                                  int idProducto, String nombre, String descripcionPromocion) {
        return builder
            .setIdProducto(idProducto)
            .setNombre(nombre)
            .setCantidad(0)
            .setPrecio(0.0)
            .setDescripcion("")
            .setPorcentajeIva(19)  // IVA por defecto
            .setIdCategoria(1)     // Categoría por defecto
            .setEstado(1)          // Estado activo por defecto
           // .setDescripcionPromocion(descripcionPromocion)
            .build();
    }
    
    // Construye un producto completo con todos los parámetros
    public Producto construirProductoCompleto(ProductoBuilder builder, 
                                           int idProducto, String nombre, int cantidad, double precio, 
                                           String descripcion, int porcentajeIva, int idCategoria, int estado) {
        return builder
            .setIdProducto(idProducto)
            .setNombre(nombre)
            .setCantidad(cantidad)
            .setPrecio(precio)
            .setDescripcion(descripcion)
            .setPorcentajeIva(porcentajeIva)
            .setIdCategoria(idCategoria)
            .setEstado(estado)
            .build();
    }
}
