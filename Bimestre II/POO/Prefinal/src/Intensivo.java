import java.util.ArrayList;
import java.util.List;

public class Intensivo extends OfertaAcademica {

    private List<OfertaAcademica> ofertaAcademicaList;
    private Double descuento;

    public Intensivo(String nombre, String descripcion, Double descuento) {
        super(nombre, descripcion);
        this.descuento = descuento;
        ofertaAcademicaList = new ArrayList<>();
    }

    public void agregarOferta(OfertaAcademica ofertaAcademica){
        ofertaAcademicaList.add(ofertaAcademica);
    }

    @Override
    public Double calcularPrecio() {
        Double sumaPrecios = 0.0;
        for (OfertaAcademica ofertaAcademica : ofertaAcademicaList) {
            sumaPrecios += ofertaAcademica.calcularPrecio();
        }
        return sumaPrecios;
    }
}
