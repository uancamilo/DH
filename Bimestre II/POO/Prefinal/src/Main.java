public class Main {
    public static void main(String[] args) {
        OfertaAcademicaFactory ofertaAcademicaFactory = OfertaAcademicaFactory.getInstance();

        Instituto instituto = new Instituto();

        instituto.agregarOferta(ofertaAcademicaFactory.crearOfertaAcademica("Codigo_front"));
        instituto.agregarOferta(ofertaAcademicaFactory.crearOfertaAcademica("Codigo_back"));

        instituto.informe();
    }
}