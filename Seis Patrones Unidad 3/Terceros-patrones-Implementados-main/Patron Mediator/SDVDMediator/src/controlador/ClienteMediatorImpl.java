/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author hecto
 */
import controlador.Ctrl_Cliente;
import modelo.Cliente;
import vista.InterCliente;
import javax.swing.JOptionPane;

public class ClienteMediatorImpl implements ClienteMediator {
    private InterCliente interfazCliente;
    private final Ctrl_Cliente controladorCliente;
    
    public ClienteMediatorImpl() {
        this.controladorCliente = new Ctrl_Cliente();
    }
    
    @Override
    public void registrarCliente(Cliente cliente) {
        if (!controladorCliente.existeCliente(cliente.getCedula())) {
            if (controladorCliente.guardar(cliente)) {
                notificar("Registro Guardado", null);
                interfazCliente.limpiarCampos();
            } else {
                notificar("Error al Guardar", null);
            }
        } else {
            notificar("El cliente ya está registrado", null);
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
}