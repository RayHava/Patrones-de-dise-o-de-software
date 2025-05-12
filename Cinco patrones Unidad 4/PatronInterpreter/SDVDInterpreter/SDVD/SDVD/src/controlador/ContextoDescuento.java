package controlador;

import java.util.ArrayList;
import java.util.List;

public class ContextoDescuento {
    private List<ExpresionDescuento> descuentos = new ArrayList<>();
    
    public void agregarDescuento(ExpresionDescuento descuento) {
        descuentos.add(descuento);
    }
    
    public double aplicarDescuentos(double precio, int cantidad) {
        double descuentoTotal = 0;
        for (ExpresionDescuento descuento : descuentos) {
            descuentoTotal += descuento.calcularDescuento(precio, cantidad);
        }
        return descuentoTotal;
    }
    
    public String getDescripcionDescuentos() {
        StringBuilder sb = new StringBuilder();
        for (ExpresionDescuento descuento : descuentos) {
            sb.append(descuento.getDescripcion()).append("\n");
        }
        return sb.toString();
    }
}