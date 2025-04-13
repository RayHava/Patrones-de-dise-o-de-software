/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

/**
 *
 * @author hecto
 */
import modelo.Cliente;
import vista.InterCliente;

public interface ClienteMediator {
    void registrarCliente(Cliente cliente);
    void notificar(String mensaje, InterCliente origen);
    void setInterfazCliente(InterCliente interfaz);
}
