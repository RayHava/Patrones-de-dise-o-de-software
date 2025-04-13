/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
public class ProductoMemento {
    private final int idProducto;
    private final String nombre;
    private final int cantidad;
    private final double precio;
    private final String descripcion;
    private final int porcentajeIva;
    private final int idCategoria;
    private final int estado;
    private final String tipo;
    private final Object atributoEspecial; // Para almacenar atributos específicos de cada tipo
    
    public ProductoMemento(Producto producto) {
        this.idProducto = producto.getIdProducto();
        this.nombre = producto.getNombre();
        this.cantidad = producto.getCantidad();
        this.precio = producto.getPrecio();
        this.descripcion = producto.getDescripcion();
        this.porcentajeIva = producto.getPorcentajeIva();
        this.idCategoria = producto.getIdCategoria();
        this.estado = producto.getEstado();
        
        // Guardar información específica según el tipo de producto
        if (producto instanceof ProductoEstandar) {
            this.tipo = "estandar";
            this.atributoEspecial = null;
        } else if (producto instanceof ProductoConDescuento) {
            this.tipo = "descuento";
            this.atributoEspecial = ((ProductoConDescuento) producto).getPorcentajeDescuento();
        } else if (producto instanceof ProductoPromocion) {
            this.tipo = "promocion";
            this.atributoEspecial = ((ProductoPromocion) producto).getDescripcionPromocion();
        } else {
            this.tipo = "desconocido";
            this.atributoEspecial = null;
        }
    }
    
    // Solo getters - Memento es inmutable
    public int getIdProducto() {
        return idProducto;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public int getPorcentajeIva() {
        return porcentajeIva;
    }
    
    public int getIdCategoria() {
        return idCategoria;
    }
    
    public int getEstado() {
        return estado;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public Object getAtributoEspecial() {
        return atributoEspecial;
    }
}
