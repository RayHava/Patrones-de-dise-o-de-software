/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author hecto
 */
import modelo.Producto;

public class ActualizarStockCommand implements ICommand {
    private Ctrl_Producto controladorProducto;
    private Producto producto;
    private int idProducto;
    private int cantidadAnterior;

    public ActualizarStockCommand(Ctrl_Producto controladorProducto, Producto producto, int idProducto) {
        this.controladorProducto = controladorProducto;
        this.producto = producto;
        this.idProducto = idProducto;
        this.cantidadAnterior = producto.getCantidad();
    }

    @Override
    public void execute() {
        controladorProducto.actualizarStock(producto, idProducto);
    }

    @Override
    public void undo() {
        producto.setCantidad(cantidadAnterior); // Restaurar stock anterior
        controladorProducto.actualizarStock(producto, idProducto);
    }
}