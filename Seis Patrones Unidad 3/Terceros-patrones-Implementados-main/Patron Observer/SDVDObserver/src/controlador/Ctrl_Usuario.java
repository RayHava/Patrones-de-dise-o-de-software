package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.UsuarioObserver;
import modelo.UsuarioSubject;


public class Ctrl_Usuario implements UsuarioSubject {
    private List<UsuarioObserver> observers = new ArrayList<>();
    
    // Métodos existentes...
    
    @Override
    public void registrarObserver(UsuarioObserver observer) {
        observers.add(observer);
    }
    
    @Override
    public void removerObserver(UsuarioObserver observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notificarObservers(String accion, Usuario usuario) {
        for (UsuarioObserver observer : observers) {
            observer.update(accion, usuario);
        }
    }
    
    // Modificar métodos existentes para incluir notificaciones
    
    public boolean guardar(Usuario objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.getConexion();
        try {
             PreparedStatement consulta = cn.prepareStatement("insert into tb_usuario values(?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getUsuario());
            consulta.setString(5, objeto.getPassword());
            consulta.setString(6, objeto.getTelefono());
            consulta.setInt(7, objeto.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
                notificarObservers("CREACION", objeto); // Notificar creación
            }
            Conexion.cerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error al guardar usuario: " + e);
        }
        return respuesta;
    }
    
    public boolean actualizar(Usuario objeto, int idUsuario) {
        boolean respuesta = false;
        Connection cn = Conexion.getConexion();
        try {
             PreparedStatement consulta = cn.prepareStatement("update tb_usuario set nombre=?, apellido = ?, usuario = ?, password= ?, telefono = ?, estado = ? where idUsuario ='" + idUsuario + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getUsuario());
            consulta.setString(4, objeto.getPassword());
            consulta.setString(5, objeto.getTelefono());
            consulta.setInt(6, objeto.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
                notificarObservers("ACTUALIZACION", objeto); // Notificar actualización
            }
            Conexion.cerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e);
        }
        return respuesta;
    }
    
    public boolean eliminar(int idUsuario) {
        boolean respuesta = false;
        Connection cn = Conexion.getConexion();
        try {
            Usuario usuarioEliminado = obtenerUsuarioPorId(idUsuario); // Necesitarás implementar este método
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_usuario where idUsuario ='" + idUsuario + "'");
            consulta.executeUpdate();
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
                notificarObservers("ELIMINACION", usuarioEliminado); // Notificar eliminación
            }
            Conexion.cerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e);
        }
        return respuesta;
    }

    /**
     * ********************************************************************
     * metodo para consultar si el producto ya esta registrado en la BBDD
     * ********************************************************************
     */
    public boolean existeUsuario(String usuario) {
        boolean respuesta = false;
        String sql = "select usuario from tb_usuario where usuario = '" + usuario + "';";
        Statement st;
        try {
            Connection cn = Conexion.getConexion();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuario: " + e);
        }
        return respuesta;
    }

    /**
     * **************************************************
     * metodo para Iniciar Sesion
     * **************************************************
     */
    public boolean loginUser(Usuario objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.getConexion();
        String sql = "select  usuario, password from tb_usuario where usuario = '" + objeto.getUsuario() + "' and password = '" + objeto.getPassword() + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al Iniciar Sesion");
            JOptionPane.showMessageDialog(null, "Error al Iniciar Sesion");
        }
        return respuesta;
    }
    
     public Usuario obtenerUsuarioPorId(int idUsuario) {
    Usuario usuario = null;
    Connection cn = Conexion.getConexion();
    String sql = "SELECT idUsuario, nombre, apellido, usuario, password, telefono, estado FROM tb_usuario WHERE idUsuario = ?";

    try {
        PreparedStatement consulta = cn.prepareStatement(sql);
        consulta.setInt(1, idUsuario);
        ResultSet rs = consulta.executeQuery();

        if (rs.next()) {
            usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("idUsuario"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellido(rs.getString("apellido"));
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setPassword(rs.getString("password"));
            usuario.setTelefono(rs.getString("telefono"));
            usuario.setEstado(rs.getInt("estado"));
        }

        Conexion.cerrarConexion();
    } catch (SQLException e) {
        System.out.println("Error al obtener usuario por ID: " + e);
    }

    return usuario;
}
    

}
