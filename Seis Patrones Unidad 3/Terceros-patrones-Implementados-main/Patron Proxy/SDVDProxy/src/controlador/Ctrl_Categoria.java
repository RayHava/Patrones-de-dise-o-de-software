package controlador;

import modelo.Categoria;
import modelo.ICategoriaDAO;
import modelo.CategoriaDAOProxy;

public class Ctrl_Categoria {
    private ICategoriaDAO categoriaDAO;
    
    public Ctrl_Categoria() {
        this.categoriaDAO = new CategoriaDAOProxy();
    }
    
    public boolean guardar(Categoria objeto) {
        return categoriaDAO.guardar(objeto);
    }
    
    public boolean existeCategoria(String categoria) {
        return categoriaDAO.existeCategoria(categoria);
    }
    
    public boolean actualizar(Categoria objeto, int idCategoria) {
        return categoriaDAO.actualizar(objeto, idCategoria);
    }
    
    public boolean eliminar(int idCategoria) {
        return categoriaDAO.eliminar(idCategoria);
    }
}
