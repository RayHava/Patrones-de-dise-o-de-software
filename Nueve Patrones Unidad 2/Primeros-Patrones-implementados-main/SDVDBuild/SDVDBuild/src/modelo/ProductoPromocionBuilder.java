/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
public class ProductoPromocionBuilder implements ProductoBuilder {
    private int idProducto;
    private String nombre;
    private int cantidad;
    private double precio;
    private String descripcion;
    private int porcentajeIva;
    private int idCategoria;
    private int estado;
    private String descripcionPromocion;
    
    @Override
    public ProductoBuilder setIdProducto(int idProducto) {
        this.idProducto = idProducto;
        return this;
    }
    
    @Override
    public ProductoBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    
    @Override
    public ProductoBuilder setCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }
    
    @Override
    public ProductoBuilder setPrecio(double precio) {
        this.precio = precio;
        return this;
    }
    
    @Override
    public ProductoBuilder setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }
    
    @Override
    public ProductoBuilder setPorcentajeIva(int porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
        return this;
    }
    
    @Override
    public ProductoBuilder setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
        return this;
    }
    
    @Override
    public ProductoBuilder setEstado(int estado) {
        this.estado = estado;
        return this;
    }
    
    public ProductoPromocionBuilder setDescripcionPromocion(String descripcionPromocion) {
        this.descripcionPromocion = descripcionPromocion;
        return this;
    }
    
    @Override
    public Producto build() {
        return new ProductoPromocion(idProducto, nombre, cantidad, precio, 
                                   descripcion, porcentajeIva, idCategoria, estado, descripcionPromocion);
    }
}