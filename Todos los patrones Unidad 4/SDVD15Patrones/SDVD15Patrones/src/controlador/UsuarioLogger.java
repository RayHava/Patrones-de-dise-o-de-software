/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author hecto
 */
import modelo.Usuario;
import modelo.UsuarioObserver;

public class UsuarioLogger implements UsuarioObserver {
    @Override
    public void update(String accion, Usuario usuario) {
        System.out.println("[LOG] Acción: " + accion + 
                         " | Usuario: " + usuario.getUsuario() + 
                         " | Nombre: " + usuario.getNombre());
    }
}