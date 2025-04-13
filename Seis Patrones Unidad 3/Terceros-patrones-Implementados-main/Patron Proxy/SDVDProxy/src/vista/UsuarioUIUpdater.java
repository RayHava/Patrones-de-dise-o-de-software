/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author hecto
 */
import modelo.Usuario;
import modelo.UsuarioObserver;

public class UsuarioUIUpdater implements UsuarioObserver {
    private InterGestionarUsuario gestionarUsuario;
    
    public UsuarioUIUpdater(InterGestionarUsuario gestionarUsuario) {
        this.gestionarUsuario = gestionarUsuario;
    }
    
    @Override
    public void update(String accion, Usuario usuario) {
        if (accion.equals("CREACION") || accion.equals("ACTUALIZACION") || accion.equals("ELIMINACION")) {
            gestionarUsuario.CargarTablaUsuarios(); // Refrescar tabla
        }
    }
}