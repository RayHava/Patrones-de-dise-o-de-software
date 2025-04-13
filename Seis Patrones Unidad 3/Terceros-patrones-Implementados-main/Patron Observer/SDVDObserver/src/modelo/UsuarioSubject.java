/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
public interface UsuarioSubject {
    void registrarObserver(UsuarioObserver observer);
    void removerObserver(UsuarioObserver observer);
    void notificarObservers(String accion, Usuario usuario);
}