/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
public class ProductoConcretoFactory implements ProductoFactory {
    @Override
    public Producto crearProductoBasico() {
        return new Producto.Builder()
                .nombre("Producto Básico")
                .cantidad(1)
                .precio(10.0)
                .descripcion("Producto estándar")
                .porcentajeIva(12)
                .idCategoria(1)
                .estado(1)
                .build();
    }

    @Override
    public Producto crearProductoPremium() {
        return new Producto.Builder()
                .nombre("Producto Premium")
                .cantidad(1)
                .precio(50.0)
                .descripcion("Producto de alta calidad")
                .porcentajeIva(14)
                .idCategoria(2)
                .estado(1)
                .build();
    }

    @Override
    public Producto crearProductoPersonalizado(int idProducto, String nombre, int cantidad, 
                                             double precio, String descripcion, 
                                             int porcentajeIva, int idCategoria, int estado) {
        return new Producto.Builder()
                .idProducto(idProducto)
                .nombre(nombre)
                .cantidad(cantidad)
                .precio(precio)
                .descripcion(descripcion)
                .porcentajeIva(porcentajeIva)
                .idCategoria(idCategoria)
                .estado(estado)
                .build();
    }
}