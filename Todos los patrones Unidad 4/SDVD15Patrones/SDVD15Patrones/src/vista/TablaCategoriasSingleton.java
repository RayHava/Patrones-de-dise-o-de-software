/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.table.DefaultTableModel;

public class TablaCategoriasSingleton {
    private static TablaCategoriasSingleton instancia;
    private DefaultTableModel model;
    
    private TablaCategoriasSingleton() {
        model = new DefaultTableModel();
        model.addColumn("idCategoria");
        model.addColumn("descripcion");
        model.addColumn("estado");
    }
    
    public static synchronized TablaCategoriasSingleton getInstancia() {
        if (instancia == null) {
            instancia = new TablaCategoriasSingleton();
        }
        return instancia;
    }
    
    public DefaultTableModel getModel() {
        return model;
    }
    
    public void limpiarTabla() {
        model.setRowCount(0);
    }
    
    public void agregarFila(Object[] fila) {
        model.addRow(fila);
    }
}