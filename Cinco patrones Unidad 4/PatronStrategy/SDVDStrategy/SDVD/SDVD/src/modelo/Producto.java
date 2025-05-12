package modelo;

import controlador.IvaCero;
import controlador.IvaStrategy;


public class Producto {
    
    //Atributos
    private int idProducto;
    private String nombre;
    private int cantidad;
    private double precio;
    private String descripcion;
    private IvaStrategy ivaStrategy;
    private int idCategoria;
    private int estado;
    
    //Contructor
    public Producto(){
        this.idProducto = 0;
        this.nombre = "";
        this.cantidad = 0;
        this.precio = 0.0;
        this.descripcion = "";
        this.ivaStrategy = new controlador.IvaCero(); // Valor por defecto
        this.idCategoria = 0;
        this.estado = 0;
    }
    //Contructor sobrecargado
    public Producto(int idProducto, String nombre, int cantidad, double precio, String descripcion, int idCategoria, int estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.ivaStrategy = new controlador.IvaCero();
        this.idCategoria = idCategoria;
        this.estado = estado;
    }
    
    //Set and get

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

 public void setIvaStrategy(IvaStrategy ivaStrategy) {
        this.ivaStrategy = ivaStrategy;
    }
    
    public IvaStrategy getIvaStrategy() {  // Añadimos este método getter
        return this.ivaStrategy;
    }
    
    public double calcularIva() {
        return ivaStrategy.calcularIva(this.precio);
    }
    
    public double getPrecioConIva() {
        return this.precio + calcularIva();
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
    
}
