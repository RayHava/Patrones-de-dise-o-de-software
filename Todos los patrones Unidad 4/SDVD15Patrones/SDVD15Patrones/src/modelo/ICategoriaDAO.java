/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
public interface ICategoriaDAO {
    boolean guardar(Categoria categoria);
    boolean existeCategoria(String descripcion);
    boolean actualizar(Categoria categoria, int idCategoria);
    boolean eliminar(int idCategoria);
}
