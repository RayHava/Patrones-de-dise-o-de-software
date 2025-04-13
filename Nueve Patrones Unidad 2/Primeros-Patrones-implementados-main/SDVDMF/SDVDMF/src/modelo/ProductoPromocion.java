/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
public class ProductoPromocion extends ProductoMF {
    private String descripcionPromocion;
    
    public ProductoPromocion() {
        super();
    }
    
    public ProductoPromocion(int idProducto, String nombre, int cantidad, double precio, 
                            String descripcion, int porcentajeIva, int idCategoria, int estado, 
                            String descripcionPromocion) {
        super(idProducto, nombre, cantidad, precio, descripcion, porcentajeIva, idCategoria, estado);
        this.descripcionPromocion = descripcionPromocion;
    }
    
    @Override
    public double calcularPrecioFinal() {
        // Implementación específica para productos en promoción
        // Por ejemplo, aplicar un descuento fijo o alguna lógica especial
        return precio + (precio * porcentajeIva / 100.0);
    }
    
    public String getDescripcionPromocion() {
        return descripcionPromocion;
    }
    
    public void setDescripcionPromocion(String descripcionPromocion) {
        this.descripcionPromocion = descripcionPromocion;
    }
}
