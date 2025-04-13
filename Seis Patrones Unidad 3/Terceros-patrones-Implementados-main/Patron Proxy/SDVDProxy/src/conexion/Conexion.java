package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    // 1. Instancia única como variable estática
    private static Connection instancia;
    
    // 2. Constructor privado para evitar instanciación
    private Conexion() {}
    
    // 3. Método estático para obtener la instancia (versión thread-safe)
    public static synchronized Connection getConexion() {
        if (instancia == null) {
            try {
                // 4. Crear la conexión solo si no existe
                instancia = DriverManager.getConnection(
                    "jdbc:mysql://localhost/bd_sistema_ventas", 
                    "root", 
                    "1234");
                System.out.println("Conexión establecida");
            } catch (SQLException e) {
                System.err.println("Error al conectar: " + e.getMessage());
                throw new RuntimeException("Error al establecer conexión", e);
            }
        }
        return instancia;
    }
    
    // 5. Método para cerrar la conexión
    public static void cerrarConexion() {
        if (instancia != null) {
            try {
                instancia.close();
                instancia = null;
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.err.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
}
