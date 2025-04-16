package modelo;

public class Producto implements Cloneable {
    // Atributos
    private int idProducto;
    private String nombre;
    private int cantidad;
    private double precio;
    private String descripcion;
    private int porcentajeIva;
    private int idCategoria;
    private int estado;
     private String descripcionCategoria;
    
    // Constructor privado para el Builder
    private Producto(Builder builder) {
        this.idProducto = builder.idProducto;
        this.nombre = builder.nombre;
        this.cantidad = builder.cantidad;
        this.precio = builder.precio;
        this.descripcion = builder.descripcion;
        this.porcentajeIva = builder.porcentajeIva;
        this.idCategoria = builder.idCategoria;
        this.estado = builder.estado;
    }
    
    // Constructor público vacío
    public Producto() {
        this.idProducto = 0;
        this.nombre = "";
        this.cantidad = 0;
        this.precio = 0.0;
        this.descripcion = "";
        this.porcentajeIva = 0;
        this.idCategoria = 0;
        this.estado = 0;
    }
    
    // Implementación de Prototype
    @Override
    public Producto clone() {
        try {
            return (Producto) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // No debería ocurrir
        }
    }
    
    // Builder para Producto
    public static class Builder {
        private int idProducto;
        private String nombre;
        private int cantidad;
        private double precio;
        private String descripcion;
        private int porcentajeIva;
        private int idCategoria;
        private int estado;
        private String descripcionCategoria;
        
        public Builder() {}
        
        public Builder idProducto(int idProducto) {
            this.idProducto = idProducto;
            return this;
        }
        
        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }
        
        public Builder descripcionCategoria(String descripcionCategoria) {
            this.descripcionCategoria = descripcionCategoria;
            return this;
        }
        
        public Producto build() {
            Producto producto = new Producto(this);
            producto.setDescripcionCategoria(this.descripcionCategoria);
            return producto;
        }
        
        public Builder cantidad(int cantidad) {
            this.cantidad = cantidad;
            return this;
        }
        
        public Builder precio(double precio) {
            this.precio = precio;
            return this;
        }
        
        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }
        
        public Builder porcentajeIva(int porcentajeIva) {
            this.porcentajeIva = porcentajeIva;
            return this;
        }
        
        public Builder idCategoria(int idCategoria) {
            this.idCategoria = idCategoria;
            return this;
        }
        
        public Builder estado(int estado) {
            this.estado = estado;
            return this;
        }
        
        
    }
    
     public String getDescripcionCategoria() {
        return descripcionCategoria;
    }
    
    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }
    // Getters y Setters (se mantienen igual)
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

    public int getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(int porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
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