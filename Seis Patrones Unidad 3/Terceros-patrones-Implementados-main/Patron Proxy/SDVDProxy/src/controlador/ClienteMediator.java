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
import vista.InterGestionarCliente;
import java.util.List;

public interface ClienteMediator {
    // Métodos básicos
    void registrarCliente(Cliente cliente);
    void notificar(String mensaje, InterCliente origen);
    void setInterfazCliente(InterCliente interfaz);
    
    // Nuevos métodos para gestión completa
    void actualizarCliente(Cliente cliente, int idCliente);
    void eliminarCliente(int idCliente);
    List<Cliente> buscarClientes(String criterio);
    void cargarTablaClientes();
    void enviarDatosClienteSeleccionado(int idCliente);
    void setInterfazGestion(InterGestionarCliente interfaz);
}
