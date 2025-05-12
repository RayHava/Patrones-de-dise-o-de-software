/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author hecto
 */


import java.util.Stack;

public class Invoker {
    private Stack<ICommand> historial = new Stack<>();

    public void ejecutarComando(ICommand comando) {
        comando.execute();
        historial.push(comando);
    }

    public void undo() {
        if (!historial.isEmpty()) {
            ICommand comando = historial.pop();
            comando.undo();
        }
    }
}