/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author hecto
 */
import modelo.Cliente;
import vista.InterCliente;
import vista.InterGestionarCliente;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;

public class ClienteMediatorImpl implements ClienteMediator {
    private InterCliente interfazCliente;
    private InterGestionarCliente interfazGestion;
    private final Ctrl_Cliente controladorCliente;
    
    public ClienteMediatorImpl() {
        this.controladorCliente = new Ctrl_Cliente();
    }
    
    @Override
    public void registrarCliente(Cliente cliente) {
        if (!controladorCliente.existeCliente(cliente.getCedula())) {
            if (controladorCliente.guardar(cliente)) {
                notificar("Registro Guardado", null);
                if (interfazCliente != null) {
                    interfazCliente.limpiarCampos();
                }
            } else {
                notificar("Error al Guardar", null);
            }
        } else {
            notificar("El cliente ya está registrado", null);
        }
    }
    
    @Override
    public void actualizarCliente(Cliente cliente, int idCliente) {
        if (controladorCliente.actualizar(cliente, idCliente)) {
            notificar("Cliente actualizado exitosamente", null);
            cargarTablaClientes();
            if (interfazGestion != null) {
                interfazGestion.Limpiar();
            }
        } else {
            notificar("Error al actualizar el cliente", null);
        }
    }
    
    @Override
    public void eliminarCliente(int idCliente) {
        if (idCliente == 0) {
            notificar("Seleccione un cliente", null);
            return;
        }
        
        if (controladorCliente.eliminar(idCliente)) {
            notificar("Cliente eliminado exitosamente", null);
            cargarTablaClientes();
            if (interfazGestion != null) {
                interfazGestion.Limpiar();
            }
        } else {
            notificar("Error al eliminar el cliente", null);
        }
    }
    
    @Override
    public List<Cliente> buscarClientes(String criterio) {
        // Implementación de búsqueda (puedes adaptar según tu BD)
        return new ArrayList<>();
    }
    
    @Override
    public void cargarTablaClientes() {
        if (interfazGestion != null) {
            interfazGestion.CargarTablaClientes();
        }
    }
    
    @Override
    public void enviarDatosClienteSeleccionado(int idCliente) {
        if (interfazGestion != null) {
            interfazGestion.EnviarDatosClienteSeleccionado(idCliente);
        }
    }
    
    @Override
    public void notificar(String mensaje, InterCliente origen) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    @Override
    public void setInterfazCliente(InterCliente interfaz) {
        this.interfazCliente = interfaz;
    }
    
    @Override
    public void setInterfazGestion(InterGestionarCliente interfaz) {
        this.interfazGestion = interfaz;
    }
}