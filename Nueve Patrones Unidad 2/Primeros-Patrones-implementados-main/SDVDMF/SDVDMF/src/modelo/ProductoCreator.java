/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
public abstract class ProductoCreator {
    // Factory Method
    public abstract ProductoMF crearProducto();
    
    // Operación que utiliza el Factory Method
    public ProductoMF prepararProducto() {
        // Llamar al Factory Method para crear un Producto
        ProductoMF producto = crearProducto();
        
        // Aquí se pueden realizar operaciones adicionales con el producto
        System.out.println("Preparando producto: " + producto.getClass().getSimpleName());
        
        return producto;
    }
}