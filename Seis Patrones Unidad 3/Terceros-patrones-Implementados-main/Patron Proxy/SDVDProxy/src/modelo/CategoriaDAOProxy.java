/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CategoriaDAOProxy implements ICategoriaDAO {
    private CategoriaDAOReal categoriaDAOReal;
    private Logger logger = Logger.getLogger(CategoriaDAOProxy.class.getName());
    
    public CategoriaDAOProxy() {
        this.categoriaDAOReal = new CategoriaDAOReal();
    }
    
    @Override
    public boolean guardar(Categoria categoria) {
        if(validarDescripcion(categoria.getDescripcion())) {
            logger.log(Level.INFO, "Intentando guardar categoría: {0}", categoria.getDescripcion());
            boolean resultado = categoriaDAOReal.guardar(categoria);
            if(resultado) {
                logger.log(Level.INFO, "Categoría guardada exitosamente");
            }
            return resultado;
        }
        return false;
    }
    
    @Override
    public boolean existeCategoria(String descripcion) {
        logger.log(Level.INFO, "Verificando existencia de categoría: {0}", descripcion);
        return categoriaDAOReal.existeCategoria(descripcion);
    }
    
    @Override
    public boolean actualizar(Categoria categoria, int idCategoria) {
        if(validarDescripcion(categoria.getDescripcion())) {
            logger.log(Level.INFO, "Actualizando categoría ID: {0}", idCategoria);
            return categoriaDAOReal.actualizar(categoria, idCategoria);
        }
        return false;
    }
    
    @Override
    public boolean eliminar(int idCategoria) {
        if(!categoriaTieneProductos(idCategoria)) {
            logger.log(Level.INFO, "Eliminando categoría ID: {0}", idCategoria);
            return categoriaDAOReal.eliminar(idCategoria);
        } else {
            JOptionPane.showMessageDialog(null, 
                "No se puede eliminar: La categoría tiene productos asociados");
            return false;
        }
    }
    
    private boolean validarDescripcion(String descripcion) {
        return descripcion != null && !descripcion.trim().isEmpty();
    }
    
    private boolean categoriaTieneProductos(int idCategoria) {
        // Implementar lógica para verificar si hay productos asociados
        return false; // Cambiar por implementación real
    }
}