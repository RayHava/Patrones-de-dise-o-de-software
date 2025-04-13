/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
public interface ProductoBuilder {
    ProductoBuilder setIdProducto(int idProducto);
    ProductoBuilder setNombre(String nombre);
    ProductoBuilder setCantidad(int cantidad);
    ProductoBuilder setPrecio(double precio);
    ProductoBuilder setDescripcion(String descripcion);
    ProductoBuilder setPorcentajeIva(int porcentajeIva);
    ProductoBuilder setIdCategoria(int idCategoria);
    ProductoBuilder setEstado(int estado);
    Producto build();
}
