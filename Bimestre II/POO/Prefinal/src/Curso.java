public class Curso extends OfertaAcademica {

    private Double horasMensuales;
    private Double cantidadMeses;
    private Double valorHora;

    public Curso(String nombre, String descripcion, Double horasMensuales, Double cantidadMeses, Double valorHora) {
        super(nombre, descripcion);
        this.horasMensuales = horasMensuales;
        this.cantidadMeses = cantidadMeses;
        this.valorHora = valorHora;
    }

    @Override
    public Double calcularPrecio() {
        return horasMensuales * valorHora * cantidadMeses;
    }
}
