/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
import java.util.HashMap;
import java.util.Map;


public class ProductFlyweightFactory {
    private static final Map<Integer, ProductFlyweight> flyweights = new HashMap<>();
    
    public static ProductFlyweight getFlyweight(int idProducto, String nombre, double precio, 
                                              int porcentajeIva, String descripcion, String categoria) {
        ProductFlyweight flyweight = flyweights.get(idProducto);
        
        if (flyweight == null) {
            flyweight = new ProductFlyweight(idProducto, nombre, precio, porcentajeIva, descripcion, categoria);
            flyweights.put(idProducto, flyweight);
        }
        
        return flyweight;
    }
    
    public static int getFlyweightCount() {
        return flyweights.size();
    }
}