/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import vista.InterActualizarStock;

/**
 *
 * @author hecto
 */
public interface StockHandler {
    void setNext(StockHandler next);
    boolean handle(InterActualizarStock frame);
}