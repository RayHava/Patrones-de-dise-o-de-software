/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hecto
 */
public class RegistroProductos {
    private static final Map<String, ProductoPrototype> prototipos = new HashMap<>();
    
    // Inicializar el registro con prototipos por defecto
    static {
        // Prototipo de producto estándar
        prototipos.put("estandar", new ProductoEstandar(
            0, "Producto Estándar", 0, 0.0,
            "Prototipo de producto estándar", 19, 1, 1
        ));
        
        // Prototipo de producto con descuento
        prototipos.put("descuento", new ProductoConDescuento(
            0, "Producto con Descuento", 0, 0.0,
            "Prototipo de producto con descuento", 19, 1, 1, 0.0
        ));
        
        // Prototipo de producto en promoción
        prototipos.put("promocion", new ProductoPromocion(
            0, "Producto en Promoción", 0, 0.0,
            "Prototipo de producto en promoción", 19, 1, 1, "Prototipo promoción"
        ));
    }
    
    // Obtener un clon del prototipo seleccionado
    public static ProductoPrototype getPrototipo(String tipoProducto) {
        ProductoPrototype prototipo = prototipos.get(tipoProducto);
        if (prototipo == null) {
            throw new IllegalArgumentException("Tipo de producto no válido: " + tipoProducto);
        }
        return prototipo.clonar();
    }
    
    // Registrar un nuevo prototipo o reemplazar uno existente
    public static void registrarPrototipo(String tipoProducto, ProductoPrototype prototipo) {
        prototipos.put(tipoProducto, prototipo);
    }
}
