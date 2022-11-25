import java.util.ArrayList;
import java.util.List;

public class Combo implements Comprable{
    private List<Comprable> comprableList;
    private Double descuento;

    public Combo(Double descuento) {
        comprableList = new ArrayList<>();
        this.descuento = descuento;
    }

    public void agregarComprable(Comprable comprable){
        comprableList.add(comprable);
    }

    @Override
    public Double calcularPrecio() {
        Double precioTotal = 0.0;
        for (Comprable comprable: comprableList
             ) { precioTotal += comprable.calcularPrecio();

        }
        Double precioDescuento = (precioTotal - precioTotal*descuento);
        return precioDescuento;
    }
}
