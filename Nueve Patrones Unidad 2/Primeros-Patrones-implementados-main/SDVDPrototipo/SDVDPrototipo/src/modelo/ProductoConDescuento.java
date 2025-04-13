/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
public class ProductoConDescuento extends ProductoP {
    private double porcentajeDescuento;
    
    public ProductoConDescuento() {
        super();
    }
    
    public ProductoConDescuento(int idProducto, String nombre, int cantidad, double precio, 
                               String descripcion, int porcentajeIva, int idCategoria, int estado, 
                               double porcentajeDescuento) {
        super(idProducto, nombre, cantidad, precio, descripcion, porcentajeIva, idCategoria, estado);
        this.porcentajeDescuento = porcentajeDescuento;
    }
    
    @Override
    public double calcularPrecioFinal() {
        double precioConIva = precio + (precio * porcentajeIva / 100.0);
        return precioConIva - (precioConIva * porcentajeDescuento / 100.0);
    }
    
    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }
    
    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
    
    @Override
    public ProductoPrototype clonar() {
        // Implementación del método clonar para ProductoConDescuento (clonación profunda)
        return new ProductoConDescuento(
            this.idProducto,
            this.nombre,
            this.cantidad,
            this.precio,
            this.descripcion,
            this.porcentajeIva,
            this.idCategoria,
            this.estado,
            this.porcentajeDescuento
        );
    }
}
