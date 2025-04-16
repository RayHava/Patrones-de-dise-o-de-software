package controlador;

import modelo.Categoria;
import modelo.ICategoriaDAO;
import modelo.CategoriaDAOProxy;
import modelo.CategoriaFlyweightFactory;

public class Ctrl_Categoria {
    private ICategoriaDAO categoriaDAO;
    private CategoriaFlyweightFactory categoriaFactory;
    
    public Ctrl_Categoria() {
        this.categoriaDAO = new CategoriaDAOProxy();
        this.categoriaFactory = CategoriaFlyweightFactory.getInstancia();
    }
    
    public boolean guardar(String descripcion) {
        Categoria categoria = categoriaFactory.getCategoria(descripcion);
        return categoriaDAO.guardar(categoria);
    }
    
    public boolean existeCategoria(String categoria) {
        return categoriaDAO.existeCategoria(categoria);
    }
    
    public boolean actualizar(String descripcion, int idCategoria) {
        Categoria categoria = categoriaFactory.getCategoria(descripcion);
        return categoriaDAO.actualizar(categoria, idCategoria);
    }
    
    public boolean eliminar(int idCategoria) {
        return categoriaDAO.eliminar(idCategoria);
    }
}