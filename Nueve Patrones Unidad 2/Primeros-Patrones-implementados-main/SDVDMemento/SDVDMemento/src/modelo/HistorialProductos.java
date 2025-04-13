/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.List;
import java.util.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author hecto
 */
public class HistorialProductos {
    private final Map<Integer, Stack<ProductoMemento>> historialPorProducto = new HashMap<>();
    
    // Guarda el estado actual de un producto
    public void guardarEstado(Producto producto) {
        int idProducto = producto.getIdProducto();
        
        // Verificar si existe historial para este producto
        if (!historialPorProducto.containsKey(idProducto)) {
            historialPorProducto.put(idProducto, new Stack<>());
        }
        
        // Añadir un nuevo memento al historial
        ProductoMemento memento = new ProductoMemento(producto);
        historialPorProducto.get(idProducto).push(memento);
        
        System.out.println("Estado guardado para el producto ID: " + idProducto);
    }
    
    // Restaura el estado previo de un producto
    public boolean restaurarEstado(Producto producto) {
        int idProducto = producto.getIdProducto();
        
        // Verificar si existe historial para este producto
        if (!historialPorProducto.containsKey(idProducto) || historialPorProducto.get(idProducto).isEmpty()) {
            System.out.println("No hay historial para restaurar para el producto ID: " + idProducto);
            return false;
        }
        
        // Quitar el estado actual (el más reciente)
        historialPorProducto.get(idProducto).pop();
        
        // Verificar si quedan estados para restaurar
        if (historialPorProducto.get(idProducto).isEmpty()) {
            System.out.println("No hay estados previos para restaurar para el producto ID: " + idProducto);
            return false;
        }
        
        // Obtener el estado previo
        ProductoMemento memento = historialPorProducto.get(idProducto).peek();
        //restaurarDesdeMemento(producto, memento);
        
        System.out.println("Estado restaurado para el producto ID: " + idProducto);
        return true;
    }
    
    // Restaura a un estado específico por índice (0 es el más antiguo)
    public boolean restaurarEstadoPorIndice(Producto producto, int indice) {
        int idProducto = producto.getIdProducto();
        
        // Verificar si existe historial para este producto
        if (!historialPorProducto.containsKey(idProducto) || historialPorProducto.get(idProducto).isEmpty()) {
            System.out.println("No hay historial para restaurar para el producto ID: " + idProducto);
            return false;
        }
        return false;
       
}
}