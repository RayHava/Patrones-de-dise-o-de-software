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

public class CategoriaFlyweightFactory {
    private static CategoriaFlyweightFactory instancia;
    private Map<String, Categoria> categoriasCache;
    
    private CategoriaFlyweightFactory() {
        categoriasCache = new HashMap<>();
    }
    
    public static synchronized CategoriaFlyweightFactory getInstancia() {
        if (instancia == null) {
            instancia = new CategoriaFlyweightFactory();
        }
        return instancia;
    }
    
    public Categoria getCategoria(String descripcion) {
        // Verificamos si ya existe una categoría con esta descripción
        if (categoriasCache.containsKey(descripcion)) {
            return categoriasCache.get(descripcion);
        } else {
            // Si no existe, creamos una nueva y la añadimos al cache
            Categoria nuevaCategoria = new Categoria(0, descripcion, 1);
            categoriasCache.put(descripcion, nuevaCategoria);
            return nuevaCategoria;
        }
    }
    
    public void clearCache() {
        categoriasCache.clear();
    }
}